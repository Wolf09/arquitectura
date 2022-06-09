/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
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
import text.Redondear;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class iMa extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public iMa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gestion);
        SpellChecker.register(codDoc);
        SpellChecker.register(aD);
        SpellChecker.register(nD);
        SpellChecker.register(act);
        SpellChecker.register(uT);
        SpellChecker.register(mat);
        nom.addItem("Maestría");
        grado.addItem("Dr.");
        grado.addItem("Dra.");
        grado.addItem("Msc. Ing.");
        grado.addItem("Ing.");
        grado.addItem("Msc. Arq.");
        grado.addItem("Arq.");
        grado.addItem("Msc. Lic.");
        grado.addItem("Lic.");
        this.setTitle("MAESTRÍA");
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
    public void llenardatos(String aux1, String aux2, String aux3, String aux4, String aux5, String aux6, String aux7, String aux8, String aux9, String aux10, String aux11, String aux12, String aux13){
    gestion.setText(aux1);
    codDoc.setText(aux2);
    grado.setSelectedItem(aux3);
    aD.setText(aux4);
    nD.setText(aux5);
    telf.setText(aux6);
    email.setText(aux7);
    mat.setText(aux8);
    uT.setText(aux9);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux10));
    } catch (ParseException ex) {
        Logger.getLogger(iDo.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux11));
    } catch (ParseException ex) {
        Logger.getLogger(iDo.class.getName()).log(Level.SEVERE, null, ex);
    }
    cum.setText(aux12);
    nom.setSelectedItem(aux13);
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "INSERTAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código Docente:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 74, -1, -1));

        codDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codDocKeyTyped(evt);
            }
        });
        jPanel1.add(codDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 71, 420, -1));

        jLabel18.setText("Grado de Instrucción del Docente:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 100, -1, -1));

        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 97, 420, -1));

        jLabel19.setText("Apellidos (Docente):");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 134, -1, -1));

        aD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aDKeyTyped(evt);
            }
        });
        jPanel1.add(aD, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 128, 420, -1));

        jLabel20.setText("Nombres (Docente):");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 165, -1, -1));

        nD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nDKeyTyped(evt);
            }
        });
        jPanel1.add(nD, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 159, 420, -1));

        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jPanel1.add(telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 190, 420, -1));

        jLabel4.setText("teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 193, -1, -1));

        jLabel2.setText("email:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 224, -1, -1));

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 221, 420, -1));

        jLabel8.setText("Unidad Temática:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 313, -1, -1));

        jLabel6.setText("Materia o Modulo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 252, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 252, 420, 49));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 313, 420, 47));

        jLabel10.setText("Actividad:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 371, -1, -1));

        jLabel13.setText("% de Cumplimiento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 502, -1, -1));

        cum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumKeyTyped(evt);
            }
        });
        jPanel1.add(cum, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 105, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 150, -1));

        jLabel12.setText("Fecha de Fin:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 466, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 150, -1));

        jLabel11.setText("Fecha de Inicio:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 441, -1, -1));

        jLabel14.setText("nominación:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 533, -1, -1));

        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 150, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 371, 420, 53));

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INSERTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 561, 106, -1));

        jButton3.setBackground(new java.awt.Color(0, 72, 225));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CANCELAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 561, 109, -1));

        jLabel3.setText("Gestión:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 43, -1, -1));

        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 40, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        if(telf.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_telfKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        if(email.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_emailKeyTyped

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

    private void uTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uTKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_uTKeyPressed

    private void uTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uTKeyTyped
        if(uT.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_uTKeyTyped

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

    private void actKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyPressed

    private void actKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyTyped
        if(act.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band =true;
        if((nom.getSelectedItem().toString()).equals("")||codDoc.getText().equals("")||mat.getText().equals("")||uT.getText().equals("")||act.getText().equals("")||cum.getText().equals("")||gestion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor, el codigo Docente,materia,Unidad tematica,actividad, % de Cumplimiento, gestión, nominacion no pueden estar vacios","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            double aux1= Double.parseDouble(cum.getText());
            if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{

                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO maestria(gestion,codDoc,grado,apellidos,nombres,telefono,email,materia,unidadTematica,actividad,fechaInicio,fechaFin,cumplimiento,evaluacion,recurso,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, codDoc.getText());
                    pst.setString(3, grado.getSelectedItem().toString());
                    pst.setString(4, aD.getText());
                    pst.setString(5, nD.getText());
                    pst.setString(6, telf.getText());
                    pst.setString(7, email.getText());
                    pst.setString(8, mat.getText());
                    pst.setString(9, uT.getText());
                    pst.setString(10, act.getText());
                    pst.setString(11, formato.format(fecha1));
                    pst.setString(12, formato.format(fecha2));
                    Double aux3= Double.parseDouble(cum.getText());
                    Redondear r=new Redondear();
                    aux3=r.rD(aux3);
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    Double aux5=0.0;
                    BigDecimal aux6= BigDecimal.valueOf(aux5);
                    pst.setBigDecimal(13,aux4);
                    pst.setBigDecimal(14,aux6);
                    pst.setString(15, "");
                    pst.setString(16, nom.getSelectedItem().toString());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Cod Docente, Materia, unidad tematica, actividad, gestión, nominación duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo"+sep+"O los campos gestion, nominacion no coinciden con institucional NOSE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
                if(band==true){
                try {
                    PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarma(uno,dos,tres,cuatro,gest,cD,mat,uT,act,nom) VALUES (?,?,?,?,?,?,?,?,?,?)");
                    Double aux3= 0.0;
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    pst3.setBigDecimal(1, aux4); 
                    pst3.setBigDecimal(2, aux4);
                    pst3.setBigDecimal(3, aux4);
                    pst3.setBigDecimal(4, aux4);
                    pst3.setString(5, gestion.getText());
                    pst3.setString(6, codDoc.getText());
                    pst3.setString(7, mat.getText());
                    pst3.setString(8, uT.getText());
                    pst3.setString(9, act.getText());
                    pst3.setString(10, nom.getSelectedItem().toString());
                    pst3.executeUpdate();

                }catch (Exception e) {
                    Logger.getLogger(Diplomado.class.getName()).log(Level.SEVERE, null, e);
                }
            }
                if(band==true){
                    try {
                        PreparedStatement pst2 = cn.prepareStatement ("DELETE FROM maestria WHERE gestion='"+gestion.getText()+"' AND codDoc='"+""+"' AND materia='"+""+"' AND unidadtematica='"+""+"' AND actividad='"+""+"' AND nominacion='"+nom.getSelectedItem().toString()+"'");
                        pst2.executeUpdate();
                       } catch (Exception e) {
                        System.out.println(e.getMessage());
                       }
                  }
                this.setVisible(false);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

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
