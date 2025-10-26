Java Swing ATM Machine Project

A clean, modern **ATM Simulation System** built entirely in **Java Swing**, following **OOP principles**.  
This project provides a graphical user interface to perform basic banking operations such as login, withdrawal, deposit, balance check, and transaction history — all in-memory (no database required).

---

## 🚀 Features

| Feature | Description |
|----------|--------------|
| 🔐 **Login** | Secure login using hardcoded credentials (`123456` / `1234`) |
| 💵 **Withdraw** | Withdraw money with validation for sufficient balance |
| 💰 **Deposit** | Deposit money and update balance |
| 💳 **Check Balance** | View your current account balance |
| 📜 **Transaction History** | View a table of all past deposits and withdrawals |
| 🧱 **OOP Design** | Uses `Account` and `Transaction` classes |
| 🎨 **Modern UI** | Built with Nimbus Look & Feel, responsive buttons, and padding |

---

## 🧰 Tech Stack

- **Language:** Java  
- **GUI Framework:** Java Swing  
- **Paradigm:** Object-Oriented Programming (OOP)  
- **Storage:** In-memory (ArrayList)  
- **Database (optional):** SQLite (via JDBC integration)

---

## 🗂️ Project Structure

JavaSwingATM/
├── Main.java
├── LoginFrame.java
├── MenuFrame.java
├── WithdrawFrame.java
├── DepositFrame.java
├── BalanceFrame.java
├── TransactionHistoryFrame.java
├── Account.java
└── Transaction.java

yaml
Copy code

---

## 🔑 Default Credentials

| Card Number | PIN  | Starting Balance |
|--------------|------|------------------|
| **123456**   | **1234** | $1000.00 |

---

## 🖥️ How to Run

### 🅰️ Using IntelliJ IDEA

1. **Extract the ZIP** or clone this repository:
   ```bash
   git clone https://github.com/<your-username>/JavaSwingATM.git
Open IntelliJ → File → Open → select the project folder.

Ensure the Project SDK is set (Java 8 or above).

Right-click Main.java → Run 'Main.main()'.

🅱️ Using Eclipse
Create a new Java Project.

Copy all .java files into src/ folder.

Right-click Main.java → Run As → Java Application.
