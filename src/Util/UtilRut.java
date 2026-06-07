package Util;

import ExceptionPersona.RutInvalidoException;
import static java.util.Objects.isNull;

/**Clase UtilRut
 * Se valida formato completo 
 * incluye validación de dígito verificador 
 */
public class UtilRut 
{
    /**
     * 
     * @param rut: Rut de la persona
     * @return true si el rut es válido
     * @throws RutInvalidoException si el rut no tiene el formato correcto
     */
    public boolean ValidarRut(String rut)
        throws RutInvalidoException    
    {
        if(isNull(rut)|| rut.strip().isBlank()) {
            throw new RutInvalidoException("El Rut no puede ser nulo o vacío");
        }
        
        rut = LimpiarRut(rut).toUpperCase();
        
        if(!rut.matches("[0-9]{7,8}[0-9K]")){
            throw new RutInvalidoException("El Rut no tiene un formato válido");
        }
        
        if(!ValidacionMatematicaRut(rut)){
            throw new RutInvalidoException("El dígito verificador no coincide");
        }
        return true;
    }
    
    /**
     * Método LimpiarRut 
     * @param rut: rut de la persona
     * @return retorna el rut sin puntos ni guiones
     */
    private String LimpiarRut(String rut){
        rut = rut.replace(".","");
        rut = rut.replace("-","");
        return rut;        
    }
    
    /**
     * Método ExtraerDigitoVerificador
     * @param rut: rut de la persona
     * @return solo el dígito verificador
     */
    private String ExtraerDigitoVerificador(String rut){
        String digitoVerificador = rut.substring(rut.length()-1);
        return digitoVerificador.toUpperCase();
    }
    
    /**
     * Método RutToArrayEnteros
     * @param rut: rut de la persona
     * @return arreglo de enteros del rut invertido  
     * y sin dígito verificador
     */
    private int[] RutToArrayEnteros(String rut){
        rut = LimpiarRut(rut);
        rut = rut.substring(0, rut.length()-1);       
        int rutIntArray[] = new int[rut.length()];
        int contador=0;
        for(int i = rut.length()-1; i >= 0; i--){               
            rutIntArray[contador] = Character.getNumericValue(rut.charAt(i));
                    //Integer.parseInt(numero);
            contador++;
        }        
        return rutIntArray;
    }
    
    /**
     * Método ValidacionMatematicaRut
     * compara el digito verificador con un cálculo matemático
     * @param rut: rut de la persona
     * @return boolean depende si es válido el rut
     */
    private boolean ValidacionMatematicaRut(String rut){
        var rutArrayEnteros = RutToArrayEnteros(rut);
        int acumulador = 0;
        int multiplicador = 2;
        for(int i = 0; i < rutArrayEnteros.length ;i++){
            multiplicador = (multiplicador == 8) ? 2 : multiplicador;
            acumulador += multiplicador * rutArrayEnteros[i];
            multiplicador++;
        }
        
        String digitoVerificadorEntrante = ExtraerDigitoVerificador(rut);
        String digitoVerificadorCalculado;
        Integer DvInt = 11 - (acumulador%11);
        digitoVerificadorCalculado = DvInt.toString();
        
        switch (DvInt){
            case 11:
                digitoVerificadorCalculado = "0";
                break;
            case 10:
                digitoVerificadorCalculado = "K";
                break;                                        
        }
        return digitoVerificadorCalculado.equalsIgnoreCase(digitoVerificadorEntrante);                
    }
}
