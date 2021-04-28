# Ascii-Boxes-Terminal-Interface
_Un programa para convertir Cadenas, Arreglos, Matrices, Objetos y mucho mas a cadenas ASCII Art para simular una Interfaz Grafica en la Terminal (linea de comandos)._

_A class program to cast strings, arrays, matrix, objets and more to an ASCII Art string to simulate a Graphic Interface in Terminal (Commad Line)._

## Comenzando

_Para usar esta clase es necesario descargar el archivo "AsciiBox.java" este proyecto aún está en desarrollo por lo que muchas funciones pueden ser modificadas en un futuro, se añadirán las actualizaciones mas abajo._

Descarga **AsciiBox.java** para usar ésta clase.

## Pre-requisitos 

_La clase fue desarrollada en Java 1.8, por lo que versiones posteriores no deberían tener ningún problema, dejando de lado que alguna función para cadenas quede obsoleta._

## Para su uso

_En ese README podrán encontar diversos ejemplos sobre su uso y funcionamiento, pero se incluyen dos archivos de prubea dentro de la carpeta "Pruebas" que se pueden ejecutar para observar su funcionamiento._

Todos los métodos y varialbes de la clase son estáticas, por lo que no es necesario crear una instacia de la misma, unicamente basta con mandar llamar la función que se desea utilizar:
```
AsciiBox.asciiBox(String, int, Boolean, Boolean);
```
Consultar **Pruebas** para los ejemplos practicos.

## Funciones

A continuación se deja un listado de las funciones diponibles:

* String addBlanks(String ren, int rest)
* String addFrame(String start, String end, String text, int len, boolean jump)
* String addSpecialFrame(String start, String middle, String end, String text, int wordLen, int totalSpaces, boolean jump)
* String addWordMiniFrame(String text, String word, String middle, int maxlength, boolean jump)
* String asciiBox(String text, int size, boolean justify, boolean print)
* String asciiBox(Object object, int size, boolean justify, boolean print)
* ArrayList<String> readAsciiFile(String fileName){ 
* String readTextFile(String fileName){ 
* Boolean writeAsciiFile(String text, String fileName){ 
* String addAccents(String text)
* void asciimateBox(String text, int speed)
* void asciiMation(ArrayList<String> listOfFrames, int speed)
* String asciiArray(Object[] array, boolean print)
* String asciiMatrix(Object[][] matrix, boolean print)
* String asciiTable(String title, ArrayList<String> headers, ArrayList<ArrayList<Object>> items, boolean columns, boolean separators, boolean print)
* String asciiArrayList(ArrayList<Object> list, boolean print)
* String asciiStack(Stack<Object> stack, boolean print)
* int frameLength(String box)
* int frameTall(String box)
* boolean checkSizes(ArrayList<ArrayList<Object>> items, int size, boolean columns)
* void show(Object o)
* void cls()throws IOException, InterruptedException
* void wait(int time) throws InterruptedException
* String characterMap()
* String concatAscii(String firstAscii, String lastAscii)
* void startTimer()
* long stopTimer(boolean print)
* String addOffSet(String text, int offset)


_Cada función cuenta con su respectiva documentación que puede consultarse en la carpeta "Documentación" de este proyecto._

Consultar **Documentacion** para los ejemplos prácticos.

## Versionado 📌

_1.3_
Tercera actualización oficial, sujeta a más actualizaciones.

_Cambios de la versión 1.1:_

* Añadida la función para concatenar dos Ascii Art.
* Añadida una función para iniciar un contador en milisegundos.
* Añadida una función para detener el contador y devolver su valor como long o imprimirlo como string.


_Cambios de la versión 1.2:_

* La función 'addAccents(String text)' ahora corrige los símbolos '¡' y '¿' en la cadena parámetro.
* Las variables y los métodos ahora son estáticas, por lo que no es necesario instanciar la clase para usar sus métodos.


_Cambios de la versión 1.2.1:_

* Correción de un bug en el método addWordMiniFrame(...).


_Cambios de la versión 1.3:_

* Añadida una función para agregar un offset a una cadena o caja dada.

## Autor ✒️

* **Hernández Ferreiro Enrique Ehecatl**,
_Facultad de Ciencias, UNAM._
_linkhernandez@ciencias.unam.mx_,
_Link8838_

## Licencia 📄

_Esta clase es de uso libre para cualquiera que la necesite, actualizada a código abierto, has buen uso del tiempo que invertí en esto._

---
Que nadie te diga que la terminal no es una interfaz gráfica. (Link8838).
