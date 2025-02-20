package org.example.lesson02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[7];
        users[0] = new User();
        users[1] = new User();
        users[2] = new User();
        users[3] = new User();
        users[4] = new User();
        users[5] = new User();
        users[6] = new User();

        System.out.println("List user is");
        for (User user : users) {
            user.info();
        }
        /*
        1. Print to old user
         */
        System.out.println("User has old is: ");
        Arrays.stream(users).max(Comparator.comparing(User::getYearOld)).get().info();

        /*
        2. Print total years old
         */
        System.out.printf("Total years old is ");
        int totalYearsOld = Arrays.stream(users).mapToInt(User::getYearOld).sum();
        System.out.println(totalYearsOld);
        /*
        3. Sort by year old
         */
        System.out.println("Sorted user when sort with reduce years old is");
        List<User> userSorredByYearsOld = Arrays.stream(users).sorted(Comparator.comparing(User::getYearOld).reversed()).collect(Collectors.toList());
        for(User user:userSorredByYearsOld){
            user.info();
        }
    }
}
