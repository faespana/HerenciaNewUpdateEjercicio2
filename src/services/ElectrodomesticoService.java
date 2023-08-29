package services;

import entities.Electrodomestico;
import java.util.Scanner;

/**
 *
 * @author facu
 */
public class ElectrodomesticoService {
    private final Scanner scanner;

    public ElectrodomesticoService(Scanner scanner) {
        this.scanner = scanner;
    }
    
    private char comprobarConsumoEnergetico(char letra) {
        int ascii = (int) letra;
        if (!(ascii >= 65 && ascii <= 70)) {
            return 'F';
        }
        
        return letra;
    }

    private String comprobarColor(String color) {
        switch (color) {
            case "blanco":
            case "negro":
            case "rojo":
            case "azul":
            case "gris":
                return color;
            default:
                return "blanco";
        }
    }
    
    protected double precioFinal(double precio, char consumoEnergetico, double peso) {
        switch (consumoEnergetico) {
            case 'A':
                precio += 1000d;
                break;
            case 'B':
                precio += 800d;
                break;
            case 'C':
                precio += 600d;
                break;
            case 'D':
                precio += 500d;
                break;
            case 'E':
                precio += 300d;
                break;
            case 'F':
                precio += 100d;
                break;
        }
        
        if (peso >= 80) {
            return precio + 1000d;
        }
        
        if (peso >= 50 && peso <= 79) {
            return precio + 800d;
        }
        
        if (peso >= 20 && peso <= 49) {
            return precio + 500d;
        }
        
        return precio + 100d;
    }

    public Electrodomestico crearElectrodomestico() {
        System.out.print("Color: ");
        String color = comprobarColor(scanner.nextLine().toLowerCase());

        System.out.print("Peso: ");

        double peso = Double.valueOf(scanner.nextLine());
        
        System.out.print("Consumo energetico: ");
        char consumo = comprobarConsumoEnergetico(scanner.nextLine().toUpperCase().charAt(0));
        
        double precio = precioFinal(1000d, consumo, peso);
        
        return new Electrodomestico(precio, color, consumo, peso);
    }
}
