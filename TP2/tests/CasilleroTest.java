import Excepciones.CasilleroOcupadoException;
import Tablero.Casillero;
import Tablero.Coordenada;
import Unidades.Catapulta;
import Unidades.Jinete;
import Unidades.Unidad;
import org.junit.*;

public class CasilleroTest {
    private Casillero pruebaCasillero = new Casillero();
    private Unidad unidad = new Jinete();
    private Unidad unidad2 = new Catapulta();

    @Test
    public void casilleroSeCreaVacio(){
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test
    public void estaOcupadoDevuelveTrueCuandoEstaOcupado() throws CasilleroOcupadoException {
        Coordenada coordenada = new Coordenada(0,0);
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad,coordenada);
        Assert.assertTrue(pruebaCasillero.estaOcupado());
    }

    @Test
    public void seVaciaCasilleroCorrectamente() throws CasilleroOcupadoException {
        Coordenada coordenada = new Coordenada(0,0);
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad, coordenada);
        pruebaCasillero.vaciarCasillero();
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test
    public void vaciarCasilleroVacioNoLanzaError() {
        pruebaCasillero.vaciarCasillero();
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void ocuparCasilleroOcupadoLanzaError() throws CasilleroOcupadoException {
        Coordenada coordenada = new Coordenada(0,0);
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad, coordenada);
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad2, coordenada);
        Assert.fail();
    }
}