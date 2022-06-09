/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import Interfaz.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import text.Control;
import ziconos.Error;
/**
 *
 * @author Wjhonatan
 */
public class Usuario extends javax.swing.JFrame {
private Error icono;
private static String user="";
    public Usuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(220,0,0));
        icono = new Error();
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
         this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
    public Usuario(String u){}

    public String getUser(){
    return user;
    }
    public void acceder(String usuario, String pass)
    {
        String cap="";
        String cap1="";
        String cap2="";
       String sql="SELECT nombreUsuario,contrasena,tipo FROM user WHERE nombreUsuario='"+usuario+"' AND contrasena='"+pass+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while(rs.next())
               {
                cap=rs.getString("nombreUsuario");
                cap1 =rs.getString("contrasena");
                cap2 =rs.getString("tipo");
               }
            rs.beforeFirst();                   
             if(rs.next()){
               
                if(cap2.equals("ADMINISTRADOR")){
                    user=usuario;
                    this.setVisible(false);
                    Administrador a=new Administrador(new java.awt.Frame(), false);
                    
                }
                 if(cap2.equals("tipo1")){
                     user=usuario;
                    this.setVisible(false);
                    Tipo1 a=new Tipo1(new java.awt.Frame(), true);
                    
                }
                  if(cap2.equals("tipo2")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo2 a=new Tipo2(new java.awt.Frame(), true);
                    
                }
                   if(cap2.equals("tipo3")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo3 a=new Tipo3(new java.awt.Frame(), true);
                    
                }
                   if(cap2.equals("tipo4")){
                     user=usuario;
                    this.setVisible(false);
                    Tipo4 a=new Tipo4(new java.awt.Frame(), true);
                    
                }
                  if(cap2.equals("tipo5")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo5 a=new Tipo5(new java.awt.Frame(), true);
                    
                }
                   if(cap2.equals("tipo6")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo6 a=new Tipo6(new java.awt.Frame(), true);
                    
                }
                   if(cap2.equals("tipo7")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo7 a=new Tipo7(new java.awt.Frame(), true);
                    
                }
                  if(cap2.equals("tipo8")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo8 a=new Tipo8(new java.awt.Frame(), true);
                    
                }
                   if(cap2.equals("tipo9")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo9 a=new Tipo9(new java.awt.Frame(), true);
                    
                }
                
                if(cap2.equals("tipo10")){
                    user=usuario;
                    this.setVisible(false);
                    Tipo10 a=new Tipo10(new java.awt.Frame(), true);
                    
                }
            }
             else{
                           JOptionPane.showMessageDialog(this, "Nombre de Usuario O Contraseña Incorrectos","",JOptionPane.WARNING_MESSAGE,icono);  
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtcontra = new javax.swing.JPasswordField();
        btnaceptar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese su nombre de usuario y contraseña:");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        txtcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraActionPerformed(evt);
            }
        });
        txtcontra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraKeyTyped(evt);
            }
        });

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btnsalir.setText("Cancelar");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnaceptar)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsalir)
                                .addGap(49, 49, 49)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptar)
                    .addComponent(btnsalir))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        txtusuario.requestFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            btnaceptar.doClick();
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraActionPerformed
        txtcontra.requestFocus();
    }//GEN-LAST:event_txtcontraActionPerformed

    private void txtcontraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyTyped
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            btnaceptar.doClick();
        }
    }//GEN-LAST:event_txtcontraKeyTyped

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed

            String usu=txtusuario.getText();
            String pas=new String(txtcontra.getPassword());
            if(usu.equals("")&&pas.equals("")){
                JOptionPane.showMessageDialog(this, "No Ingreso Datos, ingrese Por favor","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                acceder(usu, pas);
            }

    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_btnsalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
ConexionUser cc = new ConexionUser();
Connection cn = cc.conexion();
}
