/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Equipo
import scala.collection.mutable.ListMap

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object EquipoDao {

  private var equipos = new ListMap[String,Equipo]();
  
  /*
   * @param equipo
   * Se agrega un equipo a la lista de equipo
   */
  def addEquipo(equipo:Equipo){
    if(!this.equipos.contains(equipo.codigo)){
      this.equipos+=(equipo.codigo->equipo)
    }
    else{
      throw new IllegalArgumentException("El equipo ya existe!");
    }
  }
  
  def refreshEquipo(equipo:Equipo){
    this.equipos+=(equipo.codigo->equipo)
  }
  
  /*
   * @param codigoequipo
   * @return equipo
   * mediante un codigo  se retorna el equipo en el caso de encontrar!
   */
  def getEquipo(codigo:String):Equipo={
    
    if(this.equipos.contains(codigo)){
      return equipos(codigo)
    }
    else{
      throw new IllegalArgumentException("El equipo no existe!")
    }
  }
  
  /**
   * @param cdigoEquipo
   * elimina un arbitro de la lista de arbitros
   */
  def removeEquipo(codigo:String){
    if(this.equipos.contains(codigo)){
      this.equipos-=(codigo)
    }
  }
  
  /**
   * @return regresa una lista de equipos
   */
  def listEquipos():String={
   var listar:String=""
    
    for(x<-equipos.keys){
      listar+= (equipos(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
  
  /**
   * @archvo
   */
  def guardarArchivo(){
    print("Archivo guardado!!")
    var fichero = new File("ListaEquipos.dat");
    var flujoSalida = new FileOutputStream(fichero);
    var dataos = new ObjectOutputStream(flujoSalida);
    
    dataos.writeObject(equipos);
    dataos.close
    
  }
  
  def cargarArchivo(){
    
    var fichero = new File("ListaEquipos.dat");
    var flujoEntrada = new FileInputStream(fichero);
    try{
      var datain = new ObjectInputStream(flujoEntrada);
      println("Leyendo canchas...");
      
      val listaNew = datain.readObject().asInstanceOf[ListMap[String, Equipo]]
      
      if(listaNew.size>0){     
        for ((k,v) <- listaNew) {
          printf("key: %s, value: %s\n", k, v)
          this.addEquipo(v)
        }
      }
      
    }catch{
      case ex: IOException => {
          println("Problema al cargar archivo - archivo vacío")
        }
    }finally{
      flujoEntrada.close();
      println("Equipos Leidos Correctamente!");
    } 
    
  }
  
}
