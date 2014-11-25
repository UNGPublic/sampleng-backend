#language: pt
Funcionalidade: Infração

  Contexto: 
    Dado Um veiculo com placa "ABC0123" e renavam "5451355435453"
    E um proprietario com  cpf "11122233344" e nome "John Java" e cnh "1234567890"
    E com o logradouro com id "1" e descricao "Rua das Acacias"  e cep "88030000" e tipo de logradouro "Rua"
    E com as seguintes infracoes:
      | id | proprietario | logradouro | data da infracao |
      | 1  | 11122233344  | 88030000   | 25/11/2014       |
      | 2  | 11122233344  | 88030000   | 22/11/2014       |

  Cenario: Buscar infracao com id 1
    Quando buscar infracao com id = 1
    Entao o sistema deve retornar a infracao:
      | id | proprietario | logradouro | data da infracao |
      | 1  | 11122233344  | 1          | 25/11/2014       |
