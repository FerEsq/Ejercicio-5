
/* Nombre: Guerrero.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

public class Guerrero extends Jugador
{
    public Guerrero()
    {
        super();
        this.item = new Espada();
        this.nombre = "Guerrero";
        this.vida = 800;
        this.ataque = 30;
        this.mensajes[0] = "¡No sobrevivirás al filo de mi espada!";
        this.mensajes[1] = "Supongo que los buenos no siempre ganan";
        this.mensajes[2] = "Siempre logro repartir un poco de justicia";
    }
    
}
