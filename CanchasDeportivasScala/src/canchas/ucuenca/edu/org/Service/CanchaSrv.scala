/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Service

import canchas.ucuenca.edu.org.Dao.CanchaDao
import canchas.ucuenca.edu.org.Model.Cancha
import canchas.ucuenca.edu.org.Model.Encargado
import java.lang.Double

class CanchaSrv {
  
  def crearCancha(codigoP:String, nombreP:String, direccionP:String, valorP:Double, encargadoP: Encargado){
    validarDatos(codigoP, nombreP, direccionP, valorP, encargadoP);
    
    var cancha = new Cancha(codigoP, nombreP, direccionP, valorP, encargadoP);
    CanchaDao.addCancha(cancha);
    
  }
  
  def modificarCancha(codigoP:String, nombreP:String, direccionP:String, valorP:Double, encargadoP: Encargado){
    validarDatos(codigoP, nombreP, direccionP, valorP, encargadoP)
    var cancha = new Cancha(codigoP, nombreP, direccionP, valorP, encargadoP);
    CanchaDao.refreshCancha(cancha);
  }
  
  def obtenerCancha(codigo:String):Cancha={
    return CanchaDao.getCancha(codigo);
  }
  
  
  def eliminarCancha(codigo:String){
    CanchaDao.removeCancha(codigo)
  }
  
  def listar():String={
    return CanchaDao.listCanchas()
  }
  
  def guardar(){
    CanchaDao.guardarArchivo()
  }
  
  def cargar(){
    CanchaDao.cargarArchivo()
  }
  
  
  /**
   * validamos los datos par crear una chancha
   */
  private def validarDatos(codigoP:String, nombreP:String, direccionP:String, valorP:Double, encargadoP: Encargado){
    
  }

}
