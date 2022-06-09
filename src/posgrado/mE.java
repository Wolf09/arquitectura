/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import text.Redondear;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class mE extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public mE(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gestion);
        SpellChecker.register(codE);
        SpellChecker.register(aE);
        SpellChecker.register(nE);
        SpellChecker.register(cM);
        SpellChecker.register(mat);
        nom.addItem("Diplomado");
        nom.addItem("Maestría");
        nom.addItem("Doctorado");
        this.setTitle("ESTUDIANTE");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2=new Bien();
        contador1=1;
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        codE1.setVisible(false);
        cM1.setVisible(false);
        gestion1.setVisible(false);
        nom1.setVisible(false);
    }

    public String getgestion(){
    return gestion.getText();
    }
    public String getcodE(){
    return codE.getText();
    }
    public String getcM(){
    return cM.getText();
    }
    public String getnom(){
    return nom.getSelectedItem().toString();
    }
    public void llenardatos(String aux1,String aux2,String aux3,String aux4,String aux5,String aux6,String aux7,String aux8,String aux9,String aux10,String aux11){
        gestion.setText(aux1);
        codE.setText(aux2);
        aE.setText(aux3);
        nE.setText(aux4);
        email.setText(aux5);
        telf.setText(aux6);
        cM.setText(aux7);
        mat.setText(aux8);
        resE.setText(aux9);
        cum.setText(aux10);
        nom.setSelectedItem(aux11);
        gestion1.setText(aux1);
        codE1.setText(aux2);
        cM1.setText(aux7);
        nom1.setText(aux11);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        codE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        aE = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        nE = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        email = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        telf = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cM = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mat = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        resE = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nom = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        codE1 = new javax.swing.JLabel();
        cM1 = new javax.swing.JLabel();
        gestion1 = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "MODIFICAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(0, 72, 225));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, 113, -1));

        jButton2.setBackground(new java.awt.Color(0, 72, 225));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 610, 116, -1));

        jLabel9.setText("Gestión:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        gestion.setEditable(false);
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 19, 140, -1));
        jPanel1.add(codE, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 51, 140, -1));

        jLabel1.setText("Código del Estudiante:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        aE.setColumns(20);
        aE.setRows(5);
        aE.setMaximumSize(new java.awt.Dimension(516, 2147483647));
        aE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aEKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(aE);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 77, 460, 44));

        jLabel2.setText("Apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 77, -1, -1));

        nE.setColumns(20);
        nE.setRows(5);
        nE.setMaximumSize(new java.awt.Dimension(516, 2147483647));
        nE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nEKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(nE);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 132, 460, 46));

        jLabel10.setText("Nombres:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 132, -1, -1));

        email.setColumns(20);
        email.setRows(5);
        email.setMaximumSize(new java.awt.Dimension(516, 2147483647));
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(email);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 189, 460, 40));

        jLabel3.setText("e-mail:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 189, -1, -1));

        telf.setColumns(20);
        telf.setRows(5);
        telf.setMaximumSize(new java.awt.Dimension(516, 2147483647));
        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telfKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(telf);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 240, 460, 44));

        jLabel4.setText("teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 240, -1, -1));

        cM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cMKeyTyped(evt);
            }
        });
        jPanel1.add(cM, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 295, 140, -1));

        jLabel11.setText("Código de Materia:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 298, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 326, 460, 44));

        jLabel12.setText("Materia o Módulo:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 326, -1, -1));

        resE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resEKeyTyped(evt);
            }
        });
        jPanel1.add(resE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 105, -1));

        jLabel6.setText("Resultado de Evaluación:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 384, -1, -1));

        cum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumKeyTyped(evt);
            }
        });
        jPanel1.add(cum, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 105, -1));

        jLabel7.setText("% de cumplimiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 415, -1, -1));

        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 178, -1));

        jLabel8.setText("Nominación:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 446, -1, -1));
        jPanel1.add(codE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 467, 630, 27));
        jPanel1.add(cM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 505, 630, 31));
        jPanel1.add(gestion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 547, 630, 29));
        jPanel1.add(nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 582, 630, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sep = System.getProperty("line.separator");
        if(resE.getText().equals("")){
            resE.setText("0");
        }
        if(!((nom.getSelectedItem().toString()).equals(""))&&!(codE.getText().equals(""))&&!(cM.getText().equals(""))&&!(cum.getText().equals(""))&&!(gestion.getText().equals(""))){
            Double aux1= Double.parseDouble(resE.getText());
            if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el resultado de evaluación no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                Double aux3= Double.parseDouble(cum.getText());
                if(aux3<0||aux3>100){
                    JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
                }
                else{
                    Redondear r=new Redondear();
                     aux1=r.rD(aux1);
                     aux3=r.rD(aux3);
                    BigDecimal aux2= BigDecimal.valueOf(aux1);
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE estudiante SET gestion='"+gestion.getText()+"',codigoestudiante='"+codE.getText()+"',apellidos='"+aE.getText()+"',nombres='"+nE.getText()+"',email='"+email.getText()+"',telefono='"+telf.getText()+"',codMat='"+cM.getText()+"',materia='"+mat.getText()+"',resultadoEvaluaciones='"+aux2+"',cumplimiento='"+aux4+"',nominacion='"+nom.getSelectedItem().toString()+"' WHERE gestion='"+gestion1.getText()+"' AND codigoestudiante='"+codE1.getText()+"' AND codMat='"+cM1.getText()+"' AND nominacion='"+nom1.getText()+"'");
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Operación Incorrecta, Cod Estudiante, Código Materia, gestión, nominación duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un determinado campo"+sep+"O los campos gestion,nominacion no coinciden con institucional NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    }
                    this.setVisible(false);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor, el codigo del estudiante, el codigo de Materia, el % de cumplimiento, gestión, nominacion no pueden estar vacios","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void aEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aEKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            ((Component)evt.getSource()).transferFocus();
        }
    }//GEN-LAST:event_aEKeyPressed

    private void aEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aEKeyTyped
        if(aE.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aEKeyTyped

    private void nEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nEKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            ((Component)evt.getSource()).transferFocus();
        }
    }//GEN-LAST:event_nEKeyPressed

    private void nEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nEKeyTyped
        if(nE.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nEKeyTyped

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            ((Component)evt.getSource()).transferFocus();
        }
    }//GEN-LAST:event_emailKeyPressed

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        if(email.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_emailKeyTyped

    private void telfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            ((Component)evt.getSource()).transferFocus();
        }
    }//GEN-LAST:event_telfKeyPressed

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        if(telf.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_telfKeyTyped

    private void cMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cMKeyTyped
        if(cM.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cMKeyTyped

    private void matKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_matKeyPressed

    private void matKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyTyped
        if(mat.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_matKeyTyped

    private void resEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resEKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(resE.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_resEKeyPressed

    private void resEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resEKeyTyped
        char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(resE.getText().contains(".")){
            contador1=2;
        }
        else{
            contador1=1;
        }
        if ((k >= 32 && k <= 45) ||(k >= 58 && k <= 126)  ){
            evt.consume();
            getToolkit().beep();
        }
        if(k==46){
            if (resE.getText().equals("")){
                resE.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    resE.setText(resE.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(resE.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_resEKeyTyped

    private void cumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cumKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(cum.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_cumKeyPressed

    private void cumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cumKeyTyped
        char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(cum.getText().contains(".")){
            contador1=2;
        }
        else{
            contador1=1;
        }
        if ((k >= 32 && k <= 45) ||(k >= 58 && k <= 126)  ){
            evt.consume();
            getToolkit().beep();
        }
        if(k==46){
            if (cum.getText().equals("")){
                cum.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    cum.setText(cum.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(cum.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cumKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea aE;
    private javax.swing.JTextField cM;
    private javax.swing.JLabel cM1;
    private javax.swing.JTextField codE;
    private javax.swing.JLabel codE1;
    private javax.swing.JTextField cum;
    private javax.swing.JTextArea email;
    private javax.swing.JTextField gestion;
    private javax.swing.JLabel gestion1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea mat;
    private javax.swing.JTextArea nE;
    private javax.swing.JComboBox nom;
    private javax.swing.JLabel nom1;
    private javax.swing.JTextField resE;
    private javax.swing.JTextArea telf;
    // End of variables declaration//GEN-END:variables
Conexion2 cc= new Conexion2();
Connection cn= cc.conexion();
}
