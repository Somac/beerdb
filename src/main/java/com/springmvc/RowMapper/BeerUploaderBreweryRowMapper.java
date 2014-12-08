package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import com.sun.xml.internal.bind.v2.schemagen.episode.Package;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
This RowMapper is only used by BeerDAO.findBeerBreweryUploaderByID for gathering data to menu's column three
where all the information about chosen beer is shown.
*/
public class BeerUploaderBreweryRowMapper implements RowMapper<Beer>{

        public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {

//          List<BeerRawMaterial> beerRawMaterialList = new ArrayList<BeerRawMaterial>();
            Beer beer = null;

            do{
                if(beer==null){
                    beer = new Beer();
                    beer.setId(rs.getInt("beerID"));
                    beer.setName(rs.getString("name"));
                    beer.setDescription(rs.getString("description"));
                    beer.setAlcohol(rs.getDouble("alcohol"));

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
                    aPackage.setSize(rs.getDouble("size"));

                    //Actual package (price) of the beer
                    BeerPackage beerPackage = new BeerPackage();
                    beerPackage.setBeerPackageID(rs.getInt("beer_packageID"));
                    beerPackage.setPrice(rs.getDouble("price"));

                    //Uploader of the beer
                    User uploader = new User();
                    uploader.setId(rs.getInt("userID"));
                    uploader.setUsername(rs.getString("username"));
                    uploader.setFirstname(rs.getString("firstname"));
                    uploader.setLastname(rs.getString("lastname"));
                    uploader.setEmail(rs.getString("email"));
                    uploader.setCreated(rs.getDate("created"));

                    //Sub-objects to Beer object
                    brewery.setCountry(country);
                    beerPackage.setaPackage(aPackage);

                    //dynamically calculates per liter price
                    beerPackage.setPricePerLiter();

                    beer.setBeerPackage(beerPackage);
                    beer.setBrewery(brewery);
                    beer.setUser(uploader);
                }

//                //Raw materials used in beer to own list
//                BeerRawMaterial beerRawMaterial = new BeerRawMaterial();
//                beerRawMaterial.setId(rs.getInt("beer_raw_materialID"));
//                beerRawMaterial.setAmount(rs.getDouble("amount"));
//                beerRawMaterial.setRawMaterial(rs.getString("raw_material"));
//
//                beerRawMaterialList.add(beerRawMaterial);

            }while(rs.next());

//            beer.setBeerRawMaterialList(beerRawMaterialList);
            return beer;
        }
    }