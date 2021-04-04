# Ascii-Boxes-Terminal-Interface
_Un programa para convertir Cadenas, Arreglos, Matrices, Objetos y mucho mas a cadenas ASCII Art para simular una Interfaz Grafica en la Terminal (linea de comandos)._

_A class program to cast strings, arrays, matrix, objets and more to an ASCII Art string to simulate a Graphic Interface in Terminal (Commad Line)._

## Comenzando

_Para usar esta clase es necesario descargar el archivo "AsciiBox.class" dado que aun es un proyecto en desarrollo (e hice un desastre con mi código, perdón) solo se cuenta con el .class disponible, el .java una vez quede todo perfecto será cargado al repositorio._

Descarga **AsciiBox.class** para usar ésta clase.

## Pre-requisitos 

_La clase fue desarrollada en Java 1.8, por lo que versiones posteriores no deberían tener ningún problema, dejando de lado que alguna función para cadenas quede obsoleta._

## Para su uso

_En ese README podrán encontar diversos ejemplos sobre su uso y funcionamiento, pero se incluyen dos archivos de prubea dentro de la carpeta "Pruebas" que se pueden ejecutar para observar su funcionamiento._

Será necesario crear una instacia de la clase para mandar llamar sus métodos:
```
AsciiBox asciibox = new AsciiBox();
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

_Cada función cuenta con su respectiva documentación que puede consultarse en la carpeta "Documentación" de este proyecto_
Consultar **Documentacion** para los ejemplos practicos.

## Versionado 📌

_1.0_
Primera versión oficial, sujeta a actualizaciones.

## Autores ✒️

* **Hernández Ferreiro Enrique Ehecatl**
_Facultad de Ciencias, UNAM._
_linkhernandez@ciencias.unam.mx_
_Link8838_

## Licencia 📄

_Esta clase es de uso libre para cualquiera que la necesite, por el momento no cuenta con código abierto, pero eso no limita su libre uso, en un futuro se cargará todo el código para hacerla de código abierto._

---
Que nadie te diga que la terminal no es una interfaz gráfica. (Link8838).
