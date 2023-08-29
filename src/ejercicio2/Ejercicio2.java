package ejercicio2;

import entities.Lavadora;
import java.util.Scanner;
import services.ElectrodomesticoService;
import services.LavadoraService;

/**
 *
 * @author facu
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ElectrodomesticoService es = new ElectrodomesticoService(scanner);
        LavadoraService ls = new LavadoraService(scanner);

        /*
        Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios para mostrar
el precio final de los dos electrodomésticos.
        */
                
        Lavadora lavadora1 = ls.crearLavadora();
        System.out.println("El precio final de la lavadora es: $" + lavadora1.getPrecio());
    }
}
