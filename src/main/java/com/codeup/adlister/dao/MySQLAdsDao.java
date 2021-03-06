package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> usersAds(Long ID){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id=?");
            stmt.setLong(1,ID);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        }catch(SQLException e){
            throw new RuntimeException("Error retrieving the current users ads.", e);
        }
    }

    public Ad singleAd(Long ID){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id=?" );
            stmt.setLong(1,ID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        }catch(SQLException e){
            /*throw new RuntimeException("Error retrieving the single ad.", e);*/
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long insert(Ad ad) {
//        if (request.getSession == null) {
//            return
//        }
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, address, state, zip_code) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getAddress());
            stmt.setString(5, ad.getState());
            stmt.setString(6, ad.getZip_code());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    public List<Ad> searchAds(String searchTerms){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE title LIKE ?") ;
            stmt.setString(1,"%"+searchTerms+"%");
            /*stmt.setString(2,"'%" + searchTerms + "%'");*/
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        }catch(SQLException e){
            throw new RuntimeException("Error retrieving the search process...", e);
        }

    }

    public void update(Ad ad){
        String query= "UPDATE ads SET title = ?, description = ?, address = ?, state = ?, zip_code = ? where id=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setString(3, ad.getAddress());
            stmt.setString(4, ad.getState());
            stmt.setString(5, ad.getZip_code());
            stmt.setLong(6, ad.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error editing ad", e);
        }
    }

    public void delete(Long id){
        String query= "DELETE FROM ads WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error deleting ad",e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
                rs.getString("address"),
                rs.getString("state"),
                rs.getString("zip_code")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
