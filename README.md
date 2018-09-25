# 🗺️ Picnic Service
Сервис для создания и планирования пикников с друзьями. Достаточно выбрать место, время, выбрать необходимое и отправиться на природу!


[![Build Status](https://travis-ci.org/pushkinser/picnic-service.svg?branch=master)](https://travis-ci.org/pushkinser/picnic-service)

### ⚙ Download and build

```
$ git clone https://github.com/pushkinser/picnic-service.git
$ cd picnic-service
$ gradle clean build
```
### 🗄️ Database

В проекте используется встроенная HSQLDB:

TABLE     | COLUMNS
----------|-------
user      | id, user_name, password, email
role      | id, role_name
user_role | id, user_id, role_id

