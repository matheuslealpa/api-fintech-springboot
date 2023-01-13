## api-fintech-springboot

### Pré-requisitos

* Docker
* Docker composer
* Java 8
* Maven 3

### Execução local da aplicação

#### Passo 1 - Inicialização dos serviços

Abra o terminal e na _raiz do projeto_ `springboot-fintech-api` e executar:

> $ sudo docker-compose up --remove-orphans


#### Passo 2 - Execução do módulo backend

> $ mvn clean spring-boot:run

### Diagrama de classe

![domain.png](src%2Fsite%2Fdiagrams%2Fdomain.png)