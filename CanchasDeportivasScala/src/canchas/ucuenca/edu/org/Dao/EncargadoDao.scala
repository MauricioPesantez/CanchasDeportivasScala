/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Encargado
import scala.collection.mutable.ListMap
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object EncargadoDao {
  
  private var encargados = new ListMap[String, Encargado]();
  
  
  def addEncargado(encargado:Encargado){
    if (!this.encargados.contains(encargado.cedula)){
      this.encargados += (encargado.cedula->encargado)
    }
    
    else{
      throw new IllegalArgumentException("El encargado ya existe!")
    }
  }
  
  
  def getEncargado(cedula:String):Encargado={
    
    if(this.encargados.contains(cedula)){
      return (encargados(cedula))
    }
    else{
      throw new IllegalArgumentException("El Encargado no existe!")
    }
  }
  
  def refreshEncargado(encargado:Encargado){
    this.encargados+=(encargado.cedula->encargado)
  }
  
  def removeEncargado(cedula:String){
    if(this.encargados.contains(cedula)){
      this.encargados-=(cedula)
    }
  }
  
  def listEncargados():String={
   var listar:String=""
    
    for(x<-encargados.keys){
      listar+= (encargados(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
  
  /**
   * @archvo
   */
  def guardarArchivo(){
    print("Archivo guardado!!")
    var fichero = new File("ListaEncargados.dat");
    var flujoSalida = new FileOutputStream(fichero);
    var dataos = new ObjectOutputStream(flujoSalida);
    
    dataos.writeObject(encargados);
    dataos.close
    
  }
  
  def cargarArchivo(){
    
    var fichero = new File("ListaEncargados.dat");
    var flujoEntrada = new FileInputStream(fichero);
    try{
      var datain = new ObjectInputStream(flujoEntrada);
      println("Leyendo encargados...");
      
      val listaArbi = datain.readObject().asInstanceOf[ListMap[String, Encargado]]
      
      if(listaArbi.size>0){     
        for ((k,v) <- listaArbi) {
          printf("key: %s, value: %s\n", k, v)
          this.addEncargado(v);
        }
      }
      
    }catch{
      case ex: IOException => {
          println("Problema al cargar archivo - archivo vacío")
        }
    }finally{
      flujoEntrada.close();
      println("Encargados Leidos Correctamente!");
    } 
    
  }
}
