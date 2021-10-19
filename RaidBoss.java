
/* Nombre: RaidBoss.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 18.10.2021 */

public class RaidBoss extends Enemigo
{
    public RaidBoss()
    {
        super();
        this.nombre = "Cailleach: Diosa del invierno";
        this.vida = 1000;
        this.ataque = 50;
        this.habilidad = "Lluvia helada";
        this.damageE = 100;
        this.damageH = 80;
    }
}
