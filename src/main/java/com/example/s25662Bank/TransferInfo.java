package com.example.s25662Bank;


import org.springframework.stereotype.Component;

public class TransferInfo {
    private final String status;
    private float balance;

    public TransferInfo(String status, float balance) {
        this.status = status;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "TransferInfo{" +
                "status='" + status + '\'' +
                ", balance=" + balance +
                '}';
    }
}
