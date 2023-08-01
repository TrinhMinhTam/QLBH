package QLNhaSach.Excel;

import QLNhaSach.BUS.DetailSaleBUS;
import QLNhaSach.BUS.SaleBUS;
import QLNhaSach.DAO.DetailSaleDAO;
import QLNhaSach.DAO.MyConnectUnitDAO;
import QLNhaSach.DAO.SaleDAO;
import QLNhaSach.DTO.DetailSaleDTO;
import QLNhaSach.DTO.SaleDTO;
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
 

public class SaleExcel 
{
    MyConnectUnitDAO connect;
    DetailSaleDAO saledao = new DetailSaleDAO();
    DetailSaleDTO saledto = new DetailSaleDTO();
    SaleDAO saledtdao = new SaleDAO();
    SaleDTO saledtdto = new SaleDTO();
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
        HSSFSheet sheet = workbook.createSheet("Sale");
        HSSFSheet sheet2 = workbook.createSheet("DetailSale");
        
        DetailSaleDAO saleDAO = new DetailSaleDAO();
        SaleDAO saledtDAO = new SaleDAO();
        List<DetailSaleDTO> listSales = saleDAO.listSales();
        List<SaleDTO> listDetailSales = saledtDAO.listDetailSales();
        //List<DetailSaleDTO> saleounts = DetailSaleDAO.listDetailSales();

 
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
        cell.setCellValue("Mã Khuyến Mãi");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Mã Loại");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Phần Trăm Giảm");
        cell.setCellStyle(style);
 
        // Data
        for (DetailSaleDTO sale : listSales) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // EmpNo (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(sale.getCodeSale());
            // EmpName (B)
            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(sale.getCodeBook());
            // Salary (C)
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(sale.getPercentSale());
        }
        
        
        row2 = sheet2.createRow(rownum2);
 
        // EmpNo
        cell2 = row2.createCell(0, CellType.NUMERIC);
        cell2.setCellValue("Mã Khuyến Mãi");
        cell2.setCellStyle(style);
        // EmpName
        cell2 = row2.createCell(1, CellType.STRING);
        cell2.setCellValue("Tên Khuyến Mãi");
        cell2.setCellStyle(style);
        // Salary
        cell2 = row2.createCell(2, CellType.STRING);
        cell2.setCellValue("Ngày BĐ");
        cell2.setCellStyle(style);
        // Grade
        cell2 = row2.createCell(3, CellType.STRING);
        cell2.setCellValue("Ngày KT");
        cell2.setCellStyle(style);
 
        // Data
        for (SaleDTO saledt : listDetailSales) {
            rownum2++;
            row2 = sheet2.createRow(rownum2);
 
            // EmpNo (A)
            cell2 = row2.createCell(0, CellType.NUMERIC);
            cell2.setCellValue(saledt.getCodeSale());
            // EmpName (B)
            cell2 = row2.createCell(1, CellType.STRING);
            cell2.setCellValue(saledt.getNameSale());
            // Salary (C)
            cell2 = row2.createCell(2, CellType.STRING);
            cell2.setCellValue(saledt.getStartDay());
            // Grade (D)
            cell2 = row2.createCell(3, CellType.STRING);
            cell2.setCellValue(saledt.getEndDay());
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
        
       DetailSaleBUS salebus = new DetailSaleBUS();
       SaleBUS saledtbus = new SaleBUS();
       ArrayList<String> sale = new ArrayList<>();
       ArrayList<String> saledt = new ArrayList<>();
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File(filePath));
       
       connect = new MyConnectUnitDAO();
       Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
       PreparedStatement st = (PreparedStatement) connection.prepareStatement("DELETE FROM khuyenmai;");  
       PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("DELETE FROM chitietkhuyenmai;"); 
       int results = st.executeUpdate();
       int results2 = st2.executeUpdate();
       connect.Close();
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheet("Sale");

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
                   sale.add(rounded);
                   }
                   //System.out.print(b);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer = cell.getStringCellValue();
                   if(indexrow!=0)
                   {
                   sale.add(pointer);
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
           System.out.println(sale);
           String a=sale.get(0);
           int aint = Integer.parseInt(a);
           saledto.setCodeSale(aint);
           String b=sale.get(1);
           int bint = Integer.parseInt(b);
           saledto.setCodeBook(bint);
           String c=sale.get(2);
           int cint = Integer.parseInt(c);
           saledto.setPercentSale(cint);
           sale.clear();
           salebus.them(saledto);
           }
            indexrow++;
       }
       
       HSSFSheet sheet2 = workbook.getSheet("DetailSale");
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
                   saledt.add(rounded2);
                   }
                   System.out.print(rounded2);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer2 = cell2.getStringCellValue();
                   if(indexrow2!=0)
                   {
                   saledt.add(pointer2);
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
           System.out.println(saledt);
           String a=saledt.get(0);
           saledtdto.setCodeSale(a);
           
           String b=saledt.get(1);
           saledtdto.setNameSale(b);
           
           String c=saledt.get(2);
           saledtdto.setStartDay(c);
           
           String d=saledt.get(3);
           saledtdto.setEndDay(d);
           
           saledt.clear();
           saledtbus.them(saledtdto);
           }
            indexrow2++;
       }
       }
    }
}