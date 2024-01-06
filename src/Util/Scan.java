package Util;

import java.util.Scanner;

public interface Scan {
    static String equation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите простое математическое уравнение. Членами уравнения могут быть римские или арабские числа от 1 до 10");
        String equation = scanner.nextLine();
        scanner.close();
        return equation.toUpperCase();
    }
}
 