import Tablero.*;
import org.junit.*;

public class CoordenadaTest {

    @Test
    public void compararCoordenadaDevuelveTrueSiSonIgualesTest() {
        Coordenada coordenada  = new Coordenada(3, 4);
        Coordenada otraCoordenada = new Coordenada(3,4);
        Assert.assertTrue(coordenada.compararCoordenada(otraCoordenada));
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaArriba() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(4, 5);
        Assert.assertEquals(coordenada.desplazar(Direccion.ARRIBA), coordenadaDesplazada);
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaAbajo() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(6, 5);
        Assert.assertEquals(coordenada.desplazar(Direccion.ABAJO), coordenadaDesplazada);
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaIzquierda() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(5, 4);
        Assert.assertEquals(coordenada.desplazar(Direccion.IZQUIERDA), coordenadaDesplazada);
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaDerecha() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(5, 6);
        Assert.assertEquals(coordenada.desplazar(Direccion.DERECHA), coordenadaDesplazada);
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaArribaIzquierda() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(4, 4);
        Assert.assertEquals(coordenada.desplazar(Direccion.DIAGONALSUPERIORIZQUIERDA), coordenadaDesplazada);
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaArribaDerecha() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(4, 6);
        Assert.assertEquals(coordenada.desplazar(Direccion.DIAGONALSUPERIORDERECHA), coordenadaDesplazada);
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaAbajoIzquierda() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(6, 4);
        Assert.assertEquals(coordenada.desplazar(Direccion.DIAGONALINFERIORIZQUIERDA), coordenadaDesplazada);
    }

    @Test
    public void coordenadaSeDesplazaCorrectamenteHaciaAbajoDerecha() {
        Coordenada coordenada = new Coordenada(5, 5);
        Coordenada coordenadaDesplazada = new Coordenada(6, 6);
        Assert.assertEquals(coordenada.desplazar(Direccion.DIAGONALINFERIORDERECHA), coordenadaDesplazada);
    }

    @Test
    public void seCalculaCorrectamenteLaDistancia() {
        Coordenada coordenada1 = new Coordenada(2, 2);
        Coordenada coordenada2 = new Coordenada(2, 5);
        Coordenada coordenada3 = new Coordenada(4, 2);
        Coordenada coordenada4 = new Coordenada(3, 4);
        Coordenada coordenada5 = new Coordenada(20, 20);
        Coordenada coordenada6 = new Coordenada(6, 3);
        Assert.assertEquals(coordenada1.calcularDistacia(coordenada2), Distancia.MEDIANA);
        Assert.assertEquals(coordenada1.calcularDistacia(coordenada3), Distancia.CERCANA);
        Assert.assertEquals(coordenada1.calcularDistacia(coordenada4), Distancia.CERCANA);
        Assert.assertEquals(coordenada1.calcularDistacia(coordenada5), Distancia.LEJANA);
        Assert.assertEquals(coordenada1.calcularDistacia(coordenada6), Distancia.MEDIANA);
        Assert.assertEquals(coordenada2.calcularDistacia(coordenada3), Distancia.MEDIANA);
        Assert.assertEquals(coordenada2.calcularDistacia(coordenada4), Distancia.CERCANA);
        Assert.assertEquals(coordenada2.calcularDistacia(coordenada5), Distancia.LEJANA);
        Assert.assertEquals(coordenada2.calcularDistacia(coordenada6), Distancia.MEDIANA);
        Assert.assertEquals(coordenada3.calcularDistacia(coordenada4), Distancia.CERCANA);
        Assert.assertEquals(coordenada3.calcularDistacia(coordenada5), Distancia.LEJANA);
        Assert.assertEquals(coordenada3.calcularDistacia(coordenada6), Distancia.CERCANA);
        Assert.assertEquals(coordenada4.calcularDistacia(coordenada5), Distancia.LEJANA);
        Assert.assertEquals(coordenada4.calcularDistacia(coordenada6), Distancia.MEDIANA);
        Assert.assertEquals(coordenada5.calcularDistacia(coordenada6), Distancia.LEJANA);
    }

    @Test
    public void seCalculaCorrectamenteLaDistanciaNumerica() {
        Coordenada coordenada1 = new Coordenada(2, 2);
        Coordenada coordenada2 = new Coordenada(2, 5);
        Coordenada coordenada3 = new Coordenada(5, 6);
        Coordenada coordenada4 = new Coordenada(6, 3);
        Coordenada coordenada5 = new Coordenada(6, 2);
        Assert.assertEquals(coordenada1.distanciaNumerica(coordenada2), 3);
        Assert.assertEquals(coordenada1.distanciaNumerica(coordenada3), 4);
        Assert.assertEquals(coordenada1.distanciaNumerica(coordenada4), 4);
        Assert.assertEquals(coordenada2.distanciaNumerica(coordenada3), 3);
        Assert.assertEquals(coordenada2.distanciaNumerica(coordenada4), 4);
        Assert.assertEquals(coordenada3.distanciaNumerica(coordenada4), 3);
        Assert.assertEquals(coordenada4.distanciaNumerica(coordenada5), 1);
    }
}