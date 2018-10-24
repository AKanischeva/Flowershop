package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.user.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Autowired
    UserBusinessService userBusinessService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");

//        try {
//            userBusinessService.login(username, password).equals(null);
//            HttpSession session = request.getSession();
//            session.setAttribute("un", username);
//            if (!userBusinessService.getInfo(username).isAdmin()) {
//                response.sendRedirect("profile");
//            } else {
//
//                response.sendRedirect("admin.jsp");
//            }
//
//        } catch (NullPointerException e) {
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Incorrect username or password');");
//            out.println("location='index.jsp';");
//            out.println("</script>");
//        }
        if (userBusinessService.login(username, password) == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Incorrect username or password');");
            out.println("location='index.jsp';");
            out.println("</script>");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("un", username);
            if (!userBusinessService.getInfo(username).isAdmin()) {
                response.sendRedirect("profile");
            } else {

                response.sendRedirect("admin.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}