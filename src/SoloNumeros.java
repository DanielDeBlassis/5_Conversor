/**
 * Comprobaci�n de cadenas de texto 
 * 
 * @author Daniel De Blassis
 * 
 * */
public class SoloNumeros {
	
	
	/**
	 * Toma una cadena como par�metro y comprueba que contenga solo n�meros
	 * @param cadena variable de tipo String a comprobar
	 * @return <code>true</code> si la cadena solo contiene n�meros
	 *		   <code>false</code> si la cadena est� vac�a o contiene letras y/o s�mbolos
	 */
	public static boolean contieneSoloNumeros(String cadena) {
	    // Si la cadena est� vac�a, debemos devolver false
	    if (cadena.length() == 0) {
	        return false;
	    }
	    for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si no est� entre 0 y 9
	        if (!(c >= '0' && c <= '9')) {
	            return false;
	        }
	    }
	    return true;
	}
}
