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
public class iP extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public iP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gestion);
        SpellChecker.register(codP);
        SpellChecker.register(aP);
        SpellChecker.register(nP);
        SpellChecker.register(codPro);
        SpellChecker.register(pro);
        SpellChecker.register(eje);
        SpellChecker.register(linea);
        grado.addItem("Dr.");
        grado.addItem("Dra.");
        grado.addItem("Msc. Ing.");
        grado.addItem("Ing.");
        grado.addItem("Msc. Arq.");
        grado.addItem("Arq.");
        grado.addItem("Msc. Lic.");
        grado.addItem("Lic.");
        grado.addItem("Tec. Sup.");
        grado.addItem("Tec. Med.");
        grado.addItem("Est.");
        this.setTitle("POSTULANTES");
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
    public String getcodP(){
    return codP.getText();
    }
    public String getcodPro(){
    return codPro.getText();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6, String aux7,String aux8,String aux9){
    gestion.setText(aux1);
    grado.setSelectedItem(aux2);
    eje.setText(aux3);
    linea.setText(aux4);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux5));
    } catch (ParseException ex) {
        Logger.getLogger(iP.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux6));
    } catch (ParseException ex) {
        Logger.getLogger(iP.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux7);
    pro.setText(aux8);
    codPro.setText(aux9);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codP = new javax.swing.JTextField();
        grado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        aP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telf = new javax.swing.JTextField();
        gestion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eje = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        linea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pro = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        codPro = new javax.swing.JTextField();
        botI = new javax.swing.JButton();
        cump = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "INSERTAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 72, 225));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 132, -1));

        jLabel1.setText("Código del Postulante:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 64, -1, -1));

        codP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codPKeyTyped(evt);
            }
        });
        jPanel1.add(codP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 61, 380, -1));

        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 87, 180, -1));

        jLabel2.setText("Grado de instrucción del Postulante:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        aP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aPKeyTyped(evt);
            }
        });
        jPanel1.add(aP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 113, 380, -1));

        jLabel11.setText("Apellidos:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 116, -1, -1));

        nP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nPKeyTyped(evt);
            }
        });
        jPanel1.add(nP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 139, 380, -1));

        jLabel15.setText("Nombres:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 142, -1, -1));

        jLabel3.setText("e-mail:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 168, 42, -1));

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 165, 380, -1));

        jLabel4.setText("teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 194, -1, -1));

        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jPanel1.add(telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 191, 380, -1));

        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 180, -1));

        jLabel5.setText("Gestión:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 33, -1, -1));

        jLabel6.setText("Eje:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 222, -1, -1));

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
        jScrollPane1.setViewportView(eje);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 222, 380, 42));

        jLabel7.setText("Linea:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 274, -1, -1));

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
        jScrollPane2.setViewportView(linea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 274, 380, 43));

        jLabel8.setText("Fecha de Inicio:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 323, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 150, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 150, -1));

        jLabel9.setText("Fecha Final:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 355, -1, -1));

        jLabel10.setText("Proyecto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 411, -1, -1));

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
        jScrollPane3.setViewportView(pro);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 411, 380, 46));

        jLabel13.setText("código del Proyecto:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 466, -1, -1));

        codPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codProKeyTyped(evt);
            }
        });
        jPanel1.add(codPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 463, 380, -1));

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("INSERTAR");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
            }
        });
        jPanel1.add(botI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 122, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 105, -1));

        jLabel12.setText("% de cumplimiento:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 383, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void codPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codPKeyTyped
        if(codP.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codPKeyTyped

    private void aPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aPKeyTyped
        if(aP.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aPKeyTyped

    private void nPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nPKeyTyped
        if(nP.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nPKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        if(email.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_emailKeyTyped

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        if(telf.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_telfKeyTyped

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void codProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codProKeyTyped
        if(codPro.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codProKeyTyped

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band =true;
        if(gestion.getText().equals("")||codP.getText().equals("")||codPro.getText().equals("")||cump.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor, el código del Postulante,el código del proyecto, gestión,  el% de cumplimiento no pueden estar vacios","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
                double aux1= Double.parseDouble(cump.getText());
               if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
                }
               else{
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO postulantes(gestion,codigoE,grado,apellidos,nombres,email,telefono,fechaI,fechaF,cump,pp,sp,pf,recurso,codigoP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, codP.getText());
                    pst.setString(3, grado.getSelectedItem().toString());
                    pst.setString(4, aP.getText());
                    pst.setString(5, nP.getText());
                    pst.setString(6, email.getText());
                    pst.setString(7, telf.getText());
                    pst.setString(8, formato.format(fecha1));
                    pst.setString(9, formato.format(fecha2));
                    Double aux3= Double.parseDouble(cump.getText());
                    Redondear r=new Redondear();
                    aux3=r.rD(aux3);
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    pst.setBigDecimal(10,aux4);
                    Double aux5=0.0;
                    BigDecimal aux6= BigDecimal.valueOf(aux5);
                    pst.setBigDecimal(11,aux6);
                    pst.setBigDecimal(12,aux6);
                    pst.setBigDecimal(13,aux6);
                    pst.setString(14,"");
                    pst.setString(15, codPro.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, gestión, código del Postulante y código del Proyecto duplicadoS"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo"+sep+"O los campos no coinciden con un proyecto valido NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
                if(band==true){
                        try {
                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarpp(uno,dos,tres,cuatro,cinco,ges,cE,cP) VALUES (?,?,?,?,?,?,?,?)");
                            Double aux3= 0.0;
                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                            pst3.setBigDecimal(1, aux4); 
                            pst3.setBigDecimal(2, aux4);
                            pst3.setBigDecimal(3, aux4);
                            pst3.setBigDecimal(4, aux4);
                            pst3.setBigDecimal(5, aux4);
                            pst3.setString(6, gestion.getText());
                            pst3.setString(7, codP.getText());
                            pst3.setString(8, codPro.getText());
                            pst3.executeUpdate();

                        }catch (Exception e) {
                            System.out.print(e.getMessage());
                        }
                    }
                 if(band==true){
                        try {
                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarsp(uno,dos,tres,cuatro,cinco,ges,cE,cP) VALUES (?,?,?,?,?,?,?,?)");
                            Double aux3= 0.0;
                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                            pst3.setBigDecimal(1, aux4); 
                            pst3.setBigDecimal(2, aux4);
                            pst3.setBigDecimal(3, aux4);
                            pst3.setBigDecimal(4, aux4);
                            pst3.setBigDecimal(5, aux4);
                            pst3.setString(6, gestion.getText());
                            pst3.setString(7, codP.getText());
                            pst3.setString(8, codPro.getText());
                            pst3.executeUpdate();

                        }catch (Exception e) {
                            System.out.print(e.getMessage());
                        }
                    }
                    if(band==true){
                        try {
                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarpf(uno,dos,tres,cuatro,cinco,ges,cE,cP) VALUES (?,?,?,?,?,?,?,?)");
                            Double aux3= 0.0;
                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                            pst3.setBigDecimal(1, aux4); 
                            pst3.setBigDecimal(2, aux4);
                            pst3.setBigDecimal(3, aux4);
                            pst3.setBigDecimal(4, aux4);
                            pst3.setBigDecimal(5, aux4);
                            pst3.setString(6, gestion.getText());
                            pst3.setString(7, codP.getText());
                            pst3.setString(8, codPro.getText());
                            pst3.executeUpdate();

                        }catch (Exception e) {
                            System.out.print(e.getMessage());
                        }
                    }
                 if(band==true){
                    try {
                        PreparedStatement pst2 = cn.prepareStatement ("DELETE FROM postulantes WHERE gestion='"+gestion.getText()+"' AND codigoE='"+""+"' AND codigoP='"+codPro.getText()+"'");
                        pst2.executeUpdate();
                       } catch (Exception e) {
                        System.out.println(e.getMessage());
                       }
                }
                this.setVisible(false);
               }
        }
    }//GEN-LAST:event_botIActionPerformed

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

    private void proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyTyped
        if(pro.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyTyped

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
    private javax.swing.JTextField aP;
    private javax.swing.JButton botI;
    private javax.swing.JTextField codP;
    private javax.swing.JTextField codPro;
    private javax.swing.JTextField cump;
    private javax.swing.JTextArea eje;
    private javax.swing.JTextField email;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTextArea linea;
    private javax.swing.JTextField nP;
    private javax.swing.JTextArea pro;
    private javax.swing.JTextField telf;
    // End of variables declaration//GEN-END:variables
Conexion4 cc= new Conexion4();
 Connection cn= cc.conexion();
}
