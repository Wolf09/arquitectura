/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import text.Control;
import text.MiModelo;
import text.Redondear;
import text.Report;
import ziconos.Advertencia;
import ziconos.Bien2;
import ziconos.BotAct;
import ziconos.BotConsul;
import ziconos.BotInsertar;
import ziconos.BotTodos;
/**
 *
 * @author root
 */
public class LResultado extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public LResultado() {
        initComponents();
        this.setTitle("INTERACCIÓN SOCIAL Y CONVENIOS");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabR.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabR.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        icono= new Advertencia();
        icono1=new BotConsul();
        icono2=new BotTodos();
        icono3=new BotInsertar();
        icono4=new BotAct();
        icono5=new Bien2();
        botcon.setIcon(icono1);
        botcon1.setIcon(icono1);
        tabR.setRowHeight(40);
        this.addWindowListener ( new WindowAdapter() { 
        public void windowClosing(WindowEvent e) { 
            new Control().cerrarApp();
        } 
        });  
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        this.setVisible(true);  
    }
    
    public void EvaluarPp(String aux1,String aux2){
        ArrayList<BigDecimal> pP= new ArrayList<BigDecimal>();
        int aux3=0;
        double suma1=0.0;
        double res1=0.0;
        String sql1="";
        String sql2="";
                        sql1="select count(*) from postulantes where gestion='"+aux1+"' AND codigoP='"+aux2+"'";
                        try {
                            Statement st = cn.createStatement();
                            ResultSet rs = st.executeQuery(sql1);
                                while(rs.next()){
                                aux3=rs.getInt(1);
                                }
                            }
                        catch (SQLException ex) {
                           System.out.println(ex.getMessage());
                       }
                        sql2="select pp from postulantes where gestion='"+aux1+"' AND codigoP='"+aux2+"'";
                        try {
                                Statement st1 = cn.createStatement();
                                ResultSet rs1 = st1.executeQuery(sql2);
                                    while(rs1.next()){
                                    pP.add(rs1.getBigDecimal(1));
                                    }
                            }
                            catch (SQLException ex) {
                                 System.out.println(ex.getMessage());
                            }
                        
                        for(int x=0;x<pP.size();x++) {
                         suma1=suma1+(pP.get(x)).doubleValue();
                         }
                        
                        if(aux3==0){
                            aux3=1;
                        }
                        res1=suma1/aux3;
                        Redondear d=new Redondear();
                        res1=d.rD(res1);
                           try {
                                PreparedStatement pst = cn.prepareStatement("UPDATE resultado SET primerP='"+res1+"' where gestion='"+aux1+"' AND codigoP='"+aux2+"'");
                                pst.executeUpdate();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        
                        pP.clear();

    }
    public void EvaluarSp(String aux1,String aux2){
        ArrayList<BigDecimal> pP= new ArrayList<BigDecimal>();
        int aux3=0;
        double suma1=0.0;
        double res1=0.0;
        String sql1="";
        String sql2="";
                        sql1="select count(*) from postulantes where gestion='"+aux1+"' AND codigoP='"+aux2+"'";
                        try {
                            Statement st = cn.createStatement();
                            ResultSet rs = st.executeQuery(sql1);
                                while(rs.next()){
                                aux3=rs.getInt(1);
                                }
                            }
                        catch (SQLException ex) {
                           Logger.getLogger(Postulantes.class.getName()).log(Level.SEVERE, null, ex);
                       }
                        sql2="select sp from postulantes where gestion='"+aux1+"' AND codigoP='"+aux2+"'";
                        try {
                                Statement st1 = cn.createStatement();
                                ResultSet rs1 = st1.executeQuery(sql2);
                                    while(rs1.next()){
                                    pP.add(rs1.getBigDecimal(1));
                                    }
                            }
                            catch (SQLException ex) {
                                 Logger.getLogger(Postulantes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        for(int x=0;x<pP.size();x++) {
                         suma1=suma1+(pP.get(x)).doubleValue();
                         }
                        
                        if(aux3==0){
                            aux3=1;
                        }
                        res1=suma1/aux3;
                        Redondear d=new Redondear();
                        res1=d.rD(res1);
                           try {
                                PreparedStatement pst = cn.prepareStatement("UPDATE resultado SET segundoP='"+res1+"' where gestion='"+aux1+"' AND codigoP='"+aux2+"'");
                                pst.executeUpdate();
                            } catch (Exception e) {
                                Logger.getLogger(Postulantes.class.getName()).log(Level.SEVERE, null, e);
                            }
                        
                        pP.clear();

    }
    public void EvaluarPf(String aux1,String aux2){
        ArrayList<BigDecimal> pP= new ArrayList<BigDecimal>();
        int aux3=0;
        double suma1=0.0;
        double res1=0.0;
        String sql1="";
        String sql2="";
                        sql1="select count(*) from postulantes where gestion='"+aux1+"' AND codigoP='"+aux2+"'";
                        try {
                            Statement st = cn.createStatement();
                            ResultSet rs = st.executeQuery(sql1);
                                while(rs.next()){
                                aux3=rs.getInt(1);
                                }
                            }
                        catch (SQLException ex) {
                           System.out.println(ex.getMessage());
                       }
                        sql2="select pf from postulantes where gestion='"+aux1+"' AND codigoP='"+aux2+"'";
                        try {
                                Statement st1 = cn.createStatement();
                                ResultSet rs1 = st1.executeQuery(sql2);
                                    while(rs1.next()){
                                    pP.add(rs1.getBigDecimal(1));
                                    }
                            }
                            catch (SQLException ex) {
                                 System.out.println(ex.getMessage());
                            }
                        
                        for(int x=0;x<pP.size();x++) {
                         suma1=suma1+(pP.get(x)).doubleValue();
                         }
                        
                        if(aux3==0){
                            aux3=1;
                        }
                        res1=suma1/aux3;
                        Redondear d=new Redondear();
                        res1=d.rD(res1);
                           try {
                                PreparedStatement pst = cn.prepareStatement("UPDATE resultado SET tercerP='"+res1+"' where gestion='"+aux1+"' AND codigoP='"+aux2+"'");
                                pst.executeUpdate();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        
                        pP.clear();

    }
    public void mostrardatos(String valor,String valor2){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("<html>PRIMERA<br>PRESENTACIÓN</html>");
    modelo.addColumn("<html>SEGUNDA<br>PRESENTACIÓN</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CODIGO<br>PROYECTO</html>");
    tabR.setModel(modelo);
    TableColumnModel columnModel = tabR.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(150);
    columnModel.getColumn(1).setPreferredWidth(150);
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(3).setPreferredWidth(150);
    columnModel.getColumn(4).setPreferredWidth(250);
    String sql="";
    if(valor.equals("")&& valor2.equals(""))
    {
        sql="SELECT resultado.primerP,resultado.segundoP,resultado.tercerP,institucional.gestion,institucional.codigoP FROM resultado,institucional WHERE resultado.gestion=institucional.gestion AND resultado.codigoP=institucional.codigoP ORDER BY institucional.gestion";
    }
    else{
        sql="SELECT resultado.primerP,resultado.segundoP,resultado.tercerP,institucional.gestion,institucional.codigoP FROM resultado,institucional WHERE resultado.gestion=institucional.gestion AND resultado.codigoP=institucional.codigoP AND resultado.gestion='"+valor+"' AND resultado.codigoP='"+valor2+"' ORDER BY institucional.gestion";
    }
    Object []datos = new Object [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getBigDecimal(1);      
                datos[1]=rs.getBigDecimal(2);
                datos[2]=rs.getBigDecimal(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                modelo.addRow(datos);
            }
            tabR.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabR = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel8 = new javax.swing.JLabel();
        cCP = new javax.swing.JTextField();
        cPG = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabR.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(tabR);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESULTADOS POR CÓDIGO DE PROYECTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Consultar por el código del Proyecto:");
        jLabel8.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por Gestión:");
        jLabel1.setOpaque(true);

        botcon.setBackground(new java.awt.Color(0, 72, 225));
        botcon.setForeground(new java.awt.Color(255, 255, 255));
        botcon.setText("Consultar");
        botcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botconActionPerformed(evt);
            }
        });

        botcon1.setBackground(new java.awt.Color(0, 72, 225));
        botcon1.setForeground(new java.awt.Color(255, 255, 255));
        botcon1.setText("Consultar");
        botcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cCP, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(cPG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(botcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Atras");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Generar Reporte");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Acerca de");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        LInstitucional i= new LInstitucional();
        i.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          Report r=new Report(new java.awt.Frame(), true,this.cn,"RResultadoInt.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos2(cCP.getText());
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos3(cPG.getText());
        cCP.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

void mostrardatos2(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("<html>PRIMERA<br>PRESENTACIÓN</html>");
    modelo.addColumn("<html>SEGUNDA<br>PRESENTACIÓN</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CODIGO<br>PROYECTO</html>");
    tabR.setModel(modelo);
    TableColumnModel columnModel = tabR.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(150);
    columnModel.getColumn(1).setPreferredWidth(150);
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(3).setPreferredWidth(150);
    columnModel.getColumn(4).setPreferredWidth(250);
    String sql="";
   
        sql="SELECT resultado.primerP,resultado.segundoP,resultado.tercerP,institucional.gestion,institucional.codigoP FROM resultado,institucional WHERE resultado.gestion=institucional.gestion AND resultado.codigoP=institucional.codigoP AND resultado.codigoP='"+valor+"' ORDER BY institucional.gestion";
    
    Object []datos = new Object [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getBigDecimal(1);      
                datos[1]=rs.getBigDecimal(2);
                datos[2]=rs.getBigDecimal(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                modelo.addRow(datos);
            }
            tabR.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    void mostrardatos3(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("<html>PRIMERA<br>PRESENTACIÓN</html>");
    modelo.addColumn("<html>SEGUNDA<br>PRESENTACIÓN</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CODIGO<br>PROYECTO</html>");
    tabR.setModel(modelo);
    TableColumnModel columnModel = tabR.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(150);
    columnModel.getColumn(1).setPreferredWidth(150);
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(3).setPreferredWidth(150);
    columnModel.getColumn(4).setPreferredWidth(250);
    String sql="";
   
        sql="SELECT resultado.primerP,resultado.segundoP,resultado.tercerP,institucional.gestion,institucional.codigoP FROM resultado,institucional WHERE resultado.gestion=institucional.gestion AND resultado.codigoP=institucional.codigoP AND institucional.gestion='"+valor+"' ORDER BY institucional.gestion";
    
    Object []datos = new Object [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getBigDecimal(1);      
                datos[1]=rs.getBigDecimal(2);
                datos[2]=rs.getBigDecimal(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                modelo.addRow(datos);
            }
            tabR.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JTextField cCP;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabR;
    // End of variables declaration//GEN-END:variables
Conexion4 cc= new Conexion4();
Connection cn= cc.conexion();
}
