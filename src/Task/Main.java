package Task;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("������� ��� ��������.  ������ 2 + 2 ��� I + I");
        String res = scanner.nextLine();
        System.out.println(calc(res));
    }

    public static String calc(String input) throws Exception {
        String[] arr = input.split(" ");
        if (arr.length > 3) {
            throw new Exception("�.�. ������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
        } else if (arr.length == 1) {
            throw new Exception("�.�. ������ �� �������� �������������� ���������");
        } else if (arr[1].equals(" ")) {
            throw new Exception("�������� ������ �����. 1 + 1");
        }
        int res = 0;
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
            throw new Exception("�.�. ������������ ������������ ������ ������� ���������");
        }

            if ((num1 < 0 || num1 > 10) || (num2 < 0 || num2 > 10)) {
                throw new Exception("�� ���� ����� �� 1 �� 10 ������������, �� �����");
            }
            {
                switch (arr[1]) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new Exception("������ ������������ �������. (+,-,*,/)");
                }

                if (Roman) {
                    if (res <= 0) {
                        throw new Exception("�.�. � ������� ������� ��� ������������� �����");
                    }
                    return roman.romanValue[res];
                }
                return String.valueOf(res);
            }
        }
    }










