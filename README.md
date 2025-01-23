<p align="center">
    <img src="skilloLogo.png" alt="Skillo Academy Logo" />
</p>


<div align="center">

# Test Automation Framework

</div>

## Automating ISkillo Website

---

### Table of Contents

- [Overview](#overview)
- [Application Under Test](#application-under-test)
- [Test Activities Performed](#test-activities-performed-with-selenium-425-and-testng-10-java-unit-framework)
- [Installation](#installation)
- [Usage](#usage)
- [Observed Issues and Suggestions](#observed-issues-and-suggestions)
- [Bug Reporting](#bug-reporting)
- [Contact](#contact)

---

### Overview

**ISkillo Social Networks** is an innovative online platform where users can create profiles, connect with friends and
family, and engage with a broader community. The platform empowers users to share content instantly and fosters global
connections that extend beyond Bulgaria.

**ISkillo** has revolutionized communication by enabling seamless sharing of information and facilitating meaningful
interactions.

Additionally, **ISkillo** serves as a hub for QA engineers, offering a dynamic environment for a wide range of test
automation activities, making it an invaluable resource for software testing and quality assurance.
---

### Application Under Test

**ISkillo** Training Platform

- [Click here to visit the platform](http://training.skillo-bg.com:4300/posts/all)

---

### Test Activities Performed with Selenium 4.25 and TestNG 10 (Java Unit Framework):

**Registration**

- Verify that a user can register in the system with valid data.
- Verify that a user cannot register in the system with a *taken* email.
- Verify that a user cannot register in the system with a *taken* username.

**Login**

- Verify that an already registered user can successfully log in to the system with valid credentials.
- Verify that an already registered user cannot log in to the system with an *incorrect* username.
- Verify that an already registered user cannot log in to the system with an *incorrect* password.
- Verify that an already registered user cannot log in to the system without providing any credentials.

**Post**

- Verify that a user can create a new post.
- Verify that a user can delete a post.

**Profile**

- Verify that a user can upload a profile picture.

**End-to-End Flow**

- Validate the full flow of user interaction: Registration → Login → Profile → Post.

---

### Installation

- **Prerequisites**:
    - **JAVA:** Version 23 and up.
    - **Maven:** Version 3.8.1 and up.
    - **TestNG:** Version 7.10.2 and up.
    - **Selenium:** Version 4.25.0 and up.

To get started, please visit the Test Automation Framework repository
at: [SKILLO_AT_16_TAF](https://github.com/Nvdimitrova/SKILLO_16_TAF)

Ensure that you can clone the repository by following one of the three methods outlined below:

**Method 1: Manual Download**

- Navigate to the GitHub repository using the link above and click the "Download" button.
- After downloading, extract the repository to your preferred location.

**Method 2: Git Clone via HTTPS**

- Go to the GitHub repository, copy the repository's HTTPS link, and use Git Bash to execute the following commands:
    ```bash
    git clone <repository_url>
    cd <repository_directory>/src
    ```

**Method 3: Cloning with IntelliJ IDEA**

- Open IntelliJ IDEA Community Edition (v21.+ or higher) and use the "Git" menu to clone the project:
    - Select "New Project from VCS"
    - Provide the Git repository URL
    - Click "Clone" to download the project into IntelliJ IDEA.

---

### Usage

#### Check Folder Paths

For Windows OS users, please follow these steps to verify the necessary folders:

**Step 1:** Navigate to the `src/test/resources` directory.

**Step 2:** Ensure the following folders are present:

- `downloads`
- `reports`
- `screenshots`
- `uploads`

*If any of these folders are missing, they **will be automatically created** when you build the project within the
`src/test/java/gui` directory using the automation script.*

#### Running Automation

**Step 1:**  
Open a terminal, shell, or command prompt and navigate to the directory where the `pom.xml` file is located.

**Step 2:**  
Run the following Maven command to clean and execute the tests:

```bash
mvn clean repository
```

**Step 3:**
Wait a bit for the tests to execute. A detailed report will be generated post-execution.

---

### Observed Issues and Suggestions

**Login Page**

- The placeholder text for the **'email'** field could be capitalized to maintain consistency with other fields,
  enhancing the uniformity of the form design.

**Registration Page**

- The placeholder for **'Public info'** currently uses a lowercase 'info'. To ensure consistency across all form fields,
  'info' should be capitalized, aligning it with other placeholders.
- The **birthdate** field allows users to enter unrealistic dates. It would be more appropriate to limit the input to a
  realistic range, ensuring the validity of the data collected and improving the user experience.
- There is no invalid feedback displayed for the **birthdate**, **confirm password**, and **public info** fields, which
  are required. Including informative error messages below these fields would help guide the user and prevent incorrect
  submissions, improving form usability.
- The **registration button** currently uses an incorrect text. It would be more intuitive and standard to change the
  button text to **'Sign Up'**, which is commonly used for registration actions and would meet user expectations.

**Post-Registration Login Flow**

- After the registration process, users are automatically logged in. While this enhances convenience, it may not be the
  ideal user flow in all cases. Automatically logging in a user immediately after registration could present a potential
  security risk, as it might bypass certain post-registration checks or the opportunity for users to confirm their
  registration details. It is recommended to give users the option to log in after registration, allowing them to review
  their account and ensure the registration process was completed correctly before proceeding with full access to the
  platform.

---

### Test Failure Summary

**Test Case:** RegistrationPageLayoutTest.verifyRegistrationPageLayout

- **Reason for Failure:** Missing validation feedback for required fields, which violates usability standards.
- **Impact:** The registration form becomes less intuitive and may confuse users, reducing the success rate of form
  completion.
- **Action Required:** Implement proper validation and error messaging for all mandatory fields.

---

### Bug Reporting

If you encounter any bugs that you'd like to report, please provide the following details, through the designated
channel or email:

- **Description**: A clear summary of the issue.
- **Steps to Reproduce**: A list of actions to replicate the problem.
- **Expected vs. Actual Behavior**: What was expected and what actually occurred.
- **Environment**: Include browser, operating system, and application version.
- **Attachments**: Any relevant screenshots, logs, or error messages.

---

### Contact

- **Name:** Nikol Valentinova Dimitrova
- **Email:** [nikolvd3@abv.bg](mailto:nikolvd3@abv.bg)
- **Project Link:** [GitHub - TAF Selenium 4 TestNG 10](https://github.com/Nvdimitrova/SKILLO_16_TAF)