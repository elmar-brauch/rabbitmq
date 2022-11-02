# Spring Integration for RabbitMQ demo project

## How to get it running
* Clone this GIT project.
* Make sure it is a Maven project and Maven is executed to load dependencies.
* Start RabbitMQ as Docker container like this: docker run --rm -it -d -p 15672:15672 -p 5672:5672 rabbitmq:3-management
* Start Spring Boot demo application with profile "producer"
* Start Spring Boot demo application with profile "consumer"
* Use browser to send HTTP GET requests to API of producer: http://localhost/text/create or http://localhost/comment/create
* Watch logs of consumer application to see processing of RabbitMQ messages created by your API calls.
* Check RabbitMQ Management UI for more details in browser http://localhost:15672/ with login guest:guest

## More information
Visit Elmar Brauch's German blog to read the article behind this project:
https://agile-coding.blogspot.com
