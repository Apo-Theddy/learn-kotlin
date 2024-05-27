@echo off
nodemon -e kt --exec "kotlinc .\variables.kt -include-runtime -d variables.jar && java -jar variables.jar"
