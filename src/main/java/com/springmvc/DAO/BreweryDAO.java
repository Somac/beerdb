package com.springmvc.DAO;

import com.springmvc.Bean.Brewery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BreweryDAO {
    List<Brewery> findAllBrewerys();
}
