const porta = 3003;

const express = require("express");
const app = express();
const bodyParser = require("body-parser"); //converte o que está vindo da requisicao post em objeto
const bancoDeDados = require("./bancoDeDados");

// app.use((req, res, next) => {
//     console.log("Middleware que atende qualquer url ....");
//     next();
// });

// app.get("/produtos", (req, res, next) => {
//     console.log("Middleware 1....");
//     next();
// });

// app.get("/produtos", (req, res, next) => {
//     res.send({ nome: "Notebook", preco: 2999.00 }); //Converter para JSON
// });

//Intercepta toda requisição e ve se é urlencoded, se sim, trata ela. Função Middleware
app.use(bodyParser.urlencoded({ extended: true }));

app.get("/produtos", (req, res) => {
    res.send(bancoDeDados.getProdutos());
});

app.get("/produtos/:id", (req, res) => {
    res.send(bancoDeDados.getProduto(req.params.id));
});

app.post("/produtos", (req, res) => {
    const produto = bancoDeDados.salvarProduto({
        nome: req.body.nome,
        preco: req.body.preco
    });
    res.send(produto);
});

app.put("/produtos/:id", (req, res) => {
    const produto = bancoDeDados.salvarProduto({
        id: req.params.id,
        nome: req.body.nome,
        preco: req.body.preco
    });
    res.send(produto);
});

app.delete("/produtos/:id", (req, res) => {
    const produto = bancoDeDados.excluirProduto(req.params.id);
    res.send(produto);
});

app.listen(porta, () => {
    console.log(`Servidor está rodando na porta ${porta}`);
});