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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import text.Control;
import text.MiModelo;
import text.MyRen;
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
public class LConvenios extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public LConvenios() {
        initComponents();
        this.setTitle("INTERACCIÓN SOCIAL Y CONVENIOS");
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
        this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabC.getTableHeader().setPreferredSize(new Dimension(20,50));
        tabC.getTableHeader().setFont(new Font("Lucida Grande", 1, 9));
        tabC.setRowHeight(270);
        botcon3.setToolTipText("<html>Se muestran las fechas<br>Anteriores e Iguales a Esta</html>");
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
        icono= new Advertencia();
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
    modelo.addColumn("INSTITUCIÓN");
    modelo.addColumn("<html>CÓDIGO<br>POSTULANTE</html>");
    modelo.addColumn("POSTULANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EJE");
    modelo.addColumn("LÍNEA"); 
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    tabC.setModel(modelo);
    TableColumnModel columnModel = tabC.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(120);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(120);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(80);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(120);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(120);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(120);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(13).setPreferredWidth(80);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
    String sql="";
    if(valor.equals("")&&valor2.equals(""))
    {
        sql="SELECT institucional.gestion,convenios.institucion,convenios.codP,convenios.grado,convenios.apellidos,convenios.nombres,convenios.email,convenios.telefono,institucional.eje,institucional.linea,convenios.fechaI,convenios.fechaF,convenios.cumplimiento,convenios.ef,institucional.proyecto,institucional.codigoP FROM convenios,institucional WHERE convenios.gestion=institucional.gestion AND convenios.codigoP=institucional.codigoP ORDER BY convenios.apellidos, convenios.nombres";
    }
    else{
        sql="SELECT institucional.gestion,convenios.institucion,convenios.codP,convenios.grado,convenios.apellidos,convenios.nombres,convenios.email,convenios.telefono,institucional.eje,institucional.linea,convenios.fechaI,convenios.fechaF,convenios.cumplimiento,convenios.ef,institucional.proyecto,institucional.codigoP FROM convenios,institucional WHERE convenios.gestion=institucional.gestion AND convenios.codigoP=institucional.codigoP AND convenios.gestion='"+valor+"' AND convenios.codigoP='"+valor2+"' ORDER BY convenios.apellidos, convenios.nombres";
    }
 
