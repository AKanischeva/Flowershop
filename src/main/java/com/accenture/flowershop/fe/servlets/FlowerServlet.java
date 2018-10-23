package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.DAO.FlowerDAOImpl;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/servlet")
public class FlowerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        FlowerDAOImpl dao = context.getBean(FlowerDAOImpl.class);

        String result = "";
        List<Flower> flowers = dao.getFlowers();
        for (Flower flower : flowers) {
            result += "<br/>" + flower.toString();
        }
        result = "Flowers: " + result;

        resp.setContentType("text/html");

        resp.getWriter().print("<html><body><h2>" + result + "</h2></body></html>");
        resp.getWriter().println("<tr><td><a href=\"index.jsp" + "\">Login</a></td></tr>");
    }
}