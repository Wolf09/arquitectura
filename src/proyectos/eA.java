/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        botE = new javax.swing.JButton();
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
        jLabel13 = new javax.swing.JLabel();
        cump = new javax.swing.JTextField();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 132, -1));

        botE.setBackground(new java.awt.Color(0, 72, 225));
        botE.setForeground(new java.awt.Color(255, 255, 255));
        botE.setText("ELIMINAR");
        botE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEActionPerformed(evt);
            }
        });
        jPanel1.add(botE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 123, -1));

        jLabel3.setText("Gestión:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 22, -1, -1));

        gest.setEditable(false);
        gest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestKeyTyped(evt);
            }
        });
        jPanel1.add(gest, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 19, 160, -1));

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
        jScrollPane1.setViewportView(act);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 50, 330, 49));

        jLabel1.setText("Actividad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 50, -1, -1));

        fecI.setEnabled(false);
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, -1));

        jLabel12.setText("Fecha de Inicio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 117, -1, -1));

        fecF.setEnabled(false);
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 180, -1));

        jLabel14.setText("Fecha final:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 148, -1, -1));

        cP.setEditable(false);
        cP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPKeyTyped(evt);
            }
        });
        jPanel1.add(cP, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 210, 330, -1));

        jLabel9.setText("Código del Proyecto:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 213, -1, -1));

        res.setEditable(false);
        res.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resKeyTyped(evt);
            }
        });
        jPanel1.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 241, 330, -1));

        jLabel10.setText("Responsable del Proyecto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 244, -1, -1));

        nom.setEnabled(false);
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 210, -1));

        jLabel20.setText("Nominación:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 275, -1, -1));

        jLabel13.setText("% de Cumplimiento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        cump.setEditable(false);
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEActionPerformed
        try {
            PreparedStatement pst = cn.prepareStatement ("DELETE FROM actividad WHERE gestion='"+gest.getText()+"' AND actividad='"+act.getText()+"' AND codP='"+cP.getText()+"' AND responsable='"+res.getText()+"' AND nominacion='"+nom.getSelectedItem().toString()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        this.setVisible(false);
    }//GEN-LAST:event_botEActionPerformed

    private void gestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestKeyTyped
        if(gest.getText().length()==19){
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
    }//GEN-LAST:event_actKeyPressed

    private void actKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyTyped
        if(act.getText().length()==99){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyTyped

    private void cPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPKeyTyped
        if(cP.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cPKeyTyped

    private void resKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resKeyTyped
        if(res.getText().length()==79){
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
    private javax.swing.JButton botE;
    private javax.swing.JTextField cP;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gest;
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
    private javax.swing.JTextField res;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
 Connection cn= cc.conexion();
}
