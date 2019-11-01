import org.junit.*;

public class UnidadTest {
    private Unidad prueba;

    @Before
    public void setUp() {
        prueba = new Unidad(100,10,null);
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
        Unidad otraUnidad = new Unidad(0,0,null);
        prueba.ubicar(unCasillero);
        otraUnidad.ubicar(unCasillero);
    }
}