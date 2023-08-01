package QLNhaSach.BUS;

import QLNhaSach.DAO.SaleDAO;
import QLNhaSach.DTO.SaleDTO;
import java.util.ArrayList;

public class SaleBUS {
    private ArrayList<SaleDTO> list_KM;
    private SaleDAO khDAO;
    
    public void docDB() throws Exception {
        list_KM = new ArrayList<>();
        khDAO = new SaleDAO();
        list_KM = khDAO.docDB();
    }
    
    public int getNumb() {
        return list_KM.size();
    }
    
    public SaleDTO getInfor(int i){
        int iCount =0;
        for (SaleDTO hd : list_KM) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    public SaleDTO getInfor(String CodeSale){
        for (SaleDTO hd : list_KM) {
            if (hd.getCodeSale().equals(CodeSale))
                return hd;
        }
        return null;
    }
    
    public SaleBUS() throws Exception {
        list_KM = new ArrayList<>();
        khDAO = new SaleDAO();
        list_KM = khDAO.docDB();
    }
    public int getNumbKM(){
        return list_KM.size();
    }
    
    public String getDefaultMaKM() {
        if (list_KM.size() == 0)
            return "KM001";
        else {
            String s = "KM";
            int iNumb = 0;
            
            for (SaleDTO hoadon : list_KM) {
                String[] maHD = hoadon.getCodeSale().split("KM");
                iNumb = Integer.parseInt( maHD[1] );
                iNumb++;
            }
            s += iNumb;
            return s;
        }
    }
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    public ArrayList<SaleDTO> getList_KM() {
        return list_KM;
    }

    public void setList_KM(ArrayList<SaleDTO> list_KM) {
        this.list_KM = list_KM;
    }
    
    public ArrayList<SaleDTO> timKiem_MaKM(String CodeSale) {
        ArrayList<SaleDTO> arr = new ArrayList<>();
        for (SaleDTO hoadon : list_KM) {
            if ( hoadon.getCodeSale().indexOf(CodeSale) != -1 ) {
                System.out.println("Tim thay " + hoadon.getCodeSale());
                arr.add(hoadon);
            }
        }
        return arr;
    }
    
    public ArrayList<SaleDTO> timKiem_TenCT(String NameSale) {
        ArrayList<SaleDTO> arr = new ArrayList<>();
        for (SaleDTO km : list_KM) {
            if (km.getNameSale().indexOf(NameSale) != -1)
                arr.add(km);
        }
        return arr;
    }

    public Boolean them(SaleDTO kh) throws Exception{
        if ( khDAO.them(kh) ) {
            list_KM.add(kh);
        }
        return false;
    }

    public Boolean xoa(SaleDTO kh) throws Exception {
        if ( khDAO.xoa(kh) ) {
            
            // duyệt từng phẩn tử
            for ( SaleDTO taikhoan : list_KM ) {
                if (taikhoan.getCodeSale().equals(kh.getCodeSale())){
                    list_KM.remove(taikhoan);
                break;
                }
            }
        }
        
        return false;
    }

    public Boolean sua(SaleDTO kh) throws Exception {
        if ( khDAO.sua(kh) ) {
            for ( SaleDTO taikhoan : list_KM ) {
                if (taikhoan.getCodeSale().equals(kh.getCodeSale())){
                     taikhoan.setCodeSale(kh.getCodeSale());
                     taikhoan.setEndDay(kh.getEndDay());
                     taikhoan.setNameSale(kh.getNameSale());
                     taikhoan.setStartDay(kh.getStartDay());
                break;
                }
            }
        }
        
        return false;
    }
}
