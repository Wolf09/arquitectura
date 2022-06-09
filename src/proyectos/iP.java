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
public class iP extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public iP(java.awt.Frame parent, boolean modal) {
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
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6,String aux7,String aux8,String aux9){
    gest.setText(aux1);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux2));
    } catch (ParseException ex) {
        Logger.getLogger(iP.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux3));
    } catch (ParseException ex) {
        Logger.getLogger(iP.class.getName()).log(Level.SEVERE, null, ex);
    }
    monto.setText(aux4);
    res.setText(aux5);
    cump.setText(aux6);
    cNO.setSelectedItem(aux7);
    cET.setSelectedItem(aux8);
    nom.setSelectedItem(aux9);
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
        botI = new javax.swing.JButton();
        monto = new javax.swing.JTextField();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, 120, -1));

        jLabel1.setText("Gestión:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 22, -1, -1));

        gest.setEditable(false);
        gest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestKeyTyped(evt);
            }
        });
        jPanel1.add(gest, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 19, 150, -1));

        codPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codProKeyTyped(evt);
            }
        });
        jPanel1.add(codPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 45, 470, -1));

        jLabel6.setText("código Proyecto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 48, -1, -1));

        jLabel2.setText("Proyecto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 76, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 76, 470, 47));

        jLabel12.setText("Fecha de Inicio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 131, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 170, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 170, -1));

        jLabel14.setText("Fecha final:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 163, -1, -1));

        jLabel15.setText("Monto:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 189, -1, -1));

        jLabel16.setText("Responsable:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 217, -1, -1));

        res.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resKeyTyped(evt);
            }
        });
        jPanel1.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 214, 470, -1));

        jLabel3.setText("% de Cumplimiento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 248, -1, -1));

        jLabel19.setText("Continua en la siguiente Gestión:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 279, -1, -1));

        jPanel1.add(cNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 112, -1));

        jLabel5.setText("Cumplido en Tiempo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 310, -1, -1));

        jPanel1.add(cET, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 180, -1));

        jLabel7.setText("Recomendaciones:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 338, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 338, 470, 77));

        jLabel20.setText("Nominación:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 429, -1, -1));

        nom.setEnabled(false);
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 200, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 105, -1));

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("INSERTAR");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
            }
        });
        jPanel1.add(botI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 120, -1));

        monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                montoKeyTyped(evt);
            }
        });
        jPanel1.add(monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 183, 470, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
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

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha1= fecI.getDate();
        Date fecha2= fecF.getDate();
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha3 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band= true;
        if((nom.getSelectedItem().toString()).equals("")||gest.getText().equals("")||codPro.getText().equals("")||res.getText().equals("")||cump.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor, codigo del Proyecto, el responsable, % de cumplimiento, nominación, gestión NO PUEDEN ESTAR VACIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            double aux1= Double.parseDouble(cump.getText());
            if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO proyecto(gestion,codP,nombreP,fechaI,fechaF,monto,responsable,cump,mPT,mST,mTT,evaluacionF,contoNO,cET,recomendacion,recurso,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, gest.getText());
                pst.setString(2, codPro.getText());
                pst.setString(3, pro.getText());
                pst.setString(4, formato.format(fecha1));
                pst.setString(5, formato.format(fecha2));
                pst.setString(6, monto.getText());
                pst.setString(7, res.getText());
                Double aux3= Double.parseDouble(cump.getText());
                Redondear r=new Redondear();
                aux3=r.rD(aux3);
                BigDecimal aux4= BigDecimal.valueOf(aux3);
                Double aux5=0.0;
                BigDecimal aux6= BigDecimal.valueOf(aux5); 
                pst.setBigDecimal(8, aux4);
                pst.setBigDecimal(9, aux6);
                pst.setBigDecimal(10, aux6);
                pst.setBigDecimal(11, aux6);
                pst.setBigDecimal(12, aux6);
                pst.setString(13, cNO.getSelectedItem().toString());
                pst.setString(14, cET.getSelectedItem().toString());
                pst.setString(15, rec.getText());
                pst.setString(16, "");
                pst.setString(17, nom.getSelectedItem().toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Proyecto, Responsable,gestión, nominación DUPLICADOS"+sep+"O la cantidad de letras sobrepasa lo permitido para un determinado campo"+sep+"O los campos gestion,nominacion no coinciden con institucional NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band= false;
                }
                if(band==true){
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
                     if(band==true){
                            try {
                            PreparedStatement pst3 = cn.prepareStatement ("DELETE FROM proyecto WHERE gestion='"+gest.getText()+"' AND codP='"+""+"' AND responsable='"+""+"' AND nominacion='"+nom.getSelectedItem().toString()+"'");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botI;
    private javax.swing.JComboBox<String> cET;
    private javax.swing.JComboBox cNO;
    private javax.swing.JTextField codPro;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gest;
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
    private javax.swing.JTextArea pro;
    private javax.swing.JTextArea rec;
    private javax.swing.JTextField res;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
 Connection cn= cc.conexion();
}
