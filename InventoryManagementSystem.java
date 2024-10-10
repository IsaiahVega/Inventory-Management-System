import java.io.*; //Importamos todas las clases de la carpeta java.io.
import java.util.Scanner; // Importamos la

public class InventoryManagementSystem { // Clase principal.

  static Scanner keyboard = new Scanner(System.in); // Crear variable global de tipo Scanner.

  static void buscarArticulo(String codigoArticulo) { // Empezamos el método "buscarArticulo" que va a recibir el valor
                                                      // que esté almacenado en
    // codigoArticulo

    try { // Inicializamos "try" que se utiliza cuando se desean prever excepciones en el
          // transcurso de la ejecución de un programa.
      FileReader reader = new FileReader(codigoArticulo + ".txt"); // Asignamos una variable para la clase "FileREader"
                                                                   // que en este caso sería "reader".
      Scanner archivo = new Scanner(reader); // Asignamos una variable para la clase de "Scanner" que en este caso sería
                                             // "archivo".
      while (archivo.hasNextLine()) { // .hasNextLine() es un método que delvuelve verdadero si hay otra línea en la
                                      // entrada de "Scanner". Empieza la
        // Estructura de control while
        String linea = archivo.nextLine(); // Se almacena en la variable "línea" la entrada del usuario.

        System.out.println(linea); // Se imprime en la pantalla el el valor que se encuentra en línea.
      } // Termina la estructura de control "While".
      archivo.close(); // Cierra el archivo
    } // //Termina el "try"
    catch (IOException e) { // "Catch" permite que manejar errores de tiempo de ejecución.
      System.out.println("Articulo no encontrado."); // Se imprime el mensaje que se encuentra entre paréntesis de haber
                                                     // un error.
    } // Termina "Catch".
  } // Cierra el método "codigoArticulo".

  static void crearArticulo() { // Abre el método "crearArticulo"
    PrintWriter articuloNuevo; // Creamos la variable tipo "PrintWriter".
    // Debajo inicializamos el arreglo "Info[]" para almacenar los datos de los
    // artículos.
    String[] info = {
        "Nombre del Articulo (Puede tener numeros y letras): ",
        "Descripcion del Articulo:",
        "Codigo del articulo (Solo numeros): ",
        "Fecha de compra del lote: (Formato: MM/DD/AAAA):", // El arreglo guardarrá todos los valores que
        "Fecha de expiracion (Formato: MM/DD/AAAA):", // se encuentran cada espacio índice
        "Cantidad comprada (Solo numeros):",
        "Cantidad dañada (Solo numeros):",
        "Cantidad vendida (Solo numeros):",
        "Precio por articulo (Formato: $ 0.00 ):",
        "Total vendido (Solo numeros)",
    };

    for (int i = 0; i < info.length; i++) { // Iniciamos la estructura de control "for" que repetirá el bloque de
                                            // instrucciones hasta que la condición sea falsa.
      System.out.println(info[i] + ": "); // Se imprime el elemento que se encuentre en índice. El índice lo determina
                                          // el valor que se encuentra en la variable "i"
      info[i] = keyboard.nextLine(); // Asignar valor del arreglo a lo que el usuario entro.
    }
    try { // Iniciamos el "try" que ejecutará los valores que se encuentre dbuscaentro de
          // él.
      // Escribir los valores del arreglo a el archivo.
      articuloNuevo = new PrintWriter(info[2] + ".txt"); // Se le asigna la variable de articuloNuevo a PrintWriter y
                                                         // escribirá en un .txt file el String que
      // está dentro de el índice 2
      for (String s : info) { // Iniciamos la estructura de control "for" que repetirá el bloque de
                              // instrucciones hasta que la condición sea falsa.
        articuloNuevo.println(s); // imprime en el .txt file el String o el valor que se encuentre en la posición
                                  // "j" que es una variable que almacena 0 y va incrementando por el j++
      } // Termina el "for". //j++ indica el índice que busca.
      articuloNuevo.close(); // Cerramos el archivo.
    } catch (Exception e) { // Termina el 'Try'
      System.out.println("Hubo un error al crear el articulo."); // Imprime el mensaje que se encuentra entre "()" de
                                                                 // haber un error en el bloque de código que se
      // Encuentra en "try"
    } // Cierra el "catch"
  } // Termina el método "crearArticulo()"

