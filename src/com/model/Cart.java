package com.model;

import com.exceptions.ProductException;
import com.services.Product;
import com.services.ProductRepoMock;
import com.services.ProductService;
import com.services.ProductServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Cart {
    private List<Product> products;
    private ProductService productService;
    private Logger logger = Logger.getLogger(Cart.class.getName());

    public Cart() {
        products = new ArrayList<>();
        productService = new ProductServiceImpl();
    }

    public void addToCart(Product product) throws ProductException {
        if(verifiedProduct(product))
            products.add(product);
    }

    private boolean verifiedProduct(Product product) throws ProductException {
        boolean verified = false;
        Product verifiedProduct = productService.findProduct(product.getProductId());
        if(verifiedProduct != null) {
            verified = true;
        }
        return verified;

    }


    public List<Product> getProducts() {
        return products;
    }

    public boolean removeFromCart(Product product){
        boolean removed = false;
        if(product != null){
            this.products.remove(product);
            removed = true;
        }
        return removed;
    }

}
