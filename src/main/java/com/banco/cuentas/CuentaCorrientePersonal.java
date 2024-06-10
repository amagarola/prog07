package com.banco.cuentas;

import com.banco.Persona;

public class CuentaCorrientePersonal extends CuentaCorriente {
    // Atributo específico de la clase CuentaCorrientePersonal
    private double comisionMantenimiento;

    // Constructor que inicializa los atributos de la cuenta corriente personal
    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, String entidadesAutorizadas,
            double comisionMantenimiento) {
        super(titular, saldo, iban, entidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    // Método para ingresar dinero en la cuenta corriente personal
    @Override
    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    // Método para retirar dinero de la cuenta corriente personal
    @Override
    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        } else {
            return false; // Saldo insuficiente
        }
    }

    // Método para devolver la información de la cuenta corriente personal como una
    // cadena
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", Comisión de mantenimiento: " + comisionMantenimiento;
    }
}
