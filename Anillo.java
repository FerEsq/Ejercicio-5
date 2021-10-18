
/* Nombre: Anillo.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

public class Anillo extends Item
{
    public Anillo()
    {
        super();
        this.tipo = "Anillo";
        this.damage = 30; //este actuará como la vida que recupera al jugador en lugar del daño que provoca
        this.usos = 20;
    }
}
