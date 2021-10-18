
/* Nombre: RaidBoss.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.10.2021 */

 //import
 import java.util.ArrayList; 

public class RaidBoss extends Enemigo
{
    private CombatienteABS clon;
    private boolean power;

    public RaidBoss()
    {
        super();
        clon = null;
        this.nombre = "Cailleach: Diosa del invierno";
        this.vida = 1000;
        this.ataque = 50;
        this.habilidad = "Lluvia helada";
        this.damageH = 100;
        power = false;
    }
    
    public void clonar(String tipo, int h)
    {
        power = true;
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

    public void variar(int na)
    {
        clon.setAtaque(na);
    }

    public void usarClon(ArrayList <Enemigo> j)
    {
        clon.atacar(j);        
    }

    public void liberar()
    {
        power = false;
        clon = null;
    }

    public CombatienteABS getClon()
    {
        return clon;
    }

    public boolean getPower()
    {
        return power;
    }
    
    

}
