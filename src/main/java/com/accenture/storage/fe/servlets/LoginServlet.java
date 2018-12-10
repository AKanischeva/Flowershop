package com.accenture.storage.fe.servlets;

import com.accenture.storage.be.business.item.ItemBusinessService;
import com.accenture.storage.be.business.user.UserBusinessService;
import com.accenture.storage.be.entity.order.Item;
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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Autowired
    UserBusinessService userBusinessService;
    @Autowired
    ItemBusinessService ibs;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");

        if (userBusinessService.login(username, password) == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Incorrect username or password');");
            out.println("location='index.jsp';");
            out.println("</script>");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("un", username);
            List<Item> flowers = ibs.itemList();
            session.setAttribute("f", flowers);
            request.setAttribute("f", flowers);

            session.setAttribute("test", flowers.get(0).toString());
            request.setAttribute("test", flowers.get(0).toString());
            if (!userBusinessService.getInfo(username).isAdmin()) {
                response.sendRedirect("profile");
            } else {
                response.sendRedirect("admin");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}