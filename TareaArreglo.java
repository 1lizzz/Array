
import java.util.Scanner;
/**@author Corrales*/
public class TareaArreglo {
   public static void main(String[] args) { 
       Scanner teclado = new Scanner(System.in); 
        // Solicita la cantidad de nombres y edades a almacenar

      System.out.print("Ingrese la cantidad de personas: "); 
      int numPersonas = teclado.nextInt();
      
      String[] nombres = new String[numPersonas];
      int[] edades = new int[numPersonas];
      
     // Solicita los nombres y edades y los almacena
          for (int i = 0; i < numPersonas; i++) {
     
          System.out.print("Ingrese el nombre de la persona" + ": "); 
         nombres[i] = teclado.next();
         
         System.out.print(" Ingrese la edad de " + nombres[i]+ ": ");          
          edades[i] = teclado.nextInt();
          }

          // Imprime la lista de nombres y edades 
          System.out.println("\n Lista de nombres y edades:"); 
          
          for ( int i = 0; i < numPersonas; i++ ) {
              
              System.out.println("Nombre: " + nombres[i] +" Edad: " + edades[i]);
          }
      
           // Cierra el escáner
           System.exit(0);
      }
   }