import java.util.ArrayList;

public class Branch {
    private final String name;
    private final ArrayList<Customer> customersList = new ArrayList<>();

    public Branch (String branchName) {
        this.name = branchName;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    public void viewCustomers() {
        System.out.println(STR."Now showing customers of \{name} branch:");
        int count = 1;
        for (Customer customer : customersList) {
            System.out.println(STR."\{count++}. \{customer.getName()}");
        }
    }

    public boolean addCustomer (String name, double initialAmount) {
        Customer customer = findCustomer(name);

        if(customer == null) {
            customer = new Customer(name, initialAmount);
            return customersList.add(customer);
        }

        System.out.println("Customer already exists.");
        return false;
    }

    private Customer findCustomer(String  name) {
        return customersList.stream()
                .filter(customer -> customer.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean addCustomerTransaction (String name, double transaction) {
        Customer customer = findCustomer(name);

        if (customer == null) {
            return false;
        }
        return customer.addTransaction(transaction);
    }

}
