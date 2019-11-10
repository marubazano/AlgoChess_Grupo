import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Tablero.Tablero;
import Unidades.Catapulta;
import Unidades.Jinete;
import Unidades.Unidad;
import org.junit.*;
import Tablero.*;
import Unidades.*;
import Excepciones.*;

public class TableroTest {
    private Tablero pruebaTablero = new Tablero();

    @Test
    public void tableroSeCreaVacio(){
        Assert.assertTrue(pruebaTablero.tableroEstaVacio());
    }

    @Test
    public void unidadSeUbicaConExitoEnElTablero() throws CasilleroOcupadoException, CasilleroInvalidoException {
        Unidad unaUnidad = new Catapulta();
        Coordenada unaCoordenada = new Coordenada(1,1);
        pruebaTablero.ubicarUnidad(unaUnidad,unaCoordenada);
        Assert.assertFalse(pruebaTablero.tableroEstaVacio());
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void unidadNoSePuedeColocarEnPosicionOcupada() throws CasilleroOcupadoException, CasilleroInvalidoException {
        Unidad unaUnidad = new Jinete();
        Unidad otraUnidad = new Jinete();
        Coordenada unaCoordenada = new Coordenada(1,1);
        pruebaTablero.ubicarUnidad(unaUnidad, unaCoordenada);
        pruebaTablero.ubicarUnidad(otraUnidad, unaCoordenada);
    }

    @Test
    public void JugadorNoPuedeUbicarUnidadEnSectorEnemigo(){
        Jugador unJugador = new Jugador("juan", pruebaTablero, 1);
        Unidad unaUnidad = new Catapulta();
        Coordenada coordenada = new Coordenada(2,15);
        unJugador.ubicarUnidad(unaUnidad, coordenada);
        Assert.assertFalse(unJugador.ubicarUnidad(unaUnidad, coordenada));
    }
/*
    @Test
    public void tableroAsignaUnidadesContiguasCorrectamente() throws Excepciones.CasilleroInvalidoException, Excepciones.CasilleroOcupadoException{
        Unidades.Jinete jinete = new Unidades.Jinete();
        Unidades.Curandero curandero = new Unidades.Curandero();
        Unidades.Catapulta catapulta = new Unidades.Catapulta();
        Unidades.SoldadoDeInfanteria soldado = new Unidades.SoldadoDeInfanteria();
        Tablero.Coordenada coordenadaJinete = new Tablero.Coordenada(2,4);
        Tablero.Coordenada coordenadaCurandero = new Tablero.Coordenada(3,5);
        Tablero.Coordenada coordenadaCatapulta = new Tablero.Coordenada(1,5);
        Tablero.Coordenada coordenadaSoldado = new Tablero.Coordenada(3,2);
        pruebaTablero.ubicarUnidad(jinete, coordenadaJinete);
        pruebaTablero.ubicarUnidad(curandero, coordenadaCurandero);
        pruebaTablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        pruebaTablero.ubicarUnidad(soldado, coordenadaSoldado);

        Assert.assertEquals(jinete.obtenerUnidadesContiguas().size(), 2);
        Assert.assertEquals(curandero.obtenerUnidadesContiguas().size(), 1);
        Assert.assertEquals(catapulta.obtenerUnidadesContiguas().size(), 1);
        Assert.assertEquals(soldado.obtenerUnidadesContiguas().size(), 0);
    }*/
}
