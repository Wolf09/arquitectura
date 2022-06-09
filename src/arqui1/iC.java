/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class iC extends javax.swing.JDialog {
private Bien icono2;
private Advertencia icono;
    public iC(java.awt.Frame parent, boolean modal) {
        super(parent, true);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(nomCarr);
        SpellChecker.register(codCarr);
        SpellChecker.register(gestion);
        this.setTitle("CARRERA");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2=new Bien();
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    
    public String getcodCarr(){
        return codCarr.getText();
    }
    public String getgestion(){
        return gestion.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        codCarr = new javax.swing.JTextField();
        nomCarr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        botInser = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 170, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "INSERTAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Código de Carrera:");

        codCarr.setColumns(20);
        codCarr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codCarrKeyTyped(evt);
            }
        });

        nomCarr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomCarrKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Nombre de Carrera:");

        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Gestión:");

        botInser.setBackground(new java.awt.Color(0, 72, 225));
        botInser.setForeground(new java.awt.Color(255, 255, 255));
        botInser.setText("Insertar");
        botInser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botInserActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 72, 225));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(botInser, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codCarr)
                    .addComponent(nomCarr)
                    .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(codCarr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nomCarr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botInser)
                    .addComponent(jButton3))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codCarrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codCarrKeyTyped
        if(codCarr.getText().length()==30){
            evt.consume();
            getToolkit().beep();
        }
        if(codCarr.getText().length()>=30){
            evt.consume();
            getToolkit().beep();
            codCarr.setText("");
        }
    }//GEN-LAST:event_codCarrKeyTyped

    private void nomCarrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomCarrKeyTyped
        if(nomCarr.getText().length()==100){
            evt.consume();
            getToolkit().beep();
        }
        if(nomCarr.getText().length()>=100){
            evt.consume();
            getToolkit().beep();
            nomCarr.setText("");
        }
    }//GEN-LAST:event_nomCarrKeyTyped

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
        if(gestion.getText().length()>=20){
            evt.consume();
            getToolkit().beep();
            gestion.setText("");
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void botInserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botInserActionPerformed
        String sep = System.getProperty("line.separator");
        boolean band= true;
        if(codCarr.getText().equals("")||gestion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            if(band==true){
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO carrera(codigoCarrera,nombre,gestion) VALUES (?,?,?)");
                    pst.setString(1, codCarr.getText());
                    pst.setString(2, nomCarr.getText());
                    pst.setString(3, gestion.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Codigo de Carrera , gestion,duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo,NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band= false;
                }
            }
            if(band==true){
                try {
                    PreparedStatement pst2 = cn.prepareStatement("INSERT INTO materia(codigoMateria,gestion,nombreMateria,codigoDocente,grado,apellidos,nombres,eval,recurso,codCarrera) VALUES (?,?,?,?,?,?,?,?,?,?)");
                    pst2.setString(1, "");
                    pst2.setString(2, gestion.getText());
                    pst2.setString(3, "");
                    pst2.setString(4, "");
                    pst2.setString(5, "Dr.");
                    pst2.setString(6, "");
                    pst2.setString(7, "");
                    Double aux5=0.0;
                    BigDecimal aux6= BigDecimal.valueOf(aux5);
                    pst2.setBigDecimal(8,aux6);
                    pst2.setString(9, "");
                    pst2.setString(10, codCarr.getText());
                    pst2.executeUpdate();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }

            this.setVisible(false);
        }
    }//GEN-LAST:event_botInserActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botInser;
    private javax.swing.JTextField codCarr;
    private javax.swing.JTextField gestion;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomCarr;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
Connection cn= cc.conexion();
}
