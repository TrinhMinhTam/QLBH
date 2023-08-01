package QLNhaSach.Excel;

import QLNhaSach.BUS.SupplierBUS;
import QLNhaSach.DAO.SupplierDAO;
import QLNhaSach.DAO.MyConnectUnitDAO;
import QLNhaSach.DTO.SupplierDTO;
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
 

public class NCCExcel 
{
    MyConnectUnitDAO connect;
    SupplierDAO splydao = new SupplierDAO();
    SupplierDTO splydto = new SupplierDTO();

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
        HSSFSheet sheet = workbook.createSheet("Suppliers");
        
        SupplierDAO splydao = new SupplierDAO();
        List<SupplierDTO> listSuppliers = splydao.listSuppliers();
        //List<AccountDTO> accounts = AccountDAO.listAccounts();

 
        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);
 
        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã NCC");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên NCC");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Địa Chỉ");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Sđt");
        cell.setCellStyle(style);        
 
        // Data
        for (SupplierDTO sp : listSuppliers) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // EmpNo (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(sp.getCodeSupplier());
            // EmpName (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(sp.getNameSupplier());
            // Salary (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(sp.getAddressSupplier());
            // Grade (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(sp.getPhonenumberSupplier());
            
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
        
       SupplierBUS splybus = new SupplierBUS();
       ArrayList<String> sply = new ArrayList<>();
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File(filePath));
       
       connect = new MyConnectUnitDAO();
       Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
       PreparedStatement st = (PreparedStatement) connection.prepareStatement("DELETE FROM nhacungcap;");  
       int results = st.executeUpdate();
       connect.Close();
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheet("Suppliers");

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
                   sply.add(rounded);
                   }
                   //System.out.print(b);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer = cell.getStringCellValue();
                   if(indexrow!=0)
                   {
                   sply.add(pointer);
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
           System.out.println(sply);
           String a=sply.get(0);
           splydto.setCodeSupplier(a);
           String b=sply.get(1);
           splydto.setNameSupplier(b);
           String c=sply.get(2);
           splydto.setAddressSupplier(c);
           String d=sply.get(3);          
           splydto.setPhonenumberSupplier(d);
           sply.clear();
           splybus.them(splydto);
           }
            indexrow++;
       }
              
       }
    }
}