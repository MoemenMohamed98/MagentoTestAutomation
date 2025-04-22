# Magento Test Automation

This repository contains automated UI test cases for the [Magento Demo Website](https://magento.softwaretestingboard.com).  
The test suite covers user registration and product comparison features. It is structured using the **Page Object Model (POM)** for better scalability and maintainability.

---

## 🛠️ Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/MoemenMohamed98/MagentoTestAutomation.git
   ```

2. **Install dependencies using Maven**
   ```bash
   mvn clean install
   ```

3. **Configure browser settings in** `WebConfigurations.properties`:
   ```properties
   BrowserType=CHROME
   HeadlessMode=false
   BaseURL=https://magento.softwaretestingboard.com/
   ```

---

## ▶️ Running the Tests

To execute all test cases, run:

```bash
mvn test
```

Tests are prioritized and executed in the following order:

- Register a new user
- Add the first product to the comparison list
- Add the second product to the comparison list
- Compare products on the comparison page

---

## 📁 Project Structure

```
MagentoTestAutomation
├── main
│   └── java
│       └── com.magento
│           ├── drivers              # WebDriver factory, manager classes
│           ├── pages                # Page Objects: RegisterPage, HomePage
│           └── utilities            # Helpers: waits, actions, properties, test data
│
├── test
│   └── java
│       └── MagentoTest.java         # Main test suite using TestNG
│
├── resources
│   ├── WebConfigurations.properties # Test configs: browser, baseURL
│   └── log4j2.properties            # Logging config
│
└── logs/
    └── automation-log.log           # Generated log file
```

---

## ✅ Test Scenarios

- ✅ User registration
- ✅ Navigate and verify Hot Sellers section
- ✅ Add products to the compare list
- ✅ Verify comparison page functionality

---

## 📝 Logging

Logs are configured via `log4j2.properties`.  


