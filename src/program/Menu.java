package program;

import fileservice.IOReader;
import fileservice.IOWriter;
import model.Person;
import model.RegexForms;


import java.io.IOException;


import static menuservice.MenuInteraction.*;

public class Menu extends RegexForms {

    private int showMenu(){
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số để tiếp tục: ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới ");
        System.out.println("3. Cập nhật ");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file ");
        System.out.println("7. Ghi vào file ");
        System.out.println("8. Thoát !!");
        System.out.println("-------------------------------------");
        int choice = readInt(1, 8);
        return choice;
    }

    public void startMenu(){
        while(true){
            int choice = showMenu();
            switch (choice) {
                case 1:
                    showContact(IOReader.arrayList);
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    editPerson();
                    break;
                case 4:
                    removePerson();
                    break;
                case 5:
                    searchPerson();
                    break;
                case 6:
                    IOReader.fileRead("data.txt");
                    break;
                case 7:
                    IOWriter.fileWrite("data.txt");
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private int readInt(int min, int max) {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

}
