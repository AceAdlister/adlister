package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username){
      System.out.println("From mysqluserdao" + username);
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?") ;
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("street_address"),
                        rs.getString("state"),
                        rs.getString("zip_code"),
                        rs.getString("phone"),
                        rs.getString("password")
                );
            }else{return null;}
        }catch(SQLException e){
            throw new RuntimeException("Error finding user by username", e);
        }

    }


    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, first_name, last_name, street_address, state, zip_code, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4,user.getLastName());
            stmt.setString(5,user.getStreetAddress());
            stmt.setString(6,user.getState());
            stmt.setString(7,user.getZipcode());
            stmt.setString(8,user.getPhone());
            stmt.setString(9, user.getPassword());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    public void update(User user){
        String query= "UPDATE users SET username = ?, email = ?, first_name = ?, last_name = ?, street_address = ?, state = ?, zip_code = ?, phone = ?, password = ? where id=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4,user.getLastName());
            stmt.setString(5,user.getStreetAddress());
            stmt.setString(6,user.getState());
            stmt.setString(7,user.getZipcode());
            stmt.setString(8,user.getPhone());
            stmt.setString(9, user.getPassword());
            stmt.setLong(10,user.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error editing user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
//         rs.next() is does one thing and returns another. It returns a boolean, is there a next row. It also steps the registry by one.
        rs.next();
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("street_address"),
            rs.getString("state"),
            rs.getString("zip_code"),
            rs.getString("phone"),
            rs.getString("password")
        );
    }

}
