/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posgrado;

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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
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
public class EvaluarD extends javax.swing.JDialog {
private int contador1;
private String gest;
private String cD;
private String m;
private String uT;
private String act;
private String nom;
private Advertencia icono;
private Bien icono2;
private ChartPanel panel;
private JFreeChart chart = null;
    public EvaluarD(java.awt.Frame parent, boolean modal,String gest,String cD,String m,String uT,String act,String nom) {
        super(parent, modal);
        initComponents();
        contador1=1;
        this.gest=gest;
        this.cD=cD;
        this.m=m;
        this.uT=uT;
        this.act=act;
        this.nom=nom;
        this.setTitle("EVALUAR DOCENTE");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2=new Bien();
        tabD.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabD.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        tabD.setRowHeight(130);
        botAct.setEnabled(false);
         try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }

    public String getgest(){
    return gest;
    }
    public String getcD(){
    return cD;
    }
    public String getm(){
    return m;
    }
    public String getuT(){
    return uT;
    }
    public String getact(){
    return act;
    }
    public String getnom(){
    return nom;
    }
       public void mostrardatos(String valor,String valor2,String valor3,String valor4,String valor5,String valor6){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("<html>CONOCE Y DESARROLLA<br>NUEVAS TEORÍAS</html>");
    modelo.addColumn("<html>EMPLEA ESTRATEGIAS DE<br>APRENDIZAJE SIGNIFICATIVO</html>");
    modelo.addColumn("<html>PROMUEVE ACTITUDES DE<br>COMPROMISO Y SOLIDARIDAD</html>");
    modelo.addColumn("<html>ESTABLECE Y CUMPLE<br>NORMAS DE COMPORTAMIENTO</html>");
    tabD.setModel(modelo);
    TableColumnModel columnModel = tabD.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    String sql="";
    if(valor6.equals("Diplomado")){
        sql="select uno,dos,tres,cuatro from evaluardi where gest='"+valor+"' AND cD='"+valor2+"' AND mat='"+valor3+"' AND uT='"+valor4+"' AND act='"+valor5+"' AND nom='"+valor6+"'";
    }
    if(valor6.equals("Maestría")){
        sql="select uno,dos,tres,cuatro from evaluarma where gest='"+valor+"' AND cD='"+valor2+"' AND mat='"+valor3+"' AND uT='"+valor4+"' AND act='"+valor5+"' AND nom='"+valor6+"'";
    }
    if(valor6.equals("Doctorado")){
        sql="select uno,dos,tres,cuatro from evaluardo where gest='"+valor+"' AND cD='"+valor2+"' AND mat='"+valor3+"' AND uT='"+valor4+"' AND act='"+valor5+"' AND nom='"+valor6+"'";
    }


 
    Object []datos = new Object [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getBigDecimal(1); 
                datos[1]=rs.getBigDecimal(2);      
                datos[2]=rs.getBigDecimal(3);
                datos[3]=rs.getBigDecimal(4);
                modelo.addRow(datos);
            }
            tabD.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(EvaluarD.class.getName()).log(Level.SEVERE, null, ex);
        }
        modificar.setEnabled(true);
    
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
        grafic = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabD = new javax.swing.JTable();

        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EVALUAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Conoce y Desarrolla las Nuevas Teorías:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Emplea Estrategias de Aprendizaje Significativo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Promueve Actitudes de Compromiso y Solidaridad:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Establece y Cumple Normas de Comportamiento:");

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

        jLabel5.setText("(número decimales del 0 - 25)");

        jLabel6.setText("(número decimales del 0 - 25)");

        jLabel7.setText("(número decimales del 0 - 25)");

        jLabel8.setText("(número decimales del 0 - 25)");

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

