package model.entities;

import java.time.LocalDate;

public class Installment {
    private LocalDate dueDate;
    private double value;

    public Installment(LocalDate dueDate, double value) {
        this.dueDate = dueDate;
        this.value = value;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
