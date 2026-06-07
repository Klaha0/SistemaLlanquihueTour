package Model;

import ExceptionPersona.PersonaException;
import Util.UtilPersona;

public class Persona {
    private String nombre;
    private int edad;
    private Rut rut;
    private Direccion direccion;

    public Persona(String nombre, int edad, Rut rut, Direccion direccion) 
           throws PersonaException
    {
        UtilPersona util = new UtilPersona();
        if(util.ValidarNombre(nombre))            
            this.nombre = nombre;
        
        if(util.ValidarEdad(edad))
            this.edad = edad;
        
        this.rut = rut;
        this.direccion = direccion;
    }

    public String getNombre() 
    {
        return nombre;
    }

 /**
 * Setter de nombre
 * se verifican que los datos sean correctos
 * @param nombre: nombre de la persona
 * @throws PersonaException si no es válida
 */
    public void setNombre(String nombre) throws PersonaException{
        UtilPersona util = new UtilPersona();
        if(!util.ValidarNombre(nombre))
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

 /**
 * Setter de edad
 * se verifican que los datos sean correctos
 * @param edad: Edad de la persona
 * @throws PersonaException
 */
    public void setEdad(int edad) throws PersonaException{
        UtilPersona util = new UtilPersona();
        if(util.ValidarEdad(edad))
        this.edad = edad;

    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + 
               "\nEdad: " + this.edad 
                + "\n" + this.rut.toString() + 
                "\n" + this.direccion.toString()+"\n";
    }
    
    
}
