# Sistema de Compras em Java

## Sobre o Projeto

Este projeto é um sistema de compras desenvolvido em Java com o objetivo de praticar e consolidar conceitos de POO, além de simular um fluxo real de um sistema de e-comerce.

A aplicação roda no terminal e permite que o usuário interaja com o sistema, escolhendo produtos, controlando quantidades, gerenciando o carrinho e finalizando a compra com diferentes formas de pagamento.

---

## Funcionalidades

- Visualizar os produtos disponíveis
- Adicionar produtos ao carrinho com quantidade
- Remover produtos do carrinho parcialmente ou totalmente
- Visualizar o carrinho atualizado em tempo real
- Ver o total de compra antes de finalizar
- Escolha de pagamento (Pix ou Cartão):
  - Pix (à vista)
  - Cartão (À vista ou parcelado)
- Finalizar a compra e visualizar um resumo do pedido

---

## Tecnologias Utilizadas

- Java 21
- IntelliJ
- Maven
- Git / GitHub

---

## Conceitos praticados 

Este projeto foi desenvolvido com foco em aplicar na prática:

- Encapsulamento
- Herança 
- Polimorfismo
- Abstração
- Manipulação de listas
- Estrutura de dados para representar carrinho
- Validação de entrada do usuário
- Regras de negócio

---

## Estrutura do projeto

O projeto foi organizado em pacotes para melhor separação de responsabilidades:

- `app` : Contém a classe principal (`Main`) responsável pelo fluxo da aplicação
- `model` : Contém as entidades e regras de negócio como `Carrinho`, `Produto`, `Pedido` etc.
- `pagamento` : Contém as implementações de pagamento (Pix e Cartão)

---

## Decisões de implementação

Algumas decisões foram tomadas pensando em aproximar o projeto de um cenário real:

- Criação da classe `ItemCarrinho` para agrupar produtos e quantidade, evitando duplicação
- Separação da lógica de pagamento através de interface (Pagamento)
- Validação de entrada do usuário para evitar que o sistema quebre
- Controle de estoque diretamente na adição ao carrinho
- Organização do código visando legibilidade e manutenção

---

## Exemplo de uso

```Escolha uma opção: 
1 - Adicionar produto
2 - Remover produto
0 - Finalizar

Carrinho atual:

Mouse Scorpion x2 - R$ 237.87

Total da compra : R$ 475.74

Pagamento no cartão
Parcelado em 2x de R$ 237.87

Resumo do pedido:
Mouse Scorpion x2 - R$ 237.87
```

---

## Possíveis melhorias

- Interface gráfica (GUI)
- Persistência de dados (banco de dados)
- Testes unitários
- Separação em camadas (service)
- API REST com Spring Boot

---

## Nota Pessoal

Esse projeto foi desenvolvido como parte do meu processo de transição de carreira para a área de desenvolvimento.

Durante a construção, enfrentei desafios relacionados à lógica, estruturação do código e organização das responsabilidades entre as classes. Ao longo do desenvolvimento, fui ajustando o projeto para torná-lo mais próximo de um sistema real, melhorando validações, estrutura e clareza.