package org.example.lesson02;

import java.util.Random;

public class User {
    private String name;
    private int height;
    private int yearOld;
    private String gender;

    public User(){
        this.name = randomName();
        this.height = randomNumber(150,180);
        this.yearOld = randomNumber(25,45);
        this.gender = randomGender();
    }
    public void info(){
        System.out.printf("name: %s\n",this.name);
        System.out.printf("height: %d\n",this.height);
        System.out.printf("birth_year: %s\n",this.yearOld);
        System.out.printf("gender: %s\n",this.gender);
        System.out.println("--------------------------");

    }
    public String getName(){
        return name;
    }
    public int getHeight(){
        return height;
    }
    public int getYearOld() {
        return yearOld;
    }

    public String getGender() {
        return gender;
    }

    private int randomNumber(int min, int max){
        Random rand = new Random();
        int number = rand.nextInt(max-min+1)+min;
        return number;
    }
    private String randomName(){
        Random rand = new Random();
        String[] name ={"Hien","Huong","Hung","Linh","Nga","Thao","Thy"};
        return name[rand.nextInt(name.length)];
    }
    private String randomGender(){
        Random rand = new Random();
        String[] gender ={"Male","Female"};
        return gender[rand.nextInt(gender.length)];
    }
    //function to generate a random string of length n
//    private String randomString(){
//        Random rand = new Random();
//        return
//    }
}
