package model.entities.enums;

public enum SensorStatus {
    ACTIVE("ATIVO"), DISABLE("DESATIVADO");

    private String description;

    SensorStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
