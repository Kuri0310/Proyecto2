import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static double DeudaTotal;
    public static Scanner scanner = new Scanner(System.in);
    public static ConsumoDeLuz[] Luzi = new ConsumoDeLuz[10];
    public static int limite;
    public static double valorConsumo = 9.00;
    public static int opcion=0;

    public static ArrayList <Electrodomesticos> electrodomesticos = new ArrayList<Electrodomesticos>();
    public static ArrayList <Facturas> fac = new ArrayList<Facturas>();

    public static void main(String[] args) {
        Luzi[0] = new ConsumoDeLuz (52.00, 52.00, 52.00 , 70 , 9);
        Luzi[1] = new ConsumoDeLuz(51.00, 20.11, 50.00,100, 9);
        Luzi[2] = new ConsumoDeLuz(26.00, 20.00, 50.00,50, 9);

        do {
            try {
                System.out.println("Bienvenido a tu sistema de ahorro de luz!");
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Agregar electrodomestico");
                System.out.println("2. Mostrar el consumo de luz");
                System.out.println("3. Mostrar las facturas");
                System.out.println("4. Mostrar los electrodomesticos");
                System.out.println("5. Agregar factura");
                System.out.println("6. Salir");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> agregarElectrodomestico();
                    case 2 -> MostrarInfo();
                    case 3 -> MostrarFactura();
                    case 4 -> MostrarElectrodomesticos();
                    case 5 -> agregarFactura();
                    case 6 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }

            } catch (InputMismatchException exception) {
                System.out.println("Escribe un número válido.");
                scanner.nextLine();
            }

        } while (opcion != 6);
    }

    public static void MostrarFactura() {
        try {
            File archivo = new File("Facturas.txt");
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de facturas.");
            e.printStackTrace();
        }
    }

    public static void MostrarInfo() {
        for (ConsumoDeLuz consumoDeLuz : Luzi) {

            if (consumoDeLuz != null) {
                double TotalConsumido = consumoDeLuz.kWh*consumoDeLuz.costo;
                System.out.println("kWh: " + consumoDeLuz.kWh);

                double consumoDiario = TotalConsumido/30;
                System.out.println("Consumo Diario: C$ " + consumoDiario);

                double consumoSemanal = consumoDiario*7;
                System.out.println("Consumo Semanal: C$ " + consumoSemanal);

                double consumoMensual = consumoSemanal*4;
                System.out.println("Consumo mensual: C$ " + consumoMensual);

                System.out.println("Costo C$: " + consumoDeLuz.costo);
                System.out.println("El total de consumo es: C$" + TotalConsumido);
                System.out.println();
                }
            }
        try {
            File archivo = new File("ConsumosDeLuz.txt");
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                
                System.out.println(lector.nextLine());
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de consumos de luz.");
            e.printStackTrace();
        }
    }

    public static void MostrarElectrodomesticos() {
        try {
            File archivo = new File("Electrodomesticos.txt");
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de electrodomésticos.");
            e.printStackTrace();
        }
    }

    public static void agregarElectrodomestico(){
        limite = 5;

        if (electrodomesticos.size()< limite) {
            Electrodomesticos newElectrodomestico;

            System.out.println("Nombre del electrodomestico: ");
            String name = scanner.nextLine();

            System.out.println("Marca: ");
            String marca = scanner.nextLine();

            System.out.println("Modelo: ");
            String model = scanner.nextLine();

            System.out.println("Consumo: ");
            double consumo = scanner.nextDouble();
            scanner.nextLine();

            while (!(consumo>0)){
                System.out.println("El consumo debe ser positivo: ");
                consumo = scanner.nextDouble();
                scanner.nextLine();
            }

            double DeudaC = consumo * valorConsumo;
            System.out.println("Deuda en córdobas: C$" + DeudaC);

            newElectrodomestico = new Electrodomesticos(name, model, marca, consumo, DeudaC);
            electrodomesticos.add(newElectrodomestico);

            try {
                FileWriter escritor = new FileWriter("Electrodomesticos.txt", true);
                escritor.write("Nombre: " + name + ", Marca: " + marca + ", Modelo: " + model + ", Consumo: " + consumo + ", Deuda: C$" + DeudaC + "\n");
                escritor.close();
                System.out.println("Electrodoméstico agregado y guardado en el archivo.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de electrodomésticos.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Límite de electrodomésticos alcanzado");
        }
    }

    public static void agregarFactura(){
        limite = 5;

        if (fac.size()< limite) {
            Facturas newFactura;

            System.out.println("Nombre del cliente: ");
            String cliente = scanner.nextLine();

            System.out.println("Escriba la fecha de emisión: ");
            String emision = scanner.nextLine();

            System.out.println("Mes de la factura: ");
            String mes = scanner.nextLine();

            System.out.println("Consumo: ");
            double consumo = scanner.nextDouble();
            scanner.nextLine();

            double valorSubsidio = consumo;
            if (consumo<150) {
                double descuento = consumo*0.25;
                valorSubsidio -= descuento;
                System.out.println("El valor con descuento es: " + valorSubsidio);
            } else {
                System.out.println("El consumo es mayor a 150, no hay subsidio");
            }

            while (!(consumo>0)){
                System.out.println("El consumo debe ser positivo: ");
                consumo = scanner.nextDouble();
                scanner.nextLine();
            }

            double DeudaTotal = valorSubsidio * valorConsumo;
            System.out.println("Deuda total: C$" + DeudaTotal);
    
            newFactura = new Facturas(cliente, emision, mes, consumo, DeudaTotal);
            fac.add(newFactura);
            
            try {
                FileWriter escritor = new FileWriter("Facturas.txt", true);
                escritor.write("Cliente: " + cliente + ", Emisión: " + emision + ", Mes: " + mes + ", Consumo: " + consumo + ", Deuda Total: C$" + DeudaTotal + "\n");
                escritor.close();
                System.out.println("Factura agregada y guardada en el archivo.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de facturas.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Límite de facturas alcanzado");
        }
    }
}