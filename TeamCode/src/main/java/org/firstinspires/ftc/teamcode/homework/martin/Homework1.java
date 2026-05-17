package org.firstinspires.ftc.teamcode.homework.martin;

public class Homework1 {
    public static void main(String[] args){
        System.out.print(getFibonacci(3));
    }

    static int getFibonacci(int index){
      if(index > 0){
            int num = 1;
            int prevnum = 0;
            for(int i=0;i<index-1;i++){
                num += prevnum;
                prevnum = num-prevnum;
            }
            return num;
        }else{
            return 0;
        }
    }
}
