/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Doann
 */
public class Student {
    private String name;
    private int yearOfBirth;
    private String phoneNumber;
    private String major;
    private boolean level;
    public Student() {
    }

    public Student(String name, int yearOfBirth, String phoneNumber, String major, boolean level) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isLevel() {
        return level;
    }

    public void setLevel(boolean level) {
        this.level = level;
    }

    
    @Override
    public String toString() {
        return "Tên sinh viên : "+name + "\t Năm sinh : "+yearOfBirth+"\t Số điện thoại : "+phoneNumber+"\t Chuyên ngành : "+major + "\t Hệ : "+ (level ? "Đại học" : "Cao đẳng") ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        Student x = (Student)obj;
        return this.getPhoneNumber().equals(x.getPhoneNumber()); //To change body of generated methods, choose Tools | Templates.
    }
     
    

}
