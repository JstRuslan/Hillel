package org.summer2025.ruslan;

public class Main {
    public static void main(String[] args) {
        Address address=new Address("2", "5th Avenue", "New York", "121214","USA");
        Address address2=new Address("4", "5th Avenue", "New York", "121214","USA");
        User user = new User("Ruslan", "Demydov", address);

        System.out.println(user);
        user.setAddress(address2);
        System.out.println(user);

        Address address3 = user.getAddress();
        System.out.println(address3);
        }
    }
