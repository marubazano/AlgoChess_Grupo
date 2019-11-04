import org.junit.*;

public class TableroTest {
    private Tablero pruebaTablero = new Tablero();

    @Test
    public void tableroSeCreaVacio(){
        Assert.assertTrue(pruebaTablero.tableroEstaVacio());
    }

    @Test
    public void unidadSeUbicaConExitoEnElTablero(){
        Unidad unaUnidad = new Catapulta();
        Coordenada unaCoordenada = new Coordenada(1,1);
        pruebaTablero.ubicarUnidad(unaUnidad,unaCoordenada);
        Assert.assertFalse(pruebaTablero.tableroEstaVacio());
    }

    @Test
    public void unidadNoSePuedeColocarEnPosicionOcupada(){
        Unidad unaUnidad = new Jinete();
        Unidad otraUnidad = new Jinete();
        Coordenada unaCoordenada = new Coordenada(1,1);
        pruebaTablero.ubicarUnidad(unaUnidad,unaCoordenada);
        Assert.assertFalse(pruebaTablero.ubicarUnidad(otraUnidad,unaCoordenada));
    }


    @Test
    public void unidadSeMueveDePosicion(){
        Unidad unaUnidad = new Jinete();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(2,1);
        pruebaTablero.ubicarUnidad(unaUnidad,unaCoordenada);
        Assert.assertTrue(pruebaTablero.moverUnidad(unaUnidad,otraCoordenada));
    }

    @Test
    public void unidadNoSePuedeMoverAPosicionOcupada(){
        Unidad unaUnidad = new Jinete();
        Unidad otraUnidad = new Jinete();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(2,1);
        pruebaTablero.ubicarUnidad(unaUnidad,unaCoordenada);
        pruebaTablero.ubicarUnidad(otraUnidad,otraCoordenada);
        Assert.assertFalse(pruebaTablero.moverUnidad(unaUnidad,otraCoordenada));
    }



}
