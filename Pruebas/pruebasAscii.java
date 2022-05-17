import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Clase que utiliza los métodos de la clase AsciiBox para
 * realizar una prueba visual para cada uno de ellos.
 * Para mas información consultar la documentación.
 * @author Hernández Ferreiro Enrique Ehecatl
 * @author linkhernandez@ciencias.unam.mx
 * @version 1.4
 */
public class pruebasAscii{

    String test;
    int magic;
    Boolean awa;

    public pruebasAscii(){
        test = "Esto es una prueba para objetos de cajas Ascii Art";
        magic = 42;
        awa = true;
    }

    public String toString(){
        return test + "\n" + magic + "\n" + "agua?: " + awa;
    }

    public static void main(String[] args){
        String box = "";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show(AsciiBox.addAccents("Inicamos contador de tiempo, con la función 'startTimer()'"));
        AsciiBox.startTimer();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
          File myObj = new File("anillo.txt");
          myObj.createNewFile();
        } catch (Exception e) {}
        String anillo = "Tres Anillos para los Reyes Elfos bajo el cielo. Siete para los Señores Enanos en palacios de piedra. Nueve para los Hombres Mortales condenados a morir. Uno para el Señor Oscuro, sobre el trono oscuro en la Tierra de Mordor donde se extienden las Sombras. Un Anillo para gobernarlos a todos. Un Anillo para encontrarlos, un Anillo para atraerlos a todos y atarlos en las tinieblas en la Tierra de Mordor donde se extienden las Sombras.";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show("Caja con loguitud por defecto (90), texto sin justificar");        
        //Caja con longuitud por defecto con parámetro -1, texto sin justificar, impresión al final.
        box = AsciiBox.asciiBox(anillo, -1, false, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show("Caja con loguitud por defecto (90), texto justificado");        
        //Caja con longuitud por defecto con parámetro -1, texto justificado, impresión al final.
        box = AsciiBox.asciiBox(anillo, -1, true, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show("Caja con loguitud dada (50), texto sin justificar");        
        //Caja con longuitud dada parámetro 50, texto sin justificar, impresión al final.
        box = AsciiBox.asciiBox(anillo, 50, false, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show("Caja con loguitud dada (50), justificado");        
        //Caja con longuitud dada parámetro 50, texto justificado, impresión al final.
        box = AsciiBox.asciiBox(anillo, 50, true, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show("Caja para objeto dado, sin justificar");
        pruebasAscii test = new pruebasAscii();    
        //Caja para objeto dado, sin justificar, impresión al final.
        box = AsciiBox.asciiBox(test, 50, true, false);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show("Caja creada, desplazada 10 caracteres.");
        //Caja creada, desplazada 10 caracteres.
        box = AsciiBox.addOffSet(box, 10);
        AsciiBox.show(box);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String anillo2 = "                          Tres Anillos para los Reyes Elfos bajo el cielo.\n                        Siete para los Señores Enanos en palacios de piedra.\n                         Nueve para los Hombres Mortales condenados a morir.\n Uno para el Señor Oscuro, sobre el trono oscuro en la Tierra de Mordor donde se extienden las Sombras.\n                                 Un Anillo para gobernarlos a todos.   \n Un Anillo para encontrarlos, un Anillo para atraerlos a todos y  atarlos en las tinieblas en la Tierra\n                               de Mordor donde se extienden las Sombras.";
        AsciiBox.show("Caja con texto con saltos de linea");        
        //Caja con texto con saltos de linea, texto sin justificar, impresión al final.
        box = AsciiBox.asciiBox(anillo2, 103, false, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Usamos la función addAccents(...) para correguir el texto en pantalla (Windows).
        AsciiBox.show(AsciiBox.addAccents("Caja de caja, usando la función de frameLength(...) para definir la longuitud de la nueva"));        
        //Caja con caja, la longuitud de la caja es la de la caja de dentro, texto sin justificar, impresión al final.
        box = AsciiBox.asciiBox(box, AsciiBox.frameLength(box), false, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show("Caja con un Ascii Art de un archivo de texto (anilloAscii.txt)");
        //Leemos un Ascii Art de un archivo en una lista.
        ArrayList<String> asciiList = AsciiBox.readAsciiFile("anilloAscii.txt");
        //Guardamos en caja el Ascii Art almacenado en la lista, checamos la longuitud para ponerla, e imprimimos.
        box = AsciiBox.asciiBox(asciiList.get(1), 112, false, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        AsciiBox.show(AsciiBox.addAccents("Concatenación de 2 Ascii Art"));
        //Creamos una cadena AsciiArt.
        String craneo = "        ,--.\n       ([ oo]\n        `- ^\\\n      _  I`-'\n";
        box = AsciiBox.concatAscii(craneo, craneo);
        AsciiBox.show(box);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String[] array1 = new String[12];
        Integer[] array2 = new Integer[12];
        String[][] matrix1 = new String[12][12];
        Integer[][] matrix2 = new Integer[12][5];
        //Llenado los arrglos y matriz con contendido x.
        for(int i = 0; i<array1.length; i++){
            array1[i] = "Único";
            array2[i] = i*10;
            for(int j = 0; j<matrix1[i].length; j++){
                matrix1[i][j] = " a ";
            }
            for(int j = 0; j<matrix2[i].length; j++){
                matrix2[i][j] = j*100;
            }            
        }
        //Colocando un valor NULL de muestra.
        array2[5] = null;
        array1[5] = null;
        matrix1[5][5] = null;
        matrix2[5][4] = null;
        //Arreglo de enteros con impresión al final.
        AsciiBox.show("Arreglos Ascii Art de enteros, incluye un valor NULL");
        box = AsciiBox.asciiArray(array2, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);

        //Arreglo de cadenas con impresión al final.
        AsciiBox.show("Arreglos Ascii Art de cadenas, incluye un valor NULL");
        box = AsciiBox.asciiArray(array1, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);

        //Matriz de cadenas de tamaño N*N.
        AsciiBox.show("Matriz Ascii Art de cadenas de N*N, incluye un valor NULL");
        box = AsciiBox.asciiMatrix(matrix1, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);

        //Matriz de cadenas de tamaño M*N.
        AsciiBox.show("Matriz Ascii Art de enteros de M*N, incluye un valor NULL");
        box = AsciiBox.asciiMatrix(matrix2, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Crearemos lo neceasrio para una tabla Ascii Art que se llena por filas.
        ArrayList<String> headers = new ArrayList<String>();
        headers.add(" Nombre "); headers.add(" Carrera "); headers.add("Tomate o Jitomate");
        headers.add("Edad");
    
        ArrayList<Object> l1 = new ArrayList<Object>(); ArrayList<Object> l2 = new ArrayList<Object>();
        ArrayList<Object> l3 = new ArrayList<Object>(); ArrayList<Object> l4 = new ArrayList<Object>();
        ArrayList<Object> l5 = new ArrayList<Object>();

        l1.add("Emilio"); l2.add("Cuervo"); l3.add("Erik"); l4.add("Link"); l5.add("Rams");
        l1.add("C.C."); l2.add("C.C."); l3.add("C.C."); l4.add(null); l5.add("C.C.");
        l1.add("Tomate"); l2.add("Jitomate"); l3.add("Tomate"); l4.add("Si"); l5.add("Jitomate");
        l1.add(22.0); l2.add(22); l3.add(22); l4.add(22); l5.add(19.5);

        ArrayList<ArrayList<Object>> items = new ArrayList<ArrayList<Object>>();
        items.add(l1); items.add(l2); items.add(l3); items.add(l4); items.add(l5);

        AsciiBox.show(AsciiBox.addAccents("Tabla Ascii Art, se llenó por filas, contiene separadores, impresión al final, incluye un valor NULL"));
        box = AsciiBox.asciiTable("Tabla Random de cosas Random", headers, items, false, true, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);

        AsciiBox.show(AsciiBox.addAccents("Tabla Ascii Art, se llenó por filas, sin separadores, impresión al final, incluye un valor NULL"));
        box = AsciiBox.asciiTable("Tabla Random de cosas Random", headers, items, false, false, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Crearemos lo neceasrio para una tabla Ascii Art que se llena por filas.
        String title = "Anillos";
        ArrayList<String> cabeceras = new ArrayList<String>();
        cabeceras.add(" Número "); cabeceras.add(" Raza ");
        ArrayList<ArrayList<Object>> items2 = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> num = new ArrayList<Object>();
        ArrayList<Object> letra = new ArrayList<Object>();

        num.add(1); letra.add("Señor");
        num.add(2); letra.add(null);
        num.add(3); letra.add("Elfos");
        num.add(9); letra.add("Hombres");
        num.add(7); letra.add("Enanos");
        items2.add(num); items2.add(letra);

        AsciiBox.show(AsciiBox.addAccents("Tabla Ascii Art, se llenó por columnas, contiene separadores, impresión al final, incluye un valor NULL"));
        box = AsciiBox.asciiTable(title, cabeceras, items2, true, true, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);

        AsciiBox.show(AsciiBox.addAccents("Tabla Ascii Art, se llenó por columnas, sin separadores, impresión al final, incluye un valor NULL"));
        box = AsciiBox.asciiTable(title, cabeceras, items2, true, false, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        AsciiBox.show(AsciiBox.addAccents("ArrayList Ascii Art, impresión al final, incluye un valor NULL"));
        box = AsciiBox.asciiArrayList(letra, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);

        ArrayList<Object> arrayList = new ArrayList<Object>();
        AsciiBox.show(AsciiBox.addAccents("ArrayList vacía Ascii Art, impresión al final"));
        box = AsciiBox.asciiArrayList(arrayList, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Creación de un Stack.
        Stack<Object> stack = new Stack<Object>();
        stack.push("Elfos");
        stack.push("Enanos");
        stack.push(26.11);
        stack.push("Hombres");
        stack.push("Orcos");
        stack.push("Hobbits");
        stack.push(null);
        stack.push(1397);

        AsciiBox.show(AsciiBox.addAccents("Stack Ascii Art, impresión al final, incluye un valor NULL"));
        box = AsciiBox.asciiStack(stack, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);

        Stack<Object> stack2 = new Stack<Object>();
        AsciiBox.show(AsciiBox.addAccents("Stack vacío Ascii Art, impresión al final"));
        box = AsciiBox.asciiStack(stack2, true);
        AsciiBox.writeAsciiFile(box, "anillo.txt",false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////               
        AsciiBox.show(AsciiBox.addAccents("Leeremos el archivo generado e imprimimos todo el archivo en una caja"));
        box = AsciiBox.readTextFile("anillo.txt");
        box = AsciiBox.asciiBox(box, 116, false, true);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AsciiBox.show(AsciiBox.addAccents("Detenemos contador de tiempo, con la función 'stopTimer(boolean)'"));
        AsciiBox.stopTimer(true);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //javadoc -encoding UTF-8 *.java
    }
}