package com.example.s25662Bank;




public class User {
    private int id;
    private float balance;


    public User(int id, float balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public float getBalance() {
        return balance;
    }


    public void setBalance(float balance) {
        this.balance = balance;
    }
}
