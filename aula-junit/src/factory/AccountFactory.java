package factory;

import entities.Account;

// Fábrica se usa para não precisar ficar instanciando um novo obj com "new", usando apenas o AccountFactory.createAccount

public class AccountFactory {

    public static Account createAccount(){
        return new Account(1L, 0.0);
    }

    public static Account createAccount(double initialBalance) {
        return new Account(1L, initialBalance);
    }
}
