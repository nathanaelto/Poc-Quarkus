# Poc-Quarkus

## Description

It's a simple project to show how to use Quarkus with Kotlin.
<br>
In the project, I implemented a simple CRUD with a Postgres database with Panache (an overlay to Hibernate).
<br>
I test different relations between entities and I use the Panache repository to make the queries.

## Docs

- [Quarkus](https://quarkus.io/)
- [Kotlin](https://kotlinlang.org/)
- [Quarkus Docs](https://quarkus.io/guides/)
- [Quarkus Kotlin](https://quarkus.io/guides/kotlin)
- [Hibernate with Panache](https://quarkus.io/guides/hibernate-orm-panache-kotlin)
- [Default Readme](./default-readme.md)

## How to run in dev mode (basic)

Hot reload is enabled by default.


* First run docker-compose to start the database and the adminer (pgadmin)
> PgAdmin is a web-based administration tool for PostgreSQL. It run on port 5050. Access it with this url: http://localhost:5050

``
````bash
make docker-dev
# or docker-compose up -d
````

* Then run the application

> The application run on port 8080. Access it with this url: http://localhost:8080

```bash 
make dev
# or ./gradlew quarkusDev 
```

## How to test with http requests
In `./requests` folder you can find some requests to test the API.

## How to build 

Different options exist to build the application.
The most basic one is to run the following command:

```bash
make build
# or ./gradlew build
```

For more options, see the [Quarkus docs](https://quarkus.io/guides/gradle-tooling).
Or check the [Default Readme](./default-readme.md).

## Hot to stop the application

* Stop the application
> Just press `Ctrl + C` in the terminal where you run the application.

* Stop the database and the adminer
```bash
make docker-down
# or docker-compose down
```