  static void editarCodigo() { // Abre el método editarCódigo
    String codigoArticulo; // Se inicializa la variable "codigoArticulo" como una variable tipo String
    String opcion; // Se inicializa la variable "opcion" como una variable tipo String
    String[] editInfo = new String[10]; // Creará un arreglo llamado editInfo tipo String que tendrá 11 índices.
    System.out.println("Codigo del articulo: "); // Imprime en la pantalla el mensaje entre "()" indicándole al usuario
                                                 // que entre el código del artículo.
    codigoArticulo = keyboard.nextLine(); // el valor o cadéna de caractéres que guarde el usuario se almacenará en
                                          // "codigoArticulo".

    System.out.println( // Imprime la cadena de mensajes que se encuentra dentro de los "()".
        "Entre el numero de lo que desea editar: \n1.Nombre (Puete tener numero y letras) \n2.Descripcion del articulo (Puede tener numero y letras) \n3.Codigo del articulo (Solo numeros) \n4.Fecha de compra del lote (Formato: MM/DD/AAAA)\n5.Fecha de expiracion (Formato: MM/DD/AAAA)\n6.Cantidad comprada (Solo numeros)\n7.Cantidad dañada (Solo numeros) \n8.Cantidad vendida (Solo numeros) \n9.Precio por articulo (Formato: $ 0.00)\n10.Total vendido (Solo numeros)");

    opcion = keyboard.nextLine(); // La variable opción almacenará el número de opción que escogio el usuario.

    try { // Empieza el "try" que intentará ejecutar la lista de instrucciones que se
          // encuentre dentro de ella.
      FileReader reader = new FileReader(codigoArticulo + ".txt"); // Creamos la variable "reader" tipo "FileReader" que
                                                                   // almacenará el leerá el archivo cuyo nombre se
                                                                   // encuentra dentro de "codigoArtículo".

      Scanner archivo = new Scanner(reader); // Creamos la variable "archivo" para "Scanner".
      for (int i = 0; i < editInfo.length; i++) { // Iniciamos la estructura de control "for" que repetirá la lista de
                                                  // instruciones que se encuentra dentro de ella hasta que la condición
                                                  // sea falsa.
        editInfo[i] = archivo.nextLine(); // Editará la línea con lo que el usuario entre por medio del teclado.
      }
      archivo.close(); // Cerramos el archivo.
    } catch (IOException e) { // De ocurrir un error se ejecutará el "catch"
      System.out.println("Archivo no encontrado"); // Imprimir mensaje si hay error.
    } // finaliza el "catch"
    // Entrar nueva informacion.
    System.out.println("Entre nueva informacion:"); // Imprime el mensaje entre "()" en la pantalla indicando al usuario
                                                    // que entre una nueva información.
    String newInfo = keyboard.nextLine(); // Se crea la variable "newInfo" tipo "String" y almacenará la entrada del
                                          // usuario por medio del teclado.

    // Se usa la varible opcion para indicar el indice que se va cambiar.
    // Se le resta 1 ya que el arreglo empieza en index 0.
    editInfo[Integer.parseInt(opcion) - 1] = newInfo;

    try { // Comienza el "try" ejecutará la lista de código que se encuentre dentro de
          // él".
      PrintWriter articuloEditado; // Esta línea escribe los valores del arreglo a el archivo.

      articuloEditado = new PrintWriter(codigoArticulo + ".txt"); // "articuloEditado" pasarí aa ser el nuevo
                                                                  // "PrintWriter"
      // y escribira lo que tenga dentro en el file cuyo nombre se encuentra dentro de
      // "códigoArticulo".

      for (String s : editInfo) { // Comienza la estructura de contro "for" que terminará de ejecutarse una vez la
                                  // condición sea falsa.
        articuloEditado.println(s); // Escribirá en el .txt file la información qu ese encuentre almacenado en el
                                    // arreglo editInfo en el índice "j" que cuyo valor lo inicial es 0 u
        // y va incrementndo el valor de "j" por medio de j++.
      } // Termina la estructura de control "for".
      articuloEditado.close(); // Cerramos el archivo que estemos utilizando.
    } catch (IOException e) { // De haber un error en el "try" se ejecutrará el "catch">
      System.out.println("Archivo no encontrado"); // Imprimirá el mensaje que se encuentra entre "()"
    } // Termina el "catch".
  } // Termina el método "editarCodigo()"

