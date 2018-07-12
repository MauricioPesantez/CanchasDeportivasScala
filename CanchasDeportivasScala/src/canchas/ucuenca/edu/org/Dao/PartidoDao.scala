/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Partido
import scala.collection.mutable.ListMap

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object PartidoDao {
  
  private var partidos = new ListMap[String,Partido]();
  
  /*
   * @param partido
   * Se agrega un partido a la lista de partidos
   */
  def addPartido(partido:Partido){
    if(!this.partidos.contains(partido.codigo)){
      this.partidos+=(partido.codigo->partido)
    }
    else{
      throw new IllegalArgumentException("El partido ya existe!");
    }
  }
  
  def refreshPartido(partido:Partido){
    this.partidos+=(partido.codigo->partido)
  }
  
  /*
   * @param codigoPartido
   * @return partido
   * mediante un codigo se retorna el partidoen el caso de encontrar!
   */
  def getPartido(codigo:String):Partido={
    
    if(this.partidos.contains(codigo)){
      return partidos(codigo)
    }
    else{
      throw new IllegalArgumentException("El partido no existe!")
    }
  }
  
  /**
   * @param codigoPartido
   * elimina un partido de la lista de partidos
   */
  def removePartido(codigo:String){
    if(this.partidos.contains(codigo)){
      this.partidos-=(codigo)
    }
  }
  
  /**
   * @return regresa una lista de arbitros
   */
  def listPartidos():String={
   var listar:String=""
    
    for(x<-partidos.keys){
      listar+= (partidos(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
  /**
   * @archvo
   */
  def guardarArchivo(){
    print("Archivo guardado!!")
    var fichero = new File("ListaPartidos.dat");
    var flujoSalida = new FileOutputStream(fichero);
    var dataos = new ObjectOutputStream(flujoSalida);
    
    dataos.writeObject(partidos);
    dataos.close
    
  }
  
  def cargarArchivo(){
    
    var fichero = new File("ListaPartidos.dat");
    var flujoEntrada = new FileInputStream(fichero);
    try{
      var datain = new ObjectInputStream(flujoEntrada);
      println("Leyendo encargados...");
      
      val listaNew = datain.readObject().asInstanceOf[ListMap[String, Partido]]
      
      if(listaNew.size>0){     
        for ((k,v) <- listaNew) {
          printf("key: %s, value: %s\n", k, v)
          this.addPartido(v)
        }
      }
      
    }catch{
      case ex: IOException => {
          println("Problema al cargar archivo - archivo vacío")
        }
    }finally{
      flujoEntrada.close();
      println("Partidos Leidos Correctamente!");
    } 
    
  }
  
}
