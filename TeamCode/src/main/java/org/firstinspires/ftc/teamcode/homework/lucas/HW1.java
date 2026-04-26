package org.firstinspires.ftc.teamcode.homework.lucas;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        System.out.println("HELLO WORLD");
        Scanner indexInput = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int index = indexInput.nextInt();
        System.out.println(getFibonacci(index));
    }
    public static int getFibonacci(int index) {
        if (index <= 0) {
            return 0;
        }

        int a = 0;
        int b = 1;

        for (int i = 0; i < index-1; i++) {
            int sum = a + b; //set third number(sum)
            a = b; //set new first number to old second number
            b = sum; //set new second number to third number(sum)
        }
        return b;
    }
}