/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Extra
import scala.collection.mutable.ListMap

object ExtraDao {

  private var extras = new ListMap[String,Extra]();
  
  /*
   * @param extra
   * Se agrega un extra a la lista de extras
   */
  def addExtra(extra:Extra){
    if(!this.extras.contains(extra.codigo)){
      this.extras+=(extra.codigo->extra)
    }
    else{
      throw new IllegalArgumentException("El extra ya existe!");
    }
  }
  
  /*
   * @param codigoExtra
   * @return extra
   * mediante un codigo se puede obtener un extra
   */
  def getExtra(codigo:String):Object={
    
    if(this.extras.contains(codigo)){
      return extras.get(codigo)
    }
    else{
      throw new IllegalArgumentException("El Extra no existe!")
    }
  }
  
  /**
   * @param codigoExtra
   * elimina un extra de la lista de extra
   */
  def removeExtra(codigo:String){
    if(this.extras.contains(codigo)){
      this.extras-=(codigo)
    }
  }
  
  /**
   * @return regresa una lista de extras
   */
  def listExtras():String={
   var listar:String=""
    
    for(x<-extras.keys){
      listar+= (extras(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
}
