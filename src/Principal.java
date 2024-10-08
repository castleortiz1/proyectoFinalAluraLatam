import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el limite de la tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        lectura.nextLine();  // Consumir el salto de línea después de nextDouble()

        while (salir != 0) {
            System.out.println("Escriba la descripcion de la compra: ");
            String descripcion = lectura.nextLine();

            System.out.println("Escriba el valor de la compra: ");
            double valor = lectura.nextDouble();
            lectura.nextLine();  // Consumir el salto de línea después de nextDouble()

            Compras compras = new Compras(valor, descripcion);
            boolean compraRealizada = tarjeta.realizarCompra(compras);

            if (compraRealizada) {
                System.out.println("Compra realizada con éxito!");
                System.out.println("Escriba 0 para salir o 1 para continuar: ");
                salir = lectura.nextInt();
                lectura.nextLine();  // Consumir el salto de línea después de nextInt()
            } else {
                System.out.println("Saldo Insuficiente!");
                salir = 0;
            }
        }

        System.out.println("****************************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(tarjeta.getListaDeCompras());
        for (Compras compra : tarjeta.getListaDeCompras()) {
            System.out.println(compra.getDescripcion() + "  " + compra.getValor());
        }
        System.out.println("****************************************");
        System.out.println("\nSaldo de la tarjeta: " + tarjeta.getSaldo());

        lectura.close();  // Cerrar el Scanner al final
    }
}