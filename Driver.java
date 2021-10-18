
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
import java.util.function.Predicate;

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

            for (int i = 0; i < jug; i++) //para cada jugador
            {
                rol = vista.pedirRol(); 
                if (rol == 1) //guerrero
                {
                    jugadores.add(new Guerrero());
                }
                else if (rol == 2) //exploradora
                {
                    jugadores.add(new Exploradora());
                }
                else if (rol == 3) //cazador
                {
                    jugadores.add(new Cazador());
                    Pclones.add(new Mascota()); //mascota al array de posibles clones
                }
                else if (rol > 3)
                {
                    vista.mostrarError();
                    i--;
                }                
            }

            // ---------------------------------------- ENEMIGOS --------------------------------------   
            enemigos.add(new RaidBoss()); //se crea el raid boss por default
            int n = rnd.nextInt(3); //número de acompañantes (de 0 a 2)
            if (n == 1) //un acompañante
            {
                enemigos.add(new JefeBruja()); //se crea un jefe de acompañante
                Pclones.add(new JefeBruja()); //acompañante al array de posibles clones
            }
            else if (n == 2) //dos acompañantes
            {
                enemigos.add(new Bruja()); //se crean dos enemigos de acompañantes
                enemigos.add(new Bruja());
                Pclones.add(new Bruja()); //acompañante al array de posibles clones
            }
            
            // ---------------------------------------- SIMULADOR --------------------------------------  
            vista.mostrarRaid();
            while (salir == false)
            {
                //============================= TURNO JUGADOR =============================
                if (turnoJ == true) 
                {
                    if (jugadores.isEmpty() == false) //si aun hay jugadores
                    {
                        Predicate<Jugador> con = v -> (v.getVida() <= 0);
                        for (int i = 0; i < jugadores.size(); i++) //para cada jugador
                        {                       
                            if (con.test(jugadores.get(i)) == true ) //el jugador ya no tiene vida
                            {
                                vista.mostrarMuerteJ(jugadores.get(i).getNombre(), i);
                            }
                        }
                        jugadores.removeIf(con); //quitar jugadores sin vida

                        for (int i = 0; i < jugadores.size(); i++) //para cada jugador
                        {
                            opJ = vista.menuJugador(i);
                            if (opJ == 1)
                            {
                                jugadores.get(i).atacar(enemigos); //ataca
                            }
                            else if (opJ == 2)
                            {
                                if (jugadores.get(i).getNombre().equals("Guerrero")) //guerrero
                                {
                                    jugadores.get(i).usarItem(enemigos); //usa la espada (ataque)
                                }
                                else if (jugadores.get(i).getNombre().equals("Exploradora")) //exploradora
                                {
                                    jugadores.get(i).usarItem(jugadores.get(i)); //usa el anillo (curación)
                                }
                                else if (jugadores.get(i).getNombre().equals("Cazador")) //cazador
                                {
                                    jugadores.get(i).atacar(enemigos); //ataca
                                    jugadores.get(i).usarItem(enemigos); //lanza la mascota
                                }
                            }
                            else if (opJ == 3)
                            {
                                salir = true;
                                vista.mostrarDespedida();
                                break;
                            }
                            else if (opJ > 3 || opJ < 1)
                            {
                                vista.mostrarError();
                            }
                        }
                    }
                    else
                    {
                        vista.mostrarGanadores("enemigos");
                    }

                    if (salir == false)
                    {
                        contador++;
                        vista.mostrarEstatus(jugadores, enemigos);
                        turnoE = true;
                        turnoJ = false;
                    }
                }




            }           
        }
        catch (InputMismatchException e)
        {
            vista.mostrarError();
        }   
	}
}