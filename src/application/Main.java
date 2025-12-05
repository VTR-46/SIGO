package application;

import model.entities.*;
import model.entities.enums.SensorStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        double TAX = 50;

        List<ComumProduct> list = new ArrayList<>();

        ProductionMachine machine = new ProductionMachine("Maquina A1D1", 0, true, 0);
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

                    System.out.println("Lista:");
                    for (ComumProduct product : list) {
                        product.priceTag();
                    }

                    break;

                case 2:         //MAQUINAS

                    do {

                        MachineMenu();
                        opX = sc.nextInt();

                        switch (opX) {
                            case 1:
                                System.out.println("Digite a quantidade que sera produzida");
                                int p = sc.nextInt();

                                if (machine.NegativeRule(p) == true) {


                                    for (int i = 0; i < p; i++) {
                                        System.out.println("Nome:");
                                        sc.nextLine();
                                        String nmMP = sc.next();

                                        ManuProduct manuProduct = new ManuProduct(nmMP);

                                        System.out.println(nmMP + ", Foi produzido(a).");
                                        machine.addProduct(manuProduct);
                                        machine.increaseProductAmount(1);
                                        machine.increaseDamege();
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
            }


        } while (op != 0);


    }

    public static void menuGPS() {
        System.out.println("--===== Gestão de Produtos e Serviços =====--");
        System.out.println("[1]-Cadastrar Produto");
        System.out.println("[2]-Máquinas/Produção");
        System.out.println("[3]-Sensores");
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


}
