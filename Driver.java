
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
        boolean capaz = true;
        int turnosRES = 3;
        int rol = 0;
        int jug = 0;
        int opE = 0;
        int opJ = 0;
        int pc = 0;
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
                //============================= TURNO JUGADORES =============================
                if (turnoJ == true) 
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

                    if (jugadores.isEmpty() == false) //si aun hay jugadores
                    {
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
                            else if (opJ == 3) //salir
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
                        salir = true;
                    }

                    if (salir == false)
                    {
                        contador++;
                        vista.mostrarEstatus(jugadores, enemigos);
                        turnoE = true;
                        turnoJ = false;
                    }
                }

                //============================= TURNO ENEMIGOS =============================
                if (turnoE == true) 
                {
                    Predicate<Enemigo> con = v -> (v.getVida() <= 0);
                    for (int i = 0; i < enemigos.size(); i++) //para cada enemigo
                    {                       
                        if (con.test(enemigos.get(i)) == true ) //el enemigo ya no tiene vida
                        {
                            vista.mostrarMuerteE(enemigos.get(i).getNombre());
                        }
                    }
                    enemigos.removeIf(con); //quitar enemigos sin vida

                    if (enemigos.isEmpty() == false) //si aun hay enemigos
                    {
                        //Primero juega el raidboss
                        boolean bandera = false;
                        while (bandera == false)
                        {
                            opE = vista.menuRaid();
                            if (opE == 1) //atacar
                            {
                                if (capaz == true)
                                {
                                    enemigos.get(0).atacar(jugadores);
                                    bandera = true;
                                }
                                else
                                {
                                    enemigos.get(0).atacar(jugadores);
                                    enemigos.get(0).getClon().usarClon(jugadores);
                                    bandera = true;
                                }
                            }
                            else if (opE == 2) //usar habilidad 
                            {
                                if (capaz == true)
                                {
                                    enemigos.get(0).usarHabilidad(jugadores, enemigos.get(0).getDamageH());
                                    bandera = true;
                                }
                                else
                                {
                                    vista.mostrarClonActivo();
                                }
                            }
                            else if (opE == 3) //usar habilidad especial
                            {
                                if (capaz == true)
                                {
                                    enemigos.get(0).usarHabilidad(jugadores, enemigos.get(0).getDamageE());
                                    bandera = true;
                                }
                                else
                                {
                                    vista.mostrarClonActivo();
                                }
                            }
                            else if (opE == 4) //clonar
                            {
                                if (Pclones.isEmpty() == false)
                                {
                                    capaz = false; //capaz se vuelve false pues ya no podrá usar sus habilidades
                                    pc = vista.pedirClon(Pclones); //pedir el combatiente a clonar
                                    enemigos.get(0).clonar(Pclones.get(pc).getNombre()); //clonarlo
                                    bandera = true;
                                }
                                else
                                {
                                    vista.mostrarSinPC();
                                }
                            }
                            else if (opE == 5) //variar
                            {
                                if (capaz == false)
                                {
                                    int na = vista.menuVariar(); //pedir habilidad a variar
                                    enemigos.get(0).variar(na); //variarla
                                    bandera = true;
                                }
                                else
                                {
                                    vista.mostrarSinClon();
                                }
                            }
                            else if (opE == 6) //liberar
                            {
                                if (capaz == false)
                                {
                                    capaz = true; //capaz es true de nuevo
                                    enemigos.get(0).liberar(); //liberar clon
                                    bandera = true;
                                }
                                else
                                {
                                    vista.mostrarSinClon();
                                }
                            }
                            else if (opE == 7) //salir
                            {
                                salir = true;
                                vista.mostrarDespedida();
                                break;
                            }
                            else if (opE > 7 || opE < 1)
                            {
                                vista.mostrarError();
                            }
                        }

                        //Luego juegan los otros enemigos
                        if (n == 1 && enemigos.size() > 1) //hay un enemigo
                        {
                            opE = vista.menuJefe();
                            if (opE == 1) //atacar
                            {
                                enemigos.get(1).atacar(jugadores);
                            }
                            else if (opE == 2) //usar habilidad
                            {
                                enemigos.get(1).usarHabilidad(jugadores, enemigos.get(0).getDamageH());
                            }
                            else if (opE == 3) //usar habilidad especial
                            {
                                enemigos.get(1).usarHabilidad(jugadores, enemigos.get(0).getDamageE());
                            }
                            else if (opE == 4) //salir
                            {
                                salir = true;
                                vista.mostrarDespedida();
                                break;
                            }
                            else if (opE > 4 || opE < 1)
                            {
                                vista.mostrarError();
                            }
                        }

                        if (n == 2 && enemigos.size() > 1) //hay dos enemigos
                        {
                            for (int i = 1; i < enemigos.size(); i++)
                            {
                                opE = vista.menuEnemigo();
                                if (opE == 1) //atacar
                                {
                                    enemigos.get(1).atacar(jugadores);
                                }
                                else if (opE == 2) //usar habilidad
                                {
                                    enemigos.get(0).usarHabilidad(jugadores, enemigos.get(0).getDamageH());
                                }
                                else if (opE == 3) //salir
                                {
                                    salir = true;
                                    vista.mostrarDespedida();
                                    break;
                                }
                                else if (opE > 3 || opE < 1)
                                {
                                    vista.mostrarError();
                                }
                            }
                        }                                                
                    }
                    else
                    {
                        vista.mostrarGanadores("jugadores"); 
                        salir = true;
                    }

                    if (salir == false)
                    {
                        contador++;
                        vista.mostrarEstatus(jugadores, enemigos);
                        turnoE = false;
                        turnoJ = true;
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