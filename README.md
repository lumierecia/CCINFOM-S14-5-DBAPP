# Restaurant Management System - CCINFOM G5 MP

A Java-based restaurant management system that handles inventory, orders, employees, and customer management.

## Project Structure

```
src/
├── controller/
│   └── RestaurantController.java    # Main controller handling business logic
├── dao/
│   ├── CustomerDAO.java            # Data access for customers
│   ├── EmployeeDAO.java            # Data access for employees
│   ├── IngredientDAO.java          # Data access for ingredients
│   ├── InventoryDAO.java           # Data access for inventory items
│   ├── OrderDAO.java               # Data access for orders
│   └── SupplierDAO.java            # Data access for suppliers
├── model/
│   ├── Customer.java               # Customer entity
│   ├── Employee.java               # Employee entity
│   ├── Ingredient.java             # Ingredient entity
│   ├── Inventory.java              # Inventory item entity
│   ├── Order.java                  # Order entity
│   ├── OrderItem.java              # Order item entity
│   └── Supplier.java               # Supplier entity
├── util/
│   └── DatabaseConnection.java     # Database connection utility
└── view/
    ├── MainFrame.java              # Main application window
    ├── CustomerPanel.java          # Customer management interface
    ├── EmployeePanel.java          # Employee management interface
    ├── InventoryPanel.java         # Inventory management interface
    ├── OrderPanel.java             # Order management interface
    ├── RecordsPanel.java           # Records and reporting interface
    └── SupplierPanel.java          # Supplier management interface
```

## Features

### Inventory Management
- View all inventory items
- Filter items by category (Main Course, Desserts, Beverages, Sides)
- Add new inventory items
- Update existing items
- Delete items
- Track item status (Available/Unavailable)
- Monitor low stock items

### Order Management
- Create new orders
- Track order status (In Progress, Ready, Served, Completed, Cancelled)
- Process payments
- Assign employees to orders
- View order history

### Customer Management
- Add new customers
- Update customer information
- View customer history
- Track customer orders

### Employee Management
- Add new employees
- Assign roles and shifts
- Track employee schedules
- Monitor employee performance

### Supplier Management
- Add new suppliers
- Track supplier information
- Manage supplier relationships
- Monitor ingredient supplies

### Reporting
- Sales reports
- Customer order reports
- Employee shift reports
- Profit margin analysis

## Database Schema

The system uses MySQL with the following main tables:
- `InventoryItems`: Stores product information
- `Orders`: Tracks customer orders
- `Customers`: Stores customer information
- `Employees`: Manages employee data
- `Suppliers`: Tracks supplier information
- `Categories`: Product categories
- `Ingredients`: Raw materials
- `OrderItems`: Order line items

## Getting Started

1. Ensure you have Java 17 or later installed
2. Set up MySQL database
3. Run the `Group8_DB.sql` script to create the database schema
4. Update database connection details in `DatabaseConnection.java`
5. Compile and run the application:
   ```bash
   javac src/view/MainFrame.java
   java src.view.MainFrame
   ```

## Error Handling

The system includes comprehensive error handling for:
- Database constraints
- Invalid input validation
- Business logic violations
- Connection issues
