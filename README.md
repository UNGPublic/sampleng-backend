sampleng-backend
================
Sample Angular Backend Application

Trata-se de um projeto para experimentar tecnologias e auxiliar na definição de um stack para desenvolvimento de
 aplicações com tecnologias 'client side', tal como o AngularJS.


Detalhes do projeto:
===================

## Java Packages ##
__ungp.sampleng.backend.entity__ estao as entidades (POJO) usados no sistema.  
__ungp.sampleng.backend.exception__ estao as excecoes e mapeadores de excecao para o Jersey  
__ungp.sampleng.backend.reposioty__ estão os repositórios (Spring) para acesso o mongo db  
__ungp.sampleng.backend.resource__ estão os endpoints REST  
__ungp.sampleng.backend.util__ estão os utilitarios  

## Banco de dados ##  
Necessita do mongodb instalado na máquina local (provido em vm).

## Testes ##
  Os testes são realizados com JUnit e Jersey embarcado no servidor http leve Grizzly  

## Deploy ##
Para testes, configurar um server da IDE e realizar o deploy da app nele.  
O projeto já está preparado para ser enviado ao Heroku (cloud provider).  
Para enviar para o Heroku, crie uma conta no site heroku.com e realize as seguintes configurações:  

__Passos realizados no Heroku__
0. criar conta no site heroku.com  
1. ssh-keygen -t rsa heroku login heroku keys:add  
2. heroku create  
3. git push heroku master  
4. heroku ps:scale web=1  

__Jetty local__  
Da para rodar um Jetty local rodando o comando abaixo na raiz do projeto, após realizar um mvn install:  
java $JAVA_OPTS -jar server/jetty-runner.jar --port 8080 target/*.war  


