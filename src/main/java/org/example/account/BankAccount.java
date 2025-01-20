package org.example.account;

public class BankAccount {
    protected float balance;
    protected float annualInterestRate;
    protected float monthlyFee;
    protected int numDeposits;
    protected int numWithdrawals;

    public BankAccount(float initialBalance, float annualInterestRate) {
        this.balance = initialBalance;
        this.annualInterestRate = annualInterestRate;
        this.monthlyFee = 0;
        this.numDeposits = 0;
        this.numWithdrawals = 0;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            numDeposits++;
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numWithdrawals++;
        }
    }

    public void generateMonthlyStatement() {
        // Calcular y aplicar el interés mensual
        float monthlyInterestRate = annualInterestRate / 12 / 100;
        balance += balance * monthlyInterestRate;

        // Redondear el balance después del interés
        balance = roundToTwoDecimalPlaces(balance);

        // Restar la comisión mensual del saldo
        balance -= monthlyFee;

        // Redondear nuevamente después de aplicar la comisión
        balance = roundToTwoDecimalPlaces(balance);

        // Reiniciar la comisión mensual para el siguiente mes
        monthlyFee = 0;
    }

    public String printAccountDetails() {
        return "Balance: " + balance + ", Annual Interest Rate: " + annualInterestRate +
                ", Monthly Fee: " + monthlyFee + ", Deposits: " + numDeposits +
                ", Withdrawals: " + numWithdrawals;
    }

    // Método auxiliar para redondear a dos decimales
    private float roundToTwoDecimalPlaces(float value) {
        return Math.round(value * 100.0f) / 100.0f;
    }
}