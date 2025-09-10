import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Deutsche Bank. View our branches, customers and their transaction history.");

        loop: while (true) {
            printInstructions();
            System.out.print("\nPlease selection an option: ");
            String input = scanner.nextLine();
            switch (Integer.parseInt(input)) {
                case 0 -> printInstructions();
                case 1 -> viewAllBranchesAndCustomers();
                case 2 -> viewAllBranches();
                case 3 -> viewBranchCustomers();
                case 4 -> addBranch();
                case 5 -> addCustomer();
                case 6 -> addTransaction();
                case 7 -> {
                    System.out.println("Thank you for using Deutsche Bank. Good bye.");
                    break loop;
                }
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress 0 to print the options again.");
        System.out.println("Press 1 to view all our branches and its customers.");
        System.out.println("Press 2 to view the list of branches.");
        System.out.println("Press 3 to view a branch's customers.");
        System.out.println("Press 4 to add a new branch.");
        System.out.println("Press 5 to add a new customer.");
        System.out.println("Press 6 to add a transaction for a customer.");
        System.out.println("Press 7 to exit the application.");
    }

    private static void viewAllBranchesAndCustomers() {
        boolean seeTransactions = false;
        System.out.println("Would you like to see the transactions of all the customers?");
        if (scanner.nextLine().equals("yes")) {
            seeTransactions = true;
        }
        Bank.viewAllBranchesAndCustomers(seeTransactions);
    }

    private static void viewAllBranches() {
        Bank.viewBranches();
    }

    private static void viewBranchCustomers() {
        System.out.println("Which branch's customers would you like to see?");
        String branchName = scanner.nextLine();

        boolean checkValidity = Bank.showBranchCustomers(branchName);

        if (!checkValidity) {
            System.out.println("\nBranch does not exist in the database.");
        }
    }

    private static void addBranch() {
        System.out.print("Enter a name for the new branch: ");
        String branchName = scanner.nextLine();
        if (!Bank.addBranch(branchName)) {
            System.out.println("Branch already exists.");
        } else {
            System.out.println("\n" + branchName + " has been added to the database.");
        }
    }

    private static void addCustomer() {
        System.out.print("To which branch would you like to add the customer to: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter the name of the customer: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter their first transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        boolean checkValidity = Bank.addCustomer(branchName, customerName, amount);

        if (!checkValidity) {
            System.out.println("Branch does not exist in the database.");
        }

    }

    private static void addTransaction() {
        System.out.print("Enter the name of the customer: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter the name of the customer's branch: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter their transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        boolean checkValidity = Bank.addTransaction(branchName, customerName, amount);

        if (!checkValidity) {
            System.out.println("Invalid data entered.");
        }
    }
}