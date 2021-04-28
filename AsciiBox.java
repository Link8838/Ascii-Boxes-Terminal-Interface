/**
 * Clase que implementa métodos para imprimir estructuras en Ascii Art
 * como Strings, ArrayList, Stack, ademas de realizar animaciones para
 * las cajas generadas, lectura de frames en Ascii Art desde archivos,
 * funciones auxiliares para formar tus propias cadenas con Ascii Art.
 * @author Hernández Ferreiro Enrique Ehecatl
 * @author linkhernandez@ciencias.unam.mx
 * @version 1.2
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.System;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.nio.file.*;

public class AsciiBox{

    //Local Variables.
    static String si = "\u2554";   static String sd = "\u2557";
    static String ii = "\u255A";   static String id = "\u255D";
    static String ld = "\u2551";   static String st = "\u2550";
    static String fi = "\u2560";   static String fd = "\u2563";
    static String ti = "\u2569";   static String tn = "\u2566";
    static String dt = "\u256C";   static String pk = "\u00B6";
    static String a = "\u00E1";    static String e = "\u00E9";
    static String i = "\u00ED";    static String o = "\u00f3";
    static String u = "\u00fa";    static String n = "\u00f1";
    static String aM = "\u00C1";   static String eM = "\u00C9";
    static String iM = "\u00ED";   static String oM = "\u00D3";
    static String uM = "\u00Da";   static String nM = "\u00D1";
    static String qm = "\u00bf";   static String am = "\u00a1";
    static String exception = " -hoo+.                                                            -.\n  -d++ooo/.                                                     :++s/\n   :y/oo+:/oo/`                                           `-///oo++s \n    /h/++os+../++/--:////:::////:--::/+/`           `-:///::/oso:-y` \n     os-:o++so   `..`   ```.`  `.-.``` ./+////////++/-`./+ss+:-..y.  \n      ss:-/++o                                     `-/os++/-:--/y:   \n       /y/::-                                    `/o++o++:-.  -s`    \n        /s--.                                    :++o+o+:...`+o      \n        `d--`                                     `...-:.::.s:       \n        o+-.                                           -- :y`        \n       :y--`                                            . h          \n      .y--.oNNd:-`            `-/+--/:-                  o/          \n     `h--.  :mMMdo         `+dMMMMmmms:                  h`          \n     .y-.     .--          `/osyso/.                     .s          \n     -y-`        ..                                ``     d          \n     h-.        ++//::.`                          ``-`    :y         \n     y-`       `hsoooyso.           `...                 `y:         \n     s-`         +yy:`             `--.                  /y`         \n     -+.   `.   `.:-`            `.--`                   .d.         \n      y.    .:yhddddhy+:``    ``./--`          ``        +s:         \n      y.`     :ddyyyyyhddhs+//+os/-`          `..         :s         \n     s:-. `.   o+///:///+syhys+..-.             `         -y         \n     .s-. .-`  -/.` ` `       - `..                       .y         \n      -o-` `    .+:.-.`    `-+.                         `oo/         \n       o:::-------/oooooooo+:----------------------------:sd`        \n        -------------------------------------+o++++s++/:+ooo:        \n";
    static long inicio = 0, finaly = 0, tiempo = 0;

    /**
     * Constructor por omisión.
     */
    public AsciiBox(){}

    /**
     * Método que coloca en una cadena dada la cantidad de espacios en blanco que se le indiquen como parámetro.
     * @param ren Cadena a la que se le quiere añadir espacios en blanco (" ").
     * @param rest Entero de la cantidad de espacios en blanco (" ") que se desea añadir.
     * @return Cadena con espacios en blanco agregados.
     */
    public static String addBlanks(String ren, int rest){
        if(rest != 0){
            for(int i = 0; i<rest; i++){
                ren += " ";
            }
        }
        return ren;
    }

    /**
     * Método que crea una cadena "marco/frame" con los caracteres que se le indiquen al inicio y al final dada una longuitud para añadirla a una cadena dada.
     * <br>Ejemplo de "marco/frame": \u2554\u2550\u2550\u2550\u2550\u2550\u2557 Caracter de inicio: \u2554 Caracter de fin: \u2557 Longuitud: 6.
     * @param start Cadena del caracter que se colocará al inicio del frame.
     * @param end Cadena del caracter que se colocará al final de frame.
     * @param text Cadena del texto al que se añadirá el frame.
     * @param len Longuitud deseada del frame, la longuitud incluye los caracteres de inicio y de final.
     * @param jump Booleano que indica si se colocará un salto de línea al final del frame, el salto de línea no cuenta dentro de la longitud.
     * @return Cadena parámetro con el frame agregado.
     */
    public static String addFrame(String start, String end, String text, int len, boolean jump){
        for(int i = 0; i<len; i++){
            if(i == 0){
                text += start; 
            } else if(i == len-1){
                text += end;
            } else {
                text += st;
            }
        }
        if(jump){
            text += "\n";
        }
        return text;
    }

    /**
     * Método que añade un "marco/frame" especial a una cadena dada, con un carcter de inicio específico, un caracter final, un caracter como
     * separador, una cantidad de iteraciones y la longuitud de cada espacio especial.
     * <br>Ejemplo de "marco/frame" especial: \u2554\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2557  Caracter inicial: \u2554  Caracter central: \u2566 Caracter final: \u2557 Longuitud de segmento: 5 Cantidad de segmentos: 2 
     * @param start Cadena del caracter de inicial del frame.
     * @param middle Cadena del caracter de en medio o separador para el frame especial.
     * @param end Cadena del caracter final del frame.
     * @param text Cadena a la que se le desea añadir el frame creado.
     * @param wordLen Entero de la longuitud de cada segmento del frame especial.
     * @param totalSpaces Entero de la cantidad de segmentos a generar.
     * @param jump Booleano que indica si se desea colocar un salto de línea al final del frame especial.
     * @return Cadena parámetro con el frame especial añadido.
     */
    public static String addSpecialFrame(String start, String middle, String end, String text, int wordLen, int totalSpaces, boolean jump){
        String specialF = start;
        for(int i = 0; i<totalSpaces; i++){
            for(int j = 0; j<wordLen; j++){
                specialF += st;
            }
            if(i == totalSpaces-1){
                specialF += end;
            } else {
                specialF += middle;
            }
        }
        if(jump){
            specialF += "\n";
        }
        text += specialF;
        return text;
    }

    /**
     * Método que crea un pequeño frame en el que ajusta una cadena en el centro de un espacio indicado agregando espacios y un separador al final.
     *<br>Ejemplo de miniFrame: '  ejemplo  \u2551' Cadena dada: "ejemplo"  Caracter separador: \u2551  Longuitud: 11
     * @param text Cadena a la cual se le agregará el miniFrame.
     * @param word Cadena (palabra) que se agregará en el miniFrame.
     * @param middle Cadena del caracter separador.
     * @param maxlength Longuitud máxima del miniFrame, sin contar el separador.
     * @param jump Booleano para indicar si se colocará un salto de linea después del miniFrame.
     * @return Cadena pasada como parámetro con el miniFrame agregado.
     */
    public static String addWordMiniFrame(String text, String word, String middle, int maxlength, boolean jump){
        String miniFrame = "";
        word = addAccents(word);
        int wordLen = word.length();      
        int freeSpace = 0, f1 = 0, f2 = 0;
        if(wordLen < maxlength){            
            freeSpace = maxlength - wordLen;            
            f1 = freeSpace/2;
            f2 = freeSpace - f1;            
            miniFrame = addBlanks(miniFrame, f1);            
            miniFrame += word; 
            miniFrame = addBlanks(miniFrame, f2);            
            miniFrame += middle;            
        } else {
            miniFrame += word + middle;
        }
        if(jump){
            miniFrame += "\n";
        }        
        text += miniFrame;
        return text;
    }

    /**
     * Método que encierra en una caja AsciiArt una cadena dada. Cuenta con multiples opciones como definir la longuitud de la caja, impresión directa y justificación del texto.
     * @param text Cadena del texto que se desea encerrar en una caja Ascii Art.
     * @param size Entero para indicar la máxima longuitud del renglón. La longuitud por defecto es de 90, para escojerla colocar como parámetro "-1". (Unicamente mide el texto, la caja agrega siempre 4 a longitud total de cada cadena).
     * @param justify Booleano para indicar si se desea justificar el texto de la caja. (True = Justificado).
     * @param print Booleano para indicar si se imprime el resultado imediatamente después de generar la caja.
     * @return Cadena de texto que representa una caja con la cadena pasada como parámetro dentro de ella.
     */
    public static String asciiBox(String text, int size, boolean justify, boolean print){
        String ren = "";
        String extraSpace = "  ";
        String sub1, sub2, nextSpace;
        String aux = "";
        int jump, space;
        int numre = 1, rest = 0;
        boolean nextLine = false;

        if(size == -1){
            size = 90;
        }
        size += 5;

        ren = addFrame(si,sd, ren, (size-1),true);        

        text = addAccents(text);
        text = text.replaceAll("\n", "_1 ");        
        String[] split = text.split(" ");      

        try{
            for(String p : split){
                if(numre == 1 && ren.length() == size){
                    ren += ld;
                    numre++;
                }

                if(p.contains("_1")){
                    nextLine = true;
                    p = p.replaceAll("_1", "");                    
                }                            

                if(ren.length() + p.length()+1 <= (size*numre)-3){
                    ren += " " + p;                
                } else if(ren.length() + p.length()+1 > (size*numre)-3){
                    if(justify){
                        rest = ((size*numre)-3) - ren.length();
                        jump = (size*(numre-1))+2;
                        
                        for(int i = 0; i<rest; i++){                        
                            space = ren.indexOf(" ", jump);
                            //System.out.println(jump + " " + space);
                            if(space == -1){
                                jump = (size*(numre-1))+2;
                                space = ren.indexOf(" ", jump);
                                extraSpace = "  ";
                            }
                            nextSpace = ren.substring(jump, space);
                            jump += (nextSpace.length())+3; 
                            sub1 = ren.substring(0, space);
                            sub2 = ren.substring(space+1);
                            ren = sub1 + extraSpace + sub2;
                            extraSpace = "  ";
                        }
                        rest = ((size*numre)-3) - ren.length();
                    } else {
                        rest = ((size*numre)-3) - ren.length();
                    }
                    ren = addBlanks(ren, rest);
                    ren += " " + ld + "\n" + ld + " " + p;
                    numre++;
                }
                if(nextLine){
                    rest = ((size*numre)-3) - ren.length();
                    ren = addBlanks(ren, rest);
                    ren += " " + ld + "\n" + ld;
                    numre++;
                    nextLine = false;
                }
            }

            rest = ((size*numre)-2) - ren.length();
            ren = addBlanks(ren, rest);
            ren += ld + "\n";
            numre++;
            ren = addFrame(ii, id, ren, (size-1), true);

        } catch(Exception e){
            asciiBox(exception, 69, false, true);
            asciiBox(e, e.toString().length(), false, true);
            ren = "";
        }
        if(print){
            System.out.println(ren);
        }        
        return ren;
    }

    /**
     * Método que encierra en una caja AsciiArt un objeto dado siempre y cuando el objeto cuente con una implementación del método toString().
     * Cuenta con multiples opciones como definir la longuitud de la caja, impresión directa y justificación del texto.
     * @param object Objeto que se desea encerrar en una caja Ascii Art.
     * @param size Entero para indicar la máxima longuitud del renglón. La longuitud por defecto es de 90, para escojerla colocar como parámetro "-1". (Unicamente mide el texto, la caja agrega siempre 4 a longitud total de cada cadena).
     * @param justify Booleano para indicar si se desea justificar el texto de la caja. (True = Justificado).
     * @param print Booleano para indicar si se imprime el resultado imediatamente después de generar la caja.
     * @return Cadena de texto que representa una caja con la cadena pasada como parámetro dentro de ella.
     */
    public static String asciiBox(Object object, int size, boolean justify, boolean print){
        String asciiObject = "";
        boolean ok = false;
        Class c = object.getClass();
        Method[] methods = c.getMethods();
        for(Method method : methods){
            if(method.getName().equals("toString")){
                asciiObject = asciiBox(object.toString(), size, justify, print);
                ok = true;
                break;
            }
        }
        if(!ok){
            asciiObject = "El objeto pasado como parámetro no tiene implementado un método 'toString'.";
            asciiBox(asciiObject, asciiObject.length(), false, true);
        }
        return asciiObject;
    }

    /**
     * Método que lee archivos de Ascii Art, regresa en una lista cada Ascii Art de forma independiente.
     * <br> El archivo debe contener el separador "ASCII_ART" al final de cada Ascii Art para que el método lo reconozca 
     * y guarde de forma individual, aunque se trate de un único Ascii Art es necesario el separador al final.
     * <br> La lectura del archivo se hace con codificación UTF-8.
     * @param fileName Cadena del nombre del archivo que se desea leer. (debe contener extensión).
     * @return Lista de cadenas con los Ascii Arts encontrados en el archivo.
     */
    public static ArrayList<String> readAsciiFile(String fileName){  
        BufferedReader reader;
        ArrayList<String> lines = new ArrayList<String>();
        String ascii = " ";
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
            String line = reader.readLine();
            while (line != null){
                if(line.contains("ASCII_ART")){
                    lines.add(ascii);
                    ascii = " ";
                } else {
                    //line = line.replaceAll("\\u005C", "\\\\");
                    line += "\n";
                    ascii += line;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch(Exception e) {
            asciiBox(exception, 69, false, true);
            asciiBox(e, e.toString().length(), false, true);
        }
        return lines;
    }

    /**
     * Método que lee un archivo de texto y devuele en una cadena el contenido del mismo.
     * La lectura del archivo se hace con codificación UTF-8.
     * @param fileName Cadena del nombre del archivo que se desea leer. (debe contener extensión).
     * @return Cadena con el contenido del archivo leido.
     */
    public static String readTextFile(String fileName){  
        BufferedReader reader;
        String asciiText = "";
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
            String line = reader.readLine();
            while (line != null){
                asciiText += line;
                asciiText += "\n";
                line = reader.readLine();
            }
            reader.close();
            //asciiText = asciiText.substring(0, asciiText.length()-1);
        } catch(Exception e) {
            asciiBox(exception, 69, false, true);
            asciiBox(e, e.toString().length(), false, true);
        }
        return asciiText;
    }

    /**
     * Método que escribe en un archivo de texto la cadena pasada como parámetro.
     * <br> La escritura del archivo se hace con codificación UTF-8.
     * @param text Cadena de texto que se desea escribir en el archivo de texto.
     * @param fileName Cadena del nombre del archivo que se desea leer. (debe contener extensión).
     * @return Booleano que indica si se realizó la escritura en el archivo.
     */
    public static Boolean writeAsciiFile(String text, String fileName){  
        Boolean write = false;
        Path path = Paths.get(fileName);
        if (Files.exists(path)){
            try{
                String previus = readTextFile(fileName);
                previus = previus + text;      
                PrintWriter out = new PrintWriter(fileName, "UTF-8");
                out.append(previus);
                out.flush();  
                out.close();
                write = true;
            } catch (Exception e) {            
                asciiBox(exception, 69, false, true);
                asciiBox(e, e.toString().length(), false, true);
            }
        } else {
            String warnig = "No se ha encontrado el archivo de guardado especificado.";
            asciiBox(warnig, warnig.length(), false, true);
        }
        return write;
    }    

    /**
     * Método que corrigue la acentuación para sistemas Windows, recibe una cadena y la corrigue para que los acentos se muestren de manera correcta en Windows.
     * <br> Este método ya se usa por defecto en todas las funciones que imprimen texto.
     * <br> Es necesario importar: java.lang.System
     * @param text Cadena de texto a la que se le desea aplicar una correción en los acentos.
     * @return Cadena correguida para mostrar acentos de forma correcta.
     */
    public static String addAccents(String text){
        text = text.replaceAll("á", a);
        text = text.replaceAll("é", e);
        text = text.replaceAll("í", i);
        text = text.replaceAll("ó", o);
        text = text.replaceAll("ú", u);
        text = text.replaceAll("\u00C1", aM);
        text = text.replaceAll("É", eM);
        text = text.replaceAll("\u00ED", iM);
        text = text.replaceAll("Ó", oM);
        text = text.replaceAll("Ú", uM);
        text = text.replaceAll("ñ", n);
        text = text.replaceAll("Ñ", nM);
        text = text.replaceAll("¡", am);
        text = text.replaceAll("¿", qm);
        return text;
    }

    /**
     * Método que realiza una animación en terminal de la escritura de un texto en caja Ascii, para una caja previamente creada.
     * @param text Cadena que contiene una caja Ascii de texto previamente creada.
     * @param speed Entero para indicar la velocidad de la animación.
     */
    public static void asciimateBox(String text, int speed){
        String[] splitBox = text.split("\n");
        int tallBox = splitBox.length;
        int lengthBox = splitBox[0].length();
        int offset = lengthBox+4;
        String blankBox = "";
        String part1 = "";
        String part2 = "";
        String aux = "";
        boolean next = false;

        blankBox = addFrame(si,sd, blankBox, lengthBox, true);
        for(int i = 0; i<(tallBox-2); i++){
            blankBox += ld;
            blankBox = addBlanks(blankBox, lengthBox-2);
            blankBox += ld + "\n";
        }
        blankBox = addFrame(ii, id, blankBox, lengthBox, true);

        while(offset <= ((tallBox-1)*(lengthBox+1))-1){
            part1 = text.substring(0, offset);
            part2 = blankBox.substring(offset, (tallBox)*(lengthBox+1));
            offset++;
            next = false;
            while(!next){
                aux = text.substring(offset, offset+2);
                if(aux.equals("  ")){
                    offset += 2;
                } else {
                    next = true;
                }
            }
            
            try{
                cls();
            } catch(Exception e){
                asciiBox(exception, 69, false, true);
                asciiBox(e, e.toString().length(), false, true);            
            } 
            System.out.println(part1+part2);
            try {
                Thread.sleep(1 * speed);
            } catch (InterruptedException e) {
                asciiBox(exception, 69, false, true);
                asciiBox(e, e.toString().length(), false, true);              
                Thread.currentThread().interrupt();
            }             
        }
    }

    /**
     * Método que realiza una Asciimation (Animación Ascii Art) dada una secuencia de frames (cadenas de Ascii Art) dadas.
     * <br> Se recomienda generar los frames con el método "readAsciiFile(...)".
     * @param listOfFrames ArrayList de cadenas que contienen los frames a animar.
     * @param speed Entero para indicar la velocidad de la animación.
     */
    public static void asciiMation(ArrayList<String> listOfFrames, int speed){
        for(String f : listOfFrames){            
            try{
                cls();
            } catch(Exception e){
                asciiBox(exception, 69, false, true);
                asciiBox(e, e.toString().length(), false, true);              
            } 
            System.out.println(f);
            try {
                Thread.sleep(1 * speed);
            } catch (InterruptedException e) {
                asciiBox(exception, 69, false, true);
                asciiBox(e, e.toString().length(), false, true);
                Thread.currentThread().interrupt();
            }             
        }
    }

    /**
     * Método que transforma un arrglo de Objects a una representación en Ascii Art.
     * @param array Arreglo de Object para transformar a Ascii Art.
     * @param print Booleano que indica si se imprime el resultado una vez generado.
     * @return Cadena que representa el arreglo dado como parámetro en Ascii Art.
     */
    public static String asciiArray(Object[] array, boolean print){
        int len = array.length;
        String asciiArr = "", aux = "";
        int maxlength = 1, auxLen = 1;

        for(Object o : array){
            if(o != null){
                aux = o.toString();
                aux = addAccents(aux);
                auxLen = aux.length();
                if(auxLen > maxlength){
                    maxlength = auxLen;
                }
            }
        }

        asciiArr = addSpecialFrame(si,tn,sd,asciiArr,maxlength,len,true);
        asciiArr += ld;
        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
                aux = array[i].toString();
                aux = addAccents(aux);
                asciiArr = addWordMiniFrame(asciiArr, aux, ld, maxlength,false);
            } else{
                asciiArr = addBlanks(asciiArr, maxlength);
                asciiArr += ld;
            }
        }
        asciiArr += "\n";
        asciiArr = addSpecialFrame(ii,ti,id,asciiArr,maxlength,len,true);

        if(print){
            System.out.println(asciiArr);
        }
        return asciiArr; 
    }

    /**
     * Método que convierte una matriz de Objects a una cadena en Ascii Art.
     * @param matrix Matriz de Objects a transformar a representación Ascii.
     * @param print Booleano que indica si se imprime el resultado una vez generado.
     * @return Cadena con la representación en Ascii Art de la matriz dada.
     */
    public static String asciiMatrix(Object[][] matrix, boolean print){
        int len = matrix.length;
        String asciiMat = "", aux = "";
        int maxlength = 1, auxLen = 1;

        for(int i = 0; i < len; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] != null){
                    aux = matrix[i][j].toString();
                    aux = addAccents(aux);
                    auxLen = aux.length();
                    if(auxLen > maxlength){
                        maxlength = auxLen;
                    }
                }
            }
        }
        asciiMat = addSpecialFrame(si,tn,sd,asciiMat,maxlength,matrix[0].length,true);
        
        for(int i = 0; i<len; i++){
            asciiMat += ld;
            for(int j =0; j<matrix[i].length; j++){
                if(matrix[i][j] != null){
                    aux = matrix[i][j].toString();
                    aux = addAccents(aux);
                    asciiMat = addWordMiniFrame(asciiMat, aux, ld, maxlength,false);
                } else{
                    asciiMat = addBlanks(asciiMat, maxlength);
                    asciiMat += ld;
                }
            }
            asciiMat += "\n";
            if(i == len-1){
                asciiMat = addSpecialFrame(ii,ti,id,asciiMat,maxlength,matrix[matrix.length-1].length,true);
            } else{
                asciiMat = addSpecialFrame(fi,dt,fd,asciiMat,maxlength,matrix[matrix.length-1].length,true);
            }
        }

        if(print){
            System.out.println(asciiMat);
        }
        return asciiMat; 
    }

    /**
     * Método para generar tablas con Ascii Art.
     * @param title Cadena con el título de la tabla.
     * @param headers ArrayList de Cadenas con las cabeceras de cada tabla.
     * @param items ArrayList de ArrayList de Objects que conforman en contenido de la tabla.
     * @param columns Booleano que indica de que forma se deben llenar la tabla. True = llenar por columnas (arriba-abajo) Fasle = llenar por filas (izquiera-derecha).
     * @param separators Booleano que indica si se usarán separadores entre cada fila de la tabla.
     * @param print Booleano que indica si se imprime el resultado una vez generado.
     * @return Cadena que representa la tabla en Ascii Art.
     */
    public static String asciiTable(String title, ArrayList<String> headers, ArrayList<ArrayList<Object>> items, boolean columns, boolean separators, boolean print){
        String table = "", aux = "";
        int maxlength = 1, totalLength = 1, auxLen = 0, cont = 0;

        if(checkSizes(items, headers.size(), columns)){
            title = addAccents(title);
            for(String i : headers){
                aux = i.toString();
                aux = addAccents(aux);
                auxLen = aux.length();
                if(auxLen > maxlength){
                    maxlength = auxLen;
                }
            }
            totalLength = (maxlength*headers.size())+headers.size()+1;
            table = addFrame(si,sd,table,totalLength,true);
            table += ld;
            table = addWordMiniFrame(table,title,ld,totalLength-2,false);
            table += "\n";
            table = addSpecialFrame(fi,tn,fd,table,maxlength,headers.size(),true);
            table += ld;
            for(String s : headers){
                s = addAccents(s);
                table = addWordMiniFrame(table,s,ld,maxlength,false);
            }      
            table += "\n";
            table = addSpecialFrame(fi,dt,fd,table,maxlength,headers.size(),true);

            if(!columns){
                for(ArrayList<Object> ao : items){
                    table += ld;
                    for(Object o : ao){
                        if(o != null){
                            aux = o.toString();
                            aux = addAccents(aux);
                            table = addWordMiniFrame(table,aux,ld,maxlength,false);
                        } else {
                            table = addBlanks(table, maxlength);
                            table += ld;
                        }
                    }
                    table += "\n";
                    if(separators){
                        if(cont == items.size()-1){
                            table = addSpecialFrame(ii,ti,id,table,maxlength,headers.size(),true);
                        } else {
                            table = addSpecialFrame(fi,dt,fd,table,maxlength,headers.size(),true);
                        }
                    } else {
                        if(cont == items.size()-1){
                            table = addSpecialFrame(ii,ti,id,table,maxlength,headers.size(),true);
                        }               
                    }
                    cont++;
                }
            } else {
                for(int i = 0; i<items.get(0).size(); i++){
                    table += ld;
                    for(ArrayList<Object> ao : items){
                        Object o = ao.get(i);
                        if(o != null){
                            aux = o.toString();
                            aux = addAccents(aux);
                            table = addWordMiniFrame(table,aux,ld,maxlength,false);
                        } else {
                            table = addBlanks(table, maxlength);
                            table += ld;
                        }
                    }
                    table += "\n";
                    if(separators){
                        if(cont == items.get(0).size()-1){
                            table = addSpecialFrame(ii,ti,id,table,maxlength,headers.size(),true);
                        } else {
                            table = addSpecialFrame(fi,dt,fd,table,maxlength,headers.size(),true);
                        }
                    } else {
                        if(cont == items.get(0).size()-1){
                            table = addSpecialFrame(ii,ti,id,table,maxlength,headers.size(),true);
                        }               
                    }                    
                    cont++;
                }
            }
            if(print){
                System.out.println(table);
            }
        } else {
            String warnig = "No se puede genear la tabla dado que la longitud de alguna de las listas no coincide con la cantidad de cabeceras de la tabla.\nNota: Para generar celdas vacías colcar un valor 'null' en la lista.";
            asciiBox(warnig, -1, true, true);
        }        
        return table;
    }

    /**
     * Método que transforma un ArrayList de Objects a una representación de Ascii Art.
     * @param list ArrayList de Objects que se desea transformar.
     * @param print Booleano que indica si se imprime el resultado una vez generado.
     * @return Cadena con la representación en Ascii Art del ArrayList dado.
     */
    public static String asciiArrayList(ArrayList<Object> list, boolean print){
        String asciiList = "";
        String aux = "";
        if(!list.isEmpty()){
            for(Object o : list){
                if(o != null){
                    aux = addAccents(o.toString());
                    asciiList += aux + " < ";
                } else {
                    asciiList +=  "NULL < ";
                }
            }        
            int blank = asciiList.lastIndexOf(" < ");
            if( blank != -1){
                asciiList = asciiList.substring(0, blank);
            }
        } else {
            asciiList = "EMPTY ARRAYLIST";
        }
        int length = asciiList.length();
        if(length > 90){
            asciiList = asciiBox(asciiList, -1, false, print);
        } else {
            asciiList = asciiBox(asciiList, length, false, print);
        }
        return asciiList;
    }

    /**
     * Método que transforma un Stack de Objects a una representación de Ascii Art.
     * @param stack Stack de Objects que se desea transformar a Ascii Art.
     * @param print Booleano que indica si se imprime el resultado una vez generado.
     * @return Cadena con la representación Ascii Art del Stack dado.
     */
    public static String asciiStack(Stack<Object> stack, boolean print){
        String asciiStack = "\n", aux = "";
        Stack<Object> stackCopy = stack;
        int maxlength = 1, totalLength = 1, auxLen = 0, cont = 0;

        if(!stack.isEmpty()){
            for(Object o : stack){
                if(o != null){
                    aux = o.toString();
                    aux = addAccents(aux);
                    auxLen = aux.length();
                    if(auxLen > maxlength){
                        maxlength = auxLen;
                    }
                }
            }
            for(Object o : stack){
                if(o != null){
                    aux = o.toString();
                    aux = addAccents(aux);            
                    asciiStack += " " +ld;
                    asciiStack = addWordMiniFrame(asciiStack,aux,ld,maxlength,false);
                    if(cont == 0){
                        asciiStack += " <= TOP";
                    }
                } else {
                    asciiStack += " " +ld;
                    asciiStack = addBlanks(asciiStack, maxlength);
                    asciiStack += ld;
                }
                asciiStack += "\n ";
                if(cont == stack.size()-1){
                    asciiStack = addFrame(ii,id,asciiStack,maxlength+2,true);
                } else {
                    asciiStack = addFrame(fi,fd,asciiStack,maxlength+2,true);
                }            
                cont++;
            }
        } else {
            aux = "    ";
            asciiStack += " " + ld;
            asciiStack = addWordMiniFrame(asciiStack,aux,ld,6,false);
            asciiStack += " <= TOP\n ";
            asciiStack = addFrame(ii,id,asciiStack,8,false);
            asciiStack += "\n";
            asciiStack += "EMPTY STACK";
        }
        if(print){
            System.out.println(asciiStack);
        }
        return asciiStack;
    }

    /**
     * Método que transforma un arrglo de Objects a una representación en Ascii Art.
     * @param text Arreglo de Object para transformar a Ascii Art.
     * @param offset Booleano que indica si se imprime el resultado una vez generado.
     * @return Cadena que representa el arreglo dado como parámetro en Ascii Art.
     */
    public static String addOffSet(String text, int offset){
        String newText = "";
        String off = "";
        off = addBlanks(off, offset);
        String[] lines = text.split("\n");

        for(String s : lines){
            newText += off + s + "\n";
        }

        return newText; 
    }    

    /**
     * Método que regresa la longuitud de un frame de una cadena de caja Ascii  Art dada.     
     * @param box Cadena de una caja Ascii previamente creada.
     * @return Entero con la longuitud del Frame de la caja dada.
     */
    public static int frameLength(String box){
        String[] splitBox = box.split("\n");
        int lengthBox = splitBox[0].length();
        return lengthBox;
    }

    /**
     * Método que regresa la altura de un frame de una cadena de Ascii Art dada.
     * @param box Cadena de una caja Ascii previemente creada.
     * @return Entero con la altura del Frame de la caja dada.
     */
    public static int frameTall(String box){
        String[] splitBox = box.split("\n");
        int tallBox = splitBox.length;
        return tallBox;        
    }

    /**
     * Método auxiliar que verifica las longuitudes de las listas para la cración de la tabla Ascii Art.
     * @param items ArrayList de ArrayList de Objects a verificar.
     * @param size Entero con el tamaño máximo para verificar (Número de cabeceras de la tabla).
     * @param columns Booleano que indica si la tabal se llenará por filas o columnas, true = columnas.
     * @return Booleano que indica si las longuitudes son correctas según sea el caso. (Filas o columnas).
     */
    public static boolean checkSizes(ArrayList<ArrayList<Object>> items, int size, boolean columns){
        boolean ok = true;
        int aux = 0;
        if(!columns){
            for(ArrayList<Object> ao: items){
                if(ao.size() != size){
                    ok = false;
                }
            }
        } else {
            if(items.size() != size){
                ok = false;
            } else {
                aux = items.get(0).size();
                for(ArrayList<Object> ao: items){
                    if(ao.size() != aux){
                        ok = false;
                    }
                }
            }
        }
        return ok;
    }

    /**
     * Método que imprime en terminal el Objeto pasado como parámetro.
     * @param o Objecto a imprimir en terminal.
     */
    public static void show(Object o){
        System.out.println(o.toString());
    }

    /**
     * Método que limpia la terminal. Multisitema, se puede ejecutar tanto en Linux como en Windows,
     * para Linux unicamente imprime una cadena ANSI para saltar el tope de la terminal.
     * @throws IOException En caso de errores de I/O.
     * @throws InterruptedException En caso de que un thread falle.
     */
    public static void cls()throws IOException, InterruptedException{
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {                
                //Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
            }            
        } catch (IOException | InterruptedException e) {
            asciiBox(exception, 69, false, true);
            asciiBox(e, e.toString().length(), false, true);            
        }    
    }

    /**
     * Método que duerme el thread actual la cantidad de tiempo indicada. (Usado para las animaciones).
     * @param time Entero de tiempo a dormir el thread actual.
     * @throws InterruptedException En caso de que se interrumpa la ejecución del thread.
     */
    public static void wait(int time) throws InterruptedException{
        try {
            Thread.sleep(1 * time);
        } catch (InterruptedException e) {
            asciiBox(exception, 69, false, true);
            asciiBox(e, e.toString().length(), false, true);
        }
    }

    /**
     * Método que inicializa un contador en milisengudos.
     */
    public static void startTimer(){
        inicio = System.currentTimeMillis();
    }

    /**
     * Método que detiene timer y devuelve el valor y puede impirmir el resultado.
     * @param print Booleano que indica si se imprime el resultado en milisegundos.
     * @return Long con el tiempo en milisegundos.
     */
    public static long stopTimer(boolean print){
        finaly = System.currentTimeMillis();
        tiempo = finaly - inicio;
        if(print){
            String timer = "Tiempo de ejecución: " + tiempo + " ms";
            timer = addAccents(timer);
            asciiBox(timer, timer.length(), false, true);
        }
        return tiempo;
    }    

    /**
     * Método que devuelve una lista Ascii Art de los caracteres usados en esta clase así como la codificación que se usó para los mismos en Unicode.
     * @return Cadena que representa la tabla de caracteres de este proyecto.
     */
    public static String characterMap(){
        String title = "Mapa de caracteres";
        ArrayList<String> cabeceras = new ArrayList<String>();
        cabeceras.add(" Caracter "); cabeceras.add(" Unicode ");
        ArrayList<ArrayList<Object>> items = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> character = new ArrayList<Object>();
        ArrayList<Object> unicode = new ArrayList<Object>();

        character.add("\u2554"); unicode.add("\\u2554");   character.add("\u2557"); unicode.add("\\u2557");
        character.add("\u255A"); unicode.add("\\u255A");   character.add("\u255D"); unicode.add("\\u255D");
        character.add("\u2551"); unicode.add("\\u2551");   character.add("\u2550"); unicode.add("\\u2550");
        character.add("\u2560"); unicode.add("\\u2560");   character.add("\u2563"); unicode.add("\\u2563");
        character.add("\u2569"); unicode.add("\\u2569");   character.add("\u2566"); unicode.add("\\u2566");
        character.add("\u256C"); unicode.add("\\u256C");   character.add("\u00B6"); unicode.add("\\u00B6");
        character.add("\u00E1"); unicode.add("\\u00E1");    character.add("\u00E9"); unicode.add("\\u00E9");
        character.add("\u00ED"); unicode.add("\\u00ED");    character.add("\u00f3"); unicode.add("\\u00f3");
        character.add("\u00fa"); unicode.add("\\u00fa");    character.add("\u00f1"); unicode.add("\\u00f1");
        character.add("\u00C1"); unicode.add("\\u00C1");   character.add("\u00C9"); unicode.add("\\u00C9");
        character.add("\u00ED"); unicode.add("\\u00ED");   character.add("\u00D3"); unicode.add("\\u00D3");
        character.add("\u00Da"); unicode.add("\\u00Da");   character.add("\u00D1"); unicode.add("\\u00D1");
        items.add(character); items.add(unicode);

        String characterMap = asciiTable(title, cabeceras, items, true, true, true);
        return characterMap;
    }

    /**
     * Método que concatena dos Ascii Art de modo que queden uno junto al otro.
     * @param firstAscii Cadena del primer Ascii Art.
     * @param lastAscii Cadena del segundo Ascii Art a concatenar al primero.
     * @return Cadena con los Ascii Art concatenados.
     */
    public static String concatAscii(String firstAscii, String lastAscii){
        String ascii = "";
        int numberLines = 0;
        int linesLength = 0;
        String[] lines = firstAscii.split("\n");
        String[] lines2 = lastAscii.split("\n");
        numberLines = lines.length;
        //Buscamos la linea mas larga.
        for(String s : lines){
            if(s.length() > linesLength){
                linesLength = s.length();
            }
        }
        //Redimensionamos los arreglos para que sean del mismo tamaño.
        if(lines.length < lines2.length){
            String[] newLines = Arrays.copyOf(lines, lines2.length);
            lines = newLines;
            for(int i = 0; i < lines.length; i++){
                if(lines[i] == null){
                    String voyd = "";
                    lines[i] = addBlanks(voyd, linesLength);
                }
            }            
        } else if(lines2.length < lines.length){
            String[] newLines = Arrays.copyOf(lines2, lines.length);
            lines2 = newLines;
            for(int i = 0; i < lines2.length; i++){
                if(lines2[i] == null){
                    String voyd = "";
                    lines2[i] = addBlanks(voyd, linesLength);
                }
            }
        }
        //Redimensionamos las lineas del primer arreglo para que sea de la misma longuitud.
        for(int i = 0; i < lines.length; i++){
            int resta = linesLength - lines[i].length();
            lines[i] = addBlanks(lines[i], resta);
        }
        //Concatenamos.
        for(int i = 0; i<lines.length; i++){
            ascii += lines[i] + lines2[i] + "\n";
        }
        return ascii;
    }
}