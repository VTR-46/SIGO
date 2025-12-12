Demonstrar, de forma ampla e integrada, a compreensão sobre os principais conceitos de Programação Orientada a Objetos estudados ao longo do semestre.

O projeto deverá demonstrar domínio de:

Encapsulamento
Construtores e regras de negócio

Coleções e operações sobre listas

Herança e polimorfismo

Composição de objetos

Interfaces e classes de serviço

Organização em camadas (entities, services, application)

Boas práticas de escrita de código e uso adequado de pacotes


O projeto será dividido em duas etapas, cada uma publicada e desenvolvida em semanas distintas, permitindo acompanhamento da evolução.

Sistema Integrado de Gestão de Operações – SIGO

Você deverá desenvolver um sistema modular, organizado em pacotes e voltado a uma empresa fictícia que deseja informatizar três áreas internas:

Gestão de Produtos e Serviços
Gestão de Clientes e Reservas
Processamento Financeiro
Cada módulo utiliza e combina os conceitos estudados na disciplina.

O sistema completo deverá ser executado a partir de uma classe Main, exibindo menus e relatórios solicitados.

Semana 1 – Peso parcial: 25%

1. Estruturação do Projeto

Organize seu código em pacotes adequados, no mínimo:

model.entities
model.services
application
2. Módulo de Produtos (Herança + Polimorfismo + Encapsulamento)

Implemente um cadastro de produtos contendo três tipos:

ProdutoComum
ProdutoUsado (com data de fabricação)
ProdutoImportado (com taxa adicional)
Requisitos:

Encapsulamento completo (atributos privados + getters/setters quando fizer sentido).
Regras de negócio similares ao exercício 14 da lista avaliativa.
Método priceTag() polimórfico em cada tipo.
Criar uma rotina que:
leia N produtos,
armazene em uma lista,
imprima as etiquetas na mesma ordem da entrada.
3. Módulo de Controle de Produção (Encapsulamento + Regras de Negócio)

Crie a classe que representa uma máquina de produção:

atributos: nome, quantidadeProduzida, ativo, taxaDefeito (opcional), etc.
a quantidade produzida só pode ser alterada pelos métodos que registram produção.
impedir valores negativos.
Crie um menu que permita:

Registrar nova produção;
Exibir total produzido;
Exibir relatório resumido da máquina.
4. Módulo de Sensores (Encapsulamento + Validação)

Implemente um SensorTemperatura:

atributo temperatura sempre protegido por regras (faixa válida, por exemplo −20 a 200 °C);
métodos para registrar nova leitura;
impedir alterações diretas.
Crie uma classe que armazena vários sensores e exibe:

média das últimas leituras,
maior e menor temperatura registradas.
ENTREGAS DA ETAPA 1

Código completo dos módulos: Produtos, Produção e Sensores.
Projeto organizado em pacotes.
Uma classe Main capaz de demonstrar todas as funcionalidades.
Boa organização e clareza do código serão avaliados.
Semana 2 – Peso parcial: 25%

5. Módulo de Clientes e Reservas (Composição + Relacionamento entre Objetos)

Baseado no exercício 13 da lista.

Implemente:

Cliente (nome, email, data nascimento)
Reserva (data/hora, status)
Destino (nome, preço unitário)
ItemReserva (quantidade, destino)
Requisitos:

Um cliente pode ter várias reservas.
Cada reserva contém vários itens.
Exibir relatório completo contendo todos os dados.
É permitido instanciar dados via código (hard code), mas a apresentação deve ser organizada.
6. Módulo Financeiro (Interfaces + Polimorfismo + Serviços)

Baseado no exercício 17.

Crie:

classe Payment em model.entities
interface PaymentService em model.services com:
método abstrato fee(Payment)
método default netPayment(Payment)
implementações:
CardPayment
PixPayment
PromotionalPayment (sobrescreve netPayment)
A classe Main deve:

ler valor e descrição do pagamento;
permitir ao usuário escolher o método;
exibir resumo completo do processamento.
7. Módulo de Processamento de Contratos (Composição + Serviços + Datas)

Baseado no exercício 16.

Implemente:

Contract (número, data, valor)
Installment (data + valor)
ContractService para gerar parcelas
OnlinePaymentService (interface)
PaypalService como implementação
Requisitos:

aplicar juros de 1% ao mês + taxa de 2% por parcela;
gerar parcelas a partir da data do contrato;
exibir datas e valores formatados.
8. Integração Final do SIGO

A classe Main deverá oferecer um menu principal, permitindo executar cada módulo:

Gerenciar Produtos
Máquina de Produção
Sensores
Reservas
Pagamentos
Processamento de Contratos
Não é necessário integrar os módulos entre si — apenas disponibilizá-los no mesmo sistema e na mesma aplicação.
