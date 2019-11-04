import org.junit.*;

public class TableroTest {
    private Tablero pruebaTablero = new Tablero();

    @Test
    public void tableroSeCreaVacio(){
        Assert.assertTrue(pruebaTablero.tableroEstaVacio());
    }

    @Test
    public void tableroDejaDeEstarVacio(){
        Unidad unaUnidad = new Catapulta();
        Coordenada unaCoordenada = new Coordenada(1,1);
        pruebaTablero.ubicarUnidad(unaUnidad,unaCoordenada);
        Assert.assertFalse(pruebaTablero.tableroEstaVacio());
    }

}
