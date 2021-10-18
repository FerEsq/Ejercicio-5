
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
        ArrayList <CombatienteABS> Pclones = new ArrayList<>();
        ArrayList <Jugador> jugadores = new ArrayList<>();
        ArrayList <Enemigo> enemigos = new ArrayList<>();

        boolean turnoJ = true;
        boolean turnoE = false;
        boolean salir = false;
        int turnosRES = 3;
        int rol = 0;
        int jug = 0;
        int opE = 0;
        int opJ = 0;
        int obj = 0;
        int contador = 0;

		
        //Mensajes de bienvenida	
		vista.mostrarInicio();

        // ---------------------------------------- JUGADORES --------------------------------------        
        try
        {
            while (jug != 1 && jug != 2 && jug != 3)
            {
                jug = vista.pedirJugadores(); //pedir cantidad jugadores

                if (jug > 3)
                {
                    vista.mostrarError(); //no existe la opción
                }
            }
            vista.separar();

            for (int i = 0; i < jug; i++)
            {
                rol = vista.pedirRol();
                if (rol == 1)
                {
                    jugadores.add(new Guerrero());
                }
                else if (rol == 2)
                {
                    jugadores.add(new Exploradora());
                }
                else if (rol == 3)
                {
                    jugadores.add(new Cazador());
                }
                else if (rol > 3)
                {
                    vista.mostrarError();
                    i--;
                }                
            }

            // ---------------------------------------- ENEMIGOS --------------------------------------   
            enemigos.add(new RaidBoss());
            int n = rnd.nextInt(3);
            if (n == 1)
            {
                enemigos.add(new JefeBruja());
            }
            else if (n == 2)
            {
                enemigos.add(new Bruja());
                enemigos.add(new Bruja());
            }
            
        }
        catch (InputMismatchException e)
        {
            vista.mostrarError();
        }   
	}
}