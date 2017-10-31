<%@page import="com.codeup.adlister.models.User"%>
<%@page import="com.codeup.adlister.dao.DaoFactory"%>
<%@ page import="org.json.JSONObject" %>
<%@page contentType="application/json;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/json");
    String username = request.getParameter("username");
    User ifExists = DaoFactory.getUsersDao().findByUsername(username);
    Integer existence = 0;

    if (ifExists != null){
      existence = 1;
    }
    else{}

    JSONObject obj = new JSONObject();
    obj.put("exists", existence);

      //TESTING STUFF BELOW
    System.out.println("ifExists contains: " + ifExists);
    System.out.println("username parameter = " + username);
    System.out.println(existence);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(String.valueOf(obj));
%>
