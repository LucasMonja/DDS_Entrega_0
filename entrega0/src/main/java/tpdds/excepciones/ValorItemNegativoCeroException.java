package tpdds.excepciones;


public class ValorItemNegativoCeroException extends Exception {

    private static final long serialVersionUID = 1L;
    private int codigoError;

    public ValorItemNegativoCeroException(int codigoError) {
        super();
        this.codigoError = codigoError;
    }

    @Override
    public String getMessage(){

        String mensaje="";

        switch(codigoError){
            case 0:
                mensaje="Error, nosotros no regalamos productos.";
                break;
            case 1:
                mensaje="Error, no se pueden asignar precios negativos.";
                break;
        }
        return mensaje;
        
    }
    

}