package QLNhaSach.GUI;

import QLNhaSach.Excel.NCCExcel;
import QLNhaSach.Excel.KhachHangExcel;
import QLNhaSach.Excel.HoaDonExcel;
import QLNhaSach.Excel.SachExcel;
import QLNhaSach.Excel.TaiKhoanExcel;
import QLNhaSach.Excel.SaleExcel;
import QLNhaSach.Excel.NhapHangExcel;
import QLNhaSach.PDF.HoaDonPDF;
import QLNhaSach.PDF.KhachHangPDF;
import QLNhaSach.PDF.NCCPDF;
import QLNhaSach.PDF.NhapHangPDF;
import QLNhaSach.PDF.SachPDF;
import QLNhaSach.PDF.TaiKhoanPDF;
import QLNhaSach.PDF.KhuyenMaiPDF;
import javax.swing.JFrame;
import QLNhaSach.DAO.*;
import QLNhaSach.DTO.*;
import QLNhaSach.DTO.AccountDTO;
import QLNhaSach.BUS.*;
import com.itextpdf.text.DocumentException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.CardLayout;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Mainboard extends javax.swing.JFrame {
    MyConnectUnitDAO connect;
    LocalDate nowdate = LocalDate.now();
    int yearnow = nowdate.getYear();
    int monthnow = nowdate.getMonthValue();
    int daynow = nowdate.getDayOfMonth();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    SimpleDateFormat dateFormatFull = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssX");
    Date datechange = dateFormat.parse(yearnow + "-" + monthnow + "-" + daynow);
    
    Controller ctrler = new Controller();
    AccountDAO accdao = new AccountDAO();
    StaffDAO stfdao = new StaffDAO();
    AccountDTO accdto = new AccountDTO();
    StaffDTO stfdto = new StaffDTO();   
    TaiKhoanExcel tkexcel = new TaiKhoanExcel(); 
    BookDTO bookdto = new BookDTO();
    BookDAO bookdao = new BookDAO();
    SupplierDTO splydto = new SupplierDTO();
    SupplierDAO splydao = new SupplierDAO();
    ImportCouponDTO nhdto = new ImportCouponDTO();
    ImportCouponDAO nhdao = new ImportCouponDAO();
    NhapHangExcel nhexcel = new NhapHangExcel();
    DetailImportCouponDTO nhctdto = new DetailImportCouponDTO();
    DetailImportCouponDAO nhctdao = new DetailImportCouponDAO();
    NCCExcel nccexcel = new NCCExcel(); 
    KindOfBookDTO kobdto = new KindOfBookDTO();
    SachExcel sachexcel = new SachExcel();
    CustomerDTO ctdto = new CustomerDTO();
    CustomerDAO ctdao = new CustomerDAO();
    KhachHangExcel khexcel = new KhachHangExcel();
    SaleDTO saledtdto = new SaleDTO();
    SaleDAO saledtdao = new SaleDAO();
    DetailSaleDTO saledto = new DetailSaleDTO();
    DetailSaleDAO saledao = new DetailSaleDAO();
    SaleExcel saleexcel = new SaleExcel();
    BillDTO billdto = new BillDTO();
    BillDAO billdao = new BillDAO();
    DetailBillDTO billdtdto = new DetailBillDTO();
    DetailBillDAO bildtdao = new DetailBillDAO();
    DangNhap dn = new DangNhap();
    HoaDonExcel billexcel = new HoaDonExcel();    
    
    HoaDonPDF billpdf = new HoaDonPDF();
    KhachHangPDF customerpdf = new KhachHangPDF();
    NCCPDF nccpdf = new NCCPDF();
    NhapHangPDF nhaphangpdf = new NhapHangPDF();
    SachPDF sachpdf = new SachPDF();
    TaiKhoanPDF taikhoanpdf = new TaiKhoanPDF();
    KhuyenMaiPDF khuyenmaipdf = new KhuyenMaiPDF();
    //MainPanel mainpanel = new MainPanel();
    CardLayout cardLayout;
    List<String> loaisachlist = new ArrayList<String>(); 
    
    Tester tester = new Tester();
    String table = "tbltaikhoan";
    String tablenv = "nhanvien";
    String tablesach = "sach";
    String tablencc = "nhacungcap";
    String tablenh = "phieunhaphang";
    String tablenhct = "chitietphieunhap";
    String tablekh = "khachhang";
    String tablesale = "khuyenmai";
    String tablesalect = "chitietkhuyenmai";
    String tablehoadon = "hoadon";
    String tablehoadonct = "chitiethoadon";
    JFrame frame;
    
    public Mainboard() throws SQLException, Exception {
        initComponents() ;
        cardLayout = (CardLayout)(ContentTab.getLayout());      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        DanhMucWrapper = new javax.swing.JPanel();
        MainTitle = new javax.swing.JButton();
        TaiKhoanTitle = new javax.swing.JButton();
        SachTitle = new javax.swing.JButton();
        NhapHangTitle = new javax.swing.JButton();
        NCCTitle = new javax.swing.JButton();
        HoaDonTitle = new javax.swing.JButton();
        SaleTitle = new javax.swing.JButton();
        KhachHangTitle = new javax.swing.JButton();
        HoaDonTitle1 = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        ContentTab = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        TKContent3 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        HDTab = new javax.swing.JButton();
        TKTab = new javax.swing.JButton();
        KMTab = new javax.swing.JButton();
        TaiKhoanTab = new javax.swing.JButton();
        SachTab = new javax.swing.JButton();
        NhapKhoTab = new javax.swing.JButton();
        NCCTab = new javax.swing.JButton();
        KHTab = new javax.swing.JButton();
        ThongKePanel = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        TKContent4 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        thongketbl = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        thongkefromdate = new com.toedter.calendar.JDateChooser();
        thongketodate = new com.toedter.calendar.JDateChooser();
        jPanel37 = new javax.swing.JPanel();
        thongketimkiemfield = new javax.swing.JTextField();
        thongketimkiembtn = new javax.swing.JButton();
        thongketbn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        tongthanhtienlbl = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        tonghoadonlbl = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        bqsplbl = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        bqhdlbl = new javax.swing.JLabel();
        HoaDonPanel = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        TKContent2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        hdtbl1 = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        hdaddbtn = new javax.swing.JButton();
        hddeletebtn = new javax.swing.JButton();
        hdexcelwritebtn = new javax.swing.JButton();
        hdexcelreadbtn = new javax.swing.JButton();
        hdpdfbtn = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        hdid = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        hdsoluong = new javax.swing.JTextField();
        hdaddlistbtn = new javax.swing.JButton();
        hdngaylap = new com.toedter.calendar.JDateChooser();
        hdsach = new javax.swing.JComboBox<>();
        hdnhanvien = new javax.swing.JComboBox<>();
        hdkhachhang = new javax.swing.JComboBox<>();
        jPanel29 = new javax.swing.JPanel();
        hdtimkiemfield = new javax.swing.JTextField();
        hdtimkiembtn = new javax.swing.JButton();
        hdresetbtn = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        hdtbl2 = new javax.swing.JTable();
        KhuyenMaiPanel = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        TKContent1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        kmtbl = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        kmaddbtn = new javax.swing.JButton();
        kmeditbtn = new javax.swing.JButton();
        kmdeletebtn = new javax.swing.JButton();
        kmexcelwritebtn = new javax.swing.JButton();
        kmexcelreadbtn = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        kmid = new javax.swing.JTextField();
        kmname = new javax.swing.JTextField();
        kmphantram = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        kmngaybatdau = new com.toedter.calendar.JDateChooser();
        kmloaisach = new javax.swing.JComboBox<>();
        kmngayketthuc = new com.toedter.calendar.JDateChooser();
        jPanel25 = new javax.swing.JPanel();
        kmtimkiemfield = new javax.swing.JTextField();
        kmtimkiembtn = new javax.swing.JButton();
        kmresetbtn = new javax.swing.JButton();
        salepdfbtn = new javax.swing.JButton();
        TaiKhoanPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        TKContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tktbl1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tkaddbtn = new javax.swing.JButton();
        tkeditbtn = new javax.swing.JButton();
        tkdeletebtn = new javax.swing.JButton();
        tkexcelwritebtn = new javax.swing.JButton();
        tkexcelreadbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tkid = new javax.swing.JTextField();
        tkaddusername = new javax.swing.JTextField();
        tkaddpassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tkho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tkten = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tkemail = new javax.swing.JTextField();
        tkluong = new javax.swing.JTextField();
        tkaddpower = new javax.swing.JComboBox<>();
        tkngaysinh = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        tktimkiemfield = new javax.swing.JTextField();
        tktimkiembtn = new javax.swing.JButton();
        tkresetbtn = new javax.swing.JButton();
        taikhoanpdfbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tktbl2 = new javax.swing.JTable();
        SachPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        SachContent = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sachtbl = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        sachaddbtn = new javax.swing.JButton();
        sacheditbtn = new javax.swing.JButton();
        sachdeletebtn = new javax.swing.JButton();
        sachexcelwritebtn = new javax.swing.JButton();
        sachexcelreadbtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        sachid = new javax.swing.JTextField();
        sachname = new javax.swing.JTextField();
        sachtacgia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        sachdongia = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        sachsoluong = new javax.swing.JTextField();
        sachloai = new javax.swing.JComboBox<>();
        sachnxb = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        sachtimkiemfield = new javax.swing.JTextField();
        sachtimkiembtn = new javax.swing.JButton();
        sachresetbtn = new javax.swing.JButton();
        sachpdfbtn = new javax.swing.JButton();
        NhapHangPanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        SachContent1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        nhtbl = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        nhaddbtn = new javax.swing.JButton();
        nhexcelwritebtn = new javax.swing.JButton();
        nhexcelreadbtn = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        nhid = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nhsoluong = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        nhngaynhap = new com.toedter.calendar.JDateChooser();
        nhnxb = new javax.swing.JComboBox<>();
        nhsach = new javax.swing.JComboBox<>();
        nhnhanvien = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        nhtimkiemfield = new javax.swing.JTextField();
        nhtimkiembtn = new javax.swing.JButton();
        nhresetbtn = new javax.swing.JButton();
        nhaphangpdfbtn = new javax.swing.JButton();
        NCCPanel = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        SachContent2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ncctbl = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        nccaddbtn = new javax.swing.JButton();
        ncceditbtn = new javax.swing.JButton();
        nccdeletebtn = new javax.swing.JButton();
        nccexcelwritebtn = new javax.swing.JButton();
        nccexcelreadbtn = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        nccid = new javax.swing.JTextField();
        nccname = new javax.swing.JTextField();
        nccdiachi = new javax.swing.JTextField();
        nccsdt = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        ncctimkiemfield = new javax.swing.JTextField();
        ncctimkiembtn = new javax.swing.JButton();
        nccresetbtn = new javax.swing.JButton();
        nccpdfbtn = new javax.swing.JButton();
        KhachHangPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        SachContent3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        khtbl = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        khaddbtn = new javax.swing.JButton();
        kheditbtn = new javax.swing.JButton();
        khdeletebtn = new javax.swing.JButton();
        khexcelwritebtn = new javax.swing.JButton();
        khexcelreadbtn1 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        khid = new javax.swing.JTextField();
        khho = new javax.swing.JTextField();
        khten = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        khsdt = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        khemail = new javax.swing.JTextField();
        khdiachi = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        khtimkiemfield = new javax.swing.JTextField();
        khtimkiembtn = new javax.swing.JButton();
        khresetbtn = new javax.swing.JButton();
        khpdfbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1280, 720));

        DanhMucWrapper.setBackground(new java.awt.Color(51, 51, 51));
        DanhMucWrapper.setForeground(new java.awt.Color(255, 153, 0));
        DanhMucWrapper.setMaximumSize(new java.awt.Dimension(300, 720));
        DanhMucWrapper.setPreferredSize(new java.awt.Dimension(300, 720));

        MainTitle.setBackground(new java.awt.Color(255, 204, 102));
        MainTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MainTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_home_30px.png"))); // NOI18N
        MainTitle.setText("MÀN HÌNH CHÍNH");
        MainTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainTitleActionPerformed(evt);
            }
        });

        TaiKhoanTitle.setBackground(new java.awt.Color(255, 204, 102));
        TaiKhoanTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TaiKhoanTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_user_32px_3.png"))); // NOI18N
        TaiKhoanTitle.setText("THÀNH VIÊN");
        TaiKhoanTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TaiKhoanTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiKhoanTitleActionPerformed(evt);
            }
        });

        SachTitle.setBackground(new java.awt.Color(255, 204, 102));
        SachTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SachTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_book_32px.png"))); // NOI18N
        SachTitle.setText("SÁCH");
        SachTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SachTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SachTitleActionPerformed(evt);
            }
        });

        NhapHangTitle.setBackground(new java.awt.Color(255, 204, 102));
        NhapHangTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NhapHangTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_hangar_24px.png"))); // NOI18N
        NhapHangTitle.setText("NHẬP KHO");
        NhapHangTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NhapHangTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhapHangTitleActionPerformed(evt);
            }
        });

        NCCTitle.setBackground(new java.awt.Color(255, 204, 102));
        NCCTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NCCTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_supplier_24px.png"))); // NOI18N
        NCCTitle.setText("NHÀ CUNG CẤP");
        NCCTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NCCTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NCCTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCCTitleActionPerformed(evt);
            }
        });

        HoaDonTitle.setBackground(new java.awt.Color(255, 204, 102));
        HoaDonTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HoaDonTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_receipt_and_change_24px.png"))); // NOI18N
        HoaDonTitle.setText("HÓA ĐƠN");
        HoaDonTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HoaDonTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonTitleActionPerformed(evt);
            }
        });

        SaleTitle.setBackground(new java.awt.Color(255, 204, 102));
        SaleTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SaleTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_price_tag_30px_1.png"))); // NOI18N
        SaleTitle.setText("KHUYẾN MÃI");
        SaleTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SaleTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleTitleActionPerformed(evt);
            }
        });

        KhachHangTitle.setBackground(new java.awt.Color(255, 204, 102));
        KhachHangTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        KhachHangTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_search_client_32px.png"))); // NOI18N
        KhachHangTitle.setText("KHÁCH HÀNG");
        KhachHangTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        KhachHangTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        KhachHangTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhachHangTitleActionPerformed(evt);
            }
        });

        HoaDonTitle1.setBackground(new java.awt.Color(255, 204, 102));
        HoaDonTitle1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HoaDonTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_pie_chart_report_32px.png"))); // NOI18N
        HoaDonTitle1.setText("THỐNG KÊ");
        HoaDonTitle1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HoaDonTitle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonTitle1ActionPerformed(evt);
            }
        });

        exitbtn.setBackground(new java.awt.Color(255, 255, 255));
        exitbtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLNhaSach/GUI/icons8_Logout_24px.png"))); // NOI18N
        exitbtn.setText("Đăng xuất");
        exitbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exitbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Quản Lý Cửa Hàng Sách");
        jLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout DanhMucWrapperLayout = new javax.swing.GroupLayout(DanhMucWrapper);
        DanhMucWrapper.setLayout(DanhMucWrapperLayout);
        DanhMucWrapperLayout.setHorizontalGroup(
            DanhMucWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhMucWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DanhMucWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(TaiKhoanTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(MainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SachTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(NhapHangTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(NCCTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(HoaDonTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SaleTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KhachHangTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(HoaDonTitle1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DanhMucWrapperLayout.setVerticalGroup(
            DanhMucWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhMucWrapperLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(HoaDonTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(HoaDonTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SaleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TaiKhoanTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SachTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(NhapHangTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(NCCTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(KhachHangTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(DanhMucWrapper);

        ContentTab.setBackground(new java.awt.Color(204, 204, 204));
        ContentTab.setMaximumSize(new java.awt.Dimension(980, 720));
        ContentTab.setPreferredSize(new java.awt.Dimension(980, 720));
        ContentTab.setLayout(new java.awt.CardLayout());

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        MainPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel32.setBackground(new java.awt.Color(51, 51, 51));
        jPanel32.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel67.setBackground(new java.awt.Color(51, 51, 51));
        jLabel67.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Xin chào, Admin");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addContainerGap())
        );

        TKContent3.setBackground(new java.awt.Color(255, 255, 255));
        TKContent3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TKContent3.setMaximumSize(new java.awt.Dimension(980, 680));
        TKContent3.setPreferredSize(new java.awt.Dimension(985, 680));

        jLabel78.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel78.setText("Danh Sách Chức Năng");

        HDTab.setBackground(new java.awt.Color(255, 204, 102));
        HDTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HDTab.setText("HÓA ĐƠN");
        HDTab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HDTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDTabActionPerformed(evt);
            }
        });

        TKTab.setBackground(new java.awt.Color(255, 204, 102));
        TKTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TKTab.setText("THỐNG KÊ");
        TKTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKTabActionPerformed(evt);
            }
        });

        KMTab.setBackground(new java.awt.Color(255, 204, 102));
        KMTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        KMTab.setText("KHUYẾN MÃI");
        KMTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KMTabActionPerformed(evt);
            }
        });

        TaiKhoanTab.setBackground(new java.awt.Color(255, 204, 102));
        TaiKhoanTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TaiKhoanTab.setText("TÀI KHOẢN");
        TaiKhoanTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiKhoanTabActionPerformed(evt);
            }
        });

        SachTab.setBackground(new java.awt.Color(255, 204, 102));
        SachTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SachTab.setText("SÁCH");
        SachTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SachTabActionPerformed(evt);
            }
        });

        NhapKhoTab.setBackground(new java.awt.Color(255, 204, 102));
        NhapKhoTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NhapKhoTab.setText("NHẬP KHO");
        NhapKhoTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhapKhoTabActionPerformed(evt);
            }
        });

        NCCTab.setBackground(new java.awt.Color(255, 204, 102));
        NCCTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NCCTab.setText("NHÀ CUNG CẤP");
        NCCTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCCTabActionPerformed(evt);
            }
        });

        KHTab.setBackground(new java.awt.Color(255, 204, 102));
        KHTab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        KHTab.setText("KHÁCH HÀNG");
        KHTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KHTabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TKContent3Layout = new javax.swing.GroupLayout(TKContent3);
        TKContent3.setLayout(TKContent3Layout);
        TKContent3Layout.setHorizontalGroup(
            TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContent3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TKContent3Layout.createSequentialGroup()
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TKContent3Layout.createSequentialGroup()
                        .addGroup(TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HDTab, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(SachTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TKTab, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(NhapKhoTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KMTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NCCTab, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TaiKhoanTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KHTab, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addGap(37, 37, 37))))
        );
        TKContent3Layout.setVerticalGroup(
            TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContent3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TaiKhoanTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KMTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HDTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TKTab, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(TKContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KHTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NCCTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SachTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NhapKhoTab, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(TKContent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TKContent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(MainPanel, "maincard");

        ThongKePanel.setBackground(new java.awt.Color(255, 255, 255));
        ThongKePanel.setMaximumSize(new java.awt.Dimension(980, 720));
        ThongKePanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel33.setBackground(new java.awt.Color(102, 102, 102));
        jPanel33.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel79.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Thống Kê Hóa Đơn");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel79)
                .addContainerGap())
        );

        TKContent4.setBackground(new java.awt.Color(255, 255, 255));
        TKContent4.setForeground(new java.awt.Color(255, 255, 255));
        TKContent4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TKContent4.setMaximumSize(new java.awt.Dimension(980, 680));
        TKContent4.setPreferredSize(new java.awt.Dimension(985, 680));

        thongketbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        thongketbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        thongketbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongketblMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(thongketbl);
        if (thongketbl.getColumnModel().getColumnCount() > 0) {
            thongketbl.getColumnModel().getColumn(0).setResizable(false);
            thongketbl.getColumnModel().getColumn(1).setResizable(false);
            thongketbl.getColumnModel().getColumn(2).setResizable(false);
            thongketbl.getColumnModel().getColumn(3).setResizable(false);
            thongketbl.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        thongkefromdate.setBackground(new java.awt.Color(255, 255, 255));
        thongkefromdate.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ ngày"));

        thongketodate.setBackground(new java.awt.Color(255, 255, 255));
        thongketodate.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến ngày"));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm thống kê hóa đơn"));

        thongketimkiemfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongketimkiemfieldActionPerformed(evt);
            }
        });

        thongketimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        thongketimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        thongketimkiembtn.setText("Tìm Kiếm");
        thongketimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongketimkiembtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(thongketimkiemfield)
                .addGap(18, 18, 18)
                .addComponent(thongketimkiembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thongketimkiemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thongketimkiembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        thongketbn.setBackground(new java.awt.Color(255, 204, 102));
        thongketbn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        thongketbn.setText("Thống Kê");
        thongketbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongketbnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(thongkefromdate, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thongketodate, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongketbn, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
            .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thongketodate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thongkefromdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(thongketbn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel80.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel80.setText("Tổng Thành Tiền:");

        tongthanhtienlbl.setBackground(new java.awt.Color(255, 204, 102));
        tongthanhtienlbl.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tongthanhtienlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tongthanhtienlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPanel34.setBackground(new java.awt.Color(255, 204, 102));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel81.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel81.setText("Tổng Hóa Đơn:");

        tonghoadonlbl.setBackground(new java.awt.Color(255, 204, 102));
        tonghoadonlbl.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tonghoadonlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tonghoadonlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPanel38.setBackground(new java.awt.Color(255, 204, 102));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel83.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel83.setText("Bình Quân SP: ");

        bqsplbl.setBackground(new java.awt.Color(255, 204, 102));
        bqsplbl.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bqsplbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bqsplbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPanel39.setBackground(new java.awt.Color(255, 204, 102));
        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel82.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel82.setText("Bình Quân HĐ: ");

        bqhdlbl.setBackground(new java.awt.Color(255, 204, 102));
        bqhdlbl.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bqhdlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bqhdlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout TKContent4Layout = new javax.swing.GroupLayout(TKContent4);
        TKContent4.setLayout(TKContent4Layout);
        TKContent4Layout.setHorizontalGroup(
            TKContent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContent4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TKContent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TKContent4Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TKContent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(TKContent4Layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        TKContent4Layout.setVerticalGroup(
            TKContent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContent4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TKContent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TKContent4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ThongKePanelLayout = new javax.swing.GroupLayout(ThongKePanel);
        ThongKePanel.setLayout(ThongKePanelLayout);
        ThongKePanelLayout.setHorizontalGroup(
            ThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKePanelLayout.createSequentialGroup()
                .addComponent(TKContent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        ThongKePanelLayout.setVerticalGroup(
            ThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKePanelLayout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TKContent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(ThongKePanel, "thongkecard");

        HoaDonPanel.setBackground(new java.awt.Color(255, 255, 255));
        HoaDonPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        HoaDonPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel26.setBackground(new java.awt.Color(102, 102, 102));
        jPanel26.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel53.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Hóa Đơn");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel53)
                .addContainerGap())
        );

        TKContent2.setBackground(new java.awt.Color(255, 255, 255));
        TKContent2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TKContent2.setMaximumSize(new java.awt.Dimension(980, 680));
        TKContent2.setPreferredSize(new java.awt.Dimension(985, 680));

        hdtbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hdtbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hdtbl1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(hdtbl1);
        if (hdtbl1.getColumnModel().getColumnCount() > 0) {
            hdtbl1.getColumnModel().getColumn(0).setResizable(false);
            hdtbl1.getColumnModel().getColumn(1).setResizable(false);
            hdtbl1.getColumnModel().getColumn(2).setResizable(false);
            hdtbl1.getColumnModel().getColumn(3).setResizable(false);
            hdtbl1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        hdaddbtn.setBackground(new java.awt.Color(255, 204, 102));
        hdaddbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hdaddbtn.setText("Thêm");
        hdaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdaddbtnActionPerformed(evt);
            }
        });

        hddeletebtn.setBackground(new java.awt.Color(255, 204, 102));
        hddeletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hddeletebtn.setText("Xóa");
        hddeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hddeletebtnActionPerformed(evt);
            }
        });

        hdexcelwritebtn.setBackground(new java.awt.Color(255, 204, 102));
        hdexcelwritebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hdexcelwritebtn.setText("Ghi Excel");
        hdexcelwritebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdexcelwritebtnActionPerformed(evt);
            }
        });

        hdexcelreadbtn.setBackground(new java.awt.Color(255, 204, 102));
        hdexcelreadbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hdexcelreadbtn.setText("Đọc Excel");
        hdexcelreadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdexcelreadbtnActionPerformed(evt);
            }
        });

        hdpdfbtn.setBackground(new java.awt.Color(255, 204, 102));
        hdpdfbtn.setText("In PDF");
        hdpdfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdpdfbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hdaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hddeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hdexcelwritebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hdexcelreadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hdpdfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(hdpdfbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(hdexcelreadbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(hddeletebtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hdaddbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hdexcelwritebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel58.setBackground(new java.awt.Color(153, 153, 255));
        jLabel58.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel58.setText("Mã HĐ");

        jLabel60.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel60.setText("Nhân Viên");

        jLabel61.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel61.setText("Khách Hàng");

        hdid.setEditable(false);

        jLabel63.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel63.setText("Ngày Lập");

        jLabel65.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel65.setText("Sách");

        jLabel66.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel66.setText("Số Lượng");

        hdaddlistbtn.setBackground(new java.awt.Color(255, 204, 102));
        hdaddlistbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hdaddlistbtn.setText("Thêm Vào Hóa Đơn");
        hdaddlistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdaddlistbtnActionPerformed(evt);
            }
        });

        hdngaylap.setEnabled(false);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(hdid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hdnhanvien, 0, 350, Short.MAX_VALUE)
                    .addComponent(hdkhachhang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hdngaylap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hdsach, 0, 425, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hdaddlistbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hdsoluong))))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hdid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hdsach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(hdnhanvien)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hdsoluong))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hdkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hdaddlistbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hdngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        hdtimkiemfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdtimkiemfieldActionPerformed(evt);
            }
        });

        hdtimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        hdtimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hdtimkiembtn.setText("Tìm Kiếm");
        hdtimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdtimkiembtnActionPerformed(evt);
            }
        });

        hdresetbtn.setBackground(new java.awt.Color(255, 204, 102));
        hdresetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hdresetbtn.setText("Reset");
        hdresetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdresetbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hdtimkiemfield)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hdtimkiembtn)
                .addGap(11, 11, 11)
                .addComponent(hdresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hdresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hdtimkiemfield)
                    .addComponent(hdtimkiembtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        hdtbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Sách", "Đơn Giá", "Số Lượng", "Giảm Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hdtbl2.setRowSelectionAllowed(false);
        jScrollPane9.setViewportView(hdtbl2);
        if (hdtbl2.getColumnModel().getColumnCount() > 0) {
            hdtbl2.getColumnModel().getColumn(0).setResizable(false);
            hdtbl2.getColumnModel().getColumn(1).setResizable(false);
            hdtbl2.getColumnModel().getColumn(2).setResizable(false);
            hdtbl2.getColumnModel().getColumn(3).setResizable(false);
            hdtbl2.getColumnModel().getColumn(4).setResizable(false);
            hdtbl2.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout TKContent2Layout = new javax.swing.GroupLayout(TKContent2);
        TKContent2.setLayout(TKContent2Layout);
        TKContent2Layout.setHorizontalGroup(
            TKContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TKContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TKContent2Layout.createSequentialGroup()
                        .addGroup(TKContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane8)
                            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(TKContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))))
        );
        TKContent2Layout.setVerticalGroup(
            TKContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TKContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TKContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HoaDonPanelLayout = new javax.swing.GroupLayout(HoaDonPanel);
        HoaDonPanel.setLayout(HoaDonPanelLayout);
        HoaDonPanelLayout.setHorizontalGroup(
            HoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonPanelLayout.createSequentialGroup()
                .addComponent(TKContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        HoaDonPanelLayout.setVerticalGroup(
            HoaDonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonPanelLayout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TKContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(HoaDonPanel, "hdcard");

        KhuyenMaiPanel.setBackground(new java.awt.Color(255, 255, 255));
        KhuyenMaiPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        KhuyenMaiPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel22.setBackground(new java.awt.Color(102, 102, 102));
        jPanel22.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel44.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Khuyến Mãi");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
        );

        TKContent1.setBackground(new java.awt.Color(255, 255, 255));
        TKContent1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TKContent1.setMaximumSize(new java.awt.Dimension(980, 680));
        TKContent1.setPreferredSize(new java.awt.Dimension(985, 680));

        kmtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khuyến Mãi", "Mã Loại", "Phần Trăm Giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kmtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kmtblMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(kmtbl);
        if (kmtbl.getColumnModel().getColumnCount() > 0) {
            kmtbl.getColumnModel().getColumn(0).setResizable(false);
            kmtbl.getColumnModel().getColumn(1).setResizable(false);
            kmtbl.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        kmaddbtn.setBackground(new java.awt.Color(255, 204, 102));
        kmaddbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kmaddbtn.setText("Thêm");
        kmaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmaddbtnActionPerformed(evt);
            }
        });

        kmeditbtn.setBackground(new java.awt.Color(255, 204, 102));
        kmeditbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kmeditbtn.setText("Sửa");
        kmeditbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeditbtnActionPerformed(evt);
            }
        });

        kmdeletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kmdeletebtn.setText("Xóa");
        kmdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmdeletebtnActionPerformed(evt);
            }
        });

        kmexcelwritebtn.setBackground(new java.awt.Color(255, 204, 102));
        kmexcelwritebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kmexcelwritebtn.setText("Ghi Excel");
        kmexcelwritebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmexcelwritebtnActionPerformed(evt);
            }
        });

        kmexcelreadbtn.setBackground(new java.awt.Color(255, 204, 102));
        kmexcelreadbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kmexcelreadbtn.setText("Đọc Excel");
        kmexcelreadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmexcelreadbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kmaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kmeditbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kmdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kmexcelwritebtn)
                .addGap(18, 18, 18)
                .addComponent(kmexcelreadbtn))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kmexcelreadbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(kmexcelwritebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kmaddbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kmeditbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kmdeletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khuyến mãi"));

        jLabel50.setBackground(new java.awt.Color(153, 153, 255));
        jLabel50.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel50.setText("Mã KM");

        jLabel51.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel51.setText("Tên KM");

        jLabel52.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel52.setText("% Giảm");

        kmid.setEditable(false);

        kmname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmnameActionPerformed(evt);
            }
        });

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel54.setText("Thể Loại");

        jLabel56.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel56.setText("Ngày BĐ");

        jLabel57.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel57.setText("Ngày KT");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kmname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(kmid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kmphantram))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kmngaybatdau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addComponent(kmngayketthuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kmloaisach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kmid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kmloaisach))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kmname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kmngaybatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kmphantram, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kmngayketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        kmtimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        kmtimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kmtimkiembtn.setText("Tìm Kiếm");
        kmtimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmtimkiembtnActionPerformed(evt);
            }
        });

        kmresetbtn.setBackground(new java.awt.Color(255, 204, 102));
        kmresetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kmresetbtn.setText("Reset");
        kmresetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmresetbtnActionPerformed(evt);
            }
        });

        salepdfbtn.setBackground(new java.awt.Color(255, 204, 102));
        salepdfbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        salepdfbtn.setText("In PDF");
        salepdfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salepdfbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kmtimkiemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(kmtimkiembtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kmresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salepdfbtn)
                .addGap(19, 19, 19))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kmtimkiemfield)
                    .addComponent(kmresetbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kmtimkiembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salepdfbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout TKContent1Layout = new javax.swing.GroupLayout(TKContent1);
        TKContent1.setLayout(TKContent1Layout);
        TKContent1Layout.setHorizontalGroup(
            TKContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TKContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TKContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TKContent1Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        TKContent1Layout.setVerticalGroup(
            TKContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TKContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout KhuyenMaiPanelLayout = new javax.swing.GroupLayout(KhuyenMaiPanel);
        KhuyenMaiPanel.setLayout(KhuyenMaiPanelLayout);
        KhuyenMaiPanelLayout.setHorizontalGroup(
            KhuyenMaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiPanelLayout.createSequentialGroup()
                .addComponent(TKContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        KhuyenMaiPanelLayout.setVerticalGroup(
            KhuyenMaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiPanelLayout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TKContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(KhuyenMaiPanel, "kmcard");

        TaiKhoanPanel.setBackground(new java.awt.Color(255, 255, 255));
        TaiKhoanPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        TaiKhoanPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thành Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        TKContent.setBackground(new java.awt.Color(255, 255, 255));
        TKContent.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TKContent.setMaximumSize(new java.awt.Dimension(980, 680));
        TKContent.setPreferredSize(new java.awt.Dimension(985, 680));

        tktbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Tài Khoản", "Mật Khẩu", "Cấp Bậc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tktbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tktbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tktbl1);
        if (tktbl1.getColumnModel().getColumnCount() > 0) {
            tktbl1.getColumnModel().getColumn(0).setResizable(false);
            tktbl1.getColumnModel().getColumn(1).setResizable(false);
            tktbl1.getColumnModel().getColumn(2).setResizable(false);
            tktbl1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        tkaddbtn.setBackground(new java.awt.Color(255, 204, 102));
        tkaddbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tkaddbtn.setText("Thêm");
        tkaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkaddbtnActionPerformed(evt);
            }
        });

        tkeditbtn.setBackground(new java.awt.Color(255, 204, 102));
        tkeditbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tkeditbtn.setText("Sửa");
        tkeditbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkeditbtnActionPerformed(evt);
            }
        });

        tkdeletebtn.setBackground(new java.awt.Color(255, 204, 102));
        tkdeletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tkdeletebtn.setText("Xóa");
        tkdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkdeletebtnActionPerformed(evt);
            }
        });

        tkexcelwritebtn.setBackground(new java.awt.Color(255, 204, 102));
        tkexcelwritebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tkexcelwritebtn.setText("Ghi Excel");
        tkexcelwritebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkexcelwritebtnActionPerformed(evt);
            }
        });

        tkexcelreadbtn.setBackground(new java.awt.Color(255, 204, 102));
        tkexcelreadbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tkexcelreadbtn.setText("Đọc Excel");
        tkexcelreadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkexcelreadbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tkaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tkeditbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(tkdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tkexcelwritebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tkexcelreadbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tkaddbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tkexcelreadbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tkexcelwritebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tkeditbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tkdeletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Tài khoản"));

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Chức Vụ");

        tkid.setEditable(false);

        tkaddusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkaddusernameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Họ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Tên");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Ngày Sinh");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Email");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Lương");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tkaddusername, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tkid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tkaddpassword)
                    .addComponent(tkaddpower, 0, 350, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tkemail)
                    .addComponent(tkluong)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tkho, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tkten, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addComponent(tkngaysinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tkten)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tkid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tkho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tkaddusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tkngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tkemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tkaddpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tkluong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tkaddpower, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        tktimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        tktimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tktimkiembtn.setText("Tìm Kiếm");
        tktimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tktimkiembtnActionPerformed(evt);
            }
        });

        tkresetbtn.setBackground(new java.awt.Color(255, 204, 102));
        tkresetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tkresetbtn.setText("Reset");
        tkresetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkresetbtnActionPerformed(evt);
            }
        });

        taikhoanpdfbtn.setBackground(new java.awt.Color(255, 204, 102));
        taikhoanpdfbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        taikhoanpdfbtn.setText("In PDF");
        taikhoanpdfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taikhoanpdfbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tktimkiemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tktimkiembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tkresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taikhoanpdfbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tktimkiembtn, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(tkresetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(taikhoanpdfbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tktimkiemfield))
                .addContainerGap())
        );

        tktbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ", "Tên", "Ngày Sinh", "Email", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tktbl2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(tktbl2);
        if (tktbl2.getColumnModel().getColumnCount() > 0) {
            tktbl2.getColumnModel().getColumn(5).setHeaderValue("Lương");
        }

        javax.swing.GroupLayout TKContentLayout = new javax.swing.GroupLayout(TKContent);
        TKContent.setLayout(TKContentLayout);
        TKContentLayout.setHorizontalGroup(
            TKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TKContentLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TKContentLayout.createSequentialGroup()
                        .addGroup(TKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 478, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(TKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(26, 26, 26))))
        );
        TKContentLayout.setVerticalGroup(
            TKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TaiKhoanPanelLayout = new javax.swing.GroupLayout(TaiKhoanPanel);
        TaiKhoanPanel.setLayout(TaiKhoanPanelLayout);
        TaiKhoanPanelLayout.setHorizontalGroup(
            TaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanPanelLayout.createSequentialGroup()
                .addComponent(TKContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        TaiKhoanPanelLayout.setVerticalGroup(
            TaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TKContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(TaiKhoanPanel, "tkcard");

        SachPanel.setBackground(new java.awt.Color(255, 255, 255));
        SachPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        SachPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Sách");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        SachContent.setBackground(new java.awt.Color(255, 255, 255));
        SachContent.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SachContent.setMaximumSize(new java.awt.Dimension(980, 680));
        SachContent.setPreferredSize(new java.awt.Dimension(985, 685));

        sachtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Nhà Xuất Bản", "Mã Loại", "Tên Sách", "Tác Giả", "Đơn Giá", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sachtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sachtblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(sachtbl);
        if (sachtbl.getColumnModel().getColumnCount() > 0) {
            sachtbl.getColumnModel().getColumn(0).setResizable(false);
            sachtbl.getColumnModel().getColumn(1).setResizable(false);
            sachtbl.getColumnModel().getColumn(2).setResizable(false);
            sachtbl.getColumnModel().getColumn(3).setResizable(false);
            sachtbl.getColumnModel().getColumn(4).setResizable(false);
            sachtbl.getColumnModel().getColumn(5).setResizable(false);
            sachtbl.getColumnModel().getColumn(6).setResizable(false);
            sachtbl.getColumnModel().getColumn(6).setHeaderValue("Số Lượng");
        }

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Tháo tác"));

        sachaddbtn.setBackground(new java.awt.Color(255, 204, 102));
        sachaddbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sachaddbtn.setText("Thêm");
        sachaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachaddbtnActionPerformed(evt);
            }
        });

        sacheditbtn.setBackground(new java.awt.Color(255, 204, 102));
        sacheditbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sacheditbtn.setText("Sửa");
        sacheditbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacheditbtnActionPerformed(evt);
            }
        });

        sachdeletebtn.setBackground(new java.awt.Color(255, 204, 102));
        sachdeletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sachdeletebtn.setText("Xóa");
        sachdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachdeletebtnActionPerformed(evt);
            }
        });

        sachexcelwritebtn.setBackground(new java.awt.Color(255, 204, 102));
        sachexcelwritebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sachexcelwritebtn.setText("Ghi Excel");
        sachexcelwritebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachexcelwritebtnActionPerformed(evt);
            }
        });

        sachexcelreadbtn.setBackground(new java.awt.Color(255, 204, 102));
        sachexcelreadbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sachexcelreadbtn.setText("Đọc Excel");
        sachexcelreadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachexcelreadbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sachaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacheditbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(sachdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sachexcelwritebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sachexcelreadbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sachexcelreadbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sachaddbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sacheditbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sachdeletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sachexcelwritebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sách"));

        jLabel15.setBackground(new java.awt.Color(153, 153, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("ID");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Tên Sách");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Tác Giả");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Mã Loại");

        sachid.setEditable(false);

        sachname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachnameActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("N.Xuất Bản");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Đơn Giá");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Số Lượng");

        sachnxb.setMaximumRowCount(10);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sachname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(sachid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sachtacgia))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sachdongia)
                            .addComponent(sachsoluong)
                            .addComponent(sachnxb, javax.swing.GroupLayout.Alignment.TRAILING, 0, 432, Short.MAX_VALUE)))
                    .addComponent(sachloai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sachid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sachnxb))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sachdongia)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sachname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sachsoluong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sachtacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sachloai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        sachtimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        sachtimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sachtimkiembtn.setText("Tìm Kiếm");
        sachtimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachtimkiembtnActionPerformed(evt);
            }
        });

        sachresetbtn.setBackground(new java.awt.Color(255, 204, 102));
        sachresetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sachresetbtn.setText("Reset");
        sachresetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachresetbtnActionPerformed(evt);
            }
        });

        sachpdfbtn.setBackground(new java.awt.Color(255, 204, 102));
        sachpdfbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sachpdfbtn.setText("In PDF");
        sachpdfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachpdfbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sachtimkiemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sachtimkiembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sachresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sachpdfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sachresetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(sachtimkiembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sachpdfbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sachtimkiemfield))
                .addContainerGap())
        );

        javax.swing.GroupLayout SachContentLayout = new javax.swing.GroupLayout(SachContent);
        SachContent.setLayout(SachContentLayout);
        SachContentLayout.setHorizontalGroup(
            SachContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SachContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SachContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SachContentLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(SachContentLayout.createSequentialGroup()
                        .addGroup(SachContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SachContentLayout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))))
        );
        SachContentLayout.setVerticalGroup(
            SachContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SachContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SachContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SachPanelLayout = new javax.swing.GroupLayout(SachPanel);
        SachPanel.setLayout(SachPanelLayout);
        SachPanelLayout.setHorizontalGroup(
            SachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SachPanelLayout.createSequentialGroup()
                .addGroup(SachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                    .addGroup(SachPanelLayout.createSequentialGroup()
                        .addComponent(SachContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SachPanelLayout.setVerticalGroup(
            SachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SachPanelLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SachContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(SachPanel, "sachcard");

        NhapHangPanel.setBackground(new java.awt.Color(255, 255, 255));
        NhapHangPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        NhapHangPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nhập Hàng");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        SachContent1.setBackground(new java.awt.Color(255, 255, 255));
        SachContent1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SachContent1.setMaximumSize(new java.awt.Dimension(980, 680));
        SachContent1.setPreferredSize(new java.awt.Dimension(985, 685));

        nhtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu", "Mã Nhân Viên", "Mã Nhà Cung Cấp", "Ngày Nhập Hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nhtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhtblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(nhtbl);
        if (nhtbl.getColumnModel().getColumnCount() > 0) {
            nhtbl.getColumnModel().getColumn(0).setResizable(false);
            nhtbl.getColumnModel().getColumn(1).setResizable(false);
            nhtbl.getColumnModel().getColumn(2).setResizable(false);
            nhtbl.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        nhaddbtn.setBackground(new java.awt.Color(255, 204, 102));
        nhaddbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nhaddbtn.setText("Thêm");
        nhaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhaddbtnActionPerformed(evt);
            }
        });

        nhexcelwritebtn.setBackground(new java.awt.Color(255, 204, 102));
        nhexcelwritebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nhexcelwritebtn.setText("Ghi Excel");
        nhexcelwritebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhexcelwritebtnActionPerformed(evt);
            }
        });

        nhexcelreadbtn.setBackground(new java.awt.Color(255, 204, 102));
        nhexcelreadbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nhexcelreadbtn.setText("Đọc Excel");
        nhexcelreadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhexcelreadbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nhaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nhexcelwritebtn)
                .addGap(18, 18, 18)
                .addComponent(nhexcelreadbtn)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(nhexcelwritebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nhaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nhexcelreadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nguồn hàng"));

        jLabel25.setBackground(new java.awt.Color(153, 153, 255));
        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Mã Phiếu");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Nhân Viên");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("Nhà Cung");

        nhid.setEditable(false);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("Sách");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Số Lượng");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("Ngày");

        nhngaynhap.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nhnxb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhnhanvien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhid, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nhngaynhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhsach, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhsoluong, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nhid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nhsach))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nhsoluong)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nhngaynhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhnxb))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        nhtimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        nhtimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nhtimkiembtn.setText("Tìm Kiếm");
        nhtimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhtimkiembtnActionPerformed(evt);
            }
        });

        nhresetbtn.setBackground(new java.awt.Color(255, 204, 102));
        nhresetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nhresetbtn.setText("Reset");
        nhresetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhresetbtnActionPerformed(evt);
            }
        });

        nhaphangpdfbtn.setBackground(new java.awt.Color(255, 204, 102));
        nhaphangpdfbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nhaphangpdfbtn.setText("In PDF");
        nhaphangpdfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhaphangpdfbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nhtimkiemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nhtimkiembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhaphangpdfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nhtimkiembtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(nhtimkiemfield, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nhresetbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nhaphangpdfbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout SachContent1Layout = new javax.swing.GroupLayout(SachContent1);
        SachContent1.setLayout(SachContent1Layout);
        SachContent1Layout.setHorizontalGroup(
            SachContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SachContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SachContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SachContent1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        SachContent1Layout.setVerticalGroup(
            SachContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SachContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SachContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NhapHangPanelLayout = new javax.swing.GroupLayout(NhapHangPanel);
        NhapHangPanel.setLayout(NhapHangPanelLayout);
        NhapHangPanelLayout.setHorizontalGroup(
            NhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhapHangPanelLayout.createSequentialGroup()
                .addGroup(NhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                    .addGroup(NhapHangPanelLayout.createSequentialGroup()
                        .addComponent(SachContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        NhapHangPanelLayout.setVerticalGroup(
            NhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhapHangPanelLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SachContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(NhapHangPanel, "nhaphangcard");

        NCCPanel.setBackground(new java.awt.Color(255, 255, 255));
        NCCPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        NCCPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));
        jPanel14.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Nhà Cung Cấp");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addContainerGap())
        );

        SachContent2.setBackground(new java.awt.Color(255, 255, 255));
        SachContent2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SachContent2.setMaximumSize(new java.awt.Dimension(980, 680));
        SachContent2.setPreferredSize(new java.awt.Dimension(985, 685));

        ncctbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ncctbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ncctblMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ncctbl);
        if (ncctbl.getColumnModel().getColumnCount() > 0) {
            ncctbl.getColumnModel().getColumn(0).setResizable(false);
            ncctbl.getColumnModel().getColumn(1).setResizable(false);
            ncctbl.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        nccaddbtn.setBackground(new java.awt.Color(255, 204, 102));
        nccaddbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nccaddbtn.setText("Thêm");
        nccaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nccaddbtnActionPerformed(evt);
            }
        });

        ncceditbtn.setBackground(new java.awt.Color(255, 204, 102));
        ncceditbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ncceditbtn.setText("Sửa");
        ncceditbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncceditbtnActionPerformed(evt);
            }
        });

        nccdeletebtn.setBackground(new java.awt.Color(255, 204, 102));
        nccdeletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nccdeletebtn.setText("Xóa");
        nccdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nccdeletebtnActionPerformed(evt);
            }
        });

        nccexcelwritebtn.setBackground(new java.awt.Color(255, 204, 102));
        nccexcelwritebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nccexcelwritebtn.setText("Ghi Excel");
        nccexcelwritebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nccexcelwritebtnActionPerformed(evt);
            }
        });

        nccexcelreadbtn.setBackground(new java.awt.Color(255, 204, 102));
        nccexcelreadbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nccexcelreadbtn.setText("Đọc Excel");
        nccexcelreadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nccexcelreadbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(nccaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ncceditbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nccdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nccexcelwritebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nccexcelreadbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nccaddbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ncceditbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nccdeletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nccexcelwritebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nccexcelreadbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Nhà Cung Cấp"));

        jLabel35.setBackground(new java.awt.Color(153, 153, 255));
        jLabel35.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel35.setText("ID");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setText("Tên NCC");

        jLabel37.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel37.setText("Địa Chỉ");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel38.setText("SĐT");

        nccid.setEditable(false);

        nccname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nccnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nccname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                    .addComponent(nccdiachi)
                    .addComponent(nccsdt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nccid, javax.swing.GroupLayout.Alignment.LEADING)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nccid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nccname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nccdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nccsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        ncctimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        ncctimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ncctimkiembtn.setText("Tìm Kiếm");
        ncctimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncctimkiembtnActionPerformed(evt);
            }
        });

        nccresetbtn.setBackground(new java.awt.Color(255, 204, 102));
        nccresetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nccresetbtn.setText("Reset");
        nccresetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nccresetbtnActionPerformed(evt);
            }
        });

        nccpdfbtn.setBackground(new java.awt.Color(255, 204, 102));
        nccpdfbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nccpdfbtn.setText("In PDF");
        nccpdfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nccpdfbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ncctimkiemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ncctimkiembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nccresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nccpdfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nccpdfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ncctimkiembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ncctimkiemfield)
                    .addComponent(nccresetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout SachContent2Layout = new javax.swing.GroupLayout(SachContent2);
        SachContent2.setLayout(SachContent2Layout);
        SachContent2Layout.setHorizontalGroup(
            SachContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SachContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SachContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SachContent2Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        SachContent2Layout.setVerticalGroup(
            SachContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SachContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SachContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NCCPanelLayout = new javax.swing.GroupLayout(NCCPanel);
        NCCPanel.setLayout(NCCPanelLayout);
        NCCPanelLayout.setHorizontalGroup(
            NCCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NCCPanelLayout.createSequentialGroup()
                .addGroup(NCCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                    .addGroup(NCCPanelLayout.createSequentialGroup()
                        .addComponent(SachContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        NCCPanelLayout.setVerticalGroup(
            NCCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NCCPanelLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SachContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(NCCPanel, "ncccard");

        KhachHangPanel.setBackground(new java.awt.Color(255, 255, 255));
        KhachHangPanel.setMaximumSize(new java.awt.Dimension(980, 720));
        KhachHangPanel.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel18.setBackground(new java.awt.Color(102, 102, 102));
        jPanel18.setPreferredSize(new java.awt.Dimension(980, 40));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Khách Hàng");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        SachContent3.setBackground(new java.awt.Color(255, 255, 255));
        SachContent3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SachContent3.setMaximumSize(new java.awt.Dimension(980, 680));
        SachContent3.setPreferredSize(new java.awt.Dimension(985, 685));

        khtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ", "Tên", "Địa Chỉ", "Số Điện Thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        khtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                khtblMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(khtbl);
        if (khtbl.getColumnModel().getColumnCount() > 0) {
            khtbl.getColumnModel().getColumn(0).setResizable(false);
            khtbl.getColumnModel().getColumn(1).setResizable(false);
            khtbl.getColumnModel().getColumn(2).setResizable(false);
            khtbl.getColumnModel().getColumn(3).setResizable(false);
            khtbl.getColumnModel().getColumn(4).setResizable(false);
            khtbl.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        khaddbtn.setBackground(new java.awt.Color(255, 204, 102));
        khaddbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        khaddbtn.setText("Thêm");
        khaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khaddbtnActionPerformed(evt);
            }
        });

        kheditbtn.setBackground(new java.awt.Color(255, 204, 102));
        kheditbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kheditbtn.setText("Sửa");
        kheditbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kheditbtnActionPerformed(evt);
            }
        });

        khdeletebtn.setBackground(new java.awt.Color(255, 204, 102));
        khdeletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        khdeletebtn.setText("Xóa");
        khdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khdeletebtnActionPerformed(evt);
            }
        });

        khexcelwritebtn.setBackground(new java.awt.Color(255, 204, 102));
        khexcelwritebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        khexcelwritebtn.setText("Ghi Excel");
        khexcelwritebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khexcelwritebtnActionPerformed(evt);
            }
        });

        khexcelreadbtn1.setBackground(new java.awt.Color(255, 204, 102));
        khexcelreadbtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        khexcelreadbtn1.setText("Đọc Excel");
        khexcelreadbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khexcelreadbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(khaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kheditbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(khdeletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(khexcelwritebtn)
                .addGap(8, 8, 8)
                .addComponent(khexcelreadbtn1)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kheditbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(khaddbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(khdeletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(khexcelreadbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(khexcelwritebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel40.setBackground(new java.awt.Color(153, 153, 255));
        jLabel40.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel40.setText("ID");

        jLabel41.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel41.setText("Họ");

        jLabel43.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel43.setText("Tên");

        khid.setEditable(false);

        khho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khhoActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel45.setText("Địa Chỉ");

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel46.setText("SĐT");

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel47.setText("Email");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(khho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(khid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(khten))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(khsdt)
                    .addComponent(khemail)
                    .addComponent(khdiachi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(khid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(khdiachi))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(khsdt)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(khho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(khemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(khten, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        khtimkiembtn.setBackground(new java.awt.Color(255, 204, 102));
        khtimkiembtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        khtimkiembtn.setText("Tìm Kiếm");
        khtimkiembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khtimkiembtnActionPerformed(evt);
            }
        });

        khresetbtn.setBackground(new java.awt.Color(255, 204, 102));
        khresetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        khresetbtn.setText("Reset");
        khresetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khresetbtnActionPerformed(evt);
            }
        });

        khpdfbtn.setBackground(new java.awt.Color(255, 204, 102));
        khpdfbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        khpdfbtn.setText("In PDF");
        khpdfbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khpdfbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(khtimkiemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(khtimkiembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(khresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(khpdfbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(khtimkiemfield)
                    .addComponent(khresetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(khtimkiembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(khpdfbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout SachContent3Layout = new javax.swing.GroupLayout(SachContent3);
        SachContent3.setLayout(SachContent3Layout);
        SachContent3Layout.setHorizontalGroup(
            SachContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SachContent3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SachContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SachContent3Layout.createSequentialGroup()
                        .addGroup(SachContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(SachContent3Layout.createSequentialGroup()
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        SachContent3Layout.setVerticalGroup(
            SachContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SachContent3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SachContent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout KhachHangPanelLayout = new javax.swing.GroupLayout(KhachHangPanel);
        KhachHangPanel.setLayout(KhachHangPanelLayout);
        KhachHangPanelLayout.setHorizontalGroup(
            KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangPanelLayout.createSequentialGroup()
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                    .addGroup(KhachHangPanelLayout.createSequentialGroup()
                        .addComponent(SachContent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        KhachHangPanelLayout.setVerticalGroup(
            KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SachContent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ContentTab.add(KhachHangPanel, "khachhangcard");

        jSplitPane1.setRightComponent(ContentTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void khresetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khresetbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model, tablekh);

            int rows2 = model.getRowCount()+1;
            String rowsstring = String.valueOf(rows2);
            khid.setText(rowsstring);
            khho.setText("");
            khten.setText("");
            khdiachi.setText("");
            khsdt.setText("");
            khemail.setText("");
            khtimkiemfield.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_khresetbtnActionPerformed

    private void khtimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khtimkiembtnActionPerformed
        if(khtimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!khtimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
            String IDtext = khtimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablekh,IDtext);
        }
    }//GEN-LAST:event_khtimkiembtnActionPerformed

    private void khhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_khhoActionPerformed

    private void khexcelreadbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khexcelreadbtn1ActionPerformed
        try {
            khexcel.ReadExcel();
            DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablekh);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_khexcelreadbtn1ActionPerformed

    private void khexcelwritebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khexcelwritebtnActionPerformed
        try {
            khexcel.WriteExcel();
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_khexcelwritebtnActionPerformed

    private void khdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khdeletebtnActionPerformed
        try
        {
            CustomerBUS ctbus = new CustomerBUS();
            if(khid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Khách Hàng!!");
            }
            if(!khid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
                int rows = model.getRowCount();
                String ID = khid.getText();
                int IDint = Integer.parseInt(ID);
                ctdto.setCustomerID(ID);
                ctbus.Delete(ctdto);

                for(int i=IDint;i<rows;i++)
                {
                    String idnext = (String) model.getValueAt(i,0);
                    int idnextint = Integer.parseInt(idnext);
                    int idnextreal = idnextint-1;
                    connect = new MyConnectUnitDAO();
                    String sql = "UPDATE khachhang SET MAKH = " + idnextreal +  " WHERE MAKH = " + idnext + "";
                    System.out.println(sql);
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE khachhang SET MAKH = " + idnextreal +  " WHERE MAKH = " + idnext + ";" );
                    int results = st.executeUpdate();
                    connect.Close();
                }
                ctrler.cleartable(model);
                ctrler.readdata(model,tablekh);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                khid.setText(rowsstring);
                khho.setText("");
                khten.setText("");
                khdiachi.setText("");
                khsdt.setText("");
                khemail.setText("");
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_khdeletebtnActionPerformed

    private void kheditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kheditbtnActionPerformed
        try
        {
            CustomerBUS ctbus = new CustomerBUS();
            if(khid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn NCC!!");
            }
            if(!khid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
                int rows = model.getRowCount();

                String ID = khid.getText();
                int IDint = Integer.parseInt(ID);
                ctdto.setCustomerID(ID);
                String Ho = khho.getText();
                ctdto.setHo(Ho);
                String Ten = khten.getText();
                ctdto.setTen(Ten);
                String DiaChi = khdiachi.getText();
                ctdto.setAddress(DiaChi);
                String Sdt = khsdt.getText();
                if(!tester.sdt(Sdt))
                {
                    JOptionPane.showMessageDialog(null, "Sai Format Sđt (10 Số)!!!!");
                    return;
                }
                ctdto.setSdt(Sdt);
                String Email = khemail.getText();
                if(!tester.testemail(Email))
                {
                    JOptionPane.showMessageDialog(null, "Sai Format Email(*@mail.com)!!");
                    return;
                }
                ctdto.setEmail(Email);

                ctbus.Fix(ctdto);
                ctrler.cleartable(model);
                ctrler.readdata(model,tablekh);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                khid.setText(rowsstring);
                khho.setText("");
                khten.setText("");
                khdiachi.setText("");
                khsdt.setText("");
                khemail.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kheditbtnActionPerformed

    private void khaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khaddbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
            int rows = model.getRowCount();
            CustomerBUS ctbus = new CustomerBUS();
            String ID = khid.getText();
            int IDint = Integer.parseInt(ID);
            for(int i = 0; i<=rows;i++)
            {
                if(i==rows && rows!=IDint)
                {
                    ctdto.setCustomerID(ID);
                    String Ho = khho.getText();
                    ctdto.setHo(Ho);
                    String Ten = khten.getText();
                    ctdto.setTen(Ten);
                    String DiaChi = khdiachi.getText();
                    ctdto.setAddress(DiaChi);
                    String Sdt = khsdt.getText();
                    if(!tester.sdt(Sdt))
                    {
                        JOptionPane.showMessageDialog(null, "Sai Format Sđt (10 Số)!!!!");
                        break;
                    }
                    ctdto.setSdt(Sdt);
                    String Email = khemail.getText();
                    if(!tester.testemail(Email))
                    {
                        JOptionPane.showMessageDialog(null, "Sai Format Email(*@mail.com)!!");
                        break;
                    }
                    ctdto.setEmail(Email);

                    ctbus.Add(ctdto);

                    ctrler.cleartable(model);
                    ctrler.readdata(model,tablekh);

                    int rows2 = model.getRowCount()+1;
                    String rowsstring = String.valueOf(rows2);
                    khid.setText(rowsstring);
                    khho.setText("");
                    khten.setText("");
                    khdiachi.setText("");
                    khsdt.setText("");
                    khemail.setText("");
                }
                if(i==IDint)
                {
                    JOptionPane.showMessageDialog(null, "Mã Tài Khoản Đã Tồn Tại!!");
                    break;
                }

            }
        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_khaddbtnActionPerformed

    private void khtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khtblMouseClicked
        int index = khtbl.getSelectedRow();
        TableModel model = khtbl.getModel();
        String value1 = (String) model.getValueAt(index,0);
        String value2 = (String) model.getValueAt(index,1);
        String value3 = (String) model.getValueAt(index,2);
        String value4 = (String) model.getValueAt(index,3);
        String value5 = (String) model.getValueAt(index,4);
        String value6 = (String) model.getValueAt(index,5);

        khid.setText(value1);
        khho.setText(value2);
        khten.setText(value3);
        khdiachi.setText(value4);
        khsdt.setText(value5);
        khemail.setText(value6);
    }//GEN-LAST:event_khtblMouseClicked

    private void nccresetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nccresetbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model, tablencc);
            int rows2 = model.getRowCount()+1;
            String rowsstring = String.valueOf(rows2);
            nccid.setText(rowsstring);
            nccname.setText("");
            nccdiachi.setText("");
            nccsdt.setText("");
            ncctimkiemfield.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nccresetbtnActionPerformed

    private void ncctimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncctimkiembtnActionPerformed
        if(ncctimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!ncctimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
            String IDtext = ncctimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablencc,IDtext);
        }
    }//GEN-LAST:event_ncctimkiembtnActionPerformed

    private void nccnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nccnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nccnameActionPerformed

    private void nccexcelreadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nccexcelreadbtnActionPerformed
        try {
            nccexcel.ReadExcel();
            DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablencc);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nccexcelreadbtnActionPerformed

    private void nccexcelwritebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nccexcelwritebtnActionPerformed
        try {
            nccexcel.WriteExcel();
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nccexcelwritebtnActionPerformed

    private void nccdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nccdeletebtnActionPerformed
        try
        {
            SupplierBUS splybus = new SupplierBUS();
            if(nccid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn NCC!!");
            }
            if(!nccid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
                int rows = model.getRowCount();
                String ID = nccid.getText();
                int IDint = Integer.parseInt(ID);
                splydto.setCodeSupplier(ID);
                splybus.xoa(splydto);

                for(int i=IDint;i<rows;i++)
                {
                    String idnext = (String) model.getValueAt(i,0);
                    int idnextint = Integer.parseInt(idnext);
                    int idnextreal = idnextint-1;
                    connect = new MyConnectUnitDAO();
                    String sql = "UPDATE nhacungcap SET MANCC = " + idnextreal +  " WHERE MANCC = " + idnext + "";
                    System.out.println(sql);
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE nhacungcap SET MANCC = " + idnextreal +  " WHERE MANCC = " + idnext + ";" );
                    int results = st.executeUpdate();
                    connect.Close();
                }
                ctrler.cleartable(model);
                ctrler.readdata(model,tablencc);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nccid.setText(rowsstring);
                nccname.setText("");
                nccdiachi.setText("");
                nccsdt.setText("");
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nccdeletebtnActionPerformed

    private void ncceditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncceditbtnActionPerformed
        try
        {
            SupplierBUS splybus = new SupplierBUS();
            if(nccid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn NCC!!");
            }
            if(!nccid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
                int rows = model.getRowCount();

                String ID = nccid.getText();
                int IDint = Integer.parseInt(ID);
                splydto.setCodeSupplier(ID);
                String SplyName = nccname.getText();
                splydto.setNameSupplier(SplyName);

                String DiaChi = nccdiachi.getText();
                splydto.setAddressSupplier(DiaChi);

                String SDT = nccsdt.getText();
                if(!tester.sdt(SDT))
                {
                    JOptionPane.showMessageDialog(null, "Sai Format Sđt (10 Số)!!!!");
                    return;
                }
                splydto.setPhonenumberSupplier(SDT);

                splybus.sua(splydto);
                ctrler.cleartable(model);
                ctrler.readdata(model,tablencc);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nccid.setText(rowsstring);
                nccname.setText("");
                nccdiachi.setText("");
                nccsdt.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ncceditbtnActionPerformed

    private void nccaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nccaddbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
            int rows = model.getRowCount();
            SupplierBUS splybus = new SupplierBUS();
            String ID = nccid.getText();
            int IDint = Integer.parseInt(ID);
            for(int i = 0; i<=rows;i++)
            {
                if(i==rows && rows!=IDint)
                {
                    splydto.setCodeSupplier(ID);
                    String SplyName = nccname.getText();
                    splydto.setNameSupplier(SplyName);

                    String DiaChi = nccdiachi.getText();
                    splydto.setAddressSupplier(DiaChi);

                    String SDT = nccsdt.getText();
                    if(!tester.sdt(SDT))
                    {
                        JOptionPane.showMessageDialog(null, "Sai Format Sđt (10 Số)!!!!");
                        break;
                    }
                    splydto.setPhonenumberSupplier(SDT);

                    splybus.them(splydto);

                    ctrler.cleartable(model);
                    ctrler.readdata(model,tablencc);

                    int rows2 = model.getRowCount()+1;
                    String rowsstring = String.valueOf(rows2);
                    nccid.setText(rowsstring);
                    nccname.setText("");
                    nccdiachi.setText("");
                    nccsdt.setText("");
                }
                if(i==IDint)
                {
                    JOptionPane.showMessageDialog(null, "Mã NCC Đã Tồn Tại!!");
                    break;
                }

            }
        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nccaddbtnActionPerformed

    private void ncctblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ncctblMouseClicked
        int index = ncctbl.getSelectedRow();
        TableModel model = ncctbl.getModel();
        String value1 = (String) model.getValueAt(index,0);
        String value2 = (String) model.getValueAt(index,1);
        String value3 = (String) model.getValueAt(index,2);
        String value4 = (String) model.getValueAt(index,3);

        nccid.setText(value1);
        nccname.setText(value2);
        nccdiachi.setText(value3);
        nccsdt.setText(value4);
    }//GEN-LAST:event_ncctblMouseClicked

    private void nhresetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhresetbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) nhtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model, tablenh);
            int rows = model.getRowCount()+1;
            String rowsstring = String.valueOf(rows);
            nhid.setText(rowsstring);
            nhnhanvien.setSelectedIndex(0);
            nhnxb.setSelectedIndex(0);
            nhsach.setSelectedIndex(0);
            nhsoluong.setText("");
            nhtimkiemfield.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nhresetbtnActionPerformed

    private void nhtimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhtimkiembtnActionPerformed
        if(nhtimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!nhtimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) nhtbl.getModel();
            String IDtext = nhtimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablenh,IDtext);
        }
    }//GEN-LAST:event_nhtimkiembtnActionPerformed

    private void nhexcelreadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhexcelreadbtnActionPerformed
        try {
            nhexcel.ReadExcel();
            DefaultTableModel model = (DefaultTableModel) nhtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablenh);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nhexcelreadbtnActionPerformed

    private void nhexcelwritebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhexcelwritebtnActionPerformed
        try {
            nhexcel.WriteExcel();
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nhexcelwritebtnActionPerformed

    private void nhaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhaddbtnActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) nhtbl.getModel();
            Date selectedDate = (Date) nhngaynhap.getDate();
            int rows = model.getRowCount();
            ImportCouponBUS nhbus = new ImportCouponBUS();
            DetailImportCouponBUS nhctbus = new DetailImportCouponBUS();
            String ID = nhid.getText();
            int IDint = Integer.parseInt(ID);
            for(int i = 0; i<=rows;i++)
            {
                if(i==rows && rows!=IDint)
                {
                    nhdto.setCodeCoupon(ID);
                    nhctdto.setCodeCoupon(ID);

                    int nhanvien = nhnhanvien.getSelectedIndex()+1;
                    String nhanvienText = String.valueOf(nhanvien);
                    nhdto.setCodeStaff(nhanvienText);

                    int NXB = nhnxb.getSelectedIndex()+1;
                    String NXBText = String.valueOf(NXB);
                    nhdto.setCodeSupplier(NXBText);

                    String NgayNhap = dateFormat.format(selectedDate.getTime());
                    nhdto.setDate(NgayNhap);

                    int sach = nhsach.getSelectedIndex()+1;
                    String sachText = String.valueOf(sach);
                    nhctdto.setCodeBook(sachText);
                    System.out.println("Masach: " + sachText);

                    //String Levels = tkaddpower.getSelectedIndex().toString();
                    //String Levels = tkaddpower.getText();
                    String SoLuong = nhsoluong.getText();
                    int slint = Integer.parseInt(SoLuong);
                    if(slint < 0)
                    {
                        JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng >0!!");
                        return;
                    }
                    nhctdto.setNumber(slint);

                    nhbus.them(nhdto);
                    nhctbus.them(nhctdto);

                    ctrler.cleartable(model);
                    ctrler.readdata(model,tablenh);

                    int rows2 = model.getRowCount()+1;
                    String rowsstring = String.valueOf(rows2);
                    nhid.setText(rowsstring);
                    nhnhanvien.setSelectedIndex(0);
                    nhnxb.setSelectedIndex(0);
                    nhsach.setSelectedIndex(0);
                    nhsoluong.setText("");
                    nhngaynhap.setDate(datechange);

                    connect = new MyConnectUnitDAO();
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                    PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach WHERE MASACH = " + sachText + ";");
                    ResultSet rs = stsach.executeQuery();
                    while (rs.next())
                    {
                        String SLdata = (rs.getString("SoLuong"));
                        int SLdataint = Integer.parseInt(SLdata);
                        int SLTotal = SLdataint + slint;
                        PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE sach SET SoLuong = " + SLTotal +  " WHERE MASACH = " + sachText + ";" );
                        int results = st.executeUpdate();
                    }
                    connect.Close();
                }
                if(i==IDint)
                {
                    JOptionPane.showMessageDialog(null, "Mã Phiếu Nhập Đã Tồn Tại!!");
                    break;
                }

            }
        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nhaddbtnActionPerformed

    private void nhtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhtblMouseClicked
        try {
            int index = nhtbl.getSelectedRow();
            String SLdata = "";
            String MSdata= " ";
            int MSdataint = 0;
            TableModel model = nhtbl.getModel();
            String value1 = (String) model.getValueAt(index,0);
            String value2 = (String) model.getValueAt(index,1);
            int value2int = Integer.parseInt(value2)-1;
            String value3 = (String) model.getValueAt(index,2);
            int value3int = Integer.parseInt(value3)-1;
            String value4 = (String) model.getValueAt(index,3);
            Date datetbl = dateFormat.parse(value4);

            connect = new MyConnectUnitDAO();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM chitietphieunhap WHERE MAPHIEU = " + value1 + ";");
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                SLdata = (rs.getString("SoLuong"));
                MSdata = (rs.getString("MASACH"));
                MSdataint = Integer.parseInt(MSdata)-1;
                nhsoluong.setText(SLdata);
                nhsach.setSelectedIndex(MSdataint);
            }
            connect.Close();
            nhid.setText(value1);
            nhnhanvien.setSelectedIndex(value2int);
            nhnxb.setSelectedIndex(value3int);
            nhngaynhap.setDate(datetbl);
        } catch (ParseException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nhtblMouseClicked

    private void sachresetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachresetbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model, tablesach);
            int rows = model.getRowCount()+1;
            String rowsstring = String.valueOf(rows);
            sachid.setText(rowsstring);
            sachname.setText("");
            sachtacgia.setText("");
            sachloai.setSelectedIndex(0);
            sachnxb.setSelectedIndex(0);
            sachdongia.setText("");
            sachsoluong.setText("");
            sachtimkiemfield.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sachresetbtnActionPerformed

    private void sachtimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachtimkiembtnActionPerformed
        if(sachtimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!sachtimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
            String IDtext = sachtimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesach,IDtext);
        }
    }//GEN-LAST:event_sachtimkiembtnActionPerformed

    private void sachnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sachnameActionPerformed

    private void sachexcelreadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachexcelreadbtnActionPerformed
        try {
            sachexcel.ReadExcel();
            DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesach);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sachexcelreadbtnActionPerformed

    private void sachexcelwritebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachexcelwritebtnActionPerformed
        try {
            sachexcel.WriteExcel();
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sachexcelwritebtnActionPerformed

    private void sachdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachdeletebtnActionPerformed
        try
        {
            BookBUS bookbus = new BookBUS();
            if(sachid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Sách!!");
            }
            if(!sachid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
                int rows = model.getRowCount();
                String ID = sachid.getText();
                int IDint = Integer.parseInt(ID);
                bookdto.setCodeBook(ID);
                bookbus.Delete(bookdto);

                for(int i=IDint;i<rows;i++)
                {
                    String idnext = (String) model.getValueAt(i,0);
                    int idnextint = Integer.parseInt(idnext);
                    int idnextreal = idnextint-1;
                    connect = new MyConnectUnitDAO();
                    String sql = "UPDATE sach SET MASACH = " + idnextreal +  " WHERE MASACH = " + idnext + "";
                    System.out.println(sql);
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE sach SET MASACH = " + idnextreal +  " WHERE MASACH = " + idnext + ";" );
                    int results = st.executeUpdate();
                    connect.Close();
                }
                ctrler.cleartable(model);
                ctrler.readdata(model,tablesach);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                sachid.setText(rowsstring);
                sachname.setText("");
                sachtacgia.setText("");
                sachloai.setSelectedIndex(0);
                sachnxb.setSelectedIndex(0);
                sachdongia.setText("");
                sachsoluong.setText("");
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sachdeletebtnActionPerformed

    private void sacheditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacheditbtnActionPerformed
        try
        {
            BookBUS bookbus = new BookBUS();
            if(sachid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Sách!!");
            }
            if(!sachid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
                int rows = model.getRowCount();

                String ID = sachid.getText();
                int IDint = Integer.parseInt(ID);
                bookdto.setCodeBook(ID);
                String BookName = sachname.getText();
                bookdto.setBookName(BookName);

                int NXB = sachnxb.getSelectedIndex()+1;
                String NXBText = String.valueOf(NXB);
                bookdto.setPublishingCompany(NXBText);

                //String Levels = tkaddpower.getSelectedIndex().toString();
                //String Levels = tkaddpower.getText();
                String Gia = sachdongia.getText();
                float Giaint = Float.parseFloat(Gia);
                if(Giaint < 1000)
                {
                    JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Giá Tiến >1000!!");
                    return;
                }
                bookdto.setUnitPrice(Giaint);

                String TacGia = sachtacgia.getText();
                bookdto.setAuthor(TacGia);

                String SoLuong = sachsoluong.getText();
                int SoLuongint = Integer.parseInt(SoLuong);
                if(SoLuongint < 0)
                {
                    JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng >0!!");
                    return;
                }
                bookdto.setNumber(SoLuongint);

                int Loai = sachloai.getSelectedIndex()+1;
                String LoaiText = String.valueOf(Loai);
                bookdto.setCodeKindOfBook(LoaiText);

                bookbus.Fix(bookdto);
                ctrler.cleartable(model);
                ctrler.readdata(model,tablesach);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                sachid.setText(rowsstring);
                sachname.setText("");
                sachtacgia.setText("");
                sachloai.setSelectedIndex(0);
                sachnxb.setSelectedIndex(0);
                sachdongia.setText("");
                sachsoluong.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sacheditbtnActionPerformed

    private void sachaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachaddbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
            int rows = model.getRowCount();
            BookBUS bookbus = new BookBUS();
            String ID = sachid.getText();
            int IDint = Integer.parseInt(ID);
            for(int i = 0; i<=rows;i++)
            {
                if(i==rows && rows!=IDint)
                {
                    bookdto.setCodeBook(ID);
                    String BookName = sachname.getText();
                    bookdto.setBookName(BookName);

                    int NXB = sachnxb.getSelectedIndex()+1;
                    String NXBText = String.valueOf(NXB);
                    bookdto.setPublishingCompany(NXBText);

                    //String Levels = tkaddpower.getSelectedIndex().toString();
                    //String Levels = tkaddpower.getText();
                    String Gia = sachdongia.getText();
                    float Giaint = Float.parseFloat(Gia);
                    if(Giaint < 1000)
                    {
                        JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Giá Tiến >1000!!");
                        return;
                    }
                    bookdto.setUnitPrice(Giaint);

                    String TacGia = sachtacgia.getText();
                    bookdto.setAuthor(TacGia);

                    String SoLuong = sachsoluong.getText();
                    int SoLuongint = Integer.parseInt(SoLuong);
                    if(SoLuongint < 0)
                    {
                        JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng >0!!");
                        break;
                    }
                    bookdto.setNumber(SoLuongint);

                    int Loai = sachloai.getSelectedIndex()+1;
                    String LoaiText = String.valueOf(Loai);
                    bookdto.setCodeKindOfBook(LoaiText);

                    bookbus.Add(bookdto);

                    ctrler.cleartable(model);
                    ctrler.readdata(model,tablesach);

                    int rows2 = model.getRowCount()+1;
                    String rowsstring = String.valueOf(rows2);
                    sachid.setText(rowsstring);
                    sachname.setText("");
                    sachtacgia.setText("");
                    sachloai.setSelectedIndex(0);
                    sachnxb.setSelectedIndex(0);
                    sachdongia.setText("");
                    sachsoluong.setText("");
                }
                if(i==IDint)
                {
                    JOptionPane.showMessageDialog(null, "Mã Tài Khoản Đã Tồn Tại!!");
                    break;
                }

            }
        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sachaddbtnActionPerformed

    private void sachtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sachtblMouseClicked
        int index = sachtbl.getSelectedRow();
        TableModel model = sachtbl.getModel();
        String value1 = (String) model.getValueAt(index,0);
        String value2 = (String) model.getValueAt(index,1);
        int value2int = Integer.parseInt(value2)-1;
        String value3 = (String) model.getValueAt(index,2);
        int value3int = Integer.parseInt(value3)-1;
        String value4 = (String) model.getValueAt(index,3);
        String value5 = (String) model.getValueAt(index,4);
        String value6 = (String) model.getValueAt(index,5);
        String value7 = (String) model.getValueAt(index,6);

        sachid.setText(value1);
        sachnxb.setSelectedIndex(value2int);
        sachloai.setSelectedIndex(value3int);
        sachname.setText(value4);
        sachtacgia.setText(value5);
        sachdongia.setText(value6);
        sachsoluong.setText(value7);
        // tkaddpower.getItemAt(value4int);
    }//GEN-LAST:event_sachtblMouseClicked

    private void tkresetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkresetbtnActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model, table);
            DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
            ctrler.cleartable(model2);
            ctrler.readdata(model2, tablenv);
            int rows = model.getRowCount()+1;
            String rowsstring = String.valueOf(rows);
            tkid.setText(rowsstring);
            tkaddusername.setText("");
            tkaddpassword.setText("");
            tkaddpower.setSelectedIndex(0);
            tkho.setText("");
            tkten.setText("");
            tkngaysinh.setDate(datechange);
            tkemail.setText("");
            tkluong.setText("");
            tktimkiemfield.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkresetbtnActionPerformed

    private void tktimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tktimkiembtnActionPerformed
        if(tktimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!tktimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
            String IDtext = tktimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,table,IDtext);

            DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
            ctrler.cleartable(model2);
            ctrler.readdata(model2,tablenv,IDtext);
        }
    }//GEN-LAST:event_tktimkiembtnActionPerformed

    private void tkaddusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkaddusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkaddusernameActionPerformed

    private void tkexcelreadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkexcelreadbtnActionPerformed
        try {
            tkexcel.ReadExcel();
            DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,table);
            DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
            ctrler.cleartable(model2);
            ctrler.readdata(model2,tablenv);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkexcelreadbtnActionPerformed

    private void tkexcelwritebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkexcelwritebtnActionPerformed
        try {
            tkexcel.WriteExcel();
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkexcelwritebtnActionPerformed

    private void tkdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkdeletebtnActionPerformed
        try
        {
            AccountBUS accbus = new AccountBUS();
            StaffBUS stfbus = new StaffBUS();
            if(tkid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Tài Khoản!!");
            }
            if(!tkid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
                DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
                int rows = model.getRowCount();
                String IDtext = tkid.getText();
                int ID = Integer.parseInt(IDtext);
                accdto.setID(ID);
                accbus.Delete(accdto);
                stfdto.setCodeStaff(IDtext);
                stfbus.xoa(stfdto);

                for(int i=ID;i<rows;i++)
                {
                    String idnext = (String) model.getValueAt(i,0);
                    int idnextint = Integer.parseInt(idnext);
                    int idnextreal = idnextint-1;
                    connect = new MyConnectUnitDAO();
                    String sql = "UPDATE tbltaikhoan SET id = " + idnextreal +  " WHERE id = " + idnext + "";
                    System.out.println(sql);
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE tbltaikhoan SET id = " + idnextreal +  " WHERE id = " + idnext + ";" );
                    PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("UPDATE nhanvien SET MANV = " + idnextreal +  " WHERE MANV = " + idnext + ";" );
                    int results = st.executeUpdate();
                    int results2 = st2.executeUpdate();
                    connect.Close();
                }
                ctrler.cleartable(model);
                ctrler.readdata(model,table);
                ctrler.cleartable(model2);
                ctrler.readdata(model2,tablenv);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                tkid.setText(rowsstring);
                tkaddusername.setText("");
                tkaddpassword.setText("");
                tkaddpower.setSelectedIndex(0);
                tkho.setText("");
                tkten.setText("");
                tkngaysinh.setDate(datechange);
                tkemail.setText("");
                tkluong.setText("");
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkdeletebtnActionPerformed

    private void tkeditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkeditbtnActionPerformed
        try
        {
            AccountBUS accbus = new AccountBUS();
            StaffBUS stfbus = new StaffBUS();
            if(tkid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Tài Khoản!!");
            }
            if(!tkid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
                DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
                Date selectedDate = (Date) tkngaysinh.getDate();

                int rows = model.getRowCount();
                String IDtext = tkid.getText();
                int ID = Integer.parseInt(IDtext);
                accdto.setID(ID);
                String UserName = tkaddusername.getText();
                accdto.setUserName(UserName);
                String Password = tkaddpassword.getText();
                accdto.setPassword(Password);
                //String Levels = tkaddpower.getSelectedItem().toString();
                //String Levels = tkaddpower.getText();
                int Level = tkaddpower.getSelectedIndex();
                accdto.setLevel(Level);

                stfdto.setCodeStaff(IDtext);
                String Ho = tkho.getText();
                stfdto.setLastName(Ho);
                String Ten = tkten.getText();
                stfdto.setFirstName(Ten);
                String NgaySinh = dateFormat.format(selectedDate.getTime());
                stfdto.setDateOfBirth(NgaySinh);
                String Email = tkemail.getText();
                if(!tester.testemail(Email))
                {
                    JOptionPane.showMessageDialog(null, "Sai Format Email(*@mail.com)!!");
                    return;
                }
                stfdto.setEmail(Email);
                String Luong = tkluong.getText();
                float Luongfl = Float.parseFloat(Luong);
                if(Luongfl < 15000)
                {
                    JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lương >15000/1h!!");
                    return;
                }
                stfdto.setSalary(Luongfl);

                accbus.Fix(accdto);
                stfbus.sua(stfdto);
                ctrler.cleartable(model);
                ctrler.readdata(model,table);
                ctrler.cleartable(model2);
                ctrler.readdata(model2,tablenv);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                tkid.setText(rowsstring);
                tkaddusername.setText("");
                tkaddpassword.setText("");
                tkaddpower.setSelectedIndex(0);
                tkho.setText("");
                tkten.setText("");
                tkngaysinh.setDate(datechange);
                tkemail.setText("");
                tkluong.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkeditbtnActionPerformed

    private void tkaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkaddbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
            DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
            Date selectedDate = (Date) tkngaysinh.getDate();

            int rows = model.getRowCount();
            AccountBUS accbus = new AccountBUS();
            StaffBUS stfbus = new StaffBUS();
            String IDtext = tkid.getText();
            int ID = Integer.parseInt(IDtext);
            for(int i = 0; i<=rows;i++)
            {
                if(i==rows && rows!=ID)
                {
                    accdto.setID(ID);
                    String UserName = tkaddusername.getText();
                    accdto.setUserName(UserName);
                    String Password = tkaddpassword.getText();
                    accdto.setPassword(Password);
                    //String Levels = tkaddpower.getSelectedIndex().toString();
                    //String Levels = tkaddpower.getText();
                    int Level = tkaddpower.getSelectedIndex();
                    accdto.setLevel(Level);

                    stfdto.setCodeStaff(IDtext);
                    String Ho = tkho.getText();
                    stfdto.setLastName(Ho);
                    String Ten = tkten.getText();
                    stfdto.setFirstName(Ten);
                    //String NgaySinh = selectedDate;
                    String NgaySinh = dateFormat.format(selectedDate.getTime());
                    stfdto.setDateOfBirth(NgaySinh);

                    String Email = tkemail.getText();
                    if(!tester.testemail(Email))
                    {
                        JOptionPane.showMessageDialog(null, "Sai Format Email(*@mail.com)!!");
                        break;
                    }
                    stfdto.setEmail(Email);
                    String Luong = tkluong.getText();
                    float Luongfl = Float.parseFloat(Luong);
                    if(Luongfl < 15000)
                    {
                        JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lương >15000/1h!!");
                        break;
                    }
                    stfdto.setSalary(Luongfl);

                    accbus.Add(accdto);
                    stfbus.them(stfdto);
                    ctrler.cleartable(model);
                    ctrler.readdata(model,table);
                    ctrler.cleartable(model2);
                    ctrler.readdata(model2,tablenv);

                    int rows2 = model.getRowCount()+1;
                    String rowsstring = String.valueOf(rows2);
                    tkid.setText(rowsstring);
                    tkaddusername.setText("");
                    tkaddpassword.setText("");
                    tkaddpower.setSelectedIndex(0);
                    tkho.setText("");
                    tkten.setText("");
                    //tkngaysinh.setText("");
                    //String nowdatestring = String.valueOf(nowdate);

                    tkngaysinh.setDate(datechange);
                    tkemail.setText("");
                    tkluong.setText("");
                }
                if(i==ID)
                {
                    JOptionPane.showMessageDialog(null, "Mã Tài Khoản Đã Tồn Tại!!");
                    break;
                }

            }
        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkaddbtnActionPerformed

    private void tktbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tktbl1MouseClicked
        int index = tktbl1.getSelectedRow();
        TableModel model = tktbl1.getModel();
        TableModel model2 = tktbl2.getModel();

        String value1 = (String) model.getValueAt(index,0);
        String value2 = (String) model.getValueAt(index,1);
        String value3 = (String) model.getValueAt(index,2);
        String value4 = (String) model.getValueAt(index,3);
        int value4int = Integer.parseInt(value4);

        String value5 = (String) model2.getValueAt(index,1);

        for(int count = 0; count < model2.getRowCount(); count++)
        {
            String checkid = (String) model2.getValueAt(count,0);
            if(checkid.equals(value1))
            {
                try {
                    tkid.setText(value1);
                    tkaddusername.setText(value2);
                    tkaddpassword.setText(value3);
                    tkaddpower.setSelectedIndex(value4int);
                    // tkaddpower.getItemAt(value4int);

                    String value6 = (String) model2.getValueAt(count,2);
                    String value7 = (String) model2.getValueAt(count,3);
                    String value8 = (String) model2.getValueAt(count,4);
                    String value9 = (String) model2.getValueAt(count,5);
                    tkho.setText(value5);
                    tkten.setText(value6);
                    Date datetbl = dateFormat.parse(value7);
                    tkngaysinh.setDate(datetbl);
                    tkemail.setText(value8);
                    tkluong.setText(value9);
                    break;
                } catch (ParseException ex) {
                    Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tktbl1MouseClicked

    private void kmresetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmresetbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model, tablesale);

            int rows2 = model.getRowCount()+1;
            String rowsstring = String.valueOf(rows2);
            kmid.setText(rowsstring);
            kmname.setText("");
            kmphantram.setText("");
            kmloaisach.setSelectedIndex(0);
            kmngaybatdau.setDate(datechange);
            kmngayketthuc.setDate(datechange);
            kmtimkiemfield.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kmresetbtnActionPerformed

    private void kmtimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmtimkiembtnActionPerformed
        if(kmtimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!kmtimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
            String IDtext = kmtimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesale,IDtext);
        }
    }//GEN-LAST:event_kmtimkiembtnActionPerformed

    private void kmnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kmnameActionPerformed

    private void kmexcelreadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmexcelreadbtnActionPerformed
        try {
            saleexcel.ReadExcel();
            DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesale);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kmexcelreadbtnActionPerformed

    private void kmexcelwritebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmexcelwritebtnActionPerformed
        try {
            saleexcel.WriteExcel();
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kmexcelwritebtnActionPerformed

    private void kmdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmdeletebtnActionPerformed
        try
        {
            SaleBUS saledtbus = new SaleBUS();
            DetailSaleBUS salebus = new DetailSaleBUS();
            if(kmid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Tài Khoản!!");
            }
            if(!kmid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
                int rows = model.getRowCount();
                String IDtext = kmid.getText();
                int ID = Integer.parseInt(IDtext);
                saledto.setCodeSale(ID);
                salebus.xoa(saledto);
                saledtdto.setCodeSale(IDtext);
                saledtbus.xoa(saledtdto);

                for(int i=ID;i<rows;i++)
                {
                    String idnext = (String) model.getValueAt(i,0);
                    int idnextint = Integer.parseInt(idnext);
                    int idnextreal = idnextint-1;
                    connect = new MyConnectUnitDAO();
                    //                    String sql = "UPDATE tbltaikhoan SET id = " + idnextreal +  " WHERE id = " + idnext + "";
                    //                    System.out.println(sql);
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE khuyenmai SET MAKM = " + idnextreal +  " WHERE MAKM = " + idnext + ";" );
                    PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("UPDATE chitietkhuyenmai SET MAKM = " + idnextreal +  " WHERE MAKM = " + idnext + ";" );
                    int results = st.executeUpdate();
                    int results2 = st2.executeUpdate();
                    connect.Close();
                }
                ctrler.cleartable(model);
                ctrler.readdata(model,tablesale);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                kmid.setText(rowsstring);
                kmname.setText("");
                kmphantram.setText("");
                kmloaisach.setSelectedIndex(0);
                kmngaybatdau.setDate(datechange);
                kmngayketthuc.setDate(datechange);
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kmdeletebtnActionPerformed

    private void kmeditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeditbtnActionPerformed
        try
        {
            SupplierBUS splybus = new SupplierBUS();
            SaleBUS saledtbus = new SaleBUS();
            DetailSaleBUS salebus = new DetailSaleBUS();
            Date NgayBD = (Date) kmngaybatdau.getDate();
            Date NgayKT = (Date) kmngayketthuc.getDate();
            if(kmid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Khuyến Mãi!!");
            }
            if(!kmid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
                int rows = model.getRowCount();

                String ID = kmid.getText();
                int IDint = Integer.parseInt(ID);
                saledto.setCodeSale(IDint);
                int MaLoai = kmloaisach.getSelectedIndex();
                int MaLoaireal = MaLoai + 1;
                saledto.setCodeBook(MaLoaireal);
                String PhanTram = kmphantram.getText();
                int PhanTramint = Integer.parseInt(PhanTram);
                if(PhanTramint <= 0 || PhanTramint >100)
                {
                    JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Phần Trăm Từ 1-100%!!");
                    return;
                }
                saledto.setPercentSale(PhanTramint);

                saledtdto.setCodeSale(ID);
                String TenKM = kmname.getText();
                saledtdto.setNameSale(TenKM);
                String NgayBatDau = dateFormat.format(NgayBD.getTime());
                saledtdto.setStartDay(NgayBatDau);
                String NgayKetThuc = dateFormat.format(NgayKT.getTime());
                if(NgayKT.compareTo(NgayBD)<0)
                {
                    JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Ngày Kết Thúc Sau Ngày Bắt Đầu!!");
                    return;
                }
                saledtdto.setEndDay(NgayKetThuc);

                salebus.sua(saledto);
                saledtbus.sua(saledtdto);
                ctrler.cleartable(model);
                ctrler.readdata(model,tablesale);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                kmid.setText(rowsstring);
                kmname.setText("");
                kmphantram.setText("");
                kmloaisach.setSelectedIndex(0);
                kmngaybatdau.setDate(datechange);
                kmngayketthuc.setDate(datechange);
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kmeditbtnActionPerformed

    private void kmaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmaddbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
            Date NgayBD = (Date) kmngaybatdau.getDate();
            Date NgayKT = (Date) kmngayketthuc.getDate();

            int rows = model.getRowCount();
            SaleBUS saledtbus = new SaleBUS();
            DetailSaleBUS salebus = new DetailSaleBUS();
            String IDtext = kmid.getText();
            int ID = Integer.parseInt(IDtext);
            for(int i = 0; i<=rows;i++)
            {
                if(i==rows && rows!=ID)
                {
                    saledto.setCodeSale(ID);
                    int MaLoai = kmloaisach.getSelectedIndex();
                    int MaLoaireal = MaLoai + 1;
                    saledto.setCodeBook(MaLoaireal);
                    String PhanTram = kmphantram.getText();
                    int PhanTramint = Integer.parseInt(PhanTram);
                    if(PhanTramint <= 0 || PhanTramint >100)
                    {
                        JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Phần Trăm Từ 1-100%!!");
                        break;
                    }
                    saledto.setPercentSale(PhanTramint);

                    saledtdto.setCodeSale(IDtext);
                    String TenKM = kmname.getText();
                    saledtdto.setNameSale(TenKM);
                    String NgayBatDau = dateFormat.format(NgayBD.getTime());
                    saledtdto.setStartDay(NgayBatDau);
                    String NgayKetThuc = dateFormat.format(NgayKT.getTime());
                    if(NgayKT.compareTo(NgayBD)<0)
                    {
                        JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Ngày Kết Thúc Sau Ngày Bắt Đầu!!");
                        break;
                    }
                    saledtdto.setEndDay(NgayKetThuc);

                    salebus.them(saledto);
                    saledtbus.them(saledtdto);
                    ctrler.cleartable(model);
                    ctrler.readdata(model,tablesale);

                    int rows2 = model.getRowCount()+1;
                    String rowsstring = String.valueOf(rows2);
                    kmid.setText(rowsstring);
                    kmname.setText("");
                    kmphantram.setText("");
                    kmloaisach.setSelectedIndex(0);
                    kmngaybatdau.setDate(datechange);
                    kmngayketthuc.setDate(datechange);

                    //tkngaysinh.setText("");
                    //String nowdatestring = String.valueOf(nowdate);

                }
                if(i==ID)
                {
                    JOptionPane.showMessageDialog(null, "Mã Tài Khoản Đã Tồn Tại!!");
                    break;
                }

            }
        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kmaddbtnActionPerformed

    private void kmtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kmtblMouseClicked
        try {
            int index = kmtbl.getSelectedRow();
            String kmnamedata = "";
            String ngaybddata= "";
            String ngayktdata= "";

            TableModel model = kmtbl.getModel();
            String value1 = (String) model.getValueAt(index,0);
            String value2 = (String) model.getValueAt(index,1);
            int value2int = Integer.parseInt(value2)-1;
            String value3 = (String) model.getValueAt(index,2);
            connect = new MyConnectUnitDAO();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM chitietkhuyenmai WHERE MAKM = " + value1 + ";");
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                kmnamedata = (rs.getString("TenKhuyenMai"));
                ngaybddata = (rs.getString("NgayBD"));
                ngayktdata = (rs.getString("NgayKT"));
                Date datebd = dateFormat.parse(ngaybddata);
                Date datekt = dateFormat.parse(ngayktdata);
                kmname.setText(kmnamedata);
                kmngaybatdau.setDate(datebd);
                kmngayketthuc.setDate(datekt);
            }
            connect.Close();

            kmid.setText(value1);
            kmloaisach.setSelectedIndex(value2int);
            kmphantram.setText(value3);

        } catch (ParseException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kmtblMouseClicked

    private void hdresetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdresetbtnActionPerformed
        try {

            DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model, tablehoadon);
            DefaultTableModel modellist = (DefaultTableModel) hdtbl2.getModel();
            ctrler.cleartable(modellist);

            int rows2 = model.getRowCount()+1;
            String rowsstring = String.valueOf(rows2);
            hdid.setText(rowsstring);
            hdnhanvien.setSelectedIndex(0);
            hdkhachhang.setSelectedIndex(0);
            hdsach.setSelectedIndex(0);
            hdsoluong.setText("");
            hdtimkiemfield.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hdresetbtnActionPerformed

    private void hdtimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdtimkiembtnActionPerformed
        if(hdtimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!hdtimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
            String IDtext = hdtimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablehoadon,IDtext);
        }
    }//GEN-LAST:event_hdtimkiembtnActionPerformed

    private void hdexcelreadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdexcelreadbtnActionPerformed
        try {
            billexcel.ReadExcel();
            DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablehoadon);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hdexcelreadbtnActionPerformed

    private void hdexcelwritebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdexcelwritebtnActionPerformed
        try {
            billexcel.WriteExcel();
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hdexcelwritebtnActionPerformed

    private void hddeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hddeletebtnActionPerformed
        try
        {
            BillBUS billbus = new BillBUS();
            DetailBillBUS billdtbus = new DetailBillBUS();
            if(hdid.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Hóa Đơn!!");
            }
            if(!hdid.getText().equals(""))
            {
                DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
                DefaultTableModel modellist = (DefaultTableModel) hdtbl2.getModel();
                int rows = model.getRowCount();
                String IDtext = hdid.getText();
                int ID = Integer.parseInt(IDtext);
                billdto.setCodeBill(IDtext);
                billbus.xoa(billdto);
                billdtdto.setCodeBill(IDtext);
                billdtbus.Delete(billdtdto);

                for(int i=ID;i<rows;i++)
                {
                    String idnext = (String) model.getValueAt(i,0);
                    int idnextint = Integer.parseInt(idnext);
                    int idnextreal = idnextint-1;
                    connect = new MyConnectUnitDAO();
                    //                    String sql = "UPDATE tbltaikhoan SET id = " + idnextreal +  " WHERE id = " + idnext + "";
                    //                    System.out.println(sql);
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE hoadon SET MAHD = " + idnextreal +  " WHERE MAHD = " + idnext + ";" );
                    PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("UPDATE chitiethoadon SET MAHD = " + idnextreal +  " WHERE MAHD = " + idnext + ";" );
                    int results = st.executeUpdate();
                    int results2 = st2.executeUpdate();
                    connect.Close();
                }
                ctrler.cleartable(model);
                ctrler.readdata(model,tablehoadon);
                ctrler.cleartable(modellist);

                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                hdid.setText(rowsstring);
                hdnhanvien.setSelectedIndex(0);
                hdkhachhang.setSelectedIndex(0);
                hdsach.setSelectedIndex(0);
                hdsoluong.setText("");
                hdtimkiemfield.setText("");
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hddeletebtnActionPerformed

    private void hdaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdaddbtnActionPerformed
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
            DefaultTableModel modellist = (DefaultTableModel) hdtbl2.getModel();
            Date NgayLap = (Date) hdngaylap.getDate();
            ArrayList<String> TableList = new ArrayList<String>();

            int rows = model.getRowCount();
            int rowslist = modellist.getRowCount();
            BillBUS billbus = new BillBUS();
            DetailBillBUS billdtbus = new DetailBillBUS();
            String IDtext = hdid.getText();
            int ID = Integer.parseInt(IDtext);
            if(hdsoluong.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng!!");
                return;
            }
            int SoLuongInt = Integer.parseInt(hdsoluong.getText());
            if(SoLuongInt<=0)
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng Lớn Hơn 0!!");
                return;
            }
            if(rowslist==0)
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Thêm Sách Vào List!!");
                return;
            }
            for(int i = 0; i<=rows;i++)
            {
                if(i==rows && rows!=ID)
                {
                    billdto.setCodeBill(IDtext);

                    int MaNV = hdnhanvien.getSelectedIndex()+1;
                    String MaNVtext = String.valueOf(MaNV);
                    billdto.setCodeStaff(MaNVtext);

                    int MaKH = hdkhachhang.getSelectedIndex()+1;
                    String MaKHtext = String.valueOf(MaKH);
                    billdto.setCodeCustomer(MaKHtext);

                    String NgayLamHD = dateFormat.format(NgayLap.getTime());
                    billdto.setDaySale(NgayLamHD);

                    int TongTienTotal = 0;
                    for(int traverse=0;traverse<rowslist;traverse++)
                    {
                        int Tien = Integer.parseInt(hdtbl2.getValueAt(traverse,5).toString());
                        TongTienTotal = TongTienTotal + Tien;
                    }
                    System.out.println(TongTienTotal);
                    billdto.setThanhTien(TongTienTotal);

                    String MaHDFT = "", MaSachFT = "";
                    int DonGiaFT=0, SoLuongFT=0, GiamGiaFT=0;
                    float ThanhTienFT=0;
                    for(int traverse2=0;traverse2<rowslist;traverse2++)
                    {
                        MaHDFT = hdtbl2.getValueAt(traverse2,0).toString();
                        billdtdto.setCodeBill(MaHDFT);
                        MaSachFT = hdtbl2.getValueAt(traverse2,1).toString();
                        billdtdto.setCodeBook(MaSachFT);
                        DonGiaFT = Integer.parseInt(hdtbl2.getValueAt(traverse2,2).toString());
                        billdtdto.setPrice(DonGiaFT);
                        SoLuongFT = Integer.parseInt(hdtbl2.getValueAt(traverse2,3).toString());
                        billdtdto.setNumber(SoLuongFT);
                        GiamGiaFT = Integer.parseInt(hdtbl2.getValueAt(traverse2,4).toString());
                        billdtdto.setSale(GiamGiaFT);
                        ThanhTienFT = Float.parseFloat(hdtbl2.getValueAt(traverse2,5).toString());
                        billdtdto.setTotal(ThanhTienFT);
                        PreparedStatement stsachminus = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach WHERE MASACH = " + MaSachFT + ";");
                        ResultSet rssachm = stsachminus.executeQuery();
                        while (rssachm.next())
                        {
                            String SLdata = (rssachm.getString("SoLuong"));
                            int SLdataint = Integer.parseInt(SLdata);
                            int SLTotal = SLdataint - SoLuongFT;
                            PreparedStatement stsachdone = (PreparedStatement) connection.prepareStatement("UPDATE sach SET SoLuong = " + SLTotal +  " WHERE MASACH = " + MaSachFT + ";" );
                            int results = stsachdone.executeUpdate();
                        }
                        billdtbus.Add(billdtdto);
                        MaHDFT = ""; MaSachFT = "";
                        DonGiaFT=0; SoLuongFT=0;
                        ThanhTienFT=0; GiamGiaFT=0;
                    }

                    billbus.them(billdto);
                    connect.Close();

                    ctrler.cleartable(model);
                    ctrler.readdata(model,tablehoadon);
                    ctrler.cleartable(modellist);

                    int rows2 = model.getRowCount()+1;
                    String rowsstring = String.valueOf(rows2);
                    hdid.setText(rowsstring);
                    hdnhanvien.setSelectedIndex(0);
                    hdkhachhang.setSelectedIndex(0);
                    hdsach.setSelectedIndex(0);
                    hdsoluong.setText("");

                }
                if(i==ID)
                {
                    JOptionPane.showMessageDialog(null, "Mã Tài Khoản Đã Tồn Tại!!");
                    break;
                }

            }
        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hdaddbtnActionPerformed

    private void hdtbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hdtbl1MouseClicked
        try {
            int index = hdtbl1.getSelectedRow();

            DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
            DefaultTableModel modellist = (DefaultTableModel) hdtbl2.getModel();
            ctrler.cleartable(modellist);
            String value1 = (String) model.getValueAt(index,0);
            String value2 = (String) model.getValueAt(index,1);
            int value2int = Integer.parseInt(value2)-1;
            String value3 = (String) model.getValueAt(index,2);
            int value3int = Integer.parseInt(value3)-1;
            String value4 = (String) model.getValueAt(index,3);
            connect = new MyConnectUnitDAO();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM chitiethoadon WHERE MAHD = " + value1 + ";");
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                String mahdtable = (rs.getString("MAHD"));
                String masachtable = (rs.getString("MASACH"));
                String dongiatable = (rs.getString("DonGia"));
                String soluongtable = (rs.getString("SoLuong"));
                String giamgiatable = (rs.getString("GiamGia"));
                String thanhtientable = (rs.getString("ThanhTien"));
                modellist.addRow(new Object[]{mahdtable,masachtable,dongiatable,soluongtable,giamgiatable,thanhtientable});
            }
            connect.Close();

            hdid.setText(value1);
            hdnhanvien.setSelectedIndex(value2int);
            hdkhachhang.setSelectedIndex(value3int);
            Date datelap = dateFormat.parse(value4);
            hdngaylap.setDate(datelap);

        } catch (ParseException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hdtbl1MouseClicked

    private void HoaDonTitle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonTitle1ActionPerformed
        cardLayout.show(ContentTab, "thongkecard");
        try 
        {
            DefaultTableModel model = (DefaultTableModel) thongketbl.getModel();
            ctrler.cleartable(model);
            ctrler.DocDBThongke(model,tablehoadon);
            float ThanhTien = ctrler.TongThanhTien(tablehoadon);
                String ThanhTienText = String.valueOf(ThanhTien);
                tongthanhtienlbl.setText(ThanhTienText);
            int TongHoaDon = ctrler.TongHoaDon(tablehoadon);
                String TongHoaDonText = String.valueOf(TongHoaDon);
                tonghoadonlbl.setText(TongHoaDonText);
            float BQHD = ctrler.BinhQuanHoaDon(tablehoadon);
                String BQHDText = String.valueOf(BQHD);
                bqhdlbl.setText(BQHDText);
            float BQSP = ctrler.BinhQuanSanPham(tablehoadon,tablehoadonct);
                String BQSPText = String.valueOf(BQSP);
                bqsplbl.setText(BQSPText);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HoaDonTitle1ActionPerformed

    private void KhachHangTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachHangTitleActionPerformed
        cardLayout.show(ContentTab, "khachhangcard");
        try {
            DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablekh);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                khid.setText(idstring);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                khid.setText(rowsstring);
                khho.setText("");
                khten.setText("");
                khdiachi.setText("");
                khsdt.setText("");
                khemail.setText("");
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                khid.setText(checklastidString);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                khid.setText(rowsstring);
                khho.setText("");
                khten.setText("");
                khdiachi.setText("");
                khsdt.setText("");
                khemail.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_KhachHangTitleActionPerformed

    private void SaleTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleTitleActionPerformed
        cardLayout.show(ContentTab, "kmcard");
        try {
            DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesale);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                kmid.setText(idstring);
                kmloaisach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    kmloaisach.addItem(tenloai);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                kmid.setText(rowsstring);
                kmname.setText("");
                kmphantram.setText("");
                kmloaisach.setSelectedIndex(0);
                kmngaybatdau.setDate(datechange);
                kmngayketthuc.setDate(datechange);
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                kmid.setText(checklastidString);
                kmloaisach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    kmloaisach.addItem(tenloai);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                kmid.setText(rowsstring);
                kmname.setText("");
                kmphantram.setText("");
                kmloaisach.setSelectedIndex(0);
                kmngaybatdau.setDate(datechange);
                kmngayketthuc.setDate(datechange);
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaleTitleActionPerformed

    private void HoaDonTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonTitleActionPerformed
        cardLayout.show(ContentTab, "hdcard");
        try {
            DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablehoadon);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                hdid.setText(idstring);
                hdnhanvien.removeAllItems();
                hdkhachhang.removeAllItems();
                hdsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stkh = (PreparedStatement) connection.prepareStatement("SELECT * FROM khachhang;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String ho = (rs.getString("Ho"));
                    String ten = (rs.getString("Ten"));
                    String name = ho + " " + ten;
                    hdnhanvien.addItem(name);
                }
                ResultSet rskh = stkh.executeQuery();
                while (rskh.next())
                {
                    String ho2 = (rskh.getString("Ho"));
                    String ten2 = (rskh.getString("Ten"));
                    String name2 = ho2 + " " + ten2;
                    hdkhachhang.addItem(name2);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    hdsach.addItem(tensach);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                hdid.setText(rowsstring);
                hdnhanvien.setSelectedIndex(0);
                hdkhachhang.setSelectedIndex(0);
                hdngaylap.setDate(datechange);
                hdsoluong.setText("");
                hdtimkiemfield.setText("");
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                hdid.setText(checklastidString);
                hdnhanvien.removeAllItems();
                hdkhachhang.removeAllItems();
                hdsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stkh = (PreparedStatement) connection.prepareStatement("SELECT * FROM khachhang;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String ho = (rs.getString("Ho"));
                    String ten = (rs.getString("Ten"));
                    String name = ho + " " + ten;
                    hdnhanvien.addItem(name);
                }
                ResultSet rskh = stkh.executeQuery();
                while (rskh.next())
                {
                    String ho2 = (rskh.getString("Ho"));
                    String ten2 = (rskh.getString("Ten"));
                    String name2 = ho2 + " " + ten2;
                    hdkhachhang.addItem(name2);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    hdsach.addItem(tensach);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                hdid.setText(rowsstring);
                hdnhanvien.setSelectedIndex(0);
                hdkhachhang.setSelectedIndex(0);
                hdngaylap.setDate(datechange);
                hdsoluong.setText("");
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HoaDonTitleActionPerformed

    private void NCCTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCCTitleActionPerformed
        cardLayout.show(ContentTab, "ncccard");
        try {
            DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablencc);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                nccid.setText(idstring);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nccid.setText(rowsstring);
                nccname.setText("");
                nccdiachi.setText("");
                nccsdt.setText("");
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                nccid.setText(checklastidString);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nccid.setText(rowsstring);
                nccname.setText("");
                nccdiachi.setText("");
                nccsdt.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NCCTitleActionPerformed

    private void NhapHangTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapHangTitleActionPerformed
        cardLayout.show(ContentTab, "nhaphangcard");
        try {
            DefaultTableModel model = (DefaultTableModel) nhtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablenh);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                nhid.setText(idstring);
                nhnhanvien.removeAllItems();
                nhnxb.removeAllItems();
                nhsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String honv = (rs.getString("Ho"));
                    String tennv = (rs.getString("Ten"));
                    String nhanvien = honv + " " + tennv;
                    nhnhanvien.addItem(nhanvien);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    nhnxb.addItem(tennxb);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    nhsach.addItem(tensach);
                }
                connect.Close();
                nhngaynhap.setDate(datechange);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nhid.setText(rowsstring);
                nhnhanvien.setSelectedIndex(0);
                nhnxb.setSelectedIndex(0);
                nhsach.setSelectedIndex(0);
                nhsoluong.setText("");
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                nhid.setText(checklastidString);
                nhnhanvien.removeAllItems();
                nhnxb.removeAllItems();
                nhsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String honv = (rs.getString("Ho"));
                    String tennv = (rs.getString("Ten"));
                    String nhanvien = honv + " " + tennv;
                    nhnhanvien.addItem(nhanvien);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    nhnxb.addItem(tennxb);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    nhsach.addItem(tensach);
                }
                connect.Close();
                nhngaynhap.setDate(datechange);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nhid.setText(rowsstring);
                nhnhanvien.setSelectedIndex(0);
                nhnxb.setSelectedIndex(0);
                nhsach.setSelectedIndex(0);
                nhsoluong.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NhapHangTitleActionPerformed

    private void SachTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SachTitleActionPerformed
        cardLayout.show(ContentTab, "sachcard");
        try {
            DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesach);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                sachid.setText(idstring);
                sachloai.removeAllItems();
                sachnxb.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    sachloai.addItem(tenloai);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    sachnxb.addItem(tennxb);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                sachid.setText(rowsstring);
                sachname.setText("");
                sachtacgia.setText("");
                sachloai.setSelectedIndex(0);
                sachnxb.setSelectedIndex(0);
                sachdongia.setText("");
                sachsoluong.setText("");
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                sachid.setText(checklastidString);
                sachloai.removeAllItems();
                sachnxb.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    sachloai.addItem(tenloai);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    sachnxb.addItem(tennxb);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                sachid.setText(rowsstring);
                sachname.setText("");
                sachtacgia.setText("");
                sachloai.setSelectedIndex(0);
                sachnxb.setSelectedIndex(0);
                sachdongia.setText("");
                sachsoluong.setText("");
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SachTitleActionPerformed

    private void TaiKhoanTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiKhoanTitleActionPerformed
        cardLayout.show(ContentTab, "tkcard");
        try {

            DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,table);
            DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
            ctrler.cleartable(model2);
            ctrler.readdata(model2,tablenv);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                tkid.setText(idstring);
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stchucvu = (PreparedStatement) connection.prepareStatement("SELECT * FROM chucvu;");
                ResultSet rs = stchucvu.executeQuery();
                while (rs.next())
                {
                    String tencv = (rs.getString("tenchucvu"));
                    tkaddpower.addItem(tencv);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                tkid.setText(rowsstring);
                tkaddusername.setText("");
                tkaddpassword.setText("");
                tkaddpower.setSelectedIndex(0);
                tkho.setText("");
                tkten.setText("");
                tkngaysinh.setDate(datechange);
                tkemail.setText("");
                tkluong.setText("");
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                tkid.setText(checklastidString);
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stchucvu = (PreparedStatement) connection.prepareStatement("SELECT * FROM chucvu;");
                ResultSet rs = stchucvu.executeQuery();
                while (rs.next())
                {
                    String tencv = (rs.getString("tenchucvu"));
                    tkaddpower.addItem(tencv);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                tkid.setText(rowsstring);
                tkaddusername.setText("");
                tkaddpassword.setText("");
                tkaddpower.setSelectedIndex(0);
                tkho.setText("");
                tkten.setText("");
                tkngaysinh.setDate(datechange);
                tkemail.setText("");
                tkluong.setText("");
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TaiKhoanTitleActionPerformed

    private void MainTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainTitleActionPerformed
        cardLayout.show(ContentTab, "maincard");
    }//GEN-LAST:event_MainTitleActionPerformed

    private void thongketblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongketblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_thongketblMouseClicked

    private void thongketimkiembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongketimkiembtnActionPerformed
        if(thongketimkiemfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Điều Kiện!!");
        }
        if(!thongketimkiemfield.getText().equals(""))
        {
            DefaultTableModel model = (DefaultTableModel) thongketbl.getModel();
            String IDtext = thongketimkiemfield.getText();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablehoadon,IDtext);
        }
    }//GEN-LAST:event_thongketimkiembtnActionPerformed

    private void thongketbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongketbnActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) thongketbl.getModel();
            Date tkefrom = (Date) thongkefromdate.getDate();
            Date tketo = (Date) thongketodate.getDate();
            if(tketo.compareTo(tkefrom)<0)
            {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Ngày Kết Thúc Sau Ngày Bắt Đầu!!");
            return;     
            }
            String DateFrom = dateFormat.format(tkefrom.getTime());
            String DateTo = dateFormat.format(tketo.getTime());
            ctrler.cleartable(model);
            ctrler.DocDBThongkeDate(model,tablehoadon,tkefrom,tketo);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_thongketbnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void hdaddlistbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdaddlistbtnActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) hdtbl2.getModel();
            String ID = hdid.getText();
            if(hdsoluong.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng!!");
                return;
            }
            int SoLuongInt = Integer.parseInt(hdsoluong.getText());
            if(SoLuongInt<=0)
            {
                JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng Lớn Hơn 0!!");
                return;
            }
            String TongTien = "";
            int rows = model.getRowCount();
            int MaSach = hdsach.getSelectedIndex()+1;
            int SLint = 0;
            int TongTienint = 0;
            String MaLoai = "";
            String PhanTramGiam = "";
            String GiamGiaBD = "";
            String GiamGiaKT = "";
            String MaKM = "0";
            int PhanTramGiamint = 0;
            String MaSachText = String.valueOf(MaSach);
            String SoLuong = hdsoluong.getText();
            int SoLuongint = Integer.parseInt(SoLuong);
            //model.addRow(new Object[]{a,b});

            connect = new MyConnectUnitDAO();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach WHERE MASACH = " + MaSachText + ";");
            ResultSet rs = stsach.executeQuery();
            while (rs.next())
            {
                TongTien = (rs.getString("DonGia"));
                TongTienint = Integer.parseInt(TongTien);
                String SL = (rs.getString("SoLuong"));
                SLint = Integer.parseInt(SL);
                MaLoai = (rs.getString("MALOAI"));
            }
            PreparedStatement stcheckgiamgia = (PreparedStatement) connection.prepareStatement("SELECT * FROM khuyenmai WHERE MALOAI = " + MaLoai + ";");
            ResultSet rscheckgiamgia = stcheckgiamgia.executeQuery();
            while (rscheckgiamgia.next())
            {
                PhanTramGiam = (rscheckgiamgia.getString("PhanTramGiam"));
                PhanTramGiamint = Integer.parseInt(PhanTramGiam);
                MaKM = (rscheckgiamgia.getString("MAKM"));
            }
            if(SoLuongint>SLint)
            {
                JOptionPane.showMessageDialog(null, "Quá Số Lượng Sản Phẩm!!");
                return;
            }
            PreparedStatement stgiamgiadate = (PreparedStatement) connection.prepareStatement("SELECT * FROM chitietkhuyenmai WHERE MAKM = " + MaKM + ";");
            ResultSet rsgiamgiadate = stgiamgiadate.executeQuery();
            while (rsgiamgiadate.next())
            {
                GiamGiaBD = (rsgiamgiadate.getString("NgayBD"));
                GiamGiaKT = (rsgiamgiadate.getString("NgayKT"));
            }
            if(!GiamGiaBD.equals("") && !GiamGiaKT.equals(""))
            {
                Date datebd = dateFormat.parse(GiamGiaBD);
                Date datekt = dateFormat.parse(GiamGiaKT);
                if(datechange.before(datebd) || datechange.after(datekt))
                {
                    PhanTramGiamint = 0;
                    int ThanhTienpre = SoLuongint * TongTienint;
                    int ThanhTien = ThanhTienpre - ((ThanhTienpre*PhanTramGiamint)/100);
                    model.addRow(new Object[]{ID,MaSachText,TongTien,SoLuongint,PhanTramGiamint, ThanhTien});
                }
                if(datechange.before(datekt) && datechange.after(datebd))
                {

                    int ThanhTienpre = SoLuongint * TongTienint;
                    int ThanhTien = ThanhTienpre - ((ThanhTienpre*PhanTramGiamint)/100);
                    model.addRow(new Object[]{ID,MaSachText,TongTien,SoLuongint,PhanTramGiamint, ThanhTien});
                }
            }
            if(GiamGiaBD.equals("") || GiamGiaKT.equals(""))
            {
                PhanTramGiamint = 0;
                int ThanhTienpre = SoLuongint * TongTienint;
                int ThanhTien = ThanhTienpre - ((ThanhTienpre*PhanTramGiamint)/100);
                model.addRow(new Object[]{ID,MaSachText,TongTien,SoLuongint,PhanTramGiamint, ThanhTien});
            }

            connect.Close();

        }
        catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hdaddlistbtnActionPerformed

    private void hdpdfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdpdfbtnActionPerformed
        try {
            billpdf.WritePDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hdpdfbtnActionPerformed

    private void HDTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDTabActionPerformed
        cardLayout.show(ContentTab, "hdcard");
        try {
            DefaultTableModel model = (DefaultTableModel) hdtbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablehoadon);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                hdid.setText(idstring);
                hdnhanvien.removeAllItems();
                hdkhachhang.removeAllItems();
                hdsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stkh = (PreparedStatement) connection.prepareStatement("SELECT * FROM khachhang;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String ho = (rs.getString("Ho"));
                    String ten = (rs.getString("Ten"));
                    String name = ho + " " + ten;
                    hdnhanvien.addItem(name);
                }
                ResultSet rskh = stkh.executeQuery();
                while (rskh.next())
                {
                    String ho2 = (rskh.getString("Ho"));
                    String ten2 = (rskh.getString("Ten"));
                    String name2 = ho2 + " " + ten2;
                    hdkhachhang.addItem(name2);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    hdsach.addItem(tensach);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                hdid.setText(rowsstring);
                hdnhanvien.setSelectedIndex(0);
                hdkhachhang.setSelectedIndex(0);
                hdngaylap.setDate(datechange);
                hdsoluong.setText("");
                hdtimkiemfield.setText("");
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                hdid.setText(checklastidString);
                hdnhanvien.removeAllItems();
                hdkhachhang.removeAllItems();
                hdsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stkh = (PreparedStatement) connection.prepareStatement("SELECT * FROM khachhang;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String ho = (rs.getString("Ho"));
                    String ten = (rs.getString("Ten"));
                    String name = ho + " " + ten;
                    hdnhanvien.addItem(name);
                }
                ResultSet rskh = stkh.executeQuery();
                while (rskh.next())
                {
                    String ho2 = (rskh.getString("Ho"));
                    String ten2 = (rskh.getString("Ten"));
                    String name2 = ho2 + " " + ten2;
                    hdkhachhang.addItem(name2);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    hdsach.addItem(tensach);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                hdid.setText(rowsstring);
                hdnhanvien.setSelectedIndex(0);
                hdkhachhang.setSelectedIndex(0);
                hdngaylap.setDate(datechange);
                hdsoluong.setText("");
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HDTabActionPerformed

    private void TKTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKTabActionPerformed
        cardLayout.show(ContentTab, "thongkecard");
        try 
        {
            DefaultTableModel model = (DefaultTableModel) thongketbl.getModel();
            ctrler.cleartable(model);
            ctrler.DocDBThongke(model,tablehoadon);
            float ThanhTien = ctrler.TongThanhTien(tablehoadon);
                String ThanhTienText = String.valueOf(ThanhTien);
                tongthanhtienlbl.setText(ThanhTienText);
            int TongHoaDon = ctrler.TongHoaDon(tablehoadon);
                String TongHoaDonText = String.valueOf(TongHoaDon);
                tonghoadonlbl.setText(TongHoaDonText);
            float BQHD = ctrler.BinhQuanHoaDon(tablehoadon);
                String BQHDText = String.valueOf(BQHD);
                bqhdlbl.setText(BQHDText);
            float BQSP = ctrler.BinhQuanSanPham(tablehoadon,tablehoadonct);
                String BQSPText = String.valueOf(BQSP);
                bqsplbl.setText(BQSPText);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TKTabActionPerformed

    private void KMTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KMTabActionPerformed
        cardLayout.show(ContentTab, "kmcard");
        try {
            DefaultTableModel model = (DefaultTableModel) kmtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesale);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                kmid.setText(idstring);
                kmloaisach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    kmloaisach.addItem(tenloai);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                kmid.setText(rowsstring);
                kmname.setText("");
                kmphantram.setText("");
                kmloaisach.setSelectedIndex(0);
                kmngaybatdau.setDate(datechange);
                kmngayketthuc.setDate(datechange);
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                kmid.setText(checklastidString);
                kmloaisach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    kmloaisach.addItem(tenloai);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                kmid.setText(rowsstring);
                kmname.setText("");
                kmphantram.setText("");
                kmloaisach.setSelectedIndex(0);
                kmngaybatdau.setDate(datechange);
                kmngayketthuc.setDate(datechange);
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_KMTabActionPerformed

    private void TaiKhoanTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiKhoanTabActionPerformed
        cardLayout.show(ContentTab, "tkcard");
        try {

            DefaultTableModel model = (DefaultTableModel) tktbl1.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,table);
            DefaultTableModel model2 = (DefaultTableModel) tktbl2.getModel();
            ctrler.cleartable(model2);
            ctrler.readdata(model2,tablenv);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                tkid.setText(idstring);
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stchucvu = (PreparedStatement) connection.prepareStatement("SELECT * FROM chucvu;");
                ResultSet rs = stchucvu.executeQuery();
                while (rs.next())
                {
                    String tencv = (rs.getString("tenchucvu"));
                    tkaddpower.addItem(tencv);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                tkid.setText(rowsstring);
                tkaddusername.setText("");
                tkaddpassword.setText("");
                tkaddpower.setSelectedIndex(0);
                tkho.setText("");
                tkten.setText("");
                tkngaysinh.setDate(datechange);
                tkemail.setText("");
                tkluong.setText("");
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                tkid.setText(checklastidString);
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stchucvu = (PreparedStatement) connection.prepareStatement("SELECT * FROM chucvu;");
                ResultSet rs = stchucvu.executeQuery();
                while (rs.next())
                {
                    String tencv = (rs.getString("tenchucvu"));
                    tkaddpower.addItem(tencv);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                tkid.setText(rowsstring);
                tkaddusername.setText("");
                tkaddpassword.setText("");
                tkaddpower.setSelectedIndex(0);
                tkho.setText("");
                tkten.setText("");
                tkngaysinh.setDate(datechange);
                tkemail.setText("");
                tkluong.setText("");
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TaiKhoanTabActionPerformed

    private void SachTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SachTabActionPerformed
        cardLayout.show(ContentTab, "sachcard");
        try {
            DefaultTableModel model = (DefaultTableModel) sachtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablesach);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                sachid.setText(idstring);
                sachloai.removeAllItems();
                sachnxb.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    sachloai.addItem(tenloai);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    sachnxb.addItem(tennxb);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                sachid.setText(rowsstring);
                sachname.setText("");
                sachtacgia.setText("");
                sachloai.setSelectedIndex(0);
                sachnxb.setSelectedIndex(0);
                sachdongia.setText("");
                sachsoluong.setText("");
                connect.Close();
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                sachid.setText(checklastidString);
                sachloai.removeAllItems();
                sachnxb.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stloaisach = (PreparedStatement) connection.prepareStatement("SELECT * FROM loaisach;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                ResultSet rs = stloaisach.executeQuery();
                while (rs.next())
                {
                    String tenloai = (rs.getString("TenLoai"));
                    sachloai.addItem(tenloai);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    sachnxb.addItem(tennxb);
                }
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                sachid.setText(rowsstring);
                sachname.setText("");
                sachtacgia.setText("");
                sachloai.setSelectedIndex(0);
                sachnxb.setSelectedIndex(0);
                sachdongia.setText("");
                sachsoluong.setText("");
                connect.Close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SachTabActionPerformed

    private void NhapKhoTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapKhoTabActionPerformed
        cardLayout.show(ContentTab, "nhaphangcard");
        try {
            DefaultTableModel model = (DefaultTableModel) nhtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablenh);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                nhid.setText(idstring);
                nhnhanvien.removeAllItems();
                nhnxb.removeAllItems();
                nhsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String honv = (rs.getString("Ho"));
                    String tennv = (rs.getString("Ten"));
                    String nhanvien = honv + " " + tennv;
                    nhnhanvien.addItem(nhanvien);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    nhnxb.addItem(tennxb);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    nhsach.addItem(tensach);
                }
                connect.Close();
                nhngaynhap.setDate(datechange);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nhid.setText(rowsstring);
                nhnhanvien.setSelectedIndex(0);
                nhnxb.setSelectedIndex(0);
                nhsach.setSelectedIndex(0);
                nhsoluong.setText("");
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                nhid.setText(checklastidString);
                nhnhanvien.removeAllItems();
                nhnxb.removeAllItems();
                nhsach.removeAllItems();
                connect = new MyConnectUnitDAO();
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
                PreparedStatement stnv = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhanvien;");
                PreparedStatement stnxb = (PreparedStatement) connection.prepareStatement("SELECT * FROM nhacungcap;");
                PreparedStatement stsach = (PreparedStatement) connection.prepareStatement("SELECT * FROM sach;");
                ResultSet rs = stnv.executeQuery();
                while (rs.next())
                {
                    String honv = (rs.getString("Ho"));
                    String tennv = (rs.getString("Ten"));
                    String nhanvien = honv + " " + tennv;
                    nhnhanvien.addItem(nhanvien);
                }
                ResultSet rsnxb = stnxb.executeQuery();
                while (rsnxb.next())
                {
                    String tennxb = (rsnxb.getString("TenNCC"));
                    nhnxb.addItem(tennxb);
                }
                ResultSet rssach = stsach.executeQuery();
                while (rssach.next())
                {
                    String tensach = (rssach.getString("TenSach"));
                    nhsach.addItem(tensach);
                }
                connect.Close();
                nhngaynhap.setDate(datechange);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nhid.setText(rowsstring);
                nhnhanvien.setSelectedIndex(0);
                nhnxb.setSelectedIndex(0);
                nhsach.setSelectedIndex(0);
                nhsoluong.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NhapKhoTabActionPerformed

    private void NCCTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCCTabActionPerformed
        cardLayout.show(ContentTab, "ncccard");
        try {
            DefaultTableModel model = (DefaultTableModel) ncctbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablencc);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                nccid.setText(idstring);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nccid.setText(rowsstring);
                nccname.setText("");
                nccdiachi.setText("");
                nccsdt.setText("");
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                nccid.setText(checklastidString);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                nccid.setText(rowsstring);
                nccname.setText("");
                nccdiachi.setText("");
                nccsdt.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NCCTabActionPerformed

    private void KHTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KHTabActionPerformed
        cardLayout.show(ContentTab, "khachhangcard");
        try {
            DefaultTableModel model = (DefaultTableModel) khtbl.getModel();
            ctrler.cleartable(model);
            ctrler.readdata(model,tablekh);
            if(model.getRowCount()==0)
            {
                int rows = 1;
                String idstring = String.valueOf(rows);
                khid.setText(idstring);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                khid.setText(rowsstring);
                khho.setText("");
                khten.setText("");
                khdiachi.setText("");
                khsdt.setText("");
                khemail.setText("");
            }
            else
            {
                int rows = model.getRowCount()-1;
                String checklastid = (String) model.getValueAt(rows,0);
                int checklastidint = Integer.parseInt(checklastid)+1;
                String checklastidString = String.valueOf(checklastidint);
                khid.setText(checklastidString);
                int rows2 = model.getRowCount()+1;
                String rowsstring = String.valueOf(rows2);
                khid.setText(rowsstring);
                khho.setText("");
                khten.setText("");
                khdiachi.setText("");
                khsdt.setText("");
                khemail.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_KHTabActionPerformed

    private void salepdfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salepdfbtnActionPerformed
        try {
            khuyenmaipdf.WritePDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salepdfbtnActionPerformed

    private void khpdfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khpdfbtnActionPerformed
        try {
            customerpdf.WritePDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_khpdfbtnActionPerformed

    private void nccpdfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nccpdfbtnActionPerformed
        try {
            nccpdf.WritePDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nccpdfbtnActionPerformed

    private void nhaphangpdfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhaphangpdfbtnActionPerformed
        try {
            nhaphangpdf.WritePDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nhaphangpdfbtnActionPerformed

    private void sachpdfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachpdfbtnActionPerformed
        try {
            sachpdf.WritePDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sachpdfbtnActionPerformed

    private void taikhoanpdfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taikhoanpdfbtnActionPerformed
        try {
            taikhoanpdf.WritePDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_taikhoanpdfbtnActionPerformed

    private void thongketimkiemfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongketimkiemfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thongketimkiemfieldActionPerformed

    private void hdtimkiemfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdtimkiemfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hdtimkiemfieldActionPerformed
    
    
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        //Object readdbtkvar = new readdbtk().readdbtk(); 
        //readdbtk();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                try 
                {
                    new Mainboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Mainboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentTab;
    private javax.swing.JPanel DanhMucWrapper;
    private javax.swing.JButton HDTab;
    private javax.swing.JPanel HoaDonPanel;
    private javax.swing.JButton HoaDonTitle;
    private javax.swing.JButton HoaDonTitle1;
    private javax.swing.JButton KHTab;
    private javax.swing.JButton KMTab;
    private javax.swing.JPanel KhachHangPanel;
    private javax.swing.JButton KhachHangTitle;
    private javax.swing.JPanel KhuyenMaiPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton MainTitle;
    private javax.swing.JPanel NCCPanel;
    private javax.swing.JButton NCCTab;
    private javax.swing.JButton NCCTitle;
    private javax.swing.JPanel NhapHangPanel;
    private javax.swing.JButton NhapHangTitle;
    private javax.swing.JButton NhapKhoTab;
    private javax.swing.JPanel SachContent;
    private javax.swing.JPanel SachContent1;
    private javax.swing.JPanel SachContent2;
    private javax.swing.JPanel SachContent3;
    private javax.swing.JPanel SachPanel;
    private javax.swing.JButton SachTab;
    private javax.swing.JButton SachTitle;
    private javax.swing.JButton SaleTitle;
    private javax.swing.JPanel TKContent;
    private javax.swing.JPanel TKContent1;
    private javax.swing.JPanel TKContent2;
    private javax.swing.JPanel TKContent3;
    private javax.swing.JPanel TKContent4;
    private javax.swing.JButton TKTab;
    private javax.swing.JPanel TaiKhoanPanel;
    private javax.swing.JButton TaiKhoanTab;
    private javax.swing.JButton TaiKhoanTitle;
    private javax.swing.JPanel ThongKePanel;
    private javax.swing.JLabel bqhdlbl;
    private javax.swing.JLabel bqsplbl;
    private javax.swing.JButton exitbtn;
    private javax.swing.JButton hdaddbtn;
    private javax.swing.JButton hdaddlistbtn;
    private javax.swing.JButton hddeletebtn;
    private javax.swing.JButton hdexcelreadbtn;
    private javax.swing.JButton hdexcelwritebtn;
    private javax.swing.JTextField hdid;
    private javax.swing.JComboBox<String> hdkhachhang;
    private com.toedter.calendar.JDateChooser hdngaylap;
    private javax.swing.JComboBox<String> hdnhanvien;
    private javax.swing.JButton hdpdfbtn;
    private javax.swing.JButton hdresetbtn;
    private javax.swing.JComboBox<String> hdsach;
    private javax.swing.JTextField hdsoluong;
    private javax.swing.JTable hdtbl1;
    private javax.swing.JTable hdtbl2;
    private javax.swing.JButton hdtimkiembtn;
    private javax.swing.JTextField hdtimkiemfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton khaddbtn;
    private javax.swing.JButton khdeletebtn;
    private javax.swing.JTextField khdiachi;
    private javax.swing.JButton kheditbtn;
    private javax.swing.JTextField khemail;
    private javax.swing.JButton khexcelreadbtn1;
    private javax.swing.JButton khexcelwritebtn;
    private javax.swing.JTextField khho;
    private javax.swing.JTextField khid;
    private javax.swing.JButton khpdfbtn;
    private javax.swing.JButton khresetbtn;
    private javax.swing.JTextField khsdt;
    private javax.swing.JTable khtbl;
    private javax.swing.JTextField khten;
    private javax.swing.JButton khtimkiembtn;
    private javax.swing.JTextField khtimkiemfield;
    private javax.swing.JButton kmaddbtn;
    private javax.swing.JButton kmdeletebtn;
    private javax.swing.JButton kmeditbtn;
    private javax.swing.JButton kmexcelreadbtn;
    private javax.swing.JButton kmexcelwritebtn;
    private javax.swing.JTextField kmid;
    private javax.swing.JComboBox<String> kmloaisach;
    private javax.swing.JTextField kmname;
    private com.toedter.calendar.JDateChooser kmngaybatdau;
    private com.toedter.calendar.JDateChooser kmngayketthuc;
    private javax.swing.JTextField kmphantram;
    private javax.swing.JButton kmresetbtn;
    private javax.swing.JTable kmtbl;
    private javax.swing.JButton kmtimkiembtn;
    private javax.swing.JTextField kmtimkiemfield;
    private javax.swing.JButton nccaddbtn;
    private javax.swing.JButton nccdeletebtn;
    private javax.swing.JTextField nccdiachi;
    private javax.swing.JButton ncceditbtn;
    private javax.swing.JButton nccexcelreadbtn;
    private javax.swing.JButton nccexcelwritebtn;
    private javax.swing.JTextField nccid;
    private javax.swing.JTextField nccname;
    private javax.swing.JButton nccpdfbtn;
    private javax.swing.JButton nccresetbtn;
    private javax.swing.JTextField nccsdt;
    private javax.swing.JTable ncctbl;
    private javax.swing.JButton ncctimkiembtn;
    private javax.swing.JTextField ncctimkiemfield;
    private javax.swing.JButton nhaddbtn;
    private javax.swing.JButton nhaphangpdfbtn;
    private javax.swing.JButton nhexcelreadbtn;
    private javax.swing.JButton nhexcelwritebtn;
    private javax.swing.JTextField nhid;
    private com.toedter.calendar.JDateChooser nhngaynhap;
    private javax.swing.JComboBox<String> nhnhanvien;
    private javax.swing.JComboBox<String> nhnxb;
    private javax.swing.JButton nhresetbtn;
    private javax.swing.JComboBox<String> nhsach;
    private javax.swing.JTextField nhsoluong;
    private javax.swing.JTable nhtbl;
    private javax.swing.JButton nhtimkiembtn;
    private javax.swing.JTextField nhtimkiemfield;
    private javax.swing.JButton sachaddbtn;
    private javax.swing.JButton sachdeletebtn;
    private javax.swing.JTextField sachdongia;
    private javax.swing.JButton sacheditbtn;
    private javax.swing.JButton sachexcelreadbtn;
    private javax.swing.JButton sachexcelwritebtn;
    private javax.swing.JTextField sachid;
    private javax.swing.JComboBox<String> sachloai;
    private javax.swing.JTextField sachname;
    private javax.swing.JComboBox<String> sachnxb;
    private javax.swing.JButton sachpdfbtn;
    private javax.swing.JButton sachresetbtn;
    private javax.swing.JTextField sachsoluong;
    private javax.swing.JTextField sachtacgia;
    private javax.swing.JTable sachtbl;
    private javax.swing.JButton sachtimkiembtn;
    private javax.swing.JTextField sachtimkiemfield;
    private javax.swing.JButton salepdfbtn;
    private javax.swing.JButton taikhoanpdfbtn;
    private com.toedter.calendar.JDateChooser thongkefromdate;
    private javax.swing.JTable thongketbl;
    private javax.swing.JButton thongketbn;
    private javax.swing.JButton thongketimkiembtn;
    private javax.swing.JTextField thongketimkiemfield;
    private com.toedter.calendar.JDateChooser thongketodate;
    private javax.swing.JButton tkaddbtn;
    private javax.swing.JTextField tkaddpassword;
    private javax.swing.JComboBox<String> tkaddpower;
    private javax.swing.JTextField tkaddusername;
    private javax.swing.JButton tkdeletebtn;
    private javax.swing.JButton tkeditbtn;
    private javax.swing.JTextField tkemail;
    private javax.swing.JButton tkexcelreadbtn;
    private javax.swing.JButton tkexcelwritebtn;
    private javax.swing.JTextField tkho;
    private javax.swing.JTextField tkid;
    private javax.swing.JTextField tkluong;
    private com.toedter.calendar.JDateChooser tkngaysinh;
    private javax.swing.JButton tkresetbtn;
    private javax.swing.JTable tktbl1;
    private javax.swing.JTable tktbl2;
    private javax.swing.JTextField tkten;
    private javax.swing.JButton tktimkiembtn;
    private javax.swing.JTextField tktimkiemfield;
    private javax.swing.JLabel tonghoadonlbl;
    private javax.swing.JLabel tongthanhtienlbl;
    // End of variables declaration//GEN-END:variables

}
