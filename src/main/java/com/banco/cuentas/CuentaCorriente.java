package com.banco.cuentas;

import com.banco.Persona;

public abstract class CuentaCorriente extends CuentaBancaria {
    // Atributos comunes para todas las cuentas corrientes
    protected String entidadesAutorizadas;

    // Constructor que inicializa los atributos de la cuenta corriente
    public CuentaCorriente(Persona titular, double saldo, String iban, String entidadesAutorizadas) {
        super(titular, saldo, iban);
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    // Método para devolver la información de la cuenta corriente como una cadena
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", Entidades autorizadas: " + entidadesAutorizadas;
    }
}
