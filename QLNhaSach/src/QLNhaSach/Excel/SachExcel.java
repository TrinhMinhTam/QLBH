package QLNhaSach.Excel;

import QLNhaSach.BUS.BookBUS;
import QLNhaSach.DAO.BookDAO;
import QLNhaSach.DAO.MyConnectUnitDAO;
import QLNhaSach.DTO.BookDTO;
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
 

public class SachExcel 
{
    MyConnectUnitDAO connect;
    BookDAO bookdao = new BookDAO();
    BookDTO bookdto = new BookDTO();

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
        HSSFSheet sheet = workbook.createSheet("Book");
        
        BookDAO sachDAO = new BookDAO();
        List<BookDTO> listBooks = sachDAO.listBooks();
        //List<AccountDTO> accounts = AccountDAO.listAccounts();

 
        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);
 
        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã Sách");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Nhà Xuất Bản");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Mã Loại");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Tên Sách");
        cell.setCellStyle(style);
        
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Tác Giả");
        cell.setCellStyle(style);
        
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Đơn Giá");
        cell.setCellStyle(style);
        
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Số Lượng");
        cell.setCellStyle(style);
 
        // Data
        for (BookDTO bk : listBooks) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // EmpNo (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(bk.getCodeBook());
            // EmpName (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(bk.getPublishingCompany());
            // Salary (C)
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(bk.getCodeKindOfBook());
            // Grade (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(bk.getBookName());
            
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(bk.getAuthor());
            
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(bk.getUnitPrice());
            
            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue(bk.getNumber());
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
        
       BookBUS bookbus = new BookBUS();
       ArrayList<String> book = new ArrayList<>();
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File(filePath));
       
       connect = new MyConnectUnitDAO();
       Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
       PreparedStatement st = (PreparedStatement) connection.prepareStatement("DELETE FROM sach;");  
       int results = st.executeUpdate();
       connect.Close();
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheet("Book");

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
                   book.add(rounded);
                   }
                   //System.out.print(b);
                   System.out.print("\t");
                   break;


               case STRING:
                   String pointer = cell.getStringCellValue();
                   if(indexrow!=0)
                   {
                   book.add(pointer);
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
           System.out.println(book);
           String a=book.get(0);
           bookdto.setCodeBook(a);
           String b=book.get(1);
           bookdto.setPublishingCompany(b);
           String c=book.get(2);
           bookdto.setCodeKindOfBook(c);
           String d=book.get(3);          
           bookdto.setBookName(d);
           String e=book.get(4);
           bookdto.setAuthor(e);
           String f=book.get(5);
           int fint = Integer.parseInt(f);
           bookdto.setUnitPrice(fint);
           String g=book.get(6);
           int gint = Integer.parseInt(g);
           bookdto.setNumber(gint);
           book.clear();
          bookbus.Add(bookdto);
           }
            indexrow++;
       }
              
       }
    }
}