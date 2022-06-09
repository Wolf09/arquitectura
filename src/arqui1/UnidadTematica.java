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
public class UnidadTematica extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono2;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
    public UnidadTematica() {
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
        botA.setIcon(icono5);
        botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
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
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
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
     public  void mostrardatos8(String valor1, String valor2, String valor3, String valor4,String valor5){
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
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,unidadtematica.fechaInicio,unidadtematica.fechaFin,unidadtematica.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM unidadtematica, materia, carrera WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND unidadtematica.cUT='"+valor1+"' AND unidadtematica.codCarr='"+valor2+"' AND unidadtematica.gestion='"+valor3+"' AND unidadtematica.codigoMateria='"+valor4+"' AND unidadtematica.codDoc='"+valor5+"' ORDER BY materia.apellidos, materia.nombres";
 
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
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
        botA = new javax.swing.JButton();
        botcon5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("INSERTAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem5.setText("MODIFICAR");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem6.setText("ELIMINAR");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);

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

        botA.setBackground(new java.awt.Color(0, 72, 225));
        botA.setForeground(new java.awt.Color(255, 255, 255));
        botA.setText("ACTUALIZAR");
        botA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(botA, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
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
                    .addComponent(botA)
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

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Generar Reporte");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

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
        Materia m= new Materia();
        m.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tabUT.getSelectedRow();
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
                      aux1= tabUT.getValueAt(fila, 0).toString();
                      aux2= tabUT.getValueAt(fila, 1).toString();
                      sql= "select grado, apellidos, nombres from materia,unidadtematica WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera  AND unidadtematica.cUT='"+tabUT.getValueAt(fila, 3).toString()+"' AND unidadtematica.codCarr='"+tabUT.getValueAt(fila, 10).toString()+"' AND unidadtematica.gestion='"+tabUT.getValueAt(fila, 0).toString()+"' AND unidadtematica.codigoMateria='"+tabUT.getValueAt(fila, 11).toString()+"' AND unidadtematica.codDoc='"+tabUT.getValueAt(fila, 1).toString()+"'";
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
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabUT.getValueAt(fila, 5).toString();
                     aux7=tabUT.getValueAt(fila, 6).toString();
                     aux8=tabUT.getValueAt(fila, 7).toString();
                     aux9=tabUT.getValueAt(fila, 8).toString();
                     aux10=tabUT.getValueAt(fila, 9).toString();
                     aux11=tabUT.getValueAt(fila, 10).toString();
                     aux12=tabUT.getValueAt(fila, 11).toString();
            iUT i=new iUT(new java.awt.Frame(), true);
            i.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12);
            i.setVisible(true);
            mostrardatos8(i.getcUT(),i.getcodCarr(),i.getgestion(),i.getcodMat(),i.getcodDoc());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int fila= tabUT.getSelectedRow();
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
        String aux14="";
        String aux15="";
        String aux16="";
        String aux17="";
        String aux18="";     
        String aux19="";
        String aux20="";
        String aux21="";
        String aux22="";
        String aux23="";
        String aux24="";
        String aux25="";     
        String aux26="";
        String aux27="";
        if(fila>= 0){
             Usuario u= new Usuario("");
            //u.setVisible(false);
            String sql2="select responsable1,responsable2,responsable3,responsable4,responsable5,responsable6 from user where nombreUsuario='"+u.getUser()+"'";
            String sql3="select materia1,materia2,materia3,materia4,materia5,materia6,materia7 from user where nombreUsuario='"+u.getUser()+"'";
            try {
            Statement st = cn2.createStatement();
            ResultSet rs = st.executeQuery(sql2);
             while(rs.next())
               {
                aux15=rs.getString(1);
                aux16 =rs.getString(2);
                aux17 =rs.getString(3);
                aux18 =rs.getString(4);
                aux19 =rs.getString(5);
                aux20 =rs.getString(6);
               }
           if(aux15.equals("DOCENTEPREGRADO")||aux15.equals("PREGRADO")||aux16.equals("PREGRADO")||aux17.equals("PREGRADO")||aux18.equals("PREGRADO")||aux19.equals("PREGRADO")||aux20.equals("PREGRADO")){
            try {
            Statement st2 = cn2.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
             while(rs2.next())
               {
                aux21=rs2.getString(1);
                aux22 =rs2.getString(2);
                aux23 =rs2.getString(3);
                aux24 =rs2.getString(4);
                aux25 =rs2.getString(5);
                aux26 =rs2.getString(6);
                aux27 =rs2.getString(7);
               }
             if(aux21.equals(tabUT.getValueAt(fila, 5).toString())||aux21.equals("TODO")||aux22.equals(tabUT.getValueAt(fila, 5).toString())||aux23.equals(tabUT.getValueAt(fila, 5).toString())||aux24.equals(tabUT.getValueAt(fila, 5).toString())||aux25.equals(tabUT.getValueAt(fila, 5).toString())||aux26.equals(tabUT.getValueAt(fila, 5).toString())||aux27.equals(tabUT.getValueAt(fila, 5).toString())){
                      aux1= tabUT.getValueAt(fila, 0).toString();
                      aux2= tabUT.getValueAt(fila, 1).toString();
                      sql= "select grado, apellidos, nombres from materia,unidadtematica WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera  AND unidadtematica.cUT='"+tabUT.getValueAt(fila, 3).toString()+"' AND unidadtematica.codCarr='"+tabUT.getValueAt(fila, 10).toString()+"' AND unidadtematica.gestion='"+tabUT.getValueAt(fila, 0).toString()+"' AND unidadtematica.codigoMateria='"+tabUT.getValueAt(fila, 11).toString()+"' AND unidadtematica.codDoc='"+tabUT.getValueAt(fila, 1).toString()+"'";
            try {
            Statement st3 = cn.createStatement();
            ResultSet rs3 = st3.executeQuery(sql);
            while(rs3.next()){
            aux3=rs3.getString(1);
            aux4=rs3.getString(2);
            aux5=rs3.getString(3);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabUT.getValueAt(fila, 3).toString();
                     aux7=tabUT.getValueAt(fila, 4).toString();
                     aux8=tabUT.getValueAt(fila, 5).toString();
                     aux9=tabUT.getValueAt(fila, 6).toString();
                     aux10=tabUT.getValueAt(fila, 7).toString();
                     aux11=tabUT.getValueAt(fila, 8).toString();
                     aux12=tabUT.getValueAt(fila, 9).toString();
                     aux13=tabUT.getValueAt(fila, 10).toString();
                     aux14=tabUT.getValueAt(fila, 11).toString();
            mUT m=new mUT(new java.awt.Frame(), true);
            m.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14);
            m.setVisible(true);
            mostrardatos8(m.getcUT(),m.getcodCarr(),m.getgestion(),m.getcodMat(),m.getcodDoc());
            }
            else{
            JOptionPane.showMessageDialog(null, "Usted NO tiene permisos para modificar otras Materias, solo las suyas","",JOptionPane.WARNING_MESSAGE,icono);
          }  
             } catch (SQLException ex) {
         Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
         }
       } 
            else{
            JOptionPane.showMessageDialog(null, "Usted NO tiene permisos para modificar otras Materias, solo las suyas","",JOptionPane.WARNING_MESSAGE,icono);
          }
            } catch (SQLException ex) {
           Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int fila= tabUT.getSelectedRow();
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
        String aux14="";
        String aux15="";
        String aux16="";
        String aux17="";
        String aux18="";     
        String aux19="";
        String aux20="";
        String aux21="";
        String aux22="";
        String aux23="";
        String aux24="";
        String aux25="";     
        String aux26="";
        String aux27="";
        if(fila>= 0){
                      JOptionPane.showMessageDialog(null, "Al Eliminar una Unidad Temática Se Eliminan las Actividades Dependientes de esta","",JOptionPane.WARNING_MESSAGE,icono);
                      Usuario u= new Usuario("");
            //u.setVisible(false);
            String sql2="select responsable1,responsable2,responsable3,responsable4,responsable5,responsable6 from user where nombreUsuario='"+u.getUser()+"'";
            String sql3="select materia1,materia2,materia3,materia4,materia5,materia6,materia7 from user where nombreUsuario='"+u.getUser()+"'";
            try {
            Statement st = cn2.createStatement();
            ResultSet rs = st.executeQuery(sql2);
             while(rs.next())
               {
                aux15=rs.getString(1);
                aux16 =rs.getString(2);
                aux17 =rs.getString(3);
                aux18 =rs.getString(4);
                aux19 =rs.getString(5);
                aux20 =rs.getString(6);
               }
             if(aux15.equals("DOCENTEPREGRADO")||aux15.equals("PREGRADO")||aux16.equals("PREGRADO")||aux17.equals("PREGRADO")||aux18.equals("PREGRADO")||aux19.equals("PREGRADO")||aux20.equals("PREGRADO")){
            try {
            Statement st2 = cn2.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
             while(rs2.next())
               {
                aux21=rs2.getString(1);
                aux22 =rs2.getString(2);
                aux23 =rs2.getString(3);
                aux24 =rs2.getString(4);
                aux25 =rs2.getString(5);
                aux26 =rs2.getString(6);
                aux27 =rs2.getString(7);
               }
             if(aux21.equals(tabUT.getValueAt(fila, 5).toString())||aux21.equals("TODO")||aux22.equals(tabUT.getValueAt(fila, 5).toString())||aux23.equals(tabUT.getValueAt(fila, 5).toString())||aux24.equals(tabUT.getValueAt(fila, 5).toString())||aux25.equals(tabUT.getValueAt(fila, 5).toString())||aux26.equals(tabUT.getValueAt(fila, 5).toString())||aux27.equals(tabUT.getValueAt(fila, 5).toString())){
                      aux1= tabUT.getValueAt(fila, 0).toString();
                      aux2= tabUT.getValueAt(fila, 1).toString();
                      sql= "select grado, apellidos, nombres from materia,unidadtematica WHERE unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera  AND unidadtematica.cUT='"+tabUT.getValueAt(fila, 3).toString()+"' AND unidadtematica.codCarr='"+tabUT.getValueAt(fila, 10).toString()+"' AND unidadtematica.gestion='"+tabUT.getValueAt(fila, 0).toString()+"' AND unidadtematica.codigoMateria='"+tabUT.getValueAt(fila, 11).toString()+"' AND unidadtematica.codDoc='"+tabUT.getValueAt(fila, 1).toString()+"'";
            try {
            Statement st3 = cn.createStatement();
            ResultSet rs3 = st3.executeQuery(sql);
            while(rs3.next()){
            aux3=rs3.getString(1);
            aux4=rs3.getString(2);
            aux5=rs3.getString(3);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabUT.getValueAt(fila, 3).toString();
                     aux7=tabUT.getValueAt(fila, 4).toString();
                     aux8=tabUT.getValueAt(fila, 5).toString();
                     aux9=tabUT.getValueAt(fila, 6).toString();
                     aux10=tabUT.getValueAt(fila, 7).toString();
                     aux11=tabUT.getValueAt(fila, 8).toString();
                     aux12=tabUT.getValueAt(fila, 9).toString();
                     aux13=tabUT.getValueAt(fila, 10).toString();
                     aux14=tabUT.getValueAt(fila, 11).toString();
            eUT e=new eUT(new java.awt.Frame(), true);
            e.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14);
            e.setVisible(true);
            mostrardatos8(e.getcUT(),e.getcodCarr(),e.getgestion(),e.getcodMat(),e.getcodDoc());
           }
            else{
            JOptionPane.showMessageDialog(null, "Usted NO tiene permisos para modificar otras Materias, solo las suyas","",JOptionPane.WARNING_MESSAGE,icono);
          }  
             } catch (SQLException ex) {
         Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
         }
       } 
              else{
            JOptionPane.showMessageDialog(null, "Usted NO tiene permisos para modificar otras Materias, solo las suyas","",JOptionPane.WARNING_MESSAGE,icono);
          }
            } catch (SQLException ex) {
           Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
   }else{
  JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
    }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         int fila= tabUT.getSelectedRow();
        if(fila>= 0){
            this.setVisible(false);
            Actividad a=new Actividad();
            a.mostrardatos(tabUT.getValueAt(fila, 3).toString(),tabUT.getValueAt(fila, 10).toString(),tabUT.getValueAt(fila, 0).toString(),tabUT.getValueAt(fila, 11).toString(),tabUT.getValueAt(fila, 1).toString());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Report r=new Report(new java.awt.Frame(), true,this.cn,"RUnidadTematica.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","","","");
        cAD.setText("");
        cM.setText("");
        cCM.setText("");
        cPG.setText("");
        cNM.setText("");
         JOptionPane.showMessageDialog(null, "EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono6);
    }//GEN-LAST:event_botAActionPerformed

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
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UnidadTematica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUT;
    // End of variables declaration//GEN-END:variables
 Conexion1 cc= new Conexion1();
 Connection cn= cc.conexion();
 ConexionUser cc2 = new ConexionUser();
 Connection cn2 = cc2.conexion();
}
