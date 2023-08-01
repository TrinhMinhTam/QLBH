/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLNhaSach.GUI;

import QLNhaSach.BUS.AccountBUS;
import QLNhaSach.DAO.AccountDAO;
import QLNhaSach.DTO.AccountDTO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Controller {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    public void readdata(DefaultTableModel model, String table) throws SQLException, Exception
    {
            String a,b,c,d,e,f,g,h;
            ArrayList<String> data = new ArrayList<String>();
            //DefaultTableModel model = (DefaultTableModel) table.getModel();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table +";");
            //String sql="SELECT * FROM hwList";
            
            //Statement statement = (Statement) connection.createStatement(); 
            //ResultSet results = statement.executeQuery("SELECT * FROM "+table);
            
            ResultSet results = st.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
            
            int columnCount = metadata.getColumnCount();
            for (int i=1; i<=columnCount; i++) 
                {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
                }
            if(columnCount==2)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    model.addRow(new Object[]{a,b}); 
                }  
            }
            if(columnCount==3)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    model.addRow(new Object[]{a,b,c}); 
                }  
            }
            if(columnCount==4)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    model.addRow(new Object[]{a,b,c,d}); 
                }  
            }
            if(columnCount==5)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    model.addRow(new Object[]{a,b,c,d,e}); 
                }  
            }
            if(columnCount==6)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    f = results.getString(data.get(5));
                    model.addRow(new Object[]{a,b,c,d,e,f}); 
                }  
            }
            if(columnCount==7)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    f = results.getString(data.get(5));
                    g = results.getString(data.get(6));
                    model.addRow(new Object[]{a,b,c,d,e,f,g}); 
                }  
            }
            if(columnCount==8)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    f = results.getString(data.get(5));
                    g = results.getString(data.get(6));
                    h = results.getString(data.get(7));
                    model.addRow(new Object[]{a,b,c,d,e,f,g,h}); 
                }  
            }
    }           
    public void readdata(DefaultTableModel model,String table,String condition)
    {
        try {
            String a,b,c,d,e,f,g,h;
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            
            PreparedStatement st1 = (PreparedStatement) connection.prepareStatement("Select * FROM " + table);
            ResultSet results2 = st1.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results2.getMetaData();
            ArrayList<String> data = new ArrayList<String>();
            int columnCount = metadata.getColumnCount(); 
            
            for (int i=1; i<=columnCount; i++)
            {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
            }
            String index = data.get(0);
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM " + table + " WHERE " + index +"= " + condition);
            ResultSet results = st.executeQuery();
            //DefaultTableModel model = (DefaultTableModel) table.getModel();  
            if(columnCount==2)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    model.addRow(new Object[]{a,b});
                }  
            }
            if(columnCount==3)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    model.addRow(new Object[]{a,b,c});
                }  
            }
            if(columnCount==4)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    model.addRow(new Object[]{a,b,c,d});
                }  
            }
            if(columnCount==5)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    model.addRow(new Object[]{a,b,c,d,e});
                }  
            }
            if(columnCount==6)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    f = results.getString(data.get(5));
                    model.addRow(new Object[]{a,b,c,d,e,f});
                }  
            }
            if(columnCount==7)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    f = results.getString(data.get(5));
                    g = results.getString(data.get(6));
                    model.addRow(new Object[]{a,b,c,d,e,f,g});
                }  
            }
            if(columnCount==8)
            {
                while(results.next())
                {
                    a = results.getString(data.get(0));
                    b = results.getString(data.get(1));
                    c = results.getString(data.get(2));
                    d = results.getString(data.get(3));
                    e = results.getString(data.get(4));
                    f = results.getString(data.get(5));
                    g = results.getString(data.get(6));
                    h = results.getString(data.get(7));
                    model.addRow(new Object[]{a,b,c,d,e,f,g,h});
                }  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cleartable(DefaultTableModel model) {
        int rowsToRemove = model.getRowCount();
        //remove rows from the bottom one by one
        for (int i = rowsToRemove - 1; i >= 0; i--) {
           model.removeRow(i);
        }
    }
    
    public void DocDBThongke(DefaultTableModel model, String table) throws SQLException, Exception
    {
            String MaHD, MaNV, MaKH, NgayLap, ThanhTien;
            ArrayList<String> data = new ArrayList<String>();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table +";");

            ResultSet results = st.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
            
            int columnCount = metadata.getColumnCount();
            for (int i=1; i<=columnCount; i++) 
            {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
            }
            while(results.next())
            {
                    MaHD = results.getString(data.get(0));
                    MaNV = results.getString(data.get(1));
                    MaKH = results.getString(data.get(2));
                    NgayLap = results.getString(data.get(3));
                    ThanhTien = results.getString(data.get(4));
                    model.addRow(new Object[]{MaHD,MaNV,MaKH,NgayLap,ThanhTien}); 
            }  
    }
    public void DocDBThongkeDate(DefaultTableModel model, String table, Date date1, Date date2) throws SQLException, Exception
    {
            String MaHD, MaNV, MaKH, NgayLap, ThanhTien;
            ArrayList<String> data = new ArrayList<String>();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table +";");

            ResultSet results = st.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
            
            int columnCount = metadata.getColumnCount();
            for (int i=1; i<=columnCount; i++) 
            {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
            }
            while(results.next())
            {
                    MaHD = results.getString(data.get(0));
                    MaNV = results.getString(data.get(1));
                    MaKH = results.getString(data.get(2));
                    NgayLap = results.getString(data.get(3));  
                    ThanhTien = results.getString(data.get(4));
                    Date datelap = dateFormat.parse(NgayLap);
                    if(datelap.after(date1) && datelap.before(date2))
                    {
                    model.addRow(new Object[]{MaHD,MaNV,MaKH,NgayLap,ThanhTien});                    
                    }
            }  
    }
    public static float TongThanhTien(String table) throws SQLException, Exception
    {
            String ThanhTien;
            float ThanhTienFloat = 0;
            float ThanhTienTotal = 0;
            ArrayList<String> data = new ArrayList<String>();
            //DefaultTableModel model = (DefaultTableModel) table.getModel();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table +";");

            ResultSet results = st.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
            
            int columnCount = metadata.getColumnCount();
            for (int i=1; i<=columnCount; i++) 
                {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
                }
                while(results.next())
                {
                    ThanhTien = results.getString(data.get(4));
                    ThanhTienFloat = Float.parseFloat(ThanhTien);
                    ThanhTienTotal = ThanhTienTotal + ThanhTienFloat;
                }  
               return ThanhTienTotal;
    }             
    public static int TongHoaDon(String table) throws SQLException, Exception
    {
            int TongHoaDon = 0;
            ArrayList<String> data = new ArrayList<String>();
            //DefaultTableModel model = (DefaultTableModel) table.getModel();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table +";");

            ResultSet results = st.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
            
            int columnCount = metadata.getColumnCount();
            for (int i=1; i<=columnCount; i++) 
                {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
                }
                while(results.next())
                {
                   TongHoaDon++;
                }  
               return TongHoaDon;
    }
    public static float BinhQuanHoaDon(String table) throws SQLException, Exception
    {
            int TongHoaDon = TongHoaDon("hoadon");
            String ThanhTien;
            float ThanhTienFloat = 0;
            float ThanhTienTotal = 0;
            float BinhQuanHD = 0;
            ArrayList<String> data = new ArrayList<String>();
            //DefaultTableModel model = (DefaultTableModel) table.getModel();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table +";");

            ResultSet results = st.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
            
            int columnCount = metadata.getColumnCount();
            for (int i=1; i<=columnCount; i++) 
                {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
                }
                while(results.next())
                {
                   ThanhTien = results.getString(data.get(4));
                   ThanhTienFloat = Float.parseFloat(ThanhTien);
                   ThanhTienTotal = ThanhTienTotal + ThanhTienFloat;
                }
                BinhQuanHD = ThanhTienTotal/TongHoaDon;
               return BinhQuanHD;
    }      
    public static float BinhQuanSanPham(String table1, String table2) throws SQLException, Exception
    {
            int TongSanPham = 0;
            String SoSP;
            int SoSPint;
            String ThanhTien;
            float ThanhTienFloat = 0;
            float ThanhTienTotal = 0;
            float BinhQuanSP = 0;
            ArrayList<String> data = new ArrayList<String>();
            ArrayList<String> data2 = new ArrayList<String>();
            //DefaultTableModel model = (DefaultTableModel) table.getModel();
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhasach","root", "");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table1 +";");
            PreparedStatement stsp = (PreparedStatement) connection.prepareStatement("Select * FROM "+ table2 +";");
            
            ResultSet results = st.executeQuery();
            ResultSet resultsp = stsp.executeQuery();
            ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
            ResultSetMetaData metadatasp = (ResultSetMetaData) resultsp.getMetaData();
            
            int columnCount = metadata.getColumnCount();
            int columnCountSP = metadatasp.getColumnCount();
            for (int i=1; i<=columnCount; i++) 
                {
                String columnName = metadata.getColumnName(i);
                data.add(columnName);
                System.out.println(columnName);
                }
            for (int j=1; j<=columnCountSP; j++) 
                {
                String columnNameSP = metadatasp.getColumnName(j);
                data2.add(columnNameSP);
                System.out.println(columnNameSP);
                }
                while(results.next())
                {
                   ThanhTien = results.getString(data.get(4));
                   ThanhTienFloat = Float.parseFloat(ThanhTien);
                   ThanhTienTotal = ThanhTienTotal + ThanhTienFloat;
                }
                while(resultsp.next())
                {
                   SoSP = resultsp.getString(data2.get(3));
                   SoSPint = Integer.parseInt(SoSP);
                   TongSanPham = TongSanPham + SoSPint;
                }
                BinhQuanSP = ThanhTienTotal/TongSanPham;
               return BinhQuanSP;
    }          
}
