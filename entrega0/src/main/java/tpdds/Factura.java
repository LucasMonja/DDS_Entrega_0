package tpdds;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public class Factura {
    private ArrayList<Item> listaArticulos;
    private boolean cerrada;
    private Double costoFinal;

    public Factura(){
        this.cerrada = false;
        this.listaArticulos = new ArrayList<Item>();
    }

    public Double monto_a_cobrar(){
        if (cerrada){
            return costoFinal;
        }else{
        
            List<Double> listaPrecios = this.listaArticulos.stream().map(item -> item.get_precio()).collect(Collectors.toList());
            this.costoFinal = listaPrecios.stream().mapToDouble(f -> f.doubleValue()).sum();
            return costoFinal;
        }
    }

    public void agregar_item(Item item) {
        if(this.cerrada){
            System.out.println("La Factura está cerrada, no se puede agregar items");
            return;
        }else{
            this.listaArticulos.add(item);
            return;
        }
    }

    public void quitar_item(Item item) {
        if(this.cerrada){
            System.out.println("La Factura está cerrada, no se pueden quitar items");
            return;
        }else{
            this.listaArticulos.remove(item);
            return;
        }
    }
        

    public void cerrar_factura(){
        this.cerrada = true;
    }

    public List<Item> get_listaItems(){
        return this.listaArticulos;
    }
} 