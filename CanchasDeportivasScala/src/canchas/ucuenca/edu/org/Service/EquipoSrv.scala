/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Service

import canchas.ucuenca.edu.org.Dao.EquipoDao
import canchas.ucuenca.edu.org.Model.Equipo

class EquipoSrv {
  
  def crearEquipo(codigoP:String, nombreP:String, ciudadP:String){
    var equipo:Equipo = new Equipo(codigoP, nombreP, ciudadP)
    EquipoDao.addEquipo(equipo)
  }
  
  def modificarEquipo(codigoP:String, nombreP:String, ciudadP:String){
    var equipo:Equipo = new Equipo(codigoP, nombreP, ciudadP)
    EquipoDao.refreshEquipo(equipo)
  }
  
  def obtenerEquipo(codigo:String):Equipo={
    return EquipoDao.getEquipo(codigo)
  }
  
  def eliminarEquip(codigo:String){
    EquipoDao.removeEquipo(codigo)
  }
  
  def listar():String={
    return EquipoDao.listEquipos()
  }
  
  def guardar(){
    EquipoDao.guardarArchivo()
  }
  
  def cargar(){
    EquipoDao.cargarArchivo()
  }
  
}
