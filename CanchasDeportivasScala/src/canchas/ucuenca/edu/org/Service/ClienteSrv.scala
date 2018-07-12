/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Service

import canchas.ucuenca.edu.org.Dao.ClienteDao
import canchas.ucuenca.edu.org.Model.Cliente

class ClienteSrv extends Serializable{
  
  def crearCliente(cedula:String, nombre:String, apellido:String, edad:Integer){
    validarDatos(cedula, nombre, apellido, edad)
    var cliente = new Cliente(cedula, nombre, apellido, edad);
    ClienteDao.addCliente(cliente)
  }
  
  def obtenerCliente(cedula:String):Cliente={
    return ClienteDao.getCliente(cedula);
  }
  
  def modificar(cedula:String, nombre:String, apellido:String, edad:Integer){
    validarDatos(cedula, nombre, apellido, edad);
    
    var cliente = new Cliente(cedula, nombre, apellido, edad);
    ClienteDao.refreshCliente(cliente)
    
  }
  
  def eliminarEncargado(cedula:String){
    ClienteDao.removeCliente(cedula)
  }
  
  def listar():String={
    return ClienteDao.listClientes()
  }
  
  def guardar(){
    ClienteDao.guardarArchivo()
  }
  
  def cargar(){
    ClienteDao.cargarArchivo()
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
