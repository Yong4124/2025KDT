package a1;

import java.util.Scanner;

public class IfExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수: ");
        String inputdata = sc.nextLine();
        int score = Integer.parseInt(inputdata);
        
        if (score >= 90 && score <= 100) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
    }
}