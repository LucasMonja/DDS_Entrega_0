package tpdds;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class AppTest 
{
    private Item jabon;
    private Item alcoholEnGel;
    private Item lavandina;
    private Factura factura;

    @Before
    public void init() {
        this.jabon = new Item("Jabon", 40.50);
        this.alcoholEnGel = new Item("Alcohol en Gel", 500.0);
        this.lavandina = new Item("Lavandina", 320.0);
        this.factura = new Factura();
    }

    @Test
    public void seAgreganItems()
    {
        
        this.factura.agregar_item(this.jabon);
        this.factura.agregar_item(this.alcoholEnGel);
        this.factura.agregar_item(this.lavandina);
        assertTrue( this.factura.get_listaItems().size() == 3 );
    }

    @Test
    public void facturaCalculaPrecio(){
        this.factura.agregar_item(this.jabon);
        this.factura.agregar_item(this.alcoholEnGel);
        assertTrue(this.factura.monto_a_cobrar() == 540.50);
        
    }

    @Test
    public void facturaCerradaNoCambiaPrecio(){
        this.factura.agregar_item(this.jabon);
        this.factura.agregar_item(this.alcoholEnGel);
        Double valor1 = this.factura.monto_a_cobrar();
        this.factura.cerrar_factura();
        this.alcoholEnGel.cambiarPrecio(10.0);
        Double valor2 = this.factura.monto_a_cobrar();
        assertTrue(valor1 == valor2);

    }
}
