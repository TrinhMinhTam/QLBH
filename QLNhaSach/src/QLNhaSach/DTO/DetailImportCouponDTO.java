package QLNhaSach.DTO;

public class DetailImportCouponDTO {
    String  CodeCoupon;
    String  CodeBook;
    int  Number;
    
    public  DetailImportCouponDTO()
    {}

    public DetailImportCouponDTO(String CodeCoupon, String CodeBook, int Number) {
        this.CodeCoupon = CodeCoupon;
        this.CodeBook = CodeBook;
        this.Number = Number;
    }

    public String getCodeCoupon() {
        return CodeCoupon;
    }

    public void setCodeCoupon(String CodeCoupon) {
        this.CodeCoupon = CodeCoupon;
    }

    public String getCodeBook() {
        return CodeBook;
    }

    public void setCodeBook(String CodeBook) {
        this.CodeBook = CodeBook;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    @Override
    public String toString() {
        return "DetailImportCouponDTO{" + "CodeCoupon=" + CodeCoupon + ", CodeBook=" + CodeBook + ", Number=" + Number + '}';
    }
    
     public static int maSPTangdan(DetailImportCouponDTO a, DetailImportCouponDTO b){
        return a.getCodeBook().compareTo(b.getCodeBook());
    } 
}
