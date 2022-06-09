/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;
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
public class eS extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public eS(java.awt.Frame parent, boolean modal) {
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
        this.setTitle("SUB-ACTIVIDAD");
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
    public String getcA(){
    return cA.getText();
    }
    public String getact(){
    return act.getText();
    }
    public String getsubA(){
    return subA.getText();
    }
  public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6,String aux7,String aux8,String aux9,String aux10){
    gestion.setText(aux1);
    cA.setText(aux2);
    grado.setSelectedItem(aux3);
    aA.setText(aux4);
    nA.setText(aux5);
    act.setText(aux6);
    subA.setText(aux7);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecI.setDate(formato.parse(aux8));
    } catch (ParseException ex) {
        Logger.getLogger(mS.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecF.setDate(formato.parse(aux9));
    } catch (ParseException ex) {
        Logger.getLogger(mS.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux10);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        aA = new javax.swing.JTextField();
        nA = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subA = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        fecI = new com.toedter.calendar.JDateChooser();
        fecF = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cump = new javax.swing.JTextField();
        botE2 = new javax.swing.JButton();

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 473, 132, -1));

        jLabel1.setText("Gestión:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 22, -1, -1));

        gestion.setEditable(false);
        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });
        jPanel1.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 19, 150, -1));

        jLabel2.setText("Código del Administrativo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 53, -1, -1));

        cA.setEditable(false);
        jPanel1.add(cA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 520, -1));

        jLabel3.setText("Grado de instruc. del Adm.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 84, -1, -1));

        grado.setEnabled(false);
        jPanel1.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 81, 140, -1));

        jLabel16.setText("Apellidos:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 115, -1, -1));

        aA.setEditable(false);
        aA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aAKeyTyped(evt);
            }
        });
        jPanel1.add(aA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 112, 520, -1));

        nA.setEditable(false);
        nA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nAKeyTyped(evt);
            }
        });
        jPanel1.add(nA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 143, 520, -1));

        jLabel17.setText("Nombres:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 146, -1, -1));

        jLabel5.setText("Actividad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 174, -1, -1));

        act.setEditable(false);
        act.setColumns(20);
        act.setLineWrap(true);
        act.setRows(5);
        act.setWrapStyleWord(true);
        jScrollPane1.setViewportView(act);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 174, 520, 41));

        jLabel6.setText("Sub-Actividad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 229, -1, -1));

        subA.setEditable(false);
        subA.setColumns(20);
        subA.setLineWrap(true);
        subA.setRows(5);
        subA.setWrapStyleWord(true);
        jScrollPane2.setViewportView(subA);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 229, 520, 46));

        jLabel7.setText("fecha de Inicio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 292, -1, -1));

        fecI.setEnabled(false);
        jPanel1.add(fecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 140, -1));

        fecF.setEnabled(false);
        jPanel1.add(fecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 140, -1));

        jLabel8.setText("Fecha Final:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 330, -1, -1));

        jLabel9.setText("% de cumplimiento:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 358, -1, -1));

        cump.setEditable(false);
        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });
        jPanel1.add(cump, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 105, -1));

        botE2.setBackground(new java.awt.Color(0, 72, 225));
        botE2.setForeground(new java.awt.Color(255, 255, 255));
        botE2.setText("ELIMINAR");
        botE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botE2ActionPerformed(evt);
            }
        });
        jPanel1.add(botE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 473, 131, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==8){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void aAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aAKeyTyped
        if(aA.getText().length()==36){
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

    private void botE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botE2ActionPerformed
        try {
            PreparedStatement pst = cn.prepareStatement ("DELETE FROM subactividades WHERE gestion='"+gestion.getText()+"' AND codA='"+cA.getText()+"' AND act='"+act.getText()+"' AND subA='"+subA.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        this.setVisible(false);
    }//GEN-LAST:event_botE2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aA;
    private javax.swing.JTextArea act;
    private javax.swing.JButton botE2;
    private javax.swing.JTextField cA;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecF;
    private com.toedter.calendar.JDateChooser fecI;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nA;
    private javax.swing.JTextArea subA;
    // End of variables declaration//GEN-END:variables
Conexion6 cc= new Conexion6();
 Connection cn= cc.conexion();
}
