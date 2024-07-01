import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String password;
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);

        //============Проверка на корректный ввод минимальной длины пароля============
        try {
            System.out.print("Введите мин.длину пароля: ");
            int minLength = Integer.parseInt(scanner.nextLine());
            passwordChecker.setMinLength(minLength);
        } catch (IllegalArgumentException e) {
            System.out.println("Минимальная длина пароля должна быть не меньше 0!");
            System.out.println("Программа завершена.");
            return;
        }

//        ============Проверка на максимальное допустимое количество повторений символа подряд============
        try {
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int maxRepeats = Integer.parseInt(scanner.nextLine());
            passwordChecker.setMaxRepeats(maxRepeats);
        } catch (IllegalArgumentException e) {
            System.out.println("Максимальное количество повторений символов подряд должно быть больше 0!");
            System.out.println("Программа завершена.");
            return;
        }

        while (true) {
            System.out.println("Введите пароль для проверки пароля по заданным параметрам:\n" +
                    "\t Минимальная длина пароля: " + passwordChecker.getMinLength() +
                    "\n\t Максимальное количество повторений симовола подряд: " + passwordChecker.getMaxRepeats() +
                    "\nили \"end\" для завершения программы: ");
            String input = scanner.nextLine();

            if ("end".equalsIgnoreCase(input)) {
                System.out.println("Программа завершена.");
                break;
            } else {
                password = input;
                if (passwordChecker.verify(password)) {
                    System.out.printf("Пароль \"%s\" подходит!\n", password);
                } else {
                    System.out.printf("Пароль \"%s\" не подходит!\n", password);
                }
                System.out.println();
            }
        }
    }
}