/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investigacion;

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
public class eA extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public eA(java.awt.Frame parent, boolean modal) {
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
        this.setTitle("AUXILIAR");
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
    public String getpro(){
    return pro.getText();
    }
    public String getcodAT(){
    return codAT.getText();
    }
  public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6, String aux7,String aux8, String aux9,String aux10,String aux11,String aux12,String aux13,String aux14,String aux15,String aux16){
    gestion.setText(aux1);
    codA.setText(aux2);
    grado.setSelectedItem(aux3);
    aA.setText(aux4);
    nA.setText(aux5);
    telf.setText(aux6);
    email.setText(aux7);
    poa.setText(aux8);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux9));
    } catch (ParseException ex) {
        Logger.getLogger(mA.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux10));
    } catch (ParseException ex) {
        Logger.getLogger(mA.class.getName()).log(Level.SEVERE, null, ex);
    }
    pro.setText(aux11);
    resR.setText(aux12);
    cump.setText(aux13);
    nota.setText(aux14);
    areaT.setText(aux15);
    codAT.setText(aux16);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        resR = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        codAT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        poa = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        pro = new javax.swing.JTextArea();
        nota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaT = new javax.swing.JTextArea();
        botE = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        codA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        aA = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        nA = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        telf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cump = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 132, -1));

        jLabel7.setText("P.O.A. (actividad propuesta):");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        fecI.setEnabled(false);
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 254, 168, -1));

        jLabel8.setText("fecha de Inicio:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        fecF.setEnabled(false);
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 280, 168, -1));

        jLabel9.setText("fecha Final:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jLabel11.setText("Producto:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jLabel13.setText("Responsable de revisión:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        resR.setEditable(false);
        resR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resRKeyTyped(evt);
            }
        });
        jPanel1.add(resR, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 359, 400, -1));

        jLabel14.setText("Nota de Ponderación:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        codAT.setEditable(false);
        codAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codATKeyTyped(evt);
            }
        });
        jPanel1.add(codAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 475, 400, -1));

        jLabel16.setText("Código de Área Temática:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        poa.setEditable(false);
        poa.setColumns(20);
        poa.setLineWrap(true);
        poa.setRows(5);
        poa.setWrapStyleWord(true);
        poa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                poaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                poaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(poa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 209, 400, 39));

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
        jScrollPane2.setViewportView(pro);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 311, 400, 42));

        nota.setEditable(false);
        nota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                notaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notaKeyTyped(evt);
            }
        });
        jPanel1.add(nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 105, -1));

        jLabel6.setText("Área Tematica:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

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
        jScrollPane3.setViewportView(areaT);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 421, 400, 44));

        botE.setBackground(new java.awt.Color(0, 72, 225));
        botE.setForeground(new java.awt.Color(255, 255, 255));
        botE.setText("ELIMINAR");
        botE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEActionPerformed(evt);
            }
        });
        jPanel1.add(botE, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 123, -1));

        jLabel5.setText("gestión:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        gestion.setEditable(false);
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 19, 171, -1));

        codA.setEditable(false);
        codA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codAKeyTyped(evt);
            }
        });
        jPanel1.add(codA, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 50, 400, -1));

        jLabel1.setText("Codigo Auxiliar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        grado.setEnabled(false);
        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 79, 164, -1));

        jLabel2.setText("Grado de instrucción del Auxiliar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        aA.setEditable(false);
        aA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aAKeyTyped(evt);
            }
        });
        jPanel1.add(aA, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 105, 400, -1));

        jLabel19.setText("Apellidos:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        nA.setEditable(false);
        nA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nAKeyTyped(evt);
            }
        });
        jPanel1.add(nA, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 131, 400, -1));

        jLabel20.setText("Nombres:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        telf.setEditable(false);
        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });
        jPanel1.add(telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 157, 400, -1));

        jLabel4.setText("teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        email.setEditable(false);
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 183, 400, -1));

        jLabel3.setText("email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        cump.setEditable(false);
        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 390, 105, -1));

        jLabel10.setText("% de Cumplimiento:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void resRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resRKeyTyped
        if(resR.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_resRKeyTyped

    private void codATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codATKeyTyped
        if(codAT.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codATKeyTyped

    private void notaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notaKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(nota.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_notaKeyPressed

    private void notaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notaKeyTyped
        char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(nota.getText().contains(".")){
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
            if (nota.getText().equals("")){
                nota.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    nota.setText(nota.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(nota.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_notaKeyTyped

    private void poaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_poaKeyTyped
        if(poa.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_poaKeyTyped

    private void areaTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTKeyTyped
        if(areaT.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_areaTKeyTyped

    private void poaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_poaKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_poaKeyPressed

    private void proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyTyped
       if(pro.getText().length()==69){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyTyped

    private void proKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_proKeyPressed

    private void areaTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_areaTKeyPressed

    private void botEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEActionPerformed
        try {
            PreparedStatement pst = cn.prepareStatement ("DELETE FROM auxiliari WHERE gestion='"+gestion.getText()+"' AND codAux='"+codA.getText()+"' AND producto='"+pro.getText()+"' AND codigoAT='"+codAT.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        this.setVisible(false);
    }//GEN-LAST:event_botEActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void codAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codAKeyTyped
        if(codA.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codAKeyTyped

    private void aAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aAKeyTyped
        if(aA.getText().length()==31){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aAKeyTyped

    private void nAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nAKeyTyped
        if(nA.getText().length()==31){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nAKeyTyped

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        if(telf.getText().length()==51){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_telfKeyTyped

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
    private javax.swing.JTextField aA;
    private javax.swing.JTextArea areaT;
    private javax.swing.JButton botE;
    private javax.swing.JTextField codA;
    private javax.swing.JTextField codAT;
    private javax.swing.JTextField cump;
    private javax.swing.JTextField email;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTextField nA;
    private javax.swing.JTextField nota;
    private javax.swing.JTextArea poa;
    private javax.swing.JTextArea pro;
    private javax.swing.JTextField resR;
    private javax.swing.JTextField telf;
    // End of variables declaration//GEN-END:variables
Conexion3 cc= new Conexion3();
 Connection cn= cc.conexion();
}
