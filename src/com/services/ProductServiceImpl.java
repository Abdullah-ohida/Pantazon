package com.services;

import com.exceptions.ProductException;
import com.model.Product;

public class ProductServiceImpl implements ProductService{
    private ProductRepoMock productRepo = new ProductRepoMock();
    /**
     * Search for product with specified id
     *
     * @param productId
     * @return Product with valid product id
     */
    @Override
    public Product findProductById(String productId) throws ProductException {
        return productRepo.getProductById(productId);
    }
}
