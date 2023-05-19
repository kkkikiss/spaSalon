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

@WebServlet("/user/spasalons/edit")
public class UpdateController extends HttpServlet {
    private final SpaSalonService spaSalonService = new SpaSalonService(new SpaSalonRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idSalon = Long.parseLong(req.getParameter("idSalon"));
        Long idProfile = (Long) req.getSession().getAttribute("idProfile");
        if (spaSalonService.canModify(idProfile, idSalon)) {
            req.setAttribute("spasalon", spaSalonService.getSpaSalon(idSalon));
            req.getRequestDispatcher("/WEB-INF/user/spasalons/edit.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("/error/404.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long idSalon = Long.parseLong(req.getParameter("idSalon"));

        String name = req.getParameter("name");

        String costStr = req.getParameter("cost");
        BigDecimal cost = costStr.isEmpty() ? null : BigDecimal.valueOf(Long.parseLong(req.getParameter("cost")));

        SpaSalon spaSalon = new SpaSalon(idSalon, name, cost, null);
        spaSalonService.editSpaSalon(spaSalon);
        resp.sendRedirect("/user/spasalons");
    }
}