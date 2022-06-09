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
public class Actividad extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono2;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
public Actividad() {
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
        botA.setIcon(icono5);
         botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
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
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     public void mostrardatos8(String valor1,String valor2, String valor3,String valor4,String valor5,String valor6){
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
        sql="SELECT carrera.gestion,materia.codigoDocente,materia.grado,materia.apellidos,materia.nombres,actividad.actividad,unidadtematica.cUT,unidadtematica.unidadTematica,materia.nombreMateria,carrera.nombre,actividad.fechaInicio,actividad.fechaFin,actividad.cumplido,carrera.codigoCarrera,materia.codigoMateria FROM actividad,unidadtematica,materia,carrera WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND materia.codCarrera=carrera.codigoCarrera AND materia.gestion=carrera.gestion AND actividad.gestion='"+valor1+"' AND actividad.actividad='"+valor2+"' AND actividad.cUT='"+valor3+"' AND actividad.codCarr='"+valor4+"' AND actividad.codigoMateria='"+valor5+"' AND actividad.codDoc='"+valor6+"'ORDER BY materia.apellidos, materia.nombres";

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
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
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
        botA = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablaAct.setComponentPopupMenu(jPopupMenu1);
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
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(395, 395, 395))
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ccUT, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(botA, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)))))
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
                        .addComponent(botcon4)
                        .addComponent(botA)))
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
        UnidadTematica u= new UnidadTematica();
        u.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sep = System.getProperty("line.separator");
       JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tablaAct.getSelectedRow();
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
        if(fila>= 0){
                      aux1= tablaAct.getValueAt(fila, 0).toString();
                      aux2= tablaAct.getValueAt(fila, 1).toString();
                      sql= "select grado, apellidos, nombres from actividad,unidadtematica,materia WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND actividad.gestion='"+tablaAct.getValueAt(fila, 0).toString()+"' AND actividad='"+tablaAct.getValueAt(fila, 3).toString()+"' AND actividad.cUT='"+tablaAct.getValueAt(fila, 4).toString()+"' AND actividad.codCarr='"+tablaAct.getValueAt(fila, 11).toString()+"' AND actividad.codigoMateria='"+tablaAct.getValueAt(fila, 12).toString()+"' AND actividad.codDoc='"+tablaAct.getValueAt(fila, 1).toString()+"'";
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
                     aux6=tablaAct.getValueAt(fila, 4).toString();
                     aux7=tablaAct.getValueAt(fila, 5).toString();
                     aux8=tablaAct.getValueAt(fila, 6).toString();
                     aux9=tablaAct.getValueAt(fila, 7).toString();
                     aux10=tablaAct.getValueAt(fila, 8).toString();
                     aux11=tablaAct.getValueAt(fila, 9).toString();
                     aux12=tablaAct.getValueAt(fila, 10).toString();
                     aux13=tablaAct.getValueAt(fila, 11).toString();
                     aux14=tablaAct.getValueAt(fila, 12).toString();
            iA i=new iA(new java.awt.Frame(), true);
            i.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14);
            i.setVisible(true);
            mostrardatos8(i.getgestion(),i.getact(),i.getcUT(),i.getcodCarr(),i.getcodMat(),i.getcodDoc());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int fila= tablaAct.getSelectedRow();
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
        String aux28="";
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
                aux16=rs.getString(1);
                aux17 =rs.getString(2);
                aux18 =rs.getString(3);
                aux19 =rs.getString(4);
                aux20 =rs.getString(5);
                aux21 =rs.getString(6);
               }
                if(aux16.equals("DOCENTEPREGRADO")||aux16.equals("PREGRADO")||aux17.equals("PREGRADO")||aux18.equals("PREGRADO")||aux19.equals("PREGRADO")||aux20.equals("PREGRADO")||aux21.equals("PREGRADO")){
            try {
            Statement st2 = cn2.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
             while(rs2.next())
               {
                aux22=rs2.getString(1);
                aux23 =rs2.getString(2);
                aux24 =rs2.getString(3);
                aux25 =rs2.getString(4);
                aux26 =rs2.getString(5);
                aux27 =rs2.getString(6);
                aux28 =rs2.getString(7);
               }
             if(aux22.equals(tablaAct.getValueAt(fila, 6).toString())||aux22.equals("TODO")||aux23.equals(tablaAct.getValueAt(fila, 6).toString())||aux24.equals(tablaAct.getValueAt(fila, 6).toString())||aux25.equals(tablaAct.getValueAt(fila, 6).toString())||aux26.equals(tablaAct.getValueAt(fila, 6).toString())||aux27.equals(tablaAct.getValueAt(fila, 6).toString())||aux28.equals(tablaAct.getValueAt(fila, 6).toString())){
                      aux1= tablaAct.getValueAt(fila, 0).toString();
                      aux2= tablaAct.getValueAt(fila, 1).toString();
                      sql= "select grado, apellidos, nombres from actividad,unidadtematica,materia WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND actividad.gestion='"+tablaAct.getValueAt(fila, 0).toString()+"' AND actividad='"+tablaAct.getValueAt(fila, 3).toString()+"' AND actividad.cUT='"+tablaAct.getValueAt(fila, 4).toString()+"' AND actividad.codCarr='"+tablaAct.getValueAt(fila, 11).toString()+"' AND actividad.codigoMateria='"+tablaAct.getValueAt(fila, 12).toString()+"' AND actividad.codDoc='"+tablaAct.getValueAt(fila, 1).toString()+"'";
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
                     aux6=tablaAct.getValueAt(fila, 3).toString();
                     aux7=tablaAct.getValueAt(fila, 4).toString();
                     aux8=tablaAct.getValueAt(fila, 5).toString();
                     aux9=tablaAct.getValueAt(fila, 6).toString();
                     aux10=tablaAct.getValueAt(fila, 7).toString();
                     aux11=tablaAct.getValueAt(fila, 8).toString();
                     aux12=tablaAct.getValueAt(fila, 9).toString();
                     aux13=tablaAct.getValueAt(fila, 10).toString();
                     aux14=tablaAct.getValueAt(fila, 11).toString();
                     aux15=tablaAct.getValueAt(fila, 12).toString();
            mA m=new mA(new java.awt.Frame(), true);
            m.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14,aux15);
            m.setVisible(true);
            mostrardatos8(m.getgestion(),m.getact(),m.getcUT(),m.getcodCarr(),m.getcodMat(),m.getcodDoc());
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
        int fila= tablaAct.getSelectedRow();
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
        String aux28="";
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
                aux16=rs.getString(1);
                aux17 =rs.getString(2);
                aux18 =rs.getString(3);
                aux19 =rs.getString(4);
                aux20 =rs.getString(5);
                aux21 =rs.getString(6);
               }
                if(aux16.equals("DOCENTEPREGRADO")||aux16.equals("PREGRADO")||aux17.equals("PREGRADO")||aux18.equals("PREGRADO")||aux19.equals("PREGRADO")||aux20.equals("PREGRADO")||aux21.equals("PREGRADO")){
            try {
            Statement st2 = cn2.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
             while(rs2.next())
               {
                aux22=rs2.getString(1);
                aux23 =rs2.getString(2);
                aux24 =rs2.getString(3);
                aux25 =rs2.getString(4);
                aux26 =rs2.getString(5);
                aux27 =rs2.getString(6);
                aux28 =rs2.getString(7);
               }
             if(aux22.equals(tablaAct.getValueAt(fila, 6).toString())||aux22.equals("TODO")||aux23.equals(tablaAct.getValueAt(fila, 6).toString())||aux24.equals(tablaAct.getValueAt(fila, 6).toString())||aux25.equals(tablaAct.getValueAt(fila, 6).toString())||aux26.equals(tablaAct.getValueAt(fila, 6).toString())||aux27.equals(tablaAct.getValueAt(fila, 6).toString())||aux28.equals(tablaAct.getValueAt(fila, 6).toString())){
                      aux1= tablaAct.getValueAt(fila, 0).toString();
                      aux2= tablaAct.getValueAt(fila, 1).toString();
                      sql= "select grado, apellidos, nombres from actividad,unidadtematica,materia WHERE actividad.cUT=unidadtematica.cUT AND actividad.codCarr=unidadtematica.codCarr AND actividad.gestion=unidadtematica.gestion AND actividad.codigoMateria=unidadtematica.codigoMateria AND actividad.codDoc=unidadtematica.codDoc AND unidadtematica.codigoMateria=materia.codigoMateria AND unidadtematica.gestion=materia.gestion AND unidadtematica.codDoc=materia.codigoDocente AND unidadtematica.codCarr=materia.codCarrera AND actividad.gestion='"+tablaAct.getValueAt(fila, 0).toString()+"' AND actividad='"+tablaAct.getValueAt(fila, 3).toString()+"' AND actividad.cUT='"+tablaAct.getValueAt(fila, 4).toString()+"' AND actividad.codCarr='"+tablaAct.getValueAt(fila, 11).toString()+"' AND actividad.codigoMateria='"+tablaAct.getValueAt(fila, 12).toString()+"' AND actividad.codDoc='"+tablaAct.getValueAt(fila, 1).toString()+"'";
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
                     aux6=tablaAct.getValueAt(fila, 3).toString();
                     aux7=tablaAct.getValueAt(fila, 4).toString();
                     aux8=tablaAct.getValueAt(fila, 5).toString();
                     aux9=tablaAct.getValueAt(fila, 6).toString();
                     aux10=tablaAct.getValueAt(fila, 7).toString();
                     aux11=tablaAct.getValueAt(fila, 8).toString();
                     aux12=tablaAct.getValueAt(fila, 9).toString();
                     aux13=tablaAct.getValueAt(fila, 10).toString();
                     aux14=tablaAct.getValueAt(fila, 11).toString();
                     aux15=tablaAct.getValueAt(fila, 12).toString();
            eA e=new eA(new java.awt.Frame(), true);
            e.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14,aux15);
            e.setVisible(true);
             mostrardatos8(e.getgestion(),e.getact(),e.getcUT(),e.getcodCarr(),e.getcodMat(),e.getcodDoc());
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

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Report r=new Report(new java.awt.Frame(), true,this.cn,"RActividad.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","","","","");
        ccUT.setText("");
        cPG.setText("");
        cAD.setText("");
        cCC.setText("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono6);
    }//GEN-LAST:event_botAActionPerformed

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
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAct;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
Connection cn= cc.conexion();
ConexionUser cc2 = new ConexionUser();
Connection cn2 = cc2.conexion();
}
