import java.util.Scanner;

public class Main {
    private static int romanToArabic(String roman) {
        if (roman.equals("I")) return 1;
        if (roman.equals("V")) return 5;
        if (roman.equals("X")) return 10;
        if (roman.equals("L")) return 50;
        if (roman.equals("C")) return 100;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите арифметическое выражение (или 'выход' для выхода): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("выход")) {
                System.out.println("Работа приложения завершена.");
                break;
            }

            String result = calc(input);
            System.out.println("Результат: " + result);
        }

        scanner.close();
    }

    public static String calc(String input) {
        String[] parts = input.split("\\s+");
        if (parts.length != 3) {
            return "Ошибка: неверный формат выражения";
        }
        try {
            int num1 = 0;
            int num2 = 0;
            if (parts[0].matches("[IVXLCDM]+") && parts[2].matches("[IVXLCDM]+")) {
                num1 = romanToArabic(parts[0]);
                num2 = romanToArabic(parts[2]);
            } else {
                num1 = Integer.parseInt(parts[0]);
                num2 = Integer.parseInt(parts[2]);
            }
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                return "Ошибка: числа должны быть от 1 до 10";
            }
            String operator = parts[1];
            int result = 0;
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
                default: return "Ошибка: неверный оператор";
            }
            if (result < 1 || result > 10) {
                return "Ошибка: результат должен быть от 1 до 10";
            }
            return Integer.toString(result);
        } catch (NumberFormatException e) {
            return "Ошибка: неверный формат чисел";
        }
    }
}
