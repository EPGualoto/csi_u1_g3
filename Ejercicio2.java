
import java.util.Scanner;

public class Ejercicio2 {
    
            

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "si";  // Variable para controlar si el usuario desea continuar

        while (continuar.equalsIgnoreCase("si")) {
            // Solicitar el número de filas (n) para crear la matriz nxn 
            System.out.print("Ingrese el número de filas (n): ");
            int n = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            // Ingresar el mensaje para cifrarlo
            System.out.print("Ingrese el mensaje a cifrar: ");
            String mensaje = scanner.nextLine().replace(" ", "");  // Eliminar espacios en el mensaje

            // Verificar que el mensaje quepa en la matriz de n x n
            if (mensaje.length() > n * n) {
                System.out.println("Error! El mensaje excede el valor de la matriz.");
                return;
            }

            // Rellenar con '*' los espacios restantes si el mensaje no llena la matriz
            StringBuilder mensajeRelleno = new StringBuilder(mensaje);
            while (mensajeRelleno.length() < n * n) {
                mensajeRelleno.append("*");
            }

            // Crear la matriz de n x n y llenarla con los caracteres del mensaje
            char[][] matriz = new char[n][n];
            int indice = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = mensajeRelleno.charAt(indice++);
                }
            }

            // Imprimir la matriz original
            System.out.println("Matriz original:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }

            // Leer la matriz columna por columna para formar el mensaje cifrado
            StringBuilder mensajeCifrado = new StringBuilder();
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    mensajeCifrado.append(matriz[i][j]);
                }
            }

            // Imprimir el mensaje cifrado
            System.out.println("\nMensaje cifrado: " + mensajeCifrado.toString());

            // Preguntar al usuario si desea cifrar otro mensaje
            System.out.print("\n¿Desea cifrar otro mensaje? (si/no): ");
            continuar = scanner.nextLine();
        }

        // Mensaje final de despedida
        System.out.println("Programa terminado.");
        scanner.close();
    }

}