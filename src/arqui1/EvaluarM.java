/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import text.MiModelo;
import text.MyRen;
import text.Redondear;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class EvaluarM extends javax.swing.JDialog {
private int contador1;
private String cM;
private String ges;
private String cD;
private String cC;
private Advertencia icono;
private Bien icono2;
private ChartPanel panel;
private JFreeChart chart = null;
    public EvaluarM(java.awt.Frame parent, boolean modal, String cM,String ges,String cD,String cC) {
        super(parent, modal);
        initComponents();
        contador1=1;
        this.cM=cM;
        this.ges=ges;
        this.cD=cD;
        this.cC=cC;
        this.setTitle("EVALUAR DOCENTE");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2=new Bien();
        tabMat.getTableHeader().setPreferredSize(new Dimension(10,30));
        tabMat.getTableHeader().setFont(new Font("Lucida Grande", 1, 10));
        tabMat.setRowHeight(100);
        botAct.setEnabled(false);
           try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public String getcm(){
    return cM;
    }
     public String getges(){
    return ges;
    }
      public String getcd(){
    return cD;
    }
       public String getcc(){
    return cC;
    }
    public void mostrardatos(String valor,String valor2,String valor3,String valor4){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("<html>CONOCE Y DESARROLLA<br>NUEVAS TEORÍAS</html>");
    modelo.addColumn("<html>EMPLEA ESTRATEGIAS DE<br>APRENDIZAJE SIGNIFICATIVO</html>");
    modelo.addColumn("<html>PROMUEVE ACTITUDES DE<br>COMPROMISO Y SOLIDARIDAD</html>");
    modelo.addColumn("<html>ESTABLECE Y CUMPLE<br>NORMAS DE COMPORTAMIENTO</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    String sql="";
  
        sql="select uno,dos,tres,cuatro from evaluar where cM='"+valor+"' AND gest='"+valor2+"' AND cD='"+valor3+"' AND cC='"+valor4+"'";

 
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
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
        modificar.setEnabled(true);
    
    }
    
 
 public void mostrardatos2(String valor,String valor2,String valor3,String valor4){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>MATERIA</html>");
    modelo.addColumn("MATERIA");
    modelo.addColumn("<html>CÓDIGO<br>DOCENTE</html>");
    modelo.addColumn("DOCENTE");
    modelo.addColumn("CARRERA");
    modelo.addColumn("EVALUACIÓN");
    modelo.addColumn("<html>CÓDIGO<br>CARRERA</html>");
    tabMat.setModel(modelo);
    TableColumnModel columnModel = tabMat.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen());
    columnModel.getColumn(1).setPreferredWidth(90);
    columnModel.getColumn(1).setCellRenderer(new MyRen());
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(2).setCellRenderer(new MyRen());
    columnModel.getColumn(3).setPreferredWidth(80);
    columnModel.getColumn(3).setCellRenderer(new MyRen());
    columnModel.getColumn(4).setPreferredWidth(200);
    columnModel.getColumn(4).setCellRenderer(new MyRen());
    columnModel.getColumn(5).setPreferredWidth(190);
    columnModel.getColumn(5).setCellRenderer(new MyRen());
    columnModel.getColumn(6).setPreferredWidth(80);
    columnModel.getColumn(6).setCellRenderer(new MyRen());
    columnModel.getColumn(7).setPreferredWidth(80);
    columnModel.getColumn(7).setCellRenderer(new MyRen());
    String sql="";
  
        sql="SELECT c.gestion,m.codigoMateria,m.nombreMateria,m.codigoDocente,m.grado,m.apellidos,m.nombres,c.nombre,m.eval,c.codigoCarrera FROM materia m,carrera c WHERE m.codCarrera=c.codigoCarrera AND m.gestion=c.gestion AND m.codigoMateria='"+valor+"' AND m.gestion='"+valor2+"' AND m.codigoDocente='"+valor3+"' AND m.codCarrera='"+valor4+"' ORDER BY m.apellidos, m.nombres";

 
    Object []datos = new Object [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2);      
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7);
                datos[5]=rs.getString(8);
                datos[6]=rs.getBigDecimal(9);
                datos[7]=rs.getString(10);
                modelo.addRow(datos);
            }
            tabMat.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
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
        grafic = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMat = new javax.swing.JTable();

        modificar.setText("modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
            .addGap(0, 579, Short.MAX_VALUE)
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grafic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grafic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(31, 31, 31)
                                .addComponent(botAct))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );

        tabMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabMat.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabMat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
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
        int fila=tabMat.getSelectedRow();
        if(fila>=0){
            uno.setText(tabMat.getValueAt(fila, 0).toString());
            dos.setText(tabMat.getValueAt(fila, 1).toString());
            tres.setText(tabMat.getValueAt(fila, 2).toString());
            cuatro.setText(tabMat.getValueAt(fila, 3).toString());
        }
        else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void botActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botActActionPerformed
        mostrardatos2(cM,ges,cD,cC);
        botAct.setEnabled(false);
        grafic.removeAll();
        grafic.repaint();
    }//GEN-LAST:event_botActActionPerformed

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
                        panel.setBounds(5, 10, 570, 220);
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
                    panel.setBounds(5, 10, 510, 160);
                    grafic.add(panel);
                    grafic.repaint();
                    }
                    PreparedStatement pst = cn.prepareStatement("UPDATE evaluar SET uno='"+aux6+"',dos='"+aux7+"',tres='"+aux8+"',cuatro='"+aux9+"' WHERE cM='"+cM+"' AND gest='"+ges+"' AND cD='"+cD+"'AND cC='"+cC+"'");
                    pst.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                 try {
                PreparedStatement pst = cn.prepareStatement("UPDATE materia SET eval='"+aux10+"' WHERE codigoMateria='"+cM+"'AND gestion='"+ges+"' AND codigoDocente='"+cD+"' AND codCarrera='"+cC+"'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton ACTUALIZAR para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                mostrardatos(cM,ges,cD,cC);
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
    private javax.swing.JTable tabMat;
    private javax.swing.JTextField tres;
    private javax.swing.JTextField uno;
    // End of variables declaration//GEN-END:variables
 Conexion1 cc= new Conexion1();
 Connection cn= cc.conexion();
}
