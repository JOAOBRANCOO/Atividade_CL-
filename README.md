Projeto de uma API em Java e Spring Boot para cadastrar ninjas e clãs.

Para rodar o projeto, precisa ter Java e PostgreSQL instalados.

O banco usado é local e se chama ninjas.

CREATE DATABASE ninjas;

Se a senha do PostgreSQL não for 123456, é só trocar no arquivo application.properties.

Depois é só abrir o projeto no IntelliJ, esperar o Maven carregar e rodar a classe NinjasApplication.

A aplicação fica em http://localhost:8080.

Também pode rodar pelo terminal:

mvnw.cmd spring-boot:run

O arquivo backup_ninjas.sql está junto com o projeto. Para restaurar o banco:

psql -U postgres -d ninjas -f backup_ninjas.sql

Rotas de ninjas:
POST /ninjas
GET /ninjas
GET /ninjas/id/{id}
GET /ninjas/nome/{nome}
PUT /ninjas/{id}
DELETE /ninjas/{id}

Exemplo de cadastro de ninja:

{
  "nome": "Naruto Uzumaki",
  "cpf": "529.982.247-25",
  "email": "naruto@konoha.com"
}

O CPF precisa ser válido.

Rotas de clãs:

POST /cla
GET /cla
GET /cla/id/{id}
GET /cla/nome/{nome}
GET /cla/descricao/{descricao}
PUT /cla/{id}
DELETE /cla/{id}

Exemplo de cadastro de clã:

{
  "nome": "Uchiha",
  "descricao": "Clã conhecido por suas técnicas oculares",
  "habilidade": "Sharingan"
}
