# BookStore Challenge

Welcome to the **BookStore Challenge**!



## Overview

This project demonstrates a simple object-oriented Book Store task in Java. It includes functionality to manage books, handle purchases, remove outdated books, and simulate a bookstore inventory with different book types.

## Core Features

- **Book Management**: Add, edit, and remove books from the store.
- **Support for Different Book Types**:
  - `PaperBook`: Physical books with stock management.
  - `EBook`: Digital books with email delivery.
  - `ShowcaseBook`: Display-only books, not for sale.
- **Purchase System**: Buy available books with validation for stock, address, and email.
- **Inventory Maintenance**: Remove outdated books by publication year.
- **Random Data Generation**: Add random books and simulate purchases for testing.

  ## This is the output of generating random adding, buying, and deleting outdated books


   ![BookStore Output](https://github.com/abdala-elgendy/BookStore_Challenge/blob/master/img.png)

## Key Classes & Design

### Book (Abstract)
Represents a general book with common properties and methods. Declares an abstract `buy` method that is implemented differently by each book type.

**Fields**:
- ISBN, title, price, author, year

**Methods**:
- Getters/setters for each field
- `abstract double buy(int quantity, String address, String email)`

---

### PaperBook
Extends `Book` for physical books. Tracks stock and allows purchases if quantity is available.

- **Stock control** and purchase logic
- Validates quantity, address, and email

---

### EBook
Extends `Book` for digital books. Handles email delivery and file type.

- No stock restrictions
- Sends book via email (simulated)

---

### ShowcaseBook
Extends `Book` for display-only books. Purchase attempts return 0 and print a message.

---

### BookStore
Manages inventory, book addition, purchase, and removal of outdated books.

- Uses a `Map<String, Book>` for fast lookup by ISBN
- Methods for adding and buying books, and for removing outdated titles

---

### RandomBookGenerator
Utility to populate the bookstore with random books and simulate buying/removal.

---
