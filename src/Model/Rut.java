package Model;

import ExceptionPersona.RutInvalidoException;
import Util.UtilRut;

public class Rut {
    private String rut;

    /**
     * Contructor de la clase
     * @param rut: Rut de la persona
     * @throws RutInvalidoException si el rut no es válido
     */
    public Rut(String rut) throws RutInvalidoException{        
        UtilRut util = new UtilRut();
        
        if(util.ValidarRut(rut))
            this.rut = rut;    
    }

    public String getRut() {
        return rut;
    }
/**setter de rut
 * @param rut: rut de la persona
 * @throws RutInvalidoException si el rut no es válido
 */
    public void setRut(String rut) throws RutInvalidoException{
        UtilRut util = new UtilRut();
        
        if(util.ValidarRut(rut))
            this.rut = rut;
    }
    
    @Override
    public String toString(){
        return "Rut: " + this.rut;
    }
    
}
