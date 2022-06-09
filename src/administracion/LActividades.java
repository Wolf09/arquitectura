/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;
import Interfaz.Atras;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import text.Abrir;
import text.Control;
import text.MiModelo;
import text.MyRen2;
import text.Redondear;
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
public class LActividades extends javax.swing.JFrame {

    private Advertencia icono;
    private BotConsul icono1;
    private BotTodos icono2;
    private BotInsertar icono3;
    private BotAct icono4;
    private Bien2 icono5;
    public LActividades() {
        initComponents();
        this.setTitle("PERSONAL DE ADMINISTRACIÓN");
         int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(0, 0);
       this.setMinimumSize(new Dimension(ancho-20, alto-50));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        tabA.getTableHeader().setPreferredSize(new Dimension(20, 50));
        tabA.getTableHeader().setFont(new Font("Lucida Grande", 1, 8));
        tabA.setRowHeight(270);
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
          //this.getContentPane().setBackground(new Color(250,250,250));
        this.setVisible(true);
    }
    
      public void EvaluarPp(String aux1,String aux2,String aux4){
        ArrayList<BigDecimal> pP= new ArrayList<BigDecimal>();
        int aux3=0;
        double suma1=0.0;
        double res1=0.0;
        String sql1="";
        String sql2="";
                        sql1="select count(*) from subactividades where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'";
                        try {
                            Statement st = cn.createStatement();
                            ResultSet rs = st.executeQuery(sql1);
                                while(rs.next()){
                                aux3=rs.getInt(1);
                                }
                            }
                        catch (SQLException ex) {
                           System.out.println(ex.getMessage());
                       }
                        sql2="select pp from subactividades where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'";
                        try {
                                Statement st1 = cn.createStatement();
                                ResultSet rs1 = st1.executeQuery(sql2);
                                    while(rs1.next()){
                                    pP.add(rs1.getBigDecimal(1));
                                    }
                            }
                            catch (SQLException ex) {
                                 System.out.println(ex.getMessage());
                            }
                        
                        for(int x=0;x<pP.size();x++) {
                         suma1=suma1+(pP.get(x)).doubleValue();
                         }
                        
                        if(aux3==0){
                            aux3=1;
                        }
                        res1=suma1/aux3;
                        Redondear d=new Redondear();
                        res1=d.rD(res1);
                           try {
                                PreparedStatement pst = cn.prepareStatement("UPDATE actividades SET pp='"+res1+"' where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'");
                                pst.executeUpdate();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        
                        pP.clear();

    }
      public void EvaluarSp(String aux1,String aux2,String aux4){
        ArrayList<BigDecimal> pP= new ArrayList<BigDecimal>();
        int aux3=0;
        double suma1=0.0;
        double res1=0.0;
        String sql1="";
        String sql2="";
                        sql1="select count(*) from subactividades where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'";
                        try {
                            Statement st = cn.createStatement();
                            ResultSet rs = st.executeQuery(sql1);
                                while(rs.next()){
                                aux3=rs.getInt(1);
                                }
                            }
                        catch (SQLException ex) {
                           System.out.println(ex.getMessage());
                       }
                        sql2="select sp from subactividades where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'";
                        try {
                                Statement st1 = cn.createStatement();
                                ResultSet rs1 = st1.executeQuery(sql2);
                                    while(rs1.next()){
                                    pP.add(rs1.getBigDecimal(1));
                                    }
                            }
                            catch (SQLException ex) {
                                 System.out.println(ex.getMessage());
                            }
                        
                        for(int x=0;x<pP.size();x++) {
                         suma1=suma1+(pP.get(x)).doubleValue();
                         }
                        
                        if(aux3==0){
                            aux3=1;
                        }
                        res1=suma1/aux3;
                        Redondear d=new Redondear();
                        res1=d.rD(res1);
                           try {
                                PreparedStatement pst = cn.prepareStatement("UPDATE actividades SET sp='"+res1+"' where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'");
                                pst.executeUpdate();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        
                        pP.clear();

    }
      public void EvaluarPf(String aux1,String aux2,String aux4){
        ArrayList<BigDecimal> pP= new ArrayList<BigDecimal>();
        int aux3=0;
        double suma1=0.0;
        double res1=0.0;
        String sql1="";
        String sql2="";
                        sql1="select count(*) from subactividades where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'";
                        try {
                            Statement st = cn.createStatement();
                            ResultSet rs = st.executeQuery(sql1);
                                while(rs.next()){
                                aux3=rs.getInt(1);
                                }
                            }
                        catch (SQLException ex) {
                           System.out.println(ex.getMessage());
                       }
                        sql2="select pf from subactividades where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'";
                        try {
                                Statement st1 = cn.createStatement();
                                ResultSet rs1 = st1.executeQuery(sql2);
                                    while(rs1.next()){
                                    pP.add(rs1.getBigDecimal(1));
                                    }
                            }
                            catch (SQLException ex) {
                                 System.out.println(ex.getMessage());
                            }
                        
                        for(int x=0;x<pP.size();x++) {
                         suma1=suma1+(pP.get(x)).doubleValue();
                         }
                        
                        if(aux3==0){
                            aux3=1;
                        }
                        res1=suma1/aux3;
                        Redondear d=new Redondear();
                        res1=d.rD(res1);
                           try {
                                PreparedStatement pst = cn.prepareStatement("UPDATE actividades SET pf='"+res1+"' where gestion='"+aux1+"' AND codA='"+aux2+"' AND act='"+aux4+"'");
                                pst.executeUpdate();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        
                        pP.clear();

    }
    public void mostrardatos(String valor) {
        MiModelo modelo = new MiModelo();
        modelo.addColumn("GESTIÓN");
        modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
        modelo.addColumn("ADMINISTRATIVO");
        modelo.addColumn("E-MAIL");
        modelo.addColumn("TELÉFONO");
        modelo.addColumn("CARGO");
        modelo.addColumn("DEPENDENCIA");
        modelo.addColumn("ACTIVIDAD");
        modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
        modelo.addColumn("<html>FECHA<br>FINAL</html>");
        modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
        modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
        modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
        modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
        modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
        tabA.setModel(modelo);
        TableColumnModel columnModel = tabA.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(4).setPreferredWidth(90);
        columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(5).setPreferredWidth(130);
        columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(6).setPreferredWidth(130);
        columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(7).setPreferredWidth(130);
        columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(8).setPreferredWidth(80);
        columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(9).setPreferredWidth(80);
        columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(10).setPreferredWidth(70);
        columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(11).setPreferredWidth(70);
        columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(12).setPreferredWidth(70);
        columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(13).setPreferredWidth(70);
        columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(14).setPreferredWidth(110);
        columnModel.getColumn(14).setCellRenderer(new MyRen2(9,10));
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.email,actividades.telf,actividades.cargo,actividades.dependencia,actividades.act,actividades.fInicio,actividades.fFinal,actividades.cump,actividades.pp,actividades.sp,actividades.pf,actividades.respR FROM actividades ORDER BY actividades.apellidos, actividades.nombres";
        } else {
            sql = "SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.email,actividades.telf,actividades.cargo,actividades.dependencia,actividades.act,actividades.fInicio,actividades.fFinal,actividades.cump,actividades.pp,actividades.sp,actividades.pf,actividades.respR FROM actividades WHERE actividades.codA='" + valor + "'ORDER BY actividades.apellidos, actividades.nombres";
        }
        Object[] datos = new Object[16];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);
                datos[5] = rs.getString(8);
                datos[6] = rs.getString(9);
                datos[7] = rs.getString(10);
                Date fecha1 = rs.getDate(11);
                Date fecha2 = rs.getDate(12);
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                datos[8] = formato.format(fecha1);
                datos[9] = formato.format(fecha2);
                datos[10] = rs.getBigDecimal(13);
                datos[11] = rs.getBigDecimal(14);
                datos[12] = rs.getBigDecimal(15);
                datos[13] = rs.getBigDecimal(16);
                datos[14] = rs.getString(17);    
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrardatos9(String valor) {
        MiModelo modelo = new MiModelo();
        modelo.addColumn("GESTIÓN");
        modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
        modelo.addColumn("ADMINISTRATIVO");
        modelo.addColumn("E-MAIL");
        modelo.addColumn("TELÉFONO");
        modelo.addColumn("CARGO");
        modelo.addColumn("DEPENDENCIA");
        modelo.addColumn("ACTIVIDAD");
        modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
        modelo.addColumn("<html>FECHA<br>FINAL</html>");
        modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
        modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
        modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
        modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
        modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
        tabA.setModel(modelo);
        TableColumnModel columnModel = tabA.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(4).setPreferredWidth(90);
        columnModel.getColumn(4).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(5).setPreferredWidth(130);
        columnModel.getColumn(5).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(6).setPreferredWidth(130);
        columnModel.getColumn(6).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(7).setPreferredWidth(130);
        columnModel.getColumn(7).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(8).setPreferredWidth(80);
        columnModel.getColumn(8).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(9).setPreferredWidth(80);
        columnModel.getColumn(9).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(10).setPreferredWidth(70);
        columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(11).setPreferredWidth(70);
        columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(12).setPreferredWidth(70);
        columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(13).setPreferredWidth(70);
        columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(14).setPreferredWidth(110);
        columnModel.getColumn(14).setCellRenderer(new MyRen2(9,10));
        String sql = "";
            sql = "SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.email,actividades.telf,actividades.cargo,actividades.dependencia,actividades.act,actividades.fInicio,actividades.fFinal,actividades.cump,actividades.pp,actividades.sp,actividades.pf,actividades.respR FROM actividades WHERE actividades.gestion='" + valor + "'ORDER BY actividades.apellidos, actividades.nombres";
        
        Object[] datos = new Object[16];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);
                datos[5] = rs.getString(8);
                datos[6] = rs.getString(9);
                datos[7] = rs.getString(10);
                Date fecha1 = rs.getDate(11);
                Date fecha2 = rs.getDate(12);
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                datos[8] = formato.format(fecha1);
                datos[9] = formato.format(fecha2);
                datos[10] = rs.getBigDecimal(13);
                datos[11] = rs.getBigDecimal(14);
                datos[12] = rs.getBigDecimal(15);
                datos[13] = rs.getBigDecimal(16);
                datos[14] = rs.getString(17);    
                modelo.addRow(datos);
            }
            tabA.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabA = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cNA = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        cCA = new javax.swing.JTextField();
        cAA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cPF = new com.toedter.calendar.JDateChooser();
        botcon1 = new javax.swing.JButton();
        botcon2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botcon3 = new javax.swing.JButton();
        cPG = new javax.swing.JTextField();
        botcon4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("Ver Sub-Actividades");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem7.setText("VER RECURSO");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabA.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tabA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabA.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabA.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabA);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTIVIDADES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setText("Consultar por apellidos del Administrativo (Debe escribir todos sus apellidos): ");
        jLabel19.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("Consultar por código de Administrativo:");
        jLabel18.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por el nombre de la Actividad:");
        jLabel1.setOpaque(true);

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
        jLabel3.setText("Consultar por Gestión:");
        jLabel3.setOpaque(true);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cAA)
                            .addComponent(cCA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botcon2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botcon1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cNA, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(botcon4)
                .addGap(42, 42, 42))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(jLabel3)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(botcon))
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Atras");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Acerca de");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

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
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null, "autor:Wildo Jhonatan Barrientos Herrera" + sep + "nombre del programa: ControlDeGestion" + sep + "Version: 1.0" + sep + "e-mail: jhonbarh@gmail.com", "Autor", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       int fila = tabA.getSelectedRow();
       if (fila >= 0) {
           this.setVisible(false);
           LSubActividades s= new LSubActividades();
           s.mostrardatos(tabA.getValueAt(fila, 0).toString(), tabA.getValueAt(fila, 1).toString(), tabA.getValueAt(fila, 7).toString());
       }else{
           JOptionPane.showMessageDialog(null, "No selecciono una fila", "", JOptionPane.WARNING_MESSAGE, icono);
       }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         int fila= tabA.getSelectedRow();
         String sep = System.getProperty("line.separator");
        if(fila>= 0){
                     String sql="";
                     String aux="";
                     Abrir a=new Abrir();
                                   sql= "select recurso from actividades WHERE gestion='"+tabA.getValueAt(fila, 0).toString()+"' AND codA='"+tabA.getValueAt(fila, 1).toString()+"' AND act='"+tabA.getValueAt(fila, 7).toString()+"'";
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            aux=rs.getString(1);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
            }
                     a.launchFile("\\\\167.157.17.39\\administracion\\"+aux+"");
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Atras a =new Atras();
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos3(cNA.getText());
        cAA.setText("");
        cCA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos(cCA.getText().toString());
        cAA.setText("");
        cNA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos2(cAA.getText().toString());
        cCA.setText("");
        cNA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos5(formato.format(fecha1));
        cAA.setText("");
        cCA.setText("");
        cNA.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos4(cPG.getText());
        cAA.setText("");
        cCA.setText("");
        cNA.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed
  

    void mostrardatos2(String valor) {
         MiModelo modelo = new MiModelo();
        modelo.addColumn("GESTIÓN");
        modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
        modelo.addColumn("ADMINISTRATIVO");
        modelo.addColumn("E-MAIL");
        modelo.addColumn("TELÉFONO");
        modelo.addColumn("CARGO");
        modelo.addColumn("DEPENDENCIA");
        modelo.addColumn("ACTIVIDAD");
        modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
        modelo.addColumn("<html>FECHA<br>FINAL</html>");
        modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
        modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
        modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
        modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
        modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
        tabA.setModel(modelo);
        TableColumnModel columnModel = tabA.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(4).setPreferredWidth(90);
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
        columnModel.getColumn(10).setPreferredWidth(80);
        columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(11).setPreferredWidth(80);
        columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(12).setPreferredWidth(80);
        columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(13).setPreferredWidth(80);
        columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(14).setPreferredWidth(110);
        columnModel.getColumn(14).setCellRenderer(new MyRen2(9,10));
        String sql = "";
            sql = "SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.email,actividades.telf,actividades.cargo,actividades.dependencia,actividades.act,actividades.fInicio,actividades.fFinal,actividades.cump,actividades.pp,actividades.sp,actividades.pf,actividades.respR FROM actividades WHERE actividades.apellidos='" + valor + "' ORDER BY actividades.apellidos, actividades.nombres";

           Object[] datos = new Object[16];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);
                datos[5] = rs.getString(8);
                datos[6] = rs.getString(9);
                datos[7] = rs.getString(10);
                Date fecha1 = rs.getDate(11);
                Date fecha2 = rs.getDate(12);
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                datos[8] = formato.format(fecha1);
                datos[9] = formato.format(fecha2);
                datos[10] = rs.getBigDecimal(13);
                datos[11] = rs.getBigDecimal(14);
                datos[12] = rs.getBigDecimal(15);
                datos[13] = rs.getBigDecimal(16);
                datos[14] = rs.getString(17);    
                modelo.addRow(datos);
                }
                tabA.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
      void mostrardatos3(String valor) {
         MiModelo modelo = new MiModelo();
        modelo.addColumn("GESTIÓN");
        modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
        modelo.addColumn("ADMINISTRATIVO");
        modelo.addColumn("E-MAIL");
        modelo.addColumn("TELÉFONO");
        modelo.addColumn("CARGO");
        modelo.addColumn("DEPENDENCIA");
        modelo.addColumn("ACTIVIDAD");
        modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
        modelo.addColumn("<html>FECHA<br>FINAL</html>");
        modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
        modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
        modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
        modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
        modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
        tabA.setModel(modelo);
        TableColumnModel columnModel = tabA.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(4).setPreferredWidth(90);
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
        columnModel.getColumn(10).setPreferredWidth(80);
        columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(11).setPreferredWidth(80);
        columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(12).setPreferredWidth(80);
        columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(13).setPreferredWidth(80);
        columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(14).setPreferredWidth(110);
        columnModel.getColumn(14).setCellRenderer(new MyRen2(9,10));
        String sql = "";
            sql = "SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.email,actividades.telf,actividades.cargo,actividades.dependencia,actividades.act,actividades.fInicio,actividades.fFinal,actividades.cump,actividades.pp,actividades.sp,actividades.pf,actividades.respR FROM actividades WHERE actividades.act='" + valor + "' ORDER BY actividades.apellidos, actividades.nombres";

           Object[] datos = new Object[16];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);
                datos[5] = rs.getString(8);
                datos[6] = rs.getString(9);
                datos[7] = rs.getString(10);
                Date fecha1 = rs.getDate(11);
                Date fecha2 = rs.getDate(12);
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                datos[8] = formato.format(fecha1);
                datos[9] = formato.format(fecha2);
                datos[10] = rs.getBigDecimal(13);
                datos[11] = rs.getBigDecimal(14);
                datos[12] = rs.getBigDecimal(15);
                datos[13] = rs.getBigDecimal(16);
                datos[14] = rs.getString(17);    
                modelo.addRow(datos);
                }
                tabA.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
      
        void mostrardatos4(String valor) {
         MiModelo modelo = new MiModelo();
        modelo.addColumn("GESTIÓN");
        modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
        modelo.addColumn("ADMINISTRATIVO");
        modelo.addColumn("E-MAIL");
        modelo.addColumn("TELÉFONO");
        modelo.addColumn("CARGO");
        modelo.addColumn("DEPENDENCIA");
        modelo.addColumn("ACTIVIDAD");
        modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
        modelo.addColumn("<html>FECHA<br>FINAL</html>");
        modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
        modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
        modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
        modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
        modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
        tabA.setModel(modelo);
        TableColumnModel columnModel = tabA.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(4).setPreferredWidth(90);
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
        columnModel.getColumn(10).setPreferredWidth(80);
        columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(11).setPreferredWidth(80);
        columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(12).setPreferredWidth(80);
        columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(13).setPreferredWidth(80);
        columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(14).setPreferredWidth(110);
        columnModel.getColumn(14).setCellRenderer(new MyRen2(9,10));
        String sql = "";
            sql = "SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.email,actividades.telf,actividades.cargo,actividades.dependencia,actividades.act,actividades.fInicio,actividades.fFinal,actividades.cump,actividades.pp,actividades.sp,actividades.pf,actividades.respR FROM actividades WHERE actividades.gestion='" + valor + "' ORDER BY actividades.apellidos, actividades.nombres";

           Object[] datos = new Object[16];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);
                datos[5] = rs.getString(8);
                datos[6] = rs.getString(9);
                datos[7] = rs.getString(10);
                Date fecha1 = rs.getDate(11);
                Date fecha2 = rs.getDate(12);
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                datos[8] = formato.format(fecha1);
                datos[9] = formato.format(fecha2);
                datos[10] = rs.getBigDecimal(13);
                datos[11] = rs.getBigDecimal(14);
                datos[12] = rs.getBigDecimal(15);
                datos[13] = rs.getBigDecimal(16);
                datos[14] = rs.getString(17);    
                modelo.addRow(datos);
                }
                tabA.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
        
          void mostrardatos5(String valor) {
         MiModelo modelo = new MiModelo();
        modelo.addColumn("GESTIÓN");
        modelo.addColumn("<html>CÓDIGO<br>ADMINISTRATIVO</html>");
        modelo.addColumn("ADMINISTRATIVO");
        modelo.addColumn("E-MAIL");
        modelo.addColumn("TELÉFONO");
        modelo.addColumn("CARGO");
        modelo.addColumn("DEPENDENCIA");
        modelo.addColumn("ACTIVIDAD");
        modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
        modelo.addColumn("<html>FECHA<br>FINAL</html>");
        modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
        modelo.addColumn("<html>ENTREGA<br>PRIMER PRODUCTO</html>");
        modelo.addColumn("<html>ENTREGA<br>SEGUNDO PRODUCTO</html>");
        modelo.addColumn("<html>PRODUCTO<br>FINAL</html>");
        modelo.addColumn("<html>RESPONSABLE<br>DE REVISIÓN</html>");
        tabA.setModel(modelo);
        TableColumnModel columnModel = tabA.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(0).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(1).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(2).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(3).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(4).setPreferredWidth(90);
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
        columnModel.getColumn(10).setPreferredWidth(80);
        columnModel.getColumn(10).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(11).setPreferredWidth(80);
        columnModel.getColumn(11).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(12).setPreferredWidth(80);
        columnModel.getColumn(12).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(13).setPreferredWidth(80);
        columnModel.getColumn(13).setCellRenderer(new MyRen2(9,10));
        columnModel.getColumn(14).setPreferredWidth(110);
        columnModel.getColumn(14).setCellRenderer(new MyRen2(9,10));
        String sql = "";
            sql = "SELECT actividades.gestion,actividades.codA,actividades.grado,actividades.apellidos,actividades.nombres,actividades.email,actividades.telf,actividades.cargo,actividades.dependencia,actividades.act,actividades.fInicio,actividades.fFinal,actividades.cump,actividades.pp,actividades.sp,actividades.pf,actividades.respR FROM actividades WHERE actividades.fFinal<='" + valor + "' ORDER BY actividades.apellidos, actividades.nombres";

           Object[] datos = new Object[16];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);
                datos[5] = rs.getString(8);
                datos[6] = rs.getString(9);
                datos[7] = rs.getString(10);
                Date fecha1 = rs.getDate(11);
                Date fecha2 = rs.getDate(12);
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                datos[8] = formato.format(fecha1);
                datos[9] = formato.format(fecha2);
                datos[10] = rs.getBigDecimal(13);
                datos[11] = rs.getBigDecimal(14);
                datos[12] = rs.getBigDecimal(15);
                datos[13] = rs.getBigDecimal(16);
                datos[14] = rs.getString(17);    
                modelo.addRow(datos);
                }
                tabA.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(LActividades.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
          
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JTextField cAA;
    private javax.swing.JTextField cCA;
    private javax.swing.JTextField cNA;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabA;
    // End of variables declaration//GEN-END:variables
Conexion6 cc = new Conexion6();
    Connection cn = cc.conexion();
}
