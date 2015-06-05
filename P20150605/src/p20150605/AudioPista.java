/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author alumno
 */
public abstract class AudioPista {
    protected static final int max_duracion_audio = 120;
    /**
     * Propiedades de clase:
     * archivo: manejador para el archivo que contiene el audio (.mp3)
     * duracion: duración del audio, en segundos.
     * producto: nombre del producto anunciado.
     * anunciante: nombre de la empresa anunciante.
     * lasterrormsg: recoge el último mensaje de error
     */
    protected File archivo;
    protected int duracion;
    public String lasterrormsg;

    public AudioPista() {
    }

    /**
     * Une al producto y a su anunciante.
     * @param producto
     * @param anunciante
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * Controla la duración.
     * @param duracion
     * @throws IllegalArgumentException
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > max_duracion_audio) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * Comprueba si existe el archivo.
     * @param nombre_archivo
     * @return Devuelve (true)si existe y (false) si no existe el archivo.
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     * Comprueba si hay algún error, y si no lo hay lo pone en la cola de reproducción.
     * @param cola_reproduccion
     * @return si todo va bien devuelve la duración y de no ser asi diría que no se ha establecido duración alguna.
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date time) {
        int resultado = checkDatos();
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int checkDatos();

    /**
     * Comprueba que no falle nada, y si todo va correctamente exporta el audiospot
     * @param objeto_daw
     * @return devuelve un error
     */
    public abstract int ExportaAFormatoDAW(Object objeto_daw);
    
}
