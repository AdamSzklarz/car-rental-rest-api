<html>
<body>
<h2>Welcome to the car rental REST API!</h2>


<p>Main page: http://localhost:8080/car-rental-rest-api</p>

<p>(1) Getting list of all cars: http://localhost:8080/car-rental-rest-api/api/cars (method: GET)</p>
<p>(2) Getting car of specified id: http://localhost:8080/car-rental-rest-api/api/cars/{carId} (method: GET)</p>
<p>(3) Adding new car: http://localhost:8080/car-rental-rest-api/api/cars (method: POST), request body (example):
 {
    "regNumber": "XX 12345",
    "mark": "ABC",
    "model": "XYZ"
}</p>
<p>(4) Updating existing car: http://localhost:8080/car-rental-rest-api/api/cars (method: PUT),
request body (example):
{
    "carId" : 1,
    "regNumber": "XX 12345",
    "mark": "ABCDE",
    "model": "XYZ"
}</p>
<p>(5) Deleting car of specified id: http://localhost:8080/car-rental-rest-api/api/cars/{carId} (method: DELETE)</p>
<p>(6) Getting list of all customers: http://localhost:8080/car-rental-rest-api/api/customers (method: GET)</p>
<p>(7) Getting customer of specified id: http://localhost:8080/car-rental-rest-api/api/customers/{customerId} (method: GET)</p>
<p>(8) Adding a new customer: http://localhost:8080/car-rental-rest-api/api/customers (method: POST), request body (example):
{
    "firstName": "Anna",
    "lastName": "Kowalska",
    "email": "kowalska@wp.pl"
}</p>
<p>(9) Updating existing customer: http://localhost:8080/car-rental-rest-api/api/customers (method: PUT), request body (example):
{
    "customerId" : 8,
    "firstName": "Anna",
    "lastName": "Kowalska-Nowak",
    "email": "kowalska-nowak@wp.pl"
}</p>
<p>(10) Deleting customer of specified id: http://localhost:8080/car-rental-rest-api/api/customers/{customerId} (method: DELETE)<p>
<p>(11) Getting list of all rents: http://localhost:8080/car-rental-rest-api/api/rents (method: GET)</p>
<p>(12) Getting rent of specified id: http://localhost:8080/car-rental-rest-api/api/rents/{rentId} (method: GET)</p>
<p>(13) Renting a car(=adding new rent): http://localhost:8080/car-rental-rest-api/api/rents/{carId}/{customerId} (method: POST)
NOTE: Car of given id must be available for renting (isAvailable=true)</p>
<p>(14) Returning a car(=ending rent): http://localhost:8080/car-rental-rest-api/api/rents/{rentId}/{carId} (method: PUT)</p>

</body>
</html>
