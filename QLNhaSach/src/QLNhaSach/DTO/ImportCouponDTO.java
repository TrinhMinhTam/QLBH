package QLNhaSach.DTO;

public class ImportCouponDTO {
    String CodeCoupon;
    String CodeStaff;
    String CodeSupplier;
    String Date;
    
    public ImportCouponDTO()
    {}

    public ImportCouponDTO(String CodeCoupon, String CodeStaff, String CodeSupplier, String Date) {
        this.CodeCoupon = CodeCoupon;
        this.CodeStaff = CodeStaff;
        this.CodeSupplier = CodeSupplier;
        this.Date = Date;
    }

    public String getCodeCoupon() {
        return CodeCoupon;
    }

    public void setCodeCoupon(String CodeCoupon) {
        this.CodeCoupon = CodeCoupon;
    }

    public String getCodeStaff() {
        return CodeStaff;
    }

    public void setCodeStaff(String CodeStaff) {
        this.CodeStaff = CodeStaff;
    }

    public String getCodeSupplier() {
        return CodeSupplier;
    }

    public void setCodeSupplier(String CodeSupplier) {
        this.CodeSupplier = CodeSupplier;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    @Override
    public String toString() {
        return "ImportCouponDTO{" + "CodeCoupon=" + CodeCoupon + ", CodeStaff=" + CodeStaff + ", CodeSupplier=" + CodeSupplier + ", Date=" + Date + '}';
    }       
}
