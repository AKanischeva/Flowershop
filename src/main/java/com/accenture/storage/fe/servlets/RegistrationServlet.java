package com.accenture.storage.fe.servlets;

import com.accenture.storage.be.business.user.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        String cpassword = request.getParameter("inputCPassword");
        String fullName = request.getParameter("inputFullName");

        if (!password.equals(cpassword)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Passwords don't match');");
            out.println("location='registration';");
            out.println("</script>");
        } else if (userBusinessService.register(username, password, fullName) == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Username already exists');");
            out.println("location='registration';");
            out.println("</script>");
        } else {
            response.sendRedirect("successRegistration.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);

    }
}
