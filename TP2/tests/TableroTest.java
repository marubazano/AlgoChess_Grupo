import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import org.junit.*;
import Tablero.*;
import Unidades.*;
import Excepciones.*;

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

    @Test
    public void batallonSeMueveCorrectamente() throws CasilleroOcupadoException, CasilleroInvalidoException {
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
        pruebaTablero.moverBatallon(soldado1, soldado2, soldado3, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteEnElLimite() throws CasilleroOcupadoException, CasilleroInvalidoException {
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
        pruebaTablero.moverBatallon(soldado1, soldado2, soldado3, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteSiSeMueveElDeUnaPunta() throws CasilleroOcupadoException, CasilleroInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(1, 1);
        Coordenada coordenada2 = new Coordenada(1, 2);
        Coordenada coordenada3 = new Coordenada(2, 2);
        Coordenada coordenadaDestino1 = new Coordenada(2, 1);
        Coordenada coordenadaDestino2 = new Coordenada(2, 2);
        Coordenada coordenadaDestino3 = new Coordenada(3, 2);
        pruebaTablero.ubicarUnidad(soldado1, coordenada1);
        pruebaTablero.ubicarUnidad(soldado2, coordenada2);
        pruebaTablero.ubicarUnidad(soldado3, coordenada3);
        pruebaTablero.moverBatallon(soldado1, soldado2, soldado3, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteConObstaculo() throws CasilleroOcupadoException, CasilleroInvalidoException {
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
        pruebaTablero.moverBatallon(soldado1, soldado2, soldado3, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenada2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonHabiendoCuatroSoldadosSeMuevenTres() throws CasilleroOcupadoException, CasilleroInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado4 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(4, 5);
        Coordenada coordenada2 = new Coordenada(4, 6);
        Coordenada coordenada3 = new Coordenada(4, 7);
        Coordenada coordenada4 = new Coordenada(4, 8);
        Coordenada coordenadaDestino1 = new Coordenada(5, 5);
        Coordenada coordenadaDestino2 = new Coordenada(5, 6);
        Coordenada coordenadaDestino3 = new Coordenada(5, 7);
        pruebaTablero.ubicarUnidad(soldado1, coordenada1);
        pruebaTablero.ubicarUnidad(soldado2, coordenada2);
        pruebaTablero.ubicarUnidad(soldado3, coordenada3);
        pruebaTablero.ubicarUnidad(soldado4, coordenada4);
        pruebaTablero.moverBatallon(soldado1, soldado2, soldado3, Direccion.ABAJO);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenada4).obtenerUnidad(), soldado4);
    }

    @Test
    public void batallonEnLineaRectaConObstaculoNoSeMueve() throws CasilleroOcupadoException, CasilleroInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenada1 = new Coordenada(4, 5);
        Coordenada coordenada2 = new Coordenada(4, 6);
        Coordenada coordenada3 = new Coordenada(4, 7);
        Coordenada coordenadaCurandero = new Coordenada(4, 8);
        pruebaTablero.ubicarUnidad(soldado1, coordenada1);
        pruebaTablero.ubicarUnidad(soldado2, coordenada2);
        pruebaTablero.ubicarUnidad(soldado3, coordenada3);
        pruebaTablero.ubicarUnidad(curandero, coordenadaCurandero);
        pruebaTablero.moverBatallon(soldado1, soldado2, soldado3, Direccion.DERECHA);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenada1).obtenerUnidad(), soldado1);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenada2).obtenerUnidad(), soldado2);
        Assert.assertEquals(pruebaTablero.obtenerCasillero(coordenada3).obtenerUnidad(), soldado3);
    }
}
