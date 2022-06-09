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
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
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
public class LUnidadTematica extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono2;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
    public LUnidadTematica() {
        initComponents();
        this.setTitle("PREGRADO");
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
        this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabUT.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabUT.setRowHeight(200);
        icono =new Advertencia();
        icono2=new BotConsul();
        icono3=new BotTodos();
        icono4=new BotInsertar();
        icono5=new BotAct();
        icono6=new Bien2();      
        botcon.setIcon(icono2);
        botcon2.setIcon(icono2);
        botcon3.setIcon(icono2);
        botcon4.setIcon(icono2);
        botcon5.setIcon(icono2);
        botcon6.setIcon(icono2);
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
        this.setVisible(true);
        
    }

     void mostrardatos(String valor1, String valor2, String valor3, String valor4){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
   if(valor1.equals("")&& valor2.equals("")&& valor3.equals("")&& valor4.equals(""))
    {
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion ORDER BY materia.apellidos, materia.nombres";
    }
    else{
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND unidadtematica.codigoMateria='"+valor1+"' AND unidadtematica.gestion='"+valor2+"' AND unidadtematica.codDoc='"+valor3+"' AND unidadtematica.codCarr='"+valor4+"' ORDER BY materia.apellidos, materia.nombres";
    }
    Date aux;
    BigDecimal aux2;
    String sql2="";
    Object []datos = new Object [13];
    Calendar calendario = GregorianCalendar.getInstance();
    Date fecha3 = calendario.getTime();
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formato2= new SimpleDateFormat("yyyy-MM-dd");
    sql2="select fechaFin,cumplido from unidadtematica where fechaFin<='"+formato2.format(fecha3)+"' AND cumplido<'"+BigDecimal.valueOf(100.00)+"'";
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);      
                modelo.addRow(datos);
            }
              
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LUnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }

     }

       public void mostrardatos9(String valor1){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND unidadtematica.gestion='"+valor1+"' ORDER BY materia.apellidos, materia.nombres";
    
    Date aux;
    BigDecimal aux2;
    String sql2="";
    Object []datos = new Object [13];
    Calendar calendario = GregorianCalendar.getInstance();
    Date fecha3 = calendario.getTime();
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formato2= new SimpleDateFormat("yyyy-MM-dd");
    sql2="select fechaFin,cumplido from unidadtematica where fechaFin<='"+formato2.format(fecha3)+"' AND cumplido<'"+BigDecimal.valueOf(100.00)+"'";
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);      
                modelo.addRow(datos);
            }
              
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }

     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUT = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel10 = new javax.swing.JLabel();
        cPF = new com.toedter.calendar.JDateChooser();
        botcon2 = new javax.swing.JButton();
        botcon6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        cCM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botcon4 = new javax.swing.JButton();
        botcon = new javax.swing.JButton();
        cAD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cNM = new javax.swing.JTextField();
        botcon3 = new javax.swing.JButton();
        cM = new javax.swing.JTextField();
        botcon5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem7.setText("ver Actividades");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabUT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabUT.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabUT.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabUT);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UNIDAD TEMATICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Consultar por el código de Unidad Tematica:");
        jLabel10.setOpaque(true);

        botcon2.setBackground(new java.awt.Color(0, 72, 225));
        botcon2.setForeground(new java.awt.Color(255, 255, 255));
        botcon2.setText("Consultar");
        botcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon2ActionPerformed(evt);
            }
        });

        botcon6.setBackground(new java.awt.Color(0, 72, 225));
        botcon6.setForeground(new java.awt.Color(255, 255, 255));
        botcon6.setText("Consultar");
        botcon6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon6ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Consultar por Gestión:");
        jLabel4.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por Código de Materia:");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por nombre de Materia:");
        jLabel2.setOpaque(true);

        botcon4.setBackground(new java.awt.Color(0, 72, 225));
        botcon4.setForeground(new java.awt.Color(255, 255, 255));
        botcon4.setText("Consultar");
        botcon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon4ActionPerformed(evt);
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

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("consultar por Código  Docente:");
        jLabel8.setOpaque(true);

        botcon3.setBackground(new java.awt.Color(0, 72, 225));
        botcon3.setForeground(new java.awt.Color(255, 255, 255));
        botcon3.setText("Consultar");
        botcon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon3ActionPerformed(evt);
            }
        });

        botcon5.setBackground(new java.awt.Color(0, 72, 225));
        botcon5.setForeground(new java.awt.Color(255, 255, 255));
        botcon5.setText("Consultar");
        botcon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon5ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por fecha Final:");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cAD, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cNM, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(247, 247, 247))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cM, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cCM, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon)
                    .addComponent(jLabel2)
                    .addComponent(cNM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2)
                    .addComponent(cCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botcon3)
                            .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botcon6)))
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
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
                    .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        LMateria m= new LMateria();
        m.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         int fila= tabUT.getSelectedRow();
        if(fila>= 0){
            this.setVisible(false);
            LActividad a=new LActividad();
            a.mostrardatos(tabUT.getValueAt(fila, 3).toString(),tabUT.getValueAt(fila, 10).toString(),tabUT.getValueAt(fila, 0).toString(),tabUT.getValueAt(fila, 11).toString(),tabUT.getValueAt(fila, 1).toString());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos2(cM.getText());
        cAD.setText("");
        cCM.setText("");
        cNM.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon6ActionPerformed
        mostrardatos7(cPG.getText());
        cNM.setText("");
        cAD.setText("");
        cM.setText("");
        cCM.setText("");
    }//GEN-LAST:event_botcon6ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos5(cNM.getText());
        cAD.setText("");
        cM.setText("");
        cCM.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos3(cAD.getText());
        cM.setText("");
        cCM.setText("");
        cNM.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos6(formato.format(fecha1));
        cAD.setText("");
        cM.setText("");
        cCM.setText("");
        cPG.setText("");
        cNM.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon5ActionPerformed
        mostrardatos4(cCM.getText().toString());
        cNM.setText("");
        cAD.setText("");
        cM.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon5ActionPerformed

     void mostrardatos2(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("FECHA INICIO");
    modelo.addColumn("FECHA FINAL");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
   
       sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND materia.apellidos='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [13];
    
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);
                modelo.addRow(datos);
            }
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LUnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

       void mostrardatos3(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("FECHA INICIO");
    modelo.addColumn("FECHA FINAL");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
   
      sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND materia.codigoDocente='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [13];
    
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);
                modelo.addRow(datos);
            }
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LUnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
       
      void mostrardatos4(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("FECHA INICIO");
    modelo.addColumn("FECHA FINAL");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
   
     sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND materia.codigoMateria='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [13];
    
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);
                modelo.addRow(datos);
            }
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LUnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }   
    void mostrardatos5(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("FECHA INICIO");
    modelo.addColumn("FECHA FINAL");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
   
     sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND materia.nombreMateria='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [13];
    
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);
                modelo.addRow(datos);
            }
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LUnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }  
     void mostrardatos6(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("FECHA INICIO");
    modelo.addColumn("FECHA FINAL");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
   
     sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND unidadtematica.fechaFin<='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [13];
    
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);
                modelo.addRow(datos);
            }
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LUnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
     
      void mostrardatos7(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("<html>CÓDIGO<br>UNIDAD TEMA.</html>");
    modelo.addColumn("UNIDAD TEMÁTICA");
    modelo.addColumn("MATERIA");
    modelo.addColumn("CARRERA");
    modelo.addColumn("FECHA INICIO");
    modelo.addColumn("FECHA FINAL");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    tabUT.setModel(modelo);
    TableColumnModel columnModel = tabUT.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(90);
   columnModel.getColumn(0).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(1).setPreferredWidth(120);
   columnModel.getColumn(1).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(2).setPreferredWidth(170);
   columnModel.getColumn(2).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(3).setPreferredWidth(120);
   columnModel.getColumn(3).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(4).setPreferredWidth(170);
   columnModel.getColumn(4).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(5).setPreferredWidth(140);
   columnModel.getColumn(5).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(6).setPreferredWidth(140);
   columnModel.getColumn(6).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(7).setPreferredWidth(90);
   columnModel.getColumn(7).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(8).setPreferredWidth(90);
   columnModel.getColumn(8).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(9).setPreferredWidth(90);
   columnModel.getColumn(9).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(10).setPreferredWidth(90);
   columnModel.getColumn(10).setCellRenderer(new MyRen2(8,9));
   columnModel.getColumn(11).setPreferredWidth(90);
   columnModel.getColumn(11).setCellRenderer(new MyRen2(8,9));
    String sql="";
   
     sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND carrera.gestion='"+valor+"' ORDER BY materia.apellidos, materia.nombres";
    
    Object []datos = new Object [13];
    
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
                Date fecha1= rs.getDate(10);
                Date fecha2= rs.getDate(11);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[7]=formato.format(fecha1);
                datos[8]=formato.format(fecha2);
                datos[9]=rs.getBigDecimal(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getString(14);
                modelo.addRow(datos);
            }
            tabUT.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LUnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JButton botcon5;
    private javax.swing.JButton botcon6;
    private javax.swing.JTextField cAD;
    private javax.swing.JTextField cCM;
    private javax.swing.JTextField cM;
    private javax.swing.JTextField cNM;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUT;
    // End of variables declaration//GEN-END:variables
 Conexion1 cc= new Conexion1();
 Connection cn= cc.conexion();
}
