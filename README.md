# Parking System Using Java

## Introduction

Welcome to the Car Parking System using Java! This system simplifies the task of parking cars. Java, a widely-used programming language, is chosen for this project due to its simplicity, versatility, and platform independence. The system analyzes the availability of parking spaces and provides user-friendly output. When all slots are full, it alerts the user not to park their car in that area. Available slots are incremented when a user removes their car from the parking area and decremented when a user parks their car.

Parking systems in Java offer a flexible and robust platform for managing parking spaces, improving traffic flow, and enhancing the overall parking experience for drivers. By leveraging the strengths of Java, developers can create parking systems tailored to their users' unique needs.

## Explanation

The Parking System we will build is a simple console-based application that allows users to park their cars, remove their cars, and view all parked cars. It presents a menu with four options: park a car, remove a car, view parked cars, and exit the program.

### Main Features

- **Park a Car:** Users can check for available parking slots and, if available, provide their car's license number. A success message is displayed upon successful parking.

- **Remove a Car:** Users can remove their parked cars. If there are no parked cars, this option won't be available. Users need to enter the license number of the parked car for removal.

- **View Parked Cars:** Users can view a list of all currently parked cars. This feature utilizes a for-each loop to display the parked cars.

### Implementation

This parking system is implemented in a single Java class. It uses the `Scanner` class to take input from the user via the keyboard and an `ArrayList` to manage cars. The user provides the total number of parking slots, and a menu is displayed for further operations.

The system checks for the availability of slots when parking a car, and if slots are available, the user provides their car's license number, resulting in a "Car parked successfully" message. When removing a car, the system checks the number of parked cars; if there are none, the process does not proceed. The user enters the license number of the parked car to remove it. The `add` and `remove` methods of the `ArrayList` are used to add and remove cars. Available slots are adjusted accordingly.

The project is designed to be beginner-friendly, and basic knowledge of Java is sufficient to understand and modify the code.

Happy Coding!

