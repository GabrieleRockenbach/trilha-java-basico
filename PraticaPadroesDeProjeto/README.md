# Projeto Logger

## Finalidade

Este projeto tem como objetivo criar um **Logger** simples em Java usando o padrão de projeto **Singleton**. A função principal deste Logger é registrar mensagens de log em um arquivo de texto (`log.txt`). 

### O que é um Logger?

Um Logger é uma ferramenta usada em programação para registrar eventos que acontecem enquanto um programa está sendo executado. Esses registros são úteis para depuração (debugging), análise de erros e monitoramento do comportamento do programa.

### O que é o padrão Singleton?

O padrão Singleton é um padrão de design que garante que uma classe tenha apenas uma instância durante a execução do programa. Isso é útil para recursos que devem ser compartilhados globalmente, como nosso Logger.

## Como Funciona?

1. **Criação da Instância Única**:
   - O Logger é implementado como uma classe Singleton. Isso significa que apenas uma instância do Logger será criada e usada por toda a aplicação.

2. **Registrar Mensagens**:
   - Quando você precisa registrar uma mensagem, você chama o método `getInstance()` para obter a instância única do Logger.
   - Em seguida, você usa o método `log(String message)` para registrar sua mensagem no arquivo `log.txt`.

### Exemplo de Uso

Aqui está um exemplo simples de como usar o Logger:

```java
public class Main {
    public static void main(String[] args) {
        // Obtém a instância única do Logger
        Logger logger = Logger.getInstance();
        
        // Registra mensagens de log
        logger.log("Esta é uma mensagem de log.");
        logger.log("Outra mensagem de log.");
    }
}
