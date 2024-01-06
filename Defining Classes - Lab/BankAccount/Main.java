package JavaAdvancedLab.DefeiningClasses.BankAccount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String CREATE = "Create";
    private static final String END_COMMAND = "End";
    private static final String DEPOSIT = "Deposit";
    private static final String SET_INTEREST = "SetInterest";
    private static final String GET_INTEREST = "GetInterest";
    private static final Map<Integer, BankAccount> account = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!END_COMMAND.equals(input)) {
            String [] inputParts = input.split(" ");
            String command = inputParts[0];

            String result = "";
            switch (command) {
                case CREATE:
                    result = createAccount();
                    break;
                case DEPOSIT:
                    result = depositInAccount(inputParts);
                    break;
                case GET_INTEREST:
                    result = getInterest(inputParts);
                    break;
                case SET_INTEREST:
                    result = setInterest(inputParts);
                    break;
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }
            input = scanner.nextLine();
        }
    }

    private static String setInterest(String[] inputParts) {
        double interest = Double.parseDouble(inputParts[1]);

        BankAccount.setInterestRate(interest);
        return "";
    }

    private static String getInterest(String[] inputParts) {
        int accountNumber = Integer.parseInt(inputParts[1]);
        int period = Integer.parseInt(inputParts[2]);

        BankAccount bankAccount = account.get(accountNumber);

        if (bankAccount == null) {
            return "Account does not exist";
        }
        double interest = bankAccount.getInterest(period);

        return String.format("%.2f",interest);

    }

    private static String depositInAccount(String [] inputParts) {
        int accountNumber = Integer.parseInt(inputParts[1]);
        double sum = Double.parseDouble(inputParts[2]);
        BankAccount bankAccount = account.get(accountNumber);

        if (bankAccount == null) {
            return "Account does not exist";
        }

        bankAccount.deposit(sum);

        return String.format("Deposited %.0f to ID%d", sum, accountNumber);

    }

    private static String createAccount() {
        BankAccount bankAccount = new BankAccount();
        int id = bankAccount.getID();

        account.put(id, bankAccount);

        return String.format("Account ID%d created", id);
    }
}
