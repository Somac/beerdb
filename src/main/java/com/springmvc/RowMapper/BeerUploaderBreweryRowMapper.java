package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
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

            List<BeerRawMaterial> beerRawMaterialList = new ArrayList<BeerRawMaterial>();
            Beer beer = null;

            do{
                if(beer==null){
                    beer = new BeerImpl();
                    beer.setId(rs.getInt("beerID"));
                    beer.setName(rs.getString("name"));
                    beer.setProcess(rs.getString("process"));

                    //Brewery of the beer
                    Brewery brewery = new BreweryImpl();
                    brewery.setId(rs.getInt("breweryID"));
                    brewery.setName(rs.getString("brewery_name"));
                    brewery.setCountry(rs.getString("country"));

                    //Package of the beer
                    BeerPackage beerPackage = new BeerPackageImpl();
                    beerPackage.setId(rs.getInt("beer_packageID"));
                    beerPackage.setPrice(rs.getDouble("price"));
                    beerPackage.setSize(rs.getDouble("size"));

                    //Uploader of the beer
                    User uploader = new UserImpl();
                    uploader.setUserID(rs.getInt("userID"));
                    uploader.setUsername(rs.getString("username"));
                    uploader.setFirstname(rs.getString("firstname"));
                    uploader.setLastname(rs.getString("lastname"));
                    uploader.setEmail(rs.getString("email"));
                    uploader.setCreated(rs.getDate("created"));

                    //Sub-objects to Beer object
                    beer.setBeerPackage(beerPackage);
                    beer.setBrewery(brewery);
                    beer.setUser(uploader);
                }

                //Raw materials used in beer to own list
                BeerRawMaterial beerRawMaterial = new BeerRawMaterialImpl();
                beerRawMaterial.setId(rs.getInt("beer_raw_materialID"));
                beerRawMaterial.setAmount(rs.getDouble("amount"));
                beerRawMaterial.setRawMaterial(rs.getString("raw_material"));

                beerRawMaterialList.add(beerRawMaterial);

            }while(rs.next());

            beer.setBeerRawMaterialList(beerRawMaterialList);
            return beer;
        }
    }