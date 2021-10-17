
/* Nombre: Enemigo.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

public class Enemigo extends Combatiente
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
     * @param j
     */
    public void atacar(Jugador j)
    {
        j.setVida(this.getAtaque());
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
