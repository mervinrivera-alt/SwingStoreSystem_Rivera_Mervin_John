# SwingStoreSystem_Rivera_Mervin_John
# Inventory and Transaction Management System

## System Overview

This project is a Java Swing-based Inventory and Transaction Management System that allows users to:

* View available products and stock levels.
* Create purchase transactions.
* Automatically update inventory quantities after a transaction.
* Store transaction history in logs.
* Navigate between Transaction, Inventory, and Logs windows.

The system consists of three main frames:

1. Transaction Frame
2. Inventory Frame
3. Logs Frame

These frames communicate with each other through shared objects initialized in `MainClass.java`.

---

## Frame Responsibilities

### 1. Transaction Frame (`Transaction.java`)

The Transaction frame serves as the main user interface where users perform purchases.

Responsibilities:

* Displays available products.
* Allows users to select quantities using spinners.
* Calculates subtotal, VAT (12%), and total amount.
* Stores purchased items into arrays.
* Sends transaction data to the Logs frame.
* Updates inventory quantities after a successful transaction.
* Removes selected items from the cart.

Main features:

* Product selection
* Cart management
* Billing computation
* Transaction completion

---

### 2. Inventory Frame (`Inventory.java`)

The Inventory frame manages product information and stock levels.

Responsibilities:

* Stores all product data.
* Displays current inventory in a table.
* Tracks available quantities.
* Updates stock after transactions are completed.

Main features:

* Product monitoring
* Quantity tracking
* Inventory updates

---

### 3. Logs Frame (`Logs.java`)

The Logs frame records completed transactions.

Responsibilities:

* Receives transaction data from the Transaction frame.
* Displays transaction history in a table.
* Groups products belonging to the same transaction.

Main features:

* Transaction history
* Sales records
* Purchase tracking

---

### 4. Main Class (`MainClass.java`)

The MainClass acts as the system controller.

Responsibilities:

* Creates instances of all frames.
* Manages navigation between windows.
* Allows frames to communicate using shared references.

Example:

```java
public static Transaction frame1 = new Transaction();
public static Logs frame2 = new Logs();
public static Inventory frame3 = new Inventory();
```

---

## How Arrays Are Used

Arrays are the primary data structure used to store and transfer information throughout the system.

### Product Arrays

Located in `Inventory.java`

```java
private final String[] product = {"Milk", "Coffee", "Rice", "Sugar"};
private final double[] price = {40.5, 20, 50.5, 60};
private final int[] stock = {20, 20, 20, 20};
```

Purpose:

* `product[]` stores product names.
* `price[]` stores product prices.
* `stock[]` stores available inventory quantities.

Each index represents the same product.

Example:

| Index | Product | Price | Stock |
| ----- | ------- | ----- | ----- |
| 0     | Milk    | 40.5  | 20    |
| 1     | Coffee  | 20    | 20    |
| 2     | Rice    | 50.5  | 20    |
| 3     | Sugar   | 60    | 20    |

---

### Transaction Arrays

Located in `Transaction.java`

```java
String[] products;
int[] Qtys;
double[] totals;
```

Purpose:

* Store completed transaction information.
* Transfer transaction records to the Logs frame.
* Transfer sold quantities to the Inventory frame.

Example:

```java
products[0] = "Milk";
Qtys[0] = 2;
totals[0] = 81.0;
```

---

### Logs Arrays

Located in `Logs.java`

```java
private String[] product;
private int[] Qty;
private double[] total;
```

Purpose:

* Receive transaction information from the Transaction frame.
* Store transaction records temporarily.
* Display transaction history inside the logs table.

---

### Inventory Update Using Arrays

When a transaction is completed:

1. Transaction frame creates arrays containing:

   * Product names
   * Quantities sold
   * Total amounts

2. Arrays are passed to Logs.

```java
MainClass.frame2.setproduct(products);
MainClass.frame2.setQty(Qtys);
MainClass.frame2.settotal(totals);
```

3. Arrays are passed to Inventory.

```java
MainClass.frame3.updateStock(products, Qtys);
```

4. Inventory searches for matching products and deducts sold quantities.

Example:

Before transaction:

```text
Milk = 20
```

Customer buys:

```text
Milk = 3
```

After update:

```text
Milk = 17
```

---

## Data Flow

```text
Transaction Frame
       │
       ▼
Creates Arrays
(products, quantities, totals)
       │
       ├────────► Logs Frame
       │            │
       │            ▼
       │      Displays History
       │
       ▼
Inventory Frame
       │
       ▼
Updates Stock Quantities
```

---

## Conclusion

The system demonstrates the use of Java Swing for GUI development and arrays for data storage and communication. Arrays are used to manage products, prices, stock quantities, and transaction records, allowing the Transaction, Inventory, and Logs frames to exchange information efficiently.
