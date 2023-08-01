package QLNhaSach.DTO;

public class SaleDTO{
    String CodeSale;
    String  NameSale;
    String  StartDay;
    String  EndDay;
    
    public SaleDTO()
    {}

    public SaleDTO(String CodeSale, String NameSale, String StartDay, String EndDay) {
        this.CodeSale = CodeSale;
        this.NameSale = NameSale;
        this.StartDay = StartDay;
        this.EndDay = EndDay;
    }

    public String getCodeSale() {
        return CodeSale;
    }

    public void setCodeSale(String CodeSale) {
        this.CodeSale = CodeSale;
    }

    public String getNameSale() {
        return NameSale;
    }

    public void setNameSale(String NameSale) {
        this.NameSale = NameSale;
    }

    public String getStartDay() {
        return StartDay;
    }

    public void setStartDay(String StartDay) {
        this.StartDay = StartDay;
    }

    public String getEndDay() {
        return EndDay;
    }

    public void setEndDay(String EndDay) {
        this.EndDay = EndDay;
    }

    @Override
    public String toString() {
        return "SaleDTO{" + "CodeSale=" + CodeSale + ", NameSale=" + NameSale + ", StartDay=" + StartDay + ", EndDay=" + EndDay +  '}';
    }

   

   
    
    
    
    
    
}