  static void borrarCodigo() { // Comienza el método "borrarCodigo()"
    File archivo; // Se crea una variabe tipo File
    String codigoArticulo; // Se crea una variable tipo String.
    System.out.println("Codigo del articulo a borrar: "); // Imprime el mensaje entre "()" inidicando al usuario el que
                                                          // entre el código del artículo que desea borrar.
    codigoArticulo = keyboard.nextLine(); // Guardar lo que el usuario entro en la variable "codigoArticulo".
    archivo = new File(codigoArticulo + ".txt"); // Darle valor a archivo, concatenar codigoArticulo con .txt.

    // Borrar arhivo
    if (archivo.delete()) { // Comenzamos la estructura de control "if".
      System.out.println("Articulo borrado."); // Si se pudo borrar imprime en la pantalla "Artículo borrado".
    } else {
      System.out.println("Error al borrar el articulo."); // Si no se pudo borrar imprimir en la pantalla "Error al
                                                          // borrar el artículo."
    } // Cirra la estructura de control "else".
  } // Cumina el método "borrarCodigo()"

  public static void main(String[] args) {
    char alternativa; // Inicializar variable
    String linea, enteredPassword = "";

    while (!enteredPassword.equals("PASSWORD")) {
      System.out.print("Inserte la contraseña: ");
      enteredPassword = keyboard.nextLine();

      if (!enteredPassword.equals("PASSWORD")) {
        System.out.println("ACCESO DENEGADO, Intente nuevamente.");
      }
    }
    System.out.println("ACCESO PERMITIDO.");

    do {
      // Imprimir Menu
      System.out.println();
      System.out.println("------------------");
      System.out.println("     M E N U      ");
      System.out.println("------------------");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("a. Buscar Articulo");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("b. Crear Articulo");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("c. Editar Articulo");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("d. Borrar Articulo");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("x. Salir del Sistema");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("---------------------------------------------------------");

      System.out.print("Escoja una opcion: ");

      linea = keyboard.nextLine().toLowerCase(); // Guardar lo que el usuario entro en variable linea. Luego usar
      // metodo para converirla en minuscula.
      // Buscar el primer caracter de la variable y asignarlo a la variable
      // alternativa.
      alternativa = linea.charAt(0);

      switch (alternativa) { // Evaluar multiples casos.
        case 'a':
          System.out.println("Codigo del articulo: "); // Hacer output al usuario.
          String codigoArticulo = keyboard.nextLine(); // Guardar lo que el usuario entro en variable
          // codigoArticulo.
          buscarArticulo(codigoArticulo);
          break;
        case 'b':
          crearArticulo();
          break;
        case 'c':
          editarCodigo();
          break;
        case 'd':
          borrarCodigo();
          break;
        case 'x':
          System.out.println("Gracias por utilizar el sistema.");
          break;
        default:
          System.out.println("Escoja una seleccion valida.");
          break;
      }
    } while (alternativa != 'x'); // Repetir mientras alternativa no sea x.
  }
}
