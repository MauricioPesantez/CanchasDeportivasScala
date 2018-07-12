/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Encargado
import scala.collection.mutable.ListMap

object ResponsableDao {

  private var encargados = new ListMap[String,Encargado]();
  
  /*
   * @param encargado
   * Se agrega un encargado a la lista de encargados
   */
  def addenEcargado(encargado:Encargado){
    if(!this.encargados.contains(encargado.cedula)){
      this.encargados+=(encargado.cedula->encargado)
    }
    else{
      throw new IllegalArgumentException("El encargado ya existe!");
    }
  }
  
  /*
   * @param cedulaEncargado
   * @return encargado
   * mediante una cedula se retorna el encargado en el caso de encontrar!
   */
  def getEncargado(cedula:String):Object={
    
    if(this.encargados.contains(cedula)){
      return encargados.get(cedula)
    }
    else{
      throw new IllegalArgumentException("El encargado no existe!")
    }
  }
  
  /**
   * @param cedulaEncargado
   * elimina un encargado de la lista de encargados
   */
  def removeEncargado(cedula:String){
    if(this.encargados.contains(cedula)){
      this.encargados-=(cedula)
    }
  }
  
  /**
   * @return regresa una lista de encargados
   */
  def listArbitros():String={
   var listar:String=""
    
    for(x<-encargados.keys){
      listar+= (encargados(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
}
