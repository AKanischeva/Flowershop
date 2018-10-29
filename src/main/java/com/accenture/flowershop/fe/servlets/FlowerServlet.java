package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.flower.FlowerBusinessService;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Item;
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

@WebServlet(urlPatterns = "/flower")
public class FlowerServlet extends HttpServlet {

    @Autowired
    FlowerBusinessService flowerBusinessService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);


        List<Item> cart = new ArrayList<>();
        List<Flower> flowers = flowerBusinessService.flowersList();
        Integer quantity;

        for (Flower flower : flowers) {

            String amountStr = req.getParameter("amount" + flower.getId());
            try {


                if ((quantity = Integer.parseInt(amountStr)) > 0) {
                    Item item = new Item(flower, quantity);
                    cart.add(item);
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        session.setAttribute("cart", cart);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flower> flowers = flowerBusinessService.flowersList();
        HttpSession session = req.getSession(false);
        session.setAttribute("f", flowers);
        req.getRequestDispatcher("/flower.jsp").forward(req, resp);
    }
}

