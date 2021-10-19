
/* Nombre: Guerrero.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 
 *            Modificado el 18.10.2021 */

//import
import java.util.ArrayList;  

public class Guerrero extends Jugador<ArrayList <Enemigo>>
{
    public Guerrero()
    {
        super();
        this.item = new Espada();
        this.mascota = null;
        this.nombre = "Guerrero";
        this.vida = 500;
        this.ataque = 30;
    }

    public void usarItem(ArrayList <Enemigo> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.item.getDamage());
        }
    }
    
}
