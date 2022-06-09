/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import java.math.BigDecimal;
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
public class eM extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
    public eM(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        grado.addItem("Dr.");
        grado.addItem("Dra.");
        grado.addItem("Msc. Ing.");
        grado.addItem("Ing.");
        grado.addItem("Msc. Arq.");
        grado.addItem("Arq.");
        grado.addItem("Msc. Lic.");
        grado.addItem("Lic.");
        this.setTitle("MATERIA");
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
    
    public String getcodMat(){
    return codMat.getText();
    }
    public String getgestion(){
    return gestion.getText();
    }
     public String getcodDoc(){
    return codDoc.getText();
    }
    public String getcodCarr(){
    return codCarr.getText();
    }
    public void llenardatos(String aux1, String aux2,String aux3,String aux4,String aux5,String aux6,String aux7,String aux8,String aux9){
        gestion.setText(aux1);
        codMat.setText(aux2);
        nomMat.setText(aux3);
        codDoc.setText(aux4);
        grado.setSelectedItem(aux5);
        aD.setText(aux6);
        nD.setText(aux7);
        nomCarr.setText(aux8);
        codCarr.setText(aux9);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        codMat = new javax.swing.JTextField();
        codDoc = new javax.swing.JTextField();
        grado = new javax.swing.JComboBox();
        aD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nD = new javax.swing.JTextField();
        botEli = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        nomMat = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        nomCarr = new javax.swing.JTextArea();
        codCarr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 170, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "ELIMINAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Código de Materia:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 64, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Código Docente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 102, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Grado de Instrucción del Docente:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Apellidos (Docente):");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 178, -1, -1));

        codMat.setEditable(false);
        codMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codMatKeyTyped(evt);
            }
        });
        jPanel1.add(codMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 61, 330, -1));

        codDoc.setEditable(false);
        codDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codDocKeyTyped(evt);
            }
        });
        jPanel1.add(codDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 99, 330, -1));

        grado.setEnabled(false);
        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 137, 330, -1));

        aD.setEditable(false);
        aD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aDKeyTyped(evt);
            }
        });
        jPanel1.add(aD, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 175, 330, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Código Carrera :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 385, -1, 24));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Carrera donde ejerce Docencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 25));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre de materia:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 239, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombres (Docente):");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 216, -1, -1));

        nD.setEditable(false);
        nD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nDKeyTyped(evt);
            }
        });
        jPanel1.add(nD, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 213, 330, -1));

        botEli.setBackground(new java.awt.Color(0, 72, 225));
        botEli.setForeground(new java.awt.Color(255, 255, 255));
        botEli.setText("Eliminar");
        botEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEliActionPerformed(evt);
            }
        });
        jPanel1.add(botEli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 132, -1));

        nomMat.setEditable(false);
        nomMat.setColumns(20);
        nomMat.setLineWrap(true);
        nomMat.setRows(5);
        nomMat.setWrapStyleWord(true);
        nomMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomMatKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(nomMat);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 239, 330, 60));

        nomCarr.setEditable(false);
        nomCarr.setColumns(20);
        nomCarr.setLineWrap(true);
        nomCarr.setRows(5);
        nomCarr.setWrapStyleWord(true);
        jScrollPane1.setViewportView(nomCarr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 310, 330, 57));

        codCarr.setEditable(false);
        jPanel1.add(codCarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 387, 330, -1));

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 130, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Gestión:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 33, -1, -1));

        gestion.setEditable(false);
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 30, 200, -1));

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

    private void codMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codMatKeyTyped
        if(codMat.getText().length()==15){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codMatKeyTyped

    private void codDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codDocKeyTyped
        if(codDoc.getText().length()==15){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codDocKeyTyped

    private void aDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aDKeyTyped
        if(aD.getText().length()==25){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aDKeyTyped

    private void nDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nDKeyTyped
        if(nD.getText().length()==25){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nDKeyTyped

    private void botEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEliActionPerformed
           try {
                PreparedStatement pst2 = cn.prepareStatement ("DELETE FROM materia WHERE codigoMateria='"+codMat.getText().toString()+"' AND gestion='"+gestion.getText()+"' AND codigoDocente='"+codDoc.getText().toString()+"' AND codCarrera='"+codCarr.getText().toString()+"'");
                pst2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
            }
        
        this.setVisible(false);

    }//GEN-LAST:event_botEliActionPerformed

    private void nomMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomMatKeyTyped
        if(nomMat.getText().length()==89){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomMatKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aD;
    private javax.swing.JButton botEli;
    private javax.swing.JTextField codCarr;
    private javax.swing.JTextField codDoc;
    private javax.swing.JTextField codMat;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nD;
    private javax.swing.JTextArea nomCarr;
    private javax.swing.JTextArea nomMat;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
 Connection cn= cc.conexion();
}
