### RabbitMQ with Docker

Command to run rabbitmq as docker container :- 
```
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:4.2.1-management
```

Management UI :- 
```
http://localhost:15672
```
