package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private String name;
    private String email;
    private LocalDate birth;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Client(String name, LocalDate birth, String email) {
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CLIENTE" +
                "\nNome: " + name +
                "\nEmail: " + email +
                "\nData de Nascimento: " + fmt.format(birth);
    }
}
