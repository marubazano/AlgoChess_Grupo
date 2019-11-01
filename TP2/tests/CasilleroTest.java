import org.junit.*;

public class CasilleroTest {
    private Casillero pruebaCasillero = new Casillero();

    @Test
    public void CasilleroSeCreaVacio(){
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test
    public void estaOcupadoDevuelveTrueCuandoEstaOcupado(){
        Unidad prueba = new Catapulta(); //Creo una unidad cualquera
        pruebaCasillero.ocuparCasilleroPorUnidad(prueba);
        Assert.assertTrue(pruebaCasillero.estaOcupado());
    }
}