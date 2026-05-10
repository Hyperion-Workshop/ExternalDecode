package org.firstinspires.ftc.teamcode.homework.Fred;
public class HW1 {
    public static void main(String[] args) {
        int index = 5;
        for (int i=0; i<=index; i++){
            int result = getFibonacci(i);
            System.out.print(result);
        }
    }
    public static int getFibonacci(int index) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) return 0;
        if (index == 1) return 1;
        int index1 = 0;
        int index2 = 1;
        for (int i = 2; i <= index; i++) {
            int index3 = index1 + index2;
            index1 = index2;
            index2 = index3;
        }
        return index2;
    }
}