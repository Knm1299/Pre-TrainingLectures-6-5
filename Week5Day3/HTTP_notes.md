**HTTP**
 - Stands for HyperText Transfer Protocol
 - Standardized way for web servers to send data to one another
 - HTTP messages are broken down into two categories:


**Requests**
 - This is what the client(user) sends to the server
 - Consists of several parts:
 - **HTTP verb/method**: this denotes the type of request, there are a number of these with different intended uses, but for the most common ones:
    - GET:  Used to retrieve information(like retrieving a webpage) 
        - this is Read in CRUD
    - POST: Used to submit new information to the resource(server) 
        - this is Create in CRUD
    - PUT: Replaces an entire entity in the resource 
        - this is Update in CRUD
    - PATCH: Replaces part of an entity in the resource 
        - this is also Update in CRUD
    - DELETE: exactly what it says on the tin, deletes something from the resource
        - This is Delete in CRUD
- **The Path/endpoint**: This denotes where in the server we are trying to access. This will be everything to the right of the domain in a URL
    - For example: https://http.cat/418
        - the endpoint here is /418
- **The version of HTTP protocol**
- **Headers**: optional additional information for the server
- **Body**: for requests like POST, this will be the content we are sending to the server
    - For our purposes, we will be using JSON for this, more on that to come

**Responses**

- This is what the server sends back in response to a request
- This will contain: 
- **The HTTP version**
- **The status code of the response and a short descriptive message**
    - tells whether the request succeeded or not, and why
    - 3 digit numbers in the range 100-599
    - **100 series** : Informational responses
    - **200 series** : Successful responses
    - **300 series** : Redirection messages
    - **400 series** : client error responses
    - **500 series** : server error responses
- **HTTP headers similar to those for requests**
- **Body**: if applicable, sends information back to the client
    - This is optional, but almost always used for GET requests

MDN article on HTTP: https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview

MDN on Status Codes: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

Status codes as cat pictures: https://http.cat/