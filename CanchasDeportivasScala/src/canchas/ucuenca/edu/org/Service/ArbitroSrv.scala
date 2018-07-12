/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Service

import canchas.ucuenca.edu.org.Dao.ArbitroDao
import canchas.ucuenca.edu.org.Model.Arbitro
import java.lang.Integer
import java.lang.Double


class ArbitroSrv extends Serializable{
  
  def crearArbitro(cedula:String, nombre:String, apellido:String, edad:Integer, precio:Double){
    validarDatos(cedula, nombre, apellido, edad, precio);
    var arbitro = new Arbitro(cedula, nombre, apellido, edad, precio)
    ArbitroDao.addArbitro(arbitro)
  }
  
  def obtenerArbitro(cedula:String):Arbitro={
    return ArbitroDao.getArbitro(cedula)
  }
  
  def eliminarArbitro(cedula:String){
    ArbitroDao.removeArbitro(cedula)
  }
  
  def listar():String={
    return ArbitroDao.listArbitros()
  }
  
  def guardar(){
    ArbitroDao.guardarArchivo()
  }
  
  def cargar(){
    ArbitroDao.cargarArchivo()
  }
  
  private def validarDatos(cedula:String, nombre:String, apellido:String, edad:Int, precio:Double){
    if(cedula.length<9 || cedula==null || nombre==null || apellido==null ||
       cedula.trim()==0 ||nombre.trim()==0 ||apellido.trim()==0 ||
        edad<18 ||precio<1){
      throw new IllegalArgumentException("Error, ingrese los datos nuevamente!!")
    }
  }

}
