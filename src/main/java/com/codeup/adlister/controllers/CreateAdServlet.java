package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object sessionUser = request.getSession().getAttribute("user");
        if (sessionUser == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User sessionUser = (User) request.getSession().getAttribute("user");
        if (sessionUser == null) {
            response.sendRedirect("/login");
            return;
        }
        HashMap<String, String> errors = new HashMap<>();
        User user = DaoFactory.getUsersDao().findByUsername(sessionUser.getUsername());
        Long userID = user.getId(); // for now we'll hardcode the user id
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String zip_code = request.getParameter("zip_code");

        if (title.isEmpty()) {
            errors.put("title", "The title is empty");
        }
        if (description.isEmpty()) {
            errors.put("description", "The description is empty");
        }

        if (address.isEmpty()) {
            errors.put("address", "The address is empty");
        }
        if (state.isEmpty()) {
            errors.put("state", "The state is empty");
        }
        if (zip_code.isEmpty()) {
            errors.put("zip_code", "The zip_code is empty");
        }

        if (errors.size() != 0) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        } else {
            Ad ad = new Ad(userID, title, description, address, state, zip_code);
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/ads");

        }
    }
}
