# Guestbook
Guestbook on Google AppEngine: https://guest-book-exercise.appspot.com/  
Google AppEngine, Restlet and Maven

## Build and Deploy

**Build the application**  
The server is running at http://localhost:8080/
> mvn appengine:devserver  


**Deploy the application to AppEngine**  
View the application on Google AppEngine: https://guest-book-exercise.appspot.com/
> mvn appengine:update  

## Guestbook API

**URL** https://guest-book-exercise.appspot.com

**List all greetings**  
endpoint : /api/guestbook

**Get a specific greeting by ID**  
endpoint : /api/guestbook/{id}
