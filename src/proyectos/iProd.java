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
public class iProd extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public iProd(java.awt.Frame parent, boolean modal) {
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
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6,String aux7,String aux8){
    gest.setText(aux1);
    act.setText(aux2);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux3));
    } catch (ParseException ex) {
        Logger.getLogger(iProd.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux4));
    } catch (ParseException ex) {
        Logger.getLogger(iProd.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux5);
    cP.setText(aux6);
    res.setText(aux7);
    nom.setSelectedItem(aux8);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pro = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ind = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lB = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        meta = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cP = new javax.swing.JTextField();
        res = new javax.swing.JTextField();
        botI = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        gest = new javax.swing.JTextField();
        nom = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cump = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 132, -1));

        jLabel1.setText("Producto:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 480, 49));

        jLabel2.setText("Indicador:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 480, 48));

        jLabel3.setText("Línea Base:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 480, 49));

        jLabel4.setText("Meta:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 480, 54));

        jLabel12.setText("Fecha de Inicio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 170, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 170, -1));

        jLabel14.setText("Fecha final:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        jLabel9.setText("Código del Proyecto:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jLabel10.setText("Responsable del Proyecto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        cP.setEditable(false);
        cP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPKeyTyped(evt);
            }
        });
        jPanel1.add(cP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 480, -1));

        res.setEditable(false);
        res.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resKeyTyped(evt);
            }
        });
        jPanel1.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 480, -1));

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("INSERTAR");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
            }
        });
        jPanel1.add(botI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 122, -1));

        jLabel11.setText("Gestión:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 39, -1, -1));

        gest.setEditable(false);
        gest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestKeyTyped(evt);
            }
        });
        jPanel1.add(gest, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 36, 150, -1));

        nom.setEnabled(false);
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 200, -1));

        jLabel20.setText("Nominación:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, -1, -1));

        jLabel13.setText("% de Cumplimiento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 105, -1));

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

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 62, 480, 49));

        jLabel5.setText("Actividad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 62, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band=true;
        if((nom.getSelectedItem().toString()).equals("")||act.getText().equals("")||gest.getText().equals("")||cP.getText().equals("")||pro.getText().equals("")||res.getText().equals("")||cump.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor, nominacion,gestion,actividad, el código del Proyecto, Producto, responsable del proyecto,% de cumplimiento NO PUEDEN ESTAR VACIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
                double aux1= Double.parseDouble(cump.getText());
                if(aux1<0||aux1>100){
                    JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
                }
                else{
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO producto(gestion,actividad,producto,indicador,lineaBase,meta,fechaI,fechaF,cump,mPT,mST,mTT,evaluacionF,codP,responsable,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, gest.getText());
                    pst.setString(2, act.getText());
                    pst.setString(3, pro.getText());
                    pst.setString(4, ind.getText());
                    pst.setString(5, lB.getText());
                    pst.setString(6, meta.getText());
                    pst.setString(7, formato.format(fecha1));
                    pst.setString(8, formato.format(fecha2));
                    Double aux3= Double.parseDouble(cump.getText());
                    Redondear r=new Redondear();
                    aux3=r.rD(aux3);
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    Double aux5= 0.0;
                    BigDecimal aux6= BigDecimal.valueOf(aux5);
                    pst.setBigDecimal(9,aux4);
                    pst.setBigDecimal(10,aux6);
                    pst.setBigDecimal(11,aux6);
                    pst.setBigDecimal(12,aux6);
                    pst.setBigDecimal(13,aux6);
                    pst.setString(14, cP.getText());
                    pst.setString(15, res.getText());
                    pst.setString(16, nom.getSelectedItem().toString());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    Logger.getLogger(iProd.class.getName()).log(Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, código del Proyecto, Actividad,Producto,gestión,nominación, y responsable del Proyecto DUPLICADOS"+sep+"O la cantidad de letras sobrepasa lo permitido para un determinado campo"+sep+"O los campos no coinciden con una Actividad valida NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
             if(band==true){
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
             if(band==true){
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
              if(band==true){
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
               if(band==true){
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
                if(band==true){
                            try {
                            PreparedStatement pst3 = cn.prepareStatement ("DELETE FROM producto WHERE gestion='"+gest.getText()+"' AND actividad='"+act.getText()+"' AND producto='"+""+"' AND codP='"+cP.getText()+"' AND responsable='"+res.getText()+"' AND nominacion='"+nom.getSelectedItem().toString()+"'");
                            pst3.executeUpdate();
                            } catch (Exception e) {
                            System.out.println(e.getMessage());
                            }
                }
                this.setVisible(false);
             }

        }
    }//GEN-LAST:event_botIActionPerformed

    private void proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyTyped
        if(pro.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
            pro.setText("");
            JOptionPane.showMessageDialog(null,"El número de letras sobrepasa lo permitido que es 190 letras" ,"",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_proKeyTyped

    private void indKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_indKeyTyped
         if(ind.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_indKeyTyped

    private void lBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lBKeyTyped
         if(lB.getText().length()>=190){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_lBKeyTyped

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

    private void gestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestKeyTyped
        if(gest.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestKeyTyped

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
       if(act.getText().length()>=190){
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea act;
    private javax.swing.JButton botI;
    private javax.swing.JTextField cP;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gest;
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
    private javax.swing.JTextArea pro;
    private javax.swing.JTextField res;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
 Connection cn= cc.conexion();
}
