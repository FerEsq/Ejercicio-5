
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

    protected CombatienteABS clon;
    
    public Enemigo()
    {
        super();  
        clon = null;
    }
        
    /** 
     * @return int
     */
    public int getDamageH()
    {
        return damageH;
    }

    /** 
     * @return int
     */
    public int getDamageE()
    { 
        return damageE;
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
    public void usarHabilidad(ArrayList <Jugador> j, int d)
    {
        for (int i = 0; i < j.size(); i++)
        {
            j.get(i).setVida(d);
        }
    }
    
    //----------- Raid Boss ------------
    /** 
     * @param tipo
     */
    public void clonar(String tipo)
    {
        if (tipo.equals("Caracal"))
        {
            clon = new Mascota();
        }
        else if (tipo.equals("Bruja"))      
        {
            clon = new Bruja();
        }
        else if (tipo.equals("Jefe Bruja"))      
        {
            clon = new JefeBruja();
        }
    }
 
    /** 
     * @param na
     */
    public void variar(int na)
    {
        clon.setAtaque(na);
    }

    public void liberar()
    {
        clon = null;
    }

    /** 
     * @return CombatienteABS
     */
    public CombatienteABS getClon()
    {
        return clon;
    }
}
