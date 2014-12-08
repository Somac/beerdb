package com.springmvc.DAO;

import com.springmvc.Bean.aPackage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackageDAO {
    List<aPackage> findAllPackageSizes();
}
