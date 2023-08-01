package QLNhaSach.BUS;

import QLNhaSach.DAO.DetailImportCouponDAO;
import QLNhaSach.DTO.DetailImportCouponDTO;
import java.util.ArrayList;
import java.util.Collections;

public class DetailImportCouponBUS {
    private ArrayList<DetailImportCouponDTO> list_PN;
    private DetailImportCouponDAO pnDAO;
    
    public void docDB() throws Exception {
        list_PN = new ArrayList<>();
        pnDAO = new DetailImportCouponDAO();
        list_PN = pnDAO.docDB();
    }
    public void add(DetailImportCouponDTO pn) {
        list_PN.add(pn);
    }
    public void deleteAll() {
        list_PN.removeAll(list_PN);
    }

    
    public DetailImportCouponBUS() throws Exception {
        list_PN = new ArrayList<>();
        pnDAO = new DetailImportCouponDAO();
        list_PN = pnDAO.docDB();
    }

    public ArrayList<DetailImportCouponDTO> getList_PN() {
        return list_PN;
    }

    public void setList_PN(ArrayList<DetailImportCouponDTO> list_PN) {
        this.list_PN = list_PN;
    }

    public DetailImportCouponDAO getHdDAO() {
        return pnDAO;
    }

    public void setHdDAO(DetailImportCouponDAO pnDAO) {
        this.pnDAO = pnDAO;
    }
    
    public int getNumbChiTietPN() {
        return list_PN.size();
    }
    
    public DetailImportCouponDTO getInfor(int i){
        int iCount =0;
        for (DetailImportCouponDTO pn : list_PN) {
            if (iCount == i)
                return pn;
            iCount++;
        }
        return null;
    }

    public ArrayList<DetailImportCouponDTO> timKiem_MaSP(String strMaSP1, String strMaSP2) {
        ArrayList<DetailImportCouponDTO> arr = new ArrayList<>();
        
        Collections.sort(list_PN, DetailImportCouponDTO::maSPTangdan);
        
        int flag = 0;
        if (strMaSP1.equals(strMaSP2))
            for (DetailImportCouponDTO hoadon : list_PN) {
                if ( hoadon.getCodeBook().indexOf(strMaSP1) != -1 ) {
                    arr.add(hoadon);
                    System.out.println("Tim thay SP1" + hoadon.getCodeCoupon() );
                }
            }
        else    
            for (DetailImportCouponDTO hoadon : list_PN) {
                if ( hoadon.getCodeBook().indexOf(strMaSP1) != -1 ) {
                    flag = 1;
                    System.out.println("Tim thay SP1" + hoadon.getCodeCoupon() );
                }
                if ( hoadon.getCodeBook().indexOf(strMaSP2) != -1 ) {
                    flag = 2;
                    System.out.println("Tim thay SP2" + hoadon.getCodeCoupon() );
                }
                
                if ( flag == 2 )
                    if ( hoadon.getCodeBook().indexOf(strMaSP2) == -1 )
                        break;
                
                if ( flag == 1 || flag == 2 )
                    arr.add(hoadon);
                
            }
        
        return arr;
    }
    
    public ArrayList<DetailImportCouponDTO> timKiem_SoLuong(int SL1, int SL2) {
        ArrayList<DetailImportCouponDTO> arr = new ArrayList<>();
        for (DetailImportCouponDTO hoadon : list_PN) {
            if ( hoadon.getNumber() >= SL1 && hoadon.getNumber() <= SL2) {
                System.out.println("Tim thay " + hoadon.getCodeCoupon() );
                arr.add(hoadon);
            }
        }
        
        return arr;
    }
    
    public boolean kiemTraKhoachinh(DetailImportCouponDTO pn) {
        for (DetailImportCouponDTO hoadon : list_PN) {
            if (hoadon.getCodeCoupon().equals(pn.getCodeCoupon()) &&
                    hoadon.getCodeBook().equals(pn.getCodeBook())){
                System.out.println("Bị trùng");
                return true;
            }
        }
        return false;
    }
    
    public Boolean them(DetailImportCouponDTO pn) throws Exception{
     
            if ( pnDAO.them(pn) ) {
                list_PN.add(pn);
                System.out.println("thêm phiếu nhập");
            }
        return false;
    }

    public Boolean xoa(DetailImportCouponDTO pn) throws Exception {
        if ( pnDAO.xoa(pn) ) {
            
            // duyệt từng phẩn tử
            for ( DetailImportCouponDTO hoadon : list_PN ) {
                if (hoadon.getCodeBook().equals(pn.getCodeBook())
                        && hoadon.getCodeCoupon().equals(pn.getCodeCoupon())){
                    list_PN.remove(hoadon);
                    return true;
                }
            }
        }
        
        return false;
    }

    public Boolean sua(DetailImportCouponDTO pn) throws Exception {
        if ( pnDAO.sua(pn) ) {
            
            // duyệt từng phẩn tử
            for ( DetailImportCouponDTO hoadon : list_PN ) {
                if (hoadon.getCodeCoupon().equals(pn.getCodeCoupon())
                        && hoadon.getCodeBook().equals(pn.getCodeBook())){
                    hoadon.setCodeBook(pn.getCodeBook());
                    hoadon.setCodeCoupon(pn.getCodeCoupon());
                    hoadon.setNumber(pn.getNumber());
                    return true;
                }
            }
        }
       
        return false;
    }
    
    
}
