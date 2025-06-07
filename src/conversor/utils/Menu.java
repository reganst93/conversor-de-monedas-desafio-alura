package conversor.utils;

import conversor.api.ConexionApi;
import conversor.model.ConversionResponse;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ConexionApi conexionApi = new ConexionApi();
    private final GeneradorDeArchivo generador = new GeneradorDeArchivo();

    public void mostrarMenuPrincipal(){
        System.out.println("=== Bienvenid@ al conversor de Monedas===");
        System.out.println("Seleccione una de las opciones disponibles a continuación:");
        System.out.println("1- Convertir moneda");
        System.out.println("2. Ver tasa de conversíon actual");
        System.out.println("3. Salir");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1 -> convertirMoneda();
            case 2 -> mostrarTasa();
            case 3 -> {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                return;
            }
            default -> {
                System.out.println("Opción no Válida  Intente nuevamente.\\n");
                mostrarMenuPrincipal();
            }
        }
    }

    private  String seleccionarMoneda(String tipo){
        System.out.println("Seleccione la " + tipo + "de la siguiente lista:");
        System.out.println("1. USD (Dólar estadounidense)");
        System.out.println("2. BOB (Boliviano boliviano)");
        System.out.println("3. ARS (Peso argentino");
        System.out.println("4. CLP (Peso chileno)");
        System.out.println("5. CAD (Dólar canadiense)");
        System.out.println("6. BRl (Real Brasilero)");
        System.out.println("7. COP (Peso colombiano)");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        return switch (opcion){
            case 1 -> "USD";
            case 2 -> "BOB";
            case 3 -> "ARS";
            case 4 -> "CLP";
            case 5 -> "CAD";
            case 6 -> "BRL";
            case 7 -> "COP";
            default -> {
                System.out.println("Opción inválida. Intente nuevamente.");
                yield seleccionarMoneda(tipo);
            }
        };

    }
    private void convertirMoneda(){
       String base = seleccionarMoneda("moneda base");
       String objetivo = seleccionarMoneda("moneda objetivo");

       System.out.println("Ingrese el monto a convertir: ");
       double cantidad = scanner.nextDouble();
       scanner.nextLine();

       ConversionResponse resultado = conexionApi.convertirMoneda(base, objetivo,cantidad);
        System.out.println("\nResultado: " + cantidad + " " + base + " = " +
                resultado.conversion_result() + " " + objetivo + "\n");

        generador.guardarJson(resultado);

        preguntarSiContinuar();
    }

    private void mostrarTasa(){
        String base = seleccionarMoneda("moneda base");
        String objetivo = seleccionarMoneda("moneda objetivo");

        ConversionResponse resultado = conexionApi.obtenerTasa(base, objetivo);

        System.out.println("Tasa actual de conversión: " + resultado.conversion_rate());
        preguntarSiContinuar();
    }

    private void preguntarSiContinuar(){

        while (true){
            System.out.println("¿Desea realizar otra operación? (S/N)");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) {
                mostrarMenuPrincipal(); // Correcto: si es S, vuelve al menú
                break;
            } else if (respuesta.equals("N")) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                System.exit(0);
            } else {
                System.out.println("Entrada no válida. Por favor ingrese 'S' o 'N'.");
            }
        }
    }
}
