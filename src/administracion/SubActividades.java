/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
 * @author root
 */
public class SubActividades extends javax.swing.JFrame {
    private Advertencia icono;
    private BotConsul icono1;
    private BotTodos icono2;
    private BotInsertar icono3;
    private BotAct icono4;
    private Bien2 icono5;
    public SubActividades() {
        initComponents();
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
        botcon5.setIcon(icono1);
        botA.setIcon(icono4);
        botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
        this.setTitle("PERSONAL DE ADMINISTRACIÓN");
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabS.getTableHeader().setPreferredSize(new Dimension(20,50));
        tabS.getTableHeader().setFont(new Font("Lucida Grande", 1, 9));
        tabS.setRowHeight(190);
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
        //this.getContentPane().setBackground(new Color(250,250,250));
        this.setVisible(true);  
    }
    public void mostrardatos(String valor1, String valor2,String valor3){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
    if(valor1.equals("")&&valor2.equals("")&&valor3.equals("")){
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act ORDER BY actividades.apellidos, actividades.nombres";
    }
    else{
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND subactividades.gestion='"+valor1+"' AND subactividades.codA='"+valor2+"' AND subactividades.act='"+valor3+"'ORDER BY actividades.apellidos, actividades.nombres";
    }
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public  void mostrardatos8(String valor1, String valor2,String valor3,String valor4){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND subactividades.gestion='"+valor1+"' AND subactividades.codA='"+valor2+"' AND subactividades.act='"+valor3+"' AND subactividades.subA='"+valor4+"' ORDER BY actividades.apellidos, actividades.nombres";
 
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabS = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cNS = new javax.swing.JTextField();
        cCA = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        cAA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botcon1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cPF = new com.toedter.calendar.JDateChooser();
        botcon2 = new javax.swing.JButton();
        botcon3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cNA = new javax.swing.JTextField();
        botcon5 = new javax.swing.JButton();
        cPG = new javax.swing.JTextField();
        botcon4 = new javax.swing.JButton();
        botA = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem5.setText("INSERTAR");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem6.setText("MODIFICAR");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);

        jMenuItem7.setText("ELIMINAR");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        jMenuItem4.setText("EVALUAR PRIMER PRODUCTO");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem8.setText("EVALUAR SEGUNDO PRODUCTO");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

        jMenuItem9.setText("EVALUAR PRODUCTO FINAL");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabS.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        tabS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabS.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabS);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SUB-ACTIVIDADES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Mostrar por Apellidos del Administrativo(Ingresar todos sus Apellidos):");
        jLabel14.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Mostrar por código de Administrativo:");
        jLabel15.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por el nombre de la Sub-Actividad:");
        jLabel1.setOpaque(true);

        botcon.setBackground(new java.awt.Color(0, 72, 225));
        botcon.setForeground(new java.awt.Color(255, 255, 255));
        botcon.setText("Consultar");
        botcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botconActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por Fecha Final:");
        jLabel3.setOpaque(true);

        botcon1.setBackground(new java.awt.Color(0, 72, 225));
        botcon1.setForeground(new java.awt.Color(255, 255, 255));
        botcon1.setText("Consultar");
        botcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por el nombre de la Actividad:");
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

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Consultar por Gestión:");
        jLabel4.setOpaque(true);

        botcon5.setBackground(new java.awt.Color(0, 72, 225));
        botcon5.setForeground(new java.awt.Color(255, 255, 255));
        botcon5.setText("Consultar");
        botcon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon5ActionPerformed(evt);
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

