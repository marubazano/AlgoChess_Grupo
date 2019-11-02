public abstract class Unidad {
    private float vida;
    private int costo;
    private Casillero casillero;

    public Unidad(float vida, int costo) {
        this.vida = vida;
        this.costo = costo;
    }

    public float obtenerVida(){
        return this.vida;
    }

    public void recibirDaño(float daño){
        this.vida -= daño;
    }

    public void recibirCura(float cura) {
        this.vida += cura;
    }

    public void ubicar(Casillero casillero_new) { //Refactorizar esto
        casillero_new.estaOcupado();
        this.casillero = casillero_new;
        casillero.ocuparCasilleroPorUnidad();

    }

    public abstract void realizarAccion(Unidad unidad);
}

