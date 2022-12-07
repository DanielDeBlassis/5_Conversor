/**
 * Comprobación de cadenas de texto 
 * 
 * @author Daniel De Blassis
 * 
 * */
public class SoloNumeros {
	
	
	/**
	 * Toma una cadena como parámetro y comprueba que contenga solo números
	 * @param cadena variable de tipo String a comprobar
	 * @return <code>true</code> si la cadena solo contiene números
	 *		   <code>false</code> si la cadena está vacía o contiene letras y/o símbolos
	 */
	public static boolean contieneSoloNumeros(String cadena) {
	    // Si la cadena está vacía, debemos devolver false
	    if (cadena.length() == 0) {
	        return false;
	    }
	    for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si no está entre 0 y 9
	        if (!(c >= '0' && c <= '9')) {
	            return false;
	        }
	    }
	    return true;
	}
}
