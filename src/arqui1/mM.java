/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class mM extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
    public mM(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gestion);
        SpellChecker.register(codMat);
        SpellChecker.register(codDoc);
        SpellChecker.register(aD);
        SpellChecker.register(nD);
        SpellChecker.register(nomMat);
        SpellChecker.register(nomCarr);
        SpellChecker.register(codCarr);
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
        cM.setVisible(false);
        cD.setVisible(false);
        cC.setVisible(false);
        gestion1.setVisible(false);
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
        cM.setText(aux2);
        cD.setText(aux4);
        cC.setText(aux9);
        gestion1.setText(aux1);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        nomMat = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        nomCarr = new javax.swing.JTextArea();
        codCarr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        botMod = new javax.swing.JButton();
        cM = new javax.swing.JLabel();
        cD = new javax.swing.JLabel();
        cC = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        gestion1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 170, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "MODIFICAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código de Materia:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 52, -1, -1));

        jLabel5.setText("Código Docente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jLabel8.setText("Grado de Instrucción del Docente:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 128, -1, -1));

        jLabel9.setText("Apellidos (Docente):");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 166, -1, -1));

        codMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codMatKeyTyped(evt);
            }
        });
        jPanel1.add(codMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 350, -1));

        codDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codDocKeyTyped(evt);
            }
        });
        jPanel1.add(codDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 350, -1));

        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 350, -1));

        aD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aDKeyTyped(evt);
            }
        });
        jPanel1.add(aD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 350, -1));

        jLabel4.setText("Código Carrera :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 347, 102, 24));

        jLabel3.setText("Carrera donde ejerce Docencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 286, -1, 25));

        jLabel2.setText("Nombre de materia:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 232, -1, -1));

        jLabel10.setText("Nombres (Docente):");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 204, -1, -1));

        nD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nDKeyTyped(evt);
            }
        });
        jPanel1.add(nD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 350, -1));

        nomMat.setColumns(20);
        nomMat.setLineWrap(true);
        nomMat.setRows(5);
        nomMat.setWrapStyleWord(true);
        nomMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomMatKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomMatKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(nomMat);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 350, 48));

        nomCarr.setEditable(false);
        nomCarr.setColumns(20);
        nomCarr.setLineWrap(true);
        nomCarr.setRows(5);
        nomCarr.setWrapStyleWord(true);
        nomCarr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomCarrKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(nomCarr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 350, 50));

        codCarr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codCarrKeyTyped(evt);
            }
        });
        jPanel1.add(codCarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 350, 350, -1));

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 502, 149, -1));

        botMod.setBackground(new java.awt.Color(0, 72, 225));
        botMod.setForeground(new java.awt.Color(255, 255, 255));
        botMod.setText("Modificar");
        botMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botModActionPerformed(evt);
            }
        });
        jPanel1.add(botMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 502, 142, -1));
        jPanel1.add(cM, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 377, 624, 23));
        jPanel1.add(cD, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 411, 624, 20));
        jPanel1.add(cC, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 442, 624, 19));

        jLabel6.setText("Gestión:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        gestion.setEditable(false);
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 20, 210, -1));
        jPanel1.add(gestion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 472, 624, 24));

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
        if(codMat.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codMatKeyTyped

    private void codDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codDocKeyTyped
        if(codDoc.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codDocKeyTyped

    private void aDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aDKeyTyped
        if(aD.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aDKeyTyped

    private void nDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nDKeyTyped
        if(nD.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nDKeyTyped

    private void nomMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomMatKeyTyped
        if(nomMat.getText().length()==150){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomMatKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botModActionPerformed
        String sep = System.getProperty("line.separator");
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        boolean band= true;
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        if(!(codMat.getText().equals(""))&&!(codDoc.getText().equals(""))&&!(codCarr.getText().equals(""))&&!(gestion.getText().equals(""))){
            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE materia SET codigoMateria='"+codMat.getText()+"',gestion='"+gestion.getText()+"',nombreMateria='"+nomMat.getText()+"',codigoDocente='"+codDoc.getText()+"',grado='"+grado.getSelectedItem().toString()+"',apellidos='"+aD.getText()+"',nombres='"+nD.getText()+"',codCarrera='"+codCarr.getText()+"' WHERE codigoMateria='"+cM.getText()+"'AND gestion='"+gestion1.getText()+"' AND codigoDocente='"+cD.getText()+"' AND codCarrera='"+cC.getText()+"'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Materia, codigo de Docente, codigo carrera, gestión duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido a un campo"+sep+"O LOS CAMPOS NO COINCIDEN con una carrera valida NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                System.out.println(e.getMessage());
                band=false;
            }
            if(band==true){
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from unidadtematica where codigoMateria='"+codMat.getText()+"' AND gestion='"+gestion.getText()+"' AND codDoc='"+codDoc.getText()+"' AND codCarr='"+codCarr.getText()+"'");
                if (!(rs != null) || !(rs.next())) { 
                    try {
                    PreparedStatement pst2 = cn.prepareStatement("INSERT INTO unidadtematica(cUT,unidadTematica,fechaInicio,fechaFin,cumplido,codCarr,gestion,codigoMateria,codDoc) VALUES (?,?,?,?,?,?,?,?,?)");
                    pst2.setString(1, "");
                    pst2.setString(2, "");
                    pst2.setString(3, formato.format(fecha1));
                    pst2.setString(4, formato.format(fecha1));
                    Double aux3= 0.0;
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    pst2.setBigDecimal(5, aux4); 
                    pst2.setString(6, codCarr.getText());
                    pst2.setString(7, gestion.getText());
                    pst2.setString(8, codMat.getText());
                    pst2.setString(9, codDoc.getText());
                    pst2.executeUpdate();

                }catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                } 
            } catch (SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            }
            
            if(band==true){
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from evaluar where cM='"+codMat.getText()+"' AND gest='"+gestion.getText()+"' AND cD='"+codDoc.getText()+"' AND cC='"+codCarr.getText()+"'");
                if (!(rs != null) || !(rs.next())) { 
                            try {
                             PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluar(uno,dos,tres,cuatro,cM,gest,cD,cC) VALUES (?,?,?,?,?,?,?,?)");
                             Double aux3= 0.0;
                             BigDecimal aux4= BigDecimal.valueOf(aux3);
                             pst3.setBigDecimal(1, aux4); 
                             pst3.setBigDecimal(2, aux4);
                             pst3.setBigDecimal(3, aux4);
                             pst3.setBigDecimal(4, aux4);
                             pst3.setString(5, codMat.getText());
                             pst3.setString(6, gestion.getText());
                             pst3.setString(7, codDoc.getText());
                             pst3.setString(8, codCarr.getText());
                             pst3.executeUpdate();

                         }catch (Exception e) {
                             System.out.print(e.getMessage());
                         }
                } 
            } catch (SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            }
            this.setVisible(false);
        }
        else{
        JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Carrera codigo docente,carrera, gestión NO PUEDEN ESTAR VACIOS NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botModActionPerformed

    private void nomMatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomMatKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
         if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomMatKeyPressed

    private void nomCarrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomCarrKeyTyped
        if(nomCarr.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomCarrKeyTyped

    private void codCarrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codCarrKeyTyped
         if(codCarr.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codCarrKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aD;
    private javax.swing.JButton botMod;
    private javax.swing.JLabel cC;
    private javax.swing.JLabel cD;
    private javax.swing.JLabel cM;
    private javax.swing.JTextField codCarr;
    private javax.swing.JTextField codDoc;
    private javax.swing.JTextField codMat;
    private javax.swing.JTextField gestion;
    private javax.swing.JLabel gestion1;
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
