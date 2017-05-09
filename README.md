# fiap-spring-secretfriends

### spring mvc com spring boot (backend)

Projeto realizado utilizando spring mvc com spring boot. O objetivo do spring boot é prover um servidor auto embutido, facilitando o desenvolvimento e testes por terceiro, dessa forma basta executar o método main e o projeto já deve estar funcionando.

### motivo da escolha

A escolha da stack foi feita com base em pesquisa na web e mostra-se que spring mvc + spring boot é uns dos projetos mais utilizados na atualidade, com uma documentação bem completa e diversos artigos na internet com exemplos de utilização do framework.

### vuejs (frontend)

Para desenvolvimento do frontend foi utilizado vuejs (vuejs.org). Uma forma elegante e simples de desacoplar o frontend do backend, já que o backend está feito todo baseado em api.

## Configurando o projeto

No diretório resources existe um arquivo chamado application.properties.dist. O mesmo deve ser renomeado para application.properties e configurá-lo. Nesse arquivo você deve informar os dados de conexão com banco de dados e porta para o servidor web funcionar.

## Criando um banco de dados mysql

Como pré requisito você precisa ter um banco de dados criado. Recomenda-se usar o mysql.
Para criar um banco no mysql você pode utilizar o comando `create database fiap_spring_secretfriends charset utf8`

As tabelas do banco serão criadas automaticamente pelo JPA.

## Executando o projeto

Para testar o projeto basta executar o método main que está localizado em `com.github.dsaouda.fiap.spring.secretfriends.App`

Após execução basta acessar o navegador através do endereço http://localhost:8092/

## Usando o sistema

[Clique aqui](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/USANDO_SISTEMA.md) para maiores informações de como usar o sistema
