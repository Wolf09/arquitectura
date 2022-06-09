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
public class iI extends javax.swing.JDialog {
private Bien icono2;
private Advertencia icono;
    public iI(java.awt.Frame parent, boolean modal) {
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
    }

     public String getgest(){
    return gest.getText();
    }
    public String getcodPro(){
    return codPro.getText();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botIn = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "INSERTAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        botIn.setBackground(new java.awt.Color(0, 72, 225));
        botIn.setForeground(new java.awt.Color(255, 255, 255));
        botIn.setText("INSERTAR");
        botIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botInActionPerformed(evt);
            }
        });

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
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codPro)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botIn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addComponent(gest, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(gest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botIn)
                    .addComponent(jButton1))
                .addGap(55, 55, 55))
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

    private void botInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botInActionPerformed
        String sep = System.getProperty("line.separator");
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band= true;
        if(gest.getText().equals("")||codPro.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor, código de Proyecto, gestión no debe estar vacio","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            if(band==true){
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO institucional(gestion,codigoP,proyecto,eje,linea) VALUES (?,?,?,?,?)");
                pst.setString(1, gest.getText());
                pst.setString(2, codPro.getText());
                pst.setString(3, pro.getText());   
                pst.setString(4, eje.getText());
                pst.setString(5, linea.getText());   
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Proyecto, gestión duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                band= false;
            }
            }
            if(band==true){
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO resultado(primerP,segundoP,tercerP,gestion,codigoP) VALUES (?,?,?,?,?)");
                Double aux5=0.0;
                BigDecimal aux6= BigDecimal.valueOf(aux5);
                pst.setBigDecimal(1,aux6);
                pst.setBigDecimal(2,aux6);
                pst.setBigDecimal(3,aux6);
                pst.setString(4, gest.getText());
                pst.setString(5, codPro.getText());
                pst.executeUpdate();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
            if(band==true){
                try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO convenios(gestion,institucion,codP,grado,apellidos,nombres,email,telefono,fechaI,fechaF,cumplimiento,eF,codigoP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, gest.getText());
                pst.setString(2, "");
                pst.setString(3, "");
                pst.setString(4, "Dr.");
                pst.setString(5, "");
                pst.setString(6, "");
                pst.setString(7, "");
                pst.setString(8, "");
                pst.setString(9, formato.format(fecha1));
                pst.setString(10, formato.format(fecha1));
                Double aux5=0.0;
                BigDecimal aux6= BigDecimal.valueOf(aux5);
                pst.setBigDecimal(11,aux6);
                pst.setBigDecimal(12,aux6);
                pst.setString(13, codPro.getText());
                pst.executeUpdate();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
            if(band==true){
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO postulantes(gestion,codigoE,grado,apellidos,nombres,email,telefono,fechaI,fechaF,cump,pp,sp,pf,recurso,codigoP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, gest.getText());
                pst.setString(2, "");
                pst.setString(3, "Dr.");
                pst.setString(4, "");
                pst.setString(5, "");
                pst.setString(6, "");
                pst.setString(7, "");
                pst.setString(8, formato.format(fecha1));
                pst.setString(9, formato.format(fecha1));
                Double aux7=0.0;
                BigDecimal aux8= BigDecimal.valueOf(aux7);
                pst.setBigDecimal(10,aux8);
                pst.setBigDecimal(11,aux8);
                pst.setBigDecimal(12,aux8);
                pst.setBigDecimal(13,aux8);
                pst.setString(14,"");
                pst.setString(15, codPro.getText());
                pst.executeUpdate();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
            this.setVisible(false);
        }
    }//GEN-LAST:event_botInActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botIn;
    private javax.swing.JTextField codPro;
    private javax.swing.JTextArea eje;
    private javax.swing.JTextField gest;
    private javax.swing.JButton jButton1;
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
