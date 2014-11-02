sampleng-backend
================

Sample Angular Backen  

Trata-se de um projeto maven.  
Clone o repositório e importe o mesmo na sua IDE de preferência.  

Detalhes do projeto:
===================

## Java Packages ##
__ungp.sampleng.backend.entity__ estao as entidades (POJO) usados no sistema.  
__ungp.sampleng.backend.exception__ estao as excecoes e mapeadores de excecao para o Jersey  
__ungp.sampleng.backend.reposioty__ estão os repositórios (Spring) para acesso o mongo db  
__ungp.sampleng.backend.resource__ estão os endpoints REST  
__ungp.sampleng.backend.util__ estão os utilitarios  

## Banco de dados ##  
Usa uma instância de demonstracao do Mongodb provida pela mongolabs.  

## Testes ## 
 
  Os testes são realizados com JUnit e Jersey embarcado no servidor http leve Grizzly  

## Deploy ## 
 
 O deploy é realizado no heroku na conta UNGPublic  

__Passos realizados no Heroku__  
1) Definir SSL keys: ssh-keygen -t rsa heroku login heroku keys:add    
2) Criar a aplicacão: heroku create   
3) Enviar o projeto: git push heroku master  
4) Escalar um servidor: heroku ps:scale web=1  

__Jetty local__  
Da para rodar um Jetty local rodando o comando abaixo na raiz do projeto:  
java $JAVA_OPTS -jar server/jetty-runner.jar --port 8080 target/*.war