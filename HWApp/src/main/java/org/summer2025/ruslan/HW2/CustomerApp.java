package org.summer2025.ruslan.HW2;

public class CustomerApp {

    public static void main(String[] args){
        Customer customer = getCustomer(getData());
        String output = "Customer: " + customer.getName() + ", phone " + customer.getPhone();
        getOutput(output);
    }

    public static String[] getData() {
        String[] data = new String[2];
        data[0] = "Tom";
        data[1] = "555 123-8596";
        return data;
    }

    public static Customer getCustomer(String[] data) {
        return new Customer(data[0], data[1]);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}