        javax.swing.GroupLayout graficLayout = new javax.swing.GroupLayout(grafic);
        grafic.setLayout(graficLayout);
        graficLayout.setHorizontalGroup(
            graficLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        graficLayout.setVerticalGroup(
            graficLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grafic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botAct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(botAct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(grafic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabD.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void mostrardatos2(String valor,String valor2,String valor3,String valor4,String valor5,String valor6){
    MiModelo modelo= new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("TELÉFONO");
    modelo.addColumn("EMAIL");
    modelo.addColumn("<html>MATERIA<br>O MÓDULO</html>");
    modelo.addColumn("<html>UNIDAD<br>TEMÁTICA</html>");
    modelo.addColumn("ACTIVIDAD");
    modelo.addColumn("FECHA INICIO");
    modelo.addColumn("FECHA FINAL");
    modelo.addColumn("<html>%<br>CUMPLIDO</html>");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("NOMINACIÓN");
    tabD.setModel(modelo);  
    TableColumnModel columnModel = tabD.getColumnModel();
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
    if(valor6.equals("Diplomado"))
    {
     sql="SELECT institucional.gest,diplomado.codDoc,diplomado.grado,diplomado.apellidos,diplomado.nombres,diplomado.telefono,diplomado.email,diplomado.materia,diplomado.unidadTematica,diplomado.actividad,diplomado.fechaInicio,diplomado.fechaFin,diplomado.cumplimiento,diplomado.evaluacion,institucional.nomi FROM diplomado,institucional WHERE diplomado.gestion=institucional.gest AND diplomado.nominacion=institucional.nomi AND diplomado.gestion='"+valor+"' AND diplomado.codDoc='"+valor2+"' AND diplomado.materia='"+valor3+"' AND diplomado.unidadtematica='"+valor4+"' AND diplomado.actividad='"+valor5+"' AND diplomado.nominacion='"+valor6+"' ORDER BY diplomado.apellidos, diplomado.nombres";
    }
    if(valor6.equals("Maestría")){
     sql="SELECT institucional.gest,maestria.codDoc,maestria.grado,maestria.apellidos,maestria.nombres,maestria.telefono,maestria.email,maestria.materia,maestria.unidadTematica,maestria.actividad,maestria.fechaInicio,maestria.fechaFin,maestria.cumplimiento,maestria.evaluacion,institucional.nomi FROM maestria,institucional WHERE maestria.gestion=institucional.gest AND maestria.nominacion=institucional.nomi AND maestria.gestion='"+valor+"' AND maestria.codDoc='"+valor2+"' AND maestria.materia='"+valor3+"' AND maestria.unidadtematica='"+valor4+"' AND maestria.actividad='"+valor5+"' AND maestria.nominacion='"+valor6+"' ORDER BY maestria.apellidos, maestria.nombres";
    }
    if(valor6.equals("Doctorado")){
     sql="SELECT institucional.gest,doctorado.codDoc,doctorado.grado,doctorado.apellidos,doctorado.nombres,doctorado.telefono,doctorado.email,doctorado.materia,doctorado.unidadTematica,doctorado.actividad,doctorado.fechaInicio,doctorado.fechaFin,doctorado.cumplimiento,doctorado.evaluacion,institucional.nomi FROM doctorado,institucional WHERE doctorado.gestion=institucional.gest AND doctorado.nominacion=institucional.nomi AND doctorado.gestion='"+valor+"' AND doctorado.codDoc='"+valor2+"' AND doctorado.materia='"+valor3+"' AND doctorado.unidadtematica='"+valor4+"' AND doctorado.actividad='"+valor5+"' AND doctorado.nominacion='"+valor6+"' ORDER BY doctorado.apellidos, doctorado.nombres";
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
            tabD.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Diplomado.class.getName()).log(Level.SEVERE, null, ex);
        }
        modificar.setEnabled(false);
    }
    
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!(uno.getText().equals(""))&&!(dos.getText().equals(""))&&!(tres.getText().equals(""))&&!(cuatro.getText().equals(""))){
            Double aux1= Double.parseDouble(uno.getText());
            Double aux2= Double.parseDouble(dos.getText());
            Double aux3= Double.parseDouble(tres.getText());
            Double aux4= Double.parseDouble(cuatro.getText());
            Double aux5=aux1+aux2+aux3+aux4;
            Redondear r=new Redondear();
            aux5=r.rD(aux5);
            if(aux1<0||aux1>25||aux2<0||aux2>25||aux3<0||aux3>25||aux4<0||aux4>25){
                JOptionPane.showMessageDialog(this, "Los Campos de Evaluacion no pueden ser negativos o valer mas de 25","",JOptionPane.WARNING_MESSAGE,icono);
            }
            else{
                BigDecimal aux6= BigDecimal.valueOf(aux1);
                BigDecimal aux7= BigDecimal.valueOf(aux2);
                BigDecimal aux8= BigDecimal.valueOf(aux3);
                BigDecimal aux9= BigDecimal.valueOf(aux4);
                BigDecimal aux10= BigDecimal.valueOf(aux5);
                
                if(nom.equals("Diplomado")){
                    try {
                        if(aux5<100){
                        DefaultPieDataset datos= new DefaultPieDataset();
                        datos.setValue("Conoce y desarrolla nuevas teorias", aux1); 
                        datos.setValue("Emplea Estrategias de Aprendizaje Significativo", aux2); 
                        datos.setValue("Promueve Actitudes de Compromiso y Solidaridad", aux3); 
                        datos.setValue("Establece y Cumple Normas de Comportamiento", aux4);
                        datos.setValue("Valor NULO faltante a 100", 100-aux5);
                        chart= ChartFactory.createPieChart3D("Nota Sobre 100", datos,false, false, false);
                        panel = new ChartPanel(chart);
                        panel.setBounds(5, 10, 590, 240);
                        grafic.add(panel);
                        grafic.repaint();
                    }
                    else{
                    DefaultPieDataset datos= new DefaultPieDataset();
                    datos.setValue("Conoce y desarrolla nuevas teorias", aux1); 
                    datos.setValue("Emplea Estrategias de Aprendizaje Significativo", aux2); 
                    datos.setValue("Promueve Actitudes de Compromiso y Solidaridad", aux3); 
                    datos.setValue("Establece y Cumple Normas de Comportamiento", aux4);
                    chart= ChartFactory.createPieChart3D("Nota Sobre 100", datos,false, false, false);
                    panel = new ChartPanel(chart);
                    panel.setBounds(5, 10, 590, 180);
                    grafic.add(panel);
                    grafic.repaint();
                    }
                    PreparedStatement pst = cn.prepareStatement("UPDATE evaluardi SET uno='"+aux6+"',dos='"+aux7+"',tres='"+aux8+"',cuatro='"+aux9+"' where gest='"+gest+"' AND cD='"+cD+"' AND mat='"+m+"' AND uT='"+uT+"' AND act='"+act+"' AND nom='"+nom+"'");
                    pst.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                 try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE diplomado SET evaluacion='"+aux10+"' WHERE gestion='"+gest+"' AND codDoc='"+cD+"' AND materia='"+m+"' AND unidadtematica='"+uT+"' AND actividad='"+act+"' AND nominacion='"+nom+"'");
                        pst.executeUpdate();
                        botAct.setEnabled(true);
                        mostrardatos(gest,cD,m,uT,act,nom);
                        JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton ACTUALIZAR para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                    } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    }
                }
                if(nom.equals("Maestría")){
                    try {
                         if(aux5<100){
                        DefaultPieDataset datos= new DefaultPieDataset();
                        datos.setValue("Conoce y desarrolla nuevas teorias", aux1); 
                        datos.setValue("Emplea Estrategias de Aprendizaje Significativo", aux2); 
                        datos.setValue("Promueve Actitudes de Compromiso y Solidaridad", aux3); 
                        datos.setValue("Establece y Cumple Normas de Comportamiento", aux4);
                        datos.setValue("Valor NULO faltante a 100", 100-aux5);
                        chart= ChartFactory.createPieChart3D("Nota Sobre 100", datos,false, false, false);
                        panel = new ChartPanel(chart);
                        panel.setBounds(5, 10, 590, 180);
                        grafic.add(panel);
                        grafic.repaint();
                    }
                    else{
                        DefaultPieDataset datos= new DefaultPieDataset();
                        datos.setValue("Conoce y desarrolla nuevas teorias", aux1); 
                        datos.setValue("Emplea Estrategias de Aprendizaje Significativo", aux2); 
                        datos.setValue("Promueve Actitudes de Compromiso y Solidaridad", aux3); 
                        datos.setValue("Establece y Cumple Normas de Comportamiento", aux4);
                        chart= ChartFactory.createPieChart3D("Nota Sobre 100", datos,false, false, false);
                        panel = new ChartPanel(chart);
                        panel.setBounds(5, 10, 590, 180);
                        grafic.add(panel);
                        grafic.repaint();
                    }
                    PreparedStatement pst = cn.prepareStatement("UPDATE evaluarma SET uno='"+aux6+"',dos='"+aux7+"',tres='"+aux8+"',cuatro='"+aux9+"' where gest='"+gest+"' AND cD='"+cD+"' AND mat='"+m+"' AND uT='"+uT+"' AND act='"+act+"' AND nom='"+nom+"'");
                    pst.executeUpdate();         
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                 try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE maestria SET evaluacion='"+aux10+"' WHERE gestion='"+gest+"' AND codDoc='"+cD+"' AND materia='"+m+"' AND unidadtematica='"+uT+"' AND actividad='"+act+"' AND nominacion='"+nom+"'");
                        pst.executeUpdate();
                        botAct.setEnabled(true);
                        mostrardatos(gest,cD,m,uT,act,nom);
                        JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton ACTUALIZAR para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                    } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    }
                }
                if(nom.equals("Doctorado")){
                    try {
                         if(aux5<100){
                        DefaultPieDataset datos= new DefaultPieDataset();
                        datos.setValue("Conoce y desarrolla nuevas teorias", aux1); 
                        datos.setValue("Emplea Estrategias de Aprendizaje Significativo", aux2); 
                        datos.setValue("Promueve Actitudes de Compromiso y Solidaridad", aux3); 
                        datos.setValue("Establece y Cumple Normas de Comportamiento", aux4);
                        datos.setValue("Valor NULO faltante a 100", 100-aux5);
                        chart= ChartFactory.createPieChart3D("Nota Sobre 100", datos,false, false, false);
                        panel = new ChartPanel(chart);
                        panel.setBounds(5, 10, 590, 180);
                        grafic.add(panel);
                        grafic.repaint();
                    }
                    else{
                        DefaultPieDataset datos= new DefaultPieDataset();
                        datos.setValue("Conoce y desarrolla nuevas teorias", aux1); 
                        datos.setValue("Emplea Estrategias de Aprendizaje Significativo", aux2); 
                        datos.setValue("Promueve Actitudes de Compromiso y Solidaridad", aux3); 
                        datos.setValue("Establece y Cumple Normas de Comportamiento", aux4);
                        chart= ChartFactory.createPieChart3D("Nota Sobre 100", datos,false, false, false);
                        panel = new ChartPanel(chart);
                        panel.setBounds(5, 10, 590, 180);
                        grafic.add(panel);
                        grafic.repaint();
                    }
                    PreparedStatement pst = cn.prepareStatement("UPDATE evaluardo SET uno='"+aux6+"',dos='"+aux7+"',tres='"+aux8+"',cuatro='"+aux9+"' where gest='"+gest+"' AND cD='"+cD+"' AND mat='"+m+"' AND uT='"+uT+"' AND act='"+act+"' AND nom='"+nom+"'");
                    pst.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                 try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE doctorado SET evaluacion='"+aux10+"' WHERE gestion='"+gest+"' AND codDoc='"+cD+"' AND materia='"+m+"' AND unidadtematica='"+uT+"' AND actividad='"+act+"' AND nominacion='"+nom+"'");
                        pst.executeUpdate();
                        botAct.setEnabled(true);
                        mostrardatos(gest,cD,m,uT,act,nom);
                        JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton ACTUALIZAR para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                    } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, "Operación Incorrecta, NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    }
                }
                

            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación Incorrecta, Los Campos de Evaluacion no pueden estar vacios","",JOptionPane.WARNING_MESSAGE,icono);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botActActionPerformed
        mostrardatos2(gest,cD,m,uT,act,nom);
        botAct.setEnabled(false);
        grafic.removeAll();
        grafic.repaint();
    }//GEN-LAST:event_botActActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int fila=tabD.getSelectedRow();
        if(fila>=0){
            uno.setText(tabD.getValueAt(fila, 0).toString());
            dos.setText(tabD.getValueAt(fila, 1).toString());
            tres.setText(tabD.getValueAt(fila, 2).toString());
            cuatro.setText(tabD.getValueAt(fila, 3).toString());
        }
        else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAct;
    private javax.swing.JTextField cuatro;
    private javax.swing.JTextField dos;
    private javax.swing.JPanel grafic;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTable tabD;
    private javax.swing.JTextField tres;
    private javax.swing.JTextField uno;
    // End of variables declaration//GEN-END:variables
Conexion2 cc= new Conexion2();
Connection cn= cc.conexion();
}
