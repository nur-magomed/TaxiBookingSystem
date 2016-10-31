package dao;

import connection.DBConn;
import model.CustomerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nur on 27.10.16.
 */
public class CustomerDAO implements ICustomerDAO {
    private static final Logger log = LoggerFactory.getLogger(CustomerDAO.class);
    private Connection conn;

    public CustomerDAO() {
        conn = DBConn.getConnection();
        log.info("Made connection to DB");
    }

    @Override
    public void closeConnection() {
        try {
            if (conn !=null) {
                conn.close();
                log.warn("Made connection to DB is closed");
            }
        } catch (SQLException e) {

            log.error("error: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void addCustomer(CustomerBean customerBean) {
        try{
            String query = "insert into customer_tbl(first_name, last_name, phone_number, email, password) " +
                    "values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, customerBean.getFirstName() );
            preparedStatement.setString( 2, customerBean.getLastName() );
            preparedStatement.setString( 3, customerBean.getPhoneNumber() );
            preparedStatement.setString( 4, customerBean.getEmail());
            preparedStatement.setString( 5, customerBean.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            log.info("Customer is added!");
        } catch (SQLException e) {
            log.error("sql error, adding customer: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public CustomerBean loginCheck(CustomerBean customerBean) {
        try{
            String queryLogin = "SELECT * FROM customer_tbl WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement( queryLogin );
            preparedStatement.setString(1, customerBean.getEmail() );
            preparedStatement.setString(2, customerBean.getPassword() );
            ResultSet rs = preparedStatement.executeQuery();
            boolean notEmpty=rs.next();

                if (notEmpty) {
                    customerBean.setCustomerId(rs.getInt("customer_id"));
                    customerBean.setFirstName(rs.getString("first_name"));
                    customerBean.setLastName(rs.getString("last_name"));
                    customerBean.setPhoneNumber(rs.getString("phone_number"));
                    customerBean.setDateOfBirth(rs.getDate("date_of_birth"));
                    customerBean.setGender(rs.getInt("gender"));
                    customerBean.setAddress1(rs.getString("address_1"));
                    customerBean.setAddress2(rs.getString("address_2"));

                    preparedStatement.close();
                    rs.close();
                    log.info("Customer has logged in!");

                } else {
                    preparedStatement.close();
                    rs.close();
                    customerBean = null;
                }

        } catch (SQLException e) {
            log.error("sql error, login: " + e);
            e.printStackTrace();
        }
        return customerBean;
    }


    @Override
    public void updateCustomer(CustomerBean customerBean) {
        try{
            String queryUpdate = "UPDATE customer_tbl SET first_name=?, last_name=?, phone_number=?, " +
                    "email=?, password=?, gender=?, address_1=?, address_2=? WHERE customer_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( queryUpdate );
            preparedStatement.setString( 1, customerBean.getFirstName() );
            preparedStatement.setString( 2, customerBean.getLastName() );
            preparedStatement.setString( 3, customerBean.getPhoneNumber() );
            preparedStatement.setString( 4, customerBean.getEmail() );
            preparedStatement.setString( 5, customerBean.getPassword() );
            preparedStatement.setInt( 6, customerBean.getGender() );
            preparedStatement.setString( 7, customerBean.getAddress1() );
            preparedStatement.setString( 8, customerBean.getAddress2() );
            preparedStatement.setInt(9, customerBean.getCustomerId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            log.info("Customer is updated!");

        } catch (SQLException e) {
            log.error("sql error, updating customer: " + e);
            e.printStackTrace();
        }
    }


}
