package main.com.vsu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.com.vsu.entity.Profile;
import main.com.vsu.repository.ProfileRepository;
import main.com.vsu.service.ProfileService;

import java.io.IOException;

@WebServlet ("/register")
public class RegisterController extends HttpServlet {
    private final ProfileService profileService = new ProfileService(new ProfileRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        if (!profileService.canRegister(login)) {
            req.setAttribute("error", "User with this login is already exists.");
        } else {
            String password = req.getParameter("password");
            Profile profile = new Profile(null, login, password);
            profileService.register(profile);
            req.setAttribute("msg", "Registration was successful.");
        }
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }
}
