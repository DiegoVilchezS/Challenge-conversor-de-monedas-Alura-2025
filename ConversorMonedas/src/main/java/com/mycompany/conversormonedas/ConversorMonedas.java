package com.mycompany.conversormonedas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        List<String> historial = new ArrayList<>();
        int opcion = 0;

        String menu = """
                ***************************************************
                ¡Bienvenido/a al Challenge Conversor de Monedas Alura 2026!
                Escoja por favor una de nuestras opciones: 
                
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Real brasileño
                4) Real brasileño => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Ver historial de conversiones
                8) Salir
                ***************************************************
                Elija una opción válida:
                """;

        while (opcion != 8) {
            System.out.println(menu);
            
            try {
                opcion = Integer.parseInt(lectura.nextLine());
                
                if (opcion >= 1 && opcion <= 6) {
                    System.out.println("Ingrese el valor que desea convertir:");
                    double cantidad = Double.parseDouble(lectura.nextLine());
                    
                    String monedaBase = "";
                    String monedaObjetivo = "";

                    switch (opcion) {
                        case 1 -> { monedaBase = "USD"; monedaObjetivo = "ARS"; }
                        case 2 -> { monedaBase = "ARS"; monedaObjetivo = "USD"; }
                        case 3 -> { monedaBase = "USD"; monedaObjetivo = "BRL"; }
                        case 4 -> { monedaBase = "BRL"; monedaObjetivo = "USD"; }
                        case 5 -> { monedaBase = "USD"; monedaObjetivo = "COP"; }
                        case 6 -> { monedaBase = "COP"; monedaObjetivo = "USD"; }
                    }

                    // Llamar a la API
                    MonedaDTO tasa = consulta.buscarTasa(monedaBase, monedaObjetivo);
                    double resultado = cantidad * tasa.conversion_rate();
                    
                    String mensajeResultado = String.format("El valor %.2f [%s] corresponde al valor final de =>> %.2f [%s]", 
                            cantidad, monedaBase, resultado, monedaObjetivo);
                    
                    System.out.println(mensajeResultado);
                    
                    // Guardar en el historial con fecha y hora
                    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                    historial.add(timestamp + " - " + mensajeResultado);
                    
                } else if (opcion == 7) {
                    System.out.println("--- HISTORIAL DE CONVERSIONES ---");
                    if (historial.isEmpty()) {
                        System.out.println("Aún no has realizado conversiones.");
                    } else {
                        historial.forEach(System.out::println);
                    }
                    System.out.println("---------------------------------");
                } else if (opcion != 8) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un valor numérico válido.");
            } catch (RuntimeException e) {
                System.out.println("Error en la aplicación: " + e.getMessage());
            }
        }
        
        System.out.println("Finalizando la ejecución del conversor.\n"
                   + "Challenge realizado por: Diego Vilchez -PE");
                   
        lectura.close();
    }
}