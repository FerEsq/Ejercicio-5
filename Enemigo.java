
/* Nombre: Enemigo.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

  //import
  import java.util.ArrayList; 

public class Enemigo extends CombatienteABS<ArrayList <Jugador>>
{
    protected String habilidad;
    protected String habilidadE;
    protected int damageH;
    protected int damageE;
    
    public Enemigo()
    {
        super();  
    }
    
    /** 
     * @return String
     */
    public String getHabilidad()
    {
        return habilidad;
    }
    
    /** 
     * @return int
     */
    public int getDamageH()
    {
        return damageH;
    }
    
    /** 
     * @param es
     */
    public void atacar(ArrayList <Jugador> es)
    {
        for (int i = 0; i < es.size(); i++)
        {
            es.get(i).setVida(this.ataque);
        }
    }
    
    /** 
     * @param j
     * @param d
     */
    public void usarHabilidad(Jugador j, int d)
    {
        j.setVida(d);
    }

    /** 
     * @return int
     */
    public int getDamageE()
    { 
        return damageE;
    }
    
    /** 
     * @return String
     */
    public String getHabilidadE()
    {
        return habilidadE;
    }
    
}
