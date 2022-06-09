/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class eC extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
    public eC(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("CARRERA");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2=new Bien();
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }

    public void llenardatos(String cc, String nc,String g){
        codC.setText(cc);
        nomC.setText(nc);
        gestion.setText(g);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customPanel1 = new text.CustomPanel();
        jLabel9 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        botEli = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        nomC = new javax.swing.JTextField();
        codC = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ELIMINAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Gestión:");

        gestion.setEditable(false);
        gestion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });

        botEli.setBackground(new java.awt.Color(0, 0, 0));
        botEli.setForeground(new java.awt.Color(255, 255, 255));
        botEli.setText("Eliminar");
        botEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEliActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Nombre de Carrera:");

        nomC.setEditable(false);
        nomC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        codC.setEditable(false);
        codC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Código de Carrera:");

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(botEli, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codC)
                            .addComponent(nomC)
                            .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botEli)
                    .addComponent(jButton3))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void botEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEliActionPerformed
        try {
            PreparedStatement pst2 = cn.prepareStatement ("DELETE FROM carrera WHERE codigoCarrera='"+codC.getText().toString()+"' AND gestion='"+gestion.getText()+"'");
            pst2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }

        this.setVisible(false);
    }//GEN-LAST:event_botEliActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botEli;
    private javax.swing.JTextField codC;
    private text.CustomPanel customPanel1;
    private javax.swing.JTextField gestion;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nomC;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
Connection cn= cc.conexion();
}
