import org.junit.Test;

public class TestCasillero{
    Casillero prueba = new Casillero();

    @Test
    public void CasilleroSeCreaVacio(){
        Assert.assertEquals(prueba.estaOcupado(), false);
    }
}