package com.codeup.adlister.dao;

public class Config {
    private static String url ="jdbc:mysql://localhost/adlister_team?serverTimezone=UTC";
    private static String user="team_user";
    private static String password="shame_pw";


    public static void makeUser(String user, String url, String password){
        setUser(user);
        setUrl(url);
        setPassword(password);
    }
    //    Get Set email
    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Config.url = url;
    }

    //    Get Set user
    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Config.user = user;
    }

    //    Get Set password
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Config.password = password;
    }
}
