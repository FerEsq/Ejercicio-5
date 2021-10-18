
/* Nombre: Driver.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

//Import
import java.util.Scanner;
import java.util.ArrayList;  
import java.util.Random;
import java.util.InputMismatchException;

class Driver
{	
	/** 
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Propiedades
        Random rnd = new Random();
		Vista vista = new Vista();
        ArrayList <String> logs = new ArrayList<>();
        Jugador jugador = null;
        ArrayList <Enemigo> enemigos = new ArrayList<>();
        boolean turnoJ = true;
        boolean turnoE = false;
        boolean salir = false;
        int rol = 0;
        int opE = 0;
        int opJ = 0;
        int obj = 0;
        int contador = 0;

        //Ingresar logs vacíos
        logs.add("Ninguna acción");
        logs.add("Ninguna acción");
        logs.add("Ninguna acción");
		
        //Mensajes de bienvenida	
		vista.mostrarInicio();

        // ---------------------------------------- ROL --------------------------------------        
        try
        {
            while (rol != 1 && rol != 2)
            {
                rol = vista.pedirRol(); //pedir rol

                if (rol == 1)
                {
                    jugador = new Guerrero(); //crear jugador
                    vista.separar();
                }
                if (rol == 2)
                {
                    jugador = new Exploradora(); //crear jugador
                    vista.separar();
                }
                if (rol > 2)
                {
                    vista.mostrarError(); //no existe la opción
                }
            }
            vista.separar();

            // ---------------------------------------- ENEMIGOS --------------------------------------   
            int n = 1 + rnd.nextInt(2);
            
        }
        catch (InputMismatchException e)
        {
            vista.mostrarError();
        }   
	}
}