# 1. Usando o sistema

Abaixo alguns printscreen com passo a passo de como utilizar o sistema.

## 1.1 Login

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/login.jpg?raw=true)

Caso você não tenha um usuário cadastrado, clique no botão "cadastra-se aqui". Caso já tenha um usuário informe no campo e-mail e senha.

## 1.2 Cadastrar um novo usuário

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/cadastro.jpg?raw=true)

Basta informar os campos necessário para ter um novo usuário no sistema. Após realizar o cadastro você pode realizar o login.

## 1.3 Grupos administrando

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/grupo_listagem.jpg?raw=true)

Após realizar login uma listagem com os grupos que você está administrando será exibida. Para cadastrar um novo grupo de amigo secreto basta clicar no botão Novo grupo (seção 1.4). Após cadastrar um novo grupo você pode convidar os participantes clicando no botão ao lado do nome do grupo (seção 1.5).

## 1.4 Cadastrando novo grupo

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/grupo_cadastro.jpg?raw=true)

Na imagem acima existe um exemplo de como realizar o cadastro da tela. Os campos com * são obrigatórios. A data do evento deve ser maior do que a data do sorteio. Qualquer informação inválida será validada.

## 1.5 Convidando participantes para o amigo secreto

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/convite.jpg?raw=true)

Para enviar um novo convite você precisa informar o email do participante e clicar no botão "enviar convite". Abaixo são exibidos os convites enviados com seus respectivos status (aprovado ou rejeitado pelo convidado)

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/convites_adm_status.jpg?raw=true)


## 1.6 Convites recebidos

Um usuário que recebe o convite terá acesso aos convites através do menu "Convites"
Abaixo você pode visualizar um exemplo de um convite recebido.

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/convites_recebidos.jpg?raw=true)

Clicando no botão de informações ao lado da data você tem mais informações sobre o convite e grupo que você foi convidado a participar.

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/convites_recebidos_detalhe.jpg?raw=true)

## 1.7 Grupos participando

Na opção do menu grupos -> participando, você terá acesso aos grupos de amigo secreto que foi convidado a participar e você aceitou o convite. Nessa tela você consegue ver mais informações do grupo, como data do evento, data do sorteio, o seu amigo secreto, entre outras informações. Abaixo um exemplo.

![](https://github.com/dsaouda/fiap-spring-secretfriends/blob/master/docs/screenshot/thumb/grupo_participando.jpg?raw=true)

## 1.8 O Sorteio

O sorteio é realizado automaticamente após a data informada no cadastro do grupo for atingida. Existe uma task no sistema que de 5 em 5 segundos executa uma busca por grupos que precisam que o sorteio seja realizado. Caso o número de participantes seja 1 ou zero o sorteio irá falhar.