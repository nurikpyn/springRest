package kz.test.spring.model;

public enum StatusEnum {
    ON("Online"),
    OF("Offline"),
    MISS("Missing");

    private String name;

    StatusEnum(String name) {
        this.name = name;
    }

    public String getStatusEnum() {
        return this.name;
    }
}