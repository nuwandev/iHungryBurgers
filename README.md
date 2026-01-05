# 🍔 iHungry Burgers - Order Management System

A complete Java-based burger shop management system featuring a modern Swing GUI, custom data structures, and MVC architecture. This project showcases the evolution of software development skills from basic implementations to professional-grade applications.

![iHungry Burgers Banner](src/resources/burger-logo.jpg)

## 📹 Demo

<!-- Add your demo video here -->
[🎥 Demo Video Coming Soon]

## 📸 Screenshots

### Home Screen
<!-- ![Home Screen](screenshots/home-screen.png) -->
*Screenshot placeholder - Add home screen showing the main navigation*

### Place Order
<!-- ![Place Order](screenshots/place-order.png) -->
*Screenshot placeholder - Add order placement interface*

### Search Customer
<!-- ![Search Customer](screenshots/search-customer.png) -->
*Screenshot placeholder - Add customer search functionality*

### View Orders
<!-- ![View Orders](screenshots/view-orders.png) -->
*Screenshot placeholder - Add orders listing with different statuses*

### Update Order Status
<!-- ![Update Order](screenshots/update-order.png) -->
*Screenshot placeholder - Add order status update interface*

### Best Customer Analytics
<!-- ![Best Customer](screenshots/best-customer.png) -->
*Screenshot placeholder - Add best customer identification screen*

---

## 🎯 Features

### 📦 Order Management
- ✅ Place new burger orders with customer details
- ✅ Real-time order status tracking (Pending → Preparing → Delivered)
- ✅ View orders filtered by status
- ✅ Update order status dynamically
- ✅ Cancel orders when needed
- ✅ Search orders by Order ID

### 👥 Customer Management
- ✅ Automatic customer registration with unique IDs
- ✅ Search customers by ID or name
- ✅ View complete customer order history
- ✅ Identify best customers based on total purchases
- ✅ Track customer spending analytics

### 🎨 User Interface
- ✅ Modern, intuitive GUI built with Java Swing
- ✅ Card-based navigation between different sections
- ✅ Keyboard shortcuts for quick access (F1-F9)
- ✅ Consistent branding with burger logo
- ✅ Responsive form validation
- ✅ User-friendly error messages

---

## 🚀 Learning Journey: From v1 to v3

This project represents a significant learning journey, demonstrating progressive mastery of Java programming concepts, data structures, and software architecture patterns.

### 📝 Version 1: Foundation (Basic Implementation)

**What I Built:**
- Simple order management using **basic arrays** or **ArrayLists**
- Direct manipulation of data structures in UI components
- No separation between data, logic, and presentation
- Manual order tracking without persistence

**Key Concepts Learned:**
- ✅ Java fundamentals (classes, objects, methods)
- ✅ Basic collections framework (ArrayList)
- ✅ Simple GUI creation with Swing
- ✅ Event handling (ActionListener)
- ✅ Basic data validation

**Limitations:**
- ❌ Fixed array size or inefficient ArrayList resizing
- ❌ No data persistence (lost on app close)
- ❌ Tightly coupled code (hard to maintain)
- ❌ Limited scalability

---

### 🔗 Version 2: Data Structures (Custom LinkedList)

**What I Built:**
- Replaced arrays with a **custom LinkedList implementation** (`OrderList`)
- Implemented Node-based data structure from scratch
- Added iterator pattern for data traversal
- Improved search and filter operations

**Key Concepts Learned:**
- ✅ **Custom data structures** (LinkedList with Node class)
- ✅ **Memory management** (dynamic allocation)
- ✅ **Algorithm complexity** (understanding O(n) operations)
- ✅ **Functional interfaces** (OrderAction for forEach)
- ✅ **Sorting algorithms** (custom bubble sort by price)

**Code Highlights:**
```java
// Custom LinkedList with nested Node class
private class Node {
    Order order;
    Node next;
}

// Functional interface for iteration
@FunctionalInterface
public interface OrderAction {
    boolean accept(Order order);
}
```

