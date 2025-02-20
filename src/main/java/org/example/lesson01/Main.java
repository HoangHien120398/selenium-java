package org.example.lesson01;

public class Main {
    public static void main(String[] args){

        /*
        pratices 1
         */
//        String input = "$50.00";
//        String newPrice = input.replace("$","");
//        float fPrice = Float.parseFloat(newPrice);
//        System.out.println(Float.parseFloat(fPrice));
//        int tPrice = Integer.parseInt(newPrice);
//        System.out.println(Float.parseFloat(tPrice));

        /*practices 2
        Noi chuoi
        Trong java có String.format
        ít khi dùng concat hoặc toán tử +
        vì mỗi biến cộng tạo ra một biến nêu chuỗi dài thì gây tốn bộ nhớ
       */
//        String input1 = "Hien";
//        String input2 = "Hoang";
//        String space = " ";
//        String output = input1.concat(space);
//        String outputFinal = output.concat(input2);
//        System.out.println(outputFinal);
//        String name = String.format("%s %s", "Hien", "Hoang");
//        System.out.println(name);


        /*
        Practice 3: Trả về boolean nếu chứa kí tự viết hoa
         */
//        System.out.println(containUpperCase("ABc"));
//        System.out.println(containUpperCase("abc"));
//        System.out.println(containUpperCase("abC"));
//        System.out.println(containUpperCase(null));

        /*
        Practice 4: Check password nhập vào > 8 , chứa kí tự đặc biệt
         */
//        System.out.println(isvalidPassWord("hienht!@#$%^&*"));
//        System.out.println(isvalidPassWord("hienht"));
//        System.out.println(isvalidPassWord("hienht$"));
//        System.out.println(isvalidPassWord("12345678"));
//        System.out.println(isvalidPassWord(null));
    }

    private static boolean containUpperCase(String input){
        if(input==null || input.isEmpty()){
            return false;
        }
        return input.matches(".*[A-Z].*");
    }

    public static boolean isvalidPassWord(String password){
        if(password == null || password.isEmpty()) return false;
        if(password.length() < 8){
            return false;
        }
        else
            return password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()-+=])$");
    }
}
