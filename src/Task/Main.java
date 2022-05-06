package Task;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Введи мат. операцию. Пример: 2 + 2 или I + I");
        String res = scanner.nextLine();
        System.out.println(calc(res));
    }

    public static String calc(String input) throws Exception {
        String[] arr = input.split(" ");
        if (arr.length > 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (arr.length == 1) {
            throw new Exception("т.к. строка не является математической операцией");
        }
        int res;
        boolean Roman = false;
        Roman roman = new Roman();
        if (roman.testRomanNum(arr[0]) && roman.testRomanNum(arr[2])) {
            arr[0] = roman.NumbersOfRoman(arr[0]);
            arr[2] = roman.NumbersOfRoman(arr[2]);
            Roman = true;
        }
            int num1;
        int num2;
        try {
            num1 = Integer.parseInt(arr[0]);
            num2 = Integer.parseInt(arr[2]);
        } catch (Exception exception) {
            throw new Exception("т.к. используются одновремено разные системы счисления");
        }

            if ((num1 < 0 || num1 > 10) || (num2 < 0 || num2 > 10)) {
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более");
            }
            {
                res = switch (arr[1]) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> throw new Exception("т.к. необходимо ввести подходящий операнд . (+,-,*,/)");
                };

                if (Roman) {
                    if (res <= 0) {
                        throw new Exception("т.к. в римской системе нет отрицательных чисел");
                    }
                    return roman.romanValue[res];
                }
                return String.valueOf(res);
            }
        }
    }










