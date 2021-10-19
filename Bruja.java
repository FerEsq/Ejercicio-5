
/* Nombre: Bruja.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 28.09.2021 
 *            Modificado el 18.10.2021 */

public class Bruja extends Enemigo
{
    public Bruja()
    {
        super();
        this.nombre = "Bruja";
        this.vida = 150;
        this.ataque = 15;
        this.habilidad = "Hechizo oscuro";
        this.damageH = 35;
    }    
}
