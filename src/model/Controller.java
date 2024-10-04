package model;
//al estar en el mismo paquete , puede accder a las clases que estan en el paquete sin poner import
public class Controller{
    public Carta[] memoria; 
public Controller(){
     memoria = new Carta[50];
}
  public  boolean guardarCartaEnMemoria(String id, String nombre, int puntosVida, String tipo, String rareza) {


        //BASICO, RARO, MITICO, LEGENDARIO;

        Rareza rare = Rareza.BASICO;

        switch(rareza){

            case "A":
                rare = Rareza.BASICO;
                break;
            case "B":
                rare = Rareza.RARO;
                break;
            case "C":
                rare = Rareza.MITICO;
                break;
            case "D":
                rare = Rareza.LEGENDARIO;
                break;
        }

        Carta nuevaCarta = new Carta(id, nombre, puntosVida, tipo, rare);

        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i] == null) {
                memoria[i] = nuevaCarta;
                return true;
            }
        }
        return false;
    }
    public  String construirListaDeCarta() {
        boolean cambiar = false;
        String lista = "";
        boolean validar = false;

        while (!cambiar) {
            cambiar = true;
            for (int i = 0; i < memoria.length - 1; i++) {
                if (memoria[i] != null && memoria[i + 1] != null && memoria[i].getpuntosVida() < memoria[i + 1].getpuntosVida()) {
                    int tempPuntosVida = memoria[i].getpuntosVida();
                    memoria[i].setpuntosVida(memoria[i + 1].getpuntosVida());
                    memoria[i + 1].setpuntosVida(tempPuntosVida);

                    String tempID = memoria[i].getId();
                    memoria[i].setId(memoria[i + 1].getId());
                    memoria[i + 1].setId(tempID);

                    String tempNombre = memoria[i].getNombre();
                    memoria[i].setNombre(memoria[i + 1].getNombre());
                    memoria[i + 1].setNombre(tempNombre);

                    cambiar = false;
                }
            }
        }

        for (int j = 0; j < memoria.length; j++) {
            if (memoria[j] != null) {
                lista += "\n " + memoria[j].getId() + " - " + memoria[j].getNombre() + " - " + memoria[j].getpuntosVida();
                validar = true;
            }
        }

        if (!validar) {
            lista = "No hay cartas registradas";
        }
        return lista;
    }
            public  String mostrarCarta(String idAConsultar) {
        for (int k = 0; k < memoria.length; k++) {
            if (memoria[k] != null && memoria[k].getId().equalsIgnoreCase(idAConsultar)) {
                return memoria[k].toString();
            }
        }
        return null;
    }

        public  String mostrarCartaCompleta(String idAConsultar) {
        for (int k = 0; k < memoria.length; k++) {
            if (memoria[k].getId().equalsIgnoreCase(idAConsultar)) {
                return memoria[k].mostrarInfoCartaCompleta();
            }
        }
        return null;
    }

    public  Carta buscarCarta(String idAConsultar) {
        for (int k = 0; k < memoria.length; k++) {
            if (memoria[k].getId().equalsIgnoreCase(idAConsultar)) {
                return memoria[k];
            }
        }
        return null;
    }


    public boolean addAtaqueAcarta(String idCarta, String nombreAtaque,int danoAtaque,String tipoAtaque){
            Carta cartaBuscada = buscarCarta(idCarta);
            Ataque nuevoAtaque = new Ataque(nombreAtaque,danoAtaque,tipoAtaque);

            return cartaBuscada.addAtaque(nuevoAtaque);



        
    }


        //hacemos un metodo para verificar que existe la carta 
    public boolean verificarcarta(){
          for (int i = 0; i < memoria.length; i++) {
        if (memoria[i] != null) {
            return true;
 
        }
    }

        return false;
    }

    //hacemos otro para verificar que la id a modificar si existe
    public boolean cartaEncontrada (String idAModificar){
        for (int i = 0; i < memoria.length; i++) {
        if (memoria[i] != null && memoria[i].getId().equalsIgnoreCase(idAModificar)) {
            return true;
        }
    }
        return false;
    }

    public void modificarCarta(String idAModificar, int opcionAmodificar,String nuevoNombre,int nuevosPv,String nuevoTipo,Rareza nuevaRareza) {
    for (int i = 0; i < memoria.length; i++) {
        if (memoria[i] != null && memoria[i].getId().equalsIgnoreCase(idAModificar)) {
            Carta consulta = memoria[i];

                switch (opcionAmodificar) {
                    case 1:
                        consulta.setNombre(nuevoNombre);
                        break;
                    case 2:
                        consulta.setpuntosVida(nuevosPv);
                        break;
                    case 3:
                        consulta.setTipo(nuevoTipo);
                        break;
                    case 4:
                        consulta.setRareza(nuevaRareza);
                        break;
 
                }
            
        }
    }


}
 


    public boolean eliminarCarta(String idAeliminar) {
        
        for (int e = 0; e < memoria.length; e++) {
            if (memoria[e] != null && memoria[e].getId().equalsIgnoreCase(idAeliminar)) {
                memoria[e] = null;
                return true;
                
            } 
            
        }
            return false;
        
    }



    public  boolean analizarID (String id) {
        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i] != null && memoria[i].getId().equalsIgnoreCase(id)) {
                //quite el system de aqui y se hace uno en el main con el resultado de este metodo 
                return true;
            }
        }
        return false;
    }
}


    
