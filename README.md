#  JBank - Sistema de Agência Bancária em Java

Uma simulação de operações bancárias desenvolvida em Java Puro, focada na aplicação prática de conceitos avançados de Orientação a Objetos, otimização de algoritmos e tratamento de erros.

---

## 🚀 Funcionalidades do Sistema

O sistema roda via terminal e simula de forma realista o fluxo de uma fintech ou agência bancária:
* **Cadastro de Clientes:** Criação de usuários com validação básica de dados.
* **Abertura de Conta com ID Automático:** Geração de número de conta sequencial controlado por atributos estáticos.
* **Depósitos e Saques:** Operações de movimentação de saldo com validações de segurança.
* **Transferências Eletrônicas:** Envio de valores entre contas cadastradas com atualização em tempo real de ambos os saldos.
* **Listagem Geral:** Exibição organizada de todas as contas e saldos formatados no padrão monetário brasileiro (R$).

---

## 🧠 Diferenciais Técnicos (O que este projeto demonstra?)

Para ir além de um exercício comum de lógica, o projeto foi estruturado com as melhores práticas de engenharia de software:

### 🧩 1. Otimização com HashMaps
Substituição da estrutura tradicional de `ArrayList` por um `HashMap<Integer, Conta>`. Isso reduz a complexidade de tempo de busca de contas de varredura linear para busca instantânea, garantindo que o sistema continue performático mesmo com milhões de contas criadas.

### ⚠️ 2. Tratamento de Erros com Exceptions Personalizadas
A lógica de negócio foi blindada usando exceções customizadas de aplicação (`SaldoInsuficienteException` e `ContaNaoEncontradaException`). O fluxo do programa é controlado com blocos `try/catch`, separando as regras de negócio das mensagens de exibição no terminal.

### 🏛️ 3. Padrões de Projeto e Boas Práticas
* **Construtor Privado:** Aplicado na classe `Utils` para evitar instanciações desnecessárias de classes de ferramentas.
* **Encapsulamento Estrito:** Todos os atributos protegidos por modificadores `private` e acessados estritamente via métodos *Getters* e *Setters*.
* **Reutilização de Código:** O método de transferência reutiliza o método de depósito, evitando duplicidade de código.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (versão 17 ou superior)
* **IDE utilizada:** Eclipse IDE
* **Versionamento:** Git e GitHub

---

## 👨‍💻 Autor

Desenvolvido por **Juan Estevan**, estudante de Análise e Desenvolvimento de Sistemas - UTFPR
