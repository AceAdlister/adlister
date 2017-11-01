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

    HashMap<String, String> errors= new HashMap<>();
//      Set up tags
    if(username ==null || username.equalsIgnoreCase("")){
      errors.put("username","The username is empty.");
    }

    if(firstName==null ||firstName.equalsIgnoreCase("")){
      errors.put("firstName","The First Name is empty.");
    }

    if(lastName==null || lastName.equalsIgnoreCase("")){
      errors.put("lastName","The Last Name is empty.");
    }

    if(email ==null || email.equalsIgnoreCase("")){
      errors.put("email","The email is empty.");
    }else if (!email.contains("@")){
      errors.put("email","The email does not have a valid domain.");
    }

    if(streetAddress==null || streetAddress.equalsIgnoreCase("")){
      errors.put("address","The Street Address is empty.");
    }

    if(state==null || state.equalsIgnoreCase("")){
      errors.put("state","The State was not selected");
    }

    if(zipcode==null || zipcode.equalsIgnoreCase("")){
      errors.put("zipcode","The Zipcode is empty.");
    }else if(zipcode.length()!=5 && isNotNumeric(zipcode)){
      errors.put("zipcode","The Zipcode is not 5 numbers.");
    }

    if(phone==null || phone.equalsIgnoreCase("")){
      errors.put("phone","The Phone Number is empty.");
    }else if(phone.length()!=10 && isNotNumeric(phone)){
      errors.put("phone","The Phone Number is not 10 numbers.");
    }

    if(password==null ||password.equalsIgnoreCase("")){
      errors.put("password","The Password is empty");
    }

    if(!password.equals(passwordConfirmation)){
      errors.put("nomatch","The Passwords do not match.");
    }



//      forward tags
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

  private boolean isNotNumeric(String zipcode) {
    try{
      int result=Integer.parseInt(zipcode);
      return false;
    }catch(NumberFormatException e){
      return true;
    }
  }
}