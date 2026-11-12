package com.example.mcpserver.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InventoryService {

    private final Map<String, Integer> inventory =
            Map.of(
                    "LAPTOP001", 15,
                    "MOUSE001", 50,
                    "KEYBOARD001", 25
            );

    public String checkStock(String productCode) {

        Integer quantity = inventory.get(productCode);

        if (quantity == null) {
            return "Product not found: " + productCode;
        }

        return "Product: " + productCode
                + ", Available quantity: " + quantity;
    }
}