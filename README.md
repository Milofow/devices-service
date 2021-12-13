# Device service
This service is responsible for handling data related to devices connected to the [home automation dashboard](https://github.com/Milofow/front-end-dashboard). The service stores and retrieve this data inside a database.

## Requests
Currently acceptable requests are:
- GET: ```/devices``` 
- GET: ```/devices/{id}``` 
- POST: ```/devices/new```
- PUT: ```/devices/{id}```  
- DELETE: ```/devices/{id}```

## Architecture:
The application works with a three layer architecture. This means that all my controllers handle incoming requests and pass them on to the service layer which sometimes provides some essential business logic. The service layer then continues to the Data access object which communicates with the database through Hibernate JPA methods. The image below provides a graphic explanation.


![Three tier/layer architecture](https://cdn.discordapp.com/attachments/799690499157917719/920016209691431052/architecture_api.png)
<i>Source: https://www.youtube.com/watch?v=th3uIP7D8nk&t=1435s&ab_channel=JavaGuides</i>
