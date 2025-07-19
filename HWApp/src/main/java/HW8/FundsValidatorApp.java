package HW8;

import java.util.Scanner;

public class FundsValidatorApp {
    static double balance = 1000;

    public static void main(String[] args) {
        while (true) {
            validateAmount(getAmount());
            System.out.println("--------------------------");
        }
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double newBalance) {
        balance = newBalance;
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", getBalance());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static void validateAmount(double withdrawal) {
        if (withdrawal <= 0) {
            System.out.println("Enter the value > 0.00");
            return;
            }
        if (withdrawal > getBalance()) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            madePuchase(withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f\n", getBalance());
        }
    }

    private static void madePuchase(double withdrawal) {
        setBalance(getBalance() - withdrawal);
    }


}
