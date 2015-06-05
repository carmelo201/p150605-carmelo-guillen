/**
 * @author Carmelo Guillen
 * @version 1.0.1
 * @since 05/06/2015
 */
package p20150605;

import java.io.File;
import java.util.Date;

public class AudioAnuncio extends AudioPista
{
    private String producto;    
    private String anunciante;  
    
    
    /**
     * Es el constructor con el cuál se crearán objetos de AudioSpot, con unas propiedades definidas anteriormente.
     */
    public AudioAnuncio ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    
    /**
     * Une al producto y a su anunciante.
     * @param producto
     * @param anunciante
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    

    protected int checkDatos() {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }
    
    /**
     * Comprueba que no falle nada, y si todo va correctamente exporta el audiospot
     * @param objeto_daw
     * @return devuelve un error
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = checkDatos();
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
