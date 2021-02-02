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