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
import java.util.HashMap;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getSession().getAttribute("user") != null) {
      response.sendRedirect("/profile");
      return;
    }
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    HashMap<String, String> errors = new HashMap<>();

    System.out.println("username exists : " + userNameExists(username));

    if (userNameExists(username)){
      User user = DaoFactory.getUsersDao().findByUsername(username);
      System.out.println("login servlet user grab line 34 " + user.getUsername());

      if (username == null || username.equalsIgnoreCase("")) {
        errors.put("username", "The username is empty");
        username = "";
      }

      boolean passwordsDoMatch = BCrypt.checkpw(password, user.getPassword());
      if (password == null || password.equalsIgnoreCase("")) {
        errors.put("password", "The password is empty, please enter a valid password");
      } else if (!passwordsDoMatch) {
        errors.put("password", "The password is incorrect for the account: [ " + username + " ]");
      }
      if (errors.size() != 0) {
        request.setAttribute("errors", errors);
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
      } else {
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("ID", user.getId());
        response.sendRedirect("/profile");
      }

    }else{
      errors.put("username", "The user was not found...");
      request.setAttribute("errors", errors);
      request.getRequestDispatcher("/WEB-INF/login.jsp")
              .forward(request, response);
    }

  }

  private boolean userNameExists(String username){

    try {
      User user = DaoFactory.getUsersDao().findByUsername(username);
      user.getUsername();
      System.out.println("This is the user grabbed by login: " + user.getUsername());

    } catch (NullPointerException e‏){
      return false;
    }
    return true;
  }

}
