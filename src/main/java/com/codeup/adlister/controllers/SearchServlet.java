package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/search")

public class SearchServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String searchTerms = request.getParameter("searchTerms");
    request.setAttribute("ads", DaoFactory.getAdsDao().searchAds(searchTerms));
    request.getRequestDispatcher("/WEB-INF/ads/search-results.jsp").forward(request, response);
    System.out.println("Here are your Search Terms: " + searchTerms);
    System.out.println(DaoFactory.getAdsDao().searchAds(searchTerms));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // If null return user to login page
    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect("/login");
      return;

    }
  }
}