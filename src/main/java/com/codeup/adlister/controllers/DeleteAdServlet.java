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

@WebServlet(name = "DeleteAdServlet",urlPatterns = "/ads/delete_ad")
public class DeleteAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        User user =(User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        Long adID = Long.parseLong(request.getParameter("ID"));
        Ad ad = DaoFactory.getAdsDao().singleAd(adID);
        if(user.getId()!=ad.getUserId()){
            response.sendRedirect("/profile");
            return;
        }
        request.setAttribute("ad",ad);
        request.getRequestDispatcher("/WEB-INF/ads/delete-ad.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        User sessionUser =(User)request.getSession().getAttribute("user");
        if (sessionUser == null) {
            response.sendRedirect("/login");
            return;
        }
        Long adID = Long.parseLong(request.getParameter("ID"));
        Ad ad=DaoFactory.getAdsDao().singleAd(adID);
        DaoFactory.getAdsDao().delete(adID);
        response.sendRedirect("/profile");

    }
}
