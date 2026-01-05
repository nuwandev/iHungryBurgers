# iHungry Burgers

A Java Swing-based burger shop management system demonstrating progressive software development from basic implementations to professional MVC architecture.

![iHungry Burgers](src/resources/burger-logo.jpg)

## About

This project showcases my learning journey in Java development, evolving through three major versions - from simple array-based storage to custom data structures and finally to a complete MVC architecture with file persistence.

## Features

**Order Management**
- Place and track burger orders
- Update order status (Pending → Preparing → Delivered)
- Cancel orders
- Search orders by ID

**Customer Management**
- Automatic customer registration
- Search customers by ID or name
- View customer order history
- Identify best customers by total purchases

**User Interface**
- Java Swing GUI with card-based navigation
- Keyboard shortcuts (F1-F7)
- Form validation and error handling

## Learning Journey

This project evolved through three versions, each focusing on different aspects of software development:

### Version 1: Foundation
- Used arrays/ArrayLists for data storage
- Basic Java fundamentals and Swing GUI
- No data persistence
- Tight coupling between components

**Key Learning:** Java basics, collections, event handling

### Version 2: Data Structures
- Implemented custom LinkedList with Node structure
- Added functional interfaces for iteration
- Improved search and filter operations
- Custom sorting algorithms

**Key Learning:** Data structures, memory management, algorithm complexity

### Version 3: Professional Architecture (Current)
- Full MVC (Model-View-Controller) pattern
- File-based persistent storage
- Separated business logic into controllers
- Utility classes for common operations
- Professional code organization

**Key Learning:** Software architecture, separation of concerns, file I/O, maintainability

## Technical Stack

- **Language:** Java
- **GUI Framework:** Java Swing
- **Data Structures:** Custom LinkedList implementation
- **Architecture:** MVC (Model-View-Controller)
- **Data Persistence:** File I/O (CSV format)
- **IDE:** Apache NetBeans
- **Build Tool:** Apache Ant

## Project Structure

```
src/
├── controller/           # Business logic
│   └── OrderController.java
├── model/                # Data models
│   ├── Order.java
│   └── OrderList.java
├── view/                 # UI components
│   ├── MainFrame.java
│   └── panels/
├── storage/              # Data persistence
│   └── StorageManager.java
└── utils/                # Utility classes
```

## Getting Started

### Prerequisites
- Java JDK 11 or higher
- Apache NetBeans IDE (recommended)

### Installation & Running

**Using NetBeans:**
1. Clone the repository
   ```bash
   git clone https://github.com/nuwandev/iHungryBurgers.git
   ```
2. Open project in NetBeans (File → Open Project)
3. Run the project (F6)

**Using Command Line:**
```bash
git clone https://github.com/nuwandev/iHungryBurgers.git
cd iHungryBurgers
ant compile
ant jar
java -jar dist/iHungryBurgersV3.jar
```

### Keyboard Shortcuts
- F1: Home
- F2: Place Order
- F3: Search Order
- F4: Search Customer
- F5: Best Customer
- F6: View Orders
- F7: Update Order

## License

This project is created for educational purposes.

## Author

[@nuwandev](https://github.com/nuwandev)
