/**
 * @author Carmelo Guillen
 * @version 1.0.1
 * @since 05/06/2015
 */
package p20150605;

import java.io.File;

public class AudioSpot
{
    /**
     * Propiedades de clase:
     * archivo: manejador para el archivo que contiene el audio (.mp3)
     * duracion: duración del audio, en segundos.
     * producto: nombre del producto anunciado.
     * anunciante: nombre de la empresa anunciante.
     * lasterrormsg: recoge el último mensaje de error
     */
    private File archivo;       
    private int duracion;       
    private String producto;    
    private String anunciante;  
    
    public String lasterrormsg; 
    
    /**
     * Es el constructor con el cuál se crearán objetos de AudioSpot, con unas propiedades definidas anteriormente.
     */
    public AudioSpot ()
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
    
    /**
     * Controla la duración.
     * @param duracion
     * @throws IllegalArgumentException 
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("Duración demasiado larga");
        this.duracion = duracion;
    }
    
    /**
     * Comprueba si existe el archivo.
     * @param nombre_archivo
     * @return Devuelve (true)si existe y (false) si no existe el archivo.
     */
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
    
    /**
     * Comprueba si hay algún error, y si no lo hay lo pone en la cola de reproducción.
     * @param cola_reproduccion
     * @return si todo va bien devuelve la duración y de no ser asi diría que no se ha establecido duración alguna.
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
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
        
        // si todo va bien, programamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
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
    
    /**
     * Comprueba que no falle nada, y si todo va correctamente exporta el audiospot
     * @param objeto_daw
     * @return devuelve un error
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
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
