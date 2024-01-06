package Util; /**
 * Выделение из уравнения арифметического знака и переменных при помощи сплита.
 */

import Util.MyException;

import java.util.ArrayList;
import java.util.Arrays;

public class Splitter {
    private String a;
    private String b;
    private String sign;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getSign() {
        return sign;
    }

    public void split(String equation) throws MyException {
        String[] action = {"+", "-", "*", "/"};
        String equationSign = null;
        String regex;
        ArrayList<String> list;
        int index = -1;
        for (int i = 0; i < action.length; i++) {
            if (equation.contains(action[i])) {
                equationSign = action[i];
                index++;
            }
        }if (index > 0){
            throw  new MyException("Уравнение должно содержать 2 переменные.");
        }if (index == -1){
            throw  new MyException("Уравнение не содержит арифметического знака.");
        }
        regex = "\\" + equationSign;
        list = new ArrayList<>(Arrays.asList(equation.replaceAll(" ", "").split(regex)));
        list.add(equationSign);
        a = list.get(0);
        b = list.get(1);
        sign = list.get(2);
    }
}
