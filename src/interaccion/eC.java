/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion;
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
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class eC extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public eC(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        this.setTitle("CONVENIOS");
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
    public String getinst(){
    return inst.getText();
    }
    public String getcP(){
    return cP.getText();
    }
    public String getcodPro(){
    return codPro.getText();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6, String aux7,String aux8, String aux9,String aux10,String aux11,String aux12,String aux13,String aux14,String aux15){
    gestion.setText(aux1);
    inst.setText(aux2);
    cP.setText(aux3);
    grado.setSelectedItem(aux4);
    aP.setText(aux5);
    nP.setText(aux6);
    email.setText(aux7);
    telf.setText(aux8);
    eje.setText(aux9);
    linea.setText(aux10);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux11));
    } catch (ParseException ex) {
        Logger.getLogger(mC.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux12));
    } catch (ParseException ex) {
        Logger.getLogger(mC.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux13);
    pro.setText(aux14);
    codPro.setText(aux15);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eje = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        linea = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pro = new javax.swing.JTextArea();
        codPro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cump = new javax.swing.JTextField();
        botE = new javax.swing.JButton();
        gestion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inst = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        aP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        telf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "ELIMINAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 72, 225));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 569, 132, -1));

        jLabel5.setText("eje:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 270, -1, -1));

        eje.setEditable(false);
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
        jScrollPane2.setViewportView(eje);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 410, 36));

        jLabel8.setText("Línea:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 317, -1, -1));

        linea.setEditable(false);
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
        jScrollPane3.setViewportView(linea);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 317, 410, 40));

        jLabel9.setText("Fecha de Inicio:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 369, -1, -1));

        fecI.setEnabled(false);
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 190, -1));

        jLabel11.setText("Fecha Final:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 395, -1, -1));

        fecF.setEnabled(false);
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 190, -1));

        jLabel12.setText("% de cumplimiento:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 418, -1, -1));

        jLabel13.setText("Proyecto:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 446, -1, -1));

        pro.setEditable(false);
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
        jScrollPane4.setViewportView(pro);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 446, 410, 41));

        codPro.setEditable(false);
        codPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codProKeyTyped(evt);
            }
        });
        jPanel1.add(codPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 493, 410, -1));

        jLabel14.setText("Código del Proyecto:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 496, -1, -1));

        cump.setEditable(false);
        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 105, -1));

        botE.setBackground(new java.awt.Color(0, 72, 225));
        botE.setForeground(new java.awt.Color(255, 255, 255));
        botE.setText("ELIMINAR");
        botE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEActionPerformed(evt);
            }
        });
        jPanel1.add(botE, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 569, 123, -1));

        gestion.setEditable(false);
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 190, -1));

        jLabel4.setText("Gestión:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 33, -1, -1));

        inst.setEditable(false);
        inst.setColumns(20);
        inst.setLineWrap(true);
        inst.setRows(5);
        inst.setWrapStyleWord(true);
        inst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                instKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                instKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(inst);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 61, 410, 42));

        jLabel1.setText("Institución de Convenio:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 61, -1, -1));

        cP.setEditable(false);
        cP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPKeyTyped(evt);
            }
        });
        jPanel1.add(cP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 109, 410, -1));

        jLabel10.setText("Codigo del Postulante:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 112, -1, -1));

        grado.setEnabled(false);
        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 135, 200, -1));

        jLabel6.setText("Grado de Instruccion del Postulante:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 138, -1, -1));

        aP.setEditable(false);
        aP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aPKeyTyped(evt);
            }
        });
        jPanel1.add(aP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 161, 410, -1));

        jLabel7.setText("Apellidos:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 164, -1, -1));

        nP.setEditable(false);
        nP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nPKeyTyped(evt);
            }
        });
        jPanel1.add(nP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 187, 410, -1));

        jLabel15.setText("Nombres:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 190, -1, -1));

        email.setEditable(false);
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 213, 410, -1));

        jLabel2.setText("email:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 216, -1, -1));

        telf.setEditable(false);
        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jPanel1.add(telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 239, 410, -1));

        jLabel3.setText("Teléfono:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 242, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
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

    private void codProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codProKeyTyped
        if(codPro.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codProKeyTyped

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

    private void ejeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ejeKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
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
    }//GEN-LAST:event_lineaKeyPressed

    private void proKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyPressed

    private void ejeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ejeKeyTyped
        if(eje.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_ejeKeyTyped

    private void lineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lineaKeyTyped
        if(linea.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_lineaKeyTyped

    private void proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyTyped
        if(pro.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyTyped

    private void botEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEActionPerformed
        try {
            PreparedStatement pst = cn.prepareStatement ("DELETE FROM convenios WHERE gestion='"+gestion.getText()+"' AND institucion='"+inst.getText()+"' AND codP='"+cP.getText()+"' AND codigoP='"+codPro.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        this.setVisible(false);
    }//GEN-LAST:event_botEActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void instKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_instKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_instKeyPressed

    private void instKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_instKeyTyped
        if(inst.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_instKeyTyped

    private void cPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPKeyTyped
        if(cP.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cPKeyTyped

    private void aPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aPKeyTyped
        if(aP.getText().length()==31){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aPKeyTyped

    private void nPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nPKeyTyped
        if(nP.getText().length()==31){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nPKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        if(email.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_emailKeyTyped

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        if(telf.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_telfKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aP;
    private javax.swing.JButton botE;
    private javax.swing.JTextField cP;
    private javax.swing.JTextField codPro;
    private javax.swing.JTextField cump;
    private javax.swing.JTextArea eje;
    private javax.swing.JTextField email;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JTextArea inst;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea linea;
    private javax.swing.JTextField nP;
    private javax.swing.JTextArea pro;
    private javax.swing.JTextField telf;
    // End of variables declaration//GEN-END:variables
Conexion4 cc= new Conexion4();
 Connection cn= cc.conexion();
}
