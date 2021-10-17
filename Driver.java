
/* Nombre: Driver.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

//Import
import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;
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
                    vista.mostrarFrase(jugador, 0); //mostrar frase de inicio
                }
                if (rol == 2)
                {
                    jugador = new Exploradora(); //crear jugador
                    vista.separar();
                    vista.mostrarFrase(jugador, 0); //mostrar frase de inicio
                }
                if (rol > 2)
                {
                    vista.mostrarError(); //no existe la opción
                }
            }
            vista.separar();

            // ---------------------------------------- ENEMIGOS --------------------------------------   
            int n = 1 + rnd.nextInt(2);
            if (n == 1) //un enemigo
            {
                int s = 1 + rnd.nextInt(2);
                if (s == 1)
                {
                    JefeBruja e = new JefeBruja();
                    enemigos.add(e);
                }
                if (s == 2)
                {
                    JefeMago e = new JefeMago();
                    enemigos.add(e);
                }
            }
            if (n == 2) //dos enemigos
            {
                int s = 1 + rnd.nextInt(2);
                if (s == 1)
                {
                    Mago e1 = new Mago();
                    JefeBruja e2 = new JefeBruja();
                    enemigos.add(e1);
                    enemigos.add(e2);
                }
                else if (s == 2)
                {
                    Bruja e1 = new Bruja();
                    JefeMago e2 = new JefeMago();
                    enemigos.add(e1);
                    enemigos.add(e2);
                }
            }
            if (n == 3) //tres enemigos
            {
                int s = 1 + rnd.nextInt(2);
                if (s == 1)
                {
                    Mago e1 = new Mago();
                    Bruja e2 = new Bruja();
                    JefeBruja e3 = new JefeBruja();
                    enemigos.add(e1);
                    enemigos.add(e2);
                    enemigos.add(e3);
                }
                else if (s == 2)
                {
                    Bruja e1 = new Bruja();
                    Mago e2 = new Mago();
                    JefeMago e3 = new JefeMago();
                    enemigos.add(e1);
                    enemigos.add(e2);
                    enemigos.add(e3);
                }
            }
            
            while (salir == false) //mientras el simulador este activo
            {
            // ---------------------------------------- TURNO JUGADOR --------------------------------------
                if (turnoJ == true) //turno del jugador
                {
                    vista.mostrarEstatus(jugador, enemigos);                 
                    if (rol == 1) // el jugador es un guerrero
                    {
                        if (jugador.getVida() > 0)
                        {
                            opJ = vista.menuGuerrero(); //desplegar las opciones de un guerrero
                            if (opJ == 1)
                            {
                                jugador.atacarES(enemigos);
                                logs.add("Guerrero ha usado ataque");
                            }
                            if (opJ == 2)
                            {
                                boolean bandera = false;
                                while (bandera == false)
                                { 
                                    obj = vista.pedirObjetivo(enemigos);
                                    if (obj < enemigos.size())
                                    {
                                        jugador.usarItem(enemigos.get(obj));
                                        logs.add("Guerrero ha usado espada");
                                        bandera = true;
                                    }
                                    else
                                    {
                                        vista.mostrarError();
                                    }
                                }
                            }
                            if (opJ == 3)
                            {
                                contador++;
                                vista.mostrarLogs(logs);
                                turnoE = true;
                                turnoJ = false;
                                
                            }
                            if (opJ == 4)
                            {
                                salir = true;
                                turnoE = false;
                                turnoJ = false;
                                vista.mostrarDespedida();
                            }
                            if (opJ > 4)
                            {
                                vista.mostrarError();
                            }
                        }
                        else
                        {
                            vista.separar();
                            vista.mostrarFrase(jugador, 1); //frase que dice el jugador al morir
                            vista.separar();
                            for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al ganar
                            {
                                vista.mostrarFrase(enemigos.get(i), 2);
                            }
                            vista.separar();
                            salir = true;
                            turnoE = false;
                            turnoJ = false;
                        }
                    }

                    else if (rol == 2) // el jugador es una exploradora
                    {
                        vista.mostrarEstatus(jugador, enemigos); 
                        if (jugador.getVida() > 0)
                        {
                            opJ = vista.menuExploradora(); //desplegar las opciones de una exploradora
                            if (opJ == 1)
                            {
                                jugador.atacarES(enemigos);
                                logs.add("Exploradora ha usado ataque");
                            }
                            if (opJ == 2)
                            {
                                jugador.usarItemD(enemigos);
                                logs.add("Exploradora ha usado dalla");
                            }
                            if (opJ == 3)
                            {
                                jugador.usarItemC(jugador);
                                logs.add("Exploradora ha usado anillo");
                            }
                            if (opJ == 4)
                            {
                                contador++;
                                vista.mostrarLogs(logs);
                                turnoE = true;
                                turnoJ = false;
                                
                            }
                            if (opJ == 5)
                            {
                                salir = true;
                                turnoE = false;
                                turnoJ = false;
                                vista.mostrarDespedida();
                            }
                            if (opJ > 5)
                            {
                                vista.mostrarError();
                            }
                        }
                        else
                        {
                            vista.separar();
                            vista.mostrarFrase(jugador, 1); //frase que dice el jugador al morir
                            vista.separar();
                            for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al ganar
                            {
                                vista.mostrarFrase(enemigos.get(i), 2);
                            }
                            vista.separar();
                            salir = true;
                            break;
                        }
                    }
                    contador++;
                    vista.mostrarLogs(logs);
                    turnoE = true;
                    turnoJ = false;
                }

                // ---------------------------------------- TURNO ENEMIGOS --------------------------------------
                if (turnoE == true)
                {
                    vista.mostrarEstatus(jugador, enemigos); 
                    // solo hay un enemigo 
                    if (n == 1)
                    {
                        if (enemigos.get(0).getVida() > 0)
                        {
                            opE = vista.menuJefe(); //desplegar las opciones de un guerrero
                            if (opE == 1)
                            {
                                enemigos.get(0).atacar(jugador);
                                logs.add(enemigos.get(0).getNombre() + " ha usado ataque");
                            }
                            if (opE == 2)
                            {
                                enemigos.get(0).usarHabilidad(jugador, enemigos.get(0).getDamageH());
                                logs.add(enemigos.get(0).getNombre() + " ha usado " + enemigos.get(0).getHabilidad());
                            }
                            if (opE == 3)
                            {
                                enemigos.get(0).usarHabilidad(jugador, enemigos.get(0).getDamageE());
                                logs.add(enemigos.get(0).getNombre() + " ha usado " + enemigos.get(0).getHabilidadE());
                            }
                            if (opE == 4)
                            {
                                vista.mostrarLogs(logs);
                                turnoJ = true;
                                turnoE = false;
                                
                            }
                            if (opE == 5)
                            {
                                salir = true;
                                turnoE = false;
                                turnoJ = false;
                                vista.mostrarDespedida();
                            }
                            if (opE > 5)
                            {
                                vista.mostrarError();
                            }
                        }
                        else
                        {
                            vista.separar();
                            vista.mostrarFrase(jugador, 2); //frase que dice el jugador al ganar
                            vista.separar();
                            for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al morir
                            {
                                vista.mostrarFrase(enemigos.get(i), 1);
                            }
                            vista.separar();
                            salir = true;
                            break;
                        }
                    }
                    //hay dos enemigos
                    if (n == 2)
                    {
                        int mod = contador % 2;

                        if (mod == 1)
                        {
                            if (enemigos.get(0).getVida() > 0)
                            {
                                opE = vista.menuEnemigo(); //desplegar las opciones de un guerrero
                                if (opE == 1)
                                {
                                    enemigos.get(0).atacar(jugador);
                                    logs.add(enemigos.get(0).getNombre() + " ha usado ataque");
                                }
                                if (opE == 2)
                                {
                                    enemigos.get(0).usarHabilidad(jugador, enemigos.get(0).getDamageH());
                                    logs.add(enemigos.get(0).getNombre() + " ha usado " + enemigos.get(0).getHabilidad());
                                }
                                if (opE == 3)
                                {
                                    vista.mostrarLogs(logs);
                                    turnoJ = true;
                                    turnoE = false;
                                    
                                }
                                if (opE == 4)
                                {
                                    salir = true;
                                    turnoE = false;
                                    turnoJ = false;
                                    vista.mostrarDespedida();
                                }
                                if (opE > 4)
                                {
                                    vista.mostrarError();
                                }
                            }
                            else
                            {
                                vista.separar();
                                vista.mostrarFrase(jugador, 2); //frase que dice el jugador al ganar
                                vista.separar();
                                for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al morir
                                {
                                    vista.mostrarFrase(enemigos.get(i), 1);
                                }
                                vista.separar();
                                salir = true;
                                break;
                            }
                            
                        }
                        if (mod == 0)
                        {
                            if (enemigos.get(1).getVida() > 0)
                            {
                                opE = vista.menuJefe(); //desplegar las opciones de un guerrero
                                if (opE == 1)
                                {
                                    enemigos.get(1).atacar(jugador);
                                    logs.add(enemigos.get(1).getNombre() + " ha usado ataque");
                                }
                                if (opE == 2)
                                {
                                    enemigos.get(1).usarHabilidad(jugador, enemigos.get(1).getDamageH());
                                    logs.add(enemigos.get(1).getNombre() + " ha usado " + enemigos.get(1).getHabilidad());
                                }
                                if (opE == 3)
                                {
                                    enemigos.get(1).usarHabilidad(jugador, enemigos.get(1).getDamageE());
                                    logs.add(enemigos.get(1).getNombre() + " ha usado " + enemigos.get(1).getHabilidadE());
                                }
                                if (opE == 4)
                                {
                                    vista.mostrarLogs(logs);
                                    turnoJ = true;
                                    turnoE = false;
                                    
                                }
                                if (opE == 5)
                                {
                                    salir = true;
                                    turnoE = false;
                                    turnoJ = false;
                                    vista.mostrarDespedida();
                                }
                                if (opE > 5)
                                {
                                    vista.mostrarError();
                                }
                            }
                            else
                            {
                                vista.separar();
                                vista.mostrarFrase(jugador, 2); //frase que dice el jugador al ganar
                                vista.separar();
                                for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al morir
                                {
                                    vista.mostrarFrase(enemigos.get(i), 1);
                                }
                                vista.separar();
                                salir = true;
                                break;
                            }
                        }
                    }

                    // hay tres enemigos
                    if (n == 3)
                    {
                        int mod = contador % 3;
                        if (mod == 1) //turno primer enemigo
                        {
                            if (enemigos.get(0).getVida() > 0)
                            {
                                opE = vista.menuEnemigo(); //desplegar las opciones de un guerrero
                                if (opE == 1)
                                {
                                    enemigos.get(0).atacar(jugador);
                                    logs.add(enemigos.get(0).getNombre() + " ha usado ataque");
                                }
                                if (opE == 2)
                                {
                                    enemigos.get(0).usarHabilidad(jugador, enemigos.get(0).getDamageH());
                                    logs.add(enemigos.get(0).getNombre() + " ha usado " + enemigos.get(0).getHabilidad());
                                }
                                if (opE == 3)
                                {
                                    vista.mostrarLogs(logs);
                                    turnoJ = true;
                                    turnoE = false;
                                    
                                }
                                if (opE == 4)
                                {
                                    salir = true;
                                    turnoE = false;
                                    turnoJ = false;
                                    vista.mostrarDespedida();
                                }
                                if (opE > 4)
                                {
                                    vista.mostrarError();
                                }
                            }
                            else
                            {
                                vista.separar();
                                vista.mostrarFrase(jugador, 2); //frase que dice el jugador al ganar
                                vista.separar();
                                for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al morir
                                {
                                    vista.mostrarFrase(enemigos.get(i), 1);
                                }
                                vista.separar();
                                salir = true;
                                break;
                            }
                            
                        }
                        if (mod == 2) //turno segundo enemigo
                        {
                            if (enemigos.get(1).getVida() > 0)
                            {
                                opE = vista.menuEnemigo(); //desplegar las opciones de un guerrero
                                if (opE == 1)
                                {
                                    enemigos.get(1).atacar(jugador);
                                    logs.add(enemigos.get(1).getNombre() + " ha usado ataque");
                                }
                                if (opE == 2)
                                {
                                    enemigos.get(1).usarHabilidad(jugador, enemigos.get(1).getDamageH());
                                    logs.add(enemigos.get(1).getNombre() + " ha usado " + enemigos.get(1).getHabilidad());
                                }
                                if (opE == 3)
                                {
                                    vista.mostrarLogs(logs);
                                    turnoJ = true;
                                    turnoE = false;
                                    
                                }
                                if (opE == 4)
                                {
                                    salir = true;
                                    turnoE = false;
                                    turnoJ = false;
                                    vista.mostrarDespedida();
                                }
                                if (opE > 4)
                                {
                                    vista.mostrarError();
                                }
                            }
                            else
                            {
                                vista.separar();
                                vista.mostrarFrase(jugador, 2); //frase que dice el jugador al ganar
                                vista.separar();
                                for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al morir
                                {
                                    vista.mostrarFrase(enemigos.get(i), 1);
                                }
                                vista.separar();
                                salir = true;
                                break;
                            }
                            
                        }
                        if (mod == 0) //turno tercer enemigo
                        {
                            if (enemigos.get(2).getVida() > 0)
                            {
                                opE = vista.menuJefe(); //desplegar las opciones de un guerrero
                                if (opE == 1)
                                {
                                    enemigos.get(2).atacar(jugador);
                                    logs.add(enemigos.get(2).getNombre() + " ha usado ataque");
                                }
                                if (opE == 2)
                                {
                                    enemigos.get(2).usarHabilidad(jugador, enemigos.get(2).getDamageH());
                                    logs.add(enemigos.get(2).getNombre() + " ha usado " + enemigos.get(2).getHabilidad());
                                }
                                if (opE == 3)
                                {
                                    enemigos.get(2).usarHabilidad(jugador, enemigos.get(2).getDamageE());
                                    logs.add(enemigos.get(2).getNombre() + " ha usado " + enemigos.get(2).getHabilidadE());
                                }
                                if (opE == 4)
                                {
                                    vista.mostrarLogs(logs);
                                    turnoJ = true;
                                    turnoE = false;
                                    
                                }
                                if (opE == 5)
                                {
                                    salir = true;
                                    turnoE = false;
                                    turnoJ = false;
                                    vista.mostrarDespedida();
                                }
                                if (opE > 5)
                                {
                                    vista.mostrarError();
                                }
                            }
                            else
                            {
                                vista.separar();
                                vista.mostrarFrase(jugador, 2); //frase que dice el jugador al ganar
                                vista.separar();
                                for (int i = 0; i < enemigos.size(); i++) //frase que dicen los enemigos al morir
                                {
                                    vista.mostrarFrase(enemigos.get(i), 1);
                                }
                                vista.separar();
                                salir = true;
                                break;
                            }
                        }
                    }
                    vista.mostrarLogs(logs);
                    turnoJ = true;
                    turnoE = false;                
                }
            }
        }
        catch (InputMismatchException e)
        {
            vista.mostrarError();
        }   
	}
}