package com.model;

import com.exceptions.ProductException;
import com.services.CartItem;
import com.services.ProductService;
import com.services.ProductServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    ProductService productService;
    Cart cart;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl();
        cart = new Cart();
    }

    @AfterEach
    void tearDown() {
        productService = null;
        cart = null;
    }

    @Test
    void cart_canAddToCart() {
        assertTrue(cart.getItems().isEmpty());

        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 1);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void cart_canAddMoreThanOneProductToCart() {
        assertTrue(cart.getItems().isEmpty());

        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 1);

        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt, 1);

        assertFalse(cart.getItems().isEmpty());
        assertEquals(2, cart.getItems().size());
    }

    @Test
    void cart_canRemoveProductFromCart() {
        assertTrue(cart.getItems().isEmpty());

        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 1);

        boolean result = cart.removeFromCart(plantainChips);
        assertTrue(result);
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void cart_canRemoveMoreThanOneProductFromCart() {
        assertTrue(cart.getItems().isEmpty());

        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 1);

        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt, 1);

        boolean result = cart.removeFromCart(plantainChips);

        assertTrue(result);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(1, cart.getItems().size());

        boolean result1 = cart.removeFromCart(shirt);

        assertTrue(result1);
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void cart_canCalculateTotalPriceOfProductInCart(){
        assertTrue(cart.getItems().isEmpty());

        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips);

        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt);

        assertFalse(cart.getItems().isEmpty());
        assertEquals(2, cart.getItems().size());

        BigDecimal cartTotal = cart.calculateCartTotal();
        assertEquals(5050, cartTotal.intValue());
    }

    @Test
    void canCalculateQuantityOfProductInCart(){
        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 4);

        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt, 4);

        assertFalse(cart.getItems().isEmpty());
        assertEquals(2, cart.getItems().size());

        BigDecimal cartTotal = cart.calculateCartTotal();
        assertEquals(20200, cartTotal.intValue());

        CartItem chipsItem = cart.getItems().get(plantainChips.getProductId());
        assertEquals(4, chipsItem.getQuantity());

        CartItem shirtItem = cart.getItems().get(shirt.getProductId());
        assertEquals(4, shirtItem.getQuantity());
    }


}