package com.accenture.storage.fe.servlets;

import com.accenture.storage.be.business.user.UserBusinessService;
import com.accenture.storage.be.entity.user.User;
import org.apache.commons.lang3.StringUtils;
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

@WebServlet("/favs")
public class FavsServlet extends HttpServlet {

    @Autowired
    UserBusinessService ubs;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String username = session.getAttribute("un").toString();
        User u = ubs.getInfo(username);
        req.setAttribute("un", u.getFullName());
        if (StringUtils.isEmpty(u.getFavs())) {
            u.setFavs(req.getParameter("id"));
        } else {
            u.setFavs(u.getFavs().concat(",").concat(req.getParameter("id")));
        }
        ubs.updateUser(u);
        getServletContext().getRequestDispatcher("/profile").forward(req, resp);
    }
}
