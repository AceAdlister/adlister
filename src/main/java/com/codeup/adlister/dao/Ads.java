package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // get a list of a users ads
    List<Ad> usersAds(Long ID);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get single ad to display
    Ad singleAd(Long ID);
}
