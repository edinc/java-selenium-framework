package selenium.testdata.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {
    private String email;
    private String username;
    private String password;
    private String gender;
    private String firstname;
    private String lastname;
    private String address;
    private String zip;
    private String city;
    private String cardtype;
    private String cardnumber;
    private String expiremonth;
    private String expireyear;
    private String ccvnumber;
    private String country;
    private String telephone;

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getUsername() {return username; }

    public void setUsername(final String username) { this.username = username; }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpiremonth() {
        return expiremonth;
    }

    public void setExpiremonth(String expiremonth) {
        this.expiremonth = expiremonth;
    }

    public String getExpireyear() {
        return expireyear;
    }

    public void setExpireyear(String expireyear) {
        this.expireyear = expireyear;
    }

    public String getCcvnumber() {
        return ccvnumber;
    }

    public void setCcvnumber(String ccvnumber) {
        this.ccvnumber = ccvnumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("email", email)
                .append("password", password)
                .build();
    }
}

