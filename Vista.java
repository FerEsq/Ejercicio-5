
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
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Esa opción no existe, intente de nuevo");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de clon activo
    public void mostrarClonActivo()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Hay un clon en batalla, por lo que esta opción está desahibilitada");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de clon activo
    public void mostrarSinClon()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("No hay un clon en batalla, porfavor cree uno primero");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de clon activo
    public void mostrarSinPC()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("No hay ningun combatiente que pueda ser clonado");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    /** 
     * @return int
     */
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
    
    /** 
     * @return int
     */
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
    
    /** 
     * @return int
     */
    //Menú enemigo
    public int menuEnemigo()
    {
        int op = 0;
        System.out.println("¿Que desea que la Bruja haga? (ingrese solo el número)");	
		System.out.println("1. Atacar");
		System.out.println("2. Usar habilidad");
        System.out.println("3. Retirarse");

        op = scan.nextInt();
        return op;
    }
    
    /** 
     * @return int
     */
    //Menú jefe
    public int menuJefe()
    {
        int op = 0;
        System.out.println("¿Que desea que la Jefe Bruja haga? (ingrese solo el número)");	
		System.out.println("1. Atacar");
		System.out.println("2. Usar habilidad");
        System.out.println("3. Usar habilidad especial");
        System.out.println("4. Retirarse");

        op = scan.nextInt();
        return op;
    }

     /** 
      * @return int
      */
     //Menú raid boss
     public int menuRaid()
     {
         int op = 0;
         System.out.println("¿Que desea que Cailleach haga? (ingrese solo el número)");	
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

     /** 
      * @return int
      */
     //Menú variar
     public int menuVariar()
     {
         int op = 0;
         int h = 0;
         System.out.println("¿Que habilidad desea tomar? (ingrese solo el número)");	
         System.out.println("1. Habilidad normal");
         System.out.println("2. Habilidad especial");
          
         op = scan.nextInt();
         if(op == 1)
         {
            h = 80;
         }
         else if (op == 2)
         {
             h = 100;
         }
         return h;
     }
    
    /** 
     * @param n
     * @return int
     */
    //Menú jugador
    public int menuJugador(int n)
    {
        int op = 0;
        n = n+1;
        System.out.println("Jugador " + n + ": ¿Que desea hacer? (ingrese solo el número)");	
		System.out.println("1. Atacar");
		System.out.println("2. Usar item");
        System.out.println("3. Retirarse");

        op = scan.nextInt();
        return op;
    }

    /** 
     * @param e
     * @return int
     */
    //Menú clonar
    public int pedirClon(ArrayList <CombatienteABS> e)
    {
        int op = 0;
        System.out.println("¿A que combatiente desea clonar? (ingrese solo el número)");
        for (int i = 0; i < e.size(); i++)
        {
            System.out.println(i + ". " + e.get(i).getNombre());
        }         
        op = scan.nextInt();
        return op;
    }

    //Mensaje de inicio de batalla
    public void mostrarRaid()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("El Raid ha comenzado, Cailleach la Diosa del invierno se une a la batalla");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    
    /** 
     * @param j
     * @param e
     */
    public void mostrarEstatus(ArrayList <Jugador> j, ArrayList <Enemigo> e)
    {
        System.out.println("~~~~~~~~~~~~~~~~ Estatus ~~~~~~~~~~~~~~~");


        for (int i = 0; i < j.size(); i++)
        {
            System.out.println("• " + j.get(i).getNombre() + ": " + j.get(i).getVida() + " HP");
            if (j.get(i).getNombre().equals("Cazador"))
            {
                System.out.println("    • " + j.get(i).getMascota().getNombre() + ": " + j.get(i).getMascota().getVida() + " HP");
            }
        }        
        for (int i = 0; i < e.size(); i++)
        {
            System.out.println("• " + e.get(i).getNombre() + ": " + e.get(i).getVida() + " HP");
            if (e.get(i).getClon() != null)
            {
                System.out.println("    • " + e.get(i).getClon().getNombre() + ": " + e.get(i).getClon().getVida() + " HP");
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void separar()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /** 
     * @param c
     */
    //Mensaje de ganadores
    public void mostrarGanadores(String c)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("El raid ha terminado, y los " + c + " han resultado ganadores");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    /** 
     * @param n
     * @param p
     */
    //Mensaje de muerte de jugador
    public void mostrarMuerteJ(String n, int p)
    {
        p = p+1;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("El jugador " + p + " con el combatiente " + n + " ha muerto");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    /** 
     * @param n
     */
    //Mensaje de ganadores
    public void mostrarMuerteE(String n)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("El enemigo " + n + " ha muerto");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
       
}
