package task5;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Before;

public class AccountTest {
    private Catalog catalog;
    private Account account;

    @Before
    public void setUp() throws Exception {
        catalog = new Catalog();
        catalog.addProduct("apple", 1.5);
        catalog.addProduct("banana", 2.5);
        catalog.addProduct("orange", 3);
        account = new Account(catalog);
    }

    @Test
    public void testCalculateTotal() throws Exception {
        account.addProduct("apple", 2);
        account.addProduct("banana", 3);
        account.addProduct("orange", 1);
        double expected = 2 * 1.5 + 3 * 2.5 + 1 * 3;
        Assert.assertEquals(expected, account.calculateTotal(), 0.0001);
    }

    @Test
    public void testEmptyAccount() throws Exception {
        Assert.assertEquals(0, account.calculateTotal(), 0.0001);
    }

    @Test
    public void testAddRemoveItem() throws Exception {
        account.addProduct("apple", 2);
        account.removeProduct("apple");
        Assert.assertEquals(0, account.calculateTotal(), 0.0001);
    }

    @Test
    public void testAddingTwoProducts() throws Exception {
        account.addProduct("apple", 2);
        account.addProduct("banana", 3);
        Assert.assertEquals(2, account.countDifferentProducts());
    }

    @Test
    public void testDiscount() throws Exception {
        account.addProduct("apple", 2);
        account.addProduct("banana", 3);
        account.setDiscount(0.5);
        double expected = (2 * 1.5 + 3 * 2.5) * 0.5;
        Assert.assertEquals(expected, account.calculateTotal(), 0.0001);
    }

    @Test
    public void testUpdateQuantity() throws Exception {
        account.addProduct("apple", 2);
        account.updateQuantity("apple", 3);
        account.updateQuantity("apple", 5);
        Assert.assertEquals(5, account.getQuantity("apple"));
    }

    @Test
    public void testGetQuantityNotExist() throws Exception {
        Assert.assertEquals(0, account.getQuantity("pear"));
    }
}