**Improvements:**
- ✅ Dynamic data structure (no fixed size)
- ✅ Better memory utilization
- ✅ More efficient insertions
- ✅ Custom iteration logic

**Remaining Challenges:**
- ❌ Still no data persistence
- ❌ Business logic mixed with data structures
- ❌ UI still tightly coupled to data

---

### 🏗️ Version 3: Professional Architecture (Current - MVC Pattern)

**What I Built:**
- Complete **MVC (Model-View-Controller)** architecture
- **Persistent storage** using file I/O
- Separate **Controller** layer for business logic
- Modular component structure
- Professional code organization

**Key Concepts Learned:**
- ✅ **MVC Architecture Pattern**
  - **Model:** Order, OrderList (data structures)
  - **View:** MainFrame, Panels (UI components)
  - **Controller:** OrderController (business logic)
- ✅ **File I/O Operations** (BufferedReader/Writer)
- ✅ **Data Persistence** (CSV-based storage)
- ✅ **Separation of Concerns**
- ✅ **Utility Classes** (KeyBindUtils, Validators, IdGenerators)
- ✅ **Error Handling** (try-catch, logging)
- ✅ **Code Reusability** (custom Button components)

**Architecture Breakdown:**

```
📁 src/
├── 📂 model/              # Data Layer
│   ├── Order.java         # Order entity with business constants
│   └── OrderList.java     # Custom LinkedList implementation
├── 📂 view/               # Presentation Layer
│   ├── MainFrame.java     # Main application window
│   ├── 📂 panels/         # Individual screen panels
│   └── 📂 components/     # Reusable UI components
├── 📂 controller/         # Business Logic Layer
│   └── OrderController.java
├── 📂 storage/            # Data Persistence Layer
│   └── StorageManager.java
└── 📂 utils/              # Helper Classes
    ├── IdGenerators.java  # Unique ID generation
    ├── Validate.java      # Input validation
    ├── KeyBindUtils.java  # Keyboard shortcuts
    └── Utils.java         # Common utilities
```

**Professional Features:**
- ✅ **Data Persistence:** Orders saved to `orders.txt` file
- ✅ **Loose Coupling:** Easy to modify one layer without affecting others
- ✅ **Testability:** Business logic separated for unit testing
- ✅ **Scalability:** Easy to add new features
- ✅ **Maintainability:** Clear code organization
- ✅ **Reusability:** Shared utilities and components

**Technical Highlights:**
```java
// Controller handles all business logic
public class OrderController {
    private OrderList orderList;
    
    public OrderList getUniqueCustomers() { ... }
    public OrderList getOrdersByStatus(int status) { ... }
    public Order getOrderByOrderId(String orderId) { ... }
}

// Storage Manager handles persistence
public class StorageManager {
    public static OrderList loadOrderList() { ... }
    public static void saveOrder(Order order) { ... }
}
```

---

## 🎓 Final Reflections & Key Takeaways

### Evolution Summary
| Aspect | v1 (Basic) | v2 (Data Structures) | v3 (Architecture) |
|--------|------------|---------------------|-------------------|
| **Data Storage** | Arrays/ArrayList | Custom LinkedList | LinkedList + File I/O |
| **Architecture** | Monolithic | Slightly modular | Full MVC |
| **Persistence** | None | None | File-based |
| **Code Organization** | Single file/minimal | Multiple classes | Layered architecture |
| **Maintainability** | Low | Medium | High |
| **Scalability** | Limited | Better | Excellent |

### What I Learned Throughout This Journey

1. **Data Structures Matter:** Understanding when to use arrays vs. linked lists vs. other structures is crucial for performance and maintainability.

2. **Architecture is Everything:** The MVC pattern transformed my code from a tangled mess to a clean, organized system that's easy to extend.

3. **Separation of Concerns:** Keeping UI, business logic, and data separate makes code easier to test, debug, and modify.

4. **Persistence is Essential:** Real-world applications need to save data - file I/O was a critical addition.

5. **User Experience:** Clean UI, keyboard shortcuts, and proper validation make software actually usable.

6. **Code Reusability:** Creating utility classes and custom components saves time and reduces bugs.

