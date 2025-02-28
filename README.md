# 🚀 Magento Store Automation with Cucumber & Selenium

## 📖 Project Overview
Magento Store Automation with **Cucumber, Selenium WebDriver, and TestNG** is a powerful test automation framework designed to ensure the quality, stability, and efficiency of the Magento eCommerce platform. Using a **Behavior-Driven Development (BDD) approach with Cucumber**, this project automates key functionalities such as **user authentication, product purchase, order management, and payment processing**, ensuring a seamless customer experience.

## 🎯 Project Objective
The primary goals of this automation framework are:
- ✅ **Automate core eCommerce functionalities** to enhance software quality and minimize defects.
- ✅ **Utilize BDD principles with Cucumber** to create human-readable test scenarios for better collaboration between QA, Dev, and Business teams.
- ✅ **Increase test coverage** by covering positive, negative, and edge-case scenarios.
- ✅ **Optimize test execution** by reducing manual testing efforts and implementing efficient regression testing.
- ✅ **Enhance reporting and debugging** through **Allure Reports**, providing detailed execution logs and insights.
- ✅ **Leverage browser configurations** with **Chrome Options** to manage SSL, incognito mode, and notification settings.
- ✅ **Follow industry best practices** with a scalable and maintainable automation architecture.

## 🛠️ Technologies and Tools
This project is built using the following technologies and tools:

| Technology/Tool                | Purpose                                                                                                                                                                     |
|--------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Java**                       | Core programming language for automation scripts                                                                                                                            |
| **Selenium WebDriver**         | Automates browser interactions for functional and regression testing                                                                                                        |
| **Cucumber (BDD)**             | Enables behavior-driven development with Gherkin syntax                                                                                                                     |
| **JUnit**                      | writing and executing tests with Gherkin feature files                                                                                                                      |
| **DTT**                        | for reading and writing Excel files (XLSX)                                                                                                                                  |
| **TestNG**                     | Manages test execution and reporting                                                                                                                                        |
| **Extent Reports Cucumber 7**  | Generates detailed test reports with execution logs                                                                                                                         |
| **Test Data Management**       | Created a detailed MagentoStoreData.xlsx with multiple sheets (LoginData, RegisterData, BillingInformation, AdminLoginData) <br/>to provide dynamic test data for scenarios |
| **Cucumber Server Reports**    | Generates detailed test reports in Cucumber server                                                                                                                          |
| **Chrome Options**             | Handles browser configurations such as SSL, incognito mode, and notifications                                                                                               |
| **Maven**                      | Manages dependencies and builds the project efficiently                                                                                                                     |
| **TestNG XML**                 | Defines test execution flow and enables parallel execution                                                                                                                  |
| **Page Object Model (POM)**    | Enhances maintainability by separating UI interactions                                                                                                                      |

## 📂 Project Structure
The project follows a structured and modular organization to ensure scalability and maintainability:

```
BDD/
│── .idea/                              # Project-specific settings
│── Features/                           # Contains Cucumber feature files
│── reports/                            # Stores test execution reports
│── src/
│   ├── main/
│   ├── test/
│   │   ├── java/
│   │   │   ├── base/                   # Base classes for test execution
│   │   │   ├── environment/            # Environment configurations
│   │   │   ├── factory/                # WebDriver factory for managing browser instances
│   │   │   ├── hooks/                  # Cucumber hooks for setup and teardown
│   │   │   ├── testcases/              # Contains test execution classes
│   │   │   ├── testData/               # Stores test data for scenarios
│   │   │   ├── testRunner/             # Cucumber Test Runner classes
│   │   │   ├── ui.pageobjects/         # Page Object Model (POM) classes
│   │   │   ├── utils/                  # Utility classes for reusable components
│── target/                             # Stores compiled files and test execution results
│── test-output/                        # Stores test execution output
│── .gitignore                          # Git ignore file to exclude unnecessary files
│── pom.xml                             # Maven Dependency Management file
```

## 🌟 Key Features
This project represents a **significant milestone** in my automation testing journey, integrating **Cucumber BDD** with **Selenium WebDriver** to enhance software quality. The key highlights of this framework include:

- ✅ **End-to-End Automation** covering login, product selection, cart operations, checkout, and order validation.
- ✅ **Cucumber BDD Implementation** to make test scenarios more readable and maintainable.
- ✅ **Reusable Page Object Model (POM)** for modular and scalable test automation.
- ✅ **Data-Driven Testing** using external test data sources to validate multiple scenarios.
- ✅ **Detailed Reporting** with Allure Reports, ensuring transparency in test execution.
- ✅ **Robust Browser Configuration Handling** using Chrome Options.

🔹 I am excited about applying these skills to future projects and collaborating on improving software testing practices!

## 🎥 Project Demo
Check out the full project demonstration video here:  
📺 **[Watch Demo](https://drive.google.com/file/d/1hJgLfHDGw53UPmbF8Guy2yDiFwk_LgOF/view?usp=sharing)** 

## 📩 Contact
For any inquiries, collaborations, or contributions, feel free to reach out:

- **👤 Tester Name:** <span style="color:#89CFF0">Mustafa Ibrahim Mostafa</span>
- **📧 Email:** <span style="color:#89CFF0">mustafa.ibrahim.qa@gmail.com</span>
- **🔗 LinkedIn:** [MyProfile](https://www.linkedin.com/in/mostafa-ibrahim-mostafa-6530b4235/)
- **📞 Phone:** <span style="color:#89CFF0">(+02) 01005747258</span>

---
**📌 Note:** This project is actively maintained, and contributions are welcome! Feel free to fork the repository, raise issues, or submit pull requests to enhance the framework. 🚀

