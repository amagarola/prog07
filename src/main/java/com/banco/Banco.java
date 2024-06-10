package com.banco;

import java.util.ArrayList;

import com.banco.cuentas.CuentaBancaria;

public class Banco {
    // Lista para almacenar las cuentas bancarias
    private ArrayList<CuentaBancaria> cuentas;

    // Constructor que inicializa la lista de cuentas
    public Banco() {
        cuentas = new ArrayList<>();
    }

    // Método para abrir una nueva cuenta
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        if (cuentas.size() < 100) {
            cuentas.add(cuenta);
            return true;
        } else {
            return false; // No se pueden agregar más de 100 cuentas
        }
    }

    // Método para obtener un listado de las cuentas
    public ArrayList<String> listadoCuentas() {
        ArrayList<String> lista = new ArrayList<>();
        for (CuentaBancaria cuenta : cuentas) {
            lista.add(cuenta.devolverInfoString());
        }
        return lista;
    }

    // Método para obtener la información de una cuenta específica
    public String informacionCuenta(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.devolverInfoString();
            }
        }
        return null; // Cuenta no encontrada
    }

    // Método para realizar un ingreso en una cuenta
    public boolean ingresoCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                cuenta.ingresar(cantidad);
                return true;
            }
        }
        return false; // Cuenta no encontrada
    }

    // Método para realizar una retirada de efectivo de una cuenta
    public boolean retiradaCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.retirar(cantidad);
            }
        }
        return false; // Cuenta no encontrada o saldo insuficiente
    }

    // Método para obtener el saldo de una cuenta
    public double obtenerSaldo(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.getSaldo();
            }
        }
        return -1; // Cuenta no encontrada
    }
}
