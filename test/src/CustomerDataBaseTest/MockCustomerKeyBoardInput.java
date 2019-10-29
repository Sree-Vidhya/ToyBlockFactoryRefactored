package CustomerDataBaseTest;

import CustomerDataBase.Customer;
import CustomerDataBase.CustomerInput;
import CustomerDataBase.CustomerRepository;


public class MockCustomerKeyBoardInput implements CustomerInput {
    String name;
    String address;
    int custID;
    Customer getCustomer;
    Customer getCustomerwithCode;
    Customer customer;

    public MockCustomerKeyBoardInput(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @Override
    public int generateNextCustId()
    {
        return generateCustomerDetailsFromTheInformationProvided().custID;

    }
    @Override
    public String getNameFromTheUser() {
        return name;
    }

    @Override
    public String getAddressFromTheUser() {
        return null;
    }
    public Customer generateCustomerDetailsFromTheInformationProvided()
    {
        customer = new Customer(name,address);
        return customer;
    }

    @Override
    public Customer getCustomerWithCode(int custID) {
        getCustomer =  CustomerRepository.getCustomerFromDataBase(custID);
        return getCustomer;
    }

    @Override
    public Customer getCustomerFromDatabase() {
        getCustomerwithCode = getCustomerWithCode(custID);
        if(customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("No such customer in database");
        }
        return customer;
    }
}
