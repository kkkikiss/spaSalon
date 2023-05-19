package main.com.vsu.controllers.user.spasalons;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.com.vsu.service.SpaSalonService;
import main.com.vsu.entity.SpaSalon;
import main.com.vsu.repository.SpaSalonRepository;


import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/user/spasalons/new")
public class InsertController extends HttpServlet {
    private final SpaSalonService spaSalonService = new SpaSalonService(new SpaSalonRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/user/spasalons/new.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long idProfile = (Long) req.getSession().getAttribute("idProfile");

        String name = req.getParameter("nameSalon");

        String CostStr = req.getParameter("cost");
        BigDecimal cost = CostStr.isEmpty() ? null : BigDecimal.valueOf(Long.parseLong(req.getParameter("cost")));

        SpaSalon spaSalon = new SpaSalon(null, name, cost, idProfile);
        spaSalonService.addSpaSalon(spaSalon);
        resp.sendRedirect("/user/spasalons");
    }
}