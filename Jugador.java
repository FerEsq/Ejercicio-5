
/* Nombre: Jugador.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 
 *            Modificado el 18.10.2021 */

//import
import java.util.ArrayList;  

public abstract class Jugador<COM> extends CombatienteABS<ArrayList <Enemigo>>
{
    protected Item item;
    protected Mascota mascota;
    
    public Jugador()
    {
        super();
    }
      
    /** 
     * @param es
     */
    public void atacar(ArrayList <Enemigo> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.ataque);
        }
    }
        
    /** 
     * @param es
     */
    public abstract void usarItem(COM c);

    /** 
     * @return Mascota
     */
    //Mascotas
    public Mascota getMascota()
    {
        return mascota;
    }

    public void setMascota()
    {
        mascota = null;
    }

    public void newMascota()
    {
        mascota = new Mascota();
    }
    
}
