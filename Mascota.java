
/* Nombre: Mascota.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.10.2021 */

//import
import java.util.ArrayList;  

public class Mascota extends Jugador<ArrayList <Enemigo>>
{
    public Mascota()
    {
        super();
        this.item = null;
        this.nombre = "Caracal";
        this.vida = 150;
        this.ataque = 50;
    }

    public void usarItem(ArrayList <Enemigo> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.ataque);
        }
    }
    
}
