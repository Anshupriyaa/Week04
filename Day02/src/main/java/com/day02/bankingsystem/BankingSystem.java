package com.day02.bankingsystem;

import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts;
    private Queue<Integer> withdrawalQueue;

    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void deposit(int accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Withdrawal of Rs" + amount + " processed for Account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance in Account: " + accountNumber);
            }
        }
    }

    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 500.0);
        bank.createAccount(102, 1000.0);
        bank.createAccount(103, 750.0);

        bank.deposit(101, 200);
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(101);

        bank.processWithdrawals(300);
        bank.displaySortedAccounts();
    }
}

