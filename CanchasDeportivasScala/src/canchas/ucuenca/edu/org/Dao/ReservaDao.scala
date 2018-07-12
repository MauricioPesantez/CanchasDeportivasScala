/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Reserva
import scala.collection.mutable.ListMap

object ReservaDao {

  private var reservas = new ListMap[String,Reserva]();
  
  /*
   * @param reserva
   * Se agrega una reserva a la lista de reservas
   */
  def addReserva(reserva:Reserva){
    if(!this.reservas.contains(reserva.codigo)){
      this.reservas+=(reserva.codigo->reserva)
    }
    else{
      throw new IllegalArgumentException("La reserva ya existe!");
    }
  }
  
  /*
   * @param codigoReserva
   * @return reserva
   * mediante un codigo se retorna la reserva en el caso de encontrar!
   */
  def getReserva(codigo:String):Object={
    
    if(this.reservas.contains(codigo)){
      return reservas.get(codigo)
    }
    else{
      throw new IllegalArgumentException("La reserva no existe!")
    }
  }
  
  /**
   * @param codigoReserva
   * elimina un reserva de la lista de reservas
   */
  def removeReserva(codigo:String){
    if(this.reservas.contains(codigo)){
      this.reservas-=(codigo)
    }
  }
  
  /**
   * @return regresa una lista de reservas
   */
  def listPartidos():String={
   var listar:String=""
    
    for(x<-reservas.keys){
      listar+= (reservas(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
  
}
