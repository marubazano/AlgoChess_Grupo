import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Excepciones.PuntosInsuficientesException;
import Tablero.Tablero;
import Unidades.*;
import org.junit.*;
import Tablero.*;
import Unidades.*;
import Excepciones.*;

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
    public void puedeComprarUnaUnidad() throws PuntosInsuficientesException {
        Unidad catapulta = new Catapulta();
        pruebaJugador.comprar(catapulta);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void puedeComprarVariasUnidades() throws PuntosInsuficientesException {
        Unidad catapulta = new Catapulta();
        Unidad jinete = new Jinete();
        Unidad soldado = new SoldadoDeInfanteria();
        pruebaJugador.comprar(catapulta);
        pruebaJugador.comprar(jinete);
        pruebaJugador.comprar(soldado);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 3);
    }

    @Test(expected = PuntosInsuficientesException.class)
    public void tiraExceptionCuandoNoTieneSuficientesPuntos() throws PuntosInsuficientesException {
        Unidad catapulta_1 = new Catapulta();
        Unidad catapulta_2 = new Catapulta();
        Unidad catapulta_3 = new Catapulta();
        Unidad soldado = new SoldadoDeInfanteria();
        Unidad catapulta_4 = new Catapulta();
        pruebaJugador.comprar(catapulta_1);
        pruebaJugador.comprar(catapulta_2);
        pruebaJugador.comprar(catapulta_3);
        pruebaJugador.comprar(soldado);
        pruebaJugador.comprar(catapulta_4);
    }

    @Test
    public void jugadorPuedeUbicarUnidadEnCasilleroVacio() throws CasilleroInvalidoException {
        Unidad unaUnidad = new Catapulta();
        Coordenada coordenada = new Coordenada(2,4);
        Assert.assertFalse(tablero.obtenerCasillero(coordenada).estaOcupado());
        pruebaJugador.ubicarUnidad(unaUnidad, coordenada);
        Assert.assertTrue(tablero.obtenerCasillero(coordenada).estaOcupado());
    }

    @Test
    public void jugadorPuedeMoverUnidadEnDireccion() {
        Curandero unidadMovible = new Curandero();
        Coordenada coordenada = new Coordenada(2,4);
        Coordenada destino = new Coordenada(3, 4);
        pruebaJugador.ubicarUnidad(unidadMovible, coordenada);
        pruebaJugador.mover(unidadMovible, Direccion.ABAJO);
        Assert.assertTrue(unidadMovible.obtenerCoordenada().compararCoordenada(destino));
    }

    @Test
    public void jugadorNoPuedeMoverUnidadACasilleroOcupado() throws CasilleroOcupadoException {
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Curandero otroCurandero = new Curandero();
        Coordenada coordenada = new Coordenada(2,5);
        Coordenada otraCoordenada = new Coordenada(3,5);
        Coordenada yetAnotherCoordenada = new Coordenada(2,6);
        pruebaJugador.ubicarUnidad(soldado, coordenada);
        pruebaJugador.ubicarUnidad(curandero, otraCoordenada);
        pruebaJugador.ubicarUnidad(otroCurandero, yetAnotherCoordenada);
        pruebaJugador.mover(curandero, Direccion.ARRIBA);
        pruebaJugador.mover(otroCurandero, Direccion.IZQUIERDA);
    }

    @Test
    public void jugadorPuedeMoverUnidadEnTodasLasDirecciones(){
        Jinete jinete = new Jinete();
        Coordenada coordenada = new Coordenada(4,6);
        pruebaJugador.ubicarUnidad(jinete, coordenada);
        for (Direccion dir : Direccion.values()) {
            Coordenada esperada = jinete.obtenerCoordenada().desplazar(dir);
            pruebaJugador.mover(jinete, dir);
            Assert.assertTrue(jinete.obtenerCoordenada().compararCoordenada(esperada)); //Comparo la coordenada actual del jinete
                                                                                        //Con la coordenada que se espera.
        }
    }

    @Test
    public void jugadorSeQuedaSinUnidadesEsPerdedor(){
        Assert.assertEquals(pruebaJugador.obtenerEstado(),"JUGANDO");
        Jinete jinete = new Jinete();
        Coordenada coordenada = new Coordenada(4,6);
        pruebaJugador.ubicarUnidad(jinete, coordenada);
        pruebaJugador.eliminarUnidadDelJugador(jinete);
        Assert.assertEquals(pruebaJugador.obtenerEstado(),"PERDEDOR");
    }

    @Test
    public void jugadorSeQuedaSinUnidadesEsPerdedorConVariasUnidades(){
        Assert.assertEquals(pruebaJugador.obtenerEstado(),"JUGANDO");
        Jinete jinete = new Jinete();
        Coordenada coordenada = new Coordenada(4,6);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenada2 = new Coordenada(1,2);
        pruebaJugador.ubicarUnidad(jinete, coordenada);
        pruebaJugador.ubicarUnidad(soldado,coordenada2);
        pruebaJugador.eliminarUnidadDelJugador(jinete);
        Assert.assertEquals(pruebaJugador.obtenerEstado(),"JUGANDO");
        pruebaJugador.eliminarUnidadDelJugador(soldado);
        Assert.assertEquals(pruebaJugador.obtenerEstado(),"PERDEDOR");
    }

    @Test
    public void jugadorNoPuedeMoverUnidadFueraDelTablero() {
        Jinete jinete = new Jinete();
        Coordenada coordenada = new Coordenada(1,1);
        pruebaJugador.ubicarUnidad(jinete, coordenada);
        pruebaJugador.mover(jinete, Direccion.ARRIBA);
        pruebaJugador.mover(jinete, Direccion.IZQUIERDA);
        pruebaJugador.mover(jinete, Direccion.DIAGONALSUPERIORDERECHA);
        pruebaJugador.mover(jinete, Direccion.DIAGONALSUPERIORIZQUIERDA);
        Assert.assertTrue(jinete.obtenerCoordenada().compararCoordenada(new Coordenada(1,1)));
    }

}