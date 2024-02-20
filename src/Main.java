import java.util.Scanner;

public class Main {
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
            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[2]);
            String operator = parts[1];

            double result;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    return "Ошибка: неверный оператор";
            }

            return Double.toString(result);
        } catch (NumberFormatException e) {
            return "Ошибка: неверный формат чисел";
        }
    }
}
