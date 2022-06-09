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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class iUT extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public iUT(java.awt.Frame parent, boolean modal) {
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
        SpellChecker.register(cUT);
        SpellChecker.register(uT);
        grado.addItem("Dr.");
        grado.addItem("Dra.");
        grado.addItem("Msc. Ing.");
        grado.addItem("Ing.");
        grado.addItem("Msc. Arq.");
        grado.addItem("Arq.");
        grado.addItem("Msc. Lic.");
        grado.addItem("Lic.");
        this.setTitle("UNIDAD TEMATICA");
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

    public String getcUT(){
    return cUT.getText();
    }
    public String getcodCarr(){
    return codCarr.getText();
    }
    public String getgestion(){
    return gestion.getText();
    }
    public String getcodMat(){
    return codMat.getText();
    }
    public String getcodDoc(){
    return codDoc.getText();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6, String aux7,String aux8, String aux9,String aux10,String aux11,String aux12){
    gestion.setText(aux1);
    codDoc.setText(aux2);
    grado.setSelectedItem(aux3);
    aD.setText(aux4);
    nD.setText(aux5);
    nomMat.setText(aux6);
    nomCarr.setText(aux7);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecIni.setDate(formato.parse(aux8));
    } catch (ParseException ex) {
        Logger.getLogger(iUT.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecFin.setDate(formato.parse(aux9));
    } catch (ParseException ex) {
        Logger.getLogger(iUT.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux10);
    codCarr.setText(aux11);
    codMat.setText(aux12);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        aD = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        nD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        nomMat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nomCarr = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        fecIni = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        fecFin = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        codDoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        codMat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        uT = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cUT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        codCarr = new javax.swing.JTextField();
        cump = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 170, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "INSERTAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Unidad Tematica:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 84, -1, -1));

        jLabel11.setText("Grado de Instrucción del Docente:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        grado.setEnabled(false);
        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 185, 360, -1));

        jLabel12.setText("Apellidos (Docente):");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 226, -1, -1));

        aD.setEditable(false);
        aD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aDKeyTyped(evt);
            }
        });
        jPanel1.add(aD, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 223, 360, -1));

        jLabel13.setText("Nombres (Docente):");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 264, -1, -1));

        nD.setEditable(false);
        nD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nDKeyTyped(evt);
            }
        });
        jPanel1.add(nD, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 261, 360, -1));

        jLabel3.setText("Nombre de materia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 136, -1, -1));

        nomMat.setEditable(false);
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 136, 360, 38));

        jLabel4.setText("Carrera donde ejerce Docencia:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 25));

        nomCarr.setEditable(false);
        nomCarr.setColumns(20);
        nomCarr.setLineWrap(true);
        nomCarr.setRows(5);
        nomCarr.setWrapStyleWord(true);
        nomCarr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomCarrKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomCarrKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(nomCarr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 292, 360, 38));

        jLabel6.setText("Fecha de Inicio:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 347, -1, -1));
        jPanel1.add(fecIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 230, -1));

        jLabel9.setText("Fecha de fin:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 372, -1, -1));
        jPanel1.add(fecFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 230, -1));

        jLabel5.setText("% de Cumplimiento :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 413, -1, -1));

        jLabel14.setText("Código del Docente:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 444, -1, -1));

        codDoc.setEditable(false);
        codDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codDocKeyTyped(evt);
            }
        });
        jPanel1.add(codDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 441, 340, -1));

        jLabel7.setText("Código de Materia :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 482, -1, -1));

        codMat.setEditable(false);
        codMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codMatKeyTyped(evt);
            }
        });
        jPanel1.add(codMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 479, 340, -1));

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INSERTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 102, -1));

        jButton2.setBackground(new java.awt.Color(0, 72, 225));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 111, -1));

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
        jScrollPane3.setViewportView(uT);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 84, 360, 33));

        jLabel1.setText("código Unidad Temática:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        cUT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cUTKeyTyped(evt);
            }
        });
        jPanel1.add(cUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 53, 360, -1));

        jLabel8.setText("Código carrera:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, -1, -1));

        codCarr.setEditable(false);
        jPanel1.add(codCarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 517, 340, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 105, -1));

        jLabel10.setText("Gestión:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 22, -1, -1));

        gestion.setEditable(false);
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 19, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void codMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codMatKeyTyped
        if(codMat.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codMatKeyTyped

    private void uTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uTKeyTyped
        if(uT.getText().length()==150){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_uTKeyTyped

    private void nomCarrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomCarrKeyTyped
        if(nomCarr.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomCarrKeyTyped

    private void codDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codDocKeyTyped
        if(codDoc.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codDocKeyTyped

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

    private void nomMatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomMatKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomMatKeyPressed

    private void nomCarrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomCarrKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomCarrKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sep = System.getProperty("line.separator");
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        Date fecha2=fecIni.getDate();
        Date fecha3=fecFin.getDate();
        boolean band= true;
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        if(cUT.getText().equals("")||codCarr.getText().equals("")||codMat.getText().equals("")||cump.getText().equals("")||gestion.getText().equals("")||codDoc.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos Ingrese por favor, el Código de Unidad tematica, Código de Materia,codigo carrera, % de Cumplimiento,gestión, código del Docente no pueden estar vacios","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            double aux1= Double.parseDouble(cump.getText());
             if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
            if(band==true){
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO unidadtematica(cUT,unidadtematica,fechaInicio,fechaFin,cumplido,codCarr,gestion,codigoMateria,codDoc) VALUES (?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, cUT.getText());
                    pst.setString(2, uT.getText());
                    pst.setString(3, formato.format(fecha2));
                    pst.setString(4, formato.format(fecha3));
                    Double aux3= Double.parseDouble(cump.getText());
                    Redondear r=new Redondear();
                    aux3=r.rD(aux3);
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    pst.setBigDecimal(5, aux4);
                    pst.setString(6, codCarr.getText());
                    pst.setString(7, gestion.getText()); 
                    pst.setString(8, codMat.getText());
                    pst.setString(9, codDoc.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo Unid Tem, codigo de Materia, codigo carrera, gestion, codigo de Docente duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo"+sep+"O los campos no coinciden con una materia valida NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band= false;
                }
            }

            if(band==true){
                try {
                    PreparedStatement pst2 = cn.prepareStatement("INSERT INTO actividad(gestion,actividad,cUT,fechaInicio,fechaFin,cumplido,codCarr,codigoMateria,codDoc) VALUES (?,?,?,?,?,?,?,?,?)");
                    pst2.setString(1, gestion.getText());
                    pst2.setString(2, "");
                    pst2.setString(3, cUT.getText());
                    pst2.setString(4, formato.format(fecha1));
                    pst2.setString(5, formato.format(fecha1));
                    Double aux3= 0.0;
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    pst2.setBigDecimal(6, aux4);
                    pst2.setString(7, codCarr.getText());
                    pst2.setString(8, codMat.getText());
                    pst2.setString(9, codDoc.getText());
                    pst2.executeUpdate();

                }catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
            if(band==true){
                try {
                    PreparedStatement pst2 = cn.prepareStatement ("DELETE FROM unidadtematica WHERE cUT='"+""+"' AND codCarr='"+codCarr.getText()+"' AND gestion='"+gestion.getText()+"' AND codigoMateria='"+codMat.getText()+"' AND codDoc='"+codDoc.getText()+"'");
                    pst2.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            this.setVisible(false);
            
           }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cUTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cUTKeyTyped
        if(cUT.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cUTKeyTyped

    private void cumpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cumpKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(cump.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_cumpKeyPressed

    private void cumpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cumpKeyTyped
        char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(cump.getText().contains(".")){
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
            if (cump.getText().equals("")){
                cump.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    cump.setText(cump.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(cump.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cumpKeyTyped

    private void aDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_aDKeyReleased

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_gestionKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aD;
    private javax.swing.JTextField cUT;
    private javax.swing.JTextField codCarr;
    private javax.swing.JTextField codDoc;
    private javax.swing.JTextField codMat;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecFin;
    private com.toedter.calendar.JDateChooser fecIni;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nD;
    private javax.swing.JTextArea nomCarr;
    private javax.swing.JTextArea nomMat;
    private javax.swing.JTextArea uT;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
 Connection cn= cc.conexion();
}
