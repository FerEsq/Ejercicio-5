
/* Nombre: Cazador.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.10.2021 */

 //import
import java.util.ArrayList;  

public class Cazador extends Jugador<ArrayList <Enemigo>>
{
    public Cazador()
    {
        super();
        this.mascota = new Mascota();
        this.item = null;
        this.nombre = "Cazador";
        this.vida = 300;
        this.ataque = 10;
    }

    public void usarItem(ArrayList <Enemigo> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(mascota.getAtaque());
        }
    }

}

