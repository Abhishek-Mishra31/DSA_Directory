package Leet_Code_Questions;

import java.util.Scanner;

public class TowerOfHanoi {

    public static void func(int n, int src, int dest, int temp) {
        if (n == 1) {
            System.out.println(src + " " + dest);
            return;
        }

        func(n - 1, src, temp, dest);
        System.out.println(src + " " + dest);
        func(n - 1, temp, dest, src);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println((int)(Math.pow(2 , input) - 1));
        func(input , 1 , 3 , 2);
    }
}
