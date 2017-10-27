package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
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
        if (! rs.next()) {
            return null;
        }
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
