# Sistema de Bilheteria - Rede de Cinemas

Sistema em Kotlin que simula a venda de ingressos de uma rede de cinemas: calcula o valor para múltiplos assentos, aplica meia-entrada e gerencia vouchers opcionais de pipoca.

Aluna: Eduarda Paiva

## Classes

- Filme: título, gênero e valor base
- Ingresso: filme, assento, se é estudante (eEstudante) e o cálculo do valor
- Cliente: nome e voucher de pipoca (opcional)

## Regras de negócio

- Múltiplos ingressos (for): o total é a soma dos ingressos do carrinho
- Meia-entrada (if/else): estudante (eEstudante == true) paga 50% do valor base
- Voucher de pipoca (Null Safety): campo String?; se for nulo, o operador Elvis (?:) registra "Sem brinde"
- Classificação (when): a recomendação etária é exibida de acordo com o gênero do filme

## Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Variáveis Int, Double, Boolean e String
- Condicionais if/else e when
- Laço for
- Null Safety com String? e operador Elvis

## Estrutura

```
bilheteria-cinema/
├── src/
│   └── Main.kt
└── README.md
```

## Como executar

1. Clone ou baixe este repositório
2. Abra a pasta no IntelliJ IDEA
3. Abra o arquivo `src/Main.kt`
4. Execute a função `main`

## Saída esperada

```
Cliente: Ana
  Assento A1 | Super Aventura (Animação, Livre) | Meia | R$ 15.00
  Assento A2 | Super Aventura (Animação, Livre) | Inteira | R$ 30.00
  Ingressos: 2
  Total: R$ 45.00
  Brinde: Pipoca média grátis

Cliente: Bruno
  Assento C5 | Noite Sombria (Terror, 16 anos) | Inteira | R$ 40.00
  Assento C6 | Noite Sombria (Terror, 16 anos) | Meia | R$ 20.00
  Assento C7 | Noite Sombria (Terror, 16 anos) | Meia | R$ 20.00
  Ingressos: 3
  Total: R$ 80.00
  Brinde: Sem brinde
```