7. **Professional Practices:** Proper naming, package structure, and documentation are as important as functionality.

---

## 🛠️ Technologies & Tools

- **Language:** Java (100%)
- **GUI Framework:** Java Swing
- **Data Structures:** Custom LinkedList implementation
- **Architecture Pattern:** MVC (Model-View-Controller)
- **Data Persistence:** File I/O (CSV format)
- **IDE:** Apache NetBeans
- **Build Tool:** Apache Ant
- **Version Control:** Git

---

## 📋 Prerequisites

- **Java Development Kit (JDK) 11 or higher**
- **Apache NetBeans IDE** (recommended) or any Java IDE
- Basic understanding of Java Swing applications

---

## 🚀 How to Run

### Option 1: Using NetBeans IDE

1. **Clone the repository:**
   ```bash
   git clone https://github.com/nuwandev/iHungryBurgers.git
   cd iHungryBurgers
   ```

2. **Open in NetBeans:**
   - File → Open Project
   - Select the `iHungryBurgers` folder
   - Click "Open Project"

3. **Run the application:**
   - Right-click on the project
   - Select "Run" or press F6
   - The main application window will appear

### Option 2: Using Command Line

1. **Clone the repository:**
   ```bash
   git clone https://github.com/nuwandev/iHungryBurgers.git
   cd iHungryBurgers
   ```

2. **Build the project:**
   ```bash
   ant compile
   ant jar
   ```

3. **Run the application:**
   ```bash
   java -jar dist/iHungryBurgersV3.jar
   ```

---

## 🎮 Keyboard Shortcuts

- **F1:** Home
- **F2:** Place Order
- **F3:** Search Order
- **F4:** Search Customer
- **F5:** Search Best Customer
- **F6:** View Orders
- **F7:** Update Order Status

---

## 📁 Project Structure

```
iHungryBurgers/
│
├── src/
│   ├── controller/           # Business logic
│   │   └── OrderController.java
│   │
│   ├── model/                # Data models
│   │   ├── Order.java
│   │   └── OrderList.java
│   │
│   ├── view/                 # UI components
│   │   ├── MainFrame.java
│   │   ├── panels/           # Screen panels
│   │   └── components/       # Reusable UI components
│   │
│   ├── storage/              # Data persistence
│   │   ├── StorageManager.java
│   │   └── orders.txt
│   │
│   ├── utils/                # Utility classes
│   │   ├── IdGenerators.java
│   │   ├── Validate.java
│   │   ├── KeyBindUtils.java
│   │   └── Utils.java
│   │
│   └── resources/            # Assets
│       └── burger-logo.jpg
│
├── nbproject/                # NetBeans configuration
├── build.xml                 # Ant build script
├── manifest.mf              # JAR manifest
└── README.md                # This file
```

---

## 🔮 Future Enhancements

- [ ] Database integration (MySQL/PostgreSQL)
- [ ] User authentication and roles
- [ ] Order history reports and analytics
- [ ] Payment processing integration
- [ ] Email notifications for order status
- [ ] Export orders to PDF/Excel
- [ ] Multi-language support
- [ ] Dark mode theme

---

## 📝 License

This project is created for educational purposes.

---

## 👤 Author

**Nuwan Wijesinghe**
- GitHub: [@nuwandev](https://github.com/nuwandev)

---

## 🙏 Acknowledgments

- Custom LinkedList implementation inspired by Java Collections Framework
- MVC architecture pattern best practices
- Java Swing documentation and community resources

---

## 📊 Repository Topics

For GitHub repository settings, add these topics:
`java` `swing` `mvc-architecture` `data-structures` `linked-list` `desktop-application` `order-management` `educational-project` `java-swing` `file-io` `custom-data-structures` `learning-journey` `burger-shop` `restaurant-management` `netbeans`

---

## 📄 Repository Description

**For GitHub repository description, use:**

> A Java Swing burger shop management system showcasing progressive learning from basic arrays to custom LinkedList and professional MVC architecture with file persistence. Educational project demonstrating software evolution from v1 to v3.

---

*Built with ❤️ and lots of learning*
