/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
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
public class mI extends javax.swing.JDialog {
private Bien icono2;
private Advertencia icono;
    public mI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gest);
        SpellChecker.register(codPro);
        SpellChecker.register(pro);
        SpellChecker.register(eje);
        SpellChecker.register(linea);
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
        codPro1.setVisible(false);
        gest1.setVisible(false);
    }
    public String getgest(){
    return gest.getText();
    }
    public String getcodPro(){
    return codPro.getText();
    }
    public void llenardatos(String aux1,String aux2,String aux3,String aux4,String aux5){
    gest.setText(aux1);
    codPro.setText(aux2);
    pro.setText(aux3);   
    eje.setText(aux4);
    linea.setText(aux5);
    codPro1.setText(aux2);
    gest1.setText(aux1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codPro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        gest = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pro = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eje = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        linea = new javax.swing.JTextArea();
        codPro1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        gest1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "MODIFICAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Código del Proyecto:");

        codPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codProKeyTyped(evt);
            }
        });

        jLabel2.setText("Proyecto:");

        gest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestKeyTyped(evt);
            }
        });

        jLabel3.setText("Gestión:");

        pro.setColumns(20);
        pro.setLineWrap(true);
        pro.setRows(5);
        pro.setWrapStyleWord(true);
        pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                proKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                proKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(pro);

        jLabel5.setText("Línea:");

        jLabel4.setText("Eje:");

        eje.setColumns(20);
        eje.setLineWrap(true);
        eje.setRows(5);
        eje.setWrapStyleWord(true);
        eje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ejeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ejeKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(eje);

        linea.setColumns(20);
        linea.setLineWrap(true);
        linea.setRows(5);
        linea.setWrapStyleWord(true);
        linea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lineaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lineaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(linea);

        jButton3.setBackground(new java.awt.Color(0, 72, 225));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("MODIFICAR");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codPro)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)))
                    .addComponent(codPro1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addComponent(gest, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gest1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(gest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(codPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gest1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(27, 27, 27))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void codProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codProKeyTyped
        if(codPro.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codProKeyTyped

    private void gestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestKeyTyped
        if(gest.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestKeyTyped

    private void proKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyPressed
       char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyPressed

    private void ejeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ejeKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_ejeKeyPressed

    private void lineaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lineaKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_lineaKeyPressed

    private void proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyTyped
        if(pro.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyTyped

    private void ejeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ejeKeyTyped
        if(eje.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_ejeKeyTyped

    private void lineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lineaKeyTyped
        if(linea.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_lineaKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sep = System.getProperty("line.separator");
        if(!(codPro.getText().equals(""))&&!(gest.getText().equals(""))){
            try {
                PreparedStatement pst = cn.prepareStatement ("UPDATE institucional SET gestion='"+gest.getText()+"',codigoP='"+codPro.getText()+"',proyecto='"+pro.getText()+"', eje='"+eje.getText()+"', linea='"+linea.getText()+"' WHERE gestion='"+gest1.getText()+"' AND codigoP='"+codPro1.getText()+"'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Proyecto, gestión duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
            }
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Proyecto, gestión NO PUEDE ESTAR VACIO NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codPro;
    private javax.swing.JLabel codPro1;
    private javax.swing.JTextArea eje;
    private javax.swing.JTextField gest;
    private javax.swing.JLabel gest1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea linea;
    private javax.swing.JTextArea pro;
    // End of variables declaration//GEN-END:variables
Conexion4 cc= new Conexion4();
Connection cn= cc.conexion();
}
