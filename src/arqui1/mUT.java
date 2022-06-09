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
public class mUT extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public mUT(java.awt.Frame parent, boolean modal) {
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
        cUT1.setVisible(false);
        codDoc1.setVisible(false);
        codCarr1.setVisible(false);
        gestion1.setVisible(false);
        codMat1.setVisible(false);
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
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6, String aux7,String aux8, String aux9,String aux10, String aux11,String aux12,String aux13,String aux14){
    gestion.setText(aux1);
    codDoc.setText(aux2);
    grado.setSelectedItem(aux3);
    aD.setText(aux4);
    nD.setText(aux5);
    cUT.setText(aux6);
    uT.setText(aux7);
    nomMat.setText(aux8);
    nomCarr.setText(aux9);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecIni.setDate(formato.parse(aux10));
    } catch (ParseException ex) {
        Logger.getLogger(mUT.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecFin.setDate(formato.parse(aux11));
    } catch (ParseException ex) {
        Logger.getLogger(mUT.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux12);
    codCarr.setText(aux13);
    codMat.setText(aux14);
    cUT1.setText(aux6);
    codDoc1.setText(aux2);
    codCarr1.setText(aux13);
    gestion1.setText(aux1);
    codMat1.setText(aux14);
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
        jLabel14 = new javax.swing.JLabel();
        codDoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        codMat = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        uT = new javax.swing.JTextArea();
        botMod = new javax.swing.JButton();
        cUT1 = new javax.swing.JLabel();
        codDoc1 = new javax.swing.JLabel();
        codCarr1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cUT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        codCarr = new javax.swing.JTextField();
        cump = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        gestion1 = new javax.swing.JLabel();
        codMat1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 170, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "MODIFICAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Unidad Tematica:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 81, -1, -1));

        jLabel11.setText("Grado de Instrucción del Docente:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        grado.setEnabled(false);
        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 174, 420, -1));

        jLabel12.setText("Apellidos (Docente):");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 208, -1, -1));

        aD.setEditable(false);
        aD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aDKeyTyped(evt);
            }
        });
        jPanel1.add(aD, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 205, 420, -1));

        jLabel13.setText("Nombres (Docente):");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 246, -1, -1));

        nD.setEditable(false);
        nD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nDKeyTyped(evt);
            }
        });
        jPanel1.add(nD, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 243, 420, -1));

        jLabel3.setText("Nombre de materia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 125, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 125, 420, 38));

        jLabel4.setText("Carrera donde ejerce Docencia:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 25));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 274, 420, 38));

        jLabel6.setText("Fecha de Inicio:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 329, -1, -1));
        jPanel1.add(fecIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 230, -1));

        jLabel9.setText("Fecha de fin:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 354, -1, -1));
        jPanel1.add(fecFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 230, -1));

        jLabel14.setText("Código del Docente:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 421, -1, -1));

        codDoc.setEditable(false);
        codDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codDocKeyTyped(evt);
            }
        });
        jPanel1.add(codDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 418, 320, -1));

        jLabel7.setText("Código de Materia :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 455, -1, -1));

        codMat.setEditable(false);
        codMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codMatKeyTyped(evt);
            }
        });
        jPanel1.add(codMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 449, 320, -1));

        jButton2.setBackground(new java.awt.Color(0, 72, 225));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 587, 111, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 81, 420, 33));

        botMod.setBackground(new java.awt.Color(0, 72, 225));
        botMod.setForeground(new java.awt.Color(255, 255, 255));
        botMod.setText("MODIFICAR");
        botMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botModActionPerformed(evt);
            }
        });
        jPanel1.add(botMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 587, 108, -1));
        jPanel1.add(cUT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 511, 639, 20));
        jPanel1.add(codDoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 542, 285, 25));
        jPanel1.add(codCarr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 19, 250, 20));

        jLabel1.setText("código Unidad Temática:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 53, -1, -1));

        cUT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cUTKeyTyped(evt);
            }
        });
        jPanel1.add(cUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 50, 420, -1));

        jLabel8.setText("Código Carrera:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 490, -1, -1));

        codCarr.setEditable(false);
        jPanel1.add(codCarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 487, 320, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 105, -1));

        jLabel5.setText("% de Cumplimiento :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 390, -1, -1));

        jLabel10.setText("Gestión:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 22, -1, -1));

        gestion.setEditable(false);
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 160, -1));
        jPanel1.add(gestion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 390, 320, 20));
        jPanel1.add(codMat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 542, 344, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
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
        if(nomMat.getText().length()==99){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nomMatKeyTyped

    private void codMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codMatKeyTyped
        if(codMat.getText().length()==21){
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
        if(codDoc.getText().length()==21){
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botModActionPerformed
        String sep = System.getProperty("line.separator");
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha3 = calendario.getTime();
        Date fecha1= fecIni.getDate();
        Date fecha2= fecFin.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");   
        boolean band= true;
        if(!(cUT.getText().equals(""))&&!(codMat.getText().equals(""))&&!(codCarr.getText().equals(""))&&!(cump.getText().equals(""))&&!(gestion.getText().equals(""))&&!(codDoc.getText().equals(""))){
            Double aux1= Double.parseDouble(cump.getText());
            if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                Redondear r=new Redondear();
                aux1=r.rD(aux1);
                BigDecimal aux2= BigDecimal.valueOf(aux1);
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE unidadtematica SET cUT='"+cUT.getText()+"',unidadtematica='"+uT.getText()+"',fechaInicio='"+formato.format(fecha1)+"',fechaFin='"+formato.format(fecha2)+"',cumplido='"+aux2+"',codCarr='"+codCarr.getText().toString()+"',gestion='"+gestion.getText()+"',codigoMateria='"+codMat.getText()+"',codDoc='"+codDoc.getText()+"' WHERE cUT='"+cUT1.getText()+"' AND codCarr='"+codCarr1.getText()+"' AND gestion='"+gestion1.getText()+"' AND codigoMateria='"+codMat1.getText()+"' AND codDoc='"+codDoc1.getText()+"'");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo Unid Tem, codigo de Materia, codigo carrera, gestion, codigo de Docente duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo"+sep+"O los campos no coinciden con una materia valida NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
              if(band==true){
              try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery("select * from actividad where cUT='"+cUT.getText()+"' AND codCarr='"+codCarr.getText()+"' AND gestion='"+gestion.getText()+"' AND codigoMateria='"+codMat.getText()+"' AND codDoc='"+codDoc.getText()+"'");
                    if (!(rs != null) || !(rs.next())) { 
                           try {
                                 PreparedStatement pst2 = cn.prepareStatement("INSERT INTO actividad(gestion,actividad,cUT,fechaInicio,fechaFin,cumplido,codCarr,codigoMateria,codDoc) VALUES (?,?,?,?,?,?,?,?,?)");
                                 pst2.setString(1, gestion.getText());
                                 pst2.setString(2, "");
                                 pst2.setString(3, cUT.getText());
                                 pst2.setString(4, formato.format(fecha3));
                                 pst2.setString(5, formato.format(fecha3));
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
              } catch (SQLException ex) {
              Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
              }
            
            }
            this.setVisible(false);
            }
        }
        else{
               JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Unid Tematica, codigo de Materia, codigo carrera, % de Cumplimiento, gestión, codigo del Docente NO PUEDEN ESTAR VACIOS NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botModActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aD;
    private javax.swing.JButton botMod;
    private javax.swing.JTextField cUT;
    private javax.swing.JLabel cUT1;
    private javax.swing.JTextField codCarr;
    private javax.swing.JLabel codCarr1;
    private javax.swing.JTextField codDoc;
    private javax.swing.JLabel codDoc1;
    private javax.swing.JTextField codMat;
    private javax.swing.JLabel codMat1;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecFin;
    private com.toedter.calendar.JDateChooser fecIni;
    private javax.swing.JTextField gestion;
    private javax.swing.JLabel gestion1;
    private javax.swing.JComboBox grado;
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
