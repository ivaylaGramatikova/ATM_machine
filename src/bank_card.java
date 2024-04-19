import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Bank_account {
    String name;
    ArrayList<String> account_nums = new ArrayList<>();
    ArrayList<Integer> unique_nums = new ArrayList<>();
    ArrayList<Integer> unique_pins = new ArrayList<>();

    Bank_account(String name){
        this.name = name;
    }

    String generateAccountNum() {
        Random random = new Random();
        String account_num;

        do{
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                sb.append(random.nextInt(10)); // Генерира случайна цифра и я добавя към номера на сметката
                if ((i + 1) % 4 == 0 && i != 15) {
                    sb.append(" "); // Добавя интервал на всеки 4 цифри, освен последните 4
                }
            }
            account_num = sb.toString();
        }while(account_nums.contains(account_num));

        account_nums.add(account_num);
        return account_num;
    }

    void generateUniqueNum() {
        Random random = new Random();
        int unique_num;

        do {
            unique_num = random.nextInt(900) + 100; // Генерира числа между 100 и 999
        } while (unique_nums.contains(unique_num)); // Проверява дали числото вече съществува

        unique_nums.add(unique_num);
        System.out.println("Generated unique num: " + unique_num);
    }

    void generateUniquePIN() {
        Random random = new Random();
        int minPIN = 1000; // Най-малкият възможен PIN код
        int maxPIN = 9999; // Най-големият възможен PIN код
        int uniquePIN;

        do {
            uniquePIN = random.nextInt(maxPIN - minPIN + 1) + minPIN; // Генерира случайно число в интервала [minPIN, maxPIN]
        } while (!isPINUnique(uniquePIN)); // Проверява дали генерираният PIN код е уникален

        unique_pins.add(uniquePIN); // Добавя генерирания уникален PIN код към списъка
        System.out.println("Generated unique PIN: " + uniquePIN);
    }

    boolean isPINUnique(int pin) {
        return !unique_pins.contains(pin);
    }

    void printAllPINs() {
        for (int pin : unique_pins) {
            System.out.println(pin);
        }
    }

    void show() {
        System.out.println("Hello!, Welcome to ATM card creator");
        System.out.println("You can write now your full name: " + name);

        String account_num = generateAccountNum();
        System.out.println("Generated account number: " + account_num);

        generateUniqueNum();
        generateUniquePIN(); // Генерира уникален PIN код

    }
}

public class bank_card {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your full name: ");
        String name = scanner.nextLine();

        Bank_account bankAccount = new Bank_account(name);
        bankAccount.show();
    }
}
