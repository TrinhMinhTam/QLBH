package QLNhaSach.DTO;

public class BillDTO {

    private String CodeBill;
    private String CodeCustomer;
    private String CodeStaff;
    private String DaySale;
    private float ThanhTien;

    public BillDTO() {
    }

    public BillDTO(String CodeBill, String CodeCustomer, String CodeStaff, String DaySale, float ThanhTien) {
        this.CodeBill = CodeBill;
        this.CodeCustomer = CodeCustomer;
        this.CodeStaff = CodeStaff;
        this.DaySale = DaySale;
        this.ThanhTien = ThanhTien;
    }

    public String getCodeBill() {
        return CodeBill;
    }

    public void setCodeBill(String CodeBill) {
        this.CodeBill = CodeBill;
    }

    public String getCodeCustomer() {
        return CodeCustomer;
    }

    public void setCodeCustomer(String CodeCustomer) {
        this.CodeCustomer = CodeCustomer;
    }

    public String getCodeStaff() {
        return CodeStaff;
    }

    public void setCodeStaff(String CodeStaff) {
        this.CodeStaff = CodeStaff;
    }

    public String getDaySale() {
        return DaySale;
    }

    public void setDaySale(String DaySale) {
        this.DaySale = DaySale;
    }
    
    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    @Override
    public String toString() {
        return "BillDTO{" + "CodeBill=" + CodeBill + ", CodeCustomer=" + CodeCustomer + ", CodeStaff=" + CodeStaff + ", DaySale=" + DaySale +'}';
    }
    
    public static int maHDTangdan(BillDTO a, BillDTO b){
        return a.getCodeBill().compareTo(b.getCodeBill());
    }   
    public static int maHDGiamdan(BillDTO a, BillDTO b){
        return b.getCodeBill().compareTo(a.getCodeBill());
    }
    
    public static int maKHTangdan(BillDTO a, BillDTO b){
        return a.getCodeCustomer().compareTo(b.getCodeCustomer());
    }
    public static int maKHGiamdan(BillDTO a, BillDTO b){
        return b.getCodeCustomer().compareTo(a.getCodeCustomer());
    }
    public static int maNVTangdan(BillDTO a, BillDTO b){
        return a.getCodeStaff().compareTo(b.getCodeStaff());
    }
    public static int maNVGiamdan(BillDTO a, BillDTO b){
        return b.getCodeStaff().compareTo(a.getCodeStaff());
    }
}


    