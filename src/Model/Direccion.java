package Model;
import ExceptionPersona.DireccionException;
import util.UtilDireccion;
/**
 * Clase para modelar una dirección
 * 
 */
public class Direccion {
private String calle;
private int numero;
private String comuna;
private String ciudad;

/**
 * Constructor con todos los parámetros
 * hace validación de datos antes de crear objeto
 * @param calle: nombre de la calle
 * @param numero: Numeración de la casa
 * @param comuna: Comuna a la que pertenece la casa
 * @param ciudad : Ciudad a la que pertenece la casa
 */
    public Direccion(String calle, int numero, String comuna, String ciudad) throws DireccionException 
    {
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarCalle(calle))
            this.calle = calle;
        
        if(util.ValidarNumeracion(numero))    
            this.numero = numero;
                        
        if(util.ValidarComuna(comuna))
            this.comuna = comuna;

        if(util.ValidarCiudad(ciudad))
            this.ciudad = ciudad;
    }    
    
    public String getCalle() {
        return calle;
    }
/**
 * Setter de calle
 * se verifican que los datos sean correctos
 * @param calle nombre de la calle
 * @throws DireccionException si no es válida
 */
    public void setCalle(String calle) throws DireccionException{
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarCalle(calle))
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }
/**
 * Setter de numero
 * se verifican que los datos sean correctos
 * @param numero: numeración de la dirección
 * @throws DireccionException
 */
    public void setNumero(int numero) throws DireccionException{
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarNumeracion(numero))
        this.numero = numero;

    }

    public String getComuna() {
        return comuna;
    }
/**
 * Setter de comuna
 * se verifican que los datos sean correctos
 * @param comuna: nombre de la comuna
 * @throws DireccionException
 */
    public void setComuna(String comuna) throws DireccionException{
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarComuna(comuna))
            this.comuna = comuna;        
    }

    public String getCiudad() {
        return ciudad;
    }
/**
 * Setter de ciudad
 * se verifican que los datos sean correctos
 * @param ciudad: nombre de la ciudad
 * @throws DireccionException
 */
    public void setCiudad(String ciudad) throws DireccionException{ 
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarCiudad(ciudad))
            this.ciudad = ciudad;        
    }
    
    /** 
     * @param  calle: Nombre de calle del la dirección
     * @param numero: Numeración de la dirección
     * @param comuna: Comuna de la dirección
     * @param ciudad: Ciudad de la dirección
     * @Retorna String Dirección formateada
     */
    @Override
    public String toString()
    {
            return "Direccion: " + this.calle + " " + this.numero +", " + this.comuna + ", " + this.ciudad;
    }
}

