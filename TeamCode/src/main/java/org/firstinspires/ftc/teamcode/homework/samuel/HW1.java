package org.firstinspires.ftc.teamcode.homework.samuel;

public class HW1 {
    public static void main(String[] args ) {
        int index = 3;
        System.out.print(getFibonacci(index));

    }

    static int getFibonacci(int index) {
        if (index < 0) {
            return -1;
        }
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }

        return getFibonacci(index - 1) + getFibonacci(index - 2);
    }
}
