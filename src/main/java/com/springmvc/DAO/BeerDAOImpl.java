package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.RowMapper.BeerRowMapper;
import com.springmvc.RowMapper.BeerStyleRowMapper;
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

    @Override
    public List<Beer> findAllBeers(){

        String sql = "SELECT beerID, name, process FROM Beer";
        RowMapper<Beer> beerRowMapper = new BeerRowMapper();
        List<Beer> beers = jdbcTemplate.query(sql, beerRowMapper);

        return beers;
    }

    public List<BeerStyle> findAllBeerStyles(){
        String sql = "SELECT styleID, beer_style FROM Beer_style";
        RowMapper<BeerStyle> beerStyleRowMapper = new BeerStyleRowMapper();
        List<BeerStyle> beerStyles = jdbcTemplate.query(sql, beerStyleRowMapper);

        return beerStyles;
    }

    public Beer findBeer(int id){
        String sql =
                "SELECT b.beerID, b.name, b.process, rm.raw_materialID, rm.raw_material\n" +
                "FROM Beer as b, Beer_raw_material as brm, Raw_material as rm\n" +
                "WHERE b.beerID=brm.beerID AND brm.raw_materialID=rm.raw_materialID AND b.beerID=?;";

        Object[] parameters = new Object[]{id};

        RowMapper<Beer> beerRowMapper = new BeerRowMapper();
        List<Beer> b = jdbcTemplate.query(sql, parameters, beerRowMapper);

        Beer beer = b.get(0);

        return beer;
    }
}
