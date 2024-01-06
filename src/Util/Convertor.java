package Util;

/*
    1. Символы записываются от наибольшего к наименьшему,
       чтобы указать, что их значения должны быть сложены.
       Например, число 27 записывается как XXVII, а не VXXII.

    2. Когда символ с меньшим значением стоит перед символом с большим значением,
       это указывает на вычитание. Например, число 4 записывается как IV, а не IIII.

    3. Символы I, X и C могут повторяться не более трех раз подряд,
       чтобы избежать неоднозначности.
       Например, число 14 записывается как XIV, а не XIIII.

    4. Символы V, L и D никогда не повторяются.

    5. Символы I, X и C могут использоваться в сочетании с символами,
       которые имеют более высокое значение,
       чтобы увеличить значение. Например,
       число 8 записывается как VIII, а не IIX.

    6. Символы, которые имеют более высокое значение,
       всегда стоят перед символами, которые имеют более низкое значение.

    7. Числа, которые больше 3999,
       не могут быть записаны в системе римских цифр.
 */
public class Convertor {
    private final static String[] ROMAN_NUMERALS = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final static int[] DECIMAL_VALUES = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String toRomanNumeral(int number) {
        var result = new StringBuilder();
        int remaining = number;
        for (int i = 0; i < ROMAN_NUMERALS.length; i++) {
            int decimalValue = DECIMAL_VALUES[i];
            String romanNumeral = ROMAN_NUMERALS[i];
            while (remaining >= decimalValue) {
                result.append(romanNumeral);
                remaining -= decimalValue;
            }
        }
        return result.toString();
    }

    public static int fromRomanNumeral(String romanNumeral) {
        int result = 0;
        var input = romanNumeral.toUpperCase();
        for (int i = 0; i < ROMAN_NUMERALS.length; i++) {
            var romanNumeralToCheck = ROMAN_NUMERALS[i];
            int decimalValue = DECIMAL_VALUES[i];
            while (input.startsWith(romanNumeralToCheck)) {
                result += decimalValue;
                input = input.substring(romanNumeralToCheck.length());
            }
        }
        return result;
    }

    public static boolean isRoman(String number) {
        boolean isRoman = false;
        for (String romanNumeral : ROMAN_NUMERALS) {
            if (number.equalsIgnoreCase(toRomanNumeral(fromRomanNumeral(number)))
                    && number.toUpperCase().contains(romanNumeral)){
                isRoman = true;
                break;
            }
        }
        return isRoman;
    }

    public static boolean isNumeric(String s) throws MyException {
        try {
            Integer.parseInt(s);
            if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) > 10) {
                throw new MyException("На вход должны поступать числа от 1 до 10");
            }else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValid (String number1, String number2) throws MyException {
        if (isNumeric(number1) == isNumeric(number2)
                || isRoman(number1) == isRoman(number2)){
            return true;
        }else {
            throw new MyException("используются одновременно разные системы счисления");
        }
    }

}
