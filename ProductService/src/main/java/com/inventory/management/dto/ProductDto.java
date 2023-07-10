package com.inventory.management.dto;

/**
 * Data Transfer Object (DTO) for representing a product.
 */
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    
    // Getters and Setters
    // These methods are used to retrieve and modify the values of the private fields.
    
    /**
     * Retrieves the ID of the product.
     *
     * @return The ID of the product.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the ID of the product.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the product.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the description of the product.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Retrieves the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Sets the price of the product.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Retrieves the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Sets the quantity of the product.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Parameterized Constructor
    // This constructor allows you to create a new instance of the Product class with specified values for all fields.
    
    /**
     * Constructs a new ProductDto object with specified values for all fields.
     *
     * @param id          The ID of the product.
     * @param name        The name of the product.
     * @param description The description of the product.
     * @param price       The price of the product.
     * @param quantity    The quantity of the product.
     */
    public ProductDto(Long id, String name, String description, double price, int quantity) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Default Constructor
    // This constructor is used when you create a new instance of the ProductDto class without providing any initial values.
    
    /**
     * Constructs a new empty ProductDto object.
     */
    public ProductDto() {
        super();
    }   
}
