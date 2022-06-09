/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;
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
public class mProd extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public mProd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gest);
        SpellChecker.register(ind);
        SpellChecker.register(res);
        SpellChecker.register(lB);
        SpellChecker.register(meta);
        SpellChecker.register(pro);
        SpellChecker.register(cP);
        nom.addItem("POA");
        nom.addItem("PEI");
        nom.addItem("ACREDITACIÓN");
        nom.addItem("IDH");
        this.setTitle("PRODUCTO");
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
        pro1.setVisible(false);
        res1.setVisible(false);
        nom1.setVisible(false);
        cP1.setVisible(false);
        gest1.setVisible(false);
        act1.setVisible(false);
    }

    public String getgest(){
    return gest.getText();
    }
    public String getact(){
    return act.getText();
    }
    public String getpro(){
    return pro.getText();
    }
    public String getcP(){
    return cP.getText();
    }
    public String getres(){
    return res.getText();
    }
    public String getnom(){
    return nom.getSelectedItem().toString();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6,String aux7,String aux8,String aux9,String aux10,String aux11,String aux12){
    gest.setText(aux1);
    act.setText(aux2);
    pro.setText(aux3);
    ind.setText(aux4);
    lB.setText(aux5);
    meta.setText(aux6);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux7));
    } catch (ParseException ex) {
        Logger.getLogger(mProd.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux8));
    } catch (ParseException ex) {
        Logger.getLogger(mProd.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux9);
    cP.setText(aux10);
    res.setText(aux11);
    nom.setSelectedItem(aux12);
    act1.setText(aux2);
    pro1.setText(aux3);
    res1.setText(aux11);
    cP1.setText(aux10);
    nom1.setText(aux12);
    gest1.setText(aux1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        pro1 = new javax.swing.JLabel();
        res1 = new javax.swing.JLabel();
        botM = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        gest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pro = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ind = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lB = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        meta = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        cP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        res = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nom = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        cP1 = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();
        gest1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cump = new javax.swing.JTextField();
        act1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 132, -1));
        jPanel1.add(pro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 575, 680, 20));
        jPanel1.add(res1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 601, 680, 20));

        botM.setBackground(new java.awt.Color(0, 72, 225));
        botM.setForeground(new java.awt.Color(255, 255, 255));
        botM.setText("MODIFICAR");
        botM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botMActionPerformed(evt);
            }
        });
        jPanel1.add(botM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, 125, -1));

        jLabel11.setText("Gestión:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, -1));

        gest.setEditable(false);
        gest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestKeyTyped(evt);
            }
        });
        jPanel1.add(gest, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 190, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 480, 49));

        jLabel1.setText("Producto:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        ind.setColumns(20);
        ind.setLineWrap(true);
        ind.setRows(5);
        ind.setWrapStyleWord(true);
        ind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                indKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                indKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(ind);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 480, 48));

        jLabel2.setText("Indicador:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        lB.setColumns(20);
        lB.setLineWrap(true);
        lB.setRows(5);
        lB.setWrapStyleWord(true);
        lB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lBKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lBKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(lB);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 480, 49));

        jLabel3.setText("Línea Base:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        meta.setColumns(20);
        meta.setLineWrap(true);
        meta.setRows(5);
        meta.setWrapStyleWord(true);
        meta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                metaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                metaKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(meta);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 480, 54));

        jLabel4.setText("Meta:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 170, -1));

        jLabel12.setText("Fecha de Inicio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 170, -1));

        jLabel14.setText("Fecha final:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        cP.setEditable(false);
        cP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPKeyTyped(evt);
            }
        });
        jPanel1.add(cP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 480, -1));

        jLabel9.setText("Código del Proyecto:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        res.setEditable(false);
        res.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resKeyTyped(evt);
            }
        });
        jPanel1.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 480, -1));

        jLabel10.setText("Responsable del Proyecto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        nom.setEnabled(false);
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 200, -1));

        jLabel20.setText("Nominación:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));
        jPanel1.add(cP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 511, 340, 22));
        jPanel1.add(nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 544, 680, 20));
        jPanel1.add(gest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 511, 330, 22));

        jLabel13.setText("% de Cumplimiento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 105, -1));
        jPanel1.add(act1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 410, 20));

        act.setEditable(false);
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
        jScrollPane5.setViewportView(act);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 480, 50));

        jLabel5.setText("Actividad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botMActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band=true;
        if(!((nom.getSelectedItem().toString()).equals(""))&&!(gest.getText().equals(""))&&!(act.getText().equals(""))&&!(res.getText().equals(""))&&!(pro.getText().equals(""))&&!(cP.getText().equals(""))&&!(cump.getText().equals(""))){
             Double aux1= Double.parseDouble(cump.getText());
             if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
             }
             else{
                 Redondear r=new Redondear();
                 aux1=r.rD(aux1);
                 BigDecimal aux2= BigDecimal.valueOf(aux1);
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE producto SET gestion='"+gest.getText()+"',producto='"+pro.getText()+"',indicador='"+ind.getText()+"',lineaBase='"+lB.getText()+"',meta='"+meta.getText()+"',fechaI='"+formato.format(fecha1)+"',fechaF='"+formato.format(fecha2)+"',cump='"+aux2+"',codP='"+cP.getText()+"',responsable='"+res.getText()+"',nominacion='"+nom.getSelectedItem().toString()+"' WHERE gestion='"+gest1.getText()+"' AND actividad='"+act1.getText()+"' AND producto='"+pro1.getText()+"' AND codP='"+cP1.getText()+"' AND responsable='"+res1.getText()+"' AND nominacion='"+nom1.getText()+"'");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, código del Proyecto,Actividad, Producto,gestión,nominación, y responsable del Proyecto DUPLICADOS"+sep+"O la cantidad de letras sobrepasa lo permitido para un determinado campo"+sep+"O los campos no coinciden con una Actividad valida NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
                 if(band==true){
                                try {
                                Statement st = cn.createStatement();
                                ResultSet rs = st.executeQuery("select * from evaluarppt WHERE ges='"+gest.getText()+"' AND act='"+act.getText()+"' AND pro='"+pro.getText()+"' AND cP='"+cP.getText()+"' AND res='"+res.getText()+"'AND nom='"+nom.getSelectedItem().toString()+"'");
                                    if (!(rs != null) || !(rs.next())) { 
                                                 try {
                                                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarppt(uno,dos,tres,cuatro,cinco,ges,act,pro,cP,res,nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                                                            Double aux3= 0.0;
                                                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                                                            pst3.setBigDecimal(1, aux4); 
                                                            pst3.setBigDecimal(2, aux4);
                                                            pst3.setBigDecimal(3, aux4);
                                                            pst3.setBigDecimal(4, aux4);
                                                            pst3.setBigDecimal(5, aux4);
                                                            pst3.setString(6, gest.getText());
                                                            pst3.setString(7, act.getText());
                                                            pst3.setString(8, pro.getText());
                                                            pst3.setString(9, cP.getText());
                                                            pst3.setString(10, res.getText());
                                                            pst3.setString(11, nom.getSelectedItem().toString());
                                                            pst3.executeUpdate();

                                                            }catch (Exception e) {
                                                                System.out.print(e.getMessage());
                                                            }
                                       } 
                                } catch (SQLException ex) {
                                Logger.getLogger(mProd.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                         }
                         if(band==true){
                                try {
                                Statement st = cn.createStatement();
                                ResultSet rs = st.executeQuery("select * from evaluarpst WHERE ges='"+gest.getText()+"' AND act='"+act.getText()+"' AND pro='"+pro.getText()+"' AND cP='"+cP.getText()+"' AND res='"+res.getText()+"'AND nom='"+nom.getSelectedItem().toString()+"'");
                                    if (!(rs != null) || !(rs.next())) { 
                                                 try {
                                                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarpst(uno,dos,tres,cuatro,cinco,ges,act,pro,cP,res,nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                                                            Double aux3= 0.0;
                                                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                                                            pst3.setBigDecimal(1, aux4); 
                                                            pst3.setBigDecimal(2, aux4);
                                                            pst3.setBigDecimal(3, aux4);
                                                            pst3.setBigDecimal(4, aux4);
                                                            pst3.setBigDecimal(5, aux4);
                                                            pst3.setString(6, gest.getText());
                                                            pst3.setString(7, act.getText());
                                                            pst3.setString(8, pro.getText());
                                                            pst3.setString(9, cP.getText());
                                                            pst3.setString(10, res.getText());
                                                            pst3.setString(11, nom.getSelectedItem().toString());
                                                            pst3.executeUpdate();

                                                            }catch (Exception e) {
                                                                System.out.print(e.getMessage());
                                                            }
                                       } 
                                } catch (SQLException ex) {
                                Logger.getLogger(mProd.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                         }
                         if(band==true){
                                try {
                                Statement st = cn.createStatement();
                                ResultSet rs = st.executeQuery("select * from evaluarptt WHERE ges='"+gest.getText()+"' AND act='"+act.getText()+"' AND pro='"+pro.getText()+"' AND cP='"+cP.getText()+"' AND res='"+res.getText()+"'AND nom='"+nom.getSelectedItem().toString()+"'");
                                    if (!(rs != null) || !(rs.next())) { 
                                                 try {
                                                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarptt(uno,dos,tres,cuatro,cinco,ges,act,pro,cP,res,nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                                                            Double aux3= 0.0;
                                                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                                                            pst3.setBigDecimal(1, aux4); 
                                                            pst3.setBigDecimal(2, aux4);
                                                            pst3.setBigDecimal(3, aux4);
                                                            pst3.setBigDecimal(4, aux4);
                                                            pst3.setBigDecimal(5, aux4);
                                                            pst3.setString(6, gest.getText());
                                                            pst3.setString(7, act.getText());
                                                            pst3.setString(8, pro.getText());
                                                            pst3.setString(9, cP.getText());
                                                            pst3.setString(10, res.getText());
                                                            pst3.setString(11, nom.getSelectedItem().toString());
                                                            pst3.executeUpdate();

                                                            }catch (Exception e) {
                                                                System.out.print(e.getMessage());
                                                            }
                                       } 
                                } catch (SQLException ex) {
                                Logger.getLogger(mProd.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                         }
                         if(band==true){
                                try {
                                Statement st = cn.createStatement();
                                ResultSet rs = st.executeQuery("select * from evaluarpef WHERE ges='"+gest.getText()+"' AND act='"+act.getText()+"' AND pro='"+pro.getText()+"' AND cP='"+cP.getText()+"' AND res='"+res.getText()+"'AND nom='"+nom.getSelectedItem().toString()+"'");
                                    if (!(rs != null) || !(rs.next())) { 
                                                 try {
                                                            PreparedStatement pst3 = cn.prepareStatement("INSERT INTO evaluarpef(uno,dos,tres,cuatro,cinco,ges,act,pro,cP,res,nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                                                            Double aux3= 0.0;
                                                            BigDecimal aux4= BigDecimal.valueOf(aux3);
                                                            pst3.setBigDecimal(1, aux4); 
                                                            pst3.setBigDecimal(2, aux4);
                                                            pst3.setBigDecimal(3, aux4);
                                                            pst3.setBigDecimal(4, aux4);
                                                            pst3.setBigDecimal(5, aux4);
                                                            pst3.setString(6, gest.getText());
                                                            pst3.setString(7, act.getText());
                                                            pst3.setString(8, pro.getText());
                                                            pst3.setString(9, cP.getText());
                                                            pst3.setString(10, res.getText());
                                                            pst3.setString(11, nom.getSelectedItem().toString());
                                                            pst3.executeUpdate();

                                                            }catch (Exception e) {
                                                                System.out.print(e.getMessage());
                                                            }
                                       } 
                                } catch (SQLException ex) {
                                Logger.getLogger(mProd.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                         }
                this.setVisible(false);
             }
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta,gestion,nominacion,responsable del proyecto, Producto, y Código del Proyecto, % de cumplimiento NO PUEDEN ESTAR VACIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botMActionPerformed

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

    private void proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyTyped
        if(pro.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
            pro.setText("");
            JOptionPane.showMessageDialog(null,"El número de letras sobrepasa lo permitido que es 190 letras" ,"",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_proKeyTyped

    private void indKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_indKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_indKeyPressed

    private void indKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_indKeyTyped
        if(ind.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_indKeyTyped

    private void lBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lBKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_lBKeyPressed

    private void lBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lBKeyTyped
        if(lB.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_lBKeyTyped

    private void metaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_metaKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_metaKeyPressed

    private void metaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_metaKeyTyped
        if(meta.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_metaKeyTyped

    private void cPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPKeyTyped
        if(cP.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cPKeyTyped

    private void resKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resKeyTyped
        if(res.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_resKeyTyped

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
        if(act.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea act;
    private javax.swing.JLabel act1;
    private javax.swing.JButton botM;
    private javax.swing.JTextField cP;
    private javax.swing.JLabel cP1;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gest;
    private javax.swing.JLabel gest1;
    private javax.swing.JTextArea ind;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea lB;
    private javax.swing.JTextArea meta;
    private javax.swing.JComboBox nom;
    private javax.swing.JLabel nom1;
    private javax.swing.JTextArea pro;
    private javax.swing.JLabel pro1;
    private javax.swing.JTextField res;
    private javax.swing.JLabel res1;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
 Connection cn= cc.conexion();
}
