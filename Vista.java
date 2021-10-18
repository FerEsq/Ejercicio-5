
/* Nombre: Vista.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

//Import
import java.util.Scanner;
import java.util.ArrayList;  

public class Vista 
{
    Scanner scan = new Scanner(System.in);

    public Vista()
    {  

    }

    //Mensaje de bienvenida
    public void mostrarInicio()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("      ✦ Bienvenid@ al Simulador de batallas de rol ✦ \n");
		System.out.println(" - Máximo de jugadores: 4");
        System.out.println(" - Los jugadores deberán tomarse turnos para controlar el simulador");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de despedida
    public void mostrarDespedida()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Muchas gracias por utilizar nuestro simulador!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    //Mensaje de error de opción
    public void mostrarError()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Esa opción no existe, intente de nuevo");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Menú guerrero
    public int pedirJugadores()
    {
        int op = 0;
        System.out.println("¿Cuantos jugadores participarán en la batalla? (ingrese solo el número)");	
		System.out.println("1. Un jugador");
		System.out.println("2. Dos jugadores");
        System.out.println("3. Tres jugadores");

        op = scan.nextInt();
        return op;
    }

    //Menú rol
    public int pedirRol()
    {
        int op = 0;
        System.out.println("¿Que rol desea tener? (ingrese solo el número)");	
		System.out.println("1. Guerrero");
		System.out.println("2. Exploradora");
        System.out.println("3. Cazador");

        op = scan.nextInt();
        return op;
    }

    //Menú enemigo
    public int menuEnemigo()
    {
        int op = 0;
        System.out.println("¿Que desea que el enemigo haga? (ingrese solo el número)");	
		System.out.println("1. Atacar");
		System.out.println("2. Usar habilidad");
        System.out.println("3. Retirarse");

        op = scan.nextInt();
        return op;
    }

    //Menú jefe
    public int menuJefe()
    {
        int op = 0;
        System.out.println("¿Que desea que el enemigo haga? (ingrese solo el número)");	
		System.out.println("1. Atacar");
		System.out.println("2. Usar habilidad");
        System.out.println("3. Usar habilidad especial");
        System.out.println("4. Saltar turno");
        System.out.println("5. Retirarse");

        op = scan.nextInt();
        return op;
    }

     //Menú raid boss
     public int menuRaid()
     {
         int op = 0;
         System.out.println("¿Que desea que el enemigo haga? (ingrese solo el número)");	
         System.out.println("1. Atacar");
         System.out.println("2. Usar habilidad");
         System.out.println("3. Usar habilidad especial");
         System.out.println("4. Clonar");
         System.out.println("5. Variar");
         System.out.println("6. Liberar");
         System.out.println("7. Retirarse");
 
         op = scan.nextInt();
         return op;
     }

     //Menú raid boss
     public int menuClon()
     {
         int op = 0;
         System.out.println("¿Que desea que el Raid Boss haga? (ingrese solo el número)");	
         System.out.println("1. Usar Clon");
         System.out.println("2. Variar");
         System.out.println("3. Liberar");
         System.out.println("4. Retirarse");
 
         op = scan.nextInt();
         return op;
     }

     //Menú raid boss
     public int menuHabilidad()
     {
         int op = 0;
         int h = 0;
         System.out.println("¿Que habilidad desea tomar? (ingrese solo el número)");	
         System.out.println("1. Habilidad normal");
         System.out.println("2. Habilidad especial");
          
         op = scan.nextInt();
         if(op == 1)
         {
            h = 50;
         }
         else if (op == 2)
         {
             h = 100;
         }
         return h;
     }

    //Menú guerrero
    public int menuJugador()
    {
        int op = 0;
        System.out.println("¿Que desea hacer? (ingrese solo el número)");	
		System.out.println("1. Atacar");
		System.out.println("2. Usar item");
        System.out.println("3. Retirarse");

        op = scan.nextInt();
        return op;
    }

    //Menú espada
    public String pedirObjetivo(ArrayList <CombatienteABS> e)
    {
        int op = 0;
        String t = "";
        System.out.println("¿A que combatiente desea clonar? (ingrese solo el número)");
        for (int i = 0; i < e.size(); i++)
        {
            System.out.println(i + ". " + e.get(i).getNombre());
        }         
        op = scan.nextInt();
        t = e.get(op).getNombre();
        return t;
    }

    //Menú exploradora
    public int menuCazador()
    {
        int op = 0;
        System.out.println("¿Que desea hacer? (ingrese solo el número)");	
		System.out.println("1. Atacar y lanzar Mascota");
        System.out.println("2. Retirarse");

        op = scan.nextInt();
        return op;
    }

    //Mensaje de muerte de la mascota
    public void mostrarMuerte()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("La mascota ha muerto, revivirá en 3 turnos");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void separar()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
   
}
