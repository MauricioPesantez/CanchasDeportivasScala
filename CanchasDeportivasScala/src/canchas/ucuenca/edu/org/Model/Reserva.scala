/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Model

class Reserva (codigoP:String,fechaP:String, horaInicioP:String, horaFinP:String, clienteP:Cliente, canchaP:Cancha) extends Serializable{

  var codigo=codigoP;
  var fecha = fechaP;
  var horaInicio = horaInicioP;
  var horaFin = horaFinP;
  var cliente = clienteP;
  var cancha = canchaP
  
  def descuentoClienteFrecuente():Double={
    if(this.cliente.reservas>1){
      
      return (100/this.cliente.reservas)
    }
    else{
      return (0)
    }
  }
  
  def mostrarInfo():String={
    return (this.codigo+","+this.fecha+","+this.horaInicio+","+this.horaFin+","+
            this.cliente.cedula+"," + this.cliente.nombre + ","+ this.cancha.codigo
            )
  }
  
}
