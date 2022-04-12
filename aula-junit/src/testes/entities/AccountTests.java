package testes.entities;

import entities.Account;
import factory.AccountFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {

    //   Nomenclatura do teste
//    <AÇÃO> should <EFEITO> [When <CENARIO>] OBS: Como boa prática cada cenário seja um teste diferente, não fazer ifElse no test".

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {

//        Padrão AAA (Arrange, Act, Assert)


//      Arrange (instaciar os obj necessarios)
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createAccount();

//        Act (execute acões necessarias)
        acc.deposit(amount);

//        Assert (o que deveria acontecer "resultado esperado")
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    //    Deposito sem ação quanto quantia for negativa
    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {

        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnBalance(){

        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(800.0);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance(){

        Account acc = AccountFactory.createAccount(800.0);

        acc.withdraw(500.0);

        Assertions.assertEquals(300, acc.getBalance());
    }

//    Para Exceções deve se utilizar uma expressão lambda!
    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = AccountFactory.createAccount(800.0);
            acc.withdraw(801.0);
        });
    }
}
