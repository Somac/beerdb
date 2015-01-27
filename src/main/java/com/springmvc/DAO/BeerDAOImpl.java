package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.RowMapper.BeerRowMapper;
import com.springmvc.RowMapper.BeerStyleRowMapper;
import com.springmvc.RowMapper.BeerUploaderBreweryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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
      String sql = "SELECT beerID, name, description, alcohol, created, breweryID, styleID FROM Beer WHERE styleID = ? " +
              "ORDER BY name";

        Object[] parameters = new Object[]{styleID};
        RowMapper<Beer> beerRowMapper = new BeerRowMapper();

        List<Beer> beers = jdbcTemplate.query(sql, parameters, beerRowMapper);

        return beers;
    }


    public Beer findBeerBreweryUploaderByID(int beerID){
        String sql = "SELECT b.beerID, b.name, b.description, b.alcohol, usr.userID, usr.username, usr.created,\n" +
                "u.userID, u.email, r.rating, bre.breweryID, bre.brewery_name, c.countryID, c.country, bp.beer_packageID, bp.price, p.packageID, p.size \n" +
                "FROM Beer as b\n" +
                "INNER JOIN Rating as r\n" +
                "INNER JOIN User as u\n" +
                "INNER JOIN Brewery as bre\n" +
                "INNER JOIN Country as c\n" +
                "INNER JOIN Beer_package as bp\n" +
                "INNER JOIN Package as p\n" +
                "INNER JOIN User as usr\n" +
                "ON b.beerID = r.beerID\n" +
                "AND r.userID = u.userID\n" +
                "AND b.breweryID = bre.breweryID\n" +
                "AND bre.breweryID = c.countryID\n" +
                "AND b.beerID = bp.beerID\n" +
                "AND bp.packageID = p.packageID\n" +
                "AND usr.userID = b.userID\n" +
                "WHERE b.beerID = ?\n" +
                "ORDER BY b.name;";

        Object[] parameters = new Object[]{beerID};
        RowMapper<Beer> beerRowMapper = new BeerUploaderBreweryRowMapper();

        Beer beer = jdbcTemplate.queryForObject(sql, parameters, beerRowMapper);

        return beer;
    }



    public Beer findBeerByName(String name) throws EmptyResultDataAccessException{

        String sql = "SELECT beerID, name, description, alcohol, created, breweryID, styleID FROM Beer WHERE name=?";

        Object[] parameters = new Object[]{name};
        RowMapper<Beer> beerRowMapper = new BeerRowMapper();

        Beer b = jdbcTemplate.queryForObject(sql, parameters, beerRowMapper);

        return b;
    }

    @Transactional(isolation=Isolation.READ_COMMITTED, readOnly=false)
    public void saveBeerToDB(Beer beer){

        String sql = "INSERT INTO Beer (name, description, alcohol, breweryID, styleID, userID) VALUES (?,?,?,?,?,?)";
        String sql2 = "INSERT INTO Beer_package (price, packageID, beerID) VALUES (?,?,LAST_INSERT_ID())";

        Object[] parameters = {
                beer.getName(),
                beer.getDescription(),
                beer.getAlcohol(),
                beer.getBrewery().getId(),
                beer.getBeerStyle().getId(),
                beer.getUser().getId()
        };

        Object[] parameters2 = {
          beer.getBeerPackage().getPrice(),
          beer.getBeerPackage().getaPackage().getPackageID()
        };

        jdbcTemplate.update(sql, parameters);
        jdbcTemplate.update(sql2, parameters2);
    }
}
