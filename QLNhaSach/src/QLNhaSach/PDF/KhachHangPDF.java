/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLNhaSach.PDF;

import QLNhaSach.DAO.CustomerDAO;
import QLNhaSach.DTO.CustomerDTO;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;

public class KhachHangPDF {
	public void WritePDF() throws DocumentException, IOException
	{
        JFileChooser opensave = new JFileChooser();
        int rVal = opensave.showSaveDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) 
        {
        String filename = opensave.getSelectedFile().getName();
        String dir = opensave.getCurrentDirectory().toString();
        String filePath = dir+"\\"+filename+".pdf";
	Document document = new Document();
        BaseFont bf = BaseFont.createFont("c:/windows/fonts/arial.ttf", 
        BaseFont.IDENTITY_H, BaseFont.EMBEDDED); 
        Font font = new Font(bf, 12); 
        font.setStyle(Font.NORMAL);
            try
		{
                CustomerDAO customerDAO = new CustomerDAO();
                List<CustomerDTO> listCustomers = customerDAO.listCustomers();
              
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
                
		PdfPTable table = new PdfPTable(6); // 3 columns.               
                Paragraph LabelHoaDon = new Paragraph("Khách Hàng",font);
                document.add(LabelHoaDon);
                
		table.setWidthPercentage(100); //Width 100%
		table.setSpacingBefore(10f); //Space before table
		table.setSpacingAfter(10f); //Space after table
		float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f};
		table.setWidths(columnWidths);

		PdfPCell cell1 = new PdfPCell(new Paragraph("ID", font));
		cell1.setBorderColor(BaseColor.BLACK);
		cell1.setPaddingLeft(10);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell2 = new PdfPCell(new Paragraph("Họ", font));
		cell2.setBorderColor(BaseColor.BLACK);
		cell2.setPaddingLeft(10);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell3 = new PdfPCell(new Paragraph("Tên", font));
		cell3.setBorderColor(BaseColor.BLACK);
		cell3.setPaddingLeft(10);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell4 = new PdfPCell(new Paragraph("Địa Chỉ", font));
		cell4.setBorderColor(BaseColor.BLACK);
		cell4.setPaddingLeft(10);
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell5 = new PdfPCell(new Paragraph("SDT", font));
		cell5.setBorderColor(BaseColor.BLACK);
		cell5.setPaddingLeft(10);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                
                PdfPCell cell6 = new PdfPCell(new Paragraph("Email", font));
		cell6.setBorderColor(BaseColor.BLACK);
		cell6.setPaddingLeft(10);
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

			//To avoid having the cell border and the content overlap, if you are having thick cell borders
			//cell1.setUserBorderPadding(true);
			//cell2.setUserBorderPadding(true);
			//cell3.setUserBorderPadding(true);                       

		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);  
                table.addCell(cell6); 
                for (CustomerDTO customer : listCustomers) 
                    {
                    PdfPCell celladd1 = new PdfPCell(new Paragraph(customer.getCustomerID(), font));
                    celladd1.setBorderColor(BaseColor.BLACK);
                    celladd1.setPaddingLeft(10);
                    celladd1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd2 = new PdfPCell(new Paragraph(customer.getHo(), font));
                    celladd2.setBorderColor(BaseColor.BLACK);
                    celladd2.setPaddingLeft(10);
                    celladd2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd3 = new PdfPCell(new Paragraph(customer.getTen(), font));
                    celladd3.setBorderColor(BaseColor.BLACK);
                    celladd3.setPaddingLeft(10);
                    celladd3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd4 = new PdfPCell(new Paragraph(customer.getAddress(), font));
                    celladd4.setBorderColor(BaseColor.BLACK);
                    celladd4.setPaddingLeft(10);
                    celladd4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd5 = new PdfPCell(new Paragraph(customer.getSdt(), font));
                    celladd5.setBorderColor(BaseColor.BLACK);
                    celladd5.setPaddingLeft(10);
                    celladd5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd6 = new PdfPCell(new Paragraph(customer.getEmail(), font));
                    celladd6.setBorderColor(BaseColor.BLACK);
                    celladd6.setPaddingLeft(10);
                    celladd6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table.addCell(celladd1);
                    table.addCell(celladd2);
                    table.addCell(celladd3);
                    table.addCell(celladd4);
                    table.addCell(celladd5);
                    table.addCell(celladd6);
                    }
                document.add(table);
                document.close();
		writer.close();
		} 
                catch (Exception e)
		{
			e.printStackTrace();
		}
	}
    }    
}

