package org.firstinspires.ftc.teamcode.homework.Ishan;

public class hw1 {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("Fib number is : " + getFibonacci(6));
    }

    public static int getFibonacci(int n) {
        int prevfib = 0;
        int currentfib=1;
        int  i=1;
        while (i<=n) {

            int nextfib=prevfib + currentfib;
            prevfib= currentfib;
            currentfib=nextfib;
            i=i+1;
        }
        return currentfib;

    }




}
