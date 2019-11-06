import org.junit.*;

import java.time.temporal.ChronoUnit;

/*
   Al ser abstracta, tenemos que usar un objeto
   tipo mock, no heredados de unidad.
 */
public class UnidadTest {
    private Unidad prueba;

    @Before
    public void setUp() {
        prueba = new SoldadoDeInfanteria();
    }

    @After
    public void tearDown() {
        prueba = null;
    }

    @Test
    public void unidadRecibeDanioYActualizaVida(){
        prueba.recibirDaño(20);
        Assert.assertEquals(80, prueba.obtenerVida(), 0.01); //Delta agregado para comparar flotantes, doubles

    }

    /*@Test
    public void unidadSePuedeUbicarEnCasilleroDesocupado(){
        Casillero unCasillero = new Casillero();
        prueba.ubicar(unCasillero);
        Assert.assertTrue(unCasillero.estaOcupado());
    }

    //Lanzar excepcion si casillero ocupado
    @Test
    public void unidadNoPuedeUbicarseEnCasilleroOcupado(){
        Casillero unCasillero = new Casillero();
        Unidad otraUnidad = new Catapulta();
        prueba.ubicar(unCasillero);
        otraUnidad.ubicar(unCasillero);
    }*/

    @Test
    public void SoldadoAtacaEnemigo(){
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        soldado.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==90);
        Assert.assertTrue(soldado.obtenerVida()==100);
    }

    @Test
    public void CatapultaAtacaEnemigo(){
        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        catapulta.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }


    @Test
    public void curanderoCuraAUnidadAliada(){
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        jinete.recibirDaño(50);
        Assert.assertTrue(jinete.obtenerVida()==50);
        curandero.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==65);

    }

    @Test
    public void unidadSeUbicaEnCoordenadaCorrespondiente(){
        Curandero curandero = new Curandero();
    }

}