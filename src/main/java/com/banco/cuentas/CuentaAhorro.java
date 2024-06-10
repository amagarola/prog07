package com.banco.cuentas;

import com.banco.Persona;

public class CuentaAhorro extends CuentaBancaria {
    // Atributo específico de la clase CuentaAhorro
    private double tipoInteresAnual;

    // Constructor que inicializa los atributos de la cuenta de ahorro
    public CuentaAhorro(Persona titular, double saldo, String iban, double tipoInteresAnual) {
        super(titular, saldo, iban);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    // Método para ingresar dinero en la cuenta de ahorro
    @Override
    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    // Método para retirar dinero de la cuenta de ahorro
    @Override
    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        } else {
            return false; // Saldo insuficiente
        }
    }

    // Método para devolver la información de la cuenta de ahorro como una cadena
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", Tipo de interés anual: " + tipoInteresAnual;
    }
}
