# Coffee Shop App

Welcome to the Coffee Shop App! This application simulates a coffee shop with ordering and admin functionalities. It is built using Spring Boot 2.5.2 and compiled with Java 8.

## Setup

### Prerequisites

*   Java 8
*   Eclipse IDE (or any preferred Java IDE)

### Clone the Repository

*   git clone https://github.com/yourusername/-NameSurname_Omega_CoffeeShop.git 
*   cd coffee-shop-app

### Import the Project into Eclipse

1.  Open Eclipse IDE.
2.  File > Import > Existing Maven Projects.
3.  Select the root directory of the cloned project and click "Finish."

### Run the Application

1.  Open the `CoffeeShopApplication` class in the `src/main/java/com/gunsh/coffeeshop/CoffeeShopApplication.java` file.
2.  Right-click on the file and select "Run As > Java Application."
3.  The backend will start on [http://localhost:8080](http://localhost:8080).

## Usage

### Backend Endpoints

1.  #### Add Coffee

    *   Endpoint: `POST /api/coffee/add`
    *   Description: Add a new coffee to the menu.
    *   Request Body: Coffee details (type, price, picture URL, amount of coffee in grams, brewing time).
    *   Response: Success message or error message with HTTP status.
2.  #### Modify Coffee

    *   Endpoint: `PUT /api/coffee/modify/{id}`
    *   Description: Modify an existing coffee on the menu.
    *   Path Variable: Coffee ID.
    *   Request Body: Modified coffee details.
    *   Response: Success message or error message with HTTP status.
3.  #### Remove Coffee

    *   Endpoint: `DELETE /api/coffee/remove/{id}`
    *   Description: Remove a coffee from the menu.
    *   Path Variable: Coffee ID.
    *   Response: Success message or error message with HTTP status.
4.  #### Get All Coffees

    *   Endpoint: `GET /api/coffee/list`
    *   Description: Get a list of all available coffees.
    *   Response: List of coffees with details.
5.  #### Get Coffee by ID

    *   Endpoint: `GET /api/coffee/{id}`
    *   Description: Get details of a specific coffee by ID.
    *   Path Variable: Coffee ID.
    *   Response: Coffee details or HTTP status.
6.  #### Order coffee 

    *   Endpoint: `POST /api/coffee/order`
    *   Description: Get details of a specific coffee by ID.
    *   Request Body: Order details
    *   Response: Order status or HTTP status.

### Notes

*   The application is not started with Maven but run directly from the IDE (Eclipse).
*   All the data is stored in text files, including users.
*   Data is located inside src/data.