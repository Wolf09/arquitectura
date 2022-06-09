/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import text.Control;
import text.MiModelo;
import text.MyRen2;
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
public class LActividad extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono2;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
public LActividad() {
        initComponents();
        this.setTitle("PREGRADO");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tablaAct.getTableHeader().setPreferredSize(new Dimension(10,30));
        tablaAct.setRowHeight(190);
        tablaAct.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        icono2=new BotConsul();
        icono3=new BotTodos();
        icono4=new BotInsertar();
        icono5=new BotAct();
        icono6=new Bien2();  
        botcon.setIcon(icono2);
        botcon1.setIcon(icono2);
        botcon2.setIcon(icono2);
        botcon3.setIcon(icono2);
        botcon4.setIcon(icono2);
        botcon4.setToolTipText("<html>Se muestran las fechas<br>Anteriores e Iguales a Esta</html>");
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
         icono =new Advertencia();
        this.setVisible(true);
       
    }
     void mostrardatos(String valor1,String valor2, String valor3,String valor4,String valor5){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>DE MATERIA</html>");
    tablaAct.setModel(modelo);
    TableColumnModel columnModel = tablaAct.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(110);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(80);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
    if(valor1.equals("")&& valor2.equals("")&& valor3.equals("")&& valor4.equals("")&& valor5.equals(""))
    {
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion ORDER BY materia.apellidos, materia.nombres";
    }
    else{
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND actividad.cUT='"+valor1+"' AND actividad.codCarr='"+valor2+"' AND actividad.gestion='"+valor3+"' AND actividad.codigoMateria='"+valor4+"' AND actividad.codDoc='"+valor5+"'ORDER BY materia.apellidos, materia.nombres";
    }
 
    Object []datos = new Object [14];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){   
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getString(9);
                datos[7]=rs.getString(10);
                Date fecha1= rs.getDate(11);
                Date fecha2= rs.getDate(12);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[8]=formato.format(fecha1);
                datos[9]=formato.format(fecha2);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getString(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tablaAct.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAct = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel5 = new javax.swing.JLabel();
        cAD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ccUT = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        cPG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cCC = new javax.swing.JTextField();
        botcon2 = new javax.swing.JButton();
        botcon3 = new javax.swing.JButton();
        cPF = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        botcon4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(tablaAct);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTIVIDAD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Consultar por Código del Docente:");
        jLabel5.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Consultar por Apellidos del Docente debe Ingresar todos los apellidos:");
        jLabel11.setOpaque(true);

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

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por Gestión:");
        jLabel3.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por Codigo de carrera:");
        jLabel1.setOpaque(true);

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

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por Fecha Final:");
        jLabel2.setOpaque(true);

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
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccUT, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cAD, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cCC, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon2)
                                .addGap(59, 59, 59)))
                        .addComponent(botcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon)
                        .addComponent(jLabel2)
                        .addComponent(botcon4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ccUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(jLabel1)
                    .addComponent(cCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2))
                .addGap(0, 22, Short.MAX_VALUE))
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
                    .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        LUnidadTematica u= new LUnidadTematica();
        u.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sep = System.getProperty("line.separator");
       JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos3(cAD.getText());
        ccUT.setText("");
        cCC.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos6(cPG.getText());
        ccUT.setText("");
        cCC.setText("");
        cAD.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos4(cCC.getText());
        ccUT.setText("");
        cPG.setText("");
        cAD.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        mostrardatos2(ccUT.getText());
        cAD.setText("");
        cCC.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos5(formato.format(fecha1));
        ccUT.setText("");
        cPG.setText("");
        cAD.setText("");
        cCC.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

      void mostrardatos4(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>DE MATERIA</html>");
    tablaAct.setModel(modelo);
    TableColumnModel columnModel = tablaAct.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(110);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(80);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND carrera.codigoCarrera='"+valor+"'ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [14];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){   
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getString(9);
                datos[7]=rs.getString(10);
                Date fecha1= rs.getDate(11);
                Date fecha2= rs.getDate(12);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[8]=formato.format(fecha1);
                datos[9]=formato.format(fecha2);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getString(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tablaAct.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }  
      void mostrardatos2(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>DE MATERIA</html>");
    tablaAct.setModel(modelo);
    TableColumnModel columnModel = tablaAct.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(110);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(80);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
  
       sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND materia.apellidos='"+valor+"'ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [14];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){   
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getString(9);
                datos[7]=rs.getString(10);
                Date fecha1= rs.getDate(11);
                Date fecha2= rs.getDate(12);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[8]=formato.format(fecha1);
                datos[9]=formato.format(fecha2);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getString(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tablaAct.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
     void mostrardatos3(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>DE MATERIA</html>");
    tablaAct.setModel(modelo);
    TableColumnModel columnModel = tablaAct.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(110);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(80);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND materia.codigoDocente='"+valor+"'ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [14];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){   
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getString(9);
                datos[7]=rs.getString(10);
                Date fecha1= rs.getDate(11);
                Date fecha2= rs.getDate(12);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[8]=formato.format(fecha1);
                datos[9]=formato.format(fecha2);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getString(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tablaAct.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }  
     
     void mostrardatos5(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>DE MATERIA</html>");
    tablaAct.setModel(modelo);
   TableColumnModel columnModel = tablaAct.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(110);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(80);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND actividad.fechaFin<='"+valor+"'ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [14];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){   
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getString(9);
                datos[7]=rs.getString(10);
                Date fecha1= rs.getDate(11);
                Date fecha2= rs.getDate(12);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[8]=formato.format(fecha1);
                datos[9]=formato.format(fecha2);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getString(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tablaAct.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }  
     
     void mostrardatos6(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>DE MATERIA</html>");
    tablaAct.setModel(modelo);
    TableColumnModel columnModel = tablaAct.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(130);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(110);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(80);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND carrera.gestion='"+valor+"'ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [14];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){   
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getString(9);
                datos[7]=rs.getString(10);
                Date fecha1= rs.getDate(11);
                Date fecha2= rs.getDate(12);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[8]=formato.format(fecha1);
                datos[9]=formato.format(fecha2);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getString(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tablaAct.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JTextField cAD;
    private javax.swing.JTextField cCC;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField ccUT;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAct;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
Connection cn= cc.conexion();
}
