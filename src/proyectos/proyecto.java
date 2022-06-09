/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.math.BigDecimal;
import java.sql.*;
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
import text.MiModelo;
import text.MyRen2;
import text.Redondear;
import text.Abrir;
import text.Control;
import text.Report;
import text.Report3;
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
public class proyecto extends javax.swing.JFrame {
private Advertencia icono;
private BotConsul icono1;
private BotTodos icono2;
private BotInsertar icono3;
private BotAct icono4;
private Bien2 icono5;
    public proyecto() {
        initComponents();
         nom.addItem("POA");
        nom.addItem("PEI");
        nom.addItem("ACREDITACIÓN");
        nom.addItem("IDH");
        this.setTitle("UNIDAD DE PROYECTOS");
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(0, 0);
        this.setMinimumSize(new Dimension(ancho, alto-50));
        this.setMaximumSize(new Dimension(ancho, alto-20));
        tabP.getTableHeader().setPreferredSize(new Dimension(20,60));
        tabP.getTableHeader().setFont(new Font("Lucida Grande", 1, 8));
        tabP.setRowHeight(290);
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
        botcon5.setIcon(icono1);
        botA.setIcon(icono4);
        botA.setToolTipText("<html>Solo se Actualizan<br>los Datos Mostrados</html>");
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
        this.setVisible(true);       
    }
    public void evaluacionF(String aux1,String aux2,String aux5,String aux6){
    ArrayList<BigDecimal> pro= new ArrayList<BigDecimal>();
    ArrayList<BigDecimal> act= new ArrayList<BigDecimal>();
    int aux3=0;
    int aux4=0;
    double suma1=0.0;
    double suma2=0.0;
    double res1=0.0;
    double res2=0.0;
    double resF=0.0;
    String sql1="";
    String sql2="";
    String sql3="";
    String sql4="";
    
                sql1= "select count(*) from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
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
            
               sql2= "select evaluacionF from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql2);
                while(rs1.next()){
                pro.add(rs1.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
                sql3= "select count(*) from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                while(rs2.next()){
                aux4=rs2.getInt(1);
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
              sql4= "select evaluacionF from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st3 = cn.createStatement();
            ResultSet rs3 = st3.executeQuery(sql4);
                while(rs3.next()){
                act.add(rs3.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
            for(int x=0;x<pro.size();x++) {
             suma1=suma1+(pro.get(x)).doubleValue();
            }
            for(int y=0;y<pro.size();y++) {
             suma2=suma2+(act.get(y)).doubleValue();
            }
            if(aux3==0){
            aux3=1;
            }
            if(aux4==0){
            aux4=1;
            }
            res1=suma1/aux3;
            res2=suma2/aux4;
            resF=(res1+res2)/2;
            Redondear d=new Redondear();
            resF=d.rD(resF);
            try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE proyecto SET evaluacionF='"+resF+"' where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'");
                        pst.executeUpdate();
           } catch (Exception e) {
             System.out.println(e.getMessage());
           }
            pro.clear();
            act.clear();
    }
    public void evaluarMPT(String aux1,String aux2,String aux5,String aux6){
    ArrayList<BigDecimal> pro= new ArrayList<BigDecimal>();
    ArrayList<BigDecimal> act= new ArrayList<BigDecimal>();
    int aux3=0;
    int aux4=0;
    double suma1=0.0;
    double suma2=0.0;
    double res1=0.0;
    double res2=0.0;
    double resF=0.0;
    String sql1="";
    String sql2="";
    String sql3="";
    String sql4="";
    
                sql1= "select count(*) from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
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
            
               sql2= "select mPT from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql2);
                while(rs1.next()){
                pro.add(rs1.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
                sql3= "select count(*) from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                while(rs2.next()){
                aux4=rs2.getInt(1);
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
              sql4= "select mPT from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st3 = cn.createStatement();
            ResultSet rs3 = st3.executeQuery(sql4);
                while(rs3.next()){
                act.add(rs3.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
            for(int x=0;x<pro.size();x++) {
             suma1=suma1+(pro.get(x)).doubleValue();
            }
            for(int y=0;y<act.size();y++) {
             suma2=suma2+(act.get(y)).doubleValue();
            }
            if(aux3==0){
            aux3=1;
            }
            if(aux4==0){
            aux4=1;
            }
            res1=suma1/aux3;
            res2=suma2/aux4;
            resF=(res1+res2)/2;
            Redondear d=new Redondear();
            resF=d.rD(resF);
            try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE proyecto SET mPT='"+resF+"' where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'");
                        pst.executeUpdate();
           } catch (Exception e) {
             System.out.println(e.getMessage());
           }
            pro.clear();
            act.clear();
    }
    public void evaluarMST(String aux1,String aux2,String aux5,String aux6){
    ArrayList<BigDecimal> pro= new ArrayList<BigDecimal>();
    ArrayList<BigDecimal> act= new ArrayList<BigDecimal>();
    int aux3=0;
    int aux4=0;
    double suma1=0.0;
    double suma2=0.0;
    double res1=0.0;
    double res2=0.0;
    double resF=0.0;
    String sql1="";
    String sql2="";
    String sql3="";
    String sql4="";
    
                sql1= "select count(*) from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
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
            
               sql2= "select mST from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql2);
                while(rs1.next()){
                pro.add(rs1.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
                sql3= "select count(*) from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                while(rs2.next()){
                aux4=rs2.getInt(1);
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
              sql4= "select mST from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st3 = cn.createStatement();
            ResultSet rs3 = st3.executeQuery(sql4);
                while(rs3.next()){
                act.add(rs3.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
            for(int x=0;x<pro.size();x++) {
             suma1=suma1+(pro.get(x)).doubleValue();
            }
            for(int y=0;y<pro.size();y++) {
             suma2=suma2+(act.get(y)).doubleValue();
            }
            if(aux3==0){
            aux3=1;
            }
            if(aux4==0){
            aux4=1;
            }
            res1=suma1/aux3;
            res2=suma2/aux4;
            resF=(res1+res2)/2;
            Redondear d=new Redondear();
            resF=d.rD(resF);
            try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE proyecto SET mST='"+resF+"' where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'");
                        pst.executeUpdate();
           } catch (Exception e) {
             System.out.println(e.getMessage());
           }
            pro.clear();
            act.clear();
    }
    public void evaluarMTT(String aux1,String aux2,String aux5,String aux6){
    ArrayList<BigDecimal> pro= new ArrayList<BigDecimal>();
    ArrayList<BigDecimal> act= new ArrayList<BigDecimal>();
    int aux3=0;
    int aux4=0;
    double suma1=0.0;
    double suma2=0.0;
    double res1=0.0;
    double res2=0.0;
    double resF=0.0;
    String sql1="";
    String sql2="";
    String sql3="";
    String sql4="";
    
                sql1= "select count(*) from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
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
            
               sql2= "select mTT from producto where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql2);
                while(rs1.next()){
                pro.add(rs1.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
                sql3= "select count(*) from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                while(rs2.next()){
                aux4=rs2.getInt(1);
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
              sql4= "select mTT from actividad where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'";
            try {
            Statement st3 = cn.createStatement();
            ResultSet rs3 = st3.executeQuery(sql4);
                while(rs3.next()){
                act.add(rs3.getBigDecimal(1));
                }
            }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
            for(int x=0;x<pro.size();x++) {
             suma1=suma1+(pro.get(x)).doubleValue();
            }
            for(int y=0;y<pro.size();y++) {
             suma2=suma2+(act.get(y)).doubleValue();
            }
            if(aux3==0){
            aux3=1;
            }
            if(aux4==0){
            aux4=1;
            }
            res1=suma1/aux3;
            res2=suma2/aux4;
            resF=(res1+res2)/2;
            Redondear d=new Redondear();
            resF=d.rD(resF);
            try {
                        PreparedStatement pst = cn.prepareStatement("UPDATE proyecto SET mTT='"+resF+"' where gestion='"+aux1+"' AND codP='"+aux2+"' AND responsable='"+aux5+"' AND nominacion='"+aux6+"'");
                        pst.executeUpdate();
           } catch (Exception e) {
             System.out.println(e.getMessage());
           }
            pro.clear();
            act.clear();
    }
  public void mostrardatos(String valor,String valor2){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
    if(valor.equals("")&& valor2.equals(""))
    {
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion ORDER BY proyecto.codP, institucional.gestion";
    }
    else{
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.gestion='"+valor+"' AND proyecto.nominacion='"+valor2+"' ORDER BY proyecto.codP, institucional.gestion";
    }
 
    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
  
   public void mostrardatos8(String valor,String valor2,String valor3,String valor4){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.gestion='"+valor+"' AND proyecto.codP='"+valor2+"' AND proyecto.responsable='"+valor3+"' AND proyecto.nominacion='"+valor4+"' ORDER BY proyecto.codP, institucional.gestion";

    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
    public void mostrardatos9(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.gestion='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";

    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabP = new javax.swing.JTable();
        customPanel1 = new text.CustomPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cCP = new javax.swing.JTextField();
        cP = new javax.swing.JTextField();
        botcon = new javax.swing.JButton();
        botcon1 = new javax.swing.JButton();
        botcon2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cPF = new com.toedter.calendar.JDateChooser();
        cPG = new javax.swing.JTextField();
        botcon4 = new javax.swing.JButton();
        botcon3 = new javax.swing.JButton();
        botA = new javax.swing.JButton();
        nom = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cPG2 = new javax.swing.JTextField();
        nom2 = new javax.swing.JComboBox<>();
        botcon5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem8.setText("INSERTAR");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

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

        jMenuItem9.setText("ABRIR RECURSO");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem9);

        jMenuItem7.setText("Ver Actividades");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 704));

        tabP.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tabP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabP.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabP);

        customPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROYECTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        customPanel1.setOpaque(false);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Consultar por Nominacion:");
        jLabel5.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("Consultar por nombre del Responsable:");
        jLabel21.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Consultar por el Código del Proyecto:");
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

        botcon2.setBackground(new java.awt.Color(0, 72, 225));
        botcon2.setForeground(new java.awt.Color(255, 255, 255));
        botcon2.setText("Consultar");
        botcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Consultar por Gestión:");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Consultar por Fecha Final:");
        jLabel3.setOpaque(true);

        botcon4.setBackground(new java.awt.Color(0, 72, 225));
        botcon4.setForeground(new java.awt.Color(255, 255, 255));
        botcon4.setText("Consultar");
        botcon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon4ActionPerformed(evt);
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

        botA.setBackground(new java.awt.Color(0, 72, 225));
        botA.setForeground(new java.awt.Color(255, 255, 255));
        botA.setText("ACTUALIZAR");
        botA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Consultar por Gestión y Nominación:");
        jLabel4.setOpaque(true);

        nom2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POA", "PEI", "ACREDITACIÓN", "IDH" }));

        botcon5.setBackground(new java.awt.Color(0, 72, 225));
        botcon5.setForeground(new java.awt.Color(255, 255, 255));
        botcon5.setText("Consultar");
        botcon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcon5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCP, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon2))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cP, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon1))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botcon4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(botcon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botA)
                        .addGap(38, 38, 38))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(cPG2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botcon5)))
                .addContainerGap())
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botcon)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cPG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botcon1)
                        .addComponent(jLabel3))
                    .addComponent(botcon3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon2)
                    .addComponent(jLabel2)
                    .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botcon4)
                    .addComponent(botA))
                .addGap(3, 3, 3))
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
                    .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setVisible(false);
        Institucional i =new Institucional();
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
         int fila= tabP.getSelectedRow();
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
        if(fila>= 0){
                     aux1=tabP.getValueAt(fila, 0).toString();
                     aux2=tabP.getValueAt(fila, 1).toString();
                     aux3=tabP.getValueAt(fila, 2).toString();
                     aux4=tabP.getValueAt(fila, 3).toString();
                     aux5=tabP.getValueAt(fila, 4).toString();
                     aux6=tabP.getValueAt(fila, 5).toString();
                     aux7=tabP.getValueAt(fila, 6).toString();
                     aux8=tabP.getValueAt(fila, 7).toString();
                     aux9=tabP.getValueAt(fila, 12).toString();
                     aux10=tabP.getValueAt(fila, 13).toString();
                     aux11=tabP.getValueAt(fila, 14).toString();
                     aux12=tabP.getValueAt(fila, 15).toString();
                     mP m=new mP(new java.awt.Frame(), true);
                     m.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12);
                     m.setVisible(true);
                     mostrardatos8(m.getgest(),m.getcodPro(),m.getres(),m.getnom());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int fila= tabP.getSelectedRow();
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
        if(fila>= 0){
                    JOptionPane.showMessageDialog(null, "Al Eliminar un Proyecto se eliminan todos las Actividades y a su ves los Productos, Dependientes de este","",JOptionPane.WARNING_MESSAGE,icono);
                     aux1=tabP.getValueAt(fila, 0).toString();
                     aux2=tabP.getValueAt(fila, 1).toString();
                     aux3=tabP.getValueAt(fila, 2).toString();
                     aux4=tabP.getValueAt(fila, 3).toString();
                     aux5=tabP.getValueAt(fila, 4).toString();
                     aux6=tabP.getValueAt(fila, 5).toString();
                     aux7=tabP.getValueAt(fila, 6).toString();
                     aux8=tabP.getValueAt(fila, 7).toString();
                     aux9=tabP.getValueAt(fila, 12).toString();
                     aux10=tabP.getValueAt(fila, 13).toString();
                     aux11=tabP.getValueAt(fila, 14).toString();
                     aux12=tabP.getValueAt(fila, 15).toString();
                     eP e=new eP(new java.awt.Frame(), true);
                     e.llenardatos(aux1,aux2,aux3,aux4,aux5,aux6,aux7,aux8,aux9,aux10,aux11,aux12);
                     e.setVisible(true);
                     mostrardatos8(e.getgest(),e.getcodPro(),e.getres(),e.getnom());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int fila= tabP.getSelectedRow();
        if(fila>= 0){
                     this.setVisible(false);
                     Actividades a= new Actividades();
                     a.mostrardatos(tabP.getValueAt(fila, 0).toString(),tabP.getValueAt(fila, 1).toString(),tabP.getValueAt(fila, 6).toString(),tabP.getValueAt(fila, 15).toString()); 
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        int fila= tabP.getSelectedRow();
         Calendar calendario = GregorianCalendar.getInstance();
         calendario.add(Calendar.DAY_OF_YEAR,1);
        Date fecha1 = calendario.getTime();
        SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
         String aux1="";
         String aux2="";
         String aux3="";
        if(fila>= 0){
                     aux1=tabP.getValueAt(fila, 0).toString();
                     aux2=tabP.getValueAt(fila, 6).toString();
                     aux3=tabP.getValueAt(fila, 15).toString();
                     iP i=new iP(new java.awt.Frame(), true);
                     i.llenardatos(aux1,formato.format(fecha1),formato.format(fecha1),"0",aux2,"0","NO","NO",aux3);
                     i.setVisible(true);
                     mostrardatos8(i.getgest(),i.getcodPro(),i.getres(),i.getnom());
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
         int fila= tabP.getSelectedRow();
         String sep = System.getProperty("line.separator");
        if(fila>= 0){
                     String sql="";
                     String aux="";
                     Abrir a=new Abrir();
                                   sql= "select recurso from proyecto WHERE gestion='"+tabP.getValueAt(fila, 0).toString()+"' AND codP='"+tabP.getValueAt(fila, 1).toString()+"' AND responsable='"+tabP.getValueAt(fila, 6).toString()+"' AND nominacion='"+tabP.getValueAt(fila, 15).toString()+"'";
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            aux=rs.getString(1);
            }
            }
            catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
                     a.launchFile("\\\\167.157.17.39\\proyectos\\"+aux+"");
        }else{
        JOptionPane.showMessageDialog(null, "No selecciono una fila","",JOptionPane.WARNING_MESSAGE,icono);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
          Report3 r=new Report3(new java.awt.Frame(), true,this.cn,"RProyecto.jasper");
          r.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void botconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botconActionPerformed
        mostrardatos3(nom.getSelectedItem().toString());
        cP.setText("");
        cCP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botconActionPerformed

    private void botcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon1ActionPerformed
        mostrardatos2(cP.getText().toString());
        cCP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon1ActionPerformed

    private void botcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon2ActionPerformed
        mostrardatos4(cCP.getText());
        cP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon2ActionPerformed

    private void botcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon4ActionPerformed
        mostrardatos6(cPG.getText());
        cP.setText("");
        cCP.setText("");
    }//GEN-LAST:event_botcon4ActionPerformed

    private void botcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon3ActionPerformed
        Date fecha1= cPF.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        mostrardatos5(formato.format(fecha1));
        cP.setText("");
        cCP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon3ActionPerformed

    private void botAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAActionPerformed
        //mostrardatos("","");
        cP.setText("");
        cCP.setText("");
        cPG.setText("");
        cPG2.setText("");
        JOptionPane.showMessageDialog(null,"EXITO!! AL GUARDAR O ACTUALIZAR LOS DATOS MOSTRADOS","",JOptionPane.WARNING_MESSAGE,icono5);
    }//GEN-LAST:event_botAActionPerformed

    private void botcon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcon5ActionPerformed
        mostrardatos7(cPG2.getText(),nom2.getSelectedItem().toString());
        cP.setText("");
        cCP.setText("");
        cPG.setText("");
    }//GEN-LAST:event_botcon5ActionPerformed
 void mostrardatos2(String valor){
   MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.responsable='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
    
    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 void mostrardatos3(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND institucional.nominacion='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
     
    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
    void mostrardatos4(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.codP='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
     
    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
    void mostrardatos5(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND proyecto.fechaF<='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
     
    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
    void mostrardatos6(String valor){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND institucional.gestion='"+valor+"' ORDER BY proyecto.codP, institucional.gestion";
     
    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
    public void mostrardatos7(String valor,String valor2){
    MiModelo modelo = new MiModelo();
    modelo.addColumn("GESTIÓN");
    modelo.addColumn("<html>CÓDIGO<br>PROYECTO</html>");
    modelo.addColumn("PROYECTO");
    modelo.addColumn("<html>FECHA DE<br>INICIO</html>");
    modelo.addColumn("<html>FECHA<br>FINAL</html>");
    modelo.addColumn("MONTO");
    modelo.addColumn("RESPONSABLE");
    modelo.addColumn("<html>% DE CUM-<br>PLIMIENTO</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>PRIMER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>SEGUNDO TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>TERCER TRIMESTRE</html>");
    modelo.addColumn("<html>PRESENTACIÓN<br>FINAL</html>");
    modelo.addColumn("<html>CONTINUA<br>DE GESTIÓN</html>");
    modelo.addColumn("<html>CUMPLIDO<br>EN TIEMPO</html>");
    modelo.addColumn("RECOMENDACIONES");
    modelo.addColumn("NOMINACIÓN");
    tabP.setModel(modelo);
    TableColumnModel columnModel = tabP.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(1).setPreferredWidth(80);
    columnModel.getColumn(1).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(2).setPreferredWidth(130);
    columnModel.getColumn(2).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(3).setPreferredWidth(90);
    columnModel.getColumn(3).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(4).setPreferredWidth(90);
    columnModel.getColumn(4).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(5).setPreferredWidth(120);
    columnModel.getColumn(5).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(6).setPreferredWidth(130);
    columnModel.getColumn(6).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(7).setPreferredWidth(70);
    columnModel.getColumn(7).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(8).setPreferredWidth(80);
    columnModel.getColumn(8).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(9).setPreferredWidth(80);
    columnModel.getColumn(9).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(10).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(11).setPreferredWidth(80);
    columnModel.getColumn(11).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(12).setPreferredWidth(70);
    columnModel.getColumn(12).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(13).setPreferredWidth(70);
    columnModel.getColumn(13).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(14).setPreferredWidth(160);
    columnModel.getColumn(14).setCellRenderer(new MyRen2(4,7));
    columnModel.getColumn(15).setPreferredWidth(110);
    columnModel.getColumn(15).setCellRenderer(new MyRen2(4,7));
    String sql="";
        sql="SELECT institucional.gestion,proyecto.codP,proyecto.nombreP,proyecto.fechaI,proyecto.fechaF,proyecto.monto,proyecto.responsable,proyecto.cump,proyecto.mPT,proyecto.mST,proyecto.mTT,proyecto.evaluacionF,proyecto.contoNO,proyecto.cET,proyecto.recomendacion,institucional.nominacion FROM proyecto,institucional WHERE proyecto.gestion=institucional.gestion AND proyecto.nominacion=institucional.nominacion AND institucional.gestion='"+valor+"' AND institucional.nominacion='"+valor2+"' ORDER BY proyecto.codP, institucional.gestion";
     
    Object []datos = new Object [17];
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                datos[0]=rs.getString(1);      
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                Date fecha1= rs.getDate(4);
                Date fecha2= rs.getDate(5);
                SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
                datos[3]=formato.format(fecha1);
                datos[4]=formato.format(fecha2);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getBigDecimal(8);
                datos[8]=rs.getBigDecimal(9);
                datos[9]=rs.getBigDecimal(10);
                datos[10]=rs.getBigDecimal(11);
                datos[11]=rs.getBigDecimal(12);
                datos[12]=rs.getString(13);
                datos[13]=rs.getString(14);
                datos[14]=rs.getString(15);
                datos[15]=rs.getString(16);
                modelo.addRow(datos);
            }
            tabP.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botA;
    private javax.swing.JButton botcon;
    private javax.swing.JButton botcon1;
    private javax.swing.JButton botcon2;
    private javax.swing.JButton botcon3;
    private javax.swing.JButton botcon4;
    private javax.swing.JButton botcon5;
    private javax.swing.JTextField cCP;
    private javax.swing.JTextField cP;
    private com.toedter.calendar.JDateChooser cPF;
    private javax.swing.JTextField cPG;
    private javax.swing.JTextField cPG2;
    private text.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
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
    private javax.swing.JComboBox<String> nom;
    private javax.swing.JComboBox<String> nom2;
    private javax.swing.JTable tabP;
    // End of variables declaration//GEN-END:variables
Conexion5 cc= new Conexion5();
Connection cn= cc.conexion();
}
