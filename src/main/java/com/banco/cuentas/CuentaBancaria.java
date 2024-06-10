package com.banco.cuentas;

import com.banco.Imprimible;
import com.banco.Persona;

public abstract class CuentaBancaria implements Imprimible {
    // Atributos de la clase CuentaBancaria
    protected Persona titular;
    protected double saldo;
    protected String iban;

    // Constructor que inicializa los atributos de la cuenta bancaria
    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    // Métodos getter para obtener los atributos
    public Persona getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }

    // Método abstracto para ingresar dinero en la cuenta
    public abstract void ingresar(double cantidad);

    // Método abstracto para retirar dinero de la cuenta
    public abstract boolean retirar(double cantidad);

    // Método para devolver la información de la cuenta como una cadena
    @Override
    public String devolverInfoString() {
        return "Titular: " + titular.toString() + ", Saldo: " + saldo + ", IBAN: " + iban;
    }
}
