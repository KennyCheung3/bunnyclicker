# Mobile Application Development with Android - Bunny Clicker

Bunny Clicker is a small mobile application development project still WIP made within the framework of an elective.

<<DELETE BELOW>>

> 🚧 **This is a template project**: Make sure that you adapt this documentation and the source code in this project according to your needs and use case.

#### Contents:
- [Installation Guide](#installation-guide)
- [Analysis](#analysis)
    - [Scenario](#scenario)
    - [User Stories](#user-stories)
    - [Use Case](#use-case)
- [Design](#design)
    - [Prototype Design](#prototype-design)
    - [Domain Design](#domain-design)
    - [Business Logic Design](#business-logic-design)
    - [Endpoint Design](#endpoint-design)
- [Implementation](#implementation)
    - [Backend Technology](#backend-technology)
    - [Frontend Technology](#frontend-technology)
- [Deployment](#deployment)
- [User Guide](#user-guide)
- [Project Management](#project-management)
    - [Roles](#roles)
    - [Milestones](#milestones)

## Installation Guide

This section provides you a detailed installation guide for the Web Application - ABBC Group. The installation guide is tested for **Windows users** only. In case of questions, please contact a member of the ABBC Group which can be found [here](#roles). <br><br>

1. Download the ZIP File of this GitHub Repository (and the 'target' folder with the respective project documents*). Place the files (alongside 'target' folder) in a folder, where you can easily access again later.
2. Press the Windows-Key and type 'cmd (Command Prompt)' in your Windows search. Launch cmd.


![](images/installation-guide/img-1.png)

3. Type 'java' into the console. If it returns an error (see below), please proceed to step 4. Otherwise, skip to step 7.

Error:

![](images/installation-guide/img-2.png)

No error:

![](images/installation-guide/img-3.png)

4. Locate your java.exe file in your File Explorer. This should be located within your C:\User\openjdk\bin folder (or C:\Program Files\Java\jdk-11\bin).

![](images/installation-guide/img-4.png)

5. Copy the filepath (as shown above), then type 'cd' in your cmd console and paste the path.

![](images/installation-guide/img-5.png)

6. Repeat step 3. This should fix the problem.
7. Open and copy the filepath from the 'target' folder mentioned in step 1. This folder should consist a file named acrm-1.0.jar. Add the filename to the filepath as well (e.g., C:\Users\Filepath\target\acrm-1.0.jar)
8. Open your cmd console again. Type in 'java -jar' and paste the filepath you copied. Put parentheses around the folder's path, if you have spacings somewhere along the file path.

![](images/installation-guide/img-6.png)

9. Execute the script. It should look like this now.

![](images/installation-guide/img-7.png)

10. Open a standard web browser (e.g., Google Chrome) and type in 'localhost:8080'

![](images/installation-guide/img-8.png)

11. You should be able to access the Web Application now.

![](images/installation-guide/img-9.png)

12. You are done! Enjoy testing our Web Application. <br> The 'localhost' server will be terminated, as soon as you close your cmd window. <br><br>
13. Alternatively, the direct link to the Web Application on Heroku server can be found [here](https://abbc-shipping-cost.herokuapp.com/login-page).



---

*For teachers only. Will be sent via E-Mail.

## Analysis

### Scenario

The ABBC Group is an IT-Project created at the FHNW - University of Applied Sciences Northwestern Switzerland. The aim of this project work is to create a
functional, dynamic and responsive Web Application with the primary goal to allow for shipping cost calculations. The shipping cost is calculated based on the
palette sizes of the selected products from the Web Shop and the distance between the location of FHNW Basel (Peter Merian-Strasse 86, 4052 Basel) and
the user's input. Additionally, we have added several functionalities to further enhance quality of life and user experience.


### User Stories

1. As a user, I want to create an account so that I can get access to the Web Application.
2. As a user, I want to authenticate myself in the log-in.
3. As a user, I want to edit my personal data so my data is stored securely.
4. As a user, I want to be able to log out from the system.
5. As a user, I want to have a Web Application with consistent, appealing and intuitive visual appearance.
6. As a user, I want to have a Web Application that I can use on different mobile devices and on desktop computers.
7. As a user, I want to add products to my shopping cart.
8. As a user, I want to receive quantity discounts on selected products.
9. As a user, I want to have the system perform the costs for me.
10. As a user, I want to have the system perform the shipping cost calculations for me.
11. As a user, I want to have the system perform the total bill for me.
12. As a user, I want to review my orders placed in the Web Application (Order history).
13. As a user, I want to submit contact forms to reach out for support.

### Use Case
![](images/use-case.png)



- UC 100 [Account Registration]: Users can create a new account by entering information in the required input fields (Surname, Name, Address, Zip Code, Email and Password) within the registration page.
- UC 101 [Login]: Users can log-in by entering an email address and password. As an extension, new users may register first.
- UC 102 [Logout]: Users can log-out from the system, if they are already signed in.
- UC 103 [Edit Account Information]: Users can view and edit the personal data in the Account settings.
- UC 110 [Password Policy]: Users can only create or edit an account, if the password policy is fulfilled (see UC 100 & UC 103)
- UC 200 [Homepage]: Users can navigate through the webapp using the user interface.
- UC 210 [Add Products to Cart]: Users can add products to their shopping cart.
- UC 211 [Edit Shopping Cart]: Users can edit the shopping cart in the cart page.
- UC 220 [Calculate Shipping Cost]: The Web Application calculates the shipping cost based on the products and quantities in the current shopping cart.
- UC 222 [Discount protocol]: Users receive a discount of 5% if the given quantity is ordered.
- UC 223 [Checkout]: Users can perform checkout with the products ordered in the shopping cart.
- UC 224 [Order History]: Users can view the order history within the cart page.
- UC 300 [Contact Form]: Users can submit a contact form to the ABBC Group.

## Design

### Prototype Design

A first static prototype design for the user interface based on HTML, CSS and basic JavaScript have been created using the application Bootstrap Studio. <br><br>
Further adjustments to the HTML pages have been made throughout the project's lifecycle to enhance visibility of the Web Application. The static assets have been exported and added to the Web Application.


### Domain Design

The `ch.fhnw.acrm.data.domain` package contains the following domain objects / entities including getters and setters:

![](images/domain-model.png)

### Business Logic Design

The `ch.fhnw.acrm.business.service` package contains classes of the following business services:

![](images/business-service.png)

### Endpoint Design

**Example Request**

**Path**: [`/api/getLatestOrderItems`](https://abbc-shipping-cost.herokuapp.com/swagger-ui/#/order-item-endpoint/getOrderItemsUsingGET)

**Method:** `GET`

**Sample Request**  • *Header:* `Content-Type: application/json` • *Body:*

```JSON
[
  {
    "discount": 0,
    "id": 0,
    "order": {
      "agent": {
        "address": "string",
        "email": "string",
        "id": 0,
        "name": "string",
        "remember": "string",
        "surname": "string",
        "zipCode": 0
      },
      "date": "string",
      "deliveryDate": "string",
      "id": 0,
      "status": true,
      "totalBill": 0
    },
    "product": {
      "discountQuant": 0,
      "id": 0,
      "maxProducts": 0,
      "minSpace": 0,
      "name": "string",
      "price": 0
    },
    "quantity": 0
  }
]
```

• *Optional:* `...`

**Success Response**  • *Code:* `200 OK` • *Sample Body:*

```JSON
[
  {
    "discount": 0,
    "id": 0,
    "order": {
      "agent": {
        "address": "string",
        "email": "string",
        "id": 0,
        "name": "string",
        "remember": "string",
        "surname": "string",
        "zipCode": 0
      },
      "date": "string",
      "deliveryDate": "string",
      "id": 0,
      "status": true,
      "totalBill": 0
    },
    "product": {
      "discountQuant": 0,
      "id": 0,
      "maxProducts": 0,
      "minSpace": 0,
      "name": "string",
      "price": 0
    },
    "quantity": 0
  }
]
```

**Error Response** • *Code:* `401 Unauthorized`<br>
**Error Response** • *Code:* `404 Forbidden`<br>
**Error Response** • *Code:* `404 Not Found`<br>

---

The complete Endpoint Design can be found on Swagger-UI [here](https://abbc-shipping-cost.herokuapp.com/swagger-ui/).

## Implementation

### Backend Technology
This Web application is relying on [Spring Boot](https://projects.spring.io/spring-boot) and the following dependencies:

- [Spring Boot](https://projects.spring.io/spring-boot)
- [Spring Web](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
- [Spring Data](https://projects.spring.io/spring-data)
- [Java Persistence API (JPA)](http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html)
- [PostgreSQL](https://www.postgresql.org)

To bootstrap the application, the [Spring Initializr](https://start.spring.io/) has been used.

Then the following further dependencies has been added to the project `pom.xml`:

- Swagger and Swagger UI:
```XML
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

- Java HTML Parser and JWT:
```XML
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.14.2</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.2</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-gson</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
```

### Frontend Technology
The ABBC Web Application is relying on the following frontend technology/libraries:

- jQuery
- Bootstrap

## Deployment
This spring boot has been deployed to Heroku by using a pre-configuration scripts `app.json` and `Procfile`.

## User Guide
The Web Application can be accessed over the standard web browser by clicking [here](https://abbc-shipping-cost.herokuapp.com/login-page). <br><br> The Web Application Swagger-UI can be access [here](https://abbc-shipping-cost.herokuapp.com/swagger-ui/#/).

## Project Management

### Roles
- Back End: [Leonardo Bollazzi](https://people.inside.fhnw.ch/Person.aspx?accountname=i%3A05%2Et%7Cadfs%7Cleonardo%2Ebollazzi%40students%2Efhnw%2Ech)
- Back End: [Niklas Baumgartner](https://people.inside.fhnw.ch/Person.aspx?accountname=i%3A05%2Et%7Cadfs%7Cniklas%2Ebaumgartner%40students%2Efhnw%2Ech)
- Front End: [Christine Dyan Aseral](https://people.inside.fhnw.ch/Person.aspx?accountname=i%3A05%2Et%7Cadfs%7Cchristinedyan%2Easeral%40students%2Efhnw%2Ech)
- Front End: [Kenny Cheung](https://people.inside.fhnw.ch/Person.aspx?accountname=i%3A05%2Et%7Cadfs%7Ckenny%2Echeung%40students%2Efhnw%2Ech)

### Milestones
1. **Analysis**: Scenario ideation, use case analysis and user story writing.
2. **Prototype Design**: Creation of Bootstrap static web-design prototype.
3. **Domain Design**: Definition of domain model.
4. **Business Logic and API Design**: Definition of business logic and API.
5. **Data and API Implementation**: Implementation of data access and business logic layers, and API.
6. **Security and Frontend Implementation**: Integration of security framework and frontend realisation.
7. **Deployment**: Deployment of Web application on cloud infrastructure.

#### Maintainer
- **ABBC Group**

#### License
- [Apache License, Version 2.0](blob/master/LICENSE)