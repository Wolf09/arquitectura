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
import text.Control;
import text.MiModelo;
import text.MyEditor;
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
public class Administrativos extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public Administrativos() {
        initComponents();
        this.setTitle("INSTITUTO DE INVESTIGACIONES");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabA.getTableHeader().setPreferredSize(new Dimension(20,50));
        tabA.getTableHeader().setFont(new Font("Lucida Grande", 1, 9));
        tabA.setRowHeight(290);
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
    public void mostrardatos(String valor,String valor2){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("CARGO");
    modelo.addColumn("P.O.A.");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("PRODUCTO");
    modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
    modelo.addColumn("<html>% de CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>ÁREA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CÓDIGO<br>ÁREA TEM.</html>");
    tabA.setModel(modelo);
    TableColumnModel columnModel = tabA.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(2).setPreferredWidth(90);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(5).setPreferredWidth(110);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(6).setPreferredWidth(110);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(10).setPreferredWidth(90);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(11).setPreferredWidth(90);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(13).setPreferredWidth(110);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(14).setPreferredWidth(70);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(8,11));
    String sql="";
    if(valor.equals("")&& valor2.equals(""))
    {
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT ORDER BY administrativos.apellidos, administrativos.nombres";
    }
    else{
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT AND administrativos.gestion='"+valor+"' AND administrativos.codigoAT='"+valor2+"' ORDER BY administrativos.apellidos, administrativos.nombres";
    }
 
