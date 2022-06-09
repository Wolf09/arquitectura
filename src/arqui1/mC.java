/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class mC extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
    public mC(java.awt.Frame parent, boolean modal) {
        super(parent, true);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(nomCarr);
        SpellChecker.register(codCarr);
        SpellChecker.register(gestion);
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
        codC.setVisible(false);
        gestion1.setVisible(false);
    }
        public String getcodCarr(){
        return codCarr.getText();
        }
        public String getgestion(){
        return gestion.getText();
        }
        public void llenardatos(String cc, String nc,String g){
        codCarr.setText(cc);
        nomCarr.setText(nc);
        gestion.setText(g);
        codC.setText(cc);
        gestion1.setText(g);
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        codCarr = new javax.swing.JTextField();
        nomCarr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        botM2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        codC = new javax.swing.JLabel();
        gestion1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 170, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "MODIFICAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(60, 150, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Código de Carrera:");

        codCarr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codCarrKeyTyped(evt);
            }
        });

        nomCarr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomCarrKeyTyped(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(60, 150, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Nombre de Carrera:");

        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(60, 150, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Gestión:");

        botM2.setBackground(new java.awt.Color(0, 72, 225));
        botM2.setForeground(new java.awt.Color(255, 255, 255));
        botM2.setText("Modificar");
        botM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botM2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 72, 225));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(codC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addGap(30, 30, 30))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel9)
                                        .addGap(28, 28, 28)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(nomCarr, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                                    .addComponent(gestion)
                                    .addComponent(codCarr))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(botM2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(codCarr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nomCarr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(codC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botM2)
                    .addComponent(jButton3))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codCarrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codCarrKeyTyped
        if(codCarr.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codCarrKeyTyped

    private void nomCarrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomCarrKeyTyped
        if(nomCarr.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomCarrKeyTyped

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void botM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botM2ActionPerformed
        String sep = System.getProperty("line.separator");
        if(!(codCarr.getText().equals(""))&&!(gestion.getText().equals(""))){
            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE carrera SET codigoCarrera='"+codCarr.getText()+"',nombre='"+nomCarr.getText()+"',gestion='"+gestion.getText()+"' WHERE codigoCarrera='"+codC.getText()+"' AND gestion='"+gestion1.getText()+"'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Carrera , gestion,duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo,NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
            }
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Carrera, gestion NO PUEDE ESTAR VACIO NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botM2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botM2;
    private javax.swing.JLabel codC;
    private javax.swing.JTextField codCarr;
    private javax.swing.JTextField gestion;
    private javax.swing.JLabel gestion1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomCarr;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
Connection cn= cc.conexion();
}
