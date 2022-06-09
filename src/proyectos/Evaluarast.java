/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import text.MiModelo;
import text.MyRen;
import text.MyRen2;
import text.Redondear;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class Evaluarast extends javax.swing.JDialog {
private int contador1;
private String ges;
private String act;
private String cP;
private String res;
private String nom;
private Advertencia icono;
private Bien icono2;
    public Evaluarast(java.awt.Frame parent, boolean modal, String ges,String act,String cP,String res,String nom) {
        super(parent, modal);
        initComponents();
        contador1=1;
        this.ges=ges;
        this.act=act;
        this.cP=cP;
        this.res=res;
        this.nom=nom;
        this.setTitle("EVALUAR PRIMER PRODUCTO");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2=new Bien();
        tabPro.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabPro.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        tabPro.setRowHeight(120);
        botAct.setEnabled(false);
         try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    
    public void mostrardatos(String valor,String valor2,String valor3,String valor4,String valor5){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("<html>PERTINENCIA<br>TEMÁTICA</html>");
    modelo.addColumn("<html>CLARIDAD DE<br>OBJETIVOS</html>");
    modelo.addColumn("<html>CONTENIDO RESPONDE<br>A OBJETIVOS</html>");
    modelo.addColumn("<html>RESULTADOS(HOJAS)<br>(GRAFICOS,ESQUEMAS,MAPAS,INFORME)</html>");
    modelo.addColumn("<html>% DE AVANCE<br>DE ACUERDO A OBJETIVOS</html>");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    String sql="";
  
        sql="select uno,dos,tres,cuatro,cinco from evaluarast where ges='"+valor+"' AND act='"+valor2+"' AND cP='"+valor3+"' AND res='"+valor4+"' AND nom='"+valor5+"'";

 
    Object []datos = new Object [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getBigDecimal(1); 
                datos[1]=rs.getBigDecimal(2);      
                datos[2]=rs.getBigDecimal(3);
                datos[3]=rs.getBigDecimal(4);
                datos[4]=rs.getBigDecimal(5);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Evaluarast.class.getName()).log(Level.SEVERE, null, ex);
        }
        modificar.setEnabled(true);
    
    }
    
 
 public void mostrardatos2(String valor,String valor2,String valor3,String valor4,String valor5){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("<html>%CUMPLI-<br>MIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");  
    modelo.addColumn("<html>CÓDIGO<br>DEL PROYECTO</html>");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("NOMINACIÓN");
    tabPro.setModel(modelo);
    TableColumnModel columnModel = tabPro.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(2).setPreferredWidth(80);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(5).setPreferredWidth(100);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(6).setPreferredWidth(100);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(7).setPreferredWidth(100);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(8).setPreferredWidth(100);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(9).setPreferredWidth(100);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(10).setPreferredWidth(150);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(3,4));
    columnModel.getColumn(11).setPreferredWidth(100);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(3,4));
    String sql="";
        sql="SELECT institucional.gestion,actividad.actividad,actividad.fechaI,actividad.fechaF,actividad.cump,actividad.mPT,actividad.mST,actividad.mTT,actividad.evaluacionF,proyecto.codP,proyecto.responsable,institucional.nominacion FROM actividad,proyecto,institucional WHERE actividad.gestion=proyecto.gestion AND actividad.codP=proyecto.codP AND actividad.responsable=proyecto.responsable AND actividad.nominacion=proyecto.nominacion AND proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND actividad.gestion='"+valor+"' AND actividad.actividad='"+valor2+"' AND actividad.codP='"+valor3+"' AND actividad.responsable='"+valor4+"' AND actividad.nominacion='"+valor5+"' ORDER BY institucional.gestion,proyecto.responsable";
 
    Object []datos = new Object [13];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);      
                Date fecha1= rs.getDate(3);
                Date fecha2= rs.getDate(4);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[2]=formato.format(fecha1);
                datos[3]=formato.format(fecha2);
                datos[4]=rs.getBigDecimal(5);
                datos[5]=rs.getBigDecimal(6);
                datos[6]=rs.getBigDecimal(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
                modelo.addRow(datos);
            }
            tabPro.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        modificar.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        uno = new javax.swing.JTextField();
        dos = new javax.swing.JTextField();
        tres = new javax.swing.JTextField();
        cuatro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        botAct = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cinco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPro = new javax.swing.JTable();

        modificar.setText("modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EVALUAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pertinencia Temática:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Claridad de Objetivos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("El Contenido responde a los Objetivos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Resultados(Hojas,Graficos,Esquemas,Mapas,Informe):");

        uno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                unoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unoKeyTyped(evt);
            }
        });

        dos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dosKeyTyped(evt);
            }
        });

        tres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tresKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tresKeyTyped(evt);
            }
        });

        cuatro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cuatroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cuatroKeyTyped(evt);
            }
        });

        jLabel5.setText("(número decimales del 0 - 20)");

        jLabel6.setText("(número decimales del 0 - 20)");

        jLabel7.setText("(número decimales del 0 - 20)");

        jLabel8.setText("(número decimales del 0 - 20)");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("EVALUAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botAct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botAct.setText("ACTUALIZAR");
        botAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botActActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("SALIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("El % de Avance es de acuerdo a los Objetivos:");

        cinco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cincoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cincoKeyTyped(evt);
            }
        });

        jLabel10.setText("(número decimales del 0 - 20)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botAct, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(botAct))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jLabel9)
                            .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabPro.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabPro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unoKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(uno.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_unoKeyPressed

    private void unoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unoKeyTyped
        char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(uno.getText().contains(".")){
            contador1=2;
        }
        else{
            contador1=1;
        }
        if ((k >= 32 && k <= 45) ||(k >= 58 && k <= 126)  ){
            evt.consume();
            getToolkit().beep();
        }
        if(k==46){
            if (uno.getText().equals("")){
                uno.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    uno.setText(uno.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(uno.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_unoKeyTyped

    private void dosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dosKeyPressed
         char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(dos.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_dosKeyPressed

    private void dosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dosKeyTyped
         char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(dos.getText().contains(".")){
            contador1=2;
        }
        else{
            contador1=1;
        }
        if ((k >= 32 && k <= 45) ||(k >= 58 && k <= 126)  ){
            evt.consume();
            getToolkit().beep();
        }
        if(k==46){
            if (dos.getText().equals("")){
                dos.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    dos.setText(dos.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(dos.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_dosKeyTyped

    private void tresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tresKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(tres.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_tresKeyPressed

    private void tresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tresKeyTyped
         char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(tres.getText().contains(".")){
            contador1=2;
        }
        else{
            contador1=1;
        }
        if ((k >= 32 && k <= 45) ||(k >= 58 && k <= 126)  ){
            evt.consume();
            getToolkit().beep();
        }
        if(k==46){
            if (tres.getText().equals("")){
                tres.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    tres.setText(tres.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(tres.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_tresKeyTyped

    private void cuatroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuatroKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(cuatro.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_cuatroKeyPressed

    private void cuatroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuatroKeyTyped
         char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(cuatro.getText().contains(".")){
            contador1=2;
        }
        else{
            contador1=1;
        }
        if ((k >= 32 && k <= 45) ||(k >= 58 && k <= 126)  ){
            evt.consume();
            getToolkit().beep();
        }
        if(k==46){
            if (cuatro.getText().equals("")){
                cuatro.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    cuatro.setText(cuatro.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(cuatro.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cuatroKeyTyped

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int fila=tabPro.getSelectedRow();
        if(fila>=0){
            uno.setText(tabPro.getValueAt(fila, 0).toString());
            dos.setText(tabPro.getValueAt(fila, 1).toString());
            tres.setText(tabPro.getValueAt(fila, 2).toString());
            cuatro.setText(tabPro.getValueAt(fila, 3).toString());
            cinco.setText(tabPro.getValueAt(fila, 4).toString());
        }
        else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void botActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botActActionPerformed
        mostrardatos2(ges,act,cP,res,nom);
        botAct.setEnabled(false);
    }//GEN-LAST:event_botActActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!(uno.getText().equals(""))&&!(dos.getText().equals(""))&&!(tres.getText().equals(""))&&!(cuatro.getText().equals(""))&&!(cinco.getText().equals(""))){
            Double aux1= Double.parseDouble(uno.getText()); 
            Double aux2= Double.parseDouble(dos.getText());
            Double aux3= Double.parseDouble(tres.getText());
            Double aux4= Double.parseDouble(cuatro.getText());
            Double aux5= Double.parseDouble(cinco.getText());
            Double aux6=aux1+aux2+aux3+aux4+aux5;
            Redondear r=new Redondear();
            aux6=r.rD(aux6);
            if(aux1<0||aux1>20||aux2<0||aux2>20||aux3<0||aux3>20||aux4<0||aux4>20||aux5<0||aux5>20){
                JOptionPane.showMessageDialog(this, "Los Campos de Evaluacion no pueden ser negativos o valer mas de 20","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                BigDecimal aux7= BigDecimal.valueOf(aux1);
                BigDecimal aux8= BigDecimal.valueOf(aux2);
                BigDecimal aux9= BigDecimal.valueOf(aux3);
                BigDecimal aux10= BigDecimal.valueOf(aux4);
                BigDecimal aux11= BigDecimal.valueOf(aux5);
                BigDecimal aux12= BigDecimal.valueOf(aux6);
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE evaluarast SET uno='"+aux7+"',dos='"+aux8+"',tres='"+aux9+"',cuatro='"+aux10+"',cinco='"+aux11+"' WHERE ges='"+ges+"' AND act='"+act+"' AND cP='"+cP+"' AND res='"+res+"'AND nom='"+nom+"'");
                    pst.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                 try {
                PreparedStatement pst = cn.prepareStatement("UPDATE actividad SET mST='"+aux12+"' WHERE gestion='"+ges+"' AND actividad='"+act+"' AND codP='"+cP+"' AND responsable='"+res+"' AND nominacion='"+nom+"'");
                pst.executeUpdate();
                proyecto p=new proyecto();
                p.evaluarMST(ges,cP,res,nom);
                p.setVisible(false);
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton ACTUALIZAR para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                mostrardatos(ges,act,cP,res,nom);
                botAct.setEnabled(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                }
                            
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, Los Campos de Evaluacion no pueden estar vacios","",JOptionPane.WARNING_MESSAGE,icono);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cincoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cincoKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(cinco.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_cincoKeyPressed

    private void cincoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cincoKeyTyped
         char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(cinco.getText().contains(".")){
            contador1=2;
        }
        else{
            contador1=1;
        }
        if ((k >= 32 && k <= 45) ||(k >= 58 && k <= 126)  ){
            evt.consume();
            getToolkit().beep();
        }
        if(k==46){
            if (cinco.getText().equals("")){
                cinco.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    cinco.setText(cinco.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(cinco.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cincoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAct;
    private javax.swing.JTextField cinco;
    private javax.swing.JTextField cuatro;
    private javax.swing.JTextField dos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTable tabPro;
    private javax.swing.JTextField tres;
    private javax.swing.JTextField uno;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
Connection cn= cc.conexion();
}
