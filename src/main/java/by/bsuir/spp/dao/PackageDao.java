package by.bsuir.spp.dao;

import by.bsuir.spp.bean.document.Package;

import java.util.List;

/**
 * Created by Кирилл on 2/15/2016.
 */
public interface PackageDao extends GenericDao<Package, Integer> {

    List<Package> getAllPackages();
    List<Integer> getPackageIds();
    List<Package> getPackagesByPassportId(int passportId);
    void addPackageToNewPackages(int idPackage);
    void deleteNewPackage(int idPackage);
    List<Integer> getNewPackageIds();
    void updateStatus(int idPackage, String status);
}
