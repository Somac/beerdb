package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
This RowMapper is only used by BeerDAO.findBeerBreweryUploaderByID for gathering data to menu's column three
where all the information about chosen beer is shown.
*/
public class BeerUploaderBreweryRowMapper implements RowMapper<Beer>{

        public Beer mapRow(ResultSet rs, int rowNum) throws SQLException{

            Map<String, Integer> beerRatings = new HashMap();
            Beer beer = null;

            do{
                if(beer==null){
                    beer = new Beer();
                    beer.setId(rs.getInt("beerID"));
                    beer.setName(rs.getString("name"));
                    beer.setDescription(rs.getString("description"));
                    beer.setAlcohol(rs.getDouble("alcohol"));
                    beer.setCreated(rs.getDate("created"));

                    //Uploader of the beer
                    User uploader = new User();
                    uploader.setId(rs.getInt("userID"));
                    uploader.setUsername(rs.getString("username"));

                    //Brewery of the beer
                    Brewery brewery = new Brewery();
                    brewery.setId(rs.getInt("breweryID"));
                    brewery.setName(rs.getString("brewery_name"));

                    //Country of the brewery
                    Country country = new Country();
                    country.setCountryID(rs.getInt("countryID"));
                    country.setName(rs.getString("country"));

                    //Package (size) of the beer
                    aPackage aPackage = new aPackage();
                    aPackage.setPackageID(rs.getInt("packageID"));
                    aPackage.setSize(rs.getDouble("size"));

                    //Actual package (price) of the beer
                    BeerPackage beerPackage = new BeerPackage();
                    beerPackage.setBeerPackageID(rs.getInt("beer_packageID"));
                    beerPackage.setPrice(rs.getDouble("price"));

                    //Sub-objects to Beer object
                    brewery.setCountry(country);
                    beerPackage.setaPackage(aPackage);

                    //dynamically calculates per liter price
                    beerPackage.setPricePerLiter();

                    beer.setBeerPackage(beerPackage);
                    beer.setBrewery(brewery);
                    beer.setUser(uploader);
                }
                    //TÄHÄN VIELÄ RATKAISU
                    beerRatings.put(rs.getString("email"), rs.getInt("rating"));

            }while(rs.next());

                  beer.setBeerRatings(beerRatings);

            return beer;
        }
    }