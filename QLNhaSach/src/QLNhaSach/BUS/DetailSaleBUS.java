package QLNhaSach.BUS;

import QLNhaSach.DAO.DetailSaleDAO;
import QLNhaSach.DTO.DetailSaleDTO;
import java.util.ArrayList;
import java.util.Collections;

public class DetailSaleBUS {
    private ArrayList<DetailSaleDTO> list_KM;
    private DetailSaleDAO kmDAO;
    
    public void docDB() throws Exception {
        list_KM = new ArrayList<>();
        kmDAO = new DetailSaleDAO();
        list_KM = kmDAO.docDB();
    }
     
    public DetailSaleBUS() throws Exception {
        list_KM = new ArrayList<>();
        kmDAO = new DetailSaleDAO();
        list_KM = kmDAO.docDB();
    }
    public int getNumbKM(){
        return list_KM.size();
    }
    public ArrayList<DetailSaleDTO> getList_KM() {
        return list_KM;
    }

    public void setList_KM(ArrayList<DetailSaleDTO> list_KM) {
        this.list_KM = list_KM;
    }
    
    public DetailSaleDTO getInfor(int i){
        int iCount =0;
        for (DetailSaleDTO hd : list_KM) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }

    public Boolean them(DetailSaleDTO hd) throws Exception{
            if ( kmDAO.them(hd) ) {
                list_KM.add(hd);
                System.out.println("thêm sản phẩm");
            }      
        return false;
    }

    public Boolean xoa(DetailSaleDTO kh) throws Exception {
        if ( kmDAO.xoa(kh) ) {
            
            // duyệt từng phẩn tử
            for ( DetailSaleDTO khuyemai : list_KM ) {
                if (khuyemai.getCodeSale()==kh.getCodeSale()
                        && khuyemai.getCodeBook()==kh.getCodeBook()){
                    list_KM.remove(khuyemai);
                break;
                }
            }
        }
        
        return false;
    }

    public Boolean sua(DetailSaleDTO kh) throws Exception {
        if ( kmDAO.sua(kh) ) {
            
            // duyệt từng phẩn tử
            for ( DetailSaleDTO khuyemai : list_KM ) {
                if (kh.getCodeSale()==khuyemai.getCodeSale()){
                     khuyemai.setCodeSale(kh.getCodeSale());
                     khuyemai.setCodeSale(kh.getCodeBook());
                     khuyemai.setCodeSale(kh.getCodeSale());
                break;
                }
            }
        }
        
        return false;
    }
    
    public ArrayList<DetailSaleDTO> timKiem_TiLeKM(double SL1, double SL2) {
        ArrayList<DetailSaleDTO> arr = new ArrayList<>();
        for (DetailSaleDTO hoadon : list_KM) {
            if ( hoadon.getPercentSale()>= SL1 && hoadon.getPercentSale()<= SL2) {
                System.out.println("Tim thay " + hoadon.getCodeSale() );
                arr.add(hoadon);
            }
        }
        return arr;
    }
    
}
