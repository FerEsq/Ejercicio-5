
/* Nombre: Bruja.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 */

public class Bruja extends Enemigo
{
    public Bruja()
    {
        super();
        this.nombre = "Bruja";
        this.vida = 150;
        this.ataque = 15;
        this.mensajes[0] = "No necesito una escoba para acabar contigo";
        this.mensajes[1] = "Oh no, necesitaré muchas posiones para recuperarme";
        this.mensajes[2] = "¡La oscuridad siempre prevalece!";
        this.habilidad = "Hechizo oscuro";
        this.damageH = 35;
    }    
}
