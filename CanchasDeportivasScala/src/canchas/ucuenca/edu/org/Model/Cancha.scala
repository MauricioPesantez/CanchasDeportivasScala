/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Model
import java.lang.Double
class Cancha (codigoP:String, nombreP:String, direccionP:String, valorP:Double, encargadoP: Encargado) extends Serializable{
  
  var codigo = codigoP;
  var nombre = nombreP;
  var direccion = direccionP;
  var valor = valorP;
  var encargado = encargadoP;

  def mostrarInfor():String={
    return (this.codigo+","+this.nombre+","+this.direccion+","+this.valor+","+this.encargado.cedula)
  }
  
}
