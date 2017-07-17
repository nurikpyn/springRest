# springRest
Spring 4 Rest

Настройки базы данных - 
kz.test.spring.config.AppConfig.java
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root" );
        dataSource.setPassword("");
расскоментировать строку для автоматического создания таблицы БД
      //  properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");


$ git clone https://github.com/nurikpyn/springRest
$ mvn tomcat7:run


Настройки базы данных - 
kz.test.spring.config.AppConfig.java
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root" );
        dataSource.setPassword("");
расскоментировать строку для автоматического создания таблицы БД
      //  properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");



1. Создание нового пользователя:
url - http://localhost:8080/api/users
method - post 
consumes - json
json body example - 
    {
        "firstName": "nurlan",
        "lastName": "sarybaev",
        "email": "nsarybaev@gmail.com",
        "mobile": "121-232-3435",
        "pictureUri": "desktop/1.jpg",
        "userStatus":""
    }
response - created user ID

2. Получение информации о пользователе:
url - http://localhost:8080/api/users/1
http://localhost:8080/api/users/{userId}
method - get 
consumes - json   
response json - status by default is "Offline"
    {
        "id":1
        "firstName": "nurlan",
        "lastName": "sarybaev",
        "email": "nsarybaev@gmail.com",
        "mobile": "121-232-3435",
        "pictureUri": "desktop/1.jpg",
        "userStatus":"Offline",
        "requests": [
            {
                "id": 1,
                "requestId": 1500306725000
            }
        ]
    }
    
3. Изменение статуса пользователя (Online, Offline):
url - http://localhost:8080/api/users/1/Online
http://localhost:8080/api/users/{userId}/{status}

method - put
consumes - json
response json -
{
    "id": 1,
    "oldStatus": "Offline",
    "status": "Online"
}

4. Статистика сервера:
url examples - 
http://localhost:8080/api/users/statistic/{status}/{requestId}
http://localhost:8080/api/users/statistic/Online
http://localhost:8080/api/users/statistic/Offline
http://localhost:8080/api/users/statistic/Online/1500306725000
http://localhost:8080/api/users/statistic/Offline/1500306725000

method - get
consumes - json
response json -

  {
        "id": 1,
        "firstName": "nurlan1",
        "lastName": "sarybaev",
        "email": "djohn@gmail.com",
        "mobile": "121-232-3435",
        "pictureUri": "desktop/1.jpg",
        "userStatus": "Online",
        "requests": [
            {
                "id": 1,
                "requestId": 1500306725000
            }
        ]
    }

5. Список пользователей - 
url  - http://localhost:8080/api/users
method - get
consumes - json
produces - json list

6. Обновить пользователя - 
url  - http://localhost:8080/api/users/{userId}
method - post
consumes - json    
response - updates user json object

7. Удалить пользователя -
url  - http://localhost:8080/api/users/{userId}
method - delete
consumes - json    
response - deleted userId



