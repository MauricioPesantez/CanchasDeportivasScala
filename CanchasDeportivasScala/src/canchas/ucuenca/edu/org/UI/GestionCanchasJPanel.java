/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canchas.ucuenca.edu.org.UI;

import canchas.ucuenca.edu.org.Dao.CanchaDao;
import canchas.ucuenca.edu.org.Model.Cancha;
import canchas.ucuenca.edu.org.Service.CanchaSrv;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriciop
 */
public class GestionCanchasJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GestionCanchasJPanel
     */
    DefaultTableModel modelo = new DefaultTableModel();
    public GestionCanchasJPanel() {
        initComponents();
        tablaCanchasTBL.getTableHeader().setReorderingAllowed(false);
        cargarTabla();
        
        
    }
    
    private void limpiarTabla(){
        try {
            modelo = (DefaultTableModel) tablaCanchasTBL.getModel();
            int a = modelo.getRowCount();
            
            for(int i=0;i<a;i++){
                modelo.removeRow(0);
            }
        } catch (Exception e) {
        }
        //tablaCanchasTBL.setModel(new DefaultTableModel());
    }

    private void cargarTabla(){
        
        limpiarTabla();
        try {
            modelo = (DefaultTableModel) tablaCanchasTBL.getModel();
            CanchaSrv servi = new CanchaSrv();
            
            String[] lista = servi.listar().split("_");
            String[] canchas = null;
            
            for (int i = 0; i<lista.length; i++) {
                canchas = lista[i].split(",");
                
                
                modelo.addRow(canchas);
            }
            
            tablaCanchasTBL.setModel(modelo);
            
        } catch (Exception e) {
        }
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCanchasTBL = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        salirBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("EB Garamond 12", 1, 18)); // NOI18N
        jLabel1.setText("Canchas");

        tablaCanchasTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Direccion", "Valor", "Encargado"
            }
        ));
        jScrollPane1.setViewportView(tablaCanchasTBL);

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminarBtn)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(salirBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarBtn)
                    .addComponent(eliminarBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(salirBtn)
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        // TODO add your handling code here:
        int a = tablaCanchasTBL.getSelectedRow();
        String codigo = (String) modelo.getValueAt(a, 0);
        
        try {
            Cancha cancha ;
            cancha = CanchaDao.getCancha(codigo);
            
            AgregarCanchaJPanel agregar = new AgregarCanchaJPanel();
            agregar.ponerDatos(cancha);
            agregar.modificarBoton();
            
            GestionJFrame nueva = new GestionJFrame();
            nueva.agregarVentana(agregar);
            nueva.setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            this.hide();
        }
        
        
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:
        int a = tablaCanchasTBL.getSelectedRow();
        String codigo = (String) modelo.getValueAt(a, 0);
        
        try {
            Cancha cancha ;
            cancha = CanchaDao.getCancha(codigo);
            
            AgregarCanchaJPanel agregar = new AgregarCanchaJPanel();
            agregar.ponerDatos(cancha);
            
            agregar.eliminarBoton();
            
            GestionJFrame nueva = new GestionJFrame();
            nueva.agregarVentana(agregar);
            nueva.setVisible(true);
            
        } catch (Exception e) {
        }finally{
            this.hide();
        }
        
    }//GEN-LAST:event_eliminarBtnActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JButton salirBtn;
    private javax.swing.JTable tablaCanchasTBL;
    // End of variables declaration//GEN-END:variables
}
