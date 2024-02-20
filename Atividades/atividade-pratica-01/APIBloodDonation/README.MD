# Sistema de Doação de Sangue - API REST

## Descrição:

API REST desenvolvida em Java 17 e Spring Boot 3.2.2 para gerenciar um sistema de doação de sangue. O projeto utiliza PostgreSQL como banco de dados e Docker para containerização.

## Tecnologias:

- Java 17
- Spring Boot 3.2.2
- Docker
- PostgreSQL

## Como subir a aplicação:

### Instalar o Docker Desktop:

- Acesse [https://www.docker.com/get-started](https://www.docker.com/get-started) e siga as instruções para instalar o Docker Desktop em seu sistema operacional.

### Criar o container PostgreSQL:

- Abra o terminal ou prompt de comando e execute o seguinte comando:

- bash
`docker run --name blood-donation -e POSTGRES_PASSWORD=12345 -p 5432:5432 -d postgres`

- Explicação do comando:
* -name blood-donation: define o nome do container como "blood-donation".
* -e POSTGRES_PASSWORD=12345: define a senha do usuário "postgres" como "12345".
* -p 5432:5432: mapeia a porta 5432 do container para a porta 5432 do host.
* -d: inicia o container em segundo plano.
* postgres: a imagem do Docker a ser utilizada.

## Configurar o arquivo application.properties:

Abra o arquivo application.properties no Intellij IDEA ou outro IDE de sua preferência.
Altere as propriedades `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` de acordo com o seu ambiente:

`spring.datasource.url=jdbc:postgresql://localhost:5432/blood_donation`
`spring.datasource.username=postgres`
`spring.datasource.password=12345`

## Subir a aplicação:
No Intellij IDEA, clique no botão verde "Run" ou utilize o atalho Ctrl+Shift+F10.
A aplicação será iniciada no servidor Spring Boot na porta 8080.

## Testar a API:
Utilize ferramentas como Postman ou Insomnia para enviar requisições HTTP para a API.
Consulte a documentação da API para saber quais endpoints estão disponíveis e como utilizá-los.

## Observações:
A senha do usuário "postgres" pode ser alterada para uma senha mais segura.
O arquivo application.properties pode ser configurado para utilizar outros bancos de dados, como MySQL ou Oracle.