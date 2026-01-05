# iHungry Burgers

A Java Swing desktop application for managing burger shop orders, featuring a custom LinkedList implementation and MVC architecture.

![iHungry Burgers](src/resources/burger-logo.jpg)

## About

This educational project demonstrates the evolution of a Java application through three development phases, showcasing progression from basic data structures to professional software architecture patterns.

## Features

**Order Management**
- Place new orders with automatic order ID generation
- Track orders through multiple states: Pending, Preparing, Delivered, Cancelled
- Search orders by order ID
- Update order status
- View orders filtered by status
- Burger price: Rs. 500.00 per unit

**Customer Management**
- Automatic customer ID generation for new customers
- Customer name-based identification and reuse
- Search customers by ID or name
- View customer order history with total spending
- Identify best customers by total purchase amount

**User Interface**
- Home screen with main navigation menu
- 11 dedicated panels for different operations
- Keyboard shortcuts using number keys (1-6)
- ESC key to go back or exit
- Real-time form validation
- Automatic price calculation

## Technical Implementation

### Architecture
- **MVC Pattern**: Clear separation between Model, View, and Controller
- **Custom Data Structure**: LinkedList implementation with Node-based storage
- **File Persistence**: CSV-format text file storage for orders
- **Functional Interfaces**: Custom OrderAction interface for iteration

### Project Structure
```
src/
├── controller/
│   └── OrderController.java       # Business logic and data operations
├── model/
│   ├── Order.java                 # Order entity with status constants
│   └── OrderList.java             # Custom LinkedList implementation
├── view/
│   ├── MainFrame.java             # Main application window
│   ├── panels/                    # 11 screen panels
│   │   ├── HomePanel.java
│   │   ├── PlaceOrderPanel.java
│   │   ├── SearchOrderPanel.java
│   │   ├── SearchCustomerPanel.java
│   │   ├── SearchBestCustomerPanel.java
│   │   ├── ViewOrdersPanel.java
│   │   ├── UpdateOrderPanel.java
│   │   ├── PendingOrdersPanel.java
│   │   ├── PreparingOrdersPanel.java
│   │   ├── DeliveredOrdersPanel.java
│   │   └── CancelledOrdersPanel.java
│   └── componenets/
│       └── Button.java            # Custom button component
├── storage/
│   ├── StorageManager.java        # File I/O operations
│   └── orders.txt                 # Persistent data storage
└── utils/
    ├── IdGenerators.java          # Order and customer ID generation
    ├── Validate.java              # Input validation utilities
    ├── KeyBindUtils.java          # Keyboard shortcut utilities
    └── Utils.java                 # Common helper functions
```

## Development Evolution

### Version 1: Basic Implementation
**Approach:**
- Arrays or ArrayLists for storing orders
- Direct data manipulation in UI components
- No persistence between sessions

**Learned:**
- Java basics: classes, objects, methods
- ArrayList and basic collections
- Swing GUI components and event handling

### Version 2: Data Structures
**Approach:**
- Custom LinkedList with Node class
- Iterator pattern with functional interface
- Improved search and sorting algorithms

**Learned:**
- Custom data structure implementation
- Memory management with linked nodes
- Functional interfaces and lambda expressions
- Algorithm complexity (O(n) operations)

### Version 3: Professional Architecture (Current)
**Approach:**
- Full MVC architecture with separated concerns
- File-based persistent storage
- Utility classes for reusable operations
- Controller layer for business logic

**Learned:**
- Software architecture patterns
- Separation of concerns
- File I/O with BufferedReader/Writer
- Code organization and maintainability

## Technology Stack

- **Language**: Java
- **GUI**: Java Swing
- **Architecture**: MVC (Model-View-Controller)
- **Data Structure**: Custom LinkedList
- **Storage**: File I/O (CSV format)
- **IDE**: Apache NetBeans
- **Build**: Apache Ant

## Getting Started

### Prerequisites
- Java JDK 11 or higher
- Apache NetBeans (recommended) or any Java IDE

### Installation

1. Clone the repository
```bash
git clone https://github.com/nuwandev/iHungryBurgers.git
cd iHungryBurgers
```

2. **Option A: Using NetBeans**
   - Open NetBeans
   - File → Open Project
   - Select the `iHungryBurgers` folder
   - Press F6 to run

3. **Option B: Using Command Line**
```bash
ant compile
ant jar
java -jar dist/iHungryBurgersV3.jar
```

## Keyboard Shortcuts

**From Home Screen:**
- `1` - Place Order
- `2` - Search Best Customer
- `3` - Search Order
- `4` - Search Customer
- `5` - View Orders
- `6` - Update Order
- `ESC` - Exit Application

**From View Orders Screen:**
- `1` - Pending Orders
- `2` - Preparing Orders
- `3` - Delivered Orders
- `4` - Cancelled Orders
- `ESC` - Back to Home

**All Other Screens:**
- `ESC` - Back to Home
- `Enter` - Submit form (when in text fields)

## Data Storage

Orders are stored in `src/storage/orders.txt` in CSV format:
```
OrderID,CustomerID,CustomerName,Quantity,TotalPrice,Status
O001,C001,NuwanDev,11,5500.0,Cancelled
O002,C001,NuwanDev,7,3500.0,Pending...
```

## Order Status Flow

```
Pending... → Preparing → Delivered
     ↓
  Cancelled
```

## License

This project is created for educational purposes.

## Author

[@nuwandev](https://github.com/nuwandev)

---

*Built as a learning project to demonstrate Java development progression*
