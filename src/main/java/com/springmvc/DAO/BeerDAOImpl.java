package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.RowMapper.BeerRowMapper;
import com.springmvc.RowMapper.BeerStyleRowMapper;
import com.springmvc.RowMapper.BeerUploaderBreweryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BeerDAOImpl implements BeerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<BeerStyle> findAllBeerStyles(){
        String sql = "SELECT styleID, beer_style FROM Beer_style";

        RowMapper<BeerStyle> beerStyleRowMapper = new BeerStyleRowMapper();
        List<BeerStyle> beerStyles = jdbcTemplate.query(sql, beerStyleRowMapper);

        return beerStyles;
    }

    public List<Beer> findAllBeersByStyle(int styleID){
      String sql = "SELECT beerID, name, breweryID, styleID FROM Beer WHERE styleID = ? ORDER BY name";

        Object[] parameters = new Object[]{styleID};

        RowMapper<Beer> beerRowMapper = new BeerRowMapper();

        List<Beer> beers = jdbcTemplate.query(sql, parameters, beerRowMapper);

        return beers;
    }


    public Beer findBeerBreweryUploaderByID(int beerID){
        String sql = "SELECT b.beerID, b.name, b.description, b.alcohol, bre.breweryID, bre.brewery_name, c.countryID, c.country, " +
                "u.userID, u.username, u.firstname, u.lastname, u.email, u.created, bp.beer_packageID, bp.price, " +
                "p.packageID, p.size, brm.beer_raw_materialID, \n" +
                "brm.amount, rm.raw_material\n" +
                "FROM Beer as b \n" +
                "INNER JOIN User as u " +
                "INNER JOIN Brewery as bre " +
                "INNER JOIN Country as c " +
                "INNER JOIN Beer_package as bp " +
                "INNER JOIN Package as p " +
                "INNER JOIN Beer_raw_material as brm " +
                "INNER JOIN Raw_material as rm\n" +
                "ON b.userID = u.userID " +
                "AND b.breweryID = bre.breweryID " +
                "AND bre.countryID = c.countryID " +
                "AND b.beerID = bp.beerID " +
                "AND bp.packageID = p.packageID " +
                "AND b.beerID = brm.beerID " +
                "AND brm.raw_materialID = rm.raw_materialID\n" +
                "WHERE b.beerID = ? " +
                "ORDER BY b.name;";

        Object[] parameters = new Object[]{beerID};

        RowMapper<Beer> beerRowMapper = new BeerUploaderBreweryRowMapper();

        Beer beer = jdbcTemplate.queryForObject(sql, parameters, beerRowMapper);

        return beer;
    }

}
