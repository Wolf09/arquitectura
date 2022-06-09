/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import java.awt.Dimension;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ziconos.Advertencia;
import Interfaz.Administrador;
import Interfaz.Atras;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import javax.swing.table.TableColumnModel;
import text.Auxi;
import text.Control;
import text.MiModelo;
import text.MyRen;
import ziconos.Bien2;
import ziconos.BotAct;
import ziconos.BotConsul;
import ziconos.BotInsertar;
import ziconos.BotTodos;
/**
 *
 * @author Jhon
 */
public class LBaseGrado extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono2;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
    public LBaseGrado() {
        initComponents();
        this.setTitle("PREGRADO");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
       this.setMinimumSize(new Dimension(ancho-100, alto-200));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
       tbCarrera.setRowHeight(50);
        icono = new Advertencia();
        icono2=new BotConsul();
        icono3=new BotTodos();
        icono4=new BotInsertar();
        icono5=new BotAct();
        icono6=new Bien2();     
        botcon.setIcon(icono2);
        botcon2.setIcon(icono2);
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

  public void mostrardatos(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("CÓDIGO DE CARRERA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("GESTIÓN");
    tbCarrera.setModel(modelo);
    TableColumnModel columnModel = tbCarrera.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT * FROM carrera ORDER BY codigoCarrera,nombre";
 
    String []datos = new String [4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelo.addRow(datos);
            }
            tbCarrera.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LBaseGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
  public void mostrardatos9(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("CÓDIGO DE CARRERA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("GESTIÓN");
    tbCarrera.setModel(modelo);
    TableColumnModel columnModel = tbCarrera.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT * FROM carrera where gestion='"+valor+"'ORDER BY codigoCarrera,nombre";
 
    String []datos = new String [4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelo.addRow(datos);
            }
            tbCarrera.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(BaseGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void mostrardatos3(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("CÓDIGO DE CARRERA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("GESTIÓN");
    tbCarrera.setModel(modelo);
    TableColumnModel columnModel = tbCarrera.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT * FROM carrera WHERE codigoCarrera='"+valor+"' ORDER BY codigoCarrera,nombre";
 
    String []datos = new String [4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelo.addRow(datos);
            }
            tbCarrera.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LBaseGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCarrera = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel3 = new javax.swing.JLabel();
        buscarCod = new javax.swing.JTextField();
        cPG = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botcon2 = new javax.swing.JButton();
        botcon = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem1.setText("Ver Materias");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tbCarrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCarrera.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbCarrera);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CARRERA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por código de Carrera:");
        jLabel3.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por Gestión:");
        jLabel1.setOpaque(true);

        botcon2.setBackground(new java.awt.Color(0, 72, 225));
        botcon2.setForeground(new java.awt.Color(255, 255, 255));
        botcon2.setText("Consultar");
        botcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon2ActionPerformed(evt);
            }
        });

        botcon.setBackground(new java.awt.Color(0, 72, 225));
        botcon.setForeground(new java.awt.Color(255, 255, 255));
        botcon.setText("Consultar");
        botcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(buscarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botcon, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 398, Short.MAX_VALUE))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(440, Short.MAX_VALUE))))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buscarCod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2))
                .addGap(1, 1, 1))
        );

        jMenu1.setText("Archivo");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Atras");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar3.add(jMenu1);

        jMenu6.setText("Ayuda");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Acerca de");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuBar3.add(jMenu6);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0"+sep+"e-mail: jhonbarh@gmail.com","Autor",JOptionPane.PLAIN_MESSAGE); 
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tbCarrera.getSelectedRow();
        if(fila>= 0){
            this.setVisible(false);
            LMateria m=new LMateria();
            m.mostrardatos(tbCarrera.getValueAt(fila, 0).toString(),tbCarrera.getValueAt(fila, 2).toString());
            
        }else{
         
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    void mostrardatos2(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("CÓDIGO DE CARRERA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("GESTIÓN");
    tbCarrera.setModel(modelo);
    TableColumnModel columnModel = tbCarrera.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT * FROM carrera WHERE gestion='"+valor+"' ORDER BY codigoCarrera,nombre";
    
 
    String []datos = new String [4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelo.addRow(datos);
            }
            tbCarrera.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LBaseGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Atras a =new Atras();
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos2(cPG.getText());
        buscarCod.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos3(buscarCod.getText());
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon2;
    private javax.swing.JTextField buscarCod;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCarrera;
    // End of variables declaration//GEN-END:variables
   Conexion1 cc= new Conexion1();
   Connection cn= cc.conexion();
}
