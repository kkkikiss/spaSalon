package main.com.vsu.controllers.user.spasalons;

import jakarta.servlet.annotation.WebServlet;
import main.com.vsu.service.SpaSalonService;
import main.com.vsu.repository.SpaSalonRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/spasalons/delete")
public class DeleteController extends HttpServlet{
    private final SpaSalonService spaSalonService = new SpaSalonService(new SpaSalonRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long idSalon = Long.parseLong(req.getParameter("idSalon"));
        Long idProfile = (Long) req.getSession().getAttribute("idProfile");
        if (spaSalonService.canModify(idProfile, idSalon)) {
            spaSalonService.deleteSpaSalon(idSalon);
        }
        resp.sendRedirect("/user/spasalons");
    }
}