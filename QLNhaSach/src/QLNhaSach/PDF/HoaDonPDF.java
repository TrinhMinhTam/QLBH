package QLNhaSach.PDF;

import QLNhaSach.DAO.BillDAO;
import QLNhaSach.DAO.DetailBillDAO;
import QLNhaSach.DTO.BillDTO;
import QLNhaSach.DTO.DetailBillDTO;
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

public class HoaDonPDF {
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
                BillDAO billDAO = new BillDAO();
                DetailBillDAO detailbillDAO = new DetailBillDAO();
                List<BillDTO> listBills = billDAO.listBills();
                List<DetailBillDTO> listDetailBills = detailbillDAO.listDetailBills();
              
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
                
		PdfPTable table = new PdfPTable(5);            
                Paragraph LabelHoaDon = new Paragraph("Hóa Đơn",font);
                document.add(LabelHoaDon);
                
		table.setWidthPercentage(100);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10f);
		float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
		table.setWidths(columnWidths);

		PdfPCell cell1 = new PdfPCell(new Paragraph("Mã HĐ",font));
		cell1.setBorderColor(BaseColor.BLACK);
		cell1.setPaddingLeft(10);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell2 = new PdfPCell(new Paragraph("Mã NV",font));
		cell2.setBorderColor(BaseColor.BLACK);
		cell2.setPaddingLeft(10);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell3 = new PdfPCell(new Paragraph("Mã KH",font));
		cell3.setBorderColor(BaseColor.BLACK);
		cell3.setPaddingLeft(10);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell4 = new PdfPCell(new Paragraph("Ngày Lập HĐ",font));
		cell4.setBorderColor(BaseColor.BLACK);
		cell4.setPaddingLeft(10);
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell5 = new PdfPCell(new Paragraph("Thành Tiền",font));
		cell5.setBorderColor(BaseColor.BLACK);
		cell5.setPaddingLeft(10);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);        
                for (BillDTO bill : listBills) 
                    {
                    PdfPCell celladd1 = new PdfPCell(new Paragraph(bill.getCodeBill(),font));
                    celladd1.setBorderColor(BaseColor.BLACK);
                    celladd1.setPaddingLeft(10);
                    celladd1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd2 = new PdfPCell(new Paragraph(bill.getCodeStaff(),font));
                    celladd2.setBorderColor(BaseColor.BLACK);
                    celladd2.setPaddingLeft(10);
                    celladd2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd3 = new PdfPCell(new Paragraph(bill.getCodeCustomer(),font));
                    celladd3.setBorderColor(BaseColor.BLACK);
                    celladd3.setPaddingLeft(10);
                    celladd3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd4 = new PdfPCell(new Paragraph(bill.getDaySale(),font));
                    celladd4.setBorderColor(BaseColor.BLACK);
                    celladd4.setPaddingLeft(10);
                    celladd4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    String ThanhTienString = String.valueOf(bill.getThanhTien());
                    PdfPCell celladd5 = new PdfPCell(new Paragraph(ThanhTienString,font));
                    celladd5.setBorderColor(BaseColor.BLACK);
                    celladd5.setPaddingLeft(10);
                    celladd5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table.addCell(celladd1);
                    table.addCell(celladd2);
                    table.addCell(celladd3);
                    table.addCell(celladd4);
                    table.addCell(celladd5);
                    }
                document.add(table);
                
                PdfPTable table2 = new PdfPTable(6); // 3 columns.               
                Paragraph LabelChiTietHoaDon = new Paragraph("Chi Tiết Hóa Đơn",font);
                document.add(LabelChiTietHoaDon);
                
		table2.setWidthPercentage(100); //Width 100%
		table2.setSpacingBefore(10f); //Space before table2
		table2.setSpacingAfter(10f); //Space after table2
                float[] columnWidths2 = {1f, 1f, 1f, 1f, 1f, 1f};
		table2.setWidths(columnWidths2);

		PdfPCell cell6 = new PdfPCell(new Paragraph("Mã HĐ",font));
		cell6.setBorderColor(BaseColor.BLACK);
		cell6.setPaddingLeft(10);
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell7 = new PdfPCell(new Paragraph("Mã Sách",font));
		cell7.setBorderColor(BaseColor.BLACK);
		cell7.setPaddingLeft(10);
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell8 = new PdfPCell(new Paragraph("Đơn Giá",font));
		cell8.setBorderColor(BaseColor.BLACK);
		cell8.setPaddingLeft(10);
		cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell9 = new PdfPCell(new Paragraph("Số Lượng",font));
		cell9.setBorderColor(BaseColor.BLACK);
		cell9.setPaddingLeft(10);
		cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                PdfPCell cell10 = new PdfPCell(new Paragraph("Giảm Giá",font));
		cell10.setBorderColor(BaseColor.BLACK);
		cell10.setPaddingLeft(10);
		cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
                
                PdfPCell cell11 = new PdfPCell(new Paragraph("Thành Tiền",font));
		cell11.setBorderColor(BaseColor.BLACK);
		cell11.setPaddingLeft(10);
		cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);

			//To avoid having the cell border and the content overlap, if you are having thick cell borders
			//cell6.setUserBorderPadding(true);
			//cell7.setUserBorderPadding(true);
			//cell8.setUserBorderPadding(true);                       

		table2.addCell(cell6);
		table2.addCell(cell7);
		table2.addCell(cell8);
                table2.addCell(cell9);
                table2.addCell(cell10);     
                table2.addCell(cell11);   
                for (DetailBillDTO detailbill : listDetailBills) 
                    {
                    PdfPCell celladd1 = new PdfPCell(new Paragraph(detailbill.getCodeBill(),font));
                    celladd1.setBorderColor(BaseColor.BLACK);
                    celladd1.setPaddingLeft(10);
                    celladd1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell celladd2 = new PdfPCell(new Paragraph(detailbill.getCodeBook(),font));
                    celladd2.setBorderColor(BaseColor.BLACK);
                    celladd2.setPaddingLeft(10);
                    celladd2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    String PriceString = String.valueOf(detailbill.getPrice());
                    PdfPCell celladd3 = new PdfPCell(new Paragraph(PriceString,font));
                    celladd3.setBorderColor(BaseColor.BLACK);
                    celladd3.setPaddingLeft(10);
                    celladd3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    String NumberString = String.valueOf(detailbill.getNumber());
                    PdfPCell celladd4 = new PdfPCell(new Paragraph(NumberString,font));
                    celladd4.setBorderColor(BaseColor.BLACK);
                    celladd4.setPaddingLeft(10);
                    celladd4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                   
                    String SaleString = String.valueOf(detailbill.getSale());
                    PdfPCell celladd5 = new PdfPCell(new Paragraph(SaleString,font));
                    celladd5.setBorderColor(BaseColor.BLACK);
                    celladd5.setPaddingLeft(10);
                    celladd5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    
                    String ThanhTienString = String.valueOf(detailbill.getTotal());
                    PdfPCell celladd6 = new PdfPCell(new Paragraph(ThanhTienString,font));
                    celladd6.setBorderColor(BaseColor.BLACK);
                    celladd6.setPaddingLeft(10);
                    celladd6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celladd6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table2.addCell(celladd1);
                    table2.addCell(celladd2);
                    table2.addCell(celladd3);
                    table2.addCell(celladd4);
                    table2.addCell(celladd5);
                    table2.addCell(celladd6);
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

