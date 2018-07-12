/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Model


class Partido (codigoP:String,equipo1P:Equipo, equipo2P:Equipo, fechaP:String, horaP:String) extends Serializable{
  
  var codigo = codigoP;
  var equipo1 = equipo1P;
  var equipo2 = equipo2P;
  var fecha =fechaP;
  var hora = horaP;
  
  
  def mostrarInfo():String={
    return(this.codigo+","+this.equipo1+","+this.equipo2+","+this.fecha+","+this.hora)
  }
}
