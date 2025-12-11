package model.entities;

import model.entities.enums.ReserveStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reserve {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter hrt = DateTimeFormatter.ofPattern("HH:mm:ss");

    private LocalDate date;
    private LocalTime hours;
    private ReserveStatus status;
    private Client client;
    private List<ReserveItem> itens = new ArrayList<>();

    public Reserve(LocalDate date, LocalTime hours, ReserveStatus status, Client client) {
        this.date = date;
        this.hours = hours;
        this.status = status;
        this.client = client;
    }



    public void addItem(ReserveItem item){
        itens.add(item);
    }

    @Override
    public String toString() {
        return "===RESERVA===" +
                "\nDATA: " + date +
                "\nHORAS: " + hours +
                "\nSTATUS: " + status +
                "\nCliente: " + client +
                "\nItens:\n" + itens;
    }
}
