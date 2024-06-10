package com.banco.cuentas;

import com.banco.Persona;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    // Atributos específicos de la clase CuentaCorrienteEmpresa
    private double maximoDescubierto;
    private double tipoInteresDescubierto;
    private double comisionDescubierto;

    // Constructor que inicializa los atributos de la cuenta corriente de empresa
    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, String entidadesAutorizadas,
            double maximoDescubierto, double tipoInteresDescubierto, double comisionDescubierto) {
        super(titular, saldo, iban, entidadesAutorizadas);
        this.maximoDescubierto = maximoDescubierto;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }

    // Método para ingresar dinero en la cuenta corriente de empresa
    @Override
    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    // Método para retirar dinero de la cuenta corriente de empresa
    @Override
    public boolean retirar(double cantidad) {
        if ((saldo - cantidad) >= -maximoDescubierto) {
            saldo -= cantidad;
            return true;
        } else {
            return false; // Se supera el máximo descubierto permitido
        }
    }

    // Método para devolver la información de la cuenta corriente de empresa como
    // una cadena
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", Máximo descubierto permitido: " + maximoDescubierto
                + ", Tipo de interés por descubierto: " + tipoInteresDescubierto
                + ", Comisión fija por descubierto: " + comisionDescubierto;
    }
}
