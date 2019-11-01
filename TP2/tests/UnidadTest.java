import org.junit.*;
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

    @Test
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
    }
}