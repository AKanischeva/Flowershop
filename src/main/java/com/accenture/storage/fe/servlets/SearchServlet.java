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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        List<Item> resultList = new ArrayList<>();

        if (req.getParameter("search").equals("1")) {
            //Search logic
        } else {
            resultList = ibs.itemList();
        }

        req.setAttribute("f", resultList);
        HttpSession session = req.getSession(false);
        String username = session.getAttribute("un").toString();
        User u = ubs.getInfo(username);
        req.setAttribute("un", u.getFullName());
        req.setAttribute("fav", session.getAttribute("fav"));
        req.getRequestDispatcher("/profile.jsp").forward(req, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
