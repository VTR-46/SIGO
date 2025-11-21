package application;

import model.entities.ComumProduct;
import model.entities.ImportedProduct;
import model.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt =DateTimeFormatter.ofPattern("dd/MM/yyyy");

        double TAX = 50;

        List<ComumProduct> list = new ArrayList<>();

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

            if (type == 'u' || type == 'U'){
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
        for (ComumProduct product : list){
            product.priceTag();
        }


    }
}
