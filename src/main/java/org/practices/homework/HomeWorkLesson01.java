package org.practices.homework;

public class HomeWorkLesson01 {
    public static void main(String[] args) {
        /*
        1. Thay đổi kí tự đặc biệt trong 1 chuỗi cho trước
        Ex: thay ki tự @ bằng kí tự _
         */
//        System.out.println("Practices 1: ");
//        changeCharacter("Hienht@bka");

        /*
        2. Lấy 4 kí tự cuối cùng của 1 chuỗi cho trước
         */
//        System.out.println("Practices 2:");
//        getFourLastCharacter(""); // String is empty
//        getFourLastCharacter("123"); // Length is not enough 4 characters
//        getFourLastCharacter("hienht@1234");

        /*
        3. Tìm kí tự không lặp lại đầu tiên của một chuỗi
         */

        /*
        4.Tìm số lớn nhất, nhỏ nhất, lớn thứ 2 trong một mảng
         */
    }

    public static void changeCharacter(String input){
        String outPutText= input.replace("@", "_");
        System.out.println(outPutText);
    }
    public static void getFourLastCharacter(String input){
        if(input == null || input.isEmpty()){
            System.out.println("String is not valid!");
        }
        else if(input.length() < 4){
            System.out.println("String is not enough four characters");
        }
        else {
            System.out.println(input.substring(input.length() - 4, input.length()));
        }
    }

    public static char printFirstCharacterNotDuplicte(String input){
        if(input == null || input.isEmpty()){
            System.out.println("String is not valid!");
        }
        else {
            /*
            1. vòng lặp từ đầu =>cuối
            kí tự đầu tiên
            kí tụ thứ 2, compare với những kí tự rước đó nếu khác => return kí tự đó
            Nếu trùng thì tăng lên 1 index
            Nếu đến cuối cùng không tìm thấy kí tự thỏa mãn thì in ra không tìm thấy kí tự nào
             */

            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i - 1)) {
                    return input.charAt(0);
                }
                return input.charAt(i);
            }
            return '_';
        }
        return 0;
    }



}
