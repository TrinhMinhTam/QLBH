package QLNhaSach.DTO;

public class DetailBillDTO {
    String CodeBill;
    String CodeBook;
    int Price;
    int Number; 
    int Sale; 
    float Total;
    
    public DetailBillDTO()
    {}
    

    public DetailBillDTO(String CodeBill, String CodeBook,int Price, int Number,int Sale, float Total) {
        this.CodeBill = CodeBill;
        this.CodeBook = CodeBook;
        this.Price = Price;
        this.Number = Number;
        this.Sale = Sale;
        this.Total = Total;
    }

    public String getCodeBill() {
        return CodeBill;
    }

    public void setCodeBill(String CodeBill) {
        this.CodeBill = CodeBill;
    }

    public String getCodeBook() {
        return CodeBook;
    }

    public void setCodeBook(String CodeBook) {
        this.CodeBook = CodeBook;
    }
    
    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    
    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }    
    
    public int getSale() {
        return Sale;
    }

    public void setSale(int Sale) {
        this.Sale = Sale;
    }
   
    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    @Override
    public String toString() {
        return "DetailBillDTO{" + "CodeBill=" + CodeBill + ", CodeBook=" + CodeBook + ", Number=" + Number + ", Total=" + Total + '}';
    }  
}
