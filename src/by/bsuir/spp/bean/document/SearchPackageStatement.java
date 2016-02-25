package by.bsuir.spp.bean.document;

import by.bsuir.spp.bean.Passport;

import java.io.Serializable;
import java.lang.*;
import java.util.Date;

public class SearchPackageStatement implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String address;
    private String phoneNumber;
    private Passport passport;

    private String petitionContent;

    private Package postPackage;

    private Date currentDate;

    private String postManagerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getPetitionContent() {
        return petitionContent;
    }

    public void setPetitionContent(String petitionContent) {
        this.petitionContent = petitionContent;
    }

    public Package getPostPackage() {
        return postPackage;
    }

    public void setPostPackage(Package postPackage) {
        this.postPackage = postPackage;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getPostManagerName() {
        return postManagerName;
    }

    public void setPostManagerName(String postManagerName) {
        this.postManagerName = postManagerName;
    }
}
