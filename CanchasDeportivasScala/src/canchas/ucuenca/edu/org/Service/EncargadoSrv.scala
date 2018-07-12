/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Service
import canchas.ucuenca.edu.org.Dao.EncargadoDao
import canchas.ucuenca.edu.org.Model.Encargado
import java.lang.Integer

class EncargadoSrv extends Serializable{
  
  def crearEncargado(cedula:String, nombre:String, apellido:String, edad:Integer){
    validarDatos(cedula, nombre, apellido, edad)
    var encargado = new Encargado(cedula, nombre, apellido, edad);
    EncargadoDao.addEncargado(encargado)
  }
  
  def obtenerEncargado(cedula:String):Encargado={
    return EncargadoDao.getEncargado(cedula)
  }
  
  def modificar(cedula:String, nombre:String, apellido:String, edad:Integer){
    validarDatos(cedula, nombre, apellido, edad);
    
    var encargado = new Encargado(cedula, nombre, apellido, edad);
    EncargadoDao.refreshEncargado(encargado);
    
  }
  
  def eliminarEncargado(cedula:String){
    EncargadoDao.removeEncargado(cedula)
  }
  
  def listar():String={
    return EncargadoDao.listEncargados()
  }
  
  def guardar(){
    EncargadoDao.guardarArchivo()
  }
  
  def cargar(){
    EncargadoDao.cargarArchivo()
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
