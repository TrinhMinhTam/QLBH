package QLNhaSach.BUS;

import QLNhaSach.DAO.DetailBillDAO;
import QLNhaSach.DTO.DetailBillDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DetailBillBUS {
    private ArrayList<DetailBillDTO> list_AC;
    private DetailBillDAO acDAO;
    
    public DetailBillBUS() throws Exception {
        list_AC = new ArrayList<>();
         acDAO= new DetailBillDAO();
        list_AC = acDAO.docDB();
    }

    public Boolean Add(DetailBillDTO ac) throws Exception{
        if ( acDAO.Add(ac) ) {
            list_AC.add(ac);
        }
        return false;
    }

    public Boolean Delete(DetailBillDTO ac) throws Exception {
        if ( acDAO.Delete(ac) ) {
            
            // duyệt từng phẩn tử
            for ( DetailBillDTO account : list_AC ) {
                if (account.getCodeBill().equals(ac.getCodeBill())){
                    list_AC.remove(account);
                break;
                }
            }
        }
        
        return false;
    }

    public Boolean Fix(DetailBillDTO ac) throws Exception {
        if ( acDAO.Fix(ac) ) {
            for ( DetailBillDTO account : list_AC ) {
                if (account.getCodeBill().equals(account.getCodeBill())){
                break;
                }
            }
        }
        
        return false;
    }
}
