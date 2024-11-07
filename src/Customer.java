import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactionsList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Customer (String name, double initialAmount) {
        this.name = name;
        this.transactionsList.add(initialAmount);
    }

    public boolean addTransaction (double transaction) {
        if (transaction < 0) {
            return false;
        }
        return transactionsList.add(transaction);
    }

    public void transactionHistory() {
        int count = 1;
        System.out.println("Transaction History:");
        for (Double transaction : transactionsList) {
            System.out.println(count++ + ". $" + transaction);
        }
    }
}
