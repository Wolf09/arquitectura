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
public class mA extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public mA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gest);
        SpellChecker.register(act);
        SpellChecker.register(res);
        SpellChecker.register(cP);
        nom.addItem("POA");
        nom.addItem("PEI");
        nom.addItem("ACREDITACIÓN");
        nom.addItem("IDH");
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
        act1.setVisible(false);
        nom1.setVisible(false);
        res1.setVisible(false);
        gest1.setVisible(false);
        cP1.setVisible(false);
    }

    public String getgest(){
    return gest.getText();
    }
    public String getact(){
    return act.getText();
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
        Logger.getLogger(mA.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux4));
    } catch (ParseException ex) {
        Logger.getLogger(mA.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux5);
    cP.setText(aux6);
    res.setText(aux7);
    nom.setSelectedItem(aux8);
    act1.setText(aux2);
    nom1.setText(aux8);
    res1.setText(aux7);
    gest1.setText(aux1);
    cP1.setText(aux6);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        act1 = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();
        botM = new javax.swing.JButton();
        res1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
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
        gest1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cump = new javax.swing.JTextField();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 132, -1));
        jPanel1.add(act1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 310, 547, 23));
        jPanel1.add(nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 344, 547, 25));

        botM.setBackground(new java.awt.Color(0, 72, 225));
        botM.setForeground(new java.awt.Color(255, 255, 255));
        botM.setText("MODIFICAR");
        botM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botMActionPerformed(evt);
            }
        });
        jPanel1.add(botM, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 125, -1));
        jPanel1.add(res1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 380, 547, 21));

        jLabel3.setText("Gestión:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 22, -1, -1));

        gest.setEditable(false);
        gest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestKeyTyped(evt);
            }
        });
        jPanel1.add(gest, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 19, 160, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 50, 340, 49));

        jLabel1.setText("Actividad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 50, -1, -1));
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, -1));

        jLabel12.setText("Fecha de Inicio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 117, -1, -1));
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 180, -1));

        jLabel14.setText("Fecha final:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 148, -1, -1));

        cP.setEditable(false);
        cP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPKeyTyped(evt);
            }
        });
        jPanel1.add(cP, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 210, 340, -1));

        jLabel9.setText("Código del Proyecto:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        res.setEditable(false);
        res.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resKeyTyped(evt);
            }
        });
        jPanel1.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 241, 340, -1));

        jLabel10.setText("Responsable del Proyecto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        nom.setEnabled(false);
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 190, -1));

        jLabel20.setText("Nominación:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));
        jPanel1.add(cP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 412, 255, 23));
        jPanel1.add(gest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 412, 282, 23));

        jLabel13.setText("% de Cumplimiento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 182, -1, -1));

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 105, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
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
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha3 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band =true;
        if(!((nom.getSelectedItem().toString()).equals(""))&&!(gest.getText().equals(""))&&!(res.getText().equals(""))&&!(act.getText().equals(""))&&!(cP.getText().equals(""))&&!(cump.getText().equals(""))){
            Double aux1= Double.parseDouble(cump.getText());
          if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
             }
          else{
                Redondear r=new Redondear();
                aux1=r.rD(aux1);
                 BigDecimal aux2= BigDecimal.valueOf(aux1);
            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE actividad SET gestion='"+gest.getText()+"',actividad='"+act.getText()+"',fechaI='"+formato.format(fecha1)+"',fechaF='"+formato.format(fecha2)+"',cump='"+aux2+"',codP='"+cP.getText()+"',responsable='"+res.getText()+"',nominacion='"+nom.getSelectedItem().toString()+"' WHERE gestion='"+gest1.getText()+"' AND actividad='"+act1.getText()+"' AND codP='"+cP1.getText()+"' AND responsable='"+res1.getText()+"' AND nominacion='"+nom1.getText()+"'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, código del Proyecto, Actividad,gestión,nominación, y responsable del Proyecto DUPLICADOS"+sep+"O la cantidad de letras sobrepasa lo permitido para un determinado campo"+sep+"O los campos no coinciden con un proyecto valido NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                band=false;
            }
            if(band==true){
                        try {
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("select * from producto where gestion='"+gest.getText()+"' AND actividad='"+act.getText()+"' AND codP='"+cP.getText()+"' AND responsable='"+res.getText()+"' AND nominacion='"+nom.getSelectedItem().toString()+"'");
                            if (!(rs != null) || !(rs.next())) { 
                               try {
                                        PreparedStatement pst2 = cn.prepareStatement("INSERT INTO producto(gestion,actividad,producto,indicador,lineaBase,meta,fechaI,fechaF,cump,mPT,mST,mTT,evaluacionF,codP,responsable,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");   
                                        pst2.setString(1, gest.getText());
                                        pst2.setString(2, act.getText());
                                        pst2.setString(3, "");
                                        pst2.setString(4, "");
                                        pst2.setString(5, "");
                                        pst2.setString(6, "");
                                        pst2.setString(7, formato.format(fecha3));
                                        pst2.setString(8, formato.format(fecha3));
                                        Double aux3= 0.0;
                                        BigDecimal aux4= BigDecimal.valueOf(aux3);
                                        Double aux5= 0.0;
                                        BigDecimal aux6= BigDecimal.valueOf(aux5);
                                        pst2.setBigDecimal(9,aux4);
                                        pst2.setBigDecimal(10,aux6);
                                        pst2.setBigDecimal(11,aux6);
                                        pst2.setBigDecimal(12,aux6);
                                        pst2.setBigDecimal(13,aux6);
                                        pst2.setString(14, cP.getText());
                                        pst2.setString(15, res.getText());
                                        pst2.setString(16, nom.getSelectedItem().toString());
                                        pst2.executeUpdate();
                                        } catch (Exception e) {
                                            System.out.print(e.getMessage());
                                        }
                         } 
                    } catch (SQLException ex) {
                    Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            this.setVisible(false);
          }
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta,gestion,nominacion,responsable del proyecto, Actividad,Código del Proyecto,% de cumplimiento NO PUEDEN ESTAR VACIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botMActionPerformed

    private void gestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestKeyTyped
        if(gest.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestKeyTyped

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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox nom;
    private javax.swing.JLabel nom1;
    private javax.swing.JTextField res;
    private javax.swing.JLabel res1;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
 Connection cn= cc.conexion();
}
