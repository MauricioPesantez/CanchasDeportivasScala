/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Service

import canchas.ucuenca.edu.org.Dao.JugadorDao
import canchas.ucuenca.edu.org.Model.Jugador

class JugadorSrv {
  
  def crearJugador(cedula:String, nombre:String, apellido:String, edad:Integer){
    validarDatos(cedula, nombre, apellido, edad)
    var jugador = new Jugador(cedula, nombre, apellido, edad);
    JugadorDao.addJugador(jugador)
  }
  
  def obtenerJugador(cedula:String):Jugador={
    return JugadorDao.getJugador(cedula)
  }
  
  def modificarJugador(cedula:String, nombre:String, apellido:String, edad:Integer){
    validarDatos(cedula, nombre, apellido, edad);
    
    var jugador = new Jugador(cedula, nombre, apellido, edad);
    JugadorDao.refreshJugador(jugador)
    
  }
  
  def eliminarJugador(cedula:String){
    JugadorDao.remoceJugador(cedula)
  }
  
  def listar():String={
    return JugadorDao.listJugadores();
  }
  
  def guardar(){
    JugadorDao.guardarArchivo()
  }
  
  def cargar(){
    JugadorDao.cargarArchivo()
  }
  
  
  private def validarDatos(cedula:String, nombre:String, apellido:String, edad:Integer){
    if(cedula.length<10 || cedula==null){
      throw new IllegalArgumentException("Error en la cedula!")
    }
    else if(nombre.trim()==0 ||apellido.trim()==0 ||edad<18){
      throw new IllegalArgumentException("Error en los datos ingresados!")
    }
  }
}
