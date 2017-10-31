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

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
//    boolean inputHasErrors = username.isEmpty()
//            || email.isEmpty()
//            || firstName.isEmpty()
//            || lastName.isEmpty()
//            || streetAddress.isEmpty()
//            || state.isEmpty()
//            || (zipcode.isEmpty() || zipcode.length()!=5)
//            || (phone.isEmpty() || phone.length()!=10)
//            || password.isEmpty()
//            || (!password.equals(passwordConfirmation));

//    if (inputHasErrors) {
      HashMap<String, String> errors= new HashMap<>();
//      Set up tags
      if(username ==null || username.equalsIgnoreCase("")){
          errors.put("username","The username is empty");
      }
//    }
//    System.out.println(errors.size());
//    System.out.println(username);
//    return;
      if(errors.size()!=0) {
        request.setAttribute("errors", errors);
      request.getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
      }else {

//         encrypt / hash the password

        int numberOfRounds = 12;
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(numberOfRounds));

//         create and save a new user
        User user = new User(username, email, firstName, lastName, streetAddress, state, zipcode, phone, hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
      }

  }
}
