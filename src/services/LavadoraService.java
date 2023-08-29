/*
Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
el atributo propio de la lavadora.

•Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
carga es menor o igual, no se incrementará el precio. Este método debe llamar al
método padre y añadir el código necesario. Recuerda que las condiciones que hemos
visto en la clase Electrodoméstico también deben afectar al precio
 */
package services;

import entities.Electrodomestico;
import entities.Lavadora;
import java.util.Scanner;

/**
 *
 * @author facu
 */
public class LavadoraService extends ElectrodomesticoService {
    private final Scanner scanner;
    
    public LavadoraService(Scanner scanner) {
        super(scanner);
        this.scanner = scanner;
    }
    
    private double precioFinal(double carga, double precio) {
        if (carga > 30) {
            return precio + 500d;
        }
        
        return precio;
    }
    
    public Lavadora crearLavadora() {
        System.out.println("Creando una lavadora: ");
        Lavadora lavadora = new Lavadora();
        
        Electrodomestico elec = crearElectrodomestico();
        
        System.out.print("Carga: ");
        double carga = Double.valueOf(scanner.nextLine());
        
        lavadora.setCarga(carga);
        lavadora.setPrecio(precioFinal(carga, elec.getPrecio()));
        lavadora.setColor(elec.getColor());
        lavadora.setConsumoEnergetico(elec.getConsumoEnergetico());
        lavadora.setPeso(elec.getPeso());
        
        return lavadora;
    }
}
