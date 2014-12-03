Sample Angular Backend Application
==================================

## O que é  
Trata-se de um projeto para experimentar tecnologias e auxiliar na definição de um stack para desenvolvimento de
 aplicações com tecnologias 'client side', tal como o AngularJS.  
 
## Pré-requisitos  
 - Instalação da VM com base nas orientações dispoíveis neste repositório https://github.com/ungppublic/vagrant.  
 - IDE com suporte a maven
  
## Instruções  
- Ao instalar a VM, conforme os pré-requisitos acima, você terá disponível um ambiente pronto para realizar o deploy do aplicativo backend.
- Realize o clone, ou checkout se contribuidor, deste projeto e importe na IDE de sua preferência.
- Para publicar o projeto no Tomcat da VM, execute o seguinte comando: __mvn clean install cargo:redeploy__
- Acesse __http://localhost:18080/sample/res/__ para obter o WADL e um JSON de exemplo

## Segurança
- O mecanismo de segurança para o aplicativo backend foi definido utilizando o _Jasig CAS_ http://jasig.github.io/cas/4.0.0/index.html.
- Para realizar a chamada dos serviços REST é necessário realizar o processo de autenticação (login/senha) no CAS.
- O usuário padrão para realizar este acesso é _*"casuser"*_ e a senha padrão é _*"Mellon"*_.
- Após realizar o processo de autenticação, os serviços REST poderão ser executados utilizando um aplicação de frontend ou um cliente REST.
- Existem alguns clientes REST disponível para teste.
- _REST-Easy_ add-on para Mozila Firefox. https://addons.mozilla.org/en-US/firefox/addon/rest-easy/
- _Postman_ Google Chrome plugin. https://chrome.google.com/webstore/detail/postman-rest-client/fdmmgilgnpjigdojojpjoooidkmcomcm?hl=en







