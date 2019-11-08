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
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad);
        Assert.assertTrue(pruebaCasillero.estaOcupado());
    }

    @Test
    public void seVaciaCasilleroCorrectamente() throws CasilleroOcupadoException {
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad);
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
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad);
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad2);
    }
}