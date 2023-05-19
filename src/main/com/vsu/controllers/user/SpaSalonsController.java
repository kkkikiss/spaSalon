package main.com.vsu.controllers.user;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import main.com.vsu.service.SpaSalonService;
import main.com.vsu.repository.SpaSalonRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/spasalons")
public class SpaSalonsController extends HttpServlet {
    private final SpaSalonService spaSalonService = new SpaSalonService(new SpaSalonRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idProfile = (Long) req.getSession().getAttribute("idProfile");
        req.setAttribute("spaSalonList", spaSalonService.getSpaSalonList(idProfile));
        req.getRequestDispatcher("/WEB-INF/user/spasalons.jsp").forward(req, resp);
    }
}