package fileservice;

import model.Person;

import java.io.*;
import java.util.ArrayList;

public class IOReader {
    public static ArrayList<Person> arrayList=new ArrayList<>();
    public static ArrayList<Person> fileRead(String path){
        File file = new File(path);
        if(arrayList == null) {
            arrayList = new ArrayList<>();
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while((line = bufferedReader.readLine()) != null){
                String[] split = line.split(",");
                String number  = split[0];
                String group = split[1];
                String name = split[2];
                String gender = split[3];
                String address = split[4];

                Person person = new Person(number,group,name,gender,address);
                arrayList.add(person);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
