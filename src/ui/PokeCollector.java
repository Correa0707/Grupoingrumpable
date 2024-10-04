package ui; //user interface 

import java.util.Scanner;
import model.Controller;
 
public class PokeCollector {

   
    public  Scanner reader;
    private Controller controladora;

    public static void main(String[] args) {
        PokeCollector executable = new PokeCollector();
        executable.menu();
        
    }

    public PokeCollector () {
        reader = new Scanner(System.in);
        controladora = new Controller();

    }

    public void menu() {
        System.out.println("Bienvenido a PokeCollector!");

        boolean salir = false;

        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Registrar una Carta (Create)");
            System.out.println("2. Consultar una Carta (Read)");
            System.out.println("3. Modificar una Carta (Update)");
            System.out.println("4. Eliminar una Carta (Delete)");
            System.out.println("5. Mostrar listado de cartas");
            System.out.println("6. Añadir ataque a carta");
            System.out.println("0. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatosCarta();
                    break;
                case 2:
                    consultarCarta();
                    break;
                case 3:
                    modificarCartaui();
                    break;
                case 4:
                    eliminarCartaui();
                    break;
                case 5:
                    System.out.println(controladora.construirListaDeCarta());
                    break;
                case 6:
                        solicitarDatosCarta();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpcion invalida!");
                    break;
            }

        } while (!salir);
    }

    public void solicitarDatosCarta(){
        reader.nextLine();
        String id = "";
        boolean valorDeVerdad = true;
        while (valorDeVerdad) {
            System.out.println("Digite el ID de la carta");
            id = reader.nextLine();
            valorDeVerdad = controladora.analizarID(id);
        }
        System.out.println("Digite el Nombre de la carta");
        String nombre = reader.nextLine();
        System.out.println("Digite los Puntos vida de la carta");
        int puntosVida = reader.nextInt();
        reader.nextLine();
        System.out.println("Digite el Tipo de la carta(Agua, Fuego, etc.)");
        String tipo = reader.nextLine();
        System.out.println("Digite la Rareza de la carta (Basico, Raro, Mitico, Legendario)");
        String rareza = reader.nextLine();
        reader.nextLine();

        boolean resultado = controladora.guardarCartaEnMemoria(id, nombre, puntosVida, tipo, rareza);
        if (resultado) {
            System.out.println("Carta registrada exitosamente");
        } else {
            System.out.println("No se ha podido registrar la carta");
        }
    }

  
    public void consultarCarta() {
        reader.nextLine();
        System.out.println("Ingrese el ID de la carta a consultar");
        String idAConsultar = reader.nextLine();
        String consulta = controladora.mostrarCarta(idAConsultar);
        if (consulta != null) {
            System.out.println(consulta);
        } else {
            System.out.println("No existe una carta registrada con este ID");
        }
    }

   
public void modificarCartaui() {
    boolean salida = false;
    boolean existe = controladora.verificarcarta(); 

    if (!existe) {
        System.out.println("No hay cartas registradas. Registre una carta primero.");
        
    }
if (existe){
    reader.nextLine();
    System.out.println("Digite el ID de la carta a modificar (podra modificar todas sus estadisticas menos su ID):");
    String idAModificar = reader.nextLine();

            do {
                System.out.println("Que atributo deseas modificar:");
                System.out.println("1: Nombre");
                System.out.println("2: Puntos vida");
                System.out.println("3: Tipo");
                System.out.println("4: Rareza");
                System.out.println("5: Salir");
                int opcionAmodificar = reader.nextInt();
                reader.nextLine();

                switch (opcionAmodificar) {
                    case 1:
                        System.out.println("Digita el nuevo nombre del Pokemon. El nombre actual es ");// + consulta.getNombre());
                        String nuevoNombre = reader.nextLine();
                        break;
                    case 2:
                        System.out.println("Digita los nuevos puntos de vida otorgados al Pokemon. Los actuales son "); //+ consulta.getpuntosVida());
                        int nuevosPv = reader.nextInt();
                        break;
                    case 3:
                        System.out.println("Digita el nuevo tipo del Pokemon (Agua, Fuego, etc.). El tipo actual es ");// + consulta.getTipo());
                        String nuevoTipo = reader.nextLine();
                        break;
                    case 4:
                        System.out.println("Digita la nueva rareza del Pokemon (Basico, Raro, Mitico, Legendario). La rareza actual es ");//+ consulta.getRareza());
                        String nuevaRareza = reader.nextLine();
                        break;
                    case 5:
                        System.out.println("Volveras al menu principal.");
                        salida = true;
                        break;
                    default:
                        System.out.println("Esta no es una opcion valida.");
                        break;
                }

            if (!controladora.cartaEncontrada(idAModificar)) {
        System.out.println("No se encuentra ninguna carta con ese ID (Asegurate de ingresar el ID correcto).");
        }

            } while (!salida);

    
}
    

    }
 
    public void eliminarCartaui() {
        reader.nextLine();
        System.out.println("Digite el ID de la carta a eliminar");
        String idAeliminar = reader.nextLine();
        boolean elicarta = controladora.eliminarCarta(idAeliminar);
       
            if (elicarta) {
                System.out.println("El nombre de la carta a eliminar es ");  // + no supe como mostrar el nombre de la carta);
                System.out.println("La carta ha sido eliminada");
                
            }

             if (!elicarta) {
            System.out.println("No se encuentra la carta con ese ID (Asegurate de ingresar el ID correcto o de registrar cartas primero)");
        }
        }

       
    

//iba analizar id pero se cambia por un if que responde segun lo qu retorna el metodo(cambiar tambien arriba)
public void analizarId (String id){
    boolean analizadora = controladora.analizarID(id);
    if (analizadora){
        System.out.println("Esta ID ya esta registrada");
        
    }

}

public void solicitarDatosAtaque(){

      reader.nextLine();
       System.out.println(controladora.construirListaDeCarta());
        System.out.println("Ingrese el ID de la carta a consultar");
        String idAConsultar = reader.nextLine();

        if(controladora.mostrarCarta(idAConsultar)!=null){

             System.out.println("Ingrese el ID de la carta a consultar");
         idAConsultar = reader.nextLine();

         System.out.println("Ingrese el nombre del ataque");
        String nombreAtaque = reader.nextLine();

         System.out.println("Ingrese el dano de la carta");
        int danoAtaque= reader.nextInt();

         System.out.println("Ingrese el tipo de ataque");
        String tipoAtaque = reader.nextLine();

       if(controladora.addAtaqueAcarta(idAConsultar,nombreAtaque,danoAtaque,tipoAtaque)){
       
            System.out.println("Ataque añadido a la carta exitosamente");
            System.out.println(controladora.mostrarCarta(idAConsultar));

        }else{
            System.out.println("Error, no se pudo añadir el ataque a la carta");
        }
        
       
    
    }else {
        System.out.println("Id invalido, no existe una Carta con ese id");
    }

}
}
