
/* Nombre: Jugador.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

//import
import java.util.ArrayList;  

public abstract class Jugador<COM> extends CombatienteABS<ArrayList <Enemigo>>
{
    protected Item item;
    
    public Jugador()
    {
        super();
    }
    
    /** 
     * @return Item
     */
    public Item getItem()
    {
        return item;
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
    
}
