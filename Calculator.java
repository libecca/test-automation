package com.company;

import java.util.*;


public class Calculator {

    public static void main(String[] args) {
        char operator;
        double num1,num2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number");
        num1 = input.nextDouble();

        System.out.println("Enter the Operator(+,-,*,/)");
        operator = input.next().charAt(0);

        System.out.println("Enter the second number");
        num2 = input.nextDouble();

        input.close();

        switch(operator){
            case '+':
                System.out.printf("%.2f + %.2f = %.2f",num1,num2,(num1+num2));
               break;

            case '-':
                System.out.printf("%.2f - %.2f = %.2f",num1,num2,(num1-num2));
                break;

            case '*':
                System.out.printf("%.2f * %.2f = %.2f",num1,num2,(num1*num2));
                break;

            case '/':
                if(num2 != 0)
                    System.out.printf("%.2f / %.2f = %.2f",num1,num2,(num1/num2));
                else
                    System.out.println("Zero");
                break;

            default:
                System.out.printf("%c is an invaild operator",operator);

        }

    }
}
