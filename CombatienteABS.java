
/* Nombre: Combatiente.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 
 *            Modificado el 18.10.2021 */

//Import
import java.util.ArrayList;  

public abstract class CombatienteABS<AL>
{
    protected String nombre;
    protected int vida;
    protected int ataque;

    public CombatienteABS()
    {

    }
    
    /** 
     * @return String
     */
    public String getNombre()
    {
        return nombre;
    }
        
    /** 
     * @param d
     */
    public void setVida(int d)
    {
        vida = vida - d;
    }
    
    /** 
     * @return int
     */
    public int getVida()
    {
        return vida;
    }
    
    /** 
     * @return int
     */
    public int getAtaque()
    {
        return ataque;
    }

    /** 
     * @param a
     */
    public abstract void atacar(AL list); 
    
    /** 
     * @param a
     */
    public void setAtaque(int a)
    {
        this.ataque = a;
    }

    /** 
     * @param es
     */
    public void usarClon(ArrayList <Jugador> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.ataque);
        }
    }
}
