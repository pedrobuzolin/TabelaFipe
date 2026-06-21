# 🚗 Consulta Tabela FIPE - Java + Spring Boot

Aplicação backend desenvolvida em Java utilizando Spring Boot para
consulta de informações de veículos através da API da Tabela FIPE.

O projeto permite consultar valores e informações de veículos como
carros, motos e caminhões, utilizando dados fornecidos por uma API
externa.

O objetivo principal foi praticar conceitos do ecossistema Java/Spring,
como consumo de APIs REST, manipulação de dados JSON e organização de
uma aplicação backend.

------------------------------------------------------------------------

## 🚀 Funcionalidades

-   Consulta de marcas disponíveis
-   Consulta de modelos por marca
-   Consulta de anos disponíveis para um veículo
-   Consulta do valor atualizado de veículos
-   Suporte para:
    -   🚗 Carros
    -   🏍️ Motos
    -   🚚 Caminhões

------------------------------------------------------------------------

## 🧠 Fluxo da aplicação

    Usuário
       ↓
    Terminal (Console)
       ↓
    Aplicação Spring Boot
       ↓
    API Tabela FIPE
       ↓
    Processamento dos dados
       ↓
    Exibição dos resultados

------------------------------------------------------------------------

## 🛠️ Tecnologias utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

![Spring
Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

------------------------------------------------------------------------

## 📚 Conceitos aplicados

-   Consumo de API REST externa
-   Requisições HTTP utilizando Spring
-   Desserialização de JSON
-   Organização em camadas
-   Criação de serviços utilizando Spring Boot
-   Manipulação de coleções em Java
-   Entrada de dados via terminal

------------------------------------------------------------------------

## ▶️ Como executar o projeto

### Pré-requisitos

-   Java 17+
-   Maven

Clone o repositório:

``` bash
git clone https://github.com/pedrobuzolin/TabelaFipe.git
```

Entre na pasta:

``` bash
cd nome-do-repositorio
```

Execute o projeto:

``` bash
mvn spring-boot:run
```

------------------------------------------------------------------------

## 💻 Exemplo de utilização

A aplicação permite selecionar o tipo de veículo:

    Digite o tipo de veículo:
    1 - Carro
    2 - Moto
    3 - Caminhão

Em seguida, o usuário informa:

    Marca:
    Modelo:
    Ano:

A aplicação realiza a consulta na API FIPE e retorna os dados
encontrados.

------------------------------------------------------------------------

## 🔮 Possíveis melhorias

-   Criar uma API REST utilizando Spring Web
-   Persistir consultas realizadas em banco de dados
-   Criar testes automatizados
-   Criar uma interface web para consulta
-   Implementar tratamento global de exceções
