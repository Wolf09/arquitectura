/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
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
public class eDi extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
    public eDi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        nom.addItem("Diplomado");
        grado.addItem("Dr.");
        grado.addItem("Dra.");
        grado.addItem("Msc. Ing.");
        grado.addItem("Ing.");
        grado.addItem("Msc. Arq.");
        grado.addItem("Arq.");
        grado.addItem("Msc. Lic.");
        grado.addItem("Lic.");
        this.setTitle("DIPLOMADO");
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

    public String getgestion(){
    return gestion.getText();
    }
    public String getcodDoc(){
    return codDoc.getText();
    }
    public String getmat(){
    return mat.getText();
    }
    public String getuT(){
    return uT.getText();
    }
    public String getact(){
    return act.getText();
    }
    public String getnom(){
    return nom.getSelectedItem().toString();
    }
    public void llenardatos(String aux1, String aux2, String aux3, String aux4, String aux5, String aux6, String aux7, String aux8, String aux9, String aux10, String aux11, String aux12,String aux13,String aux14){
    gestion.setText(aux1);
    codDoc.setText(aux2);
    grado.setSelectedItem(aux3);
    aD.setText(aux4);
    nD.setText(aux5);
    telf.setText(aux6);
    email.setText(aux7);
    mat.setText(aux8);
    uT.setText(aux9);
    act.setText(aux10);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux11));
    } catch (ParseException ex) {
        Logger.getLogger(mDi.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux12));
    } catch (ParseException ex) {
        Logger.getLogger(mDi.class.getName()).log(Level.SEVERE, null, ex);
    }
    cum.setText(aux13);
    nom.setSelectedItem(aux14);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codDoc = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        aD = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        nD = new javax.swing.JTextField();
        telf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        uT = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cum = new javax.swing.JTextField();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nom = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "ELIMINAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código Docente:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 62, -1, -1));

        codDoc.setEditable(false);
        codDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codDocKeyTyped(evt);
            }
        });
        jPanel1.add(codDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 59, 430, -1));

        jLabel18.setText("Grado de Instrucción del Docente:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 88, -1, -1));

        grado.setEnabled(false);
        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 85, 430, -1));

        jLabel19.setText("Apellidos (Docente):");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 122, -1, -1));

        aD.setEditable(false);
        aD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aDKeyTyped(evt);
            }
        });
        jPanel1.add(aD, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 116, 430, -1));

        jLabel20.setText("Nombres (Docente):");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 153, -1, -1));

        nD.setEditable(false);
        nD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nDKeyTyped(evt);
            }
        });
        jPanel1.add(nD, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 147, 430, -1));

        telf.setEditable(false);
        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jPanel1.add(telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 178, 430, -1));

        jLabel4.setText("teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 181, -1, -1));

        jLabel2.setText("email:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 212, -1, -1));

        email.setEditable(false);
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 209, 430, -1));

        jLabel8.setText("Unidad Temática:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 301, -1, -1));

        jLabel6.setText("Materia o Modulo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 240, -1, -1));

        mat.setEditable(false);
        mat.setColumns(20);
        mat.setLineWrap(true);
        mat.setRows(5);
        mat.setWrapStyleWord(true);
        mat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                matKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                matKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(mat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 240, 430, 49));

        uT.setEditable(false);
        uT.setColumns(20);
        uT.setLineWrap(true);
        uT.setRows(5);
        uT.setWrapStyleWord(true);
        uT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uTKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(uT);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 301, 430, 47));

        jLabel10.setText("Actividad:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 359, -1, -1));

        jLabel13.setText("% de Cumplimiento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 490, -1, -1));

        cum.setEditable(false);
        cum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumKeyTyped(evt);
            }
        });
        jPanel1.add(cum, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 105, -1));

        fecF.setEnabled(false);
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 150, -1));

        jLabel12.setText("Fecha de Fin:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 454, -1, -1));

        fecI.setEnabled(false);
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 150, -1));

        jLabel11.setText("Fecha de Inicio:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        jLabel14.setText("nominación:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 521, -1, -1));

        nom.setEnabled(false);
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 150, -1));

        act.setEditable(false);
        act.setColumns(20);
        act.setLineWrap(true);
        act.setRows(5);
        act.setWrapStyleWord(true);
        act.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                actKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                actKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(act);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 359, 430, 53));

        jButton3.setBackground(new java.awt.Color(0, 72, 225));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CANCELAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 549, 109, -1));

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 549, 104, -1));

        jLabel3.setText("Gestión:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 31, -1, -1));

        gestion.setEditable(false);
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 28, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codDocKeyTyped
        if(codDoc.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codDocKeyTyped

    private void aDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aDKeyTyped
        if(aD.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aDKeyTyped

    private void nDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nDKeyTyped
        if(nD.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nDKeyTyped

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        if(telf.getText().length()==51){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_telfKeyTyped

    private void cumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cumKeyTyped
        char tecla= evt.getKeyChar();
        if(Character.isLetter(tecla)|| tecla== KeyEvent.VK_SPACE){
            evt.consume();
            getToolkit().beep();
        }
        if(cum.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cumKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
         if(email.getText().length()==51){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_emailKeyTyped

    private void matKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyTyped
         if(mat.getText().length()==61){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_matKeyTyped

    private void uTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uTKeyTyped
         if(uT.getText().length()==61){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_uTKeyTyped

    private void actKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyTyped
         if(act.getText().length()==61){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyTyped

    private void matKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_matKeyPressed

    private void uTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uTKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_uTKeyPressed

    private void actKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        PreparedStatement pst = cn.prepareStatement ("DELETE FROM diplomado WHERE gestion='"+gestion.getText()+"' AND codDoc='"+codDoc.getText()+"' AND materia='"+mat.getText()+"' AND unidadtematica='"+uT.getText()+"' AND actividad='"+act.getText()+"' AND nominacion='"+nom.getSelectedItem().toString()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aD;
    private javax.swing.JTextArea act;
    private javax.swing.JTextField codDoc;
    private javax.swing.JTextField cum;
    private javax.swing.JTextField email;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea mat;
    private javax.swing.JTextField nD;
    private javax.swing.JComboBox nom;
    private javax.swing.JTextField telf;
    private javax.swing.JTextArea uT;
    // End of variables declaration//GEN-END:variables
Conexion2 cc= new Conexion2();
Connection cn= cc.conexion();
}
