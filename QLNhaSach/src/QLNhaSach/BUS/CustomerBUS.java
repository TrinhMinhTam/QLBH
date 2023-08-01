package QLNhaSach.BUS;

import QLNhaSach.DAO.CustomerDAO;
import QLNhaSach.DTO.CustomerDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CustomerBUS {
    private ArrayList<CustomerDTO> list_Customer;
    private CustomerDAO customerDAO;
    
    public CustomerBUS() throws Exception {
        list_Customer = new ArrayList<>();
         customerDAO= new CustomerDAO();
        list_Customer = customerDAO.docDB();
    }

    public Boolean Add(CustomerDTO customers) throws Exception{
        if ( customerDAO.Add(customers) ) {
            list_Customer.add(customers);
        }
        return false;
    }
    
    public Boolean Delete(CustomerDTO customers) throws Exception {
        if ( customerDAO.Delete(customers) ) {
            for ( CustomerDTO customer : list_Customer ) {
                if (customer.getCustomerID().equals(customer.getCustomerID())){
                    list_Customer.remove(customers);
                break;
                }
            }
        }
        
        return false;
    }

    public Boolean Fix(CustomerDTO customers) throws Exception {
        if ( customerDAO.Fix(customers) ) {
            for ( CustomerDTO customer : list_Customer ) {
                if (customer.getCustomerID().equals(customer.getCustomerID())){
                break;
                }
            }
        }
        
        return false;
    }
}
