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
public class mP extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public mP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gest);
        SpellChecker.register(monto);
        SpellChecker.register(res);
        SpellChecker.register(rec);
        SpellChecker.register(codPro);
        SpellChecker.register(pro);
        cNO.addItem("SI");
        cNO.addItem("NO");
        cET.addItem("SI");
        cET.addItem("NO");
        cET.addItem("En Ejecución");
        nom.addItem("POA");
        nom.addItem("PEI");
        nom.addItem("ACREDITACIÓN");
        nom.addItem("IDH");
        this.setTitle("PROYECTO");
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
        codPro1.setVisible(false);
        res1.setVisible(false);
        gest1.setVisible(false);
        nom1.setVisible(false);
    }

    public String getgest(){
    return gest.getText();
    }
    public String getcodPro(){
    return codPro.getText();
    }
    public String getres(){
    return res.getText();
    }
    public String getnom(){
    return nom.getSelectedItem().toString();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6,String aux7, String aux8, String aux9,String aux10, String aux11,String aux12){
    gest.setText(aux1);
    codPro.setText(aux2);
    pro.setText(aux3);
       SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux4));
    } catch (ParseException ex) {
        Logger.getLogger(mP.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux5));
    } catch (ParseException ex) {
        Logger.getLogger(mP.class.getName()).log(Level.SEVERE, null, ex);
    }
    monto.setText(aux6);
    res.setText(aux7);
    cump.setText(aux8);
    cNO.setSelectedItem(aux9);
    cET.setSelectedItem(aux10);
    rec.setText(aux11);
    nom.setSelectedItem(aux12);
    codPro1.setText(aux2);
    res1.setText(aux7);
    gest1.setText(aux1);
    nom1.setText(aux12);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        gest = new javax.swing.JTextField();
        codPro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pro = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        res = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cNO = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cET = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rec = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        nom = new javax.swing.JComboBox();
        cump = new javax.swing.JTextField();
        monto = new javax.swing.JTextField();
        codPro1 = new javax.swing.JLabel();
        res1 = new javax.swing.JLabel();
        botM = new javax.swing.JButton();
        gest1 = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 132, -1));

        jLabel1.setText("Gestión:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 22, -1, -1));

        gest.setEditable(false);
        gest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestKeyTyped(evt);
            }
        });
        jPanel1.add(gest, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 19, 160, -1));

        codPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codProKeyTyped(evt);
            }
        });
        jPanel1.add(codPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 45, 380, -1));

        jLabel6.setText("código Proyecto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 48, -1, -1));

        jLabel2.setText("Proyecto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 76, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 76, 380, 47));

        jLabel12.setText("Fecha de Inicio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 131, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 170, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 170, -1));

        jLabel14.setText("Fecha final:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 163, -1, -1));

        jLabel15.setText("Monto:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 189, -1, -1));

        jLabel16.setText("Responsable:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 217, -1, -1));

        res.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resKeyTyped(evt);
            }
        });
        jPanel1.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 214, 380, -1));

        jLabel3.setText("% de Cumplimiento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 248, -1, -1));

        jLabel19.setText("Continua en la siguiente Gestión:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 279, -1, -1));

        jPanel1.add(cNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 112, -1));

        jLabel5.setText("Cumplido en Tiempo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 310, -1, -1));

        jPanel1.add(cET, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 180, -1));

        jLabel7.setText("Recomendaciones:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 338, -1, -1));

        rec.setColumns(20);
        rec.setLineWrap(true);
        rec.setRows(5);
        rec.setWrapStyleWord(true);
        rec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                recKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                recKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(rec);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 338, 380, 77));

        jLabel20.setText("Nominación:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 424, -1, -1));

        nom.setEnabled(false);
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 200, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 105, -1));

        monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                montoKeyTyped(evt);
            }
        });
        jPanel1.add(monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 183, 380, -1));
        jPanel1.add(codPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 452, 580, 22));
        jPanel1.add(res1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 485, 580, 21));

        botM.setBackground(new java.awt.Color(0, 72, 225));
        botM.setForeground(new java.awt.Color(255, 255, 255));
        botM.setText("MODIFICAR");
        botM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botMActionPerformed(evt);
            }
        });
        jPanel1.add(botM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 125, -1));
        jPanel1.add(gest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 517, 580, 22));
        jPanel1.add(nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 550, 580, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void gestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestKeyTyped
        if(gest.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestKeyTyped

    private void codProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codProKeyTyped
        if(codPro.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codProKeyTyped

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

    private void proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyTyped
        if(pro.getText().length()==200){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyTyped

    private void montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoKeyTyped
        if(monto.getText().length()==50){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_montoKeyTyped

    private void recKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recKeyTyped
       if(rec.getText().length()==240){
            evt.consume();
           getToolkit().beep();
        }
    }//GEN-LAST:event_recKeyTyped

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

    private void recKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_recKeyPressed

    private void botMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botMActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha3 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band =true;
        if(!((nom.getSelectedItem().toString()).equals(""))&&!(gest.getText().equals(""))&&!(res.getText().equals(""))&&!(codPro.getText().equals(""))&&!(cump.getText().equals(""))){
            Double aux1= Double.parseDouble(cump.getText());
            if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                Redondear r=new Redondear();
                aux1=r.rD(aux1);
                BigDecimal aux2= BigDecimal.valueOf(aux1);
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE proyecto SET gestion='"+gest.getText()+"',codP='"+codPro.getText()+"', nombreP='"+pro.getText()+"',fechaI='"+formato.format(fecha1)+"',fechaF='"+formato.format(fecha2)+"',monto='"+monto.getText()+"',responsable='"+res.getText()+"',cump='"+aux2+"',contoNO='"+cNO.getSelectedItem().toString()+"',cET='"+cET.getSelectedItem().toString()+"',recomendacion='"+rec.getText()+"',nominacion='"+nom.getSelectedItem().toString()+"' WHERE gestion='"+gest1.getText()+"' AND codP='"+codPro1.getText()+"' AND responsable='"+res1.getText()+"' AND nominacion='"+nom1.getText()+"'");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Proyecto, Responsable,gestión, nominación DUPLICADOS"+sep+"O la cantidad de letras sobrepasa lo permitido para un determinado campo"+sep+"O los campos gestion,nominacion no coinciden con institucional NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
                if(band==true){
                        try {
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("select * from actividad where gestion='"+gest.getText()+"' AND codP='"+codPro.getText()+"' AND responsable='"+res.getText()+"' AND nominacion='"+nom.getSelectedItem().toString()+"'");
                            if (!(rs != null) || !(rs.next())) { 
                             try {
                                        PreparedStatement pst2 = cn.prepareStatement("INSERT INTO actividad(gestion,actividad,fechaI,fechaF,cump,mPT,mST,mTT,evaluacionF,codP,responsable,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");   
                                        pst2.setString(1,gest.getText());
                                        pst2.setString(2,"");
                                        pst2.setString(3,formato.format(fecha3));
                                        pst2.setString(4,formato.format(fecha3));
                                        Double aux7=0.0;
                                        BigDecimal aux8= BigDecimal.valueOf(aux7);
                                        pst2.setBigDecimal(5, aux8);
                                        pst2.setBigDecimal(6, aux8);
                                        pst2.setBigDecimal(7, aux8);
                                        pst2.setBigDecimal(8, aux8);
                                        pst2.setBigDecimal(9, aux8);
                                        pst2.setString(10,codPro.getText());
                                        pst2.setString(11,res.getText());
                                        pst2.setString(12,nom.getSelectedItem().toString());
                                        pst2.executeUpdate();
                                        } catch (Exception e) {
                                            System.out.print(e.getMessage());
                                        }
                         } 
                    } catch (SQLException ex) {
                    Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                this.setVisible(false);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, gestion,nominacion,Código del Proyecto, Responsable, % de Cumplimiento NO PUEDEN ESTAR VACIOS NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botMActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botM;
    private javax.swing.JComboBox<String> cET;
    private javax.swing.JComboBox cNO;
    private javax.swing.JTextField codPro;
    private javax.swing.JLabel codPro1;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gest;
    private javax.swing.JLabel gest1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField monto;
    private javax.swing.JComboBox nom;
    private javax.swing.JLabel nom1;
    private javax.swing.JTextArea pro;
    private javax.swing.JTextArea rec;
    private javax.swing.JTextField res;
    private javax.swing.JLabel res1;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
 Connection cn= cc.conexion();
}
