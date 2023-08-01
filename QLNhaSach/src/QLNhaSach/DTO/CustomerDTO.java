package QLNhaSach.DTO;

public class CustomerDTO {
    String CustomerID;
    String Ho;
    String Ten;
    String Address;
    String Sdt;
    String Email;
    
    public  CustomerDTO()
    {}
     
    public CustomerDTO(String CustomerID, String Ho, String Ten, String Address,String Sdt,String Email ) {
        this.CustomerID = CustomerID;
        this.Ho = Ho;
        this.Ten = Ten;
        this.Address = Address;
        this.Sdt = Sdt;
        this.Email = Email;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
