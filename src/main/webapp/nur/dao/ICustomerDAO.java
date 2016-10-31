package dao;


import model.CustomerBean;

/**
 * Created by nur on 27.10.16.
 */
public interface ICustomerDAO {

    public void addCustomer(CustomerBean customerBean);
    public CustomerBean loginCheck(CustomerBean customerBean);
    public void updateCustomer(CustomerBean customerBean);

    public void closeConnection();
}