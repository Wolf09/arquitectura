/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investigacion;

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
public class mIn extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public mIn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gestion);
        SpellChecker.register(codI);
        SpellChecker.register(aI);
        SpellChecker.register(nI);
        SpellChecker.register(invA);
        SpellChecker.register(areaT);
        SpellChecker.register(codAT);
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
        this.setTitle("INVESTIGADOR");
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
        codI1.setVisible(false);
        invA1.setVisible(false);
        gestion1.setVisible(false);
        codAT1.setVisible(false);
    }

    public String getgestion(){
    return gestion.getText();
    }
    public String getcodI(){
    return codI.getText();
    }
    public String getinvA(){
    return invA.getText();
    }
    public String getcodAT(){
    return codAT.getText();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6, String aux7,String aux8, String aux9,String aux10,String aux11,String aux12,String aux13){
    gestion.setText(aux1);
    codI.setText(aux2);
    grado.setSelectedItem(aux3);
    aI.setText(aux4);
    nI.setText(aux5);
    email.setText(aux6);
    telf.setText(aux7);
    invA.setText(aux8);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux9));
    } catch (ParseException ex) {
        Logger.getLogger(mIn.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux10));
    } catch (ParseException ex) {
        Logger.getLogger(mIn.class.getName()).log(Level.SEVERE, null, ex);
    }
    cum.setText(aux11);
    areaT.setText(aux12);
    codAT.setText(aux13);
    codI1.setText(aux2);
    invA1.setText(aux8);
    gestion1.setText(aux1);
    codAT1.setText(aux13);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        codI1 = new javax.swing.JLabel();
        invA1 = new javax.swing.JLabel();
        codAT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaT = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invA = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        botM = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        codI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        aI = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nI = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        telf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        gestion1 = new javax.swing.JLabel();
        codAT1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "MODIFICAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 72, 225));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, 132, -1));
        jPanel1.add(codI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 442, 630, 23));
        jPanel1.add(invA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 476, 630, 24));

        codAT.setEditable(false);
        codAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codATKeyTyped(evt);
            }
        });
        jPanel1.add(codAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 416, 290, -1));

        jLabel14.setText("código de Área Temática:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 419, -1, -1));

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
        jScrollPane2.setViewportView(areaT);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 361, 410, 44));

        jLabel13.setText("Área Temática:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 361, -1, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 150, -1));

        jLabel8.setText("Fecha Final:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 150, -1));

        jLabel7.setText("Fecha de Inicio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        cum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumKeyTyped(evt);
            }
        });
        jPanel1.add(cum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 105, -1));

        jLabel12.setText("% de cumplimiento:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 281, -1, -1));

        invA.setColumns(20);
        invA.setLineWrap(true);
        invA.setRows(5);
        invA.setWrapStyleWord(true);
        invA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                invAKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invAKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(invA);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 227, 410, 40));

        jLabel6.setText("Investigación Actual:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 227, -1, -1));

        botM.setBackground(new java.awt.Color(0, 72, 225));
        botM.setForeground(new java.awt.Color(255, 255, 255));
        botM.setText("MODIFICAR");
        botM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botMActionPerformed(evt);
            }
        });
        jPanel1.add(botM, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 122, -1));

        jLabel5.setText("gestión:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 22, -1, -1));

        gestion.setEditable(false);
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 19, 150, -1));

        codI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codIKeyTyped(evt);
            }
        });
        jPanel1.add(codI, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 50, 410, -1));

        jLabel1.setText("Código del Investigador:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 53, -1, -1));

        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 76, 150, -1));

        jLabel2.setText("Grado de instrucción del Investigador:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 79, -1, -1));

        aI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aIKeyTyped(evt);
            }
        });
        jPanel1.add(aI, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 107, 410, -1));

        jLabel16.setText("Apellidos:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 110, -1, -1));

        nI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nIKeyTyped(evt);
            }
        });
        jPanel1.add(nI, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 134, 410, -1));

        jLabel17.setText("Nombres:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 137, -1, -1));

        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jPanel1.add(telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 165, 410, -1));

        jLabel4.setText("teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 168, -1, -1));

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 196, 410, -1));

        jLabel3.setText("email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 199, -1, -1));
        jPanel1.add(gestion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 511, 630, 23));
        jPanel1.add(codAT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 545, 630, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void codATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codATKeyTyped
        if(codAT.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codATKeyTyped

    private void areaTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_areaTKeyPressed

    private void areaTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTKeyTyped
        if(areaT.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_areaTKeyTyped

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

    private void invAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invAKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_invAKeyPressed

    private void invAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invAKeyTyped
        if(invA.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_invAKeyTyped

    private void botMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botMActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band=true;
        if(!(gestion.getText().equals(""))&&!(codAT.getText().equals(""))&&!(codI.getText().equals(""))&&!(invA.getText().equals(""))&&!(cum.getText().equals(""))){
            Double aux1= Double.parseDouble(cum.getText());    
            if(aux1<0||aux1>100){
                    JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
                    }
             else{
                    Redondear r=new Redondear();
                    aux1=r.rD(aux1);
                    BigDecimal aux2= BigDecimal.valueOf(aux1);
                    try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE investigador SET gestion='"+gestion.getText()+"',codigoInv='"+codI.getText()+"',grado='"+grado.getSelectedItem().toString()+"',apellidos='"+aI.getText()+"',nombres='"+nI.getText()+"',email='"+email.getText()+"',telefono='"+telf.getText()+"',investigacionActual='"+invA.getText()+"',fechaI='"+formato.format(fecha1)+"',fechaF='"+formato.format(fecha2)+"',cumplimiento='"+aux2+"',codigoAT='"+codAT.getText()+"' WHERE gestion='"+gestion1.getText()+"' AND codigoInv='"+codI1.getText()+"' AND investigacionActual='"+invA1.getText()+"' AND codigoAT='"+codAT1.getText()+"'");
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Operación Incorrecta, el codigo del investigador, Investigacion actual, codigo de Area Tem, gestión, duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo"+sep+"O los campos no coinciden con una Area Tematica valida NOSE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                        band=false;
                    }
                    
                     if(band==true){
                                try {
                                Statement st = cn.createStatement();
                                ResultSet rs = st.executeQuery("select * from evaluarpp where ges='"+gestion.getText()+"' AND cI='"+codI.getText()+"' AND iA='"+invA.getText()+"' AND cAT='"+codAT.getText()+"'");
                                    if (!(rs != null) || !(rs.next())) { 
                                                  try {
                                                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarpp(uno,dos,tres,cuatro,cinco,ges,cI,iA,cAT) VALUES (?,?,?,?,?,?,?,?,?)");
                                                            Double aux3= 0.0;
                                                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                                                            pst3.setBigDecimal(1, aux4); 
                                                            pst3.setBigDecimal(2, aux4);
                                                            pst3.setBigDecimal(3, aux4);
                                                            pst3.setBigDecimal(4, aux4);
                                                            pst3.setBigDecimal(5, aux4);
                                                            pst3.setString(6, gestion.getText());
                                                            pst3.setString(7, codI.getText());
                                                            pst3.setString(8, invA.getText());
                                                            pst3.setString(9, codAT.getText());
                                                            pst3.executeUpdate();

                                                            }catch (Exception e) {
                                                                System.out.print(e.getMessage());
                                                            }
                                       } 
                                } catch (SQLException ex) {
                                Logger.getLogger(mIn.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                         }
                     
                         if(band==true){
                                try {
                                Statement st = cn.createStatement();
                                ResultSet rs = st.executeQuery("select * from evaluarsp where ges='"+gestion.getText()+"' AND cI='"+codI.getText()+"' AND iA='"+invA.getText()+"' AND cAT='"+codAT.getText()+"'");
                                    if (!(rs != null) || !(rs.next())) { 
                                                  try {
                                                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarsp(uno,dos,tres,cuatro,cinco,ges,cI,iA,cAT) VALUES (?,?,?,?,?,?,?,?,?)");
                                                            Double aux3= 0.0;
                                                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                                                            pst3.setBigDecimal(1, aux4); 
                                                            pst3.setBigDecimal(2, aux4);
                                                            pst3.setBigDecimal(3, aux4);
                                                            pst3.setBigDecimal(4, aux4);
                                                            pst3.setBigDecimal(5, aux4);
                                                            pst3.setString(6, gestion.getText());
                                                            pst3.setString(7, codI.getText());
                                                            pst3.setString(8, invA.getText());
                                                            pst3.setString(9, codAT.getText());
                                                            pst3.executeUpdate();

                                                            }catch (Exception e) {
                                                                System.out.print(e.getMessage());
                                                            }
                                       } 
                                } catch (SQLException ex) {
                                Logger.getLogger(mIn.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                         }
                         
                         if(band==true){
                                try {
                                Statement st = cn.createStatement();
                                ResultSet rs = st.executeQuery("select * from evaluarpf where ges='"+gestion.getText()+"' AND cI='"+codI.getText()+"' AND iA='"+invA.getText()+"' AND cAT='"+codAT.getText()+"'");
                                    if (!(rs != null) || !(rs.next())) { 
                                                  try {
                                                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarpf(uno,dos,tres,cuatro,cinco,ges,cI,iA,cAT) VALUES (?,?,?,?,?,?,?,?,?)");
                                                            Double aux3= 0.0;
                                                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                                                            pst3.setBigDecimal(1, aux4); 
                                                            pst3.setBigDecimal(2, aux4);
                                                            pst3.setBigDecimal(3, aux4);
                                                            pst3.setBigDecimal(4, aux4);
                                                            pst3.setBigDecimal(5, aux4);
                                                            pst3.setString(6, gestion.getText());
                                                            pst3.setString(7, codI.getText());
                                                            pst3.setString(8, invA.getText());
                                                            pst3.setString(9, codAT.getText());
                                                            pst3.executeUpdate();

                                                            }catch (Exception e) {
                                                                System.out.print(e.getMessage());
                                                            }
                                       } 
                                } catch (SQLException ex) {
                                Logger.getLogger(mIn.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                         }
                    this.setVisible(false);
                }
        }
        else{
               JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo del Investigador, Investigacion Actual, % de cumplimiento, codigo de Area Tem, gestión NO PUEDEN ESTAR VACIOS NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botMActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void codIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codIKeyTyped
        if(codI.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codIKeyTyped

    private void aIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aIKeyTyped
        if(aI.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aIKeyTyped

    private void nIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nIKeyTyped
        if(nI.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nIKeyTyped

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aI;
    private javax.swing.JTextArea areaT;
    private javax.swing.JButton botM;
    private javax.swing.JTextField codAT;
    private javax.swing.JLabel codAT1;
    private javax.swing.JTextField codI;
    private javax.swing.JLabel codI1;
    private javax.swing.JTextField cum;
    private javax.swing.JTextField email;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gestion;
    private javax.swing.JLabel gestion1;
    private javax.swing.JComboBox grado;
    private javax.swing.JTextArea invA;
    private javax.swing.JLabel invA1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nI;
    private javax.swing.JTextField telf;
    // End of variables declaration//GEN-END:variables
Conexion3 cc= new Conexion3();
 Connection cn= cc.conexion();
}
