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

    public void ubicar(Casillero casillero) { //Refactorizar esto
        if (casillero.estaOcupado()) {
            //LANZAR EXCEPCIÓN DE QUE ESTÁ OCUPADO
        }
        casillero.ocuparCasilleroPorUnidad(this);
    }

    public int getCosto(){
        return this.costo;
    }

    public abstract void realizarAccion(Unidad unidad);
}

