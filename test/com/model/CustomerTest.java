package com.model;

import com.exceptions.ProductException;
import com.services.Product;
import com.services.ProductService;
import com.services.ProductServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void findProduct(){
        Product product = null;
        try {
            product = productService.findProduct("AD001");
        } catch (ProductException e) {
            e.printStackTrace();
        }
        assertNotNull(product);
    }

    @Test
    void findProductWithInvalidI(){
        assertThrows(ProductException.class, ()-> productService.findProduct("ADSWW"));
    }

    @Test
    void addToCart() throws ProductException {
        assertTrue(cart.getProducts().isEmpty());
        Product testProduct = new Product();
        cart.addToCart(testProduct);
        assertFalse(cart.getProducts().isEmpty());
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void removeFromCart() throws ProductException {
        assertTrue(cart.getProducts().isEmpty());
        Product testProduct = new Product();
        cart.addToCart(testProduct);
        assertFalse(cart.getProducts().isEmpty());
        assertEquals(1, cart.getProducts().size());

        boolean result = cart.removeFromCart(testProduct);
        assertTrue(result);
        assertTrue(cart.getProducts().isEmpty());
    }
}