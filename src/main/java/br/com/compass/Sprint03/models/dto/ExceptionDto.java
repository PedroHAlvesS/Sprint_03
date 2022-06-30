package br.com.compass.Sprint03.models.dto;

public class ExceptionDto {
    private String message;
    private String type;

    public String getType() {
        return type;
    }

    public ExceptionDto(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public ExceptionDto(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
