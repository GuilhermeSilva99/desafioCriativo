# desafioCriativo
Se liga nas orientações:

PARA BACKEND:
1. O desafio é a criação de um micro serviço com uma API para encurtar URLs que deverá seguir o padrão REST.

 

2. Ao cadastrar uma URL, é necessário retornar uma outra URL encurtada que, ao ser acessada, redireciona o usuário para a URL original.

3.Além da API base, deve ser feita a criação de um endpoint de estatísticas de acesso às URLs geradas.

4. Os testes do código também devem ser implementados.


O desafio deve ser feito utilizando Kotlin ou Java com framework Spring.



O envio pode ser feito com um link de repositório Git.


# Usando o postman para ter acesso a API

## Para cadastrar uma url
método: POST <br/>
caminho: http://localhost:8080/url <br/>
exemplo de json: <br/>
{ <br/>
    "nome": "https://www.ufape.com/" <br/>
} <br/>

## Para acessar a Url
método: GET <br/>
caminho: http://localhost:8080/url/<codigo gerado pelo micro serviço> <br/>


## Para acessar as estatisticas
método: GET <br/>
caminho: http://localhost:8080/url/estatisticas <br/>
