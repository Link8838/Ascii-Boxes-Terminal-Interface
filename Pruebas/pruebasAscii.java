import java.lang.System;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

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
        AsciiBox asciiTest = new AsciiBox();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show(asciiTest.addAccents("Inicamos contador de tiempo, con la función 'startTimer()'"));
        asciiTest.startTimer();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
          File myObj = new File("anillo.txt");
          myObj.createNewFile();
        } catch (Exception e) {}
        String anillo = "Tres Anillos para los Reyes Elfos bajo el cielo. Siete para los Señores Enanos en palacios de piedra. Nueve para los Hombres Mortales condenados a morir. Uno para el Señor Oscuro, sobre el trono oscuro en la Tierra de Mordor donde se extienden las Sombras. Un Anillo para gobernarlos a todos. Un Anillo para encontrarlos, un Anillo para atraerlos a todos y atarlos en las tinieblas en la Tierra de Mordor donde se extienden las Sombras.";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show("Caja con loguitud por defecto (90), texto sin justificar");        
        //Caja con longuitud por defecto con parámetro -1, texto sin justificar, impresión al final.
        box = asciiTest.asciiBox(anillo, -1, false, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show("Caja con loguitud por defecto (90), texto justificado");        
        //Caja con longuitud por defecto con parámetro -1, texto justificado, impresión al final.
        box = asciiTest.asciiBox(anillo, -1, true, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show("Caja con loguitud dada (50), texto sin justificar");        
        //Caja con longuitud dada parámetro 50, texto sin justificar, impresión al final.
        box = asciiTest.asciiBox(anillo, 50, false, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show("Caja con loguitud dada (50), justificado");        
        //Caja con longuitud dada parámetro 50, texto justificado, impresión al final.
        box = asciiTest.asciiBox(anillo, 50, true, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show("Caja para objeto dado, sin justificar");
        pruebasAscii test = new pruebasAscii();    
        //Caja para objeto dado, sin justificar, impresión al final.
        box = asciiTest.asciiBox(test, 50, true, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");                   
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String anillo2 = "                          Tres Anillos para los Reyes Elfos bajo el cielo.\n                        Siete para los Señores Enanos en palacios de piedra.\n                         Nueve para los Hombres Mortales condenados a morir.\n Uno para el Señor Oscuro, sobre el trono oscuro en la Tierra de Mordor donde se extienden las Sombras.\n                                 Un Anillo para gobernarlos a todos.   \n Un Anillo para encontrarlos, un Anillo para atraerlos a todos y  atarlos en las tinieblas en la Tierra\n                               de Mordor donde se extienden las Sombras.";
        asciiTest.show("Caja con texto con saltos de linea");        
        //Caja con texto con saltos de linea, texto sin justificar, impresión al final.
        box = asciiTest.asciiBox(anillo2, 103, false, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Usamos la función addAccents(...) para correguir el texto en pantalla (Windows).
        asciiTest.show(asciiTest.addAccents("Caja de caja, usando la función de frameLength(...) para definir la longuitud de la nueva"));        
        //Caja con caja, la longuitud de la caja es la de la caja de dentro, texto sin justificar, impresión al final.
        box = asciiTest.asciiBox(box, asciiTest.frameLength(box), false, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show("Caja con un Ascii Art de un archivo de texto (anilloAscii.txt)");
        //Leemos un Ascii Art de un archivo en una lista.
        ArrayList<String> asciiList = asciiTest.readAsciiFile("anilloAscii.txt");
        //Guardamos en caja el Ascii Art almacenado en la lista, checamos la longuitud para ponerla, e imprimimos.
        box = asciiTest.asciiBox(asciiList.get(1), 112, false, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        asciiTest.show(asciiTest.addAccents("Concatenación de 2 Ascii Art"));
        //Creamos una cadena AsciiArt.
        String craneo = "        ,--.\n       ([ oo]\n        `- ^\\\n      _  I`-'\n";
        box = asciiTest.concatAscii(craneo, craneo);
        asciiTest.show(box);
        asciiTest.writeAsciiFile(box, "anillo.txt");        
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
        asciiTest.show("Arreglos Ascii Art de enteros, incluye un valor NULL");
        box = asciiTest.asciiArray(array2, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");

        //Arreglo de cadenas con impresión al final.
        asciiTest.show("Arreglos Ascii Art de cadenas, incluye un valor NULL");
        box = asciiTest.asciiArray(array1, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");

        //Matriz de cadenas de tamaño N*N.
        asciiTest.show("Matriz Ascii Art de cadenas de N*N, incluye un valor NULL");
        box = asciiTest.asciiMatrix(matrix1, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");

        //Matriz de cadenas de tamaño M*N.
        asciiTest.show("Matriz Ascii Art de enteros de M*N, incluye un valor NULL");
        box = asciiTest.asciiMatrix(matrix2, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
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

        asciiTest.show(asciiTest.addAccents("Tabla Ascii Art, se llenó por filas, contiene separadores, impresión al final, incluye un valor NULL"));
        box = asciiTest.asciiTable("Tabla Random de cosas Random", headers, items, false, true, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");

        asciiTest.show(asciiTest.addAccents("Tabla Ascii Art, se llenó por filas, sin separadores, impresión al final, incluye un valor NULL"));
        box = asciiTest.asciiTable("Tabla Random de cosas Random", headers, items, false, false, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
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

        asciiTest.show(asciiTest.addAccents("Tabla Ascii Art, se llenó por columnas, contiene separadores, impresión al final, incluye un valor NULL"));
        box = asciiTest.asciiTable(title, cabeceras, items2, true, true, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");

        asciiTest.show(asciiTest.addAccents("Tabla Ascii Art, se llenó por columnas, sin separadores, impresión al final, incluye un valor NULL"));
        box = asciiTest.asciiTable(title, cabeceras, items2, true, false, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        asciiTest.show(asciiTest.addAccents("ArrayList Ascii Art, impresión al final, incluye un valor NULL"));
        box = asciiTest.asciiArrayList(letra, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");

        ArrayList<Object> arrayList = new ArrayList<Object>();
        asciiTest.show(asciiTest.addAccents("ArrayList vacía Ascii Art, impresión al final"));
        box = asciiTest.asciiArrayList(arrayList, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");        
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

        asciiTest.show(asciiTest.addAccents("Stack Ascii Art, impresión al final, incluye un valor NULL"));
        box = asciiTest.asciiStack(stack, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");

        Stack<Object> stack2 = new Stack<Object>();
        asciiTest.show(asciiTest.addAccents("Stack vacío Ascii Art, impresión al final"));
        box = asciiTest.asciiStack(stack2, true);
        asciiTest.writeAsciiFile(box, "anillo.txt");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////               
        asciiTest.show(asciiTest.addAccents("Leeremos el archivo generado e imprimimos todo el archivo en una caja"));
        box = asciiTest.readTextFile("anillo.txt");
        box = asciiTest.asciiBox(box, 116, false, true);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        asciiTest.show(asciiTest.addAccents("Detenemos contador de tiempo, con la función 'stopTimer(boolean)'"));
        asciiTest.stopTimer(true);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //javadoc -encoding UTF-8 *.java
    }
}