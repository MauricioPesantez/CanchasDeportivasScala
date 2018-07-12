/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Jugador
import scala.collection.mutable.ListMap


import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object JugadorDao {

  private var jugadores = new ListMap[String,Jugador]();
  
  /*
   * @param jjugador
   * Se agrega un jugdor a la lista de jugador
   */
  def addJugador(jugador:Jugador){
    if(!this.jugadores.contains(jugador.cedula)){
      this.jugadores+=(jugador.cedula->jugador)
    }
    else{
      throw new IllegalArgumentException("El Jugador ya existe!");
    }
  }
  
  /*
   * @param cedulaJugador
   * @return Jugador
   * mediante una cedula se retorna el jugador en el caso de encontrar!
   */
  def getJugador(cedula:String):Jugador={
    
    if(this.jugadores.contains(cedula)){
      return jugadores(cedula)
    }
    else{
      throw new IllegalArgumentException("El Jugador no existe!")
    }
  }
  
  def refreshJugador(jugador:Jugador){
    this.jugadores+=(jugador.cedula->jugador)
  }
  
  /**
   * @param cedulaJugador
   * elimina un jugador de la lista de jugadores
   */
  def remoceJugador(cedula:String){
    if(this.jugadores.contains(cedula)){
      this.jugadores-=(cedula)
    }
  }
  
  /**
   * @return regresa una lista de jugadores
   */
  def listJugadores():String={
   var listar:String=""
    
    for(x<-jugadores.keys){
      listar+= (jugadores(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
  
  /**
   * @archvo
   */
  def guardarArchivo(){
    print("Archivo guardado!!")
    var fichero = new File("ListaJugadores.dat");
    var flujoSalida = new FileOutputStream(fichero);
    var dataos = new ObjectOutputStream(flujoSalida);
    
    dataos.writeObject(jugadores);
    dataos.close
    
  }
  
  def cargarArchivo(){
    
    var fichero = new File("ListaJugadores.dat");
    var flujoEntrada = new FileInputStream(fichero);
    try{
      var datain = new ObjectInputStream(flujoEntrada);
      println("Leyendo encargados...");
      
      val listaArbi = datain.readObject().asInstanceOf[ListMap[String, Jugador]]
      
      if(listaArbi.size>0){     
        for ((k,v) <- listaArbi) {
          printf("key: %s, value: %s\n", k, v)
          this.addJugador(v)
        }
      }
      
    }catch{
      case ex: IOException => {
          println("Problema al cargar archivo - archivo vacío")
        }
    }finally{
      flujoEntrada.close();
      println("Jugadores Leidos Correctamente!");
    } 
    
  }
  
  
}
