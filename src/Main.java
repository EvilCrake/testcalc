import java.util.Scanner;

public class Main {
    private static String arabicToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Число должно быть от 1 до 3999");
        }

        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int[] arabicValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        StringBuilder roman = new StringBuilder();

        int i = arabicValues.length - 1;
        while (num > 0) {
            if (num >= arabicValues[i]) {
                roman.append(romanNumerals[i]);
                num -= arabicValues[i];
            } else {
                i--;
            }
        }

        return roman.toString();
    }

    private static int romanToArabic(String roman) {
        if (roman.equals("I")) return 1;
        if (roman.equals("II")) return 2;
        if (roman.equals("III")) return 3;
        if (roman.equals("IV")) return 4;
        if (roman.equals("V")) return 5;
        if (roman.equals("VI")) return 6;
        if (roman.equals("VII")) return 7;
        if (roman.equals("VIII")) return 8;
        if (roman.equals("IX")) return 9;
        if (roman.equals("X")) return 10;
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

            try {
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static String calc(String input) {
        String[] parts = input.split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат выражения");
        }
        try {
            int num1 = 0;
            int num2 = 0;
            if (parts[0].matches("[IIIIIIIVVVIVIIVIIIIXX]+") && parts[2].matches("[IIIIIIIVVVIVIIVIIIIXX]+")) {
                num1 = romanToArabic(parts[0]);
                num2 = romanToArabic(parts[2]);
            } else {
                num1 = Integer.parseInt(parts[0]);
                num2 = Integer.parseInt(parts[2]);
            }
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            }
            String operator = parts[1];
            int result = 0;
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
                default: throw new IllegalArgumentException("Неверный оператор");
            }
            if (result < 1 || result > 3999) {
                throw new IllegalArgumentException("Результат должен быть от 1 до 3999");
            }
            if (parts[0].matches("[IIIIIIIVVVIVIIVIIIIXX]+") && parts[2].matches("[IIIIIIIVVVIVIIVIIIIXX]+")) {
                return arabicToRoman(result);
            } else {
                return Integer.toString(result);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат чисел");
        }
    }
}
