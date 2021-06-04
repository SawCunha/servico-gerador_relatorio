package com.sawcunha.controlerelatorio.exceptions;

public class NotFoundException extends RuntimeException {

    private final Integer identifier;

    public NotFoundException(String message, Integer identifier) {
        super(message);
        this.identifier = identifier;
    }

    public Integer getIdentifier() {
        return identifier;
    }
}
