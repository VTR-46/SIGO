package application;

import model.entities.*;

import java.time.LocalDate;
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

        menuGPS();
        int op = sc.nextInt();
        int opX = 0;

        do {

            switch (op) {
                case 1:
                    System.out.println("Quantos produtos de seja adicionar?");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nome do produto:");
                        sc.next();
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

                case 2:
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

                case 3:


            }


        } while (op != 0);


    }

    public static void menuGPS() {
        System.out.println("--===== Gestão de Produtos e Serviços =====--");
        System.out.println("[1]-Produtos");
        System.out.println("[2]-Máquinas/Produção");
        System.out.println("[3]-Sensores");
    }

    public static void MachineMenu() {
        System.out.println("---===== Máquinas / Produção =====---");
        System.out.println("[1]-Nova Produção");
        System.out.println("[2]-Total Produzido");
        System.out.println("[3]-Relatorio da Máquina");
    }

    public static void scanerMenu(){
        System.out.println("[1]-Novo Sensor");
        System.out.println("[2]-");
    }


}
