package com.accenture.flowershop;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class TryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        String res = "";
        String sep = System.getProperty("line.separator");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection cn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); Statement statement = cn.createStatement();
             ResultSet r = statement.executeQuery("SELECT * FROM FLOWERS");) {

            while (r.next()) {
                res += sep + r.getInt("id") + " " + r.getString("name") + " " + r.getString("description") + " " + r.getInt("quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        httpServletResponse.getWriter().print("Flowers:" + res);
    }
}
