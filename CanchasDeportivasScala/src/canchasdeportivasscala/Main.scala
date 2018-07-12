/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canchasdeportivasscala

import canchas.ucuenca.edu.org.Service.ArbitroSrv
import canchas.ucuenca.edu.org.Service.CanchaSrv
import canchas.ucuenca.edu.org.Service.ClienteSrv
import canchas.ucuenca.edu.org.Service.EncargadoSrv
import canchas.ucuenca.edu.org.UI.MainWindow

object Main {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println("Hello, world. Canchas deportivas")
    
    var srvArbitros:ArbitroSrv = new ArbitroSrv();
    srvArbitros.cargar();
    
    var srvEncargados:EncargadoSrv = new EncargadoSrv();
    srvEncargados.cargar()
    
    var srvCanchas:CanchaSrv = new CanchaSrv();
    srvCanchas.cargar()
    
    var srvCliente:ClienteSrv = new ClienteSrv();
    srvCliente.cargar()
    
    var pantalla = new MainWindow();
    pantalla.setVisible(true);
    
  }

}
