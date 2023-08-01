package QLNhaSach.BUS;


import QLNhaSach.DAO.SupplierDAO;
import QLNhaSach.DTO.SupplierDTO;
import java.util.ArrayList;

public class SupplierBUS {
    private ArrayList<SupplierDTO> list_NV;
    private SupplierDAO nvDAO;

    public ArrayList<SupplierDTO> getList_NV() {
        return list_NV;
    }

    public void setList_NV(ArrayList<SupplierDTO> list_NV) {
        this.list_NV = list_NV;
    }
    
    public SupplierBUS() throws Exception {
        list_NV = new ArrayList<>();
        nvDAO = new SupplierDAO();
        list_NV = nvDAO.docDB();
    }
    
    public int getNumb() {
        return list_NV.size();
    }

    public Boolean them(SupplierDTO nv) throws Exception{
        if ( nvDAO.them(nv) ) {
            list_NV.add(nv);
        }
        return false;
    }

    public Boolean xoa(SupplierDTO nv) throws Exception {
        if ( nvDAO.xoa(nv) ) {
            
            // duyệt từng phẩn tử
            for ( SupplierDTO nhanvien : list_NV ) {
                if (nhanvien.getCodeSupplier()== nv.getCodeSupplier()){
                    list_NV.remove(nhanvien);
                break;
                }
            }
        }
        
        return false;
    }

    public Boolean sua(SupplierDTO nv) throws Exception {
        if ( nvDAO.sua(nv) ) {
            
            // duyệt từng phẩn tử
            for ( SupplierDTO nhanvien : list_NV ) {
                if (nhanvien.getCodeSupplier() == nv.getCodeSupplier()){
                    nhanvien = nv;
                    return true;
                }
            }
        }
        
        return false;
    }
        
}
