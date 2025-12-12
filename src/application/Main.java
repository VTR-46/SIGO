package application;

import model.entities.*;
import model.entities.enums.ReserveStatus;
import model.entities.enums.SensorStatus;
import model.services.ContractService;
import model.services.PaymentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hrt = DateTimeFormatter.ofPattern("HH:mm:ss");

        double TAX = 50;    //TAXA que sera somada ao produto importado

        List<ComumProduct> list = new ArrayList<>();    //LISTA DOS PRODUTOS
        List<Client> clients = new ArrayList<>();

        //MAQUINA
        ProductionMachine machine = new ProductionMachine("Maquina A1D1", 0, true, 0);

        //SENSOR
        SensorsNotation sensorsNotation = new SensorsNotation(0, 0, 0);


        int op;
        int opX = 0;

        do {
            menuGPS();
            op = sc.nextInt();

            switch (op) {
                case 1:                         //PRODUTOS
                    System.out.println("Quantos produtos de seja adicionar?");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nome do produto:");
                        sc.nextLine();
                        String name = sc.nextLine();

                        System.out.println("Preço do Produto");
                        double value = sc.nextDouble();

                        System.out.println("Digite a quantidade");
                        int amount = sc.nextInt();

                        System.out.println("Tipo do produto (COMUM[c] | IMPORTADO[i] | USADO[u]) ");
                        char type = sc.next().charAt(0);

                        //U = USADO, I = IMPORTADO, C = COMUM
                        if (type == 'u' || type == 'U') {
                            System.out.println("Qual a data de fabricação do produto usado?");
                            LocalDate date = LocalDate.parse(sc.next(), fmt);

                            list.add(new UsedProduct(amount, value, name, date));

                        } else if (type == 'i' || type == 'I') {
                            list.add(new ImportedProduct(amount, value, name, TAX));
                        } else if (type == 'c' || type == 'C') {
                            list.add(new ComumProduct(amount, value, name));
                        }


                    }

                    //Lista dos produtos
                    System.out.println("Lista:");
                    for (ComumProduct product : list) {
                        product.priceTag();
                    }

                    break;

                case 2:         //MAQUINA/PRODUÇÃO

                    do {

                        MachineMenu();
                        opX = sc.nextInt();

                        switch (opX) {
                            case 1:
                                System.out.println("Digite a quantidade que sera produzida");
                                int p = sc.nextInt();

                                if (machine.NegativeRule(p) == true) {      //Validação


                                    for (int i = 0; i < p; i++) {
                                        System.out.println("Nome:");
                                        sc.nextLine();
                                        String nmMP = sc.next();

                                        ManuProduct manuProduct = new ManuProduct(nmMP);

                                        System.out.println(nmMP + ", Foi produzido(a).");
                                        machine.addProduct(manuProduct);
                                        machine.increaseProductAmount(1);
                                        machine.increaseDamege();   //TAXA DE DEFEITO SENDO AUMENTADA A CADA PRODUÇÃO
                                    }
                                    break;
                                } else {
                                    System.out.println("VALOR INVALIDO!!!");
                                    break;
                                }
                            case 2:
                                System.out.println("Total Produzido: " + machine.getProduced());
                                break;

                            case 3:
                                System.out.println("Relatorio:");
                                System.out.println(machine);
                                break;

                        }

                    } while (opX != 0);
                    break;

                case 3:             //SENSORES
                    do {
                        scanerMenu();
                        opX = sc.nextInt();

                        switch (opX) {
                            case 1:                 //Criação de um novo sensor | Creating a new sensor
                                boolean ok = false;

                                System.out.println("Nome do novo sensor: ");
                                String sName = sc.next();

                                double sTemp = 0;
                                do {

                                    System.out.println("Sua temperatura atual:");
                                    sTemp = sc.nextDouble();



                                    if (sensorsNotation.ValidTemperature(sTemp) == false){  //Validação da temperatura | Temperature validation
                                        System.out.println("TEMPERATURA INVALIDA!!!");
                                        ok = false;
                                    }else {
                                        ok = true;
                                    }
                                }while (ok != true);

                                LocalDateTime dateTime = LocalDateTime.now();
                                String dateTimeF = dateTime.format(fmt);

                                System.out.println("Status ([A]-ATIVO / [D]-DESATIVADO)");
                                sc.nextLine();
                                char statusop = sc.next().charAt(0);

                                SensorStatus status = null;

                                ok = false;
                                do {
                                    if (statusop == 'a' || statusop == 'A') {

                                        status = SensorStatus.ACTIVE;
                                        ok = true;

                                    } else if (statusop == 'd' || statusop == 'D') {

                                        status = SensorStatus.DISABLE;
                                        ok = true;

                                    }else {
                                        ok = false;
                                    }
                                }while (ok != true);

                                TemperatureSensor temperatureSensor = new TemperatureSensor(sName, dateTimeF, status, sTemp);

                                sensorsNotation.addSensor(temperatureSensor);

                                break;

                            case 2:                     //Visualizar todos os sensores | View all sensors
                                sensorsNotation.List();
                                break;

                            case 3:                     //Dados de media maiores e menores temperaturas entre todos os sensores | Average temperature data from all sensors
                                sensorsNotation.averageCalc();
                                sensorsNotation.Bigger();
                                sensorsNotation.Smaller();
                                System.out.println(sensorsNotation);




                        }

                    }while (opX != 0);
                    break;

                case 4:

                    System.out.println("Nome do cliente:");
                    String clientName = sc.next();

                    System.out.println("Email do cliente: ");
                    String email = sc.next();

                    System.out.println("Data de nascimento:");
                    LocalDate birth = LocalDate.parse(sc.next(), fmt);

                    Client client = new Client(clientName, birth, email);

                    System.out.println("Quantidade de reservas do cliente " + clientName + ":");
                    int reservesAmount = sc.nextInt();

                    for (int i = 0; i < reservesAmount; i++) {

                        System.out.println("Data da reseva:");
                        LocalDate rDate = LocalDate.parse(sc.next(), fmt);

                        System.out.println("Horario da reserva:");
                        LocalTime rTime = LocalTime.parse(sc.next(), hrt);

                        System.out.println("Status da reserva (PENDENTE, CANCELADA, CONFIRMADA): ");
                        ReserveStatus status = ReserveStatus.valueOf(sc.next());

                        Reserve reserve = new Reserve(rDate, rTime, status, client);

                        System.out.println("Quantos itens essa reserva possui:");
                        int in = sc.nextInt();

                        for (int j = 0; j < in; j++) {
                            System.out.println("Nome do destino:");
                            String dName = sc.next();

                            System.out.println("Preço unitario: ");
                            double dPrice = sc.nextDouble();

                            Destination destination = new Destination(dName, dPrice);

                            System.out.println("Quanidade: ");
                            int dAmount = sc.nextInt();

                            ReserveItem reserveItem = new ReserveItem(dAmount, destination);

                            reserve.addItem(reserveItem);
                        }

                        System.out.println(reserve);
                    }

                    break;

                case 5:
                    System.out.println("=== Sistema de Processamento de Pagamentos ===");
                    System.out.println("Descrição do pagamento:");
                    sc.next();
                    String descP = sc.nextLine();
                    System.out.println("Valor do pagamento:");
                    double amountP = sc.nextDouble();
                    LocalDate paymantDate = LocalDate.now();

                    Payment payment = new Payment(amountP, descP, paymantDate);

                    System.out.println("Escolha o metodo de pagamento [1]-Pix [2]-Cartão [3]-Promicional| :");
                    int pyOp = sc.nextInt();

                    double taxP = 0;
                    PaymentService paymentService = null;
                    if (pyOp == 1){
                        payment.setPaymentType("Pix");
                        paymentService = new PixPayment();
                        taxP = paymentService.fee(payment);

                    } else if (pyOp == 2) {
                        payment.setPaymentType("Cartão");
                        paymentService = new CardPayment();
                        taxP = paymentService.fee(payment);
                    } else if (pyOp == 3) {
                        payment.setPaymentType("Promocional");
                        paymentService = new PromotionalPayment();
                        taxP = paymentService.fee(payment);
                    }

                    payment.setTax(taxP);
                    double af = paymentService.netPayment(payment);
                    payment.setFinalAmount(af);

                    System.out.println(payment);
                    break;
                case 6:
                    System.out.println("Entre os dados do contrato >>");

                    System.out.print("Numero: ");
                    int number = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Data (dd/MM/yyyy): ");
                    LocalDate date = LocalDate.parse(sc.nextLine(), fmt);

                    System.out.print("Valor do contrato: ");
                    double totalValue = sc.nextDouble();

                    Contract contract = new Contract(number, totalValue, date);

                    System.out.print("Entre com o numero de parcelas: ");
                    int months = sc.nextInt();

                    ContractService cs = new ContractService(new PaypalService());
                    cs.processContract(contract, months);

                    System.out.println("Parcelas:");
                    for (Installment it : contract.getInstallments()) {
                        System.out.println(it.getDueDate().format(fmt) +
                                " - R$ " + String.format("%.2f", it.getValue()));
                    }

                    break;
            }



        } while (op != 0);

        sc.close();
    }

    //Funções para imprimir os menus
    public static void menuGPS() {
        System.out.println("--===== Gestão de Produtos e Serviços =====--");
        System.out.println("[1]-Cadastrar Produto");
        System.out.println("[2]-Máquinas/Produção");
        System.out.println("[3]-Sensores");
        System.out.println("[4]-Clintes e Reservas");
        System.out.println("[5]-Pagamentos");
        System.out.println("[6]-Processamento de Contratos");
        System.out.println("[0]-SAIR");
    }

    public static void MachineMenu() {
        System.out.println("---===== Máquinas / Produção =====---");
        System.out.println("[1]-Nova Produção");
        System.out.println("[2]-Total Produzido");
        System.out.println("[3]-Relatorio da Máquina");
        System.out.println("[0]-SAIR");
    }

    public static void scanerMenu() {
        System.out.println("[1]-Novo Sensor");
        System.out.println("[2]-Todos Sensores");
        System.out.println("[3]-Dados");
        System.out.println("[0]-SAIR");
    }

    public static void clienteReservaMenu(){
        System.out.println("[1]-Nova Reserva");
    }


}
