# Bootcamp Santander Java - Exercícios

Exercícios práticos de Java do Santander Bootcamp 2026 - AI Java Back-end.

## Fundamentos da Linguagem de Programação Java

### Exercício 01 - Idade

Escreva um código que receba o nome e o ano de nascimento de alguém e imprima na tela a seguinte mensagem:

```text
Olá "Fulano" você tem "X" anos
```

### Exercício 02 - Área do Quadrado

Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área e exiba na tela.

Fórmula:

```text
área = lado x lado
```

### Exercício 03 - Área do Retângulo

Escreva um código que receba a base e a altura de um retângulo, calcule sua área e exiba na tela.

Fórmula:

```text
área = base x altura
```

### Exercício 04 - Diferença de Idade

Escreva um código que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas.

## Como executar com Docker

### Exercício 01

```bash
docker compose run --rm java javac fundamentos-java/exercicio-01-idade/Main.java
docker compose run --rm java java -cp fundamentos-java/exercicio-01-idade Main
```

### Exercício 02

```bash
docker compose run --rm java javac fundamentos-java/exercicio-02-area-quadrado/Main.java
docker compose run --rm java java -cp fundamentos-java/exercicio-02-area-quadrado Main
```

### Exercício 03

```bash
docker compose run --rm java javac fundamentos-java/exercicio-03-area-retangulo/Main.java
docker compose run --rm java java -cp fundamentos-java/exercicio-03-area-retangulo Main
```

### Exercício 04

```bash
docker compose run --rm java javac fundamentos-java/exercicio-04-diferenca-idade/Main.java
docker compose run --rm java java -cp fundamentos-java/exercicio-04-diferenca-idade Main
```