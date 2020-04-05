package tpdds;

import java.util.ArrayList;

public class Organizacion {

    private ArrayList<Egreso> egresos;
    private ArrayList<Remito> remitos;
    private Double saldo;

    public Organizacion(){
        this.egresos = new ArrayList<Egreso>();
        this.remitos = new ArrayList<Remito>();
        this.saldo = 1000.0;

    }

    public void operacion(Egreso egreso){
        Double gasto = egreso.monto_a_cobrar();
        if(gasto < saldo){
            if(!egreso.hay_servicios()){
                remitos.add(new Remito());
            }
        }else{
            System.out.println("No tiene saldo suficiente para ejecutar esta operación.");
        }
        return;

    }

    public void agregar_egreso(Egreso egreso){
        this.egresos.add(egreso);
        return;
    }

    public ArrayList<Remito> get_remitos(){
        return this.remitos;
    }


}