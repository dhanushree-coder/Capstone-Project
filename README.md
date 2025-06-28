# Capstone-Project
# 🧾 Employee Payroll Management System (Java + MySQL)

This is a **console-based Java application** that allows you to manage employee records and calculate payroll using a MySQL database. It is designed using simple Java concepts like OOP, collections, JDBC, and exception handling — ideal for beginners and educational purposes.

---

## 📌 Features

- Add new employees (Tamil names supported)
- View all employee details
- Calculate gross salary, tax, and deductions
- Delete employee records safely (with related payroll auto-deleted)
- Store and retrieve data from MySQL database using JDBC
- Clean menu-driven CLI interface

---

## 🛠️ Technologies Used

| Component              | Technology          |
|------------------------|---------------------|
| Language               | Java (JDK 17+)      |
| Database               | MySQL               |
| JDBC                   | MySQL Connector/J   |
| IDE                    | Eclipse / IntelliJ  |
| Version Control        | Git + GitHub        |
| Optional Tools         | MySQL Workbench     |

---

## 📁 Project Folder Structure

Employee-Payroll-System/
│
├── dao/
│ └── EmployeeDAO.java
│ └── PayrollDAO.java
│
├── model/
│ └── Employee.java
│ └── Payroll.java
│
├── service/
│ └── PayrollService.java
│
├── util/
│ └── DBConnection.java
│ └── SalaryCalculator.java
│
├── exception/
│ └── InvalidEmployeeException.java
│
├── Main.java
└── README.md


---

## 🔧 How to Run

### 1. Set Up MySQL Database

Use MySQL Workbench or Terminal and run:


CREATE DATABASE payrolldb;
USE payrolldb;

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    designation VARCHAR(50),
    type VARCHAR(20),
    basicsalary DOUBLE
);

CREATE TABLE payroll (
    id INT AUTO_INCREMENT PRIMARY KEY,
    empid INT,
    date DATE,
    grosssalary DOUBLE,
    tax DOUBLE,
    deductions DOUBLE,
    netpay DOUBLE,
    FOREIGN KEY (empid) REFERENCES employee(id) ON DELETE CASCADE
);
 2.Insert Sample Data 
 INSERT INTO employee (name, email, designation, type, basicsalary) VALUES
('Madhan', 'madhan@gmail.com', 'Developer', 'FullTime', 30000);

3.Set Up Java Project
Import the folder into Eclipse or IntelliJ

Add MySQL JDBC Connector to your project’s classpath

Replace your_password in DBConnection.java with your actual MySQL password

🚀 Running the Project
Run Main.java and use the command-line menu:
1. Add Employee
2. View Employees
3. Delete Employee
4. Exit
💬 Contributions
This project is built for learning and experimentation. Feel free to fork and enhance it with features like:

📄 License
This project is open-source and free to use for educational purposes.
