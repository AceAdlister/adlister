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

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String streetAddress = request.getParameter("streetAddress");
    String phone = request.getParameter("phone");
    String state= request.getParameter("state");
    String zipcode= request.getParameter("zipcode");
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
            || (phone.isEmpty() || phone.length()!=12)
            || password.isEmpty()
            || (!password.equals(passwordConfirmation));

    if (inputHasErrors) {
      response.sendRedirect("/register");
      return;
    }

    // encrypt / hash the password

    int numberOfRounds = 12;
    String hash = BCrypt.hashpw(password, BCrypt.gensalt(numberOfRounds));

    // create and save a new user
    User user = new User(username, email, firstName, lastName, streetAddress, state, zipcode, phone, hash);
    DaoFactory.getUsersDao().insert(user);
    response.sendRedirect("/login");


  }
}
