package com.inventory.management.service;

import java.util.List;

import com.inventory.management.dto.ProductDto;


/**
 * Service interface for managing products.
 */
public interface ProductService {
    
    /**
     * Creates a new product.
     *
     * @param productDto The ProductDto object representing the product to create.
     * @return The created product as a ProductDto.
     */
    ProductDto createProduct(ProductDto productDto);
    
    /**
     * Updates an existing product.
     *
     * @param productId  The ID of the product to update.
     * @param productDto The ProductDto object representing the updated product data.
     * @return The updated product as a ProductDto if successful,
     *         or null if the product does not exist.
     */
    ProductDto updateProduct(Long productId, ProductDto productDto);
    
    /**
     * Deletes a product.
     *
     * @param productId The ID of the product to delete.
     */
    void deleteProduct(Long productId);
    
    /**
     * Retrieves a product by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return The product as a ProductDto if found,
     *         or null if the product does not exist.
     */
    ProductDto getProductById(Long productId);
    
    /**
     * Retrieves all products.
     *
     * @return A list of all products as ProductDtos.
     */
    List<ProductDto> getAllProducts();

	/**
	 * Retrieves a product by its name.
	 *
	 * @param productName The name of the product to retrieve.
	 * @return The product as a ProductDto if found,
	 *         or null if the product does not exist.
	 */
	ProductDto getProductByName(String productName);

	/**
	 * Update the stock quantity of a product.
	 *
	 * @param productName The name of the product to update.
	 * @param quantity    The updated stock quantity.
	 */
	void updateStockQuantity(String productName, int quantity);
}