package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	BankAccount strict1 = new StrictBankAccount(1234, 10000, 10);
    	BankAccount strict2 = new StrictBankAccount(4321, 10000, 10);
 
    	AccountHolder holder1 = new AccountHolder("Marco", "Serpentieri", 1234);
    	AccountHolder holder2 = new AccountHolder("Carmelo", "Pauselunghe", 4321);
    	
    	//Controllo su UserID
    	try {
    		strict1.deposit(0000, 1000);
    		fail();
    	}catch(WrongAccountHolderException w) {
    		assertNotNull(w);
    	}
    		
    	try {
    		for (int i = 0; i < 11; i++) {
    			strict2.depositFromATM(4321, 500);
    		}
    	}catch(TransactionsOverQuotaException oq) {
    		assertNotNull(oq);
    	}catch(WrongAccountHolderException ho) {
    		fail();
    	}
    	
    	try {
    		strict1.withdraw(1234, 20000);
    	}
    	catch(NotEnoughFoundsException ne) {
    		assertNotNull(ne);
    	}
    	catch(WrongAccountHolderException ho) {
    		fail();
    	}
    }
}