    Object []datos = new Object [16];
    
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
                datos[9]=rs.getString(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getBigDecimal(15);
                datos[13]=rs.getString(16);
                datos[14]=rs.getString(17);
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void mostrardatos8(String valor,String valor2,String valor3,String valor4){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("CARGO");
    modelo.addColumn("P.O.A.");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("PRODUCTO");
    modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
    modelo.addColumn("<html>% de CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>ÁREA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CÓDIGO<br>ÁREA TEM.</html>");
    tabA.setModel(modelo);
    TableColumnModel columnModel = tabA.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(2).setPreferredWidth(90);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(5).setPreferredWidth(110);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(6).setPreferredWidth(110);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(10).setPreferredWidth(90);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(11).setPreferredWidth(90);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(13).setPreferredWidth(110);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(14).setPreferredWidth(70);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(8,11));
    String sql="";
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT AND administrativos.gestion='"+valor+"' AND administrativos.codA='"+valor2+"' AND administrativos.producto='"+valor3+"' AND administrativos.codigoAT='"+valor4+"' ORDER BY administrativos.apellidos, administrativos.nombres";

    Object []datos = new Object [16];
    
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
                datos[9]=rs.getString(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getBigDecimal(15);
                datos[13]=rs.getString(16);
                datos[14]=rs.getString(17);
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabA = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cAT = new javax.swing.JTextField();
        cCA = new javax.swing.JTextField();
        cPG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botcon2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cPF = new com.toedter.calendar.JDateChooser();
        botcon3 = new javax.swing.JButton();
        cAP = new javax.swing.JTextField();
        botcon4 = new javax.swing.JButton();
        botA = new javax.swing.JButton();
        botI = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabA.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabA.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabA);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADMINISTRATIVOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("Consultar por el código del Administrativo:");
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("Consultar por Área Temática:");
        jLabel18.setOpaque(true);

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
        jLabel1.setText("Consultar por apellidos del Administrativo debe Ingresar Todos sus Apellidos:");
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

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por fecha Final:");
        jLabel2.setOpaque(true);

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

        botA.setBackground(new java.awt.Color(0, 72, 225));
        botA.setForeground(new java.awt.Color(255, 255, 255));
        botA.setText("ACTUALIZAR");
        botA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAActionPerformed(evt);
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

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cAP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon4))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cAT, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cCA, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botcon3)))
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(botI))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botA)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(cCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon)
                        .addComponent(botI)
                        .addComponent(jLabel2)
                        .addComponent(botcon3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 6, Short.MAX_VALUE))
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

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Generar Reporte");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        this.setVisible(false);
        Institucional i= new Institucional();
        i.mostrardatos9("2017");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0","Autor",JOptionPane.PLAIN_MESSAGE); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int fila= tabA.getSelectedRow();
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
                            aux1=tabA.getValueAt(fila, 0).toString();
                            aux2=tabA.getValueAt(fila, 1).toString();
                             sql= "select grado, apellidos, nombres from administrativos where gestion='"+tabA.getValueAt(fila, 0).toString()+"' AND codA='"+tabA.getValueAt(fila, 1).toString()+"'AND producto='"+tabA.getValueAt(fila, 9).toString()+"' AND codigoAT='"+tabA.getValueAt(fila, 14).toString()+"'";
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
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
            }
                     aux6=tabA.getValueAt(fila, 3).toString();
                     aux7=tabA.getValueAt(fila, 4).toString();
                     aux8=tabA.getValueAt(fila, 5).toString();
                     aux9=tabA.getValueAt(fila, 6).toString();
                     aux10=tabA.getValueAt(fila, 7).toString();
                     aux11=tabA.getValueAt(fila, 8).toString();
                     aux12=tabA.getValueAt(fila, 10).toString();
                     aux13=tabA.getValueAt(fila, 13).toString();
                     aux14=tabA.getValueAt(fila, 14).toString();
                     iAd i=new iAd(new java.awt.Frame(), true);
                     i.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,"0","0",aux13,aux14);
                     i.setVisible(true);
                     mostrardatos8(i.getgestion(),i.getcodA(),i.getpro(),i.getcodAT());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         int fila= tabA.getSelectedRow();
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
        if(fila>= 0){
                     aux1=tabA.getValueAt(fila, 0).toString();
                     aux2=tabA.getValueAt(fila, 1).toString();
                             sql= "select grado, apellidos, nombres from administrativos where gestion='"+tabA.getValueAt(fila, 0).toString()+"' AND codA='"+tabA.getValueAt(fila, 1).toString()+"'AND producto='"+tabA.getValueAt(fila, 9).toString()+"' AND codigoAT='"+tabA.getValueAt(fila, 14).toString()+"'";
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
                             System.out.println(ex.getMessage());
                        }
                     aux6=tabA.getValueAt(fila, 3).toString();
                     aux7=tabA.getValueAt(fila, 4).toString();
                     aux8=tabA.getValueAt(fila, 5).toString();
                     aux9=tabA.getValueAt(fila, 6).toString();
                     aux10=tabA.getValueAt(fila, 7).toString();
                     aux11=tabA.getValueAt(fila, 8).toString();
                     aux12=tabA.getValueAt(fila, 9).toString();
                     aux13=tabA.getValueAt(fila, 10).toString();
                     aux14=tabA.getValueAt(fila, 11).toString();
                     aux15=tabA.getValueAt(fila, 12).toString();
                     aux16=tabA.getValueAt(fila, 13).toString();
                     aux17=tabA.getValueAt(fila, 14).toString();
                     mAd m=new mAd(new java.awt.Frame(), true);
                     m.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14,aux15,aux16,aux17);
                     m.setVisible(true);
                     mostrardatos8(m.getgestion(),m.getcodA(),m.getpro(),m.getcodAT());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         int fila= tabA.getSelectedRow();
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
        if(fila>= 0){
                    JOptionPane.showMessageDialog(null, "Al Eliminar un Administrativos se eliminan todas las Evaluaciones, Dependientes de este","",JOptionPane.WARNING_MESSAGE,icono);
                     aux1=tabA.getValueAt(fila, 0).toString();
                     aux2=tabA.getValueAt(fila, 1).toString();
                             sql= "select grado, apellidos, nombres from administrativos where gestion='"+tabA.getValueAt(fila, 0).toString()+"' AND codA='"+tabA.getValueAt(fila, 1).toString()+"'AND producto='"+tabA.getValueAt(fila, 9).toString()+"' AND codigoAT='"+tabA.getValueAt(fila, 14).toString()+"'";
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
                             System.out.println(ex.getMessage());
                        }
                     aux6=tabA.getValueAt(fila, 3).toString();
                     aux7=tabA.getValueAt(fila, 4).toString();
                     aux8=tabA.getValueAt(fila, 5).toString();
                     aux9=tabA.getValueAt(fila, 6).toString();
                     aux10=tabA.getValueAt(fila, 7).toString();
                     aux11=tabA.getValueAt(fila, 8).toString();
                     aux12=tabA.getValueAt(fila, 9).toString();
                     aux13=tabA.getValueAt(fila, 10).toString();
                     aux14=tabA.getValueAt(fila, 11).toString();
                     aux15=tabA.getValueAt(fila, 12).toString();
                     aux16=tabA.getValueAt(fila, 13).toString();
                     aux17=tabA.getValueAt(fila, 14).toString();
                     eAd e=new eAd(new java.awt.Frame(), true);
                     e.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12,aux13,aux14,aux15,aux16,aux17);
                     e.setVisible(true);
                     mostrardatos8(e.getgestion(),e.getcodA(),e.getpro(),e.getcodAT());
            
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         int fila= tabA.getSelectedRow();
        if(fila>= 0){
            EvaluarAd a=new EvaluarAd(new java.awt.Frame(), true,tabA.getValueAt(fila, 0).toString(),tabA.getValueAt(fila, 1).toString(),tabA.getValueAt(fila, 9).toString(),tabA.getValueAt(fila, 14).toString());
            a.mostrardatos(tabA.getValueAt(fila, 0).toString(), tabA.getValueAt(fila, 1).toString(), tabA.getValueAt(fila, 9).toString(), tabA.getValueAt(fila, 14).toString());
            a.setVisible(true);
            mostrardatos8(a.getges(),a.getca(),a.getpro(),a.getcat());
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Report r=new Report(new java.awt.Frame(), true,this.cn,"RAdministrativo.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos6(cPG.getText());
        cCA.setText("");
        cAP.setText("");
        cAT.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos2(cCA.getText().toString());
        cAT.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos3(cAT.getText().toString());
        cCA.setText("");
        cAP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos4(formato.format(fecha1));
        cCA.setText("");
        cPG.setText("");
        cAT.setText("");
        cAP.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos5(cAP.getText());
        cCA.setText("");
        cPG.setText("");
        cAT.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","");
        cCA.setText("");
        cPG.setText("");
        cAT.setText("");
        cAP.setText("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono5);
    }//GEN-LAST:event_botAActionPerformed

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        Double aux5=0.0;
        BigDecimal aux6= BigDecimal.valueOf(aux5);
        SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
        iAd i=new iAd(new java.awt.Frame(), true);
        i.llenardatos("","","Dr.","","","","","","",formato.format(fecha1),formato.format(fecha1),"","0","0","","");
        i.setVisible(true);
        mostrardatos8(i.getgestion(),i.getcodA(),i.getpro(),i.getcodAT());
    }//GEN-LAST:event_botIActionPerformed
 
   public void mostrardatos2(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("CARGO");
    modelo.addColumn("P.O.A.");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("PRODUCTO");
    modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
    modelo.addColumn("<html>% de CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>ÁREA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CÓDIGO<br>ÁREA TEM.</html>");
    tabA.setModel(modelo);
    TableColumnModel columnModel = tabA.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(2).setPreferredWidth(90);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(5).setPreferredWidth(110);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(6).setPreferredWidth(110);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(10).setPreferredWidth(90);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(11).setPreferredWidth(90);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(13).setPreferredWidth(110);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(14).setPreferredWidth(70);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(8,11));
    String sql="";
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT AND administrativos.codA='"+valor+"' ORDER BY administrativos.apellidos, administrativos.nombres";
    
     Object []datos = new Object [16];
    
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
                datos[9]=rs.getString(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getBigDecimal(15);
                datos[13]=rs.getString(16);
                datos[14]=rs.getString(17);
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
   public void mostrardatos3(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("CARGO");
    modelo.addColumn("P.O.A.");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("PRODUCTO");
    modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
    modelo.addColumn("<html>% de CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>ÁREA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CÓDIGO<br>ÁREA TEM.</html>");
    tabA.setModel(modelo);
    TableColumnModel columnModel = tabA.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(2).setPreferredWidth(90);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(5).setPreferredWidth(110);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(6).setPreferredWidth(110);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(10).setPreferredWidth(90);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(11).setPreferredWidth(90);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(13).setPreferredWidth(110);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(14).setPreferredWidth(70);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(8,11));
    String sql="";
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT AND institucional.areaTematica='"+valor+"' ORDER BY administrativos.apellidos, administrativos.nombres";
    
     Object []datos = new Object [16];
    
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
                datos[9]=rs.getString(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getBigDecimal(15);
                datos[13]=rs.getString(16);
                datos[14]=rs.getString(17);
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void mostrardatos4(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("CARGO");
    modelo.addColumn("P.O.A.");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("PRODUCTO");
    modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
    modelo.addColumn("<html>% de CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>ÁREA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CÓDIGO<br>ÁREA TEM.</html>");
    tabA.setModel(modelo);
    TableColumnModel columnModel = tabA.getColumnModel();
   columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(2).setPreferredWidth(90);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(5).setPreferredWidth(110);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(6).setPreferredWidth(110);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(10).setPreferredWidth(90);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(11).setPreferredWidth(90);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(13).setPreferredWidth(110);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(14).setPreferredWidth(70);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(8,11));
    String sql="";
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT AND administrativos.fechaF<='"+valor+"' ORDER BY administrativos.apellidos, administrativos.nombres";
    
     Object []datos = new Object [16];
    
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
                datos[9]=rs.getString(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getBigDecimal(15);
                datos[13]=rs.getString(16);
                datos[14]=rs.getString(17);
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void mostrardatos5(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("CARGO");
    modelo.addColumn("P.O.A.");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("PRODUCTO");
    modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
    modelo.addColumn("<html>% de CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>ÁREA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CÓDIGO<br>ÁREA TEM.</html>");
    tabA.setModel(modelo);
    TableColumnModel columnModel = tabA.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(2).setPreferredWidth(90);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(5).setPreferredWidth(110);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(6).setPreferredWidth(110);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(10).setPreferredWidth(90);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(11).setPreferredWidth(90);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(13).setPreferredWidth(110);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(14).setPreferredWidth(70);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(8,11));
    String sql="";
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT AND administrativos.apellidos='"+valor+"' ORDER BY administrativos.apellidos, administrativos.nombres";
    
     Object []datos = new Object [16];
    
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
                datos[9]=rs.getString(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getBigDecimal(15);
                datos[13]=rs.getString(16);
                datos[14]=rs.getString(17);
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void mostrardatos6(String valor){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
    modelo.addColumn("ADMINISTRATIVO");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("CARGO");
    modelo.addColumn("P.O.A.");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("PRODUCTO");
    modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
    modelo.addColumn("<html>% de CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>EVALUACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>ÁREA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CÓDIGO<br>ÁREA TEM.</html>");
    tabA.setModel(modelo);
    TableColumnModel columnModel = tabA.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(2).setPreferredWidth(90);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(4).setPreferredWidth(80);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(5).setPreferredWidth(110);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(6).setPreferredWidth(110);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(8).setPreferredWidth(70);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(9).setPreferredWidth(110);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(10).setPreferredWidth(90);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(11).setPreferredWidth(90);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(13).setPreferredWidth(110);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(8,11));
    columnModel.getColumn(14).setPreferredWidth(70);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(8,11));
    String sql="";
        sql="SELECT institucional.gestion,administrativos.codA,administrativos.grado,administrativos.apellidos,administrativos.nombres,administrativos.telf,administrativos.email,administrativos.cargo,administrativos.poa,administrativos.fechaI,administrativos.fechaF,administrativos.producto,administrativos.responsableR,administrativos.cump,administrativos.ponderacion,institucional.areaTematica,institucional.codigoAT FROM administrativos,institucional WHERE administrativos.gestion=institucional.gestion AND administrativos.codigoAT=institucional.codigoAT AND institucional.gestion='"+valor+"' ORDER BY administrativos.apellidos, administrativos.nombres";
    
     Object []datos = new Object [16];
    
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
                datos[9]=rs.getString(12);
                datos[10]=rs.getString(13);
                datos[11]=rs.getBigDecimal(14);
                datos[12]=rs.getBigDecimal(15);
                datos[13]=rs.getString(16);
                datos[14]=rs.getString(17);
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Administrativos.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JTextField cAT;
    private javax.swing.JTextField cCA;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabA;
    // End of variables declaration//GEN-END:variables
Conexion3 cc= new Conexion3();
Connection cn= cc.conexion();
}
