package QLNhaSach.DTO;

public class SupplierDTO {
    String CodeSupplier;
    String NameSupplier;
    String AddressSupplier;
    String PhonenumberSupplier;
    
    
    public SupplierDTO()
    {}

    public SupplierDTO(String CodeSupplier, String NameSupplier, String AddressSupplier, String PhonenumberSupplier) {
        this.CodeSupplier = CodeSupplier;
        this.NameSupplier = NameSupplier;
        this.AddressSupplier = AddressSupplier;
        this.PhonenumberSupplier = PhonenumberSupplier;
    }

    public String getCodeSupplier() {
        return CodeSupplier;
    }

    public void setCodeSupplier(String CodeSupplier) {
        this.CodeSupplier = CodeSupplier;
    }

    public String getNameSupplier() {
        return NameSupplier;
    }

    public void setNameSupplier(String NameSupplier) {
        this.NameSupplier = NameSupplier;
    }

    public String getAddressSupplier() {
        return AddressSupplier;
    }

    public void setAddressSupplier(String AddressSupplier) {
        this.AddressSupplier = AddressSupplier;
    }

    public String getPhonenumberSupplier() {
        return PhonenumberSupplier;
    }

    public void setPhonenumberSupplier(String PhonenumberSupplier) {
        this.PhonenumberSupplier = PhonenumberSupplier;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" + "CodeSupplier=" + CodeSupplier + ", NameSupplier=" + NameSupplier + ", AddressSupplier=" + AddressSupplier + ", PhonenumberSupplier=" + PhonenumberSupplier + '}';
    }  
}
