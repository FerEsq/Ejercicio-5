
/* Nombre: Mago.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

public class Mago extends Enemigo
{
    public Mago()
    {
        super();
        this.nombre = "Mago";
        this.vida = 200;
        this.ataque = 10;
        this.mensajes[0] = "¿A quien no le gusta un buen truco de magia?";
        this.mensajes[1] = "Oh no, parece que mi magia se desvanece";
        this.mensajes[2] = "¡Te dije que tenía un truco bajo la manga!";
        this.habilidad = "Bola de fuego";
        this.damageH = 20;
    }    
}