    Object []datos = new Object [15];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);  
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6);
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabC.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabC = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cAP = new javax.swing.JTextField();
        cNP = new javax.swing.JTextField();
        ccP = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        cPF = new com.toedter.calendar.JDateChooser();
        botcon2 = new javax.swing.JButton();
        botcon3 = new javax.swing.JButton();
        botcon4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(tabC);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONVENIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Consultar por el codigo del Proyecto:");
        jLabel14.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por el nombre del Proyecto:");
        jLabel1.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Consultar por Apellidos del postulante Debe Ingresar Todos sus Apellidos:");
        jLabel4.setOpaque(true);

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

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por Fecha Final:");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por Gestión:");
        jLabel3.setOpaque(true);

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
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ccP))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cNP, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon3))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon4))))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cAP, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon2)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ccP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon)
                    .addComponent(jLabel3)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon1)
                        .addComponent(jLabel2))
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2))
                .addContainerGap(13, Short.MAX_VALUE))
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
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
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
        mostrardatos2(ccP.getText().toString());
        cNP.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos3(cNP.getText());
        ccP.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos6(cAP.getText());
        ccP.setText("");
        cPG.setText("");
        cNP.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos5(formato.format(fecha1));
        ccP.setText("");
        cPG.setText("");
        cNP.setText("");
        cAP.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos4(cPG.getText());
        ccP.setText("");
        cAP.setText("");
        cNP.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed
 
    void mostrardatos2(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("INSTITUCIÓN");
    modelo.addColumn("<html>CÓDIGO<br>POSTULANTE</html>");
    modelo.addColumn("POSTULANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EJE");
    modelo.addColumn("LÍNEA"); 
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    tabC.setModel(modelo);
    TableColumnModel columnModel = tabC.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(120);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(120);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(80);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(120);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(120);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(120);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(13).setPreferredWidth(80);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT institucional.gestion,convenios.institucion,convenios.codP,convenios.grado,convenios.apellidos,convenios.nombres,convenios.email,convenios.telefono,institucional.eje,institucional.linea,convenios.fechaI,convenios.fechaF,convenios.cumplimiento,convenios.ef,institucional.proyecto,institucional.codigoP FROM convenios,institucional WHERE convenios.gestion=institucional.gestion AND convenios.codigoP=institucional.codigoP AND convenios.codigoP='"+valor+"' ORDER BY convenios.apellidos, convenios.nombres";
 
     Object []datos = new Object [15];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);  
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6);
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabC.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    
     void mostrardatos3(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("INSTITUCIÓN");
    modelo.addColumn("<html>CÓDIGO<br>POSTULANTE</html>");
    modelo.addColumn("POSTULANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EJE");
    modelo.addColumn("LÍNEA"); 
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    tabC.setModel(modelo);
    TableColumnModel columnModel = tabC.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(120);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(120);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(80);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(120);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(120);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(120);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(13).setPreferredWidth(80);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT institucional.gestion,convenios.institucion,convenios.codP,convenios.grado,convenios.apellidos,convenios.nombres,convenios.email,convenios.telefono,institucional.eje,institucional.linea,convenios.fechaI,convenios.fechaF,convenios.cumplimiento,convenios.ef,institucional.proyecto,institucional.codigoP FROM convenios,institucional WHERE convenios.gestion=institucional.gestion AND convenios.codigoP=institucional.codigoP AND institucional.proyecto='"+valor+"' ORDER BY convenios.apellidos, convenios.nombres";
 
     Object []datos = new Object [15];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);  
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6);
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabC.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
     
      void mostrardatos4(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("INSTITUCIÓN");
    modelo.addColumn("<html>CÓDIGO<br>POSTULANTE</html>");
    modelo.addColumn("POSTULANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EJE");
    modelo.addColumn("LÍNEA"); 
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    tabC.setModel(modelo);
    TableColumnModel columnModel = tabC.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(120);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(120);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(80);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(120);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(120);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(120);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(13).setPreferredWidth(80);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT institucional.gestion,convenios.institucion,convenios.codP,convenios.grado,convenios.apellidos,convenios.nombres,convenios.email,convenios.telefono,institucional.eje,institucional.linea,convenios.fechaI,convenios.fechaF,convenios.cumplimiento,convenios.ef,institucional.proyecto,institucional.codigoP FROM convenios,institucional WHERE convenios.gestion=institucional.gestion AND convenios.codigoP=institucional.codigoP AND institucional.gestion='"+valor+"' ORDER BY convenios.apellidos, convenios.nombres";
 
     Object []datos = new Object [15];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);  
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6);
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabC.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
      
       void mostrardatos5(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("INSTITUCIÓN");
    modelo.addColumn("<html>CÓDIGO<br>POSTULANTE</html>");
    modelo.addColumn("POSTULANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EJE");
    modelo.addColumn("LÍNEA"); 
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    tabC.setModel(modelo);
    TableColumnModel columnModel = tabC.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(120);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(120);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(80);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(120);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(120);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(120);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(13).setPreferredWidth(80);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT institucional.gestion,convenios.institucion,convenios.codP,convenios.grado,convenios.apellidos,convenios.nombres,convenios.email,convenios.telefono,institucional.eje,institucional.linea,convenios.fechaI,convenios.fechaF,convenios.cumplimiento,convenios.ef,institucional.proyecto,institucional.codigoP FROM convenios,institucional WHERE convenios.gestion=institucional.gestion AND convenios.codigoP=institucional.codigoP AND convenios.fechaF<='"+valor+"' ORDER BY convenios.apellidos, convenios.nombres";
 
     Object []datos = new Object [15];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);  
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6);
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabC.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
       
        void mostrardatos6(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("INSTITUCIÓN");
    modelo.addColumn("<html>CÓDIGO<br>POSTULANTE</html>");
    modelo.addColumn("POSTULANTE");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EJE");
    modelo.addColumn("LÍNEA"); 
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    tabC.setModel(modelo);
    TableColumnModel columnModel = tabC.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(120);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(120);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(80);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(120);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(120);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(120);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(13).setPreferredWidth(80);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT institucional.gestion,convenios.institucion,convenios.codP,convenios.grado,convenios.apellidos,convenios.nombres,convenios.email,convenios.telefono,institucional.eje,institucional.linea,convenios.fechaI,convenios.fechaF,convenios.cumplimiento,convenios.ef,institucional.proyecto,institucional.codigoP FROM convenios,institucional WHERE convenios.gestion=institucional.gestion AND convenios.codigoP=institucional.codigoP AND convenios.apellidos='"+valor+"' ORDER BY convenios.apellidos, convenios.nombres";
 
     Object []datos = new Object [15];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);  
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6);
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabC.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JTextField cAP;
    private javax.swing.JTextField cNP;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField ccP;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabC;
    // End of variables declaration//GEN-END:variables
Conexion4 cc= new Conexion4();
Connection cn= cc.conexion();
}

