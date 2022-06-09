/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;

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
public class LActividades extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public LActividades() {
        initComponents();
        nom.addItem("POA");
        nom.addItem("PEI");
        nom.addItem("ACREDITACIÓN");
        nom.addItem("IDH");
        this.setTitle("UNIDAD DE PROYECTOS");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabPro.getTableHeader().setPreferredSize(new Dimension(10,50));
        tabPro.getTableHeader().setFont(new Font("Lucida Grande", 1, 9));
        tabPro.setRowHeight(170);
        icono =new Advertencia();
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
        this.setVisible(true);       
    }
  void mostrardatos(String valor,String valor2,String valor3,String valor4){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
    if(valor.equals("")&&valor2.equals("")&&valor3.equals("")&&valor4.equals(""))
    {
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion ORDER BY proyecto.codP, institucional.gestion";
    }
    else{
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND actividad.gestion='"+valor+"' AND actividad.codP='"+valor2+"' AND actividad.responsable='"+valor3+"' AND actividad.nominacion='"+valor4+"' ORDER BY proyecto.codP, institucional.gestion";
    }
 
    Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
  
  public void mostrardatos9(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND actividad.gestion='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";

    Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPro = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cP = new javax.swing.JTextField();
        ccP = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        botcon2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        cPF = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        botcon4 = new javax.swing.JButton();
        botcon3 = new javax.swing.JButton();
        nom = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cPG2 = new javax.swing.JTextField();
        nom2 = new javax.swing.JComboBox<>();
        botcon5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("Ver Productos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPro.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tabPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabPro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabPro.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabPro);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTIVIDADES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Consultar por Código del Proyecto:");
        jLabel5.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("Consultar por nombre del Responsable:");
        jLabel21.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por Nominación:");
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
        jLabel3.setText("Consultar por gestión:");
        jLabel3.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por la Fecha Final:");
        jLabel2.setOpaque(true);

        botcon4.setBackground(new java.awt.Color(0, 72, 225));
        botcon4.setForeground(new java.awt.Color(255, 255, 255));
        botcon4.setText("Consultar");
        botcon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon4ActionPerformed(evt);
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
        jLabel4.setText("Consultar por Gestión y Nominación:");
        jLabel4.setOpaque(true);

        nom2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POA", "PEI", "ACREDITACIÓN", "IDH" }));

        botcon5.setBackground(new java.awt.Color(0, 72, 225));
        botcon5.setForeground(new java.awt.Color(255, 255, 255));
        botcon5.setText("Consultar");
        botcon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccP))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon2))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cP, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPG)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botcon4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(botcon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPG2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botcon)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ccP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cPG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(jLabel3)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(botcon2)
                        .addComponent(jLabel2)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon4))
                .addGap(6, 6, 6))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        Lproyecto p =new Lproyecto();
        p.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos3(ccP.getText());
        cP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos2(cP.getText().toString());
        ccP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos4(nom.getSelectedItem().toString());
        ccP.setText("");
        cP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos6(formato.format(fecha1));
        ccP.setText("");
        cP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        mostrardatos5(cPG.getText());
        ccP.setText("");
        cP.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tabPro.getSelectedRow();
        if(fila>= 0){
            this.setVisible(false);
            LProductos p= new LProductos();
            p.mostrardatos(tabPro.getValueAt(fila, 0).toString(),tabPro.getValueAt(fila, 1).toString(),tabPro.getValueAt(fila, 9).toString(),tabPro.getValueAt(fila, 10).toString(),tabPro.getValueAt(fila, 11).toString());
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botcon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon5ActionPerformed
        mostrardatos7(cPG2.getText(),nom2.getSelectedItem().toString());
        ccP.setText("");
        cP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon5ActionPerformed
 void mostrardatos2(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.responsable='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
    
    Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 void mostrardatos3(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.codP='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
    
        Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
  void mostrardatos4(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND institucional.nominacion='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
    
        Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
  
  void mostrardatos5(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND institucional.gestion='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
    
        Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
  
  void mostrardatos6(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND actividad.fechaF<='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
    
        Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
  
  public void mostrardatos7(String valor,String valor2){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND institucional.gestion='"+valor+"' AND institucional.nominacion='"+valor2+"' ORDER BY proyecto.codP, institucional.gestion";
    
        Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JButton botcon5;
    private javax.swing.JTextField cP;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField cPG2;
    private javax.swing.JTextField ccP;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nom;
    private javax.swing.JComboBox<String> nom2;
    private javax.swing.JTable tabPro;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
Connection cn= cc.conexion();
}
