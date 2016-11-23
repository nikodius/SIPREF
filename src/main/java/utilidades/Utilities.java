
package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * clase con utilidades
 */
public class Utilities {
    
    /**
     * metodo para obtener la fecha actual en formato determinado
     * @return date
     */
     public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }
}
