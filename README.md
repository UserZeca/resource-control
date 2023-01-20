# Resource Control (Back-end)

O projeto Resource Control (Back-end) é uma API REST de um sistema de controle de fluxo de recursos. A temática desse projeto é baseada em uma situação em que há a necessidade
de controle de tráfego de recursos por meio de administradores (ADMIN's) que terão a permissão de adicionar, remover, editar e acessar todos os recursos cadastrados,
além disso também existe a demanda que usuários comuns (USER's) possam acompanhar a movimentação de recursos. 

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

Consulte **[Implantação](#-implanta%C3%A7%C3%A3o)** para saber como implantar o projeto.

### 📋 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

- [Git](https://git-scm.com/downloads)
- [Node.js](https://nodejs.org/en/download/) (usei a versão mais recente 18.13.0)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
- [PostgreSQL (version 15.1)](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
- pgAdmin 4 (Vem junto com o download do PostgreSQL)
- [Postman](https://www.postman.com/downloads/)
- [Intellij](https://www.jetbrains.com/pt-br/idea/download/) (ou qualquer outra IDE)

### 🔧 Instalação/Configuração

- Clone o projeto via git

```Bash
# Clone este repositório
$ git clone https://github.com/UserZeca/resource-control

```

ou baixe-o diretamente pelo github.

- Abra o projeto em sua IDE 

### Com o projeto aberto:

- Abra o pdAdmin 4 (ou use a interface padrão do postgre via terminal/cmd) e crie um banco de dados com o nome "resource-control-db"
- Abra o arquivo application.properties e altere para sua senha do banco de dados

```bash
spring.datasource.url= jdbc:postgresql://localhost:5432/resource-control-db
spring.datasource.username=postgres
spring.datasource.password= COLOQUE SUA SENHA AQUI
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.jdbc.lob.lab.non_contextual_creation=true

```

- Execute a classe ResourceControlApplication 
- Execute o arquivo SQL "queryStartResourceControl" para carregar dados pré prontos
- Vá até o arquivo "WebSecurityConfig"


## ⚙️ Testando a aplicação

Para testar a Aplicação use o Postman, que permitirá realizar requisições GET, POST, DELETE e PUT.

Para começar use como padrão **username = "anna"** e **password= "senha123"**, é possivel cadastrar usuários comuns via endpoint porém usuários ADMIN
somente serão definidos via query diretamente no banco de dados.

Atenção: No postman você deve utilizar a aba authorization para adicionar o **username** e o **password** para ter acesso aos metodos. 

### 🔩 GET

 Rotas para obter dados de usuários e de alimentos (food).
 
```
# Rota para obter alimentos (USER e ADMIN tem acesso)
http://localhost:8080/food
http://localhost:8080/food/id do alimento

Rota para obter usuários (ADMIN tem acesso)
http://localhost:8080/user/search
http://localhost:8080/user/search/nome do usuário
```

### 🔩 POST

 Rotas para adicionar dados de usuários e de alimentos (food).
 
```
# Rota para adicionar alimentos (ADMIN tem acesso)
http://localhost:8080/food

Rota para postar usuários ( ADMIN tem acesso)

http://localhost:8080/user/signIn/create/

```


### 🔩 PUT

 Rotas para editar dados de usuários e de alimentos (food).
 
```
# Rota para editar alimentos (ADMIN tem acesso)
http://localhost:8080/food/id do alimento

Rota para editar acesso usuários do usuário(essa rota é necessaria pais o acesso ao usuaário é uma role separada da tabela usuário) (ADMIN tem acesso)
http://localhost:8080/user/signIn/create/


```


### 🔩 DELETE

 Rotas para editar dados de usuários e de alimentos (food).
 
```
# Rota para deletar alimentos (ADMIN tem acesso)
http://localhost:8080/food/id do alimento

Rota para editar acesso usuários do usuário(essa rota é necessaria pais o acesso ao usuaário é uma role separada da tabela usuário) (ADMIN tem acesso)
http://localhost:8080/user/nome do usuário


```


### ⌨️ Metodos que envolvem vinculo de chave estrangeira 

```

# Vincular alimento a algum usuário comum
http://localhost:8080/user/food/{id}/responsibleForTransport/{username}

```


## 📦 Implantação

Adicione notas adicionais sobre como implantar isso em um sistema ativo

## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [ROME](https://rometools.github.io/rome/) - Usada para gerar RSS

## 🖇️ Colaborando

Por favor, leia o [COLABORACAO.md](https://gist.github.com/usuario/linkParaInfoSobreContribuicoes) para obter detalhes sobre o nosso código de conduta e o processo para nos enviar pedidos de solicitação.

## 📌 Versão

Nós usamos [SemVer](http://semver.org/) para controle de versão. Para as versões disponíveis, observe as [tags neste repositório](https://github.com/suas/tags/do/projeto). 

## ✒️ Autores

Mencione todos aqueles que ajudaram a levantar o projeto desde o seu início

* **Um desenvolvedor** - *Trabalho Inicial* - [umdesenvolvedor](https://github.com/linkParaPerfil)
* **Fulano De Tal** - *Documentação* - [fulanodetal](https://github.com/linkParaPerfil)

Você também pode ver a lista de todos os [colaboradores](https://github.com/usuario/projeto/colaboradores) que participaram deste projeto.

## 📄 Licença

Este projeto está sob a licença (sua licença) - veja o arquivo [LICENSE.md](https://github.com/usuario/projeto/licenca) para detalhes.

## 🎁 Expressões de gratidão

* Conte a outras pessoas sobre este projeto 📢;
* Convide alguém da equipe para uma cerveja 🍺;
* Um agradecimento publicamente 🫂;
* etc.


---
⌨️ com ❤️ por [Armstrong Lohãns](https://gist.github.com/lohhans) 😊
