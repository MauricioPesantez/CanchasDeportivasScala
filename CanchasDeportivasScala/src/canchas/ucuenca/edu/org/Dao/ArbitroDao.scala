/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

import canchas.ucuenca.edu.org.Model.Arbitro
import scala.collection.mutable.ListMap

object ArbitroDao {
  
  private var arbitros = new ListMap[String,Arbitro]();
  
  /*
   * @param arbitro
   * Se agrega un arbitro a la lista de arbitros
   */
  def addArbitro(arbitro:Arbitro){
    if(!this.arbitros.contains(arbitro.cedula)){
      this.arbitros+=(arbitro.cedula->arbitro)
    }
    else{
      throw new IllegalArgumentException("El arbitro ya existe!");
    }
  }
  
  /*
   * @param cedulaArbitro
   * @return arbitro
   * mediante una cedula se retorna el arbitro en el caso de encontrar!
   */
  def getArbitro(cedula:String):Arbitro={
    
    if(this.arbitros.contains(cedula)){
      return arbitros(cedula)
    }
    else{
      throw new IllegalArgumentException("El arbitro no existe!")
    }
  }
  
  /**
   * @param cedulaArbitro
   * elimina un arbitro de la lista de arbitros
   */
  def removeArbitro(cedula:String){
    if(this.arbitros.contains(cedula)){
      this.arbitros-=(cedula)
    }
  }
  
  /**
   * @return regresa una lista de arbitros
   */
  def listArbitros():String={
   var listar:String=""
    
    for(x<-arbitros.keys){
      listar+= (arbitros(x).mostrarInfo() +"_")
    }
    
    return listar
  }
  
  def guardarArchivo(){
    print("Archivo guardado!!")
    var fichero = new File("ListaArbitros.dat");
    var flujoSalida = new FileOutputStream(fichero);
    var dataos = new ObjectOutputStream(flujoSalida);
    
    dataos.writeObject(arbitros);
    dataos.close
    
  }
  
  def cargarArchivo(){
    
    var fichero = new File("ListaArbitros.dat");
    var flujoEntrada = new FileInputStream(fichero);
    try{
      var datain = new ObjectInputStream(flujoEntrada);
      println("Leyendo arbitros...");
      
      val listaArbi = datain.readObject().asInstanceOf[ListMap[String, Arbitro]]
      
      if(listaArbi.size>0){     
        for ((k,v) <- listaArbi) {
          printf("key: %s, value: %s\n", k, v)
          this.addArbitro(v);
        }
      }
      
    }catch{
      case ex: IOException => {
          println("Problema al cargar archivo - archivo vacío")
        }
    }finally{
      flujoEntrada.close();
      println("Arbitros Leidos Correctamente!");
    } 
    
  }
  
}
