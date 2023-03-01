# Poc-Quarkus

## Description

It's a simple project to show how to use Quarkus with Kotlin.

## Docs

- [Quarkus](https://quarkus.io/)
- [Kotlin](https://kotlinlang.org/)
- [Quarkus Docs](https://quarkus.io/guides/)
- [Quarkus Kotlin](https://quarkus.io/guides/kotlin)
- [Default Readme](./default-readme.md)

## How to run in dev mode (basic)

Hot reload is enabled by default.


* First run docker-compose to start the database
````bash
make docker-dev
# or docker-compose up -d
````

* Then run the application

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