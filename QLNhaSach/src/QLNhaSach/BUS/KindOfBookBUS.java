package QLNhaSach.BUS;

import QLNhaSach.DAO.KindOfBookDAO;
import QLNhaSach.DTO.KindOfBookDTO;
import java.util.ArrayList;

public class KindOfBookBUS {
    private ArrayList <KindOfBookDTO> list_Loai;
    private KindOfBookDAO LDAO;
    
    public KindOfBookBUS() throws Exception {
        list_Loai = new ArrayList<>();
        LDAO = new KindOfBookDAO();
        list_Loai = LDAO.docDB();
    }

    public ArrayList<KindOfBookDTO> getList_Loai() {
        return list_Loai;
    }

    public void setList_Loai(ArrayList<KindOfBookDTO> list_Loai) {
        this.list_Loai = list_Loai;
    }
    public int getNumbLoai() {
        return list_Loai.size();
    }
}

