/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import text.Control;
import text.MiModelo;
import text.MyRen;
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
public class Cursos extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public Cursos() {
        initComponents();
        nom.addItem("Diplomado");
        nom.addItem("Maestría");
        nom.addItem("Doctorado");
        this.setTitle("POSGRADO");
      int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       this.setLocation(30, 30);
       this.setMinimumSize(new Dimension(ancho-300, alto-400));
       this.setMaximumSize(new Dimension(ancho-10, alto-20));
        icono =new Advertencia();
        icono1=new BotConsul();
        icono2=new BotTodos();
        icono3=new BotInsertar();
        icono4=new BotAct();
        icono5=new Bien2();
         botcon.setIcon(icono1);
        botcon1.setIcon(icono1);
        botcon2.setIcon(icono1);
        botI.setIcon(icono3);
        botA.setIcon(icono4);
        botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
        tabCur.setRowHeight(80);
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
      void mostrardatos(String valor,String valor2){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("CÓDIGO DEL CURSO");
    modelo.addColumn("CURSO");
    modelo.addColumn("NOMINACIÓN");
    tabCur.setModel(modelo);
    TableColumnModel columnModel = tabCur.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(320);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(100);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    String sql="";
    if(valor.equals("")&&valor2.equals(""))
    {
        sql="SELECT institucional.gest,cursos.codigoCurso,cursos.curso,institucional.nomi FROM cursos,institucional WHERE cursos.gestion=institucional.gest AND cursos.nominacion=institucional.nomi ORDER BY cursos.codigoCurso,institucional.gest";
    }
    else{
        sql="SELECT institucional.gest,cursos.codigoCurso,cursos.curso,institucional.nomi FROM cursos,institucional WHERE cursos.gestion=institucional.gest AND cursos.nominacion=institucional.nomi AND cursos.gestion='"+valor+"' AND cursos.nominacion='"+valor2+"'ORDER BY cursos.codigoCurso,institucional.gest";
    }
 
    String []datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            tabCur.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
      public void mostrardatos8(String valor,String valor2,String valor3){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("CÓDIGO DEL CURSO");
    modelo.addColumn("CURSO");
    modelo.addColumn("NOMINACIÓN");
    tabCur.setModel(modelo);
    TableColumnModel columnModel = tabCur.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(320);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(100);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT institucional.gest,cursos.codigoCurso,cursos.curso,institucional.nomi FROM cursos,institucional WHERE cursos.gestion=institucional.gest AND cursos.nominacion=institucional.nomi AND cursos.gestion='"+valor+"' AND cursos.codigoCurso='"+valor2+"' AND cursos.nominacion='"+valor3+"' ORDER BY cursos.codigoCurso,institucional.gest";

    String []datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            tabCur.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabCur = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        nom = new javax.swing.JComboBox<>();
        botcon1 = new javax.swing.JButton();
        botcon2 = new javax.swing.JButton();
        botcon = new javax.swing.JButton();
        cCC = new javax.swing.JTextField();
        botA = new javax.swing.JButton();
        botI = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem5.setText("INSERTAR");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem1.setText("MODIFICAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem6.setText("ELIMINAR");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabCur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabCur.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabCur.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabCur);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CURSOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Consultar por Código de Curso:");
        jLabel5.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por nominación:");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por Gestión:");
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

        botcon.setBackground(new java.awt.Color(0, 72, 225));
        botcon.setForeground(new java.awt.Color(255, 255, 255));
        botcon.setText("Consultar");
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
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCC, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botcon2)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botcon1))
                        .addGap(18, 18, 18)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botI)
                            .addComponent(botA))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon)
                    .addComponent(botA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon1)
                    .addComponent(botI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2))
                .addGap(10, 10, 10))
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

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Generar Reporte");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
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
        int fila= tabCur.getSelectedRow();
        String aux3="";
        String aux4="";
        if(fila>= 0){
            aux3=tabCur.getValueAt(fila, 0).toString();
            aux4=tabCur.getValueAt(fila, 3).toString();
            iC i=new iC(new java.awt.Frame(), true);
            i.llenardatos(aux3, aux4);
            i.setVisible(true);
            mostrardatos8(i.getgestion(),i.getcodC(),i.getnom());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tabCur.getSelectedRow();
        String aux1="";
        String aux2="";
        String aux3="";
        String aux4="";
        if(fila>= 0){
            aux1=tabCur.getValueAt(fila, 0).toString();
            aux2=tabCur.getValueAt(fila, 1).toString();
            aux3=tabCur.getValueAt(fila, 2).toString();
            aux4=tabCur.getValueAt(fila, 3).toString();
            mC m=new mC(new java.awt.Frame(), true);
            m.llenardatos(aux1,aux2,aux3, aux4);
            m.setVisible(true);
            mostrardatos8(m.getgestion(),m.getcodC(),m.getnom());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int fila= tabCur.getSelectedRow();
        String aux1="";
        String aux2="";
        String aux3="";
        String aux4="";
        if(fila>= 0){
            aux1=tabCur.getValueAt(fila, 0).toString();
            aux2=tabCur.getValueAt(fila, 1).toString();
            aux3=tabCur.getValueAt(fila, 2).toString();
            aux4=tabCur.getValueAt(fila, 3).toString();
            eC e=new eC(new java.awt.Frame(), true);
            e.llenardatos(aux1,aux2,aux3, aux4);
            e.setVisible(true);
             mostrardatos8(e.getgestion(),e.getcodC(),e.getnom());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Report r=new Report(new java.awt.Frame(), true,this.cn,"RCursos.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos3(nom.getSelectedItem().toString());
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos4(cPG.getText());
        cCC.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos2(cCC.getText());
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","");
         cPG.setText("");
         cCC.setText("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono5);
    }//GEN-LAST:event_botAActionPerformed

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        iC i=new iC(new java.awt.Frame(), true);
        i.llenardatos("", "Diplomado");
        i.setVisible(true);
        mostrardatos8(i.getgestion(),i.getcodC(),i.getnom());
    }//GEN-LAST:event_botIActionPerformed

    void mostrardatos2(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("CÓDIGO DEL CURSO");
    modelo.addColumn("CURSO");
    modelo.addColumn("NOMINACIÓN");
    tabCur.setModel(modelo);
    TableColumnModel columnModel = tabCur.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(320);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(100);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT institucional.gest,cursos.codigoCurso,cursos.curso,institucional.nomi FROM cursos,institucional WHERE cursos.gestion=institucional.gest AND cursos.nominacion=institucional.nomi AND cursos.codigoCurso='"+valor+"' ORDER BY cursos.codigoCurso,institucional.gest";

    String []datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            tabCur.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void mostrardatos3(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("CÓDIGO DEL CURSO");
    modelo.addColumn("CURSO");
    modelo.addColumn("NOMINACIÓN");
    tabCur.setModel(modelo);
    TableColumnModel columnModel = tabCur.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(320);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(100);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT institucional.gest,cursos.codigoCurso,cursos.curso,institucional.nomi FROM cursos,institucional WHERE cursos.gestion=institucional.gest AND cursos.nominacion=institucional.nomi AND cursos.nominacion='"+valor+"' ORDER BY cursos.codigoCurso,institucional.gest";

    String []datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            tabCur.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     void mostrardatos4(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("CÓDIGO DEL CURSO");
    modelo.addColumn("CURSO");
    modelo.addColumn("NOMINACIÓN");
    tabCur.setModel(modelo);
    TableColumnModel columnModel = tabCur.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(320);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(100);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    String sql="";
        sql="SELECT institucional.gest,cursos.codigoCurso,cursos.curso,institucional.nomi FROM cursos,institucional WHERE cursos.gestion=institucional.gest AND cursos.nominacion=institucional.nomi AND institucional.gest='"+valor+"' ORDER BY cursos.codigoCurso,institucional.gest";

    String []datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            tabCur.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
    private javax.swing.JButton botI;
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JTextField cCC;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nom;
    private javax.swing.JTable tabCur;
    // End of variables declaration//GEN-END:variables
Conexion2 cc= new Conexion2();
Connection cn= cc.conexion();
}
