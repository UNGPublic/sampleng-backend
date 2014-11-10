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
 







