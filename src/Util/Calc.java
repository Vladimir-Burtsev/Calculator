package Util;

public interface Calc {
    static int result (int a, int b, String sing) {
        int result = 0;
        switch (sing){
            case "+": result = a + b;
                      break;
            case "-": result = a - b;
                      break;
            case "*": result = a * b;
                      break;
            case "/": result = a / b;
                      break;
        }
        return result;
    }
}
