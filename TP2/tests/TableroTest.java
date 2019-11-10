import org.junit.*;

public class TableroTest {
    private Tablero pruebaTablero = new Tablero();

    @Test
    public void tableroSeCreaVacio(){
        Assert.assertTrue(pruebaTablero.tableroEstaVacio());
    }

    @Test
    public void unidadSeUbicaConExitoEnElTablero() throws CasilleroOcupadoException, CasilleroInvalidoException{
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
    public void tableroAsignaUnidadesContiguasCorrectamente() throws CasilleroInvalidoException, CasilleroOcupadoException{
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(2,4);
        Coordenada coordenadaCurandero = new Coordenada(3,5);
        Coordenada coordenadaCatapulta = new Coordenada(1,5);
        Coordenada coordenadaSoldado = new Coordenada(3,2);
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
