/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;
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
public class iA extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public iA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gestion);
        SpellChecker.register(codA);
        SpellChecker.register(aA);
        SpellChecker.register(nA);
        SpellChecker.register(cargo);
        SpellChecker.register(dep);
        SpellChecker.register(act);
        SpellChecker.register(rR);
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
        this.setTitle("ACTIVIDAD");
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
    public String getcodA(){
    return codA.getText();
    }
    public String getact(){
    return act.getText();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6,String aux7,String aux8,String aux9,String aux10,String aux11,String aux12,String aux13){
    gestion.setText(aux1);
    codA.setText(aux2);
    grado.setSelectedItem(aux3);
    aA.setText(aux4);
    nA.setText(aux5);
    email.setText(aux6);
    telf.setText(aux7);
    cargo.setText(aux8);
    dep.setText(aux9);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux10));
    } catch (ParseException ex) {
        Logger.getLogger(iA.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux11));
    } catch (ParseException ex) {
        Logger.getLogger(iA.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux12);
    rR.setText(aux13);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        codA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        aA = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        nA = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        telf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rR = new javax.swing.JTextField();
        botI = new javax.swing.JButton();
        cump = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        dep = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        cargo = new javax.swing.JTextArea();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 610, 132, -1));

        jLabel1.setText("gestión:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 22, -1, -1));

        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 19, 180, -1));

        codA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codAKeyTyped(evt);
            }
        });
        jPanel1.add(codA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 520, -1));

        jLabel2.setText("Código del Administrativo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 53, -1, -1));

        jLabel3.setText("Grado de instrucción del Adm.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 84, -1, -1));

        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 81, 180, -1));

        aA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aAKeyTyped(evt);
            }
        });
        jPanel1.add(aA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 112, 520, -1));

        jLabel20.setText("Apellidos:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 115, -1, -1));

        nA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nAKeyTyped(evt);
            }
        });
        jPanel1.add(nA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 143, 520, -1));

        jLabel21.setText("Nombres:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 146, -1, -1));

        jLabel4.setText("e-mail:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 177, -1, -1));

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 174, 520, -1));

        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jPanel1.add(telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 205, 520, -1));

        jLabel5.setText("teléfono:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 208, -1, -1));

        jLabel6.setText("cargo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 236, -1, -1));

        jLabel9.setText("Dependencia:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 295, -1, -1));

        jLabel8.setText("Actividad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 359, -1, -1));

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
        jScrollPane1.setViewportView(act);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 359, 520, 47));

        jLabel10.setText("Fecha de Inicio:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 417, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 140, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 140, -1));

        jLabel11.setText("Fecha Final:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 455, -1, -1));

        jLabel12.setText("% de cumplimiento:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 483, -1, -1));

        jLabel15.setText("Responsable de Revisión:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 514, -1, -1));

        rR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rRKeyTyped(evt);
            }
        });
        jPanel1.add(rR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 511, 520, -1));

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("INSERTAR");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
            }
        });
        jPanel1.add(botI, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 610, 113, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 105, -1));

        dep.setColumns(20);
        dep.setLineWrap(true);
        dep.setRows(5);
        dep.setWrapStyleWord(true);
        dep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                depKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                depKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(dep);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 295, 520, 53));

        cargo.setColumns(20);
        cargo.setLineWrap(true);
        cargo.setRows(5);
        cargo.setWrapStyleWord(true);
        cargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cargoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cargoKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(cargo);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 236, 520, 48));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if (gestion.getText().length() == 20) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void codAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codAKeyTyped
        if (codA.getText().length() == 30) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codAKeyTyped

    private void aAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aAKeyTyped
        if (aA.getText().length() == 40) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aAKeyTyped

    private void nAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nAKeyTyped
        if (nA.getText().length() == 40) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nAKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        if (email.getText().length() == 100) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_emailKeyTyped

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        if (telf.getText().length() == 100) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_telfKeyTyped

    private void rRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rRKeyTyped
        if (rR.getText().length() == 100) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_rRKeyTyped

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha3 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band= true;
        if(codA.getText().equals("")||gestion.getText().equals("")||act.getText().equals("")||cump.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor, codigo del Administrativo, gestión, Actividad, % de cumplimiento, NO PUEDEN ESTAR VACIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            double aux1= Double.parseDouble(cump.getText());
            if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO actividades(gestion,codA,grado,apellidos,nombres,email,telf,cargo,dependencia,act,fInicio,fFinal,cump,pp,sp,pf,recurso,respR) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, codA.getText());
                    pst.setString(3, grado.getSelectedItem().toString());
                    pst.setString(4, aA.getText());
                    pst.setString(5, nA.getText());
                    pst.setString(6, email.getText());
                    pst.setString(7, telf.getText());
                    pst.setString(8, cargo.getText());
                    pst.setString(9, dep.getText());
                    pst.setString(10, act.getText());
                    pst.setString(11, formato.format(fecha1));
                    pst.setString(12, formato.format(fecha2));
                    Double aux3 = Double.parseDouble(cump.getText());
                    Redondear r=new Redondear();
                    aux3=r.rD(aux3);
                    BigDecimal aux4 = BigDecimal.valueOf(aux3);
                    Double aux5 = 0.0;
                    BigDecimal aux6 = BigDecimal.valueOf(aux5);
                    pst.setBigDecimal(13, aux4);          
                    pst.setBigDecimal(14, aux6);
                    pst.setBigDecimal(15, aux6);          
                    pst.setBigDecimal(16, aux6);
                    pst.setString(17, "");
                    pst.setString(18, rR.getText()); 
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo del Administrativo, Actividad ,gestión, DUPLICADO"+sep+"O la cantidad de letras sobrepasa lo permtido para un determinado campo","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
                if(band==true){
                     try {
                                PreparedStatement pst2 = cn.prepareStatement("INSERT INTO subactividades(gestion,codA,act,subA,fInicio,fFinal,cump,pp,sp,pf) VALUES (?,?,?,?,?,?,?,?,?,?)");
                                pst2.setString(1, gestion.getText());
                                pst2.setString(2, codA.getText());
                                pst2.setString(3, act.getText());
                                pst2.setString(4, "");
                                pst2.setString(5, formato.format(fecha3));
                                pst2.setString(6, formato.format(fecha3));
                                Double aux7 = 0.0;
                                BigDecimal aux8 = BigDecimal.valueOf(aux7);
                                pst2.setBigDecimal(7,aux8);
                                pst2.setBigDecimal(8,aux8);
                                pst2.setBigDecimal(9,aux8);
                                pst2.setBigDecimal(10,aux8);
                                pst2.executeUpdate();
                              } catch (Exception e) {
                                System.out.print(e.getMessage());
                              }
                }
                this.setVisible(false);
            }

        }
    }//GEN-LAST:event_botIActionPerformed

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

    private void actKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyTyped
         if (act.getText().length() == 200) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyTyped

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

    private void depKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depKeyPressed
           char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_depKeyPressed

    private void cargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cargoKeyPressed
           char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cargoKeyPressed

    private void cargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cargoKeyTyped
          if (cargo.getText().length() == 200) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cargoKeyTyped

    private void depKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depKeyTyped
          if (dep.getText().length() == 200) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_depKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aA;
    private javax.swing.JTextArea act;
    private javax.swing.JButton botI;
    private javax.swing.JTextArea cargo;
    private javax.swing.JTextField codA;
    private javax.swing.JTextField cump;
    private javax.swing.JTextArea dep;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nA;
    private javax.swing.JTextField rR;
    private javax.swing.JTextField telf;
    // End of variables declaration//GEN-END:variables
Conexion6 cc= new Conexion6();
 Connection cn= cc.conexion();
}
