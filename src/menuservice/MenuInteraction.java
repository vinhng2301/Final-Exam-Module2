package menuservice;

import fileservice.IOReader;
import fileservice.IOWriter;
import model.Person;
import model.RegexForms;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static fileservice.IOReader.fileRead;
import static fileservice.IOWriter.fileWrite;

public class MenuInteraction extends RegexForms {

    private ArrayList<Person> person = new ArrayList<>();

    public static ArrayList<Person> getPerson() {
        return getPerson();
    }

    public void setPerson(ArrayList<Person> person) {
        this.person = person;
    }

    public static void showContact(ArrayList<Person> person){
        System.out.println("-------------------Danh Bạ-----------------");
        for (int i = 0; i < person.size(); i++) {
            System.out.println(person.get(i).getNumber() + "\t\t|\t" + person.get(i).getGroup() + "\t\t|\t" + person.get(i).getName() + "\t\t|\t" + person.get(i).getGender() + "\t\t|\t" + person.get(i).getAddress());
        }
    }

    public static void addPerson(){
        System.out.println("Nhập số điện thoại:");
        String number = sc.nextLine();
        System.out.println("Nhập nhóm: ");
        String group = sc.nextLine();
        System.out.println("Nhập họ và tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        IOReader.arrayList.add(new Person(number,group,name,gender,address));
        fileWrite("data.txt");
    }

    public static void editPerson() {
        System.out.println("Nhập số trong danh bạ : ");
        ArrayList<Person> person =  IOReader.arrayList;
        String number = sc.nextLine();
        for (int i = 0; i <person.size() ; i++) {
            if ( number == person.get(i).getNumber()){
                System.out.println("Nhập tên mới : ");
                String newName = sc.nextLine();
                person.get(i).setName(newName);
                System.out.println("Nhập nhóm mới: ");
                String newGroup = sc.nextLine();
                person.get(i).setGroup(newGroup);
                System.out.println("Nhập giới tính :");
                String newGender = sc.nextLine();
                person.get(i).setGender(newGender);
                System.out.println("Nhập địa chỉ mới :");
                String newAddress = sc.nextLine();
                person.get(i).setAddress(newAddress);
                fileWrite("data.txt");
                break;
            }
        }
    }

    public static void removePerson(){
        System.out.println("Nhập số trong danh bạ : ");
        ArrayList<Person> person =  IOReader.arrayList;
        String number = sc.nextLine();
        int index = 0;
        for (int i = 0; i <person.size() ; i++) {
            if (number == person.get(i).getNumber()){
                index = i;
                break;
            }
        }
        person.remove(index);
    }

    public static void searchPerson() {
            try {
                System.out.println("Nhập Thông Tin Cần Tìm :");
                String regex = sc.nextLine();
                int index = 0;
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher;
                for (int i = 0; i < getPerson().size(); i++) {
                    matcher = pattern.matcher(getPerson().get(i).getName());
                    if (matcher.find()) {
                        System.out.println("STT " + i + " : " + getPerson().get(i).toString());
                        index++;
                    }
                }
                if (index <= 0) {
                    System.out.println("Thông tin này không có trong danh sách ");
                }
            } catch (Exception e) {
                System.out.println("Chưa nhập thông tin ");
            }
    }


}
