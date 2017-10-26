package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//get ads visible here
@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        Long ID=(Long) request.getSession().getAttribute("ID");
        System.out.println("Here is your ID for View Profile Servlet: "+ ID);
        request.setAttribute("ads", DaoFactory.getAdsDao().usersAds(ID));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        System.out.println("Here are the attribute names: ");
        System.out.println(request.getAttributeNames());

    }
}
