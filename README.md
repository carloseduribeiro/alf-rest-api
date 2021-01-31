# Alf Rest API

API Rest em Java e Spring Framework para gerenciamento de provas e gabaristo da escola Alf.

## Como a API funciona?

A API terá os seguintes endpoints:

### ====== ALUNO ======

`POST/api/aluno`: cria um aluno.

**Bodyresquest:**

<code>
{
    "nome": "Carlos Eduardo Ribeiro",
    "media": 0.0
}
</code>

**Onde:**

`nome`: Nome do aluno;  
`media`: Media do aluno;

`GET/api/alunos?provas=`: retorna a lista de alunos cadastrados no banco. O atributo opcional "**provas**" do tipo boolean pode ser definido na url como *true* para retornar as respostas da prova, **por padrão ele é definido como false**.

`GET/api/aluno/{id}?provas=`: faz a consulta de um aluno pelo seu ID. O atributo opcionao "**provas**" do tipo boolean pode ser definido na url como *true* para retornar as respostas da prova, **por padrão ele é definido como false**.

`PUT/api/aluno/{id}/situacao`: calcula a nota e retorna a situação do aluno pelo id. (APROVADO/REPROVA/Ou se deu algum erro no calculo da nota). Além disso ele atualiza a sitação do usuário no banco.

`GET/api/aluno/aprovados`: retorna a lista de alunos aprovados.

### ====== PROVA ======

`POST/api/prova?id=`: cadastra uma prova informando id do aluno, o id da deve ser passado pelo parametro "id" na url que é opcional, ou no atributo id_aluno corpo da requisição e é **obrigatório** em uma das partes.

**Bodyresquest:**

<code>
{
    "id_aluno" : 1,
    "nota" : 0
}
</code>

**Onde:**

`id_aluno`: id do aluno que a prova pertence;  
`nota`: nota da prova;

`GET/api/prova?questoes=`: retorna todas as provas cadastradas, o atributo opcionao "**questoes" do tipo boolean pode ser definido na url como *true* para retornar as respostas da prova, **por padrão ele é definido como false**.

`GET/api/prova/{id}?questoes=` retorna uma prova pelo id, o atributo opcionao "**questoes**" do tipo boolean pode ser definido na url como *true*  para retornar as respostas da prova, **por padrão ele é definido como false**.

### ====== GABARITO ======

`POST/api/gabarito/resposta/prova?id={id_prova}`: cadastra a resposta de uma questao informando id da prova, o id da deve ser passado pelo parametro "id" na url que é opcional, ou no atriburo id_prova no corpo da requisição e é **obrigatório** em uma das partes.

**Bodyresquest:**

<code>
{
    "id_prova" : 2,
    "alternativa" : "a",
    "peso" : 1
}
</code>
v
`GET/api/gabarito`: retorna todos as questões gabaritos cadastradas.

`GET/api/gabaritos/prova/{id_prova}`: retorna todas as questões gabaritos pelo id da prova.

#### ====== QUESTOES ======

`GET/api/questao`: retorna todas as questoes cadastradas.

`GET/api/questao/prova/id`: retorna todas as questoes pelo id da prova.

`POST/api/questao/prova?id=`: cadastra uma nova questao de uma prova informando o id da prova. O id da deve ser passado pelo parametro "id" na url que é opcional, ou no corpo da requisição.

**Bodyresquest:**

<code>
{
    "id_prova" : 2,
    "alternativa" : "a"
}
</code>

**Onde:**

`id_prova`: id da prova que a questão pertence;  
`alternativa`: alternativa correta;
`peso`: peso da questao;


`POST/api/questao/prova/lista/{id_prova}`: cadastra uma lista de questões.

**Bodyresquest:**

<code>
[
    {
        "id_prova" : 2,
        "alternativa" : "a",
        "peso" : 2
    },
    {
        "id_prova" : 2,
        "alternativa" : "c",
        "peso" : 2
    },
    {
        "id_prova" : 2,
        "alternativa" : "d",
        "peso" : 2
    },
    {
        "id_prova" : 2,
        "alternativa" : "b",
        "peso" : 2
    },
    {
        "id_prova" : 2,
        "alternativa" : "e",
        "peso" : 2
    }
]
</code>

**Onde:**

`id_prova`: id da prova que a questão pertence;  
`alternativa`: alternativa correta;
`peso`: peso da questao;

### Execução