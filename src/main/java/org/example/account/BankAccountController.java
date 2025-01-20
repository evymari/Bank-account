package org.example.account;

public class BankAccountController {
    // Create a savings account
    public static void main(String[] args) {
        BankAccountService service = new BankAccountService();

        // Create a new savings account
        SavingsAccount savings = service.createSavingsAccount(15000.0f, 5.0f);
        service.deposit(savings, 2000.0f);
        service.withdraw(savings, 5000.0f);
        service.generateMonthlyStatement(savings);
        System.out.println(service.getAccountDetails(savings));

        // Create a new checking account
        CheckingAccount checking = service.createCheckingAccount(1000.0f, 3.0f);
        service.withdraw(checking, 1500.0f);
        service.deposit(checking, 700.0f);
        service.generateMonthlyStatement(checking);
        System.out.println(service.getAccountDetails(checking));
    }
}

