package QLNhaSach.DTO;

public class BookDTO {
    String CodeBook;
    String PublishingCompany;
    String CodeKindOfBook;
    String BookName;
    String Author;
    int  Number;
    float UnitPrice;
    
    
    public  BookDTO()
    {}

    public BookDTO(String CodeBook, String PublishingCompany, String CodeKindOfBook, String BookName,String Author, int Number, float UnitPrice) {
        this.CodeBook = CodeBook;
        this.PublishingCompany = PublishingCompany;
        this.CodeKindOfBook = CodeKindOfBook;
        this.BookName = BookName;
        this.Author = Author;
        this.Number = Number;
        this.UnitPrice = UnitPrice;
    }

    public String getCodeBook() {
        return CodeBook;
    }

    public void setCodeBook(String CodeBook) {
        this.CodeBook = CodeBook;
    }

    public String getPublishingCompany() {
        return PublishingCompany;
    }

    public void setPublishingCompany(String PublishingCompany) {
        this.PublishingCompany = PublishingCompany;
    }

    public String getCodeKindOfBook() {
        return CodeKindOfBook;
    }

    public void setCodeKindOfBook(String CodeKindOfBook) {
        this.CodeKindOfBook = CodeKindOfBook;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }
    
    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "CodeBook=" + CodeBook + ", PublishingCompany=" + PublishingCompany + ", CodeKindOfBook=" + CodeKindOfBook + ", BookName=" + BookName + ", Author=" + Author + ", Number=" + Number + ", UnitPrice=" + UnitPrice + '}';
    }
    
    
    
    
    
}
