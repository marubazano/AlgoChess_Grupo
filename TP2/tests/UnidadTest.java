import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Tablero.Tablero;
import Unidades.*;
import org.junit.*;
import Tablero.*;
import Unidades.*;
import Excepciones.*;

import java.util.ArrayList;

/*
   Al ser abstracta, tenemos que usar un objeto
   tipo mock, no heredados de unidad.
 */
public class UnidadTest {
    private Unidad prueba;
    private Tablero tablero = new Tablero();

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
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
    }


    @Test
    public void SoldadoAtacaEnemigo(){
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        soldado.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida()==90);
        Assert.assertTrue(soldado.obtenerVida()==100);
    }

    @Test
    public void CatapultaAtacaEnemigo() throws CasilleroOcupadoException, CasilleroInvalidoException{
        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        Coordenada coordJinete = new Coordenada(10,5);
        tablero.ubicarUnidad(jinete,coordJinete);
        Assert.assertTrue(jinete.obtenerVida()==100);
        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }

    @Test
    public void CatapultaAtacaVariosEnemigosContiguos()throws CasilleroInvalidoException, CasilleroOcupadoException{
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(14,14);
        Coordenada coordenadaCurandero = new Coordenada(14,15);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaSoldado = new Coordenada(15,15);
        Coordenada coordenadaJinete2 = new Coordenada(16,16);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);

        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 80);
        Assert.assertTrue(soldado.obtenerVida() == 80);
        Assert.assertTrue(curandero.obtenerVida() == 55);
        Assert.assertTrue(jinete2.obtenerVida() == 80);
        Assert.assertTrue(catapulta.obtenerVida() == 50);

        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 60);
        Assert.assertTrue(soldado.obtenerVida() == 60);
        Assert.assertTrue(curandero.obtenerVida() == 35);
        Assert.assertTrue(jinete2.obtenerVida() == 60);
        Assert.assertTrue(catapulta.obtenerVida() == 50);
    }

    @Test
    public void CataputalAtacaUnidadesEnLineaRecta()throws CasilleroInvalidoException, CasilleroOcupadoException{
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Curandero curandero2 = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(14,14);
        Coordenada coordenadaCurandero = new Coordenada(15,14);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaSoldado = new Coordenada(16,14);
        Coordenada coordenadaJinete2 = new Coordenada(17,14);
        Coordenada coordenadaCurandero2 = new Coordenada(18,14);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(curandero2, coordenadaCurandero2);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);
        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(soldado.obtenerVida()==80);
        Assert.assertTrue(curandero.obtenerVida()==55);
        Assert.assertTrue(curandero2.obtenerVida()==55);
        Assert.assertTrue(jinete2.obtenerVida()==80);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }

    @Test
    public void CatapultaAtacaYNoDaniaAEnemigosNoContiguos()throws CasilleroInvalidoException, CasilleroOcupadoException {
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        Coordenada coordenadaJinete = new Coordenada(14,14);
        Coordenada coordenadaCurandero = new Coordenada(14,15);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaJinete2 = new Coordenada(18,18);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);

        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(curandero.obtenerVida()==55);
        Assert.assertTrue(jinete2.obtenerVida()==100);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }


    @Test
    public void curanderoCuraAUnidadAliada(){
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        jinete.recibirDaño(50);
        Assert.assertTrue(jinete.obtenerVida()==50);
        curandero.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida()==65);
    }

    @Test
    public void jineteAtacaEnemigoADistanciaMediaConArcoYFlecha()throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException {
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(11,11);
        Coordenada coordenadaCurandero = new Coordenada(13,13);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        unidadesAliadas.add(soldado);
        unidadesAliadas.add(jinete);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        jinete.realizarAccion(curandero, tablero, unidadesAliadas);
        Assert.assertTrue(curandero.obtenerVida()==60);
    }

    @Test
    public void jineteAtacaAUnidadEnemigaCercanaConEspada()throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException{
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(11,11);
        Coordenada coordenadaCurandero = new Coordenada(13,13);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        unidadesAliadas.add(curandero);
        unidadesAliadas.add(jinete);
        jinete.realizarAccion(soldado, tablero, unidadesAliadas);
        Assert.assertTrue(soldado.obtenerVida()==95);
    }

    @Test(expected = AccionInvalidaException.class)
    public void jineteFallaAlAtacarEnemigoLejano()throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException{
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(11,18);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        jinete.realizarAccion(soldado, tablero, unidadesAliadas);
        Assert.assertTrue(soldado.obtenerVida()==100);
    }

    @Test(expected = AccionInvalidaException.class)
    public void jineteFallaAlAtacarEnemigoCercanoTeniendoAliadosCerca() throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException{
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Catapulta catapulta = new Catapulta();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(10,9);
        Coordenada coordenadaCatapulta = new Coordenada(11,11);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        unidadesAliadas.add(catapulta);
        jinete.realizarAccion(soldado, tablero, unidadesAliadas);
        Assert.assertTrue(soldado.obtenerVida()==100);
    }
}