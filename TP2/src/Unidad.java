import java.util.ArrayList;
public abstract class Unidad {
    private float vida;
    private int costo;
    private Coordenada coordenada;
    private ArrayList<Unidad> unidadesContiguas;

    public Unidad(float vida, int costo) {
        this.vida = vida;
        this.costo = costo;
        this.coordenada = null; //Poner las coordenadas para cuando atacamos, calcular las coordenadas a las que hace daño desde el lugar en que está la unidad
        this.unidadesContiguas = new ArrayList<>();
    }

    public float obtenerVida() {
        return this.vida;
    }

    public void recibirDaño(float daño) {
        this.vida -= daño;
    }

    public void recibirCura(float cura) {
        this.vida += cura;
    }

    /*public void ubicar(Casillero casillero) { //Refactorizar esto
        if (casillero.estaOcupado()) {
            //LANZAR EXCEPCIÓN DE QUE ESTÁ OCUPADO
        }
        casillero.ocuparCasilleroPorUnidad(this);
    }*/

    public void ubicarEnCoodenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Coordenada obtenerCoordenada() {
        return this.coordenada;
    }

    public int obtenerCosto() {
        return this.costo;
    }

    public abstract void realizarAccion(Unidad unidad);

    public void asignarUnidadContigua(Unidad unidad){
        if(!unidadesContiguas.contains(unidad))
            unidadesContiguas.add(unidad);
    }

    public ArrayList<Unidad> obtenerUnidadesContiguas(){
        return unidadesContiguas;
    }
}

