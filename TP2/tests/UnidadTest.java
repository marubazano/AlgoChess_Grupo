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
}