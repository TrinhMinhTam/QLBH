package QLNhaSach.Excel;

import QLNhaSach.BUS.BillBUS;
import QLNhaSach.BUS.DetailBillBUS;
import QLNhaSach.DAO.BillDAO;
import QLNhaSach.DAO.MyConnectUnitDAO;
import QLNhaSach.DAO.DetailBillDAO;
import QLNhaSach.DTO.BillDTO;
import QLNhaSach.DTO.DetailBillDTO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
 
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
 

public class HoaDonExcel 
{
    MyConnectUnitDAO connect;
    BillDAO billdao = new BillDAO();
    BillDTO billdto = new BillDTO();
    DetailBillDAO detailbilldao = new DetailBillDAO();
    DetailBillDTO detailbilldto = new DetailBillDTO();
    JFileChooser opensave = new JFileChooser();
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    public void WriteExcel() throws FileNotFoundException, IOException, Exception{
        int rVal = opensave.showSaveDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) 
        {
        String filename = opensave.getSelectedFile().getName();
        String dir = opensave.getCurrentDirectory().toString();
        
        String filePath = dir+"\\"+filename+".xls";
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bill");
        HSSFSheet sheet2 = workbook.createSheet("DetailBill");
        
        BillDAO billDAO = new BillDAO();
        DetailBillDAO detailbillDAO = new DetailBillDAO();
        List<BillDTO> listBills = billDAO.listBills();
        List<DetailBillDTO> listDetailBills = detailbillDAO.listDetailBills();
        //List<BillDTO> bills = BillDAO.listBills();

 
        int rownum = 0;
        int rownum2 = 0;
        Cell cell;
        Row row;
        Cell cell2;
        Row row2;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);
 
        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("MaHD");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("MaNV");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("MaKH");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Ngày Lập HĐ");
        cell.setCellStyle(style);
        
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Thành Tiền");
        cell.setCellStyle(style);
 
