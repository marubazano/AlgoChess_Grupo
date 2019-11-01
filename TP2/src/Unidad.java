import java.util.ArrayList;

public class Unidad {
    private float vida;
    private int costo;
    private ArrayList<Arma> armas; //Guarda, no todas tienen armas, despues vemos eso
    private Casillero casillero;

    protected Unidad(float vida, int costo, ArrayList<Arma> armas) {
        this.vida = vida;
        this.costo = costo;
        this.armas = null;
    }

    public float obtenerVida(){
        return this.vida;
    }

    public void recibirDaño(float daño){
        this.vida -= daño;
    }

    public void recibirCura(float cura) { this.vida += cura; }

    public void ubicar(Casillero casillero_new) {
        if(!casillero_new.estaOcupado()) {
            this.casillero = casillero_new;
            casillero.ocuparCasilleroPorUnidad(this);
        }
        else System.out.println("Casillero esta ocupado!");
        //si se trata de ubicar y esta ocupado lanzo excepcion
    }
}

