Hypermedia-Driven API
- Spring generate itself endpoints from Repositories:
    - GET 
        - /tourPackages 
        - /tourPackages/{code}
        - /tours
        - /tours/{code}
    - POST, DELETE and UPDATE (PUT, PATCH)
    
Paging and Sorting
- Spring auto implement when Repositories extends Paging and Sorting
- GET http://localhost:8080/tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc
- GET http://localhost:8080/tours?page=1&size=3&sort=title,asc

Controlling API Exposure:
- Block some methods/endpoints for outside world
    - @RestResource(exported = false)

Changing default endpoint route
- @RepositoryRestResource(collectionResourceRel = "packages", path = "packages")

HAL Browser:
- Tool to easily navigate through the endpoint from your API

REST Controller Class mediates between web requests and the internal of the applications.

Spring MVC:
- Request -> RestController class -> Services
Spring Data REST:
- Request -> Spring Data REST -> Spring Data Repository

Why use Spring MVC?
- Not using Spring Data Repositories
- API uses algorithms
- Hide internal data
- Require business layer

Paging and Sorting DTOs
- localhost:8080/tours/1/ratings?size=2&page=1&sort=score,desc