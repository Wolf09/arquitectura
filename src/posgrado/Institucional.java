/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;
import Interfaz.Atras;
import java.awt.Color;
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
import text.Control;
import text.MiModelo;
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
public class Institucional extends javax.swing.JFrame {
private Advertencia icono;
private Bien icono2;
private BotConsul icono7;
private BotTodos icono3;
private BotInsertar icono4;
private BotAct icono5;
private Bien2 icono6;
private BotMod icono8;
private BotEli icono9;
    public Institucional() {
        initComponents();
        nomi.addItem("Diplomado");
        nomi.addItem("Maestría");
        nomi.addItem("Doctorado");
        this.setTitle("POSGRADO");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2 =new Bien();
        icono7=new BotConsul();
        icono3=new BotTodos();
        icono4=new BotInsertar();
        icono5=new BotAct();
        icono6=new Bien2(); 
        icono8=new BotMod();
        icono9=new BotEli();
        botM.setIcon(icono8);
        botcon.setIcon(icono7);
        botI.setIcon(icono4);
        botA.setIcon(icono5);
        botE.setIcon(icono9);
        botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
        tabI.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        tabI.setRowHeight(40);
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
        nomi1.setVisible(false);
        gestion1.setVisible(false);
        this.setVisible(true);
    }
    
    public void mostrardatos(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabI.setModel(modelo);
    String sql="";
    if(valor.equals("")){
        sql="SELECT * FROM institucional ORDER BY gest";
    }
    else{
        sql="SELECT * FROM institucional WHERE gest='"+valor+"'ORDER BY gest";
    }
    String []datos = new String [3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(posgrado.Institucional.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void mostrardatos8(String valor,String valor2){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabI.setModel(modelo);
    String sql="";
        sql="SELECT * FROM institucional WHERE gest='"+valor+"' AND nomi='"+valor2+"'ORDER BY gest";

    String []datos = new String [3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(posgrado.Institucional.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
     public void mostrardatos9(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabI.setModel(modelo);
    String sql="";
        sql="SELECT * FROM institucional WHERE gest='"+valor+"'ORDER BY gest";

    String []datos = new String [3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                modelo.addRow(datos);
            }
            tabI.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(posgrado.Institucional.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabI = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel1 = new javax.swing.JLabel();
        nomi = new javax.swing.JComboBox();
        cPG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botcon = new javax.swing.JButton();
        gestion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botI = new javax.swing.JButton();
        botA = new javax.swing.JButton();
        botM = new javax.swing.JButton();
        botE = new javax.swing.JButton();
        nomi1 = new javax.swing.JLabel();
        gestion1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("modificar o eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem4.setText("ver Areas Temáticas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setText("ver Cursos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem6.setText("Ver Docentes");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);

        jMenuItem7.setText("Ver Estudiantes Inscritos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabI.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabI);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INSTITUCIONAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("nominación:");
        jLabel1.setOpaque(true);

        cPG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPGKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por gestion:");
        jLabel3.setOpaque(true);

        botcon.setBackground(new java.awt.Color(0, 72, 225));
        botcon.setForeground(new java.awt.Color(255, 255, 255));
        botcon.setText("consultar");
        botcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botconActionPerformed(evt);
            }
        });

        gestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gestionKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Gestión:");
        jLabel2.setOpaque(true);

        botI.setBackground(new java.awt.Color(0, 72, 225));
        botI.setForeground(new java.awt.Color(255, 255, 255));
        botI.setText("insertar");
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

        botM.setBackground(new java.awt.Color(0, 72, 225));
        botM.setForeground(new java.awt.Color(255, 255, 255));
        botM.setText("modificar");
        botM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botMActionPerformed(evt);
            }
        });

        botE.setBackground(new java.awt.Color(0, 72, 225));
        botE.setForeground(new java.awt.Color(255, 255, 255));
        botE.setText("eliminar");
        botE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEActionPerformed(evt);
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
                        .addComponent(nomi1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botI))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addGap(0, 567, Short.MAX_VALUE)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botE, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customPanel1Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomi, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(customPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botcon)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomi1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botA)
                        .addGap(11, 11, 11)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botI)
                            .addComponent(botM))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon))
                    .addGap(14, 14, 14)))
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

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Atras");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       new Control().cerrarApp();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"autor:Wildo Jhonatan Barrientos Herrera"+sep+"nombre del programa: ControlDeGestion"+sep+"Version: 1.0"+sep+"e-mail: jhonbarh@gmail.com","Autor",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         int fila= tabI.getSelectedRow();
        if(fila>= 0){
            gestion.setText(tabI.getValueAt(fila, 0).toString());
            nomi.setSelectedItem(tabI.getValueAt(fila, 1).toString());
            gestion1.setText(tabI.getValueAt(fila, 0).toString());
            nomi1.setText(tabI.getValueAt(fila, 1).toString());         
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         int fila= tabI.getSelectedRow();
        if(fila>= 0){
            AreaTematica a = new AreaTematica();
            a.mostrardatos(tabI.getValueAt(fila, 0).toString(), tabI.getValueAt(fila, 1).toString());
            this.setVisible(false);
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int fila= tabI.getSelectedRow();
        if(fila>= 0){
            Cursos c = new Cursos();
            c.mostrardatos(tabI.getValueAt(fila, 0).toString(), tabI.getValueAt(fila, 1).toString());
            this.setVisible(false);
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int fila= tabI.getSelectedRow();
        if(fila>= 0){
            if((tabI.getValueAt(fila, 1).toString()).equals("Diplomado")){
                Diplomado d = new Diplomado();
                d.mostrardatos(tabI.getValueAt(fila, 0).toString(), tabI.getValueAt(fila, 1).toString());
                this.setVisible(false);
            }
            if((tabI.getValueAt(fila, 1).toString()).equals("Maestría")){
                Maestria m = new Maestria();
                m.mostrardatos(tabI.getValueAt(fila, 0).toString(), tabI.getValueAt(fila, 1).toString());
                this.setVisible(false);
            }
            if((tabI.getValueAt(fila, 1).toString()).equals("Doctorado")){
                Doctorado doc = new Doctorado();
                doc.mostrardatos(tabI.getValueAt(fila, 0).toString(), tabI.getValueAt(fila, 1).toString());
                this.setVisible(false);
            }
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int fila= tabI.getSelectedRow();
        if(fila>= 0){
            Estudiante e = new Estudiante();
            e.mostrardatos(tabI.getValueAt(fila, 0).toString(), tabI.getValueAt(fila, 1).toString());
            this.setVisible(false);
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Atras a =new Atras();
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void cPGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPGKeyTyped
        if(cPG.getText().length()==19){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cPGKeyTyped

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos(cPG.getText());
        gestion.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void gestionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestionKeyTyped
        if(gestion.getText().length()==20){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_gestionKeyTyped

    private void botIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIActionPerformed
        String sep = System.getProperty("line.separator");
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.add(Calendar.DAY_OF_YEAR,1);
        java.util.Date fecha1 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band= true;
        if((nomi.getSelectedItem().toString()).equals("")||gestion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos ingrese porfavor","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            if(band==true){
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO institucional(gest,nomi) VALUES (?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, nomi.getSelectedItem().toString());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                    mostrardatos8(gestion.getText(),nomi.getSelectedItem().toString());
                    gestion.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, nominacion,gestion duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo","",JOptionPane.WARNING_MESSAGE,icono);
                    band= false;
                }
            }
            /*
            if(band==true){
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO areatematica(gestion,codigoAT,areaTematica,nominacion) VALUES (?,?,?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, "");
                    pst.setString(3, "");
                    pst.setString(4, nomi.getSelectedItem().toString());
                    pst.executeUpdate();
                } catch (Exception e) {
                    Logger.getLogger(Institucional.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(band==true){
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO cursos(gestion,codigoCurso,curso,nominacion) VALUES (?,?,?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, "");
                    pst.setString(3, "");
                    pst.setString(4, nomi.getSelectedItem().toString());
                    pst.executeUpdate();
                } catch (Exception e) {
                    Logger.getLogger(Institucional.class.getName()).log(Level.SEVERE, null, e);
                }

            }

            if(band==true){
                if((nomi.getSelectedItem().toString()).equals("Diplomado")){
                    try {
                        PreparedStatement pst = cn.prepareStatement("INSERT INTO diplomado(gestion,codDoc,grado,apellidos,nombres,telefono,email,materia,unidadTematica,actividad,fechaInicio,fechaFin,cumplimiento,evaluacion,recurso,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, gestion.getText());
                        pst.setString(2, "");
                        pst.setString(3, "Dr.");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, formato.format(fecha1));
                        pst.setString(12, formato.format(fecha1));
                        Double aux3= 0.0;
                        BigDecimal aux4= BigDecimal.valueOf(aux3);
                        Double aux5=0.0;
                        BigDecimal aux6= BigDecimal.valueOf(aux5);
                        pst.setBigDecimal(13,aux4);
                        pst.setBigDecimal(14,aux6);
                        pst.setString(15, "");
                        pst.setString(16, nomi.getSelectedItem().toString());
                        pst.executeUpdate();
                    } catch (Exception e) {
                        Logger.getLogger(Institucional.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if((nomi.getSelectedItem().toString()).equals("Maestría")){
                    try {
                        PreparedStatement pst = cn.prepareStatement("INSERT INTO maestria(gestion,codDoc,grado,apellidos,nombres,telefono,email,materia,unidadTematica,actividad,fechaInicio,fechaFin,cumplimiento,evaluacion,recurso,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, gestion.getText());
                        pst.setString(2, "");
                        pst.setString(3, "Dr.");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, formato.format(fecha1));
                        pst.setString(12, formato.format(fecha1));
                        Double aux3= 0.0;
                        BigDecimal aux4= BigDecimal.valueOf(aux3);
                        Double aux5=0.0;
                        BigDecimal aux6= BigDecimal.valueOf(aux5);
                        pst.setBigDecimal(13,aux4);
                        pst.setBigDecimal(14,aux6);
                        pst.setString(15, "");
                        pst.setString(16, nomi.getSelectedItem().toString());
                        pst.executeUpdate();
                    } catch (Exception e) {
                        Logger.getLogger(Institucional.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if((nomi.getSelectedItem().toString()).equals("Doctorado")){
                    try {
                        PreparedStatement pst = cn.prepareStatement("INSERT INTO doctorado(gestion,codDoc,grado,apellidos,nombres,telefono,email,materia,unidadTematica,actividad,fechaInicio,fechaFin,cumplimiento,evaluacion,recurso,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, gestion.getText());
                        pst.setString(2, "");
                        pst.setString(3, "Dr.");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, formato.format(fecha1));
                        pst.setString(12, formato.format(fecha1));
                        Double aux3= 0.0;
                        BigDecimal aux4= BigDecimal.valueOf(aux3);
                        Double aux5=0.0;
                        BigDecimal aux6= BigDecimal.valueOf(aux5);
                        pst.setBigDecimal(13,aux4);
                        pst.setBigDecimal(14,aux6);
                        pst.setString(15, "");
                        pst.setString(16, nomi.getSelectedItem().toString());
                        pst.executeUpdate();
                    } catch (Exception e) {
                        Logger.getLogger(Institucional.class.getName()).log(Level.SEVERE, null, e);
                    }
                }

            }
            if(band==true){
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO estudiante(gestion,codigoestudiante,apellidos,nombres,email,telefono,codMat,materia,resultadoEvaluaciones,cumplimiento,nominacion) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, "");
                    pst.setString(3, "");
                    pst.setString(4, "");
                    pst.setString(5, "");
                    pst.setString(6, "");
                    pst.setString(7, "");
                    pst.setString(8, "");
                    Double aux3= 0.0;
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    pst.setBigDecimal(9, aux4);
                    Double aux5= 0.0;
                    BigDecimal aux6= BigDecimal.valueOf(aux5);
                    pst.setBigDecimal(10, aux6);
                    pst.setString(11, nomi.getSelectedItem().toString());
                    pst.executeUpdate();
                } catch (Exception e) {
                    Logger.getLogger(Institucional.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            */

        }
        cPG.setText("");
    }//GEN-LAST:event_botIActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono6);
        gestion.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botAActionPerformed

    private void botMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botMActionPerformed
        String sep = System.getProperty("line.separator");
        if(!((nomi.getSelectedItem().toString()).equals(""))||!(gestion.getText().equals(""))){
            try {
                PreparedStatement pst = cn.prepareStatement ("UPDATE institucional SET gest='"+gestion.getText()+"', nomi='"+nomi.getSelectedItem().toString()+"' WHERE gest='"+gestion1.getText()+"' AND nomi='"+nomi1.getText()+"'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                mostrardatos8(gestion.getText(),nomi.getSelectedItem().toString());
                gestion.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, nominacion,gestion duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo","",JOptionPane.WARNING_MESSAGE,icono);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, nominacion,gestión NO PUEDEN ESTAR VACIOS NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
        }
        cPG.setText("");
    }//GEN-LAST:event_botMActionPerformed

    private void botEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEActionPerformed
        if((nomi.getSelectedItem().toString()).equals("")||gestion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "NO SELECCIONO FILA A ELIMINAR ","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            JOptionPane.showMessageDialog(null, "Al Eliminaran todos los Docentes,Cursos,Áreas Temáticas,Estudiantes Dependientes de este","",JOptionPane.WARNING_MESSAGE,icono);
            try {  
                PreparedStatement pst = cn.prepareStatement ("DELETE FROM institucional WHERE gest='"+gestion.getText()+"' AND nomi='"+nomi.getSelectedItem().toString()+"'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                mostrardatos8(gestion.getText(),nomi.getSelectedItem().toString());
                gestion.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
            }

        }
        cPG.setText("");
    }//GEN-LAST:event_botEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
    private javax.swing.JButton botE;
    private javax.swing.JButton botI;
    private javax.swing.JButton botM;
    private javax.swing.JButton botcon;
    private javax.swing.JTextField cPG;
    private text.CustomPanel customPanel1;
    private javax.swing.JTextField gestion;
    private javax.swing.JLabel gestion1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox nomi;
    private javax.swing.JLabel nomi1;
    private javax.swing.JTable tabI;
    // End of variables declaration//GEN-END:variables
Conexion2 cc= new Conexion2();
Connection cn= cc.conexion();
}
