# This is Selenium test for social media [LinkedIn](https://www.linkedin.com/)

---

This project includes 2 test suits.

Each of them have 4 test cases.

Altogether 8 test cases.

Project includes WebDriverManager which setup the webdriver options for few browsers instead of manualy setup.
Browsers included in WDM are:
- Chrome
- FireFox
- Opera
- Edge
- Internet Explorer

In this project Google Chrome is default web driver. You can choose others by uncommenting them in setupTest() method.

---

## How to use?

You can run it simply with "mvn test" command from terminal.

---

## Login Test
In this test I used my crenedtials. You need to use yours if you want this test running correctly.

- Login with valid phone number. 
  - Note: My phone number is based on Croatian phone number. It's not same for other countries.
- Login with invalid phone number.
  - Note: Login with phone number which is actualy not phone number.
- Login with invalid password (difference is in first letter )
  - Note: Difference is in uppercase and lowercase of first letter.
- Login With valid email and password. 

### 4 tests runned, 4 tests passed

---

## Register Test
Also, I used my credentials.

- Register with invalid email. 
  - Note: Here mail is not in standard form.
- Register with short password.
- Register with long password. 
- Register with existing email. 
  - Mail used in this register form is already in use. 
  
### Here, 2 tests passed while 2 of them failed.
In registration with existing email we expected error message like in TC register with invalid email, but that didn't happend. We could proceed with the registration procedure. Error message or stopping user carry on with registration would be good.

Registration with long password also failed. I used 143 characters for password. It's nonsense to use that long password.

---

Full report is avaliable at [Report](https://github.com/kristijankoscak/SeleniumTestProject/blob/master/koscak_projekt/target/surefire-reports/index.html).
