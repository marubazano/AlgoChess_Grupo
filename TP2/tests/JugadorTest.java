import org.junit.*;

public class JugadorTest {
    private Tablero tablero = new Tablero();
    private Jugador pruebaJugador = new Jugador("Juan", tablero, 1);

    @Test
    public void JugadorSeCreaConNombre(){
        Assert.assertEquals(pruebaJugador.obtenerNombre(), "Juan");
    }

    @Test
    public void seAgregaUnidadAlJugador(){
        Unidad prueba = new Catapulta();
        pruebaJugador.agregarUnidadAJugador(prueba);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void seAgregaUnidadesAlJugador(){
        Unidad prueba_1 = new Catapulta();
        Unidad prueba_2 = new Curandero();
        Unidad prueba_3 = new Jinete();
        Unidad prueba_4 = new SoldadoDeInfanteria();
        pruebaJugador.agregarUnidadAJugador(prueba_1);
        pruebaJugador.agregarUnidadAJugador(prueba_2);
        pruebaJugador.agregarUnidadAJugador(prueba_3);
        pruebaJugador.agregarUnidadAJugador(prueba_4);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 4);
    }

    @Test
    public void jugadorNoTieneUnidades(){
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 0);
    }

    @Test
    public void puedeComprarUnaUnidad() {
        Unidad catapulta = new Catapulta();
        pruebaJugador.comprarUnidad(catapulta);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void puedeComprarVariasUnidades() {
        Unidad catapulta = new Catapulta();
        Unidad jinete = new Jinete();
        Unidad soldado = new SoldadoDeInfanteria();
        pruebaJugador.comprarUnidad(catapulta);
        pruebaJugador.comprarUnidad(jinete);
        pruebaJugador.comprarUnidad(soldado);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 3);
    }

    @Test(expected = PuntosInsuficientesException.class)
    public void tiraExceptionCuandoNoTieneSuficientesPuntos() throws PuntosInsuficientesException {
        Unidad catapulta_1 = new Catapulta();
        Unidad catapulta_2 = new Catapulta();
        Unidad catapulta_3 = new Catapulta();
        Unidad soldado = new SoldadoDeInfanteria();
        Unidad catapulta_4 = new Catapulta();
        pruebaJugador.comprarUnidad(catapulta_1);
        pruebaJugador.comprarUnidad(catapulta_2);
        pruebaJugador.comprarUnidad(catapulta_3);
        pruebaJugador.comprarUnidad(soldado);
        pruebaJugador.comprar(catapulta_4);
    }

    @Test
    public void jugadorPuedeUbicarUnidadEnCasilleroVacio(){
        Unidad unaUnidad = new Catapulta();
        Coordenada coordenada = new Coordenada(2,4);
        Tablero tablero = new Tablero();
        Assert.assertFalse(tablero.obtenerCasillero(coordenada).estaOcupado());
        pruebaJugador.ubicarUnidad(tablero, unaUnidad, coordenada);
        Assert.assertTrue(tablero.obtenerCasillero(coordenada).estaOcupado());
    }

}