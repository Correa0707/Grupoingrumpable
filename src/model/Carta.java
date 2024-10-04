package model;
public class Carta{

//Atributos
private String id;
private String nombre;
private int puntosVida;
private String tipo;
private Rareza rareza;
private Ataque [] memoriaAtaques;//esto es una relacion con ataque
                //A12 
public Carta(String id, String nombre,int puntosVida, String tipo,Rareza rareza){
this.id=id;
this.nombre=nombre;
this.puntosVida=puntosVida;
this.tipo=tipo;
this.rareza=rareza;
memoriaAtaques = new Ataque[2];
}  

//Modificador
public void setId(String id){
    this.id=id;
}
//Analizador
public String getId(){
    return id;
}

public void setNombre(String nombre){
    this.nombre=nombre;
}

public String getNombre(){
    return nombre;
}
public void setpuntosVida(int puntosVida){
    this.puntosVida=puntosVida;
}

public int getpuntosVida(){
    return puntosVida;
}
public void setTipo(String tipo){
    this.tipo=tipo;
}

public String getTipo(){
    return tipo;
}
public void setRareza(Rareza rareza){
    this.rareza=rareza;
}

public Rareza getRareza(){
    return rareza;
}

public String toString(){
    return id+" - "+nombre+" - "+tipo;
}

public String mostrarInfoCartaCompleta(){

    String informacionCarta = toString();
    
     for(int i=0;i<memoriaAtaques.length;i++){

            if(memoriaAtaques[i]!=null){

            informacionCarta+="\n"+memoriaAtaques[i].toString();
            }
        }


        return informacionCarta;


}

public Ataque[] getMemoriaAtaques(){
    return memoriaAtaques;
}

public boolean addAtaque(Ataque nuevoAtaque){
       for (int i = 0; i < memoriaAtaques.length; i++) {
            if (memoriaAtaques[i] == null) {
                memoriaAtaques[i] = nuevoAtaque;
                return true;
            }
        }
        return false;
}


}