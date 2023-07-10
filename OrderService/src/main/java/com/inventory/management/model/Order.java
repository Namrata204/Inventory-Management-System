package com.inventory.management.model;

import java.util.HashMap;
import java.util.Map;

import com.inventory.management.converter.MapToJsonConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a order entity.
 */
@Entity
@Table(name="orders")
public class Order{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // The ID of the order
	@Convert(converter = MapToJsonConverter.class)
    private Map<String, Integer> productQuantities; // Mapping of product names to quantities
    private String status; // The status of the order

    /**
     * Default constructor.
     * Initializes the productQuantities map.
     */
    public Order() {
        this.productQuantities = new HashMap<>();
    }

    /**
     * Parameterized constructor.
     *
     * @param id                The ID of the order.
     * @param productQuantities Mapping of product names to quantities.
     * @param status            The status of the order.
     */
    public Order(Long id, Map<String, Integer> productQuantities, String status) {
        this.id = id;
        this.productQuantities = productQuantities;
        this.status = status;
    }

    /**
     * Retrieves the ID of the order.
     *
     * @return The ID of the order.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id The ID of the order.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the mapping of product names to quantities.
     *
     * @return The mapping of product names to quantities.
     */
    public Map<String, Integer> getProductQuantities() {
        return productQuantities;
    }

    /**
     * Sets the mapping of product names to quantities.
     *
     * @param productQuantities The mapping of product names to quantities.
     */
    public void setProductQuantities(Map<String, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    /**
     * Retrieves the status of the order.
     *
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status The status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

