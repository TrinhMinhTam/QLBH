package QLNhaSach.PDF;

import QLNhaSach.DAO.DetailSaleDAO;
import QLNhaSach.DAO.SaleDAO;
import QLNhaSach.DTO.DetailSaleDTO;
import QLNhaSach.DTO.SaleDTO;
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

public class KhuyenMaiPDF {
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
                DetailSaleDAO detailsaleDAO = new DetailSaleDAO();
                SaleDAO saleDAO = new SaleDAO();
                List<DetailSaleDTO> listDetailSales = detailsaleDAO.listSales();
                List<SaleDTO> listSales = saleDAO.listDetailSales();
              
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
                
		PdfPTable table = new PdfPTable(3);            
                Paragraph LabelHoaDon = new Paragraph("Khuyến Mãi",font);
                document.add(LabelHoaDon);
                
		table.setWidthPercentage(100);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10f);
		float[] columnWidths = {1f, 1f, 1f};
		table.setWidths(columnWidths);

		PdfPCell cell1 = new PdfPCell(new Paragraph("Mã KM",font));
		cell1.setBorderColor(BaseColor.BLACK);
		cell1.setPaddingLeft(10);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell2 = new PdfPCell(new Paragraph("Mã Loại",font));
		cell2.setBorderColor(BaseColor.BLACK);
		cell2.setPaddingLeft(10);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell3 = new PdfPCell(new Paragraph("Phần Trăm Giảm",font));
		cell3.setBorderColor(BaseColor.BLACK);
		cell3.setPaddingLeft(10);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
   
                for (DetailSaleDTO detailsale : listDetailSales) 
                    {
                    String IDString = String.valueOf(detailsale.getCodeSale());
                    PdfPCell celladd1 = new PdfPCell(new Paragraph(IDString,font));
                    celladd1.setBorderColor(BaseColor.BLACK);
                    celladd1.setPaddingLeft(10);
                    celladd1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    String CodeBookString = String.valueOf(detailsale.getCodeBook());
                    PdfPCell celladd2 = new PdfPCell(new Paragraph(CodeBookString,font));
                    celladd2.setBorderColor(BaseColor.BLACK);
                    celladd2.setPaddingLeft(10);
                    celladd2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    String PercentSale = String.valueOf(detailsale.getPercentSale());
                    PdfPCell celladd3 = new PdfPCell(new Paragraph(PercentSale,font));
                    celladd3.setBorderColor(BaseColor.BLACK);
                    celladd3.setPaddingLeft(10);
                    celladd3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table.addCell(celladd1);
                    table.addCell(celladd2);
                    table.addCell(celladd3);
                    }
                document.add(table);
                
                PdfPTable table2 = new PdfPTable(4); // 3 columns.               
                Paragraph LabelChiTietHoaDon = new Paragraph("Chi Tiết Khuyến Mãi",font);
                document.add(LabelChiTietHoaDon);
                
		table2.setWidthPercentage(100); //Width 100%
		table2.setSpacingBefore(10f); //Space before table2
		table2.setSpacingAfter(10f); //Space after table2
                float[] columnWidths2 = {1f, 1f, 1f, 1f};
		table2.setWidths(columnWidths2);

		PdfPCell cell6 = new PdfPCell(new Paragraph("Mã KM",font));
		cell6.setBorderColor(BaseColor.BLACK);
		cell6.setPaddingLeft(10);
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell7 = new PdfPCell(new Paragraph("Tên KM",font));
		cell7.setBorderColor(BaseColor.BLACK);
		cell7.setPaddingLeft(10);
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell8 = new PdfPCell(new Paragraph("Ngày BĐ",font));
		cell8.setBorderColor(BaseColor.BLACK);
		cell8.setPaddingLeft(10);
		cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell9 = new PdfPCell(new Paragraph("Ngày KT",font));
		cell9.setBorderColor(BaseColor.BLACK);
		cell9.setPaddingLeft(10);
		cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);                      

		table2.addCell(cell6);
		table2.addCell(cell7);
		table2.addCell(cell8);
                table2.addCell(cell9);
 
                for (SaleDTO sale : listSales) 
                    {
                    PdfPCell celladd1 = new PdfPCell(new Paragraph(sale.getCodeSale(),font));
                    celladd1.setBorderColor(BaseColor.BLACK);
                    celladd1.setPaddingLeft(10);
                    celladd1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd2 = new PdfPCell(new Paragraph(sale.getNameSale(),font));
                    celladd2.setBorderColor(BaseColor.BLACK);
                    celladd2.setPaddingLeft(10);
                    celladd2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd3 = new PdfPCell(new Paragraph(sale.getStartDay(),font));
                    celladd3.setBorderColor(BaseColor.BLACK);
                    celladd3.setPaddingLeft(10);
                    celladd3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    String NumberString = String.valueOf(sale.getEndDay());
                    PdfPCell celladd4 = new PdfPCell(new Paragraph(NumberString,font));
                    celladd4.setBorderColor(BaseColor.BLACK);
                    celladd4.setPaddingLeft(10);
                    celladd4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table2.addCell(celladd1);
                    table2.addCell(celladd2);
                    table2.addCell(celladd3);
                    table2.addCell(celladd4);
                    }		
                document.add(table2);
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


