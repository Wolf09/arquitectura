/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investigacion;

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
import text.Abrir;
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
public class Investigador extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public Investigador() {
        initComponents();
        this.setTitle("INSTITUTO DE INVESTIGACIONES");
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabI.getTableHeader().setPreferredSize(new Dimension(20,50));
        tabI.getTableHeader().setFont(new Font("Lucida Grande", 1, 9));
        tabI.setRowHeight(240);
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
        botI.setIcon(icono3);
        botA.setIcon(icono4);
        botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
        this.setVisible(true);
        
    }
   void mostrardatos(String valor,String valor2){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>INVESTIGADOR</html>");
    modelo.addColumn("INVESTIGADOR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>INVESTIGACIÓN<br>ACTUAL</html>");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    modelo.addColumn("ÁREA TEMÁTICA");
    modelo.addColumn("<html>CÓDIGO ÁREA<br>TEMÁTICA</html>");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(12).setPreferredWidth(140);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(13).setPreferredWidth(90);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(7,8));
    String sql="";
    if(valor.equals("")&& valor2.equals(""))
    {
        sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT ORDER BY investigador.apellidos, investigador.nombres";
    }
    else{
        sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT AND investigador.gestion='"+valor+"' AND investigador.codigoAT='"+valor2+"' ORDER BY investigador.apellidos, investigador.nombres";
    }
 
    Object []datos = new Object [15];
    
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
                Date fecha1= rs.getDate(9);
                Date fecha2= rs.getDate(10);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[6]=formato.format(fecha1);
                datos[7]=formato.format(fecha2);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
   public void mostrardatos8(String valor,String valor2,String valor3,String valor4){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>INVESTIGADOR</html>");
    modelo.addColumn("INVESTIGADOR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>INVESTIGACIÓN<br>ACTUAL</html>");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    modelo.addColumn("ÁREA TEMÁTICA");
    modelo.addColumn("<html>CÓDIGO ÁREA<br>TEMÁTICA</html>");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(12).setPreferredWidth(140);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(13).setPreferredWidth(90);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(7,8));
    String sql="";
        sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT AND investigador.gestion='"+valor+"' AND investigador.codigoInv='"+valor2+"' AND investigador.investigacionActual='"+valor3+"' AND investigador.codigoAT='"+valor4+"' ORDER BY investigador.apellidos, investigador.nombres";

    Object []datos = new Object [15];
    
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
                Date fecha1= rs.getDate(9);
                Date fecha2= rs.getDate(10);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[6]=formato.format(fecha1);
                datos[7]=formato.format(fecha2);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabI = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel15 = new javax.swing.JLabel();
        concodI = new javax.swing.JTextField();
        ccAT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botcon2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botcon1 = new javax.swing.JButton();
        botcon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cPF = new com.toedter.calendar.JDateChooser();
        cAP = new javax.swing.JTextField();
        botcon4 = new javax.swing.JButton();
        botcon3 = new javax.swing.JButton();
        botI = new javax.swing.JButton();
        botA = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

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

        jMenuItem1.setText("ELIMINAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem7.setText("EVALUAR PRIMER PRODUCTO");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

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

        jMenuItem10.setText("VER RECURSO");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem10);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabI.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabI.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabI);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INVESTIGADORES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Consultar por código del Investigador:");
        jLabel15.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Consultar por Area Tematica:");
        jLabel9.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por Apellidos del Investigador Debe Ingresar Todos los apellidos:");
        jLabel1.setOpaque(true);

        botcon1.setBackground(new java.awt.Color(0, 72, 225));
        botcon1.setForeground(new java.awt.Color(255, 255, 255));
        botcon1.setText("Consultar");
        botcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon1ActionPerformed(evt);
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

        botcon3.setBackground(new java.awt.Color(0, 72, 225));
        botcon3.setForeground(new java.awt.Color(255, 255, 255));
        botcon3.setText("Consultar");
        botcon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon3ActionPerformed(evt);
            }
        });

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("INSERTAR");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
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
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(concodI, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(botI))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cAP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon4))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccAT, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botA)))
                .addContainerGap())
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botcon3)
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(concodI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon)
                        .addComponent(jLabel2)
                        .addComponent(botI)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ccAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(botA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2)
                    .addComponent(jLabel1)
                    .addComponent(cAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon4))
                .addGap(0, 10, Short.MAX_VALUE))
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

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Generar Reporte");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        Institucional i= new Institucional();
        i.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
          int fila= tabI.getSelectedRow();
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
           String aux11="";
           String aux12="";
        if(fila>= 0){
                         aux1=tabI.getValueAt(fila, 0).toString();
                         aux2=tabI.getValueAt(fila, 1).toString();
                         sql= "select grado, apellidos, nombres from investigador where gestion='"+tabI.getValueAt(fila, 0).toString()+"' AND codigoInv='"+tabI.getValueAt(fila, 1).toString()+"' AND investigacionActual='"+tabI.getValueAt(fila, 5)+"' AND codigoAT='"+tabI.getValueAt(fila, 13).toString()+"'";
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
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabI.getValueAt(fila, 3).toString();
                     aux7=tabI.getValueAt(fila, 4).toString();
                     aux8=tabI.getValueAt(fila, 6).toString();
                     aux9=tabI.getValueAt(fila, 7).toString();
                     aux10=tabI.getValueAt(fila, 8).toString();
                     aux11=tabI.getValueAt(fila, 12).toString();
                     aux12=tabI.getValueAt(fila, 13).toString();
                     iIn i=new iIn(new java.awt.Frame(), true);
                     i.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12);
                     i.setVisible(true);
                     mostrardatos8(i.getgestion(),i.getcodI(),i.getinvA(),i.getcodAT());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         int fila= tabI.getSelectedRow();
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
           String aux11="";
           String aux12="";
           String aux13="";
        if(fila>= 0){
                        
                        aux1=tabI.getValueAt(fila, 0).toString();
                        aux2=tabI.getValueAt(fila, 1).toString();
                         sql= "select grado, apellidos, nombres from investigador where gestion='"+tabI.getValueAt(fila, 0).toString()+"' AND codigoInv='"+tabI.getValueAt(fila, 1).toString()+"' AND investigacionActual='"+tabI.getValueAt(fila, 5)+"' AND codigoAT='"+tabI.getValueAt(fila, 13).toString()+"'";
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
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabI.getValueAt(fila, 3).toString();
                     aux7=tabI.getValueAt(fila, 4).toString();
                     aux8=tabI.getValueAt(fila, 5).toString();
                     aux9=tabI.getValueAt(fila, 6).toString();
                     aux10=tabI.getValueAt(fila, 7).toString();
                     aux11=tabI.getValueAt(fila, 8).toString();
                     aux12=tabI.getValueAt(fila, 12).toString();
                     aux13=tabI.getValueAt(fila, 13).toString();
                     mIn m=new mIn(new java.awt.Frame(), true);
                     m.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13);
                     m.setVisible(true);
                     mostrardatos8(m.getgestion(),m.getcodI(),m.getinvA(),m.getcodAT());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tabI.getSelectedRow();
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
           String aux11="";
           String aux12="";
           String aux13="";
        if(fila>= 0){
                        JOptionPane.showMessageDialog(null, "Al Eliminar un Investigador se eliminan todas las Evaluaciones, Dependientes de este","",JOptionPane.WARNING_MESSAGE,icono);   
                        aux1=tabI.getValueAt(fila, 0).toString();
                        aux2=tabI.getValueAt(fila, 1).toString();
                        sql= "select grado, apellidos, nombres from investigador where gestion='"+tabI.getValueAt(fila, 0).toString()+"' AND codigoInv='"+tabI.getValueAt(fila, 1).toString()+"' AND investigacionActual='"+tabI.getValueAt(fila, 5)+"' AND codigoAT='"+tabI.getValueAt(fila, 13).toString()+"'";
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
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabI.getValueAt(fila, 3).toString();
                     aux7=tabI.getValueAt(fila, 4).toString();
                     aux8=tabI.getValueAt(fila, 5).toString();
                     aux9=tabI.getValueAt(fila, 6).toString();
                     aux10=tabI.getValueAt(fila, 7).toString();
                     aux11=tabI.getValueAt(fila, 8).toString();
                     aux12=tabI.getValueAt(fila, 12).toString();
                     aux13=tabI.getValueAt(fila, 13).toString();
                     eIn e=new eIn(new java.awt.Frame(), true);
                     e.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13);
                     e.setVisible(true);
                     mostrardatos8(e.getgestion(),e.getcodI(),e.getinvA(),e.getcodAT());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         int fila= tabI.getSelectedRow();
        if(fila>= 0){
            Evaluarpp e=new Evaluarpp(new java.awt.Frame(), true,tabI.getValueAt(fila, 0).toString(),tabI.getValueAt(fila, 1).toString(),tabI.getValueAt(fila, 5).toString(),tabI.getValueAt(fila, 13).toString());
            e.mostrardatos(tabI.getValueAt(fila, 0).toString(),tabI.getValueAt(fila, 1).toString(),tabI.getValueAt(fila, 5).toString(),tabI.getValueAt(fila, 13).toString());
            e.setVisible(true);
            mostrardatos8(e.getges(),e.getcI(),e.getia(),e.getcat());
         }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
         int fila= tabI.getSelectedRow();
        if(fila>= 0){
            Evaluarsp e=new Evaluarsp(new java.awt.Frame(), true,tabI.getValueAt(fila, 0).toString(),tabI.getValueAt(fila, 1).toString(),tabI.getValueAt(fila, 5).toString(),tabI.getValueAt(fila, 13).toString());
            e.mostrardatos(tabI.getValueAt(fila, 0).toString(),tabI.getValueAt(fila, 1).toString(),tabI.getValueAt(fila, 5).toString(),tabI.getValueAt(fila, 13).toString());
            e.setVisible(true);
            mostrardatos8(e.getges(),e.getcI(),e.getia(),e.getcat());
         }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int fila= tabI.getSelectedRow();
        if(fila>= 0){
            Evaluarpf e=new Evaluarpf(new java.awt.Frame(), true,tabI.getValueAt(fila, 0).toString(),tabI.getValueAt(fila, 1).toString(),tabI.getValueAt(fila, 5).toString(),tabI.getValueAt(fila, 13).toString());
            e.mostrardatos(tabI.getValueAt(fila, 0).toString(),tabI.getValueAt(fila, 1).toString(),tabI.getValueAt(fila, 5).toString(),tabI.getValueAt(fila, 13).toString());
            e.setVisible(true);
            mostrardatos8(e.getges(),e.getcI(),e.getia(),e.getcat());
         }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        int fila= tabI.getSelectedRow();
         String sep = System.getProperty("line.separator");
        if(fila>= 0){
                     String sql="";
                     String aux="";
                     Abrir a=new Abrir();
                                   sql= "select recurso from investigador WHERE gestion='"+tabI.getValueAt(fila, 0).toString()+"' AND codigoInv='"+tabI.getValueAt(fila, 1).toString()+"' AND investigacionActual='"+tabI.getValueAt(fila, 5).toString()+"' AND codigoAT='"+tabI.getValueAt(fila, 13).toString()+"'";
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            aux=rs.getString(1);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
            }
                     a.launchFile("\\\\167.157.17.39\\investigacion\\"+aux+"");
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Report r=new Report(new java.awt.Frame(), true,this.cn,"RInvestigador.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos6(cPG.getText());
        concodI.setText("");
        ccAT.setText("");
        cAP.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos3(ccAT.getText());
        concodI.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos2(concodI.getText().toString());
        ccAT.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos5(cAP.getText());
        concodI.setText("");
        ccAT.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos4(formato.format(fecha1));
        concodI.setText("");
        ccAT.setText("");
        cPG.setText("");
        cAP.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        Double aux5=0.0;
        BigDecimal aux6= BigDecimal.valueOf(aux5);
        SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
        iIn i=new iIn(new java.awt.Frame(), true);
        i.llenardatos("","","Dr.","","","","",formato.format(fecha1),formato.format(fecha1),"0","","");
        i.setVisible(true);
        mostrardatos8(i.getgestion(),i.getcodI(),i.getinvA(),i.getcodAT());
    }//GEN-LAST:event_botIActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","");
        concodI.setText("");
        ccAT.setText("");
        cPG.setText("");
        cAP.setText("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono5);
    }//GEN-LAST:event_botAActionPerformed
