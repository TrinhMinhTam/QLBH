package QLNhaSach.DTO;

public class DetailSaleDTO {
    int CodeSale;
    int CodeBook;
    int PercentSale;
    

    public DetailSaleDTO() {
    }

    public DetailSaleDTO(int CodeSale, int CodeBook, int PercentSale) {
        this.CodeSale = CodeSale;
        this.CodeBook = CodeBook;
        this.PercentSale = PercentSale;
    }

    public int getCodeSale() {
        return CodeSale;
    }

    public void setCodeSale(int CodeSale) {
        this.CodeSale = CodeSale;
    }

    public int getCodeBook() {
        return CodeBook;
    }

    public void setCodeBook(int CodeBook) {
        this.CodeBook = CodeBook;
    }

    public int getPercentSale() {
        return PercentSale;
    }

    public void setPercentSale(int PercentSale) {
        this.PercentSale = PercentSale;
    }

    @Override
    public String toString() {
        return "SaleDTO{" + "CodeSale=" + CodeSale + ", CodeBook=" + CodeBook + ", PercentSale=" + PercentSale + '}';
    }   
}
