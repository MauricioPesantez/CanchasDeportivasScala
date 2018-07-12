/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Model

class Cliente (cedulaP:String, nombreP:String, apellidoP:String, edadP:Int) extends
      Persona (cedulaP:String, nombreP:String, apellidoP:String, edadP:Int){
      
  var reservas = 0;
  
  def nuevaReserva(){
    this.reservas = this.reservas +1
  }
}
