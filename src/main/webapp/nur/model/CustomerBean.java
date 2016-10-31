package model;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by nur on 27.10.16.
 */
public class CustomerBean {

    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String address1;
    private String address2;
    private int gender;

    public CustomerBean(){};

    public CustomerBean (HttpServletRequest request)  {
        firstName= request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        phoneNumber = request.getParameter("phone_numb");
        email = request.getParameter("email");
        password = request.getParameter("user_password");
    }



    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    /**
     * Method returns
     * @return
     */
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method returns
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method returns
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method returns
     * @return
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method returns
     * @return
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Method returns
     * @return
     */
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Method returns
     * @return
     */
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Method checks if Gender is true
     * @return
     */
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


}