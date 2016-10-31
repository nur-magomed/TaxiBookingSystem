package dao;

import connection.DBConn;
import model.CustomerBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nur on 27.10.16.
 */
public class CustomerDAO implements ICustomerDAO {

    private Connection conn;

    public CustomerDAO() {
        conn = DBConn.getConnection();
    }

    @Override
    public void closeConnection() {
        try {
            if (conn !=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCustomer(CustomerBean customerBean) {
        try{
            String query = "insert into customer_tbl(first_name, last_name, phone_number, email, password) " +
                    "values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, customerBean.getFirst_name() );
            preparedStatement.setString( 2, customerBean.getLast_name() );
            preparedStatement.setString( 3, customerBean.getPhone_number() );
            preparedStatement.setString( 4, customerBean.getEmail());
            preparedStatement.setString( 5, customerBean.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("Customer is added!");

        } catch (SQLException e) {
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
                    customerBean.setCustomer_id(rs.getInt("customer_id"));
                    customerBean.setFirst_name(rs.getString("first_name"));
                    customerBean.setLast_name(rs.getString("last_name"));
                    customerBean.setPhone_number(rs.getString("phone_number"));
                    customerBean.setDate_of_birth(rs.getDate("date_of_birth"));
                    customerBean.setGender(rs.getInt("gender"));
                    customerBean.setAddress_1(rs.getString("address_1"));
                    customerBean.setAddress_2(rs.getString("address_2"));

                    preparedStatement.close();
                    rs.close();

                } else {
                    preparedStatement.close();
                    rs.close();
                    customerBean = null;
                }

        } catch (SQLException e) {
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
            preparedStatement.setString( 1, customerBean.getFirst_name() );
            preparedStatement.setString( 2, customerBean.getLast_name() );
            preparedStatement.setString( 3, customerBean.getPhone_number() );
            preparedStatement.setString( 4, customerBean.getEmail() );
            preparedStatement.setString( 5, customerBean.getPassword() );
            preparedStatement.setInt( 6, customerBean.getGender() );
            preparedStatement.setString( 7, customerBean.getAddress_1() );
            preparedStatement.setString( 8, customerBean.getAddress_2() );
            preparedStatement.setInt(9, customerBean.getCustomer_id());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("Customer is updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
