package cursojava_netbeans;

public class Cursojava_netbeans {

   
    public static void main(String[] args) {
        final double PI=3.14159;
        int radio=8;
        float precioPorMetroCuadrado=12.50f;
        char unidadMedida='m';
    
        double area=PI*radio*radio;
        double costoTotal=area*precioPorMetroCuadrado;
        
        
        System.out.println("El radio "+radio+unidadMedida+" resulta en un área de "+area+". El costo total, a un precio de "+precioPorMetroCuadrado+" €/m²,es de"+costoTotal);
    }

}
