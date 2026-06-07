package App;

import ExceptionPersona.DireccionException;
import ExceptionPersona.PersonaException;
import ExceptionPersona.RutInvalidoException;
import Model.Direccion;
import Model.Empleado;
import Model.Rut;

/**
 * clase principal de la aplicación, donde se crean los objetos de tipo 
 * Empleado y se muestran sus datos por consola.
 * @author Carlos Palma G.
 */
public class LlanquihueTour {

   
    public static void main(String[] args) throws RutInvalidoException, DireccionException, PersonaException
    {
        //Se habilita el sistema de caracteres utf-8 para manejo de tíldes.
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        var rut1 = new Rut("15941450-7");        
        var rut2 = new Rut("23056634-8");     
        var rut3 = new Rut("17.228.449-3");
        
        var direccion1 = new Direccion("José Miguel Infante", 5790, "Renca", "Santiago");
        var direccion2 = new Direccion("Lluta", 6459, "Quinta Normal", "Santiago");
        var direccion3 = new Direccion("Pegaso", 3356, "Lo Espejo", "Santiago");
        
        var empleado1 = new Empleado("Carlos Palma",41, rut1,direccion1,"Chofer");        
        var empleado2 = new Empleado("Yuliana Palma",25, rut2,direccion2,"Promotora");
        var empleado3 = new Empleado("Daniela Guzmán",35, rut3,direccion3,"Guía turístico"); 
        
        System.out.println(empleado1.toString());
        System.out.println(empleado2.toString());
        System.out.println(empleado3.toString());
    }
    
}
