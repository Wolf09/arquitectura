/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;
import arqui1.ConexionUser;
import arqui1.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
public class Maestria extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public Maestria() {
        initComponents();
        this.setTitle("POSGRADO");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabM.getTableHeader().setPreferredSize(new Dimension(20,50));
        tabM.getTableHeader().setFont(new Font("Lucida Grande", 1, 9));
        tabM.setRowHeight(240);
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
        botI.setIcon(icono3);
        botA.setIcon(icono4);
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
        this.setVisible(true);
    }

     public  void mostrardatos(String valor,String valor2){
   MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabM.setModel(modelo);  
    TableColumnModel columnModel = tabM.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(130);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(90);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
    if(valor.equals("")&& valor2.equals(""))
    {
        sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi ORDER BY maestria.apellidos, maestria.nombres";
    }
    else{
        sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND maestria.gestion='"+valor+"' AND maestria.nominacion='"+valor2+"' ORDER BY maestria.apellidos, maestria.nombres";
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tabM.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Maestria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
     public  void mostrardatos8(String valor,String valor2,String valor3,String valor4,String valor5,String valor6){
   MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabM.setModel(modelo);  
    TableColumnModel columnModel = tabM.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(130);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(90);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
        sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND maestria.gestion='"+valor+"' AND maestria.codDoc='"+valor2+"' AND maestria.materia='"+valor3+"' AND maestria.unidadtematica='"+valor4+"' AND maestria.actividad='"+valor5+"' AND maestria.nominacion='"+valor6+"' ORDER BY maestria.apellidos, maestria.nombres";

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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tabM.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Maestria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabM = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel1 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        codMD = new javax.swing.JTextField();
        codD = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cNM = new javax.swing.JTextField();
        botcon3 = new javax.swing.JButton();
        botcon2 = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        botI = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cPF = new com.toedter.calendar.JDateChooser();
        botA = new javax.swing.JButton();
        botcon4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
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

        jMenuItem7.setText("ELIMINAR");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        jMenuItem1.setText("EVALUAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem8.setText("VER RECURSO");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabM.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabM.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabM);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DOCENTES MAESTRÍA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por Gestión:");
        jLabel1.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setText("Mostrar por Codigo del Docente:");
        jLabel16.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Buscar por los apellidos del Docente (debe escribir todos los apellidos):");
        jLabel15.setOpaque(true);

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
        jLabel2.setText("Consultar por nombre de Materia:");
        jLabel2.setOpaque(true);

        botcon3.setBackground(new java.awt.Color(0, 72, 225));
        botcon3.setForeground(new java.awt.Color(255, 255, 255));
        botcon3.setText("Consultar");
        botcon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon3ActionPerformed(evt);
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

        botcon1.setBackground(new java.awt.Color(0, 72, 225));
        botcon1.setForeground(new java.awt.Color(255, 255, 255));
        botcon1.setText("Consultar");
        botcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon1ActionPerformed(evt);
            }
        });

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("Insertar");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por fecha Final:");
        jLabel3.setOpaque(true);

        botA.setBackground(new java.awt.Color(0, 72, 225));
        botA.setForeground(new java.awt.Color(255, 255, 255));
        botA.setText("ACTUALIZAR");
        botA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cNM, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codMD, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(codD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(botcon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon4)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botA)
                                .addContainerGap())))))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(codMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(botI)
                    .addComponent(botA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(codD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon2)
                        .addComponent(jLabel3))
                    .addComponent(botcon4)
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon)
                    .addComponent(jLabel2)
                    .addComponent(cNM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Generar Reporte");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void mostrardatos2(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabM.setModel(modelo);  
    TableColumnModel columnModel = tabM.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(130);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(90);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
     sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND maestria.apellidos='"+valor+"' ORDER BY maestria.apellidos, maestria.nombres";
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tabM.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Maestria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    void mostrardatos3(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabM.setModel(modelo);  
    TableColumnModel columnModel = tabM.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(130);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(90);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
     sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND maestria.codDoc='"+valor+"' ORDER BY maestria.apellidos, maestria.nombres";
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tabM.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Maestria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
    void mostrardatos4(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabM.setModel(modelo);  
    TableColumnModel columnModel = tabM.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(130);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(90);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
     sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND institucional.gest='"+valor+"' ORDER BY maestria.apellidos, maestria.nombres";
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tabM.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Maestria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void mostrardatos5(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabM.setModel(modelo);  
    TableColumnModel columnModel = tabM.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(130);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(90);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
     sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND maestria.fechaFin<='"+valor+"' ORDER BY maestria.apellidos, maestria.nombres";
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tabM.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Maestria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void mostrardatos6(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabM.setModel(modelo);  
    TableColumnModel columnModel = tabM.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(2).setPreferredWidth(150);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(5).setPreferredWidth(130);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(7).setPreferredWidth(130);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(9).setPreferredWidth(70);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(10).setPreferredWidth(70);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(11).setPreferredWidth(70);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
    columnModel.getColumn(12).setPreferredWidth(90);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
    String sql="";
     sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND maestria.materia='"+valor+"' ORDER BY maestria.apellidos, maestria.nombres";
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
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getString(15);
                modelo.addRow(datos);
            }
            tabM.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Maestria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        Institucional i= new Institucional();
        i.mostrardatos9("2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Report r=new Report(new java.awt.Frame(), true,this.cn,"RDocentesMa.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int fila= tabM.getSelectedRow();
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
             if(aux15.equals("DOCENTEPOSGRADO")||aux15.equals("POSGRADO")||aux16.equals("DOCENTEPOSGRADO")||aux16.equals("POSGRADO")||aux17.equals("POSGRADO")||aux18.equals("POSGRADO")||aux19.equals("POSGRADO")||aux20.equals("POSGRADO")){
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
             if(aux21.equals("TODO")||aux21.equals(tabM.getValueAt(fila, 5).toString())||aux22.equals(tabM.getValueAt(fila, 5).toString())||aux23.equals(tabM.getValueAt(fila, 5).toString())||aux24.equals(tabM.getValueAt(fila, 5).toString())||aux25.equals(tabM.getValueAt(fila, 5).toString())||aux26.equals(tabM.getValueAt(fila, 5).toString())||aux27.equals(tabM.getValueAt(fila, 5).toString())){
            aux1=tabM.getValueAt(fila, 0).toString();
            aux2=tabM.getValueAt(fila, 1).toString();
            sql= "select grado, apellidos, nombres from maestria where gestion='"+tabM.getValueAt(fila, 0).toString()+"' AND codDoc='"+tabM.getValueAt(fila, 1).toString()+"' AND materia='"+tabM.getValueAt(fila, 5).toString()+"' AND unidadtematica='"+tabM.getValueAt(fila, 6).toString()+"' AND actividad='"+tabM.getValueAt(fila, 7).toString()+"' AND nominacion='"+tabM.getValueAt(fila, 12).toString()+"'";
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
                Logger.getLogger(Diplomado.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux6=tabM.getValueAt(fila, 3).toString();
            aux7=tabM.getValueAt(fila, 4).toString();
            aux8=tabM.getValueAt(fila, 5).toString();
            aux9=tabM.getValueAt(fila, 6).toString();
            aux10=tabM.getValueAt(fila, 8).toString();
            aux11=tabM.getValueAt(fila, 9).toString();
            aux12=tabM.getValueAt(fila, 10).toString();
            aux13=tabM.getValueAt(fila, 12).toString();
            iMa i=new iMa(new java.awt.Frame(), true);
            i.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13);
            i.setVisible(true);
            mostrardatos8(i.getgestion(),i.getcodDoc(),i.getmat(),i.getuT(),i.getact(),i.getnom());
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
            int fila= tabM.getSelectedRow();
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
            if(aux15.equals("DOCENTEPOSGRADO")||aux15.equals("POSGRADO")||aux16.equals("DOCENTEPOSGRADO")||aux16.equals("POSGRADO")||aux17.equals("POSGRADO")||aux18.equals("POSGRADO")||aux19.equals("POSGRADO")||aux20.equals("POSGRADO")){
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
            if(aux21.equals("TODO")||aux21.equals(tabM.getValueAt(fila, 5).toString())||aux22.equals(tabM.getValueAt(fila, 5).toString())||aux23.equals(tabM.getValueAt(fila, 5).toString())||aux24.equals(tabM.getValueAt(fila, 5).toString())||aux25.equals(tabM.getValueAt(fila, 5).toString())||aux26.equals(tabM.getValueAt(fila, 5).toString())||aux27.equals(tabM.getValueAt(fila, 5).toString())){
            aux1=tabM.getValueAt(fila, 0).toString();
            aux2=tabM.getValueAt(fila, 1).toString();
            sql= "select grado, apellidos, nombres from maestria where gestion='"+tabM.getValueAt(fila, 0).toString()+"' AND codDoc='"+tabM.getValueAt(fila, 1).toString()+"' AND materia='"+tabM.getValueAt(fila, 5).toString()+"' AND unidadtematica='"+tabM.getValueAt(fila, 6).toString()+"' AND actividad='"+tabM.getValueAt(fila, 7).toString()+"' AND nominacion='"+tabM.getValueAt(fila, 12).toString()+"'";
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
                Logger.getLogger(Diplomado.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux6=tabM.getValueAt(fila, 3).toString();
            aux7=tabM.getValueAt(fila, 4).toString();
            aux8=tabM.getValueAt(fila, 5).toString();
            aux9=tabM.getValueAt(fila, 6).toString();
            aux10=tabM.getValueAt(fila, 7).toString();
            aux11=tabM.getValueAt(fila, 8).toString();
            aux12=tabM.getValueAt(fila, 9).toString();
            aux13=tabM.getValueAt(fila, 10).toString();
            aux14=tabM.getValueAt(fila, 12).toString();
            mMa m=new mMa(new java.awt.Frame(), true);
            m.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14);
            m.setVisible(true);
            mostrardatos8(m.getgestion(),m.getcodDoc(),m.getmat(),m.getuT(),m.getact(),m.getnom());
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
       int fila= tabM.getSelectedRow();
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
            JOptionPane.showMessageDialog(null, "Al Eliminar un Docente se eliminan todas las Evaluaciones, Dependientes de este","",JOptionPane.WARNING_MESSAGE,icono);
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
            if(aux15.equals("DOCENTEPOSGRADO")||aux15.equals("POSGRADO")||aux16.equals("DOCENTEPOSGRADO")||aux16.equals("POSGRADO")||aux17.equals("POSGRADO")||aux18.equals("POSGRADO")||aux19.equals("POSGRADO")||aux20.equals("POSGRADO")){
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
            if(aux21.equals("TODO")||aux21.equals(tabM.getValueAt(fila, 5).toString())||aux22.equals(tabM.getValueAt(fila, 5).toString())||aux23.equals(tabM.getValueAt(fila, 5).toString())||aux24.equals(tabM.getValueAt(fila, 5).toString())||aux25.equals(tabM.getValueAt(fila, 5).toString())||aux26.equals(tabM.getValueAt(fila, 5).toString())||aux27.equals(tabM.getValueAt(fila, 5).toString())){
            aux1=tabM.getValueAt(fila, 0).toString();
            aux2=tabM.getValueAt(fila, 1).toString();
            sql= "select grado, apellidos, nombres from maestria where gestion='"+tabM.getValueAt(fila, 0).toString()+"' AND codDoc='"+tabM.getValueAt(fila, 1).toString()+"' AND materia='"+tabM.getValueAt(fila, 5).toString()+"' AND unidadtematica='"+tabM.getValueAt(fila, 6).toString()+"' AND actividad='"+tabM.getValueAt(fila, 7).toString()+"' AND nominacion='"+tabM.getValueAt(fila, 12).toString()+"'";
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
                Logger.getLogger(Diplomado.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux6=tabM.getValueAt(fila, 3).toString();
            aux7=tabM.getValueAt(fila, 4).toString();
            aux8=tabM.getValueAt(fila, 5).toString();
            aux9=tabM.getValueAt(fila, 6).toString();
            aux10=tabM.getValueAt(fila, 7).toString();
            aux11=tabM.getValueAt(fila, 8).toString();
            aux12=tabM.getValueAt(fila, 9).toString();
            aux13=tabM.getValueAt(fila, 10).toString();
            aux14=tabM.getValueAt(fila, 12).toString();
            eMa e=new eMa(new java.awt.Frame(), true);
            e.llenardatos(aux1, aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14);
            e.setVisible(true);
            mostrardatos8(e.getgestion(),e.getcodDoc(),e.getmat(),e.getuT(),e.getact(),e.getnom());
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
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         int fila= tabM.getSelectedRow();
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
        if(fila>=0){
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
            if(aux15.equals("DOCENTEPOSGRADO")||aux15.equals("POSGRADO")||aux16.equals("DOCENTEPOSGRADO")||aux16.equals("POSGRADO")||aux17.equals("POSGRADO")||aux18.equals("POSGRADO")||aux19.equals("POSGRADO")||aux20.equals("POSGRADO")){
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
            if(aux21.equals("TODO")||aux21.equals(tabM.getValueAt(fila, 5).toString())||aux22.equals(tabM.getValueAt(fila, 5).toString())||aux23.equals(tabM.getValueAt(fila, 5).toString())||aux24.equals(tabM.getValueAt(fila, 5).toString())||aux25.equals(tabM.getValueAt(fila, 5).toString())||aux26.equals(tabM.getValueAt(fila, 5).toString())||aux27.equals(tabM.getValueAt(fila, 5).toString())){
            EvaluarD e=new EvaluarD(new java.awt.Frame(), true,tabM.getValueAt(fila, 0).toString(),tabM.getValueAt(fila, 1).toString(),tabM.getValueAt(fila, 5).toString(),tabM.getValueAt(fila, 6).toString(),tabM.getValueAt(fila, 7).toString(),tabM.getValueAt(fila, 12).toString());
            e.mostrardatos(tabM.getValueAt(fila, 0).toString(),tabM.getValueAt(fila, 1).toString(),tabM.getValueAt(fila, 5).toString(),tabM.getValueAt(fila, 6).toString(),tabM.getValueAt(fila, 7).toString(),tabM.getValueAt(fila, 12).toString());
            e.setVisible(true);
            mostrardatos8(e.getgest(),e.getcD(),e.getm(),e.getuT(),e.getact(),e.getnom());
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
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       int fila= tabM.getSelectedRow();
           String sep = System.getProperty("line.separator");
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
            if(aux15.equals("DOCENTEPOSGRADO")||aux15.equals("POSGRADO")||aux16.equals("DOCENTEPOSGRADO")||aux16.equals("POSGRADO")||aux17.equals("POSGRADO")||aux18.equals("POSGRADO")||aux19.equals("POSGRADO")||aux20.equals("POSGRADO")){
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
            if(aux21.equals("TODO")||aux21.equals(tabM.getValueAt(fila, 5).toString())||aux22.equals(tabM.getValueAt(fila, 5).toString())||aux23.equals(tabM.getValueAt(fila, 5).toString())||aux24.equals(tabM.getValueAt(fila, 5).toString())||aux25.equals(tabM.getValueAt(fila, 5).toString())||aux26.equals(tabM.getValueAt(fila, 5).toString())||aux27.equals(tabM.getValueAt(fila, 5).toString())){
                     String sql="";
                     String aux="";
                     Abrir a=new Abrir();
                                   sql= "select recurso from maestria WHERE gestion='"+tabM.getValueAt(fila, 0).toString()+"' AND codDoc='"+tabM.getValueAt(fila, 1).toString()+"' AND materia='"+tabM.getValueAt(fila, 5).toString()+"' AND unidadtematica='"+tabM.getValueAt(fila, 6).toString()+"' AND actividad='"+tabM.getValueAt(fila, 7).toString()+"' AND nominacion='"+tabM.getValueAt(fila, 12).toString()+"'";
            try {
            Statement st3 = cn.createStatement();
            ResultSet rs3 = st3.executeQuery(sql);
            while(rs3.next()){
            aux=rs3.getString(1);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(Diplomado.class.getName()).log(Level.SEVERE, null, ex);
            }
                     a.launchFile("\\\\167.157.17.39\\posgrado\\"+aux+"");
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
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos4(cPG.getText());
        codMD.setText("");
        codD.setText("");
        cNM.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        mostrardatos6(cNM.getText());
        codMD.setText("");
        codD.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos3(codD.getText().toString());
        codMD.setText("");
        cPG.setText("");
        cNM.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos2(codMD.getText().toString());
        codD.setText("");
        cPG.setText("");
        cNM.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos5(formato.format(fecha1));
        codMD.setText("");
        codD.setText("");
        cPG.setText("");
        cNM.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","");
        codMD.setText("");
        codD.setText("");
        cPG.setText("");
        cNM.setText("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono5);
    }//GEN-LAST:event_botAActionPerformed

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        Double aux5=0.0;
        BigDecimal aux6= BigDecimal.valueOf(aux5);
        SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
        iMa i=new iMa(new java.awt.Frame(), true);
        i.llenardatos("","", "Dr.", "", "", "", "", "", "", formato.format(fecha1), formato.format(fecha1), "0", "Diplomado");
        i.setVisible(true);
        mostrardatos8(i.getgestion(),i.getcodDoc(),i.getmat(),i.getuT(),i.getact(),i.getnom());
    }//GEN-LAST:event_botIActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
    private javax.swing.JButton botI;
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JTextField cNM;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField codD;
    private javax.swing.JTextField codMD;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
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
    private javax.swing.JTable tabM;
    // End of variables declaration//GEN-END:variables
Conexion2 cc= new Conexion2();
Connection cn= cc.conexion();
ConexionUser cc2 = new ConexionUser();
Connection cn2 = cc2.conexion();
}

