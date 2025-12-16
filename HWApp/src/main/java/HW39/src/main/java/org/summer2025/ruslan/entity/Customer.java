package org.summer2025.ruslan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private int id;
    private String fullName;
    private String email;
    private String socialSecurityNumber;

    @Override
    public String toString() {
        return "Customer{id=" + id + ", fullName='" + fullName + "', email='" + email + "', ssn='" + socialSecurityNumber + "'}";
    }
}
