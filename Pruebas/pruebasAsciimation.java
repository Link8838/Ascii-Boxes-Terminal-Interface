import java.lang.System;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Clase que utiliza los métodos de animación de la clase AsciiBox para
 * realizar una prueba visual para cada uno de ellos.
 * Para mas información consultar la documentación.
 * @author Hernández Ferreiro Enrique Ehecatl
 * @author linkhernandez@ciencias.unam.mx
 * @version 1.0
 */
public class pruebasAsciimation{

    public static void main(String[] args){
        String box = "";
        AsciiBox asciiTest = new AsciiBox();
        String intro = "Se mostrarán dos animaciones, la primera de una animación por lectura de frames de archivo, la segunda una caja de texto animada";
        String anillo = "Tres Anillos para los Reyes Elfos bajo el cielo. Siete para los Señores Enanos en palacios de piedra. Nueve para los Hombres Mortales condenados a morir. Uno para el Señor Oscuro, sobre el trono oscuro en la Tierra de Mordor donde se extienden las Sombras. Un Anillo para gobernarlos a todos. Un Anillo para encontrarlos, un Anillo para atraerlos a todos y atarlos en las tinieblas en la Tierra de Mordor donde se extienden las Sombras.";
        box = asciiTest.asciiBox(intro, -1, true, true);        
        try{
            asciiTest.wait(10000);
        } catch(InterruptedException e){}
        //Leemos un Ascii Art de un archivo en una lista.
        ArrayList<String> asciiList = asciiTest.readAsciiFile("asciimation.txt");
        //Imprimimos animación Ascii (ascimation)
        asciiTest.asciiMation(asciiList, 30);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Creamos una caja y la animamos
        box = asciiTest.asciiBox(anillo, -1, true, false);
        asciiTest.asciimateBox(box, 5);
    }
}