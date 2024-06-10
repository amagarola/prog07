package com.banco;

import java.util.Scanner;

import com.banco.cuentas.CuentaAhorro;
import com.banco.cuentas.CuentaCorrienteEmpresa;
import com.banco.cuentas.CuentaCorrientePersonal;

public class Main {
    private static Banco banco = new Banco();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Abrir una nueva cuenta.");
            System.out.println("2. Ver listado de cuentas.");
            System.out.println("3. Obtener datos de una cuenta concreta.");
            System.out.println("4. Realizar un ingreso.");
            System.out.println("5. Retirar efectivo.");
            System.out.println("6. Consultar saldo actual.");
            System.out.println("7. Salir.");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    abrirNuevaCuenta();
                    break;
                case 2:
                    verListadoCuentas();
                    break;
                case 3:
                    obtenerDatosCuenta();
                    break;
                case 4:
                    realizarIngreso();
                    break;
                case 5:
                    retirarEfectivo();
                    break;
                case 6:
                    consultarSaldo();
                    break;
                case 7:
                    System.out.println("Gracias por utilizar la aplicación.");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void abrirNuevaCuenta() {
        System.out.println("Ingrese los datos del titular:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        Persona titular = new Persona(nombre, apellidos, dni);

        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("1. Cuenta de ahorro");
        System.out.println("2. Cuenta corriente personal");
        System.out.println("3. Cuenta corriente de empresa");
        int tipoCuenta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("IBAN (formato ESNNNNNNNNNNNNNNNNNNNNNN): ");
        String iban = scanner.nextLine();

        if (!iban.matches("^ES\\d{20}$")) {
            System.out.println("IBAN no válido.");
            return;
        }

        switch (tipoCuenta) {
            case 1:
                System.out.print("Tipo de interés anual: ");
                double tipoInteresAnual = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                CuentaAhorro cuentaAhorro = new CuentaAhorro(titular, saldoInicial, iban, tipoInteresAnual);
                banco.abrirCuenta(cuentaAhorro);
                break;
            case 2:
                System.out.print("Entidades autorizadas (separadas por comas): ");
                String entidadesAutorizadas = scanner.nextLine();
                System.out.print("Comisión de mantenimiento: ");
                double comisionMantenimiento = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                CuentaCorrientePersonal ccp = new CuentaCorrientePersonal(titular, saldoInicial, iban,
                        entidadesAutorizadas, comisionMantenimiento);
                banco.abrirCuenta(ccp);
                break;
            case 3:
                System.out.print("Entidades autorizadas (separadas por comas): ");
                String entidadesAutorizadasEmpresa = scanner.nextLine();
                System.out.print("Máximo descubierto permitido: ");
                double maximoDescubierto = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Tipo de interés por descubierto: ");
                double tipoInteresDescubierto = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Comisión fija por descubierto: ");
                double comisionDescubierto = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                CuentaCorrienteEmpresa cce = new CuentaCorrienteEmpresa(titular, saldoInicial, iban,
                        entidadesAutorizadasEmpresa, maximoDescubierto, tipoInteresDescubierto, comisionDescubierto);
                banco.abrirCuenta(cce);
                break;
            default:
                System.out.println("Tipo de cuenta no válido.");
        }
    }

    private static void verListadoCuentas() {
        for (String cuentaInfo : banco.listadoCuentas()) {
            System.out.println(cuentaInfo);
        }
    }

    private static void obtenerDatosCuenta() {
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = scanner.nextLine();
        String info = banco.informacionCuenta(iban);
        if (info != null) {
            System.out.println(info);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    private static void realizarIngreso() {
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = scanner.nextLine();
        System.out.print("Ingrese la cantidad a ingresar: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        if (banco.ingresoCuenta(iban, cantidad)) {
            System.out.println("Ingreso realizado con éxito.");
        } else {
            System.out.println("Error al realizar el ingreso.");
        }
    }

    private static void retirarEfectivo() {
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = scanner.nextLine();
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        if (banco.retiradaCuenta(iban, cantidad)) {
            System.out.println("Retiro realizado con éxito.");
        } else {
            System.out.println("Error al realizar el retiro.");
        }
    }

    private static void consultarSaldo() {
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = scanner.nextLine();
        double saldo = banco.obtenerSaldo(iban);
        if (saldo != -1) {
            System.out.println("El saldo actual de la cuenta es: " + saldo);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }
}
