package com.example.mcpserver.tool;

import com.example.mcpserver.service.InventoryService;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;

import org.springframework.stereotype.Component;

@Component
public class InventoryTools {

    private final InventoryService inventoryService;

    public InventoryTools(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @McpTool(
            name = "check_inventory",
            description = """
            Check available stock quantity for a product.
            Provide the product code to retrieve stock details.
            """
    )
    public String checkInventory(
            @McpToolParam(
                    description = "Product code, for example LAPTOP001",
                    required = true
            )
            String productCode
    ) {

        return inventoryService.checkStock(productCode);
    }
}