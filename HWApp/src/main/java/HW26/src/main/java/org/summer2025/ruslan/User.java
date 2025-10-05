package org.summer2025.ruslan;

public class User {
    private String name;
    private String lastName;
    private Address address;

    public User(String name, String lastName, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public void setAddress(Address address){
        this.address=address;
    }

    public Address getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
