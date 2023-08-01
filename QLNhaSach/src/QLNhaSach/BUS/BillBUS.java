package QLNhaSach.BUS;

import QLNhaSach.DAO.BillDAO;
import QLNhaSach.DTO.BillDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BiConsumer;

public class BillBUS {
    private ArrayList<BillDTO> list_HD;
    private BillDAO hdDAO;
    
    public void docDB() throws Exception{
        list_HD = new ArrayList<>();
        hdDAO = new BillDAO();
        list_HD = hdDAO.docDB();
        
    }
    
    public BillBUS() throws Exception {
        list_HD = new ArrayList<>();
        hdDAO = new BillDAO();
        list_HD = hdDAO.docDB();
    }

    public void add(BillDTO hd) {
        list_HD.add(hd);
    }
    
    public void deleteAll() {
        list_HD.removeAll(list_HD);
    }
    
    public BillDAO getHdDAO() {
        return hdDAO;
    }

    public void setHdDAO(BillDAO hdDAO) {
        this.hdDAO = hdDAO;
    }
    
    public int getNumbHoaDon() {
        return list_HD.size();
    }
    
   public BillDTO getInfor(String CodeBill){
       for(BillDTO hoadon : list_HD){
           if(hoadon.getCodeBill().equals(CodeBill)){
               return hoadon;
           }
       }
       BillDTO hd = new BillDTO();
       hd.setCodeBill(null);
       return hd;
   }
   
   public String getMaKM(String CodeBill){
       for(BillDTO hoadon : list_HD){
           if(hoadon.getCodeBill().equals(CodeBill)){
               return hoadon.getCodeBill();
           }
       }
       return null;
   }
   
   public ArrayList<BillDTO> timkiem_MaHD(String CodeBill,boolean sapxep){
       ArrayList<BillDTO> arr = new ArrayList<>();
       for(BillDTO hoadon : list_HD){
           if(hoadon.getCodeBill().indexOf(CodeBill) != -1){
               System.out.println("hoa don tim kiem la: "+hoadon.getCodeBill());
               arr.add(hoadon);
           }
       }
       if(sapxep){
           Collections.sort(arr,BillDTO::maHDTangdan);
       }else{
           Collections.sort(arr,BillDTO::maHDGiamdan);
       }
       return arr;
   }
   
   public ArrayList<BillDTO> timkiem_MaKH(String CodeKH,boolean sapxep){
     ArrayList<BillDTO> arr  = new ArrayList<>();
     for(BillDTO hd : list_HD){
         if(hd.getCodeCustomer().equals(CodeKH)){
             System.out.println("makH dang tim kiem la: "+ hd.getCodeCustomer());
             arr.add(hd);
         }
     }
     if(sapxep){
         Collections.sort(arr,BillDTO::maKHTangdan);
     }else{
         Collections.sort(arr,BillDTO::maKHGiamdan);
     }
     return  arr;
   }
   
   public ArrayList<BillDTO> timkiem_MaNV(String MaNV,boolean sapxep){
       ArrayList<BillDTO> arr = new ArrayList<>();
       for(BillDTO hd: list_HD){
           if(hd.getCodeStaff().indexOf(MaNV) != -1){
               System.err.println("Nhan vien dangb tim kiem : "+hd.getCodeStaff());
               arr.add(hd);
           }
       }
       if(sapxep){
           Collections.sort(arr,BillDTO::maNVTangdan);
       }else{
           Collections.sort(arr,BillDTO::maNVGiamdan);
       }
       return arr;
   }
   
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    
    public String getDefaultMaHD(){
       if (list_HD.size() == 0)
            return "HD001";
        else {
            String s = "HD";
            int iNumb  = 0;
            
            for (BillDTO hoadon : list_HD) {
                String[] maHD = hoadon.getCodeBill().split("HD");
                iNumb = Integer.parseInt( maHD[1] );
                iNumb++;
            }
            switch (demSoChuSo(iNumb)) {
            
            }
            s += iNumb;
            return s;
        }
    }
    
     public Boolean them(BillDTO hd) throws Exception{
        if(hdDAO.them(hd)){
            list_HD.add(hd);
        }
        return false;
    }
    
    public Boolean xoa(BillDTO hd) throws Exception{
        if(hdDAO.xoa(hd)){
            for(BillDTO hoadon : list_HD){
                if(hoadon.getCodeBill().equals(hd.getCodeBill())){
                    list_HD.remove(hd);
                }
            }
        }
        return false;
    }
    
    public Boolean sua(BillDTO hd) throws Exception{
       if(hdDAO.sua(hd)){
           for(BillDTO hoadon : list_HD){
               if(hoadon.getCodeBill().equals(hd.getCodeBill())){
                     hoadon.setCodeBill(hd.getCodeBill());
                     hoadon.setCodeCustomer(hd.getCodeCustomer());
                     hoadon.setCodeStaff(hd.getCodeStaff());
                     hoadon.setDaySale(hd.getDaySale());
               }
               break;
           }
       }
       return  false;
    }
    
    public ArrayList<BillDTO> getList_HD() {
        return list_HD;
    }

    public void setList_HD(ArrayList<BillDTO> list_HD) {
        this.list_HD = list_HD;
    }
    
    
    
    
    
}
