package marketplace;

import java.util.Objects;

public class Customer {
    public enum Gender {
        MALE, FEMALE
    }

    public String fullName;
    public int age;
    public String phoneNumber;
    public Gender gender;

    public Customer(String fullName, int age, String phoneNumber, Gender gender) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(
                fullName, customer.fullName
        ) && Objects.equals(
                phoneNumber, customer.phoneNumber
        ) && Objects.equals(
                gender, customer.gender
        );
    }
}
