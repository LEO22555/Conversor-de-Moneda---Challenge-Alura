# Currencies Exchange

## Descripción

**Currencies Exchange** es una aplicación de conversión de divisas construida con Java y Spring Boot. Permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio actualizadas.

## Tecnologías Utilizadas

- Java 22
- Spring Boot 3.3.4
- Maven
- Thymeleaf

## Requisitos

- JDK 17
- Maven
- Conexión a Internet (para tasas de cambio en tiempo real)

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/LEO22555/Conversor-de-Moneda---Challenge-Alura
   cd Currencies-Exchange

2. Construye el proyecto utilizando Maven:

mvn clean install

3. Ejecuta la aplicación:

mvn spring-boot:run
Abre tu navegador y dirígete a:

http://localhost:8080/convert?from=USD&to=EUR&amount=55.6

como resultado se mostrara en la página:

55.60 USD = 51.18 EUR

Si deseas puedes cambiar la cantidad a convertir y las monedas a intercambiar:

http://localhost:8080/convert?from=USD&to=COP&amount=105.6

como resultado se mostrara en la página:

105.60 USD = 448824.86 COP

Rafael Martinez Barrios - Octubre 2024
Challenge Alura - Conversor de monedas

## Estructura del Proyecto

```bash
Currencies_Exchange/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── alura/
│   │   │           └── Currencies_Exchange/
│   │   │               ├── CurrencyConverterApplication.java
│   │   │               ├── controller/
│   │   │               │   └── CurrencyController.java
│   │   │               ├── service/
│   │   │               │   └── CurrencyService.java
│   │   │               ├── model/
│   │   │               │   └── Currency.java
│   │   │               └── repository/
│   │   │                   └── CurrencyRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/
│               └── alura/
│                   └── Currencies_Exchange/
│                       └── CurrencyConverterApplicationTests.java
├── pom.xml
└── README.md