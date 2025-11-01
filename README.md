# iHungry Burgers

iHungry Burgers is a Java-based burger shop management system with a graphical user interface built using Swing. The application helps manage burger orders, customer information, and order tracking efficiently.

## Features

- **Order Management**
  - Place new burger orders
  - Track order status (Pending, Preparing, Delivered, Cancelled)
  - View all orders in different states
  - Update order status
  - Cancel orders

- **Customer Management**
  - Customer registration and tracking
  - Search customers by ID or name
  - Best customer identification
  - Track customer order history

- **User Interface**
  - Clean and intuitive GUI using Java Swing
  - Easy navigation between different sections
  - Keyboard shortcuts for quick access
  - Consistent branding and design

## Technical Implementation

- **Data Structures**
  - Custom implementation of LinkedList for order management (`OrderList`)
  - Efficient data storage and retrieval system

- **Design Patterns & Architecture**
  - MVC (Model-View-Controller) architecture
  - Controller-based business logic handling
  - Separation of concerns between UI, business logic, and data storage

- **File System Integration**
  - Persistent data storage using file system
  - Data loading and saving capabilities

## Project Evolution & Learnings

This project is the result of progressive improvements. Here's how it evolved and what I learned at each stage:

### v1: Basic Version
- **Order Storage**: Used simple arrays or ArrayLists for storing orders and customer data.
- **Learning Outcome**: Learned the basics of Java collections, looping, and object management.

### v2: Intermediate Version
- **Linked List Implementation**: Replaced array-based storage with a custom LinkedList (`OrderList`).
- **Learning Outcome**: Understood data structure efficiency, memory management, and custom data structures.

### v3: Advanced Version (Current)
- **MVC Architecture**: Refactored the code to use MVC pattern for better separation of concerns.
- **Controller Logic**: Moved business logic to controllers for modularity.
- **Persistent Storage**: Implemented file-based persistent storage using file I/O.
- **Learning Outcome**: Grasped software architecture, modular programming, decoupling, and real-world application design.

## Final Reflections

- Progressed from basic array-based approaches to custom linked lists, and finally to a fully modular MVC application.
- Learned to build maintainable, scalable, and user-friendly desktop applications in Java.
- Enhanced understanding of user experience, code organization, and best practices.

## Technical Details

- Language: Java (100%)
- GUI Framework: Java Swing
- Data Storage: File-based system
- Architecture: MVC Pattern

## Author

@nuwandev
