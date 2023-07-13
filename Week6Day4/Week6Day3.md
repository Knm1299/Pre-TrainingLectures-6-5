# REST

- REpresentational State Transfer
- Architectural style for an API using HTTP
- Design convention, not a universal standard, but very widespread


## Constraints

- **These are the general "Rules" an API neds to fulfil to be considered 'RESTful'**
  
1. **Uniform Interface**
    - Endpoints for a particular entity should share the same URL, distinguishing actions with the HTTP verb used
    - Take for instance the following scenario:
  
    ```md
        A GET request is sent to the following endpoint:

        http://url.com/getAllPaintings

        1. What does this likely return?

        2. What other endpoints exist at this url?
    ```

    - How can we format this to make the second question obvious?

    ```md
        GET    http://url.com/painting
        GET    http://url.com/painting/{id}
        POST   http://url.com/painting
        PUT    http://url.com/painting/1
        PATCH  http://url.com/painting/1
        DELETE http://url.com/painting/1
    ```

    <br>

2. **Stateless**
    - The necessary information for a request is contained in the request itself
    - No info about client session is stored in the server while not processing a request

    <br>

3. **Cacheable**
    - If a client has already received a response for a particular call, they should be able to store that response, and use it if the call is made again
    - For instance: GET http://google.com
        - When we send this request for the first time, we download the page from the server
        - If we refresh without changing anything, our browser can load the site much faster, since it's already stored(cached) resources from the webpage

    <br>

4. **Client-Server**
    - Just means that the client and server are treated as two seperate entities

    <br>

5. **Layered System**
    - The client should not know if it's reached the endpoint itself or an intermediate layer
    - The request/response doesn't store any info about everything it hits, just the source and destination
