
package cursojava_netbeans;

import java.util.Scanner;


public class Ejercicio3 {
        public static void main(String[] args) {
        String modeloDispositivo="Samsung";
        String unidadMedida="mAh";
        final float capacidadMaxima=24.000f;
        float consumoPorHora=1.000f;
        byte nivelActual=100;
        
        
      Scanner entrada= new Scanner(System.in);
      
        System.out.print("Ingrese en número de horas usadas: ");
        float horasUsadas=entrada.nextByte();
        
        float horasTotales=capacidadMaxima/consumoPorHora;
        float desgasteBateria=horasUsadas*consumoPorHora;
        float horasRestantes=horasTotales-horasUsadas;
        
        
        boolean autonomiaBaja=(nivelActual<20);

        
        System.out.println("Informe de bateria: El modelo "+modeloDispositivo+" (Capacidad: "+capacidadMaxima+unidadMedida+
                           " tiene un Consumo de "+desgasteBateria+"mAh/h. Quedan "+horasRestantes+" horas de uso."+" ¿Alerta de batería baja?: " +
                            autonomiaBaja + ".");
       
        
    entrada.close();
       
    }
    
}

    

