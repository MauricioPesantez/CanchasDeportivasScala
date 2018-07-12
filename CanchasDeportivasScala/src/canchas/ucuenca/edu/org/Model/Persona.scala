/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Model
import java.lang.Integer;
class Persona (cedulaP:String, nombreP:String, apellidoP:String, edadP:Integer) extends Serializable{

  var cedula=cedulaP;
  var nombre = nombreP;
  var apellido = apellidoP;
  var edad = edadP;
  
  def mostrarInfo(): String ={
    return(this.cedula+","+this.nombre + ","+this.apellido+","+this.edad)
  }
  
}
