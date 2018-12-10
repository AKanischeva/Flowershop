package com.accenture.storage.fe.servlets;

import com.accenture.storage.be.business.item.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class FileUploadServlet extends HttpServlet {

    @Autowired
    ItemBusinessService ibs;
    // database connection settings
    private String dbURL = "jdbc:h2:tcp://localhost/~/test";
    private String dbUser = "sa";
    private String dbPass = "";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String student = request.getParameter("Student");
        String theme = request.getParameter("Theme");
        String director = request.getParameter("Director");
        String year = request.getParameter("Year");
        String faculty = request.getParameter("Faculty");
        String description = request.getParameter("Description");

        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("Upload");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getSubmittedFileName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            Class.forName("org.h2.Driver");
            // connects to the database
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // constructs SQL statement
            String sql = "INSERT INTO ITEM (student, theme, director, year1, faculty, description, upload, filename) values (?, ?, ?, ?, ?, ?, ?, ?)";
//            INSERT INTO ITEM (student, theme, director, year1, faculty, description)
//            VALUES
//                    ('Nastya', '1', 'Karlov', '1', '1', 'desc'),
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, student);
            statement.setString(2, theme);
            statement.setString(3, director);
            statement.setString(4, year);
            statement.setString(5, faculty);
            statement.setString(6, description);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(7, inputStream);
                statement.setString(8, filePart.getSubmittedFileName());
            }

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                conn.commit();
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.commit();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);

            // forwards to the message page
            getServletContext().getRequestDispatcher("/admin").forward(request, response);
        }
    }
}
