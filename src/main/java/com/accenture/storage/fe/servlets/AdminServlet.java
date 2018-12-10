package com.accenture.storage.fe.servlets;

import com.accenture.storage.be.business.item.ItemBusinessService;
import com.accenture.storage.be.business.user.UserBusinessService;
import com.accenture.storage.be.entity.order.Item;
import com.accenture.storage.be.entity.user.User;
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

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
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
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");


        try {
            HttpSession session = req.getSession(false);
            String username = session.getAttribute("un").toString();
            User u = ubs.getInfo(username);
            req.setAttribute("un", u.getFullName());
            List<Item> items = ibs.itemList();
            session.setAttribute("f", items);
            req.setAttribute("f", items);

            session.setAttribute("test", items.get(0).toString());
            req.setAttribute("test", items.get(0).toString());
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        } catch (NullPointerException e) {
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}