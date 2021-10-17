
/* Nombre: Jugador.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

//import
import java.util.ArrayList;  

public class Jugador extends Combatiente
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
    public void atacarES(ArrayList <Enemigo> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.ataque);
        }
    }
    
    /** 
     * @param e
     */
    public void usarItem(Enemigo e)
    {
        e.setVida(this.item.getDamage());
    }
    
    /** 
     * @param es
     */
    public void usarItemD(ArrayList <Enemigo> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.ataque);
        }
    }
    
    /** 
     * @param j
     */
    public void usarItemC(Jugador j)
    { 
        if (this.vida < 500)
        {
            this.vida += item.getDamage();
        }
    }

}
