package Model;

import ExceptionPersona.DireccionException;
import ExceptionPersona.PersonaException;
import ExceptionPersona.RutInvalidoException;
import static java.util.Objects.isNull;

public class Empleado extends Persona{
    private String cargo;

    /**
     * Constructor del Empleado
     * @param nombre: del empleado
     * @param edad: del empleado 
     * @param rut: del empleado
     * @param direccion: del empleado
     * @param cargo: del empleado
     * @throws DireccionException si los datos la dirección no es válida
     * @throws RutInvalidoException si el Rut no es válido
     * @throws PersonaException si los datos de la persona no son válidos
     */
    public Empleado(String nombre, int edad, Rut rut, Direccion direccion, String cargo) 
    throws DireccionException, RutInvalidoException, PersonaException
    {
        super(nombre, edad, rut, direccion);
        if(isNull(cargo) || cargo.trim().isEmpty())
            throw new PersonaException("El cargo no debe ser nulo o vacío");
        this.cargo = cargo; 
    }    

    public String getCargo() {
        return cargo;
    }

/**
 * Setter de cargo
 * se verifican que los datos sean correctos
 * @param cargo: cargo del empleado
 * @throws PersonaException si los datos no son válidos
 */
    public void setCargo(String cargo) throws PersonaException{
        if(isNull(cargo) || cargo.trim().isEmpty())
            throw new PersonaException("El cargo no debe ser nulo o vacío");
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Cargo: " + this.cargo;
    }
}