        // Data
        for (BillDTO bill : listBills) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // EmpNo (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(bill.getCodeBill());
            // EmpName (B)
            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(bill.getCodeStaff());
            // Salary (C)
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(bill.getCodeCustomer());
            // Grade (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(bill.getDaySale());
            
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(bill.getThanhTien());
        }
        
        
        row2 = sheet2.createRow(rownum2);
 
        // EmpNo
        cell2 = row2.createCell(0, CellType.STRING);
        cell2.setCellValue("MaHD");
        cell2.setCellStyle(style);
        // EmpName
        cell2 = row2.createCell(1, CellType.STRING);
        cell2.setCellValue("Mã Sách");
        cell2.setCellStyle(style);
        // Salary
        cell2 = row2.createCell(2, CellType.STRING);
        cell2.setCellValue("Đơn Giá");
        cell2.setCellStyle(style);
        // Grade
        cell2 = row2.createCell(3, CellType.STRING);
        cell2.setCellValue("Số Lượng");
        cell2.setCellStyle(style);
        
        cell2 = row2.createCell(4, CellType.STRING);
        cell2.setCellValue("Giảm Giá");
        cell2.setCellStyle(style);
        
        cell2 = row2.createCell(5, CellType.STRING);
        cell2.setCellValue("Thành Tiền");
        cell2.setCellStyle(style);
 
        // Data
        for (DetailBillDTO detailbill : listDetailBills) {
            rownum2++;
            row2 = sheet2.createRow(rownum2);
 
            // EmpNo (A)
            cell2 = row2.createCell(0, CellType.NUMERIC);
            cell2.setCellValue(detailbill.getCodeBill());
            // EmpName (B)
            cell2 = row2.createCell(1, CellType.NUMERIC);
            cell2.setCellValue(detailbill.getCodeBook());
            // Salary (C)
            cell2 = row2.createCell(2, CellType.NUMERIC);
            cell2.setCellValue(detailbill.getPrice());
            // Grade (D)
            cell2 = row2.createCell(3, CellType.NUMERIC);
            cell2.setCellValue(detailbill.getNumber());
            
            cell2 = row2.createCell(4, CellType.NUMERIC);
            cell2.setCellValue(detailbill.getSale());
            
            cell2 = row2.createCell(5, CellType.NUMERIC);
            cell2.setCellValue(detailbill.getTotal());
        }
        
        File file = new File(filePath);
        file.setWritable(true);
        file.canWrite();
        //file.getParentFile().mkdirs();
 
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        outFile.close();
        System.out.println("Created file: " + file.getAbsolutePath());
        
        }
    }
    public void ReadExcel() throws FileNotFoundException, IOException, SQLException, Exception {
       int rVal = opensave.showOpenDialog(null);
       if (rVal == JFileChooser.APPROVE_OPTION) 
       {
       String filename = opensave.getSelectedFile().getName();
       String dir = opensave.getCurrentDirectory().toString();        
        
       String filePath = dir+"\\"+filename;
        
       BillBUS billbus = new BillBUS();
       DetailBillBUS detailbillbus = new DetailBillBUS();
       ArrayList<String> bill = new ArrayList<>();
       ArrayList<String> detailbill = new ArrayList<>();
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File(filePath));
       
       connect = new MyConnectUnitDAO();
       Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
       PreparedStatement st = (PreparedStatement) connection.prepareStatement("DELETE FROM hoadon;");  
       PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("DELETE FROM chitiethoadon;"); 
       int results = st.executeUpdate();
       int results2 = st2.executeUpdate();
       connect.Close();
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheet("Bill");

       // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
       Iterator<Row> rowIterator = sheet.iterator();
       int indexrow=0;
       while (rowIterator.hasNext()) 
       {
           Row row = rowIterator.next();
     
           // Lấy Iterator cho tất cả các cell của dòng hiện tại.
           Iterator<Cell> cellIterator = row.cellIterator();
 
           while (cellIterator.hasNext()) 
           {
               Cell cell = cellIterator.next();
  
               // Đổi thành getCellType() nếu sử dụng POI 4.x
               CellType cellType = cell.getCellType();
 
               switch (cellType) {
               case _NONE:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case BOOLEAN:
                   System.out.print(cell.getBooleanCellValue());
                   System.out.print("\t");
                   break;
               case BLANK:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case FORMULA:
       
                   // Công thức
                   System.out.print(cell.getCellFormula());
                   System.out.print("\t");
                    
                   FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
         
                   // In ra giá trị từ công thức
                   System.out.print(evaluator.evaluate(cell).getNumberValue());
                   break;
               case NUMERIC:
                   Double pointernum = cell.getNumericCellValue();
                   String rounded = String.format("%.0f", pointernum);
                   if(indexrow!=0)
                   {
                   bill.add(rounded);
                   }
                   //System.out.print(b);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer = cell.getStringCellValue();
                   if(indexrow!=0)
                   {
                   bill.add(pointer);
                   }
                  // System.out.print(a);
                   System.out.print("\t");
                   break;
               case ERROR:
                   System.out.print("!");
                   System.out.print("\t");
                   break;
               }
           
           }
           
           if(indexrow!=0)
           {
           System.out.println("");
           System.out.println(bill);
           String a=bill.get(0);
           billdto.setCodeBill(a);
           String b=bill.get(1);
           billdto.setCodeStaff(b);
           String c=bill.get(2);
           billdto.setCodeCustomer(c);
           String d=bill.get(3);
           billdto.setDaySale(d);
           String e=bill.get(4);
           float efloat = Float.parseFloat(e);
           billdto.setThanhTien(efloat);
           bill.clear();
           billbus.them(billdto);
           }
            indexrow++;
       }
       
       HSSFSheet sheet2 = workbook.getSheet("DetailBill");
       Iterator<Row> rowIterator2 = sheet2.iterator();
       int indexrow2=0;
       while (rowIterator2.hasNext()) 
       {
           Row row2 = rowIterator2.next();
     
           // Lấy Iterator cho tất cả các cell của dòng hiện tại.
           Iterator<Cell> cellIterator2 = row2.cellIterator();
 
           while (cellIterator2.hasNext()) 
           {
               Cell cell2 = cellIterator2.next();
  
               // Đổi thành getCellType() nếu sử dụng POI 4.x
               CellType cellType2 = cell2.getCellType();
 
               switch (cellType2) {
               case _NONE:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case BOOLEAN:
                   System.out.print(cell2.getBooleanCellValue());
                   System.out.print("\t");
                   break;
               case BLANK:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case FORMULA:
       
                   // Công thức
                   System.out.print(cell2.getCellFormula());
                   System.out.print("\t");
                    
                   FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
         
                   // In ra giá trị từ công thức
                   System.out.print(evaluator.evaluate(cell2).getNumberValue());
                   break;
               case NUMERIC:
                   Double pointernum2 = cell2.getNumericCellValue();
                   String rounded2 = String.format("%.0f", pointernum2);
                   if(indexrow2!=0)
                   {
                   detailbill.add(rounded2);
                   }
                   System.out.print(rounded2);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer2 = cell2.getStringCellValue();
                   if(indexrow2!=0)
                   {
                   detailbill.add(pointer2);
                   }
                   System.out.print(pointer2);
                   System.out.print("\t");
                   break;
               case ERROR:
                   System.out.print("!");
                   System.out.print("\t");
                   break;
               }
           
           }
           
           if(indexrow2!=0)
           {
           System.out.println("");
           System.out.println(detailbill);
           String a=detailbill.get(0);
           detailbilldto.setCodeBill(a);
           
           String b=detailbill.get(1);
           detailbilldto.setCodeBook(b);
           
           String c=detailbill.get(2);
           int cint = Integer.parseInt(c);
           detailbilldto.setPrice(cint);
           
           String d=detailbill.get(3);
           int dint = Integer.parseInt(d);
           detailbilldto.setNumber(dint);
           
           String e=detailbill.get(4);
           int eint = Integer.parseInt(e);
           detailbilldto.setSale(eint);
           
           String f=detailbill.get(5);
           float fint = Float.parseFloat(f);
           detailbilldto.setTotal(fint);
           
           detailbill.clear();
           detailbillbus.Add(detailbilldto);
           }
            indexrow2++;
       }
       }
    }
}