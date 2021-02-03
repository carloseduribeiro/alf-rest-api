# Alf Rest API

API Rest em Java e Spring Framework para gerenciamento de provas e gabaristo da escola Alf.

## Como a API funciona?

A API terá os seguintes endpoints:

### ====== ALUNO ======

* `POST/api/alunos`: cria um aluno.

**Corpo da requisição:**  

<code>
{
    "nome": "Carlos Eduardo Ribeiro"
}
</code>

**Onde:**  

`nome`: Nome do aluno;

* `GET/api/alunos/{id}`: retorna os dados de um aluno pelo id.  

**Resposta:**  

<code>
{
    "id": 1,
    "nome": "asdfas",  
    "media": 0.0,
    "situacao": "NÃO CALCULADO",
    "provas" : []
}
</code>

**Onde:**

`id` : id do aluno;
`nome` : nome do aluno;
`media` : média (Se for igual a 0.0 ela ainda não foi calculada);
`situacao` : situação do alunon (pode ser APROVADO, REPROVADO E NÃO CALCULADA);
`provas` : lista com todas as provas do aluno;

* `GET/api/alunos`: retorna todos os alunos cadastrados.

**Resposta:**

<code>
[
    {
        "id": 1,
        "nome": "Carlos Eduardo",
        "media": 0.0,
        "situacao": "NÃO CALCULADO",
        "provas" : []
    },
    {
        "id": 2,
        "nome": "José Luiz",
        "media": 0.0,
        "situacao": "NÃO CALCULADO",
        "provas" : []
    },
    {
        "id": 3,
        "nome": "Lucas Raimundo",
        "media": 0.0,
        "situacao": "NÃO CALCULADO",
        "provas" : []
    }
}
</code>


### Execução