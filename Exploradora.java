
/* Nombre: Exploradora.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

 //Import

public class Exploradora extends Jugador<Jugador>
{
    public Exploradora()
    {
        super();
        this.item = new Anillo();
        this.nombre = "Exploradora";
        this.vida = 500;
        this.ataque = 20;
    }
    
    /** 
     * @param es
     */
    public void usarItem(Jugador j)
    {
        if (this.vida < 500)
        {
            this.vida += item.getDamage();
        }
    }    
}
