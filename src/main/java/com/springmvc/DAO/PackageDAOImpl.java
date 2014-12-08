package com.springmvc.DAO;


import com.springmvc.Bean.aPackage;
import com.springmvc.RowMapper.aPackageRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PackageDAOImpl implements PackageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<aPackage> findAllPackageSizes(){

        String sql = "SELECT packageID, size FROM Package";

        RowMapper<aPackage> packageRowMapper = new aPackageRowMapper();
        List<aPackage> packageList = jdbcTemplate.query(sql, packageRowMapper);

        return packageList;
    }


}
