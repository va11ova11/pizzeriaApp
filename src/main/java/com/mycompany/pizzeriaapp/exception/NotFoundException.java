package com.mycompany.pizzeriaapp.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mes) {
        super(mes);
    }
}
