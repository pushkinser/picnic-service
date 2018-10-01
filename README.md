# 🗺️ Picnic Service
Сервис для создания и планирования пикников с друзьями. Достаточно выбрать место, время, выбрать необходимое и отправиться на природу!


[![Build Status](https://travis-ci.org/pushkinser/picnic-service.svg?branch=master)](https://travis-ci.org/pushkinser/picnic-service)

### ⚙ Download and build

```
$ git clone https://github.com/pushkinser/picnic-service.git
$ cd picnic-service
$ gradle clean build
```

### 🚪 Endpoints

#### User Resources

URL               | HTTP Method | Description
------------------|-------------|------------
 `api/user/:id`   | GET         | get user by id
 `api/user/all`   | GET         | get all user


### Item Resources
URL             | HTTP Method | Description
----------------|-------------|------------
`api/item/:id`  | GET         | get item by id

### 🗄️ Database

В проекте используется встроенная HSQLDB:

TABLE         | COLUMNS                                       |COMMENT
--------------|-----------------------------------------------|---------
user          | id, user_name, password, email                |user info
role          | id, role_name                                 |role info
user_role     | id, user_id, role_id                          |relation user @OneToOne role
item_category | id, category_name                             |category info
item          | id, item_title, description, item_category_id |item info

