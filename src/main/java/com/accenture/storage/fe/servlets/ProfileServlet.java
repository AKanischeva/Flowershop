package com.accenture.storage.fe.servlets;

import com.accenture.storage.be.business.item.ItemBusinessService;
import com.accenture.storage.be.business.user.UserBusinessService;
import com.accenture.storage.be.entity.order.Item;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Autowired
    UserBusinessService ubs;
    @Autowired
    ItemBusinessService ibs;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("utf-8");


        try {
            HttpSession session = req.getSession(false);
            String username = session.getAttribute("un").toString();
            User u = ubs.getInfo(username);
            req.setAttribute("un", u.getFullName());
            String favs = u.getFavs();
            if (!StringUtils.isEmpty(favs)) {
                String[] parts = favs.split(",");
                req.setAttribute("fav", parts.length);
                session.setAttribute("fav", parts.length);
            } else {
                req.setAttribute("fav", 0);
                session.setAttribute("fav", 0);
            }
            List<Item> flowers = ibs.itemList();
            session.setAttribute("f", flowers);
            req.setAttribute("f", flowers);

            req.getRequestDispatcher("/profile.jsp").forward(req, resp);


        } catch (NullPointerException e) {
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}