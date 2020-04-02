package tpdds;

import tpdds.excepciones.ValorItemNegativoCeroException;

public class Item {
    private Double valor;
    private String nombreArticulo;

    public Item(String nombre, Double precio){
        this.valor = precio;
        this.nombreArticulo = nombre;

    }

    public Double get_precio(){
        return this.valor;

    }

    public void cambiarPrecio(Double precio){
        try {
            if(precio < 0){
                throw new ValorItemNegativoCeroException(0);
            }else if (precio == 0){
                throw new ValorItemNegativoCeroException(1);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.valor = precio;
    }

    public String get_nombre() {
        return this.nombreArticulo;

    }
} 