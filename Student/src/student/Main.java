/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Doann
 */
public class Main {

    public static Scanner sn = new Scanner(System.in);
    static List<Student> list = new ArrayList<Student>();

    public static void main(String[] args) {
        list.add(new Student("Đoàn Nam", 2000, "0397482017", "CNTT", false));
        list.add(new Student("Đoàn Duy Nam", 2000, "0397482016", "CNTT", true));
        list.add(new Student("Vũ Văn Doan", 1999, "0397482018", "CNTT", true));
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("              MENU");
            System.out.println("1.Thêm sinh viên");
            System.out.println("2.Sắp xếp");
            System.out.println("3.Sửa thông tin");
            System.out.println("4.Xóa sinh viên");
            System.out.println("5.Hiển thi danh sách sinh viên");
            System.out.println("6.Tìm kiếm");
            System.out.println("7.Kết thúc");
            System.out.print("Lựa chọn : ");
            int choose = sn.nextInt();
            sn.nextLine();
            switch (choose) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    System.out.println("1 . Sắp xếp theo tên ");
                    System.out.println("2 . Sắp xếp năm sinh ");
                    System.out.println("3 . Sắp xếp số điện thoại ");
                    System.out.print("Lựa chọn : ");
                    int i = sn.nextInt();
                    sn.nextLine();
                    while (i != 1 && i != 2 && i != 3) {
                        System.out.print("Nhập lại :");
                        i = sn.nextInt();
                        sn.nextLine();
                    }
                    sortStudents(i);
                    System.out.println("Thông tin sau khi sắp xếp");
                    showStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    showStudents();
                    break;
                case 6:
                    findStudents();
                    break;
                case 7:
                   return;
                    
            }
        }
    }

    private static boolean checkPhoneNumber(List<Student> list, String phoneNumber) {
        for (Student item : list) {
            if (item.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }

    private static void addStudent() {
        Student student = new Student();
        System.out.println("Nhập thông tin sinh viên ");
        System.out.print("Nhập tên sinh viên : ");
        student.setName(sn.nextLine());
        System.out.print("Nhập năm sinh : ");
        student.setYearOfBirth(sn.nextInt());
        sn.nextLine();
        System.out.print("Nhập số điện thoại : ");
        String phoneNumber = sn.nextLine();
        while (!checkPhoneNumber(list, phoneNumber)) {
            System.out.print("Không thể trùng số điện thoại : ");
            phoneNumber = sn.nextLine();
        }
        student.setPhoneNumber(phoneNumber);
        System.out.print("Nhập chuyên ngành : ");
        student.setMajor(sn.nextLine());
        System.out.print("Nhập hệ :\n1.Đại học\n2.Cao đẳng\nLựa chọn :");
        int he = sn.nextInt();
        while (he != 1 && he != 2) {
            System.out.println("Nhập lại : ");
            he = sn.nextInt();
        }
        if (he == 1) {
            student.setLevel(true);
        } else {
            student.setLevel(false);
        }
        list.add(student);
        System.out.println("Thông tin sinh viên sau khi thêm :");
        showStudents();
    }

    private static void updateStudent() {
        Student student = new Student();
        System.out.println("Nhập thông tin sinh viên cần sửa");
        System.out.print("Nhập số điện thoại : ");
        String phoneNumber = sn.nextLine();
        if (checkPhoneNumber(list, phoneNumber)) {
            System.out.println("Không tồn tại sinh viên có số điện thoại " + phoneNumber);
            return;
        }
        System.out.print("Nhập tên sinh viên : ");
        student.setName(sn.nextLine());
        System.out.print("Nhập năm sinh : ");
        student.setYearOfBirth(sn.nextInt());
        sn.nextLine();
        student.setPhoneNumber(phoneNumber);
        System.out.print("Nhập chuyên ngành : ");
        student.setMajor(sn.nextLine());
        System.out.print("Nhập hệ :\n1.Đại học\n2.Cao đẳng\nLựa chọn :");
        int he = sn.nextInt();
        while (he != 1 && he != 2) {
            System.out.println("Nhập lại : ");
            he = sn.nextInt();
        }
        if (he == 1) {
            student.setLevel(true);
        } else {
            student.setLevel(false);
        }
        Collections.replaceAll(list, list.get(list.indexOf(student)), student);
        System.out.println("Thông tin sinh viên sau khi sửa :");
        showStudents();
    }

    private static void deleteStudent() {
        Student student = new Student();
        System.out.print("Nhập số điện thoại : ");
        String phoneNumber = sn.nextLine();
        if (checkPhoneNumber(list, phoneNumber)) {
            System.out.println("Không tồn tại sinh viên có số điện thoại " + phoneNumber);
            return;
        }
        student.setPhoneNumber(phoneNumber);
        list.remove(student);
        System.out.println("Thông tin sinh viên sau khi xóa :");
        showStudents();
    }

    private static void showStudents() {
        if (list.size() == 0) {
            System.out.println("Chưa có sinh viên nào !!!");
        }
        for (Student item : list) {
            System.out.println(item);
        }
    }

    private static void sortStudents(int i) {
        switch (i) {
            case 1:
                Collections.sort(list, (Student o1, Student o2) -> o1.getName().compareTo(o2.getName()));
                break;
            case 2:
                Collections.sort(list, (Student o1, Student o2) -> o1.getYearOfBirth() > o2.getYearOfBirth() ? 1 : -1);
                break;
            case 3:
                Collections.sort(list, (Student o1, Student o2) -> o1.getPhoneNumber().compareTo(o2.getPhoneNumber()));
                break;
        }
    }

    private static void findStudents() {
        System.out.print("Nhập từ khóa : ");
        String keySearch = sn.nextLine();
        List<Student> listResult = new ArrayList<Student>();
        String dh = "đại học";
        String cd = "cao đẳng";
        for (Student item : list) {
            if (item.getName().toLowerCase().contains(keySearch.toLowerCase()) || item.getPhoneNumber().toLowerCase().contains(keySearch.toLowerCase())
                    || (item.getYearOfBirth() + "").contains(keySearch) || dh.contains(keySearch.toLowerCase()) || cd.contains(keySearch.toLowerCase())) {
                System.out.println(item);
            }

        }
    }
}
