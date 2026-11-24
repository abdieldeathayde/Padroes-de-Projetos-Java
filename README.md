# Java Design Patterns Lab

Laboratório prático de **Padrões de Projeto (Design Patterns) com Java 21**, usando um cenário de pedidos e pagamentos para estudar como aplicar padrões clássicos em código organizado, extensível e de fácil manutenção.

> Projeto de estudo em evolução. Os exemplos são implementações didáticas e não integram gateways reais de pagamento nem persistência de dados.

## Objetivos

- Entender o propósito de cada padrão e o problema que ele resolve.
- Aplicar os padrões em um cenário próximo de uma aplicação comercial.
- Praticar orientação a objetos, composição, interfaces e responsabilidades bem definidas.
- Comparar implementações e refletir sobre extensibilidade, manutenção e testabilidade.

## Padrões implementados

| Padrão | Categoria | Onde está aplicado | Propósito no projeto |
|---|---|---|---|
| **Strategy** | Comportamental | `payment/factory/PaymentStrategy` e estratégias de pagamento | Permite variar a forma de pagamento sem concentrar toda a lógica em condicionais. |
| **Factory** | Criacional | `payment/factory/PaymentFactory` | Cria a estratégia de pagamento correspondente ao método escolhido. |
| **Builder** | Criacional | `order/builder/OrderBuilder` | Facilita construir pedidos passo a passo, com uma API fluente. |
| **Chain of Responsibility** | Comportamental | `order/validation` | Encadeia validadores para executar verificações de pedido em sequência. |

### Exemplos no domínio

- Pagamentos: PIX, cartão de crédito e boleto, por meio de estratégias distintas.
- Pedidos: construção de pedido com cliente e itens.
- Validação: verificações de e-mail do cliente e pedido com itens, encadeadas.

Alguns componentes de validação e serviço ainda estão em desenvolvimento (por exemplo, `QuantityValidator`, `StockValidator` e `OrderService`).

## Tecnologias

- Java 21
- Maven
- JUnit (testes)

## Estrutura

```text
src/
└── main/
    ├── java/
    │   ├── br/Main.java
    │   └── br/com/abdiel/patternslab/
    │       ├── order/
    │       │   ├── builder/       # Builder de pedidos
    │       │   ├── model/        # Pedido, itens e status
    │       │   ├── service/      # Serviços (em evolução)
    │       │   └── validation/   # Chain of Responsibility
    │       ├── payment/
    │       │   ├── factory/      # Factory, Strategy e formas de pagamento
    │       │   └── service/      # Serviço de pagamento
    │       ├── product/
    │       │   └── model/        # Produto
    │       └── shared/
    │           └── exception/    # Componentes compartilhados
    └── resources/
        └── application.yml
```

## Pré-requisitos

- JDK 21 instalado
- Maven instalado (ou Maven Wrapper, caso seja adicionado futuramente)
- IDE de sua preferência (IntelliJ IDEA, Eclipse ou VS Code com extensões Java)

Confira as versões:

```bash
java -version
mvn -version
```

## Como executar

Clone o repositório:

```bash
git clone https://github.com/abdieldeathayde/Padroes-de-Projetos-Java.git
cd Padroes-de-Projetos-Java
```

Compile o projeto:

```bash
mvn clean compile
```

Execute a classe `br.Main` pela sua IDE ou, após compilar, usando a configuração de execução da classe principal.

## Exemplo: Strategy + Factory

A classe `Main` seleciona PIX, solicita à Factory a estratégia correspondente e delega o processamento ao serviço:

```java
PaymentFactory factory = new PaymentFactory();
PaymentService service = new PaymentService(factory);

PaymentResult result = service.process(
    PaymentMethod.PIX,
    new BigDecimal("250.00")
);

System.out.println(result.message());
System.out.println("Valor: " + result.amount());
System.out.println("Sucesso: " + result.success());
```

Para experimentar outras opções, altere `PaymentMethod.PIX` para `PaymentMethod.CREDIT_CARD` ou `PaymentMethod.BOLETO`.

## Testes

O projeto contém um teste para o processamento de pagamento PIX. Execute os testes Maven:

```bash
mvn test
```

> A configuração atual do `pom.xml` e a localização/nomenclatura dos testes podem precisar de ajustes para que o Maven descubra e execute os testes automaticamente.

## Roadmap

- [ ] Completar validações de quantidade e estoque.
- [ ] Implementar o serviço de pedidos e integrar a cadeia de validação.
- [ ] Adicionar testes unitários para todos os padrões.
- [ ] Documentar diagramas UML e fluxos de execução.
- [ ] Explorar outros padrões GoF (Observer, Decorator, Adapter, Singleton e outros) com exemplos separados.
- [ ] Evoluir o projeto com boas práticas, refatorações e cenários mais realistas.

## Aprendizados

Este repositório é um espaço de experimentação para compreender não apenas **como** implementar padrões, mas também **quando** eles são úteis, quais benefícios oferecem e quais custos de complexidade podem trazer.

## Autor

**Abdiel de Athayde**  
GitHub: [@abdieldeathayde](https://github.com/abdieldeathayde)

---

Se este repositório for útil para seus estudos, fique à vontade para acompanhar sua evolução.
