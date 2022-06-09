/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import administracion.LActividades;
import arqui1.BaseGrado;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import text.Control;
import ziconos.Advertencia;
/**
 *
 * @author root
 */
public class Tipo2 extends javax.swing.JDialog {
private Advertencia icono;
    public Tipo2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        menu.addItem("Personal de Administración");
        menu.addItem("Unidad de Proyectos");
        menu.addItem("Interaccion Social y Convenios");
        menu.addItem("Instituto de Investigaciones");
        menu.addItem("Posgrado");
        menu.addItem("Pregrado");
        
        jPanel2.setBackground(Color.black);
        icono = new Advertencia();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener ( new WindowAdapter() { 
        public void windowClosing(WindowEvent e) { 
        new Control().cerrarApp();
        } 
        }); 
             try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JComboBox();
        botI = new javax.swing.JButton();
        botS = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BIENVENIDO(A):");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Por Favor Seleccione");

        menu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                menuKeyTyped(evt);
            }
        });

        botI.setText("Ingresar");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
            }
        });

        botS.setText("Salir");
        botS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("donde desea Acceder:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(botI, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botS, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botI)
                    .addComponent(botS))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        if((menu.getSelectedItem().toString()).equals("")){
        JOptionPane.showMessageDialog(this, "No selecciono una Base de Datos seleccione porfavor","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            if((menu.getSelectedItem().toString()).equals("Pregrado")){
            this.setVisible(false);
            BaseGrado b= new BaseGrado();
            b.mostrardatos9("2017");
            }
            if((menu.getSelectedItem().toString()).equals("Posgrado")){
            this.setVisible(false);
            posgrado.LInstitucional i= new posgrado.LInstitucional();
            i.mostrardatos9("2017");
            }
            if((menu.getSelectedItem().toString()).equals("Instituto de Investigaciones")){
            this.setVisible(false);
            investigacion.LInstitucional i= new investigacion.LInstitucional();
            i.mostrardatos9("2017");
            }
            if((menu.getSelectedItem().toString()).equals("Interaccion Social y Convenios")){
                this.setVisible(false);
                interaccion.LInstitucional i= new interaccion.LInstitucional();
                i.mostrardatos9("2017");
            }
            if((menu.getSelectedItem().toString()).equals("Unidad de Proyectos")){
            this.setVisible(false);
            proyectos.LInstitucional i= new proyectos.LInstitucional();
            i.mostrardatos9("2017");
            }
            if((menu.getSelectedItem().toString()).equals("Personal de Administración")){
            this.setVisible(false);
            LActividades i= new LActividades();
            i.mostrardatos9("2017");
            }
        }
    }//GEN-LAST:event_botIActionPerformed

    private void botSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_botSActionPerformed

    private void menuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuKeyTyped

    }//GEN-LAST:event_menuKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botI;
    private javax.swing.JButton botS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox menu;
    // End of variables declaration//GEN-END:variables
}
