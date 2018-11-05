package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    Varasto varasto3;
    Varasto varasto4;
    Varasto varasto5;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(-10);
        varasto3 = new Varasto(10, 15);
        varasto4 = new Varasto(-10, -5);
        varasto5 = new Varasto(10, 5);         
    }

    @Test
    public void negatiivinenVaraston() {
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, varasto4.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(10, varasto3.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto4.getSaldo(), vertailuTarkkuus);
        assertEquals(5, varasto5.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
        varasto3.lisaaVarastoon(-8);
        
        
// saldon pitäisi olla sama kun lisätty määrä
        
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
        varasto.lisaaVarastoon(8);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
        
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminen() {
        
        double saatuMaara = varasto.otaVarastosta(-2);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
        
        double saatuMaara2 = varasto5.otaVarastosta(7);
        assertEquals(5, saatuMaara2, vertailuTarkkuus);
        assertEquals(0, varasto5.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void gstringi() {
        String asd = varasto5.toString();
        assertEquals("saldo = 5.0, vielä tilaa 5.0", asd);
    }
    
}