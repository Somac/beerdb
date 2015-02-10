package com.springmvc.RowMapper;

import com.springmvc.Bean.aPackage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class aPackageRowMapper implements RowMapper<aPackage>{
    public aPackage mapRow(ResultSet rs, int rowNum) throws SQLException {

        aPackage aPackage = new aPackage();
        aPackage.setPackageID(rs.getInt("packageID"));
        aPackage.setSize(rs.getDouble("size"));

        return aPackage;

    }
}
