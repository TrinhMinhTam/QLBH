package QLNhaSach.BUS;

import QLNhaSach.DAO.StaffDAO;
import QLNhaSach.DTO.StaffDTO;
import java.util.ArrayList;



public class StaffBUS {
     private ArrayList<StaffDTO> list_NV;
    private StaffDAO nvDAO;
    
    public StaffBUS() throws Exception {
        list_NV = new ArrayList<>();
        nvDAO = new StaffDAO();
        list_NV = nvDAO.docDB();
    }

    public Boolean them(StaffDTO nv) throws Exception{
        if ( nvDAO.them(nv) ) {
            list_NV.add(nv);
        }
        return false;
    }

    public Boolean xoa(StaffDTO nv) throws Exception {
        if ( nvDAO.xoa(nv) ) {
            for ( StaffDTO nhanvien : list_NV ) {
                if (nhanvien.getCodeStaff()== nv.getCodeStaff()){
                    list_NV.remove(nhanvien);
                break;
                }
            }
        }
        
        return false;
    }

    public Boolean sua(StaffDTO nv) throws Exception {
        if ( nvDAO.sua(nv) ) {
            
            // duyệt từng phẩn tử
            for ( StaffDTO nhanvien : list_NV ) {
                if (nhanvien.getCodeStaff()== nv.getCodeStaff()){
                break;
                }
            }
        }
        
        return false;
    }
    
    public StaffDTO getNhanVien_MaNV(String CodeStaff) {
        for ( StaffDTO nhanvien : list_NV ) {
            if (nhanvien.getCodeStaff().equals(CodeStaff)) {
                return nhanvien;
            }
        }
        return null;
    }
        
}
