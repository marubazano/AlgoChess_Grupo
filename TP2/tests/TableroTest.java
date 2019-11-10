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

    @Test
    public void batallonSeMueveCorrectamente() throws CasilleroOcupadoException, CasilleroInvalidoException{
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(4, 5);
        Coordenada coordenada2 = new Coordenada(4, 6);
        Coordenada coordenada3 = new Coordenada(4, 7);
        Coordenada coordenadaDestino1 = new Coordenada(5, 5);
        Coordenada coordenadaDestino2 = new Coordenada(5, 6);
        Coordenada coordenadaDestino3 = new Coordenada(5, 7);
        pruebaTablero.ubicarUnidad(soldado1, coordenada1);
        pruebaTablero.ubicarUnidad(soldado2, coordenada2);
        pruebaTablero.ubicarUnidad(soldado3, coordenada3);
        pruebaTablero.mover(soldado2, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteEnElLimite() throws CasilleroOcupadoException, CasilleroInvalidoException{
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(1, 1);
        Coordenada coordenada2 = new Coordenada(1, 2);
        Coordenada coordenada3 = new Coordenada(1, 3);
        Coordenada coordenadaDestino1 = new Coordenada(2, 1);
        Coordenada coordenadaDestino2 = new Coordenada(2, 2);
        Coordenada coordenadaDestino3 = new Coordenada(2, 3);
        pruebaTablero.ubicarUnidad(soldado1, coordenada1);
        pruebaTablero.ubicarUnidad(soldado2, coordenada2);
        pruebaTablero.ubicarUnidad(soldado3, coordenada3);
        pruebaTablero.mover(soldado2, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteConObstaculo() throws CasilleroOcupadoException, CasilleroInvalidoException{
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenada1 = new Coordenada(1, 1);
        Coordenada coordenada2 = new Coordenada(1, 2);
        Coordenada coordenada3 = new Coordenada(1, 3);
        Coordenada coordenada4 = new Coordenada(2, 2);
        Coordenada coordenadaDestino1 = new Coordenada(2, 1);
        Coordenada coordenadaDestino3 = new Coordenada(2, 3);
        pruebaTablero.ubicarUnidad(soldado1, coordenada1);
        pruebaTablero.ubicarUnidad(soldado2, coordenada2);
        pruebaTablero.ubicarUnidad(soldado3, coordenada3);
        pruebaTablero.ubicarUnidad(curandero, coordenada4);
        pruebaTablero.mover(soldado2, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenada2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }



}
