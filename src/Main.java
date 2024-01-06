import Util.*;

public class Main {
    public static void main(String[] args) throws MyException {
        String scan = Scan.equation();
        Splitter splitter = new Splitter();
        splitter.split(scan);

        if (Convertor.isValid(splitter.getA(), splitter.getB())) {
            if (Convertor.isNumeric(splitter.getA())) {
                System.out.println(Calc.result(Integer.parseInt(splitter.getA()),
                        Integer.parseInt(splitter.getB()),
                        splitter.getSign()));
            }
            else {
                if (Calc.result(
                        Convertor.fromRomanNumeral(splitter.getA()),
                        Convertor.fromRomanNumeral(splitter.getB()),
                        splitter.getSign()
                ) <= 0) {
                    throw new MyException("в римской системе счисления нет 0 и отрицательных значений");
                }
                else {
                    System.out.println(
                            Convertor.toRomanNumeral(Calc.result(
                                    Convertor.fromRomanNumeral(splitter.getA()),
                                    Convertor.fromRomanNumeral(splitter.getB()),
                                    splitter.getSign()
                            )));
                }
            }
        }
    }
}
