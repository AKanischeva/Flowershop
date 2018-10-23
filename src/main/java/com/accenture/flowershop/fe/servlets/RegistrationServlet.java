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
import java.io.IOException;

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

        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        String cpassword = request.getParameter("inputCPassword");
        String fullName = request.getParameter("inputFullName");
        String phone = request.getParameter("inputPhone");
        String address = request.getParameter("inputAddress");

        if (!password.equals(cpassword) || userBusinessService.register(username, password, fullName, phone, address) == null) {
            response.sendRedirect("registrationFailed.html");
        } else {
            response.sendRedirect("successRegistration.html");
        }
    }
}
