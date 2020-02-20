# Description

Glofox REST Api exercises with three services:

* Create classes 
* Get a class
* Book a class


# Getting Started



## Prerequisites

* Java 8+
* Maven
* Spring Boot

## Installing

1. Execute maven clean install
2. Run as SpringBootApplication (profile is not required)


## Database

H2 was used as a database. When running locally a console can be accessed via  [H2 Console](http://localhost:8090/glofox/h2)

Configuration:
 
   * **url**: jdbc:h2:file:./glofox-h2-db
   * **username:** glofox
  *  **password:** (it doesn't have one)
   * **driver-class-name:** org.h2.Driver




## Documentation

Documentation was done using Swagger-U that can be accessed locally via [Swagger-UI](http://localhost:8090/glofox/swagger-ui.html#/)

## Testing Examples

The following JSONs were used to test all the functionalities.

* Test #1 - Create a class sucessfuly

```json
{
    "capacity": 20,
    "endDate": "2020-02-25",
    "name": "Pilates",
    "startDate": "2020-02-21"
}
```

* Test #2 -Throw invalid dates exception

```json
{
    "capacity": 20,
    "endDate": "2020-02-21",
    "name": "Pilates",
    "startDate": "2020-02-23"
}
```

* Test #3 - Create a class + Try to add a class to an existing created class.

1. Create first set of classes
```json
{
    "capacity": 20,
    "endDate": "2020-02-25",
    "name": "Pilates",
    "startDate": "2020-02-21"
}
```
2. Try to book a class where a class is already booked
```json
{
    "capacity": 20,
    "endDate": "2020-02-22",
    "name": "Pilates",
    "startDate": "2020-02-21"
}
```

* Test #4 - Book a class

1. Create class

```json
{
    "capacity": 20,
    "endDate": "2020-02-25",
    "name": "Pilates",
    "startDate": "2020-02-21"
}
```
2. Book a class for a given day
```json
{
    "date": "2020-02-21",
    "name": "Tiago"
}
```

# Note
I tried to implement automated testing using JUnit and Mockito but unfortunately ran into some problems and was unable to successfully complete it. Nevertheless, I left the code in the test directory and 1 test that passes successfully. 