void mostrardatos2(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>INVESTIGADOR</html>");
    modelo.addColumn("INVESTIGADOR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>INVESTIGACIÓN<br>ACTUAL</html>");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    modelo.addColumn("ÁREA TEMÁTICA");
    modelo.addColumn("<html>CÓDIGO ÁREA<br>TEMÁTICA</html>");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(12).setPreferredWidth(140);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(13).setPreferredWidth(90);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(7,8));
    String sql="";
      sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT AND investigador.codigoInv='"+valor+"' ORDER BY investigador.apellidos, investigador.nombres";
  Object []datos = new Object [15];
    
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
                Date fecha1= rs.getDate(9);
                Date fecha2= rs.getDate(10);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[6]=formato.format(fecha1);
                datos[7]=formato.format(fecha2);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    void mostrardatos3(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>INVESTIGADOR</html>");
    modelo.addColumn("INVESTIGADOR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>INVESTIGACIÓN<br>ACTUAL</html>");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    modelo.addColumn("ÁREA TEMÁTICA");
    modelo.addColumn("<html>CÓDIGO ÁREA<br>TEMÁTICA</html>");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(12).setPreferredWidth(140);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(13).setPreferredWidth(90);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(7,8));
    String sql="";
      sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT AND institucional.areaTematica='"+valor+"' ORDER BY investigador.apellidos, investigador.nombres";
   Object []datos = new Object [15];
    
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
                Date fecha1= rs.getDate(9);
                Date fecha2= rs.getDate(10);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[6]=formato.format(fecha1);
                datos[7]=formato.format(fecha2);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
     void mostrardatos4(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>INVESTIGADOR</html>");
    modelo.addColumn("INVESTIGADOR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>INVESTIGACIÓN<br>ACTUAL</html>");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    modelo.addColumn("ÁREA TEMÁTICA");
    modelo.addColumn("<html>CÓDIGO ÁREA<br>TEMÁTICA</html>");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(12).setPreferredWidth(140);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(13).setPreferredWidth(90);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(7,8));
    String sql="";
      sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT AND investigador.fechaF<='"+valor+"' ORDER BY investigador.apellidos, investigador.nombres";
   Object []datos = new Object [15];
    
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
                Date fecha1= rs.getDate(9);
                Date fecha2= rs.getDate(10);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[6]=formato.format(fecha1);
                datos[7]=formato.format(fecha2);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
      void mostrardatos5(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>INVESTIGADOR</html>");
    modelo.addColumn("INVESTIGADOR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>INVESTIGACIÓN<br>ACTUAL</html>");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    modelo.addColumn("ÁREA TEMÁTICA");
    modelo.addColumn("<html>CÓDIGO ÁREA<br>TEMÁTICA</html>");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(12).setPreferredWidth(140);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(13).setPreferredWidth(90);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(7,8));
    String sql="";
      sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT AND investigador.apellidos='"+valor+"' ORDER BY investigador.apellidos, investigador.nombres";
   Object []datos = new Object [15];
    
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
                Date fecha1= rs.getDate(9);
                Date fecha2= rs.getDate(10);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[6]=formato.format(fecha1);
                datos[7]=formato.format(fecha2);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
      
     void mostrardatos6(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>INVESTIGADOR</html>");
    modelo.addColumn("INVESTIGADOR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("<html>INVESTIGACIÓN<br>ACTUAL</html>");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
    modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
    modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
    modelo.addColumn("ÁREA TEMÁTICA");
    modelo.addColumn("<html>CÓDIGO ÁREA<br>TEMÁTICA</html>");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(12).setPreferredWidth(140);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(7,8));
    columnModel.getColumn(13).setPreferredWidth(90);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(7,8));
    String sql="";
      sql="SELECT institucional.gestion,investigador.codigoInv,investigador.grado,investigador.apellidos,investigador.nombres,investigador.email,investigador.telefono,investigador.investigacionActual,investigador.fechaI,investigador.fechaF,investigador.cumplimiento,investigador.pp,investigador.sp,investigador.pf,institucional.areaTematica,institucional.codigoAT FROM investigador,institucional WHERE investigador.gestion=institucional.gestion AND investigador.codigoAT=institucional.codigoAT AND institucional.gestion='"+valor+"' ORDER BY investigador.apellidos, investigador.nombres";
   Object []datos = new Object [15];
    
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
                Date fecha1= rs.getDate(9);
                Date fecha2= rs.getDate(10);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[6]=formato.format(fecha1);
                datos[7]=formato.format(fecha2);
                datos[8]=rs.getBigDecimal(11);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getBigDecimal(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                datos[13]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Investigador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
    private javax.swing.JButton botI;
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JTextField cAP;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField ccAT;
    private javax.swing.JTextField concodI;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
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
    private javax.swing.JTable tabI;
    // End of variables declaration//GEN-END:variables
Conexion3 cc= new Conexion3();
Connection cn= cc.conexion();
}
