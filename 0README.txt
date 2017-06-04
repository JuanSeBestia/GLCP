Deteccion de plagios de codgio fuente escrito en Python usando ANTLR v4

Dependencias para su ejecucion
- Java 7 o mayor
Ejecucion
En la carpeta src/ esta todos los archivos necesarios para el mismo atravez
de comandos en la consola
En la carpeta Bin se ecnuentran los bianrios para Windows con lo cual no es
necesario correrlo en consola pero tiene suseptibilidad a ls fallos se 
recomienda la normal
 
Modo prueba
>java Test
Sin argumentos extraera los archivos Test.py y test1.py para ser 
Modo Normal
>java Test Codigo1.py Codigo2.py


En lo dos casos mostrara los siguiente
-Arbol de sitactico de cada codigo
-La prueba de similitud de arboles
-Tabla de llamadas de reglas gramaticales
-Estadisticas generales del resultado del programa

Dependencias para su compilacion
- JDK 7 o mayor
- libreria de ANTLR (src/antlr-4.5.1.-omplete.jar)
- seguir los pasos de instalacion (VEASE Clase 12 - Felipe Restrepo Calle - 
LP )

1. Si desea recompilar la gramatica por actualizacion del lnguaje pude hacerlo
de la misma manera que vista en los ejemplos de instalacion (VEASE Clase 12 - 
Felipe Restrepo Calle - LP )

2. Se compila todos los archivos java incluyendo la libreria por sistema o como
parametro
>javac -cp antlr-4.5.1.-omplete.jar *.java
o
>java *.java
Solo si el classPath incluye la libreria

Esta listo para su ejucucion