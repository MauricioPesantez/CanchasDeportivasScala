/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchas.ucuenca.edu.org.Dao

import canchas.ucuenca.edu.org.Model.Cancha
import scala.collection.mutable.ListMap

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object CanchaDao {
  
  private var canchas = new ListMap[String, Cancha]();
  
  /**
   * @param cancha
   * se agrega una cancha a la lista de canchas
   */
  def addCancha(cancha:Cancha){
    if(!this.canchas.contains(cancha.codigo)){
      this.canchas+=(cancha.codigo->cancha)
    }
    else{
      throw new IllegalArgumentException("La cancha ya existe!")
    }
  }
  
  /*
   * @param codigoCancha
   * @return cancha
   * mediante el codigo de una cancha se retorna la cancha en el caso de encontrar!
   */
  def getCancha(codigo:String):Cancha={
    if(this.canchas.contains(codigo)){
      return this.canchas(codigo)
    }
    else{
      throw new IllegalArgumentException("La cancha no existe!")
    }
  }
  
  def refreshCancha(cancha:Cancha){
    this.canchas+=(cancha.codigo->cancha)
  }
  
  def removeCancha(codigo:String){
    if(this.canchas.contains(codigo)){
      this.canchas-=(codigo)
    }
  }
  
  /**
   * @return lista de canchas
   */
  def listCanchas():String={
    var listar:String = ""
    
    for(x<-canchas.keys){
      listar += (canchas(x).mostrarInfor()+"_")
    }
    
    return listar
  }
  
  /**
   * @archvo
   */
  def guardarArchivo(){
    print("Archivo guardado!!")
    var fichero = new File("ListaCanchas.dat");
    var flujoSalida = new FileOutputStream(fichero);
    var dataos = new ObjectOutputStream(flujoSalida);
    
    dataos.writeObject(canchas);
    dataos.close
    
  }
  
  def cargarArchivo(){
    
    var fichero = new File("ListaCanchas.dat");
    var flujoEntrada = new FileInputStream(fichero);
    try{
      var datain = new ObjectInputStream(flujoEntrada);
      println("Leyendo canchas...");
      
      val listaArbi = datain.readObject().asInstanceOf[ListMap[String, Cancha]]
      
      if(listaArbi.size>0){     
        for ((k,v) <- listaArbi) {
          printf("key: %s, value: %s\n", k, v)
          this.addCancha(v);
        }
      }
      
    }catch{
      case ex: IOException => {
          println("Problema al cargar archivo - archivo vacío")
        }
    }finally{
      flujoEntrada.close();
      println("Canchas Leidos Correctamente!");
    } 
    
  }
  
}
