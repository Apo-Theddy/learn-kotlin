class Mascota {
  var nombre: String
    get(){
      println("Llamada al getter de nombre")
      return field;
    }

    set(nuevoNombre){
      println("Llamada al setter de nombre")
      field = nuevoNombre 
    }

  var edad:Int;

  constructor(nombre:String,edad:Int){
    this.nombre = nombre;
    this.edad = edad;
  }

  fun saludar(){
    println("Hola me llamo $nombre y tengo $edad años")
  }
}

fun main(){
  val scrapy = Mascota("scrapy",5)
  scrapy.saludar();
}
