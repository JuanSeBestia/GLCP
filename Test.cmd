@echo off
java org.antlr.v4.Tool Python3.g4
pause
javac *.java
pause
java org.antlr.v4.runtime.misc.TestRig Python3 file_input –gui hola.py
pause
exit