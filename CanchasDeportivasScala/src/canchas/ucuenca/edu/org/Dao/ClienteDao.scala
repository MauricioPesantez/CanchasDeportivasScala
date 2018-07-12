/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Cliente
import scala.collection.mutable.ListMap

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object ClienteDao {
  
  private var clientes = new ListMap[String, Cliente]();
  
  /**
   * @param cliente
   * agrega un cliente a la lista de clientes
   */
  def addCliente(cliente:Cliente){
    if(!this.clientes.contains(cliente.cedula)){
      this.clientes += (cliente.cedula->cliente)
    }
    else{
      throw new IllegalArgumentException("EL cliente ya existe!")
    }
  }
  
  /**
   * @param cedulaCLiente
   * @return Cliente
   * se retorna el cliente segun la cedula
   */
  def getCliente(cedula:String):Cliente={
    if(this.clientes.contains(cedula)){
      return clientes(cedula)
    }
    else{
      throw new IllegalArgumentException("EL cliente NO existe!")
    }
  }
  
  def removeCliente(cedula:String){
    if(this.clientes.contains(cedula)){
      this.clientes-=cedula
    }
  }
  
  def refreshCliente(cliente:Cliente){
    this.clientes +=(cliente.cedula->cliente)
  }
  
  
  def listClientes():String={
    var listar:String=""
    
    for(x<-clientes.keys){
      listar += (clientes(x).mostrarInfo()+"_")
    }
    
    return listar
  }
  
  /**
   * @archvo
   */
  def guardarArchivo(){
    print("Archivo guardado!!")
    var fichero = new File("ListaClientes.dat");
    var flujoSalida = new FileOutputStream(fichero);
    var dataos = new ObjectOutputStream(flujoSalida);
    
    dataos.writeObject(clientes);
    dataos.close
    
  }
  
  def cargarArchivo(){
    
    var fichero = new File("ListaClientes.dat");
    var flujoEntrada = new FileInputStream(fichero);
    try{
      var datain = new ObjectInputStream(flujoEntrada);
      println("Leyendo clientes...");
      
      val listaNew = datain.readObject().asInstanceOf[ListMap[String, Cliente]]
      
      if(listaNew.size>0){     
        for ((k,v) <- listaNew) {
          printf("key: %s, value: %s\n", k, v)
          this.addCliente(v);
        }
      }
      
    }catch{
      case ex: IOException => {
          println("Problema al cargar archivo - archivo vacío")
        }
    }finally{
      flujoEntrada.close();
      println("Clientes Leidos Correctamente!");
    } 
    
  }
  
  
}
