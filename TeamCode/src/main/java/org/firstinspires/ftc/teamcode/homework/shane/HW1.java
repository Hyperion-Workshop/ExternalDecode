package org.firstinspires.ftc.teamcode.homework.shane;

public class HW1 {
    public static void main(String[] args) {
        System.out.print(getFibonacci(11));
    }

    public static int getFibonacci(int index) {
        int result = 0;
        if (index < 0) {
            return result;
        }
        int first = 0;
        int second = 1;
        int third;
        for (int i = 2; i < index; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
