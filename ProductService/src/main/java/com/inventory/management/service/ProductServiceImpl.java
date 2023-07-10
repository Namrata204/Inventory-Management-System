package com.inventory.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.dto.ProductDto;
import com.inventory.management.exception.DuplicateProductException;
import com.inventory.management.exception.ProductNotFoundException;
import com.inventory.management.model.Product;
import com.inventory.management.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the ProductService interface.
 * Provides methods for managing products.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Creates a new product.
     *
     * @param productDto The ProductDto object representing the product to create.
     * @return The created product as a ProductDto.
     */
    @Override
    public ProductDto createProduct(ProductDto productDto) {
    	 // Check if the product with the same name already exists
        Optional<Product> existingProduct = productRepository.findByName(productDto.getName());
        if (existingProduct.isPresent()) {
            throw new DuplicateProductException("Product already exists with the same name.");
        }

        Product product = convertToProduct(productDto);
        Product createdProduct = productRepository.save(product);
        return convertToProductDto(createdProduct);
    }

    /**
     * Updates an existing product.
     *
     * @param productId  The ID of the product to update.
     * @param productDto The ProductDto object representing the updated product data.
     * @return The updated product as a ProductDto if successful,
     *         or null if the product does not exist.
     */
    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            // Update existingProduct with data from productDto
            existingProduct.setName(productDto.getName());
            existingProduct.setDescription(productDto.getDescription());
            existingProduct.setPrice(productDto.getPrice());
            existingProduct.setQuantity(productDto.getQuantity());
            Product updatedProduct = productRepository.save(existingProduct);
            return convertToProductDto(updatedProduct);
        }
        throw new ProductNotFoundException("Product not found with ID: " + productId);
    }
    
    /**
     * Update the stock quantity of a product.
     *
     * @param productName The name of the product to update.
     * @param quantity    The updated stock quantity.
     */
    @Override
    public void updateStockQuantity(String productName, int quantity) {
        Optional<Product> optionalProduct = productRepository.findByName(productName);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int remainingQuantity=product.getQuantity()-quantity;
            product.setQuantity(remainingQuantity);
            productRepository.save(product);
        } else {
            throw new ProductNotFoundException("Product not found with name: " + productName);
        }
    }

    /**
     * Deletes a product.
     *
     * @param productId The ID of the product to delete.
     */
    @Override
    public void deleteProduct(Long productId) {
    	Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(productId);
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + productId);
        }
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return The product as a ProductDto if found,
     *         or null if the product does not exist.
     */
    @Override
    public ProductDto getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return convertToProductDto(product);
        }
        throw new ProductNotFoundException("Product not found with ID: " + productId);
    }
    
    /**
     * Retrieves a product by its name.
     *
     * @param productName The name of the product to retrieve.
     * @return The product as a ProductDto if found,
     *         or null if the product does not exist.
     */
    @Override
    public ProductDto getProductByName(String productName) {
        Optional<Product> optionalProduct = productRepository.findByName(productName);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return convertToProductDto(product);
        }
        throw new ProductNotFoundException("Product not found with name: " + productName);
    }


    /**
     * Retrieves all products.
     *
     * @return A list of all products as ProductDtos.
     */
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToProductDto)
                .collect(Collectors.toList());
    }

    /**
     * Converts a ProductDto to a Product entity.
     *
     * @param productDto The ProductDto to convert.
     * @return The corresponding Product entity.
     */
    private Product convertToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        return product;
    }

    /**
     * Converts a Product entity to a ProductDto.
     *
     * @param product The Product entity to convert.
     * @return The corresponding ProductDto.
     */
    private ProductDto convertToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        return productDto;
    }
}