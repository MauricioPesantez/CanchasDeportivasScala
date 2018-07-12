/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Service

import canchas.ucuenca.edu.org.Dao.PartidoDao
import canchas.ucuenca.edu.org.Model.Equipo
import canchas.ucuenca.edu.org.Model.Partido

class PartidoSrv {

  def crearPartido(codigoP:String,equipo1P:Equipo, equipo2P:Equipo, fechaP:String, 
                   horaP:String){
    
    var partido = new Partido(codigoP, equipo1P, equipo2P, fechaP, horaP)
    PartidoDao.addPartido(partido)
    
  }
  
  def modificarPartido(codigoP:String,equipo1P:Equipo, equipo2P:Equipo, fechaP:String, 
                   horaP:String){
    var partido = new Partido(codigoP, equipo1P, equipo2P, fechaP, horaP)
    PartidoDao.refreshPartido(partido)
  }
  
  def obtenerPartido(codigo:String):Partido={
    return PartidoDao.getPartido(codigo)
  }
  
  def eliminarPartido(codigo:String){
    PartidoDao.removePartido(codigo)
  }
  
  def listar():String={
    return PartidoDao.listPartidos()
  }
  
  def guardar(){
    PartidoDao.guardarArchivo()
  }
  
  def cargar(){
    PartidoDao.cargarArchivo()
  }
  
  
}
