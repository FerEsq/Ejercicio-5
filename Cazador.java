
/* Nombre: Cazador.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.10.2021 */

 //import
import java.util.ArrayList;  

public class Cazador extends Jugador<ArrayList <Enemigo>>
{

    private Mascota mascota;

    public Cazador()
    {
        super();
        mascota = new Mascota();
        this.item = null;
        this.nombre = "Cazador";
        this.vida = 300;
        this.ataque = 30;
    }

    public void usarItem(ArrayList <Enemigo> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.ataque);
        }
    }

    public void setMascota()
    {
        mascota = null;
    }

    public void newMascota()
    {
        mascota = new Mascota();
    }

    public Mascota getMascota()
    {
        return mascota;
    }

}

