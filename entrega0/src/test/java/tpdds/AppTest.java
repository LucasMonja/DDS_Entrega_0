package tpdds;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class AppTest 
{
    private Item jabon;
    private Item alcoholEnGel;
    private Item lavandina;
    private Item electricista;
    private Egreso egreso;
    private Organizacion organicazion;

    @Before
    public void init() {
        this.jabon = new Item("Jabon", 40.50, false);
        this.alcoholEnGel = new Item("Alcohol en Gel", 500.0, false);
        this.lavandina = new Item("Lavandina", 320.0, false);
        this.electricista = new Item("Electircista", 400.0, true);
        this.egreso = new Egreso();
    }

    @Test
    public void seAgreganItems()
    {
        
        this.egreso.agregar_item(this.jabon);
        this.egreso.agregar_item(this.alcoholEnGel);
        this.egreso.agregar_item(this.lavandina);
        assertTrue( this.egreso.get_listaItems().size() == 3 );
    }

    @Test
    public void egresoCalculaPrecio(){
        this.egreso.agregar_item(this.jabon);
        this.egreso.agregar_item(this.alcoholEnGel);
        assertTrue(this.egreso.monto_a_cobrar() == 540.50);
        
    }

    @Test
    public void egresoVacioDevuelveCero(){
        assertTrue(this.egreso.monto_a_cobrar() == 0);

    }

    @Test
    public void egresoCerradoNoCambiaPrecio(){
        this.egreso.agregar_item(this.jabon);
        this.egreso.agregar_item(this.alcoholEnGel);
        Double valor1 = this.egreso.monto_a_cobrar();
        this.egreso.cerrar_egreso();
        this.alcoholEnGel.cambiarPrecio(10.0);
        Double valor2 = this.egreso.monto_a_cobrar();
        assertTrue(valor1 == valor2);

    }

    @Test
    public void generaRemito(){
        this.organicazion = new Organizacion();
        this.egreso.agregar_item(this.jabon);
        this.egreso.agregar_item(this.alcoholEnGel);
        this.organicazion.agregar_egreso(this.egreso);
        this.organicazion.operacion(this.egreso);
        assertTrue(this.organicazion.get_remitos().size() == 1);

    }

    @Test
    public void noGeneraRemito(){
        this.organicazion = new Organizacion();
        this.egreso.agregar_item(this.jabon);
        this.egreso.agregar_item(this.alcoholEnGel);
        this.egreso.agregar_item((this.electricista));
        this.organicazion.agregar_egreso(this.egreso);
        this.organicazion.operacion(this.egreso);
        assertTrue(this.organicazion.get_remitos().size() == 0);

    }
}
