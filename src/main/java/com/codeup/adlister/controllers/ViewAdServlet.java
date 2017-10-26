package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.codeup.adlister.dao.DaoFactory;

// View individual ad servlet

@WebServlet(name = "controllers.ViewAdsServlet", urlPatterns = "/view-ad")
public class ViewAdServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // If null return user to login page
    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect("/login");
      return;

    }
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Long adID = 0L;

    adID = Long.parseLong(request.getParameter("ID"));

    request.setAttribute("adID", DaoFactory.getAdsDao().usersAds(adID));
    request.getRequestDispatcher("/WEB-INF/view-ad.jsp?").forward(request, response);

    System.out.println(DaoFactory.getAdsDao().usersAds(adID));

  }


}