package util;

import entity.Customer;

public class CustomerTM {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private int onOfMembors;

    public CustomerTM() {
    }

    public CustomerTM(String customerId, String customerName, String phoneNumber, int onOfMembors) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.onOfMembors = onOfMembors;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOnOfMembors() {
        return onOfMembors;
    }

    public void setOnOfMembors(int onOfMembors) {
        this.onOfMembors = onOfMembors;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", onOfMembors=" + onOfMembors +
                '}';
    }
}
