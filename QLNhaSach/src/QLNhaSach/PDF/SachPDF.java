package QLNhaSach.PDF;

import QLNhaSach.DAO.BookDAO;
import QLNhaSach.DTO.BookDTO;
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

public class SachPDF {
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
                BookDAO bookDAO = new BookDAO();
                List<BookDTO> listBooks = bookDAO.listBooks();
              
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
                
		PdfPTable table = new PdfPTable(7);            
                Paragraph LabelHoaDon = new Paragraph("Sách",font);
                document.add(LabelHoaDon);
                
		table.setWidthPercentage(100);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10f);
		float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f, 1f};
		table.setWidths(columnWidths);

		PdfPCell cell1 = new PdfPCell(new Paragraph("Mã Sách", font));
		cell1.setBorderColor(BaseColor.BLACK);
		cell1.setPaddingLeft(10);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell2 = new PdfPCell(new Paragraph("Nhà Xuất Bản", font));
		cell2.setBorderColor(BaseColor.BLACK);
		cell2.setPaddingLeft(10);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell3 = new PdfPCell(new Paragraph("Mã Loại", font));
		cell3.setBorderColor(BaseColor.BLACK);
		cell3.setPaddingLeft(10);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell4 = new PdfPCell(new Paragraph("Tên Sách", font));
		cell4.setBorderColor(BaseColor.BLACK);
		cell4.setPaddingLeft(10);
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                
                PdfPCell cell5 = new PdfPCell(new Paragraph("Tác Giả", font));
		cell5.setBorderColor(BaseColor.BLACK);
		cell5.setPaddingLeft(10);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                
                PdfPCell cell6 = new PdfPCell(new Paragraph("Đơn Giá", font));
		cell6.setBorderColor(BaseColor.BLACK);
		cell6.setPaddingLeft(10);
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
                
                PdfPCell cell7 = new PdfPCell(new Paragraph("Số Lượng", font));
		cell7.setBorderColor(BaseColor.BLACK);
		cell7.setPaddingLeft(10);
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                table.addCell(cell7);

                for (BookDTO book : listBooks) 
                    {
                    PdfPCell celladd1 = new PdfPCell(new Paragraph(book.getCodeBook(), font));
                    celladd1.setBorderColor(BaseColor.BLACK);
                    celladd1.setPaddingLeft(10);
                    celladd1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd2 = new PdfPCell(new Paragraph(book.getPublishingCompany(), font));
                    celladd2.setBorderColor(BaseColor.BLACK);
                    celladd2.setPaddingLeft(10);
                    celladd2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd3 = new PdfPCell(new Paragraph(book.getCodeKindOfBook(), font));
                    celladd3.setBorderColor(BaseColor.BLACK);
                    celladd3.setPaddingLeft(10);
                    celladd3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd4 = new PdfPCell(new Paragraph(book.getBookName(), font));
                    celladd4.setBorderColor(BaseColor.BLACK);
                    celladd4.setPaddingLeft(10);
                    celladd4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    
                    PdfPCell celladd5 = new PdfPCell(new Paragraph(book.getAuthor(), font));
                    celladd5.setBorderColor(BaseColor.BLACK);
                    celladd5.setPaddingLeft(10);
                    celladd5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    
                    String UnitPriceString = String.valueOf(book.getUnitPrice());
                    PdfPCell celladd6 = new PdfPCell(new Paragraph(UnitPriceString, font));
                    celladd6.setBorderColor(BaseColor.BLACK);
                    celladd6.setPaddingLeft(10);
                    celladd6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd6.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    
                    String NumberString = String.valueOf(book.getNumber());
                    PdfPCell celladd7 = new PdfPCell(new Paragraph(NumberString, font));
                    celladd7.setBorderColor(BaseColor.BLACK);
                    celladd7.setPaddingLeft(10);
                    celladd7.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table.addCell(celladd1);
                    table.addCell(celladd2);
                    table.addCell(celladd3);
                    table.addCell(celladd4);
                    table.addCell(celladd5);
                    table.addCell(celladd6);
                    table.addCell(celladd7);
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

