/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investigacion;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class eI extends javax.swing.JDialog {
private Bien icono2;
private Advertencia icono;
    public eI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("INSTITUCIONAL");
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
    public String getcodAT(){
    return codAT.getText();
    }
    public void llenardatos(String aux1,String aux2,String aux3){
    gestion.setText(aux1);
    codAT.setText(aux2);
    areaT.setText(aux3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        codAT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaT = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "ELIMINAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel3.setText("Área Temática:");

        gestion.setEditable(false);
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });

        jLabel2.setText("gestión:");

        codAT.setEditable(false);
        codAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codATKeyTyped(evt);
            }
        });

        jLabel1.setText("Código de Área Temática:");

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 72, 225));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        areaT.setEditable(false);
        areaT.setColumns(20);
        areaT.setLineWrap(true);
        areaT.setRows(5);
        areaT.setWrapStyleWord(true);
        areaT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areaTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaTKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(areaT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(131, 360, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(codAT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gestion, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                        .addGap(127, 127, 127))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(91, 91, 91))
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

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==9){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void codATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codATKeyTyped
        if(codAT.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codATKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         try {
            PreparedStatement pst = cn.prepareStatement ("DELETE FROM institucional WHERE gestion='"+gestion.getText()+"' AND codigoAT='"+codAT.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
            }
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void areaTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_areaTKeyPressed

    private void areaTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTKeyTyped
        if(areaT.getText().length()==89){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_areaTKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaT;
    private javax.swing.JTextField codAT;
    private javax.swing.JTextField gestion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
Conexion3 cc= new Conexion3();
Connection cn= cc.conexion();
}