        botA.setBackground(new java.awt.Color(0, 72, 225));
        botA.setForeground(new java.awt.Color(255, 255, 255));
        botA.setText("ACTUALIZAR");
        botA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cNS, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botcon1)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cNA, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botcon5)
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cAA, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botA))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCA, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon4)))
                .addGap(30, 30, 30))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2)
                    .addComponent(botA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon)
                        .addComponent(jLabel15)
                        .addComponent(jLabel3))
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botcon3)
                        .addComponent(jLabel4)
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon4))
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(jLabel2)
                    .addComponent(cNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu2.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Atras");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Generar Reporte");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Acerca de");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        Actividades a= new Actividades();
        a.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int fila= tabS.getSelectedRow();
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
           String sql="";
           String aux1="";
           String aux2="";
           String aux3="";
           String aux4="";
           String aux5="";
           String aux6="";
        if(fila>= 0){
                     aux1=tabS.getValueAt(fila, 0).toString();
                     aux2=tabS.getValueAt(fila, 1).toString();
                     sql= "select grado, apellidos, nombres from subactividades,actividades where subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND subactividades.gestion='"+tabS.getValueAt(fila, 0).toString()+"' AND subactividades.codA='"+tabS.getValueAt(fila, 1).toString()+"' AND subactividades.act='"+tabS.getValueAt(fila, 3).toString()+"' AND subactividades.subA='"+tabS.getValueAt(fila, 4).toString()+"'";
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            aux3=rs.getString(1);
            aux4=rs.getString(2);
            aux5=rs.getString(3);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabS.getValueAt(fila, 3).toString();
                     iS i=new iS(new java.awt.Frame(), true);
                     i.llenardatos(aux1, aux2, aux3, aux4, aux5, aux6, formato.format(fecha1), formato.format(fecha1), "0");
                     i.setVisible(true);
                     mostrardatos8(i.getgestion(),i.getcA(),i.getact(),i.getsubA());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
           int fila= tabS.getSelectedRow();
           String sql="";
           String aux1="";
           String aux2="";
           String aux3="";
           String aux4="";
           String aux5="";
           String aux6="";
           String aux7="";
           String aux8="";
           String aux9="";
           String aux10="";
        if(fila>= 0){
                     aux1=tabS.getValueAt(fila, 0).toString();
                     aux2=tabS.getValueAt(fila, 1).toString();
                     sql= "select grado, apellidos, nombres from subactividades,actividades where subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND subactividades.gestion='"+tabS.getValueAt(fila, 0).toString()+"' AND subactividades.codA='"+tabS.getValueAt(fila, 1).toString()+"' AND subactividades.act='"+tabS.getValueAt(fila, 3).toString()+"' AND subactividades.subA='"+tabS.getValueAt(fila, 4).toString()+"'";
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            aux3=rs.getString(1);
            aux4=rs.getString(2);
            aux5=rs.getString(3);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabS.getValueAt(fila, 3).toString();
                     aux7=tabS.getValueAt(fila, 4).toString();  
                     aux8=tabS.getValueAt(fila, 5).toString();
                     aux9=tabS.getValueAt(fila, 6).toString();
                     aux10=tabS.getValueAt(fila, 7).toString();
                     mS m=new mS(new java.awt.Frame(), true);
                     m.llenardatos(aux1, aux2, aux3, aux4, aux5, aux6, aux7, aux8, aux9,aux10);
                     m.setVisible(true);
                     mostrardatos8(m.getgestion(),m.getcA(),m.getact(),m.getsubA());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         int fila= tabS.getSelectedRow();
           String sql="";
           String aux1="";
           String aux2="";
           String aux3="";
           String aux4="";
           String aux5="";
           String aux6="";
           String aux7="";
           String aux8="";
           String aux9="";
           String aux10="";
        if(fila>= 0){
                    JOptionPane.showMessageDialog(null, "Al Eliminan todas las Evaluaciones Dependientes de este","",JOptionPane.WARNING_MESSAGE,icono);
                     aux1=tabS.getValueAt(fila, 0).toString();
                     aux2=tabS.getValueAt(fila, 1).toString();
                     sql= "select grado, apellidos, nombres from subactividades,actividades where subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND subactividades.gestion='"+tabS.getValueAt(fila, 0).toString()+"' AND subactividades.codA='"+tabS.getValueAt(fila, 1).toString()+"' AND subactividades.act='"+tabS.getValueAt(fila, 3).toString()+"' AND subactividades.subA='"+tabS.getValueAt(fila, 4).toString()+"'";
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            aux3=rs.getString(1);
            aux4=rs.getString(2);
            aux5=rs.getString(3);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabS.getValueAt(fila, 3).toString();
                     aux7=tabS.getValueAt(fila, 4).toString();  
                     aux8=tabS.getValueAt(fila, 5).toString();
                     aux9=tabS.getValueAt(fila, 6).toString();
                     aux10=tabS.getValueAt(fila, 7).toString();
                     eS e=new eS(new java.awt.Frame(), true);
                     e.llenardatos(aux1, aux2, aux3, aux4, aux5, aux6, aux7, aux8, aux9,aux10);
                     e.setVisible(true);
                     mostrardatos8(e.getgestion(),e.getcA(),e.getact(),e.getsubA());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    int fila= tabS.getSelectedRow();
        if(fila>= 0){  
            Evaluarpp e=new Evaluarpp(new java.awt.Frame(), true,tabS.getValueAt(fila, 0).toString(),tabS.getValueAt(fila, 1).toString(),tabS.getValueAt(fila, 3).toString(),tabS.getValueAt(fila, 4).toString());
            e.mostrardatos(tabS.getValueAt(fila, 0).toString(), tabS.getValueAt(fila, 1).toString(), tabS.getValueAt(fila, 3).toString(), tabS.getValueAt(fila, 4).toString());
            e.setVisible(true);
            mostrardatos8(e.getges(),e.getcA(),e.getact(),e.getsuba());
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        int fila= tabS.getSelectedRow();
        if(fila>= 0){  
            Evaluarsp e=new Evaluarsp(new java.awt.Frame(), true,tabS.getValueAt(fila, 0).toString(),tabS.getValueAt(fila, 1).toString(),tabS.getValueAt(fila, 3).toString(),tabS.getValueAt(fila, 4).toString());
            e.mostrardatos(tabS.getValueAt(fila, 0).toString(), tabS.getValueAt(fila, 1).toString(), tabS.getValueAt(fila, 3).toString(), tabS.getValueAt(fila, 4).toString());
            e.setVisible(true);
            mostrardatos8(e.getges(),e.getcA(),e.getact(),e.getsuba());
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int fila= tabS.getSelectedRow();
        if(fila>= 0){  
            Evaluarpf e=new Evaluarpf(new java.awt.Frame(), true,tabS.getValueAt(fila, 0).toString(),tabS.getValueAt(fila, 1).toString(),tabS.getValueAt(fila, 3).toString(),tabS.getValueAt(fila, 4).toString());
            e.mostrardatos(tabS.getValueAt(fila, 0).toString(), tabS.getValueAt(fila, 1).toString(), tabS.getValueAt(fila, 3).toString(), tabS.getValueAt(fila, 4).toString());
            e.setVisible(true);
            mostrardatos8(e.getges(),e.getcA(),e.getact(),e.getsuba());
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Report r=new Report(new java.awt.Frame(), true,this.cn,"RSubActividades.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos3(cCA.getText().toString());
        cAA.setText("");
        cNS.setText("");
        cNA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos4(cNS.getText());
        cAA.setText("");
        cCA.setText("");
        cNA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos2(cAA.getText().toString());
        cCA.setText("");
        cNS.setText("");
        cNA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos6(formato.format(fecha1));
        cAA.setText("");
        cCA.setText("");
        cNS.setText("");
        cNA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon5ActionPerformed
        mostrardatos5(cNA.getText());
        cAA.setText("");
        cCA.setText("");
        cNS.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon5ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos7(cPG.getText());
        cAA.setText("");
        cCA.setText("");
        cNS.setText("");
        cNA.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","","");
        cAA.setText("");
        cCA.setText("");
        cNS.setText("");
        cNA.setText("");
        cPG.setText("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono5);
    }//GEN-LAST:event_botAActionPerformed

    public void mostrardatos2(String valor){
     MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND actividades.apellidos='"+valor+"' ORDER BY actividades.apellidos,actividades.nombres";
     
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public void mostrardatos3(String valor){
     MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND actividades.codA='"+valor+"' ORDER BY actividades.apellidos,actividades.nombres";
     
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void mostrardatos4(String valor){
     MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND subactividades.subA='"+valor+"' ORDER BY actividades.apellidos,actividades.nombres";
     
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
    public void mostrardatos5(String valor){
     MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND actividades.act='"+valor+"' ORDER BY actividades.apellidos,actividades.nombres";
     
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        
    public void mostrardatos6(String valor){
     MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND subactividades.fFinal<='"+valor+"' ORDER BY actividades.apellidos,actividades.nombres";
     
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
          
     public void mostrardatos7(String valor){
     MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("SUB-ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    tabS.setModel(modelo);
    TableColumnModel columnModel = tabS.getColumnModel();
     columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(1).setPreferredWidth(110);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(3).setPreferredWidth(160);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(4).setPreferredWidth(160);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(5).setPreferredWidth(105);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(6).setPreferredWidth(105);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(6,7));
    columnModel.getColumn(10).setPreferredWidth(100);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(6,7));
    String sql="";
        sql="SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.act,subactividades.subA,subactividades.fInicio,subactividades.fFinal,subactividades.cump,subactividades.pp,subactividades.sp,subactividades.pf FROM actividades, subactividades WHERE subactividades.gestion=actividades.gestion AND subactividades.codA=actividades.codA AND subactividades.act=actividades.act AND actividades.gestion='"+valor+"' ORDER BY actividades.apellidos,actividades.nombres";
     
    Object []datos = new Object [12];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);       
                datos[3]=rs.getString(6);
                datos[4]=rs.getString(7);
                Date fecha1= rs.getDate(8);
                Date fecha2= rs.getDate(9);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[5]=formato.format(fecha1);
                datos[6]=formato.format(fecha2);
                datos[7]=rs.getBigDecimal(10);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                modelo.addRow(datos);
            }
            tabS.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(SubActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JButton botcon5;
    private javax.swing.JTextField cAA;
    private javax.swing.JTextField cCA;
    private javax.swing.JTextField cNA;
    private javax.swing.JTextField cNS;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabS;
    // End of variables declaration//GEN-END:variables
Conexion6 cc= new Conexion6();
Connection cn= cc.conexion();
}
