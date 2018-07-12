/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Model

class Extra (codigoP:String, descripcionP:String, precioP:Double) extends Serializable{
  
  var codigo = codigoP;
  var descipcion = descripcionP;
  var precio = precioP;

  def mostrarInfo():String={
    return (this.codigo+","+this.descipcion+","+this.precio)
  }
  
}
