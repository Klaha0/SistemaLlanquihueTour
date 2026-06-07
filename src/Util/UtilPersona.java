package Util;
import ExceptionPersona.PersonaException;
import static java.util.Objects.isNull;

public class UtilPersona{
    
    /**
     * Método ValidarNombre
     * @param nombre: nombre de la persona
     * @return true si el campo es válido
     * @throws PersonaException si el campo no es válido
     */           
    public boolean ValidarNombre(String nombre) throws PersonaException{
        if(isNull(nombre))
        {
            throw new PersonaException("El campo nombre no debe ser nulo");            
        }
        if(nombre.trim().isBlank())
        {
            throw new PersonaException("El campo nombre no estar en blanco");            
        }
        return true;
    }
    
    /**
     * Método ValidarEdad
     * @param edad: Edad de la persona.
     * @return true si el campo es válido
     * @throws PersonaException si el campo no es válido.
     */ 
    public boolean ValidarEdad(int edad) throws PersonaException{
        if(edad < 0)
        {
            throw new PersonaException("La edad debe ser mayor o igual a 0");
        }
        return true;
    }
}
