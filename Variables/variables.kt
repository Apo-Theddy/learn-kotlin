fun main(/*args:Array<String>*/){
  // primerVistazoVariables();
  // cadenas();
  // variables();
  // arrays();
  // argsFunction(args);
  anys();
}

fun primerVistazoVariables(){
  var edad:Int = 25;
  println(edad);
  println("Tipo Inferido");
  var edadInferido = 25;
  println(edadInferido);
}

fun cadenas(){
  var edadJuan:Int = 21;
  println("La edad de Juan es: "+edadJuan);
  println("Un anio despues...");
  edadJuan++;
  println("la edad de Juan es: "+edadJuan);
  
  // Plantilla de strings
  // println("La edad de Juan es $edadJuan");
  // println(String.format("La edad de Juan es %d",edadJuan));
  println("La edad de Juan es: " + edadJuan.toString());
}

fun variables(){
  // var edadJuan:Int = 21; // Variable mutable
  // val nombrePersona:String = "Juan"; // Variable inmutable - constante
}

fun arrays(){
  val miArray = Array(5){0};
  miArray[2] = 7;
  println(miArray[2]);
  println(miArray.joinToString());
  val miArray2 = intArrayOf(1,7,9,15,25);
  println(miArray2.joinToString());

  lateinit var miArray3:Array<String>;
  miArray3 = arrayOf("Hola","Alumnos","Fieles");
  println(miArray3.joinToString());
}

fun argsFunction(args:Array<String>){
  val numeros = args.map{ it.toInt() }.toIntArray();
  println(numeros.joinToString());

  val suma = numeros.sum();
  println("La suma de los elementos: ${suma}");
}

class Persona(val nombre:String){
  override fun toString():String{
    return "Nombre: $nombre";
  }
}

fun anys(){
  val numero:Any = 11;
  println(numero);

  val p1:Any = Persona("Juan");:
  println(p1);
  println(dameTipo(10))
  println(dameTipo(true))
}

fun dameTipo(obj:Any):Any{
  return obj::class.simpleName ?:"Desconocido";
}
