package QLNhaSach.Excel;

import QLNhaSach.BUS.AccountBUS;
import QLNhaSach.BUS.StaffBUS;
import QLNhaSach.DAO.AccountDAO;
import QLNhaSach.DAO.MyConnectUnitDAO;
import QLNhaSach.DAO.StaffDAO;
import QLNhaSach.DTO.AccountDTO;
import QLNhaSach.DTO.StaffDTO;
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
 

public class TaiKhoanExcel 
{
    MyConnectUnitDAO connect;
    AccountDAO accdao = new AccountDAO();
    AccountDTO accdto = new AccountDTO();
    StaffDAO stfdao = new StaffDAO();
    StaffDTO stfdto = new StaffDTO();
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
        HSSFSheet sheet = workbook.createSheet("Accounts");
        HSSFSheet sheet2 = workbook.createSheet("Staff");
        
        AccountDAO accDAO = new AccountDAO();
        StaffDAO stfDAO = new StaffDAO();
        List<AccountDTO> listAccounts = accDAO.listAccounts();
        List<StaffDTO> listStaffs = stfDAO.listStaffs();
        //List<AccountDTO> accounts = AccountDAO.listAccounts();

 
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
        cell.setCellValue("ID");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên Tài Khoản");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Mật Khẩu");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Chức Danh");
        cell.setCellStyle(style);
 
        // Data
        for (AccountDTO acc : listAccounts) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // EmpNo (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(acc.getID());
            // EmpName (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(acc.getUserName());
            // Salary (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(acc.getPassword());
            // Grade (D)
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(acc.getLevel());
        }
        
        
        row2 = sheet2.createRow(rownum2);
 
        // EmpNo
        cell2 = row2.createCell(0, CellType.STRING);
        cell2.setCellValue("ID");
        cell2.setCellStyle(style);
        // EmpName
        cell2 = row2.createCell(1, CellType.STRING);
        cell2.setCellValue("Họ");
        cell2.setCellStyle(style);
        // Salary
        cell2 = row2.createCell(2, CellType.STRING);
        cell2.setCellValue("Tên");
        cell2.setCellStyle(style);
        // Grade
        cell2 = row2.createCell(3, CellType.STRING);
        cell2.setCellValue("Ngày Sinh");
        cell2.setCellStyle(style);
        
        cell2 = row2.createCell(4, CellType.STRING);
        cell2.setCellValue("Email");
        cell2.setCellStyle(style);
        
        cell2 = row2.createCell(5, CellType.STRING);
        cell2.setCellValue("Lương");
        cell2.setCellStyle(style);
 
        // Data
        for (StaffDTO stf : listStaffs) {
            rownum2++;
            row2 = sheet2.createRow(rownum2);
 
            // EmpNo (A)
            cell2 = row2.createCell(0, CellType.NUMERIC);
            cell2.setCellValue(stf.getCodeStaff());
            // EmpName (B)
            cell2 = row2.createCell(1, CellType.STRING);
            cell2.setCellValue(stf.getLastName());
            // Salary (C)
            cell2 = row2.createCell(2, CellType.STRING);
            cell2.setCellValue(stf.getFirstName());
            // Grade (D)
            cell2 = row2.createCell(3, CellType.STRING);
            cell2.setCellValue(stf.getDateOfBirth());
            
            cell2 = row2.createCell(4, CellType.STRING);
            cell2.setCellValue(stf.getEmail());
            
            cell2 = row2.createCell(5, CellType.NUMERIC);
            cell2.setCellValue(stf.getSalary());
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
        
       AccountBUS accbus = new AccountBUS();
       StaffBUS stfbus = new StaffBUS();
       ArrayList<String> account = new ArrayList<>();
       ArrayList<String> staff = new ArrayList<>();
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File(filePath));
       
       connect = new MyConnectUnitDAO();
       Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
       PreparedStatement st = (PreparedStatement) connection.prepareStatement("DELETE FROM tbltaikhoan;");  
       PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("DELETE FROM nhanvien;"); 
       int results = st.executeUpdate();
       int results2 = st2.executeUpdate();
       connect.Close();
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheet("Accounts");

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
                   account.add(rounded);
                   }
                   //System.out.print(b);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer = cell.getStringCellValue();
                   if(indexrow!=0)
                   {
                   account.add(pointer);
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
           System.out.println(account);
           String a=account.get(0);
           int aint = Integer.parseInt(a);
           accdto.setID(aint);
           String b=account.get(1);
           accdto.setUserName(b);
           String c=account.get(2);
           accdto.setPassword(c);
           String d=account.get(3);
           int dint = Integer.parseInt(d);
           accdto.setLevel(dint);
           account.clear();
           accbus.Add(accdto);
           }
            indexrow++;
       }
       
       HSSFSheet sheet2 = workbook.getSheet("Staff");
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
                   staff.add(rounded2);
                   }
                   System.out.print(rounded2);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer2 = cell2.getStringCellValue();
                   if(indexrow2!=0)
                   {
                   staff.add(pointer2);
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
           System.out.println(staff);
           String a=staff.get(0);
           stfdto.setCodeStaff(a);
           
           String b=staff.get(1);
           stfdto.setLastName(b);
           
           String c=staff.get(2);
           stfdto.setFirstName(c);
           
           String d=staff.get(3);
           stfdto.setDateOfBirth(d);
           
           String e=staff.get(4);
           stfdto.setEmail(e);
           
           String f=staff.get(5);
           float fint = Float.parseFloat(f);
           stfdto.setSalary(fint);
           
           staff.clear();
           stfbus.them(stfdto);
           }
            indexrow2++;
       }
       }
    }
}