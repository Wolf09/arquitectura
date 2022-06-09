/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import arqui1.ConexionUser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import text.Control;
import text.MiModelo;
import text.MyRen;
import ziconos.Advertencia;
import ziconos.Bien;
import ziconos.Bien2;
import ziconos.BotAct;
import ziconos.BotConsul;
import ziconos.BotEli;
import ziconos.BotInsertar;
import ziconos.BotMod;
import ziconos.BotTodos;

/**
 *
 * @author Jhon
 */
public class Permisos extends javax.swing.JFrame {
private Advertencia icono;
private Bien icono2;
private BotConsul icono7;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
private BotMod icono8;
private BotEli icono9;
    public Permisos() {
        initComponents();
        tipo.addItem("tipo1");
        tipo.addItem("tipo2");
        tipo.addItem("tipo3");
        tipo.addItem("tipo4");
        tipo.addItem("tipo5");
        tipo.addItem("tipo6");
        tipo.addItem("tipo7");
        tipo.addItem("tipo8");
        tipo.addItem("tipo9");
        tipo.addItem("tipo10");
        tipo.addItem("ADMINISTRADOR");
        this.setTitle("USUARIOS");
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        icono =new Advertencia();
        icono2 =new Bien();
        icono7=new BotConsul();
        icono3=new BotTodos();
        icono4=new BotInsertar();
        icono5=new BotAct();
        icono6=new Bien2(); 
        icono8=new BotMod();
        icono9=new BotEli();
        botI.setIcon(icono4);
        botE.setIcon(icono9);
        botM.setIcon(icono8);
        botcon.setIcon(icono7);
        botMT.setIcon(icono3);
        botA.setIcon(icono5);
        botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
        botMT.setToolTipText("<html>Se Muestran<br>Todos los Datos</html>");
        tabI.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabI.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        tabI.setRowHeight(120); 
        this.addWindowListener ( new WindowAdapter() { 
        public void windowClosing(WindowEvent e) { 
            setVisible(false);
        } 
        }); 
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        nU1.setVisible(false);
        this.getContentPane().setBackground(new Color(0,0,120));
        this.setVisible(true);
    }
    
    public void mostrardatos(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("<html>NOMBRE<br>USUARIO</html>");
    modelo.addColumn("CONTRASEÑA");
    modelo.addColumn("TIPO");
    modelo.addColumn("APELLIDOS");
    modelo.addColumn("NOMBRES");
    modelo.addColumn("CELULAR");
    modelo.addColumn("E-MAIL");
    modelo.addColumn("MATERIA1");
    modelo.addColumn("MATERIA2");
    modelo.addColumn("MATERIA3");
    modelo.addColumn("MATERIA4");
    modelo.addColumn("MATERIA5");
    modelo.addColumn("MATERIA6");
    modelo.addColumn("MATERIA7");
    modelo.addColumn("RESPONSABLE1");
    modelo.addColumn("RESPONSABLE2");
    modelo.addColumn("RESPONSABLE3");
    modelo.addColumn("RESPONSABLE4");
    modelo.addColumn("RESPONSABLE5");
    modelo.addColumn("RESPONSABLE6");
    tabI.setModel(modelo);
    TableColumnModel columnModel = tabI.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    columnModel.getColumn(8).setCellRenderer(new MyRen());
    columnModel.getColumn(9).setCellRenderer(new MyRen());
    columnModel.getColumn(10).setCellRenderer(new MyRen());
    columnModel.getColumn(11).setCellRenderer(new MyRen());
    columnModel.getColumn(12).setCellRenderer(new MyRen());
    columnModel.getColumn(13).setCellRenderer(new MyRen());
    columnModel.getColumn(14).setCellRenderer(new MyRen());
    columnModel.getColumn(15).setCellRenderer(new MyRen());
    columnModel.getColumn(16).setCellRenderer(new MyRen());
    columnModel.getColumn(17).setCellRenderer(new MyRen());
    columnModel.getColumn(18).setCellRenderer(new MyRen());
    columnModel.getColumn(19).setCellRenderer(new MyRen());
    String sql="";
    if(valor.equals("")){
        sql="SELECT nombreUsuario,contrasena,tipo,apellidos,nombres,celular,email,materia1,materia2,materia3,materia4,materia5,materia6,materia7,responsable1,responsable2,responsable3,responsable4,responsable5,responsable6 FROM user ORDER BY apellidos";
    }
    else{
        sql="SELECT nombreUsuario,contrasena,tipo,apellidos,nombres,celular,email,materia1,materia2,materia3,materia4,materia5,materia6,materia7,responsable1,responsable2,responsable3,responsable4,responsable5,responsable6 FROM user where apellidos='"+valor+"'ORDER BY apellidos";
    }
    String []datos = new String [21];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                datos[16]=rs.getString(17);
                datos[17]=rs.getString(18);
                datos[18]=rs.getString(19);
                datos[19]=rs.getString(20);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabI = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel1 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox();
        botcon = new javax.swing.JButton();
        botA = new javax.swing.JButton();
        botM = new javax.swing.JButton();
        botMT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cAU = new javax.swing.JTextField();
        botI = new javax.swing.JButton();
        botE = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nU = new javax.swing.JTextField();
        aU = new javax.swing.JTextField();
        nNU = new javax.swing.JTextField();
        cel = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mat1 = new javax.swing.JTextField();
        mat2 = new javax.swing.JTextField();
        mat3 = new javax.swing.JTextField();
        mat4 = new javax.swing.JTextField();
        mat5 = new javax.swing.JTextField();
        mat6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mat7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        res1 = new javax.swing.JTextField();
        res2 = new javax.swing.JTextField();
        res3 = new javax.swing.JTextField();
        res4 = new javax.swing.JTextField();
        res5 = new javax.swing.JTextField();
        res6 = new javax.swing.JTextField();
        nU1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        con = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("MODIFICAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tabI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabI.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabI);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tipo:");
        jLabel1.setOpaque(true);

        botcon.setBackground(new java.awt.Color(0, 72, 225));
        botcon.setForeground(new java.awt.Color(255, 255, 255));
        botcon.setText("consultar");
        botcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botconActionPerformed(evt);
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

        botM.setBackground(new java.awt.Color(0, 72, 225));
        botM.setForeground(new java.awt.Color(255, 255, 255));
        botM.setText("MODIFICAR");
        botM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botMActionPerformed(evt);
            }
        });

        botMT.setBackground(new java.awt.Color(0, 72, 225));
        botMT.setForeground(new java.awt.Color(255, 255, 255));
        botMT.setText("mostrar Todos");
        botMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botMTActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("Consultar por Apellidos del Usuario:");
        jLabel2.setOpaque(true);

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("INSERTAR");
        botI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIActionPerformed(evt);
            }
        });

        botE.setBackground(new java.awt.Color(0, 72, 225));
        botE.setForeground(new java.awt.Color(255, 255, 255));
        botE.setText("ELIMINAR");
        botE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Nombre de Usuario:");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Apellidos:");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Nombres:");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("celular:");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("E-mail:");
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Materia1:");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Materia2:");
        jLabel9.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Materia3:");
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Materia4:");
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("Materia5:");
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("Materia6:");
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Materia7:");
        jLabel14.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Responsable1:");
        jLabel15.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setText("Responsable2:");
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("Responsable3:");
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("Responsable4:");
        jLabel18.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setText("Responsable5:");
        jLabel19.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 0));
        jLabel20.setText("Responsable6:");
        jLabel20.setOpaque(true);

        nU1.setForeground(new java.awt.Color(255, 255, 51));
        nU1.setText("jLabel21");

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("Contraseña:");
        jLabel21.setOpaque(true);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 0));
        jLabel22.setText("*");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 0));
        jLabel23.setText("*");

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setForeground(new java.awt.Color(255, 51, 0));
        jLabel24.setText("Los Campos marcados con * deben ser llenados SON IMPORTANTES!!! OJO");
        jLabel24.setOpaque(true);

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cAU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipo, 0, 151, Short.MAX_VALUE)
                            .addComponent(nU)
                            .addComponent(aU)
                            .addComponent(nNU)
                            .addComponent(cel)
                            .addComponent(email)
                            .addComponent(con))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mat7))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mat1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mat2))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mat3))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mat4))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mat5))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mat6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(res1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(res2))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(res3))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(res4))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(res5))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(res6))
                            .addComponent(nU1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botMT, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(botA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(nU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(mat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(res1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botI))
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(mat5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(res5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(mat6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(res6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(mat7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nU1)))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(aU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(nNU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addGap(18, 18, 18)
                                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botcon)
                            .addComponent(jLabel2)
                            .addComponent(cAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botM)
                            .addComponent(jLabel9)
                            .addComponent(mat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(res2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(con, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botE)
                            .addComponent(jLabel10)
                            .addComponent(mat3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(res3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botA)
                            .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(mat4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(res4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(botMT)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        jMenu1.setText("Archivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

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

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Acerca de Los Tipos");
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
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0"+sep+"e-mail: jhonbarh@gmail.com","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         int fila= tabI.getSelectedRow();
        if(fila>= 0){
            nU.setText(tabI.getValueAt(fila, 0).toString());
            con.setText(tabI.getValueAt(fila, 1).toString());
            tipo.setSelectedItem(tabI.getValueAt(fila, 2).toString());
            aU.setText(tabI.getValueAt(fila, 3).toString());
            nNU.setText(tabI.getValueAt(fila, 4).toString());
            cel.setText(tabI.getValueAt(fila, 5).toString());
            email.setText(tabI.getValueAt(fila, 6).toString());
            mat1.setText(tabI.getValueAt(fila, 7).toString());
            mat2.setText(tabI.getValueAt(fila, 8).toString());
            mat3.setText(tabI.getValueAt(fila, 9).toString());
            mat4.setText(tabI.getValueAt(fila, 10).toString());
            mat5.setText(tabI.getValueAt(fila, 11).toString());
            mat6.setText(tabI.getValueAt(fila, 12).toString());
            mat7.setText(tabI.getValueAt(fila, 13).toString());
            res1.setText(tabI.getValueAt(fila, 14).toString());
            res2.setText(tabI.getValueAt(fila, 15).toString());
            res3.setText(tabI.getValueAt(fila, 16).toString());
            res4.setText(tabI.getValueAt(fila, 17).toString());
            res5.setText(tabI.getValueAt(fila, 18).toString());
            res6.setText(tabI.getValueAt(fila, 19).toString());
            nU1.setText(tabI.getValueAt(fila, 0).toString());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botMActionPerformed
        int fila= tabI.getSelectedRow();
        if(fila>=0){
            if(nU.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No Ingreso datos el nombre de usuario no debe estar vacio","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE user SET nombreUsuario='"+nU.getText()+"',contrasena='"+con.getText()+"',tipo='"+tipo.getSelectedItem().toString()+"',apellidos='"+aU.getText()+"',nombres='"+nNU.getText()+"',celular='"+cel.getText()+"',email='"+email.getText()+"',materia1='"+mat1.getText()+"',materia2='"+mat2.getText()+"',materia3='"+mat3.getText()+"',materia4='"+mat4.getText()+"',materia5='"+mat5.getText()+"',materia6='"+mat6.getText()+"',materia7='"+mat7.getText()+"',responsable1='"+res1.getText()+"',responsable2='"+res2.getText()+"',responsable3='"+res3.getText()+"',responsable4='"+res4.getText()+"',responsable5='"+res5.getText()+"',responsable6='"+res6.getText()+"' WHERE nombreUsuario='"+nU1.getText()+"'");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (SQLException ex) {
                    Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, nombre de Usuario duplicado No se realizo cambios, o el numero de letras excede un campo","",JOptionPane.WARNING_MESSAGE,icono);
                }
            }
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botMActionPerformed

    private void botMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botMTActionPerformed
        mostrardatos("");
    }//GEN-LAST:event_botMTActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        mostrardatos("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono6);
    }//GEN-LAST:event_botAActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
            mostrardatos(cAU.getText());
    }//GEN-LAST:event_botconActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Ayuda a=new Ayuda(new java.awt.Frame(), true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
            if(nU.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No Ingreso datos el nombre de usuario no debe estar vacio","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO user(nombreUsuario,contrasena,tipo,apellidos,nombres,celular,email,materia1,materia2,materia3,materia4,materia5,materia6,materia7,responsable1,responsable2,responsable3,responsable4,responsable5,responsable6) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, nU.getText());
                    pst.setString(2, con.getText());
                    pst.setString(3, tipo.getSelectedItem().toString());
                    pst.setString(4, aU.getText());
                    pst.setString(5, nNU.getText());
                    pst.setString(6, cel.getText());
                    pst.setString(7, email.getText());
                    pst.setString(8, mat1.getText());
                    pst.setString(9, mat2.getText());
                    pst.setString(10, mat3.getText());
                    pst.setString(11, mat4.getText());
                    pst.setString(12, mat5.getText());
                    pst.setString(13, mat6.getText());
                    pst.setString(14, mat7.getText());
                    pst.setString(15, res1.getText());
                    pst.setString(16, res2.getText());
                    pst.setString(17, res3.getText());
                    pst.setString(18, res4.getText());
                    pst.setString(19, res5.getText());
                    pst.setString(20, res6.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (SQLException ex) {
                    Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, nombre de Usuario duplicado No se realizo cambios, o el numero de letras excede un campo","",JOptionPane.WARNING_MESSAGE,icono);
                }
            }
    }//GEN-LAST:event_botIActionPerformed

    private void botEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEActionPerformed
        int fila= tabI.getSelectedRow();
        if(fila>=0){
            if(nU.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No Ingreso datos el nombre de usuario no debe estar vacio","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                try {
                    PreparedStatement pst2 = cn.prepareStatement ("DELETE FROM user WHERE nombreUsuario='"+nU.getText()+"'");
                     pst2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (SQLException ex) {
                    Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, nombre de Usuario duplicado No se realizo cambios, o el numero de letras excede un campo","",JOptionPane.WARNING_MESSAGE,icono);
                }
            }
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_botEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aU;
    private javax.swing.JButton botA;
    private javax.swing.JButton botE;
    private javax.swing.JButton botI;
    private javax.swing.JButton botM;
    private javax.swing.JButton botMT;
    private javax.swing.JButton botcon;
    private javax.swing.JTextField cAU;
    private javax.swing.JTextField cel;
    private javax.swing.JTextField con;
    private text.CustomPanel customPanel1;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mat1;
    private javax.swing.JTextField mat2;
    private javax.swing.JTextField mat3;
    private javax.swing.JTextField mat4;
    private javax.swing.JTextField mat5;
    private javax.swing.JTextField mat6;
    private javax.swing.JTextField mat7;
    private javax.swing.JTextField nNU;
    private javax.swing.JTextField nU;
    private javax.swing.JLabel nU1;
    private javax.swing.JTextField res1;
    private javax.swing.JTextField res2;
    private javax.swing.JTextField res3;
    private javax.swing.JTextField res4;
    private javax.swing.JTextField res5;
    private javax.swing.JTextField res6;
    private javax.swing.JTable tabI;
    private javax.swing.JComboBox tipo;
    // End of variables declaration//GEN-END:variables
ConexionUser cc= new ConexionUser();
Connection cn= cc.conexion();
}
