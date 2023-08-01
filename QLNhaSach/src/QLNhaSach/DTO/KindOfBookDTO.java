package QLNhaSach.DTO;

public class KindOfBookDTO {
    String  CodeKindOfBook;
    String   NameKind;
    
    public  KindOfBookDTO(){}

    public KindOfBookDTO(String CodeKindOfBook, String NameKind) {
        this.CodeKindOfBook = CodeKindOfBook;
        this.NameKind = NameKind;
    }

    public String getCodeKindOfBook() {
        return CodeKindOfBook;
    }

    public void setCodeKindOfBook(String CodeKindOfBook) {
        this.CodeKindOfBook = CodeKindOfBook;
    }

    public String getNameKind() {
        return NameKind;
    }

    public void setNameKind(String NameKind) {
        this.NameKind = NameKind;
    }

    @Override
    public String toString() {
        return "KindOfBookDTO{" + "CodeKindOfBook=" + CodeKindOfBook + ", NameKind=" + NameKind + '}';
    }   
}
