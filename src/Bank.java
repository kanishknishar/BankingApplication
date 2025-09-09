import java.util.ArrayList;

public class Bank {
    private static ArrayList<Branch> branches = new ArrayList<>();

    public static boolean addBranch(String name) {
        if (findBranch(name) != null) {
            return false;
        }
        branches.add(new Branch(name));
        return true;
    }

    public static boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);

        if (branch == null) {
            return false;
        }

        return branch.addCustomer(customerName, initialAmount);
    }

    public static boolean addTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);

        if (branch == null) {
            return false;
        }

        return branch.addCustomerTransaction(customerName, amount);
    }

    private static Branch findBranch(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equals(name)) {
                return branch;
            }
        }

        return null;
    }

    public static boolean showBranchCustomers(String branchName) {
        Branch branch = findBranch(branchName);

        if (branch == null) {
            return false;
        }

        branch.viewCustomers();
        return true;
    }

    public static void viewAllBranchesAndCustomers(boolean seeTransactions) {
        if (branches == null) {
            System.out.println("No branches exist currently.");
        }

        for (Branch branch : branches) {
            System.out.printf("Now seeing customers of the %s branch:\n", branch.getName());
            int customerCount = 1;
            for (Customer customer : branch.getCustomersList()) {
                System.out.printf("%s. %s - \n", RomanNumerals.roman(customerCount), customer.getName());
                if (seeTransactions) {
                    customer.transactionHistory();
                }
                customerCount++;
            }
        }
    }

    public static void viewBranches() {
        if (branches == null) {
            System.out.println("No branches exist currently.");
        }

        int count = 1;
        System.out.println("List of branches:\n");
        for (Branch branch : branches) {
            System.out.println(count++ + ". " + branch.getName());
        }
    }

}
