
/* Nombre: Item.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 
 *            Modificado el 18.10.2021 */

public class Item 
{
    protected String tipo;
    protected int damage;
    protected int usos;

    public Item()
    {
        
    }
    
    /** 
     * @return String
     */
    public String getTipo()
    {
        return tipo;
    }
    
    /** 
     * @return int
     */
    public int getDamage()
    {
        return damage;
    }
    
    /** 
     * @return int
     */
    public int getUsos()
    {
        return usos;
    }

    public void setUsos()
    {
        usos--;
    }

}
