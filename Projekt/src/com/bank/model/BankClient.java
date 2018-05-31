package com.bank.model;

public class BankClient {
    private Person bankClient;
    private double clientFunds;

    public BankClient(Person bankClient, double clientFunds) {
        this.bankClient = bankClient;
        this.clientFunds = clientFunds;
    }

    public Person getBankClient() {
        return bankClient;
    }

    public void setBankClient(Person bankClient) {
        this.bankClient = bankClient;
    }

    public double getClientFunds() {
        return clientFunds;
    }

    public void setClientFunds(double clientFunds) {
        this.clientFunds = clientFunds;
    }

    @Override
    public String toString() {
        return "BankClient{" +
                "bankClient=" + bankClient +
                ", clientFunds=" + clientFunds +
                '}';
    }
}
