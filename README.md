# Inventory-Management-System
The Inventory Management System consists of two microservices: the Product Service and the Order Service. The Product Service handles product management tasks, such as creating and updating products, while the Order Service manages order-related operations like creating orders, updating status, and generating invoices.

Product Service:
The Product Service handles all the operations related to managing the products in the inventory. It provides functionalities such as creating new products, updating existing product information, retrieving product details, and deleting products. This service can also handle inventory tracking, including stock availability, quantity updates, and managing product variations like size, color, or other attributes. Additionally, it can integrate with external systems or suppliers to retrieve product data or update stock levels.

Order Service:
The Order Service is responsible for managing the order-related operations. It handles tasks like creating new orders, processing order requests, updating order status, and generating invoices. This service can also perform inventory checks to ensure product availability before accepting an order and update the stock levels accordingly. It may integrate with other systems such as payment gateways or shipping providers to handle payment processing and order fulfillment.

Tool Used :
Spring tool suite4
H2 Database
Postman


Endpoints for Product Service:

1. Create a new product:
   - Method: POST
   - Endpoint: http://localhost:8080/api/products
   - Request Body: ProductDto
2. Update an existing product:
   - Method: PUT
   - Endpoint: http://localhost:8080/api/products/{productId}
   - Request Body: ProductDto
3. Update the stock quantity of a product:
   - Method: PUT
   - Endpoint: http://localhost:8080/api/products/{productName}/update-stock?quantity={quantity}
4. Delete a product:
   - Method: DELETE
   - Endpoint: http://localhost:8080/api/products/{productId}
5. Retrieve a product by ID:
   - Method: GET
   - Endpoint: http://localhost:8080/api/products/{productId}
6. Retrieve a product by name:
   - Method: GET
   - Endpoint: http://localhost:8080/api/products/byname/{productName}
7. Retrieve all products:
   - Method: GET
   - Endpoint: http://localhost:8080/api/products


Endpoints for Order Service:

1. Create a new order:
   - Method: POST
   - Endpoint: http://localhost:8081/api/orders
   - Request Body: OrderDto
2. Get an order by ID:
   - Method: GET
   - Endpoint: http://localhost:8081/api/orders/{orderId}
3. Update the status of an order:
   - Method: PUT
   - Endpoint: http://localhost:8081/api/orders/{orderId}/status
   - Request Parameter: status
4. Generate an invoice for an order:
   - Method: GET
   - Endpoint: http://localhost:8081/api/orders/{orderId}/invoice
