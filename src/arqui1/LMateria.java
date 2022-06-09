/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import text.Abrir;
import text.Control;
import text.MiModelo;
import text.MyRen;
import text.Report;
import ziconos.Advertencia;
import ziconos.Bien2;
import ziconos.BotAct;
import ziconos.BotConsul;
import ziconos.BotInsertar;
import ziconos.BotTodos;
/**
 *
 * @author Jhon
 */
public class LMateria extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono2;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
    public LMateria() {
        initComponents();
        this.setTitle("PREGRADO");
          int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
       this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
       tabMat.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabMat.setRowHeight(110);
        icono = new Advertencia();
        icono2=new BotConsul();
        icono3=new BotTodos();
        icono4=new BotInsertar();
        icono5=new BotAct();
        icono6=new Bien2();
        botcon.setIcon(icono2);
        botcon2.setIcon(icono2);
        botcon3.setIcon(icono2);
        botcon1.setIcon(icono2);
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
 void mostrardatos(String valor,String valor2){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("MATERIA");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("CARRERA");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(200);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(190);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    String sql="";
    if(valor.equals("")&&valor2.equals(""))
    {
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion ORDER BY m.apellidos, m.nombres";
    }
    else{
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion AND m.codCarrera='"+valor+"' AND m.gestion='"+valor2+"'ORDER BY m.apellidos, m.nombres";
    }
 
    Object []datos = new Object [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getBigDecimal(9);
                datos[7]=rs.getString(10);
                modelo.addRow(datos);
            }
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void mostrardatos9(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("MATERIA");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("CARRERA");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(200);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(190);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion AND m.gestion='"+valor+"'ORDER BY m.apellidos, m.nombres";
 
    Object []datos = new Object [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getBigDecimal(9);
                datos[7]=rs.getString(10);
                modelo.addRow(datos);
            }
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMat = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel5 = new javax.swing.JLabel();
        ccD = new javax.swing.JTextField();
        cCM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botcon2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cPA = new javax.swing.JTextField();
        botcon3 = new javax.swing.JButton();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jPopupMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jPopupMenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        jMenuItem7.setText("Ver Unidades Tematicas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        jMenuItem9.setText("VER RECURSO");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1273, 650));

        tabMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabMat.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabMat.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabMat);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MATERIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Consultar por el código del Docente:");
        jLabel5.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Consultar por nombre de la Materia:");
        jLabel4.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por Gestión:");
        jLabel2.setOpaque(true);

        botcon2.setBackground(new java.awt.Color(0, 72, 225));
        botcon2.setForeground(new java.awt.Color(255, 255, 255));
        botcon2.setText("Consultar");
        botcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon2ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por Apellidos del Docente Debe Ingresar Todos los apellidos:");
        jLabel3.setOpaque(true);

        botcon3.setBackground(new java.awt.Color(0, 72, 225));
        botcon3.setForeground(new java.awt.Color(255, 255, 255));
        botcon3.setText("Consultar");
        botcon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon3ActionPerformed(evt);
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
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ccD, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPA, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon3))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCM, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botcon)
                    .addComponent(jLabel5)
                    .addComponent(ccD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botcon1)
                    .addComponent(jLabel4)
                    .addComponent(cCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2)
                    .addComponent(jLabel3)
                    .addComponent(cPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon3))
                .addContainerGap(15, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        LBaseGrado b= new LBaseGrado();
        b.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
          String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
              int fila= tabMat.getSelectedRow();
        if(fila>= 0){
            this.setVisible(false);
            LUnidadTematica u=new LUnidadTematica();
            u.mostrardatos(tabMat.getValueAt(fila, 1).toString(),tabMat.getValueAt(fila, 0).toString(),tabMat.getValueAt(fila, 3).toString(),tabMat.getValueAt(fila, 7).toString());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jPopupMenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jPopupMenu1MenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPopupMenu1MenuKeyPressed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int fila= tabMat.getSelectedRow();
         String sep = System.getProperty("line.separator");
        if(fila>= 0){
                     String sql="";
                     String aux="";
                     Abrir a=new Abrir();
                                   sql= "select recurso from materia WHERE codigoMateria='"+tabMat.getValueAt(fila, 1).toString()+"' AND gestion='"+tabMat.getValueAt(fila, 0).toString()+"' AND codigoDocente='"+tabMat.getValueAt(fila, 3).toString()+"' AND codCarrera='"+tabMat.getValueAt(fila, 7).toString()+"'";
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            aux=rs.getString(1);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(LMateria.class.getName()).log(Level.SEVERE, null, ex);
            }
                     a.launchFile("\\\\167.157.17.39\\pregrado\\"+aux+"");
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos4(cPG.getText());
        ccD.setText("");
        cCM.setText("");
        cPA.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        mostrardatos5(cPA.getText());
        ccD.setText("");
        cPG.setText("");
        cCM.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos2(ccD.getText());
        cCM.setText("");
        cPG.setText("");
        cPA.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos3(cCM.getText().toString());
        ccD.setText("");
        cPG.setText("");
        cPA.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

     void mostrardatos2(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("MATERIA");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("CARRERA");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(200);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(190);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    String sql="";
    
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion AND m.codigoDocente='"+valor+"' ORDER BY m.apellidos, m.nombres";
    
    Object []datos = new Object [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getBigDecimal(9);
                datos[7]=rs.getString(10);
                modelo.addRow(datos);
            }
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
 void mostrardatos3(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("MATERIA");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("CARRERA");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(200);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(190);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    String sql="";
    
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion AND m.nombreMateria='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getBigDecimal(9);
                datos[7]=rs.getString(10);
                modelo.addRow(datos);
            }
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    void mostrardatos4(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("MATERIA");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("CARRERA");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(200);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(190);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    String sql="";
    
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion AND c.gestion='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getBigDecimal(9);
                datos[7]=rs.getString(10);
                modelo.addRow(datos);
            }
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    void mostrardatos5(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("MATERIA");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("CARRERA");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(200);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(190);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    String sql="";
    
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion AND m.apellidos='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getBigDecimal(9);
                datos[7]=rs.getString(10);
                modelo.addRow(datos);
            }
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JTextField cCM;
    private javax.swing.JTextField cPA;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField ccD;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabMat;
    // End of variables declaration//GEN-END:variables
 Conexion1 cc= new Conexion1();
 Connection cn= cc.conexion();
}
