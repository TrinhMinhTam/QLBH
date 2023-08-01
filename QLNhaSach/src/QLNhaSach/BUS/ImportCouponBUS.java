package QLNhaSach.BUS;

import QLNhaSach.DAO.ImportCouponDAO;
import QLNhaSach.DTO.ImportCouponDTO;
import java.util.ArrayList;

public class ImportCouponBUS {
    private ArrayList<ImportCouponDTO> list_TK;
    private ImportCouponDAO tkDAO;
    
    public ImportCouponBUS() throws Exception {
        list_TK = new ArrayList<>();
        tkDAO = new ImportCouponDAO();
        list_TK = tkDAO.docDB();
    }
    
    public void add(ImportCouponDTO pn) {
        list_TK.add(pn);
    }
    
    public void deleteAll() {
        list_TK.removeAll(list_TK);
    }
    
    public void docDB() throws Exception {
        list_TK = new ArrayList<>();
        tkDAO = new ImportCouponDAO();
        list_TK = tkDAO.docDB();
    }

    public ArrayList<ImportCouponDTO> getList_TK() {
        return list_TK;
    }

    public void setList_TK(ArrayList<ImportCouponDTO> list_TK) {
        this.list_TK = list_TK;
    }
    
    public int getNumb() {
        return list_TK.size();
    }
    
    public ImportCouponDTO getInfor(int i){
        int iCount =0;
        for (ImportCouponDTO hd : list_TK) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    
    public String getDefaultMaPN() {
        if (list_TK.size() == 0)
            return "PN001";
        else {
            String s = "PN";
            int iNumb = 0;
            
            for (ImportCouponDTO hoadon : list_TK) {
                String[] maPN = hoadon.getCodeCoupon().split("PN");
                iNumb = Integer.parseInt( maPN[1] );
                iNumb++;
            }
            switch (demSoChuSo(iNumb)) {
                case 1:
                    s +="0";
                case 2:
                    s +="0";
                case 3:  
            }
            s += iNumb;
            return s;
        }
    }
    
     public ArrayList<ImportCouponDTO> timKiem_MaPN(String CodeCoupon) {
        ArrayList<ImportCouponDTO> arr = new ArrayList<>();
        for (ImportCouponDTO hoadon : list_TK) {
            if ( hoadon.getCodeCoupon().indexOf(CodeCoupon) != -1 ) {
                System.out.println("Tim thay " + hoadon.getCodeCoupon() );
                arr.add(hoadon);
            }
        }
        return arr;
    }
    
    public ArrayList<ImportCouponDTO> timKiem_MaNV(String CodeStaff) {
        ArrayList<ImportCouponDTO> arr = new ArrayList<>();
        for (ImportCouponDTO hoadon : list_TK) {
            if ( hoadon.getCodeStaff().indexOf(CodeStaff) != -1 ) {
                System.out.println("Tim thay " + hoadon.getCodeStaff() );
                arr.add(hoadon);
            }
        }
        
        return arr;
    }
    
    public ArrayList<ImportCouponDTO> timKiem_MaNCC(String CodeSupplier) {
        ArrayList<ImportCouponDTO> arr = new ArrayList<>();
        for (ImportCouponDTO hoadon : list_TK) {
            if ( hoadon.getCodeSupplier().indexOf(CodeSupplier) != -1 ) {
                System.out.println("Tim thay " + hoadon.getCodeCoupon() );
                arr.add(hoadon);
            }
        }
        
        return arr;
    }    
    
    public Boolean them(ImportCouponDTO tk) throws Exception{
        if ( tkDAO.them(tk) ) {
            list_TK.add(tk);
        }
        return false;
    }

    public Boolean xoa(ImportCouponDTO tk) throws Exception {
        if ( tkDAO.xoa(tk) ) {
            
            // duyệt từng phẩn tử
            for ( ImportCouponDTO taikhoan : list_TK ) {
                if (taikhoan.getCodeCoupon().equals(tk.getCodeCoupon())){
                    list_TK.remove(taikhoan);
                break;
                }
            }
        }
        
        return false;
    }

    public Boolean sua(ImportCouponDTO tk) throws Exception {
        if ( tkDAO.sua(tk) ) {
            
            // duyệt từng phẩn tử
            for ( ImportCouponDTO taikhoan : list_TK ) {
                if (taikhoan.getCodeCoupon().equals(tk.getCodeCoupon())){
                    taikhoan.setCodeSupplier(tk.getCodeSupplier());
                    taikhoan.setCodeStaff(tk.getCodeStaff());
                    taikhoan.setCodeCoupon(tk.getCodeCoupon());
                    taikhoan.setDate(tk.getDate());
                    return true;
                }
            }
        }
        
        return false;
    }

}
