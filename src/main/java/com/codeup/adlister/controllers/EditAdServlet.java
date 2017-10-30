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

@WebServlet(name = "EditAdServlet",urlPatterns = "/ads/edit_ad")
public class EditAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        User user =(User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        Long adID = Long.parseLong(request.getParameter("ID"));
        Ad ad =DaoFactory.getAdsDao().singleAd(adID);
        if(user.getId()!=ad.getUserId()){
            response.sendRedirect("/profile");
            return;
        }
        request.setAttribute("ad",ad);
        request.getRequestDispatcher("/WEB-INF/ads/edit-ad.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User sessionUser =(User)request.getSession().getAttribute("user");
        if (sessionUser == null) {
            response.sendRedirect("/login");
            return;
        }
        Long adID = Long.parseLong(request.getParameter("ID"));
        Ad ad=DaoFactory.getAdsDao().singleAd(adID);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String zip_code = request.getParameter("zip_code");

        boolean inputHasErrors = title.isEmpty() || description.isEmpty() || address.isEmpty() ||
                (state.isEmpty() || state.length()!=2) || (zip_code.isEmpty() || zip_code.length()!=5);
        if(inputHasErrors){
            response.sendRedirect("/ads/edit_ad");
            return;
        }

        Ad newAd= new Ad(ad.getId(),sessionUser.getId(), title, description, address, state, zip_code);
        DaoFactory.getAdsDao().update(newAd);
        response.sendRedirect("/profile");


    }

}
