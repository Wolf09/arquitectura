/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import text.Control;
import text.MiModelo;
import text.MyEditor;
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
public class LEstudiante extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public LEstudiante() {
        initComponents();
        this.setTitle("POSGRADO");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabE.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabE.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        tabE.setRowHeight(150);
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
        icono = new Advertencia();
         icono1=new BotConsul();
        icono2=new BotTodos();
        icono3=new BotInsertar();
        icono4=new BotAct();
        icono5=new Bien2();
         botcon.setIcon(icono1);
        botcon1.setIcon(icono1);
        botcon2.setIcon(icono1);
        botcon3.setIcon(icono1);
        botcon4.setIcon(icono1);
        this.setVisible(true);
       
    }
  void mostrardatos(String valor,String valor2){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ESTUDIANTE</html>");
    modelo.addColumn("ESTUDIANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("NOMINACIÓN");
    tabE.setModel(modelo);
    TableColumnModel columnModel = tabE.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(160);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(130);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(210);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(90);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    columnModel.getColumn(8).setPreferredWidth(90);
    columnModel.getColumn(8).setCellRenderer(new MyRen());
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen());
    String sql="";
    if(valor.equals("")&& valor2.equals(""))
    {
        sql="SELECT institucional.gest,estudiante.codigoestudiante,estudiante.apellidos,estudiante.nombres,estudiante.email,estudiante.telefono,estudiante.codMat,estudiante.materia,estudiante.resultadoEvaluaciones,estudiante.cumplimiento,institucional.nomi FROM estudiante,institucional WHERE estudiante.gestion=institucional.gest AND estudiante.nominacion=institucional.nomi ORDER BY estudiante.apellidos, estudiante.nombres";
    }
    else{
        sql="SELECT institucional.gest,estudiante.codigoestudiante,estudiante.apellidos,estudiante.nombres,estudiante.email,estudiante.telefono,estudiante.codMat,estudiante.materia,estudiante.resultadoEvaluaciones,estudiante.cumplimiento,institucional.nomi FROM estudiante,institucional WHERE estudiante.gestion=institucional.gest AND estudiante.nominacion=institucional.nomi AND estudiante.gestion='"+valor+"' AND estudiante.nominacion='"+valor2+"' ORDER BY estudiante.apellidos, estudiante.nombres";
    }
 
    Object []datos = new Object [11];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3)+" "+rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                datos[6]=rs.getString(8);      
                datos[7]=rs.getBigDecimal(9);
                datos[8]=rs.getBigDecimal(10);
                datos[9]=rs.getString(11);
                modelo.addRow(datos);
            }
            tabE.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabE = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cCM = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        botcon2 = new javax.swing.JButton();
        cAP = new javax.swing.JTextField();
        botcon3 = new javax.swing.JButton();
        nom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cPG2 = new javax.swing.JTextField();
        nom2 = new javax.swing.JComboBox<>();
        botcon4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabE.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(tabE);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESTUDIANTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(250, 250, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Consultar por Nominación:");
        jLabel9.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("Consultar por el codigo de Materia:");
        jLabel12.setOpaque(true);

        botcon.setBackground(new java.awt.Color(0, 72, 225));
        botcon.setForeground(new java.awt.Color(255, 255, 255));
        botcon.setText("Mostrar");
        botcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botconActionPerformed(evt);
            }
        });

        botcon1.setBackground(new java.awt.Color(0, 72, 225));
        botcon1.setForeground(new java.awt.Color(255, 255, 255));
        botcon1.setText("Mostrar");
        botcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por apellidos del Estudiante debe ingresar todos los Apellidos:");
        jLabel1.setOpaque(true);

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

        botcon3.setBackground(new java.awt.Color(0, 72, 225));
        botcon3.setForeground(new java.awt.Color(255, 255, 255));
        botcon3.setText("Consultar");
        botcon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon3ActionPerformed(evt);
            }
        });

        nom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diplomado", "Maestría", "Doctorado" }));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por Gestión y Nominación:");
        jLabel3.setOpaque(true);

        nom2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diplomado", "Maestría", "Doctorado" }));

        botcon4.setBackground(new java.awt.Color(0, 72, 225));
        botcon4.setForeground(new java.awt.Color(255, 255, 255));
        botcon4.setText("Consultar");
        botcon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom, 0, 99, Short.MAX_VALUE)
                            .addComponent(cCM)))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPG2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botcon)
                            .addComponent(botcon1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cAP, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon3))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customPanel1Layout.createSequentialGroup()
                        .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon4)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(botcon)
                    .addComponent(jLabel2)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(jLabel1)
                    .addComponent(cAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cPG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon4)))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos2(nom.getSelectedItem().toString());
        cCM.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos3(cCM.getText().toString());
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos5(cPG.getText());
        cCM.setText("");
        cAP.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        mostrardatos4(cAP.getText());
        cCM.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos6(cPG2.getText(),nom2.getSelectedItem().toString());
        cCM.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed
    void mostrardatos2(String valor){
     MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ESTUDIANTE</html>");
    modelo.addColumn("ESTUDIANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("NOMINACIÓN");
    tabE.setModel(modelo);
    TableColumnModel columnModel = tabE.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(160);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(130);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(210);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(90);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    columnModel.getColumn(8).setPreferredWidth(90);
    columnModel.getColumn(8).setCellRenderer(new MyRen());
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen());
    String sql="";
     sql="SELECT institucional.gest,estudiante.codigoestudiante,estudiante.apellidos,estudiante.nombres,estudiante.email,estudiante.telefono,estudiante.codMat,estudiante.materia,estudiante.resultadoEvaluaciones,estudiante.cumplimiento,institucional.nomi FROM estudiante,institucional WHERE estudiante.gestion=institucional.gest AND estudiante.nominacion=institucional.nomi AND institucional.nomi='"+valor+"' ORDER BY estudiante.apellidos, estudiante.nombres";
   Object []datos = new Object [11];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3)+" "+rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                datos[6]=rs.getString(8);      
                datos[7]=rs.getBigDecimal(9);
                datos[8]=rs.getBigDecimal(10);
                datos[9]=rs.getString(11);
                modelo.addRow(datos);
            }
            tabE.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    void mostrardatos3(String valor){
     MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ESTUDIANTE</html>");
    modelo.addColumn("ESTUDIANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("NOMINACIÓN");
    tabE.setModel(modelo);
    TableColumnModel columnModel = tabE.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(160);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(130);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(210);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(90);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    columnModel.getColumn(8).setPreferredWidth(90);
    columnModel.getColumn(8).setCellRenderer(new MyRen());
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen());
    String sql="";
     sql="SELECT institucional.gest,estudiante.codigoestudiante,estudiante.apellidos,estudiante.nombres,estudiante.email,estudiante.telefono,estudiante.codMat,estudiante.materia,estudiante.resultadoEvaluaciones,estudiante.cumplimiento,institucional.nomi FROM estudiante,institucional WHERE estudiante.gestion=institucional.gest AND estudiante.nominacion=institucional.nomi AND estudiante.codMat='"+valor+"' ORDER BY estudiante.apellidos, estudiante.nombres";
   Object []datos = new Object [11];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3)+" "+rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                datos[6]=rs.getString(8);      
                datos[7]=rs.getBigDecimal(9);
                datos[8]=rs.getBigDecimal(10);
                datos[9]=rs.getString(11);
                modelo.addRow(datos);
            }
            tabE.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
       void mostrardatos4(String valor){
     MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ESTUDIANTE</html>");
    modelo.addColumn("ESTUDIANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("NOMINACIÓN");
    tabE.setModel(modelo);
    TableColumnModel columnModel = tabE.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(160);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(130);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(210);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(90);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    columnModel.getColumn(8).setPreferredWidth(90);
    columnModel.getColumn(8).setCellRenderer(new MyRen());
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen());
    String sql="";
     sql="SELECT institucional.gest,estudiante.codigoestudiante,estudiante.apellidos,estudiante.nombres,estudiante.email,estudiante.telefono,estudiante.codMat,estudiante.materia,estudiante.resultadoEvaluaciones,estudiante.cumplimiento,institucional.nomi FROM estudiante,institucional WHERE estudiante.gestion=institucional.gest AND estudiante.nominacion=institucional.nomi AND estudiante.apellidos='"+valor+"' ORDER BY estudiante.apellidos, estudiante.nombres";
   Object []datos = new Object [11];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3)+" "+rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                datos[6]=rs.getString(8);      
                datos[7]=rs.getBigDecimal(9);
                datos[8]=rs.getBigDecimal(10);
                datos[9]=rs.getString(11);
                modelo.addRow(datos);
            }
            tabE.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
       
          void mostrardatos5(String valor){
     MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ESTUDIANTE</html>");
    modelo.addColumn("ESTUDIANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("NOMINACIÓN");
    tabE.setModel(modelo);
    TableColumnModel columnModel = tabE.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(160);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(130);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(210);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(90);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    columnModel.getColumn(8).setPreferredWidth(90);
    columnModel.getColumn(8).setCellRenderer(new MyRen());
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen());
    String sql="";
     sql="SELECT institucional.gest,estudiante.codigoestudiante,estudiante.apellidos,estudiante.nombres,estudiante.email,estudiante.telefono,estudiante.codMat,estudiante.materia,estudiante.resultadoEvaluaciones,estudiante.cumplimiento,institucional.nomi FROM estudiante,institucional WHERE estudiante.gestion=institucional.gest AND estudiante.nominacion=institucional.nomi AND institucional.gest='"+valor+"' ORDER BY estudiante.apellidos, estudiante.nombres";
   Object []datos = new Object [11];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3)+" "+rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                datos[6]=rs.getString(8);      
                datos[7]=rs.getBigDecimal(9);
                datos[8]=rs.getBigDecimal(10);
                datos[9]=rs.getString(11);
                modelo.addRow(datos);
            }
            tabE.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
          
    public void mostrardatos6(String valor,String valor2){
     MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ESTUDIANTE</html>");
    modelo.addColumn("ESTUDIANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("NOMINACIÓN");
    tabE.setModel(modelo);
    TableColumnModel columnModel = tabE.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(160);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(130);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(210);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(90);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    columnModel.getColumn(8).setPreferredWidth(90);
    columnModel.getColumn(8).setCellRenderer(new MyRen());
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen());
    String sql="";
     sql="SELECT institucional.gest,estudiante.codigoestudiante,estudiante.apellidos,estudiante.nombres,estudiante.email,estudiante.telefono,estudiante.codMat,estudiante.materia,estudiante.resultadoEvaluaciones,estudiante.cumplimiento,institucional.nomi FROM estudiante,institucional WHERE estudiante.gestion=institucional.gest AND estudiante.nominacion=institucional.nomi AND institucional.gest='"+valor+"' AND institucional.nomi='"+valor2+"' ORDER BY estudiante.apellidos, estudiante.nombres";
   Object []datos = new Object [11];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3)+" "+rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                datos[6]=rs.getString(8);      
                datos[7]=rs.getBigDecimal(9);
                datos[8]=rs.getBigDecimal(10);
                datos[9]=rs.getString(11);
                modelo.addRow(datos);
            }
            tabE.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JTextField cAP;
    private javax.swing.JTextField cCM;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField cPG2;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nom;
    private javax.swing.JComboBox<String> nom2;
    private javax.swing.JTable tabE;
    // End of variables declaration//GEN-END:variables
Conexion2 cc= new Conexion2();
Connection cn= cc.conexion();
}
