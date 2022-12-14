# Swagger Codegen

This repository contains source code for the project from this Swagger Codegen [video-guide](https://www.youtube.com/watch?v=eZq6D6OkoPY):

[![](https://img.youtube.com/vi/eZq6D6OkoPY/0.jpg)](https://www.youtube.com/watch?v=eZq6D6OkoPY)

## Imitate local pet clinic

To imitate local pet clinic, run Spring Boot app located [here](https://github.com/jpa-buddy/local-pet-clinic).

## HTTP requests

You can run and check the HTTP requests on your own. Here are some example of them:

```http request
###
GET http://localhost:8080/api/v1/pet/sync?id=1

###
GET http://localhost:8080/api/v1/pet/sync?id=10

###
GET http://localhost:8080/api/v1/pet/sync?id=15

### Adjust the start and end dates according to the values in the db
GET http://localhost:8080/api/v1/statistics/from-interval?start=2022-12-09T15:49:05.630Z&end=2022-12-12T15:49:05.630Z
```
