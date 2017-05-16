# fiap-spring-secretfriends

### spring mvc com spring boot (backend)

Projeto realizado utilizando spring mvc com spring boot. O objetivo do spring boot é prover um servidor auto embutido, facilitando o desenvolvimento e testes por terceiro, dessa forma basta executar o método main e o projeto já deve estar funcionando.

Todo projeto foi baseado em API, dessa forma um mesmo projeto pode ser utilizado em um celular (android, IOS, ...), uma televisão, tablet, entre outros...

### motivo da escolha (spring)

A escolha da stack foi feita com base em uma pesquisa na web que mostrou que spring mvc + spring boot é uns dos projetos/frameworks java mais utilizados na atualidade, com uma documentação bem completa e diversos artigos na internet com exemplos de como utilizar o framework. Fora a popularidade, foi o framework mais fácil de evoluir o projeto.

### vuejs (frontend)

Para desenvolvimento do frontend foi utilizado vuejs (vuejs.org). Uma forma elegante e simples de desacoplar o frontend do backend, já que o backend está feito todo baseado em api.

## Configurando o projeto

No diretório resources existe um arquivo chamado application.properties.dist. O mesmo deve ser renomeado para application.properties e configurá-lo. Nesse arquivo você deve informar os dados de conexão com banco de dados e porta para o servidor web funcionar.

## Criando um banco de dados mysql

Como pré requisito você precisa ter um banco de dados criado. Recomenda-se usar o mysql.
Para criar um banco no mysql você pode utilizar o comando `create database fiap_spring_secretfriends charset utf8`

As tabelas do banco serão criadas automaticamente pelo JPA após inicialização do projeto.

## Executando o projeto através do eclipse

Depois de importar o projeto para eclipse, basta executar o método main que está localizado em `com.github.dsaouda.fiap.spring.secretfriends.App`

Após execução basta acessar o navegador através do endereço http://localhost:8092/ (Obs: Se alterou as configuração do application.properties, use a configuração informada)

## Executando o projeto compilado

Realize download do jar em https://github.com/dsaouda/fiap-spring-secretfriends/releases/download/1.1.1/fiap-spring-secretfriends.zip, descompacte o zip baixado. Entre no diretório extraído. Configure a conexão com banco de dados no arquivo application.properties. Depois de configurado basta executar o arquivo startup.bat se estiver no windows ou startup.sh se estiver no linux ou mac. Acesse http://localhost:8092 para testar o sistema.

## Usando o sistema

[Clique aqui](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/USANDO_SISTEMA.md) para maiores informações de como usar o sistema

## Pacotes dos sistema

Para maiores informações sobre como o sistema está dividido [acesse aqui](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/spring-backend/README.md)
