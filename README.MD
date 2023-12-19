# Beneficiário API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

Esse projeto é uma Api que ultiliza **Java, Spring Boot 3 e H2 como database.**

Essa API foi desenvolvida para akan usando Java Spring boot 3.

## Table of Contents

- [Instalação](#instalação)
- [Configuracao](#configuração)
- [Usando](#usando)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Installation

1. Clone o repositorio:

```bash
git clone https://github.com/RafaelNeves199/ekan_api.git
```

2. Instale as dependencias com o maven

1. mvn clean install
2. mvn spring-boot:run

## Usando

1. Start the application with Maven
2. A API está acessivel pelo http://localhost:8080/
3. O H2 Consele está acessivel pelo http://localhost:8080/h2-console/ - login: sa / password: password
4. Swagger-ui http://localhost:8080/swagger-ui.html


## API Endpoints
Essa API prove os seguintes endpoints:
**`Autenticação`**

**`Login`**
```markdown
POST /api/auth/login - Efetue o login com usuário já cadastrado para receber o token. user: ekan - password: 12345
```
```json
{
  "login": "ekan",
  "password": "12345"
}
```

**`Registrar`**
```markdown
POST /api/auth/registrar - Endpoint para registrar usuários que vao usar o sistema.
```
```json
{
  "login": "ekan",
  "password": "12345",
  "role": "USER"
}
```

**`Beneficiarios API`**

**`GET BENEFICIARIOS`**
```markdown
GET /api/beneficiarios - Endpoint que Traz uma lista com todos os beneficiários.
```
```json
[
  {
    "id": 1,
    "nome": "Rafael Soares",
    "telefone": "11948484848",
    "dataNascimento": "1980-02-17",
    "dataInclusao": "2023-12-19T12:14:17.95239",
    "dataAtualizacao": "2023-12-19T12:14:17.95239"
  },
    {
    "id": 2,
    "nome": "Joao da Silva",
    "telefone": "11948484848",
    "dataNascimento": "1981-07-15",
    "dataInclusao": "2023-12-19T12:14:17.95239",
    "dataAtualizacao": "2023-12-19T12:14:17.95239"
  }
]
```

**`POST BENEFICIARIOS`**
```markdown
POST /api/beneficiarios - Endpoint para registrar um novo beneficiário com seus documentos
```
```json
{
  "nome": "Rafael Neves",
  "telefone": "11948484848",
  "dataNascimento": "17/02/1980",
  "documentos": [
    {
      "tipoDocumento": "CPF",
      "descricao": "29184526888"
    }
  ]
}
```

**`PUT BENEFICIARIOS`**
```markdown
PUT /api/beneficiarios/{id} - Endpoint para atualizar o Beneficiario
```

```json
{
  "nome": "Rafael",
  "telefone": "11948464648",
  "dataNascimento": "2023-12-19",
  "documentos": [
    {
      "tipoDocumento": "RG",
      "descricao": "303044545"
    }
  ]
}
```

**`DELETE BENEFICIARIO`**
```markdown
DELETE /api/beneficiarios/{id} - Endpoint para deletar Beneficiario
```

**GET DOCUMENTOS BENEFICIARIO**
```markdown
get /api/beneficiarios/{idBeneficiario}/documentos - Endpoint para listar todos os documentos de um beneficiário a partir de seu id
```

## Database
The project utilizes [H2 Database](https://www.h2database.com/html/tutorial.html) as the database. 