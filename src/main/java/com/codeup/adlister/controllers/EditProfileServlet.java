package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="EditProfileServlet", urlPatterns = "/profile_mod")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{
        User sessionUser =(User)request.getSession().getAttribute("user");

        if (sessionUser == null) {
            response.sendRedirect("/login");
            return;
        }
        User user=DaoFactory.getUsersDao().findByUsername(sessionUser.getUsername());
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/profile-mod.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User sessionUser =(User)request.getSession().getAttribute("user");

        if (sessionUser == null) {
            response.sendRedirect("/login");
            return;
        }
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String streetAddress = request.getParameter("street_address");
        String phone = request.getParameter("phone");
        String state= request.getParameter("state");
        String zipcode= request.getParameter("zip_code");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || firstName.isEmpty()
                || lastName.isEmpty()
                || streetAddress.isEmpty()
                || state.isEmpty()
                || (zipcode.isEmpty() || zipcode.length()!=5)
                || (phone.isEmpty() || phone.length()!=10)
                || password.isEmpty()
                || (!password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/profile_mod");
            return;
        }

        // encrypt / hash the password

        int numberOfRounds = 12;
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(numberOfRounds));

        // create and save a new user
        User userNew = new User(sessionUser.getId(),username, email, firstName, lastName, streetAddress, state, zipcode, phone, hash);
        DaoFactory.getUsersDao().update(userNew);
        response.sendRedirect("/profile");


    }
}
