import AlgoChess.Jugador;
import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Tablero.*;
import Unidades.*;
import org.junit.*;

public class TableroTest {
    private Tablero pruebaTablero = new Tablero();

    @Test
    public void tableroSeCreaVacio() {
        Assert.assertTrue(pruebaTablero.tableroEstaVacio());
    }

    @Test
    public void unidadSeUbicaConExitoEnElTablero() throws CasilleroOcupadoException, CasilleroInvalidoException {
        Unidad unaUnidad = new Catapulta();
        Coordenada unaCoordenada = new Coordenada(1,1);
        pruebaTablero.ubicarUnidad(unaUnidad,unaCoordenada);
        Assert.assertFalse(pruebaTablero.tableroEstaVacio());
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void unidadNoSePuedeColocarEnPosicionOcupada() throws CasilleroOcupadoException, CasilleroInvalidoException {
        Unidad unaUnidad = new Jinete();
        Unidad otraUnidad = new Jinete();
        Coordenada unaCoordenada = new Coordenada(1,1);
        pruebaTablero.ubicarUnidad(unaUnidad, unaCoordenada);
        pruebaTablero.ubicarUnidad(otraUnidad, unaCoordenada);
        Assert.fail();
    }

    @Test
    public void JugadorNoPuedeUbicarUnidadEnSectorEnemigo() {
        Jugador unJugador = new Jugador("juan", pruebaTablero, 1);
        Unidad unaUnidad = new Catapulta();
        Coordenada coordenada = new Coordenada(2,15);
        unJugador.ubicarUnidad(unaUnidad, coordenada);
        Assert.assertFalse(unJugador.ubicarUnidad(unaUnidad, coordenada));
    }

    @Test
    public void tableroAsignaUnidadesContiguasCorrectamente() throws CasilleroInvalidoException, CasilleroOcupadoException{
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(2,4);
        Coordenada coordenadaCurandero = new Coordenada(3,5);
        Coordenada coordenadaCatapulta = new Coordenada(1,5);
        Coordenada coordenadaSoldado1 = new Coordenada(3,1);
        Coordenada coordenadaSoldado2 = new Coordenada(2,3);
        pruebaTablero.ubicarUnidad(jinete, coordenadaJinete);
        pruebaTablero.ubicarUnidad(curandero, coordenadaCurandero);
        pruebaTablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        pruebaTablero.ubicarUnidad(soldado1, coordenadaSoldado1);
        pruebaTablero.ubicarUnidad(soldado2, coordenadaSoldado2);

        Assert.assertEquals(pruebaTablero.obtenerUnidadesContiguas(jinete).size(), 3);
        Assert.assertEquals(pruebaTablero.obtenerUnidadesContiguas(curandero).size(), 1);
        Assert.assertEquals(pruebaTablero.obtenerUnidadesContiguas(catapulta).size(), 1);
        Assert.assertEquals(pruebaTablero.obtenerUnidadesContiguas(soldado1).size(), 0);
        Assert.assertEquals(pruebaTablero.obtenerUnidadesContiguas(soldado2).size(), 1);
    }

}
