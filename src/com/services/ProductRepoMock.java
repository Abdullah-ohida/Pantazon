package com.services;

import com.exceptions.ProductException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductRepoMock {
    private Map<String, Product> mockProducts;

    public ProductRepoMock() {
        mockProducts = new HashMap<>();

        Product plantainChips = new Product("Aduni Chips", "Savoury plantainChips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        mockProducts.put(plantainChips.getProductId(), plantainChips);

        Product noseMask = new Product();
        noseMask.setProductId("AD002");
        noseMask.setName("Flank safety");
        noseMask.setDescription("Best in class nose mask");
        noseMask.setPrice(new BigDecimal(100));
        mockProducts.put(noseMask.getProductId(), noseMask);

        Product beaksJean = new Product("Beaks", "Swag Gucci jean", new BigDecimal(2000));
        beaksJean.setProductId("AD003");
        mockProducts.put(beaksJean.getProductId(), beaksJean);
    }

    public Map<String, Product> getMockProducts() {
        return mockProducts;
    }


    public Product getProductById(String id) throws ProductException {
        Product result = mockProducts.get(id);
        if(isEmpty(result)){
            throw new ProductException("Product with id was not found");
        }
        return result;
    }



    private boolean isEmpty(Product result) {
        return result == null;
    }
}
