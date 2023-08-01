package QLNhaSach.DTO;

public class StaffDTO {
    String CodeStaff;
    String LastName;
    String FirstName;
    String DateOfBirth;
    String Email;
    Float Salary;
    
    public StaffDTO()
    {}

    public StaffDTO(String CodeStaff, String LastName,String FristName, String DateOfBirth, String Email, Float Salary) {
        this.CodeStaff = CodeStaff;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.DateOfBirth = DateOfBirth;
        this.Email = Email;
        this.Salary = Salary;
    }

    public String getCodeStaff() {
        return CodeStaff;
    }

    public void setCodeStaff(String CodeStaff) {
        this.CodeStaff = CodeStaff;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

   
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "StaffDTO{" + "CodeStaff=" + CodeStaff + ", LastName=" + LastName + ", FirstName=" + FirstName + ", DateOfBirth=" + DateOfBirth + ", Email=" + Email + ", Salary=" + Salary + '}';
    }

   
    
    
    
}
