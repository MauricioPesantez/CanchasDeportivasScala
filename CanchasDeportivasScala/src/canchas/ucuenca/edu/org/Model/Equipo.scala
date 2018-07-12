/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Model

import scala.collection.mutable.ListMap

class Equipo (codigoP:String, nombreP:String, ciudadP:String) extends Serializable{
  
  var codigo =codigoP;
  var nombre = nombreP;
  var ciudad = ciudadP;
  
  var jugadores = new ListMap[String,Jugador]();
  
  def mostrarInfo():String={
    return (this.codigo+","+this.nombre+","+this.ciudad)
  }
  
  def agregarJugador(jugador:Jugador){
    if(!this.jugadores.contains(jugador.cedula)){
      this.jugadores += (jugador.cedula->jugador)
    }
  }
  
  def listJugadores():String={
   var listar:String=""
    
    for(x<-jugadores.keys){
      listar+= (jugadores(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
}
