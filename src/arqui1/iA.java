/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqui1;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import text.Redondear;
import ziconos.Advertencia;
import ziconos.Bien;

/**
 *
 * @author WildoJ
 */
public class iA extends javax.swing.JDialog {
private Advertencia icono;
private Bien icono2;
private int contador1;
    public iA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(gestion);
        SpellChecker.register(codMat);
        SpellChecker.register(codDoc);
        SpellChecker.register(aD);
        SpellChecker.register(nD);
        SpellChecker.register(act);
        SpellChecker.register(uniTem);
        SpellChecker.register(codCarr);
        SpellChecker.register(cUT);
        SpellChecker.register(mat);
        SpellChecker.register(carr);
        grado.addItem("Dr.");
        grado.addItem("Dra.");
        grado.addItem("Msc. Ing.");
        grado.addItem("Ing.");
        grado.addItem("Msc. Arq.");
        grado.addItem("Arq.");
        grado.addItem("Msc. Lic.");
        grado.addItem("Lic.");
        this.setTitle("ACTIVIDAD");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        icono =new Advertencia();
        icono2=new Bien();
        contador1=1;
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }

     public String getgestion(){
    return gestion.getText();
    }
    public String getact(){
    return act.getText();
    }
    public String getcUT(){
    return cUT.getText();
    }
    public String getcodCarr(){
    return codCarr.getText();
    }
    public String getcodMat(){
    return codMat.getText();
    }
    public String getcodDoc(){
    return codDoc.getText();
    }
   public void llenardatos(String aux1, String aux2, String aux3,String aux4, String aux5,String aux6, String aux7,String aux8, String aux9,String aux10,String aux11,String aux12,String aux13,String aux14){
    gestion.setText(aux1);
    codDoc.setText(aux2);
    grado.setSelectedItem(aux3);
    aD.setText(aux4);
    nD.setText(aux5);
    cUT.setText(aux6);
    uniTem.setText(aux7);
    mat.setText(aux8);
    carr.setText(aux9);
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
    try {
        fecIni.setDate(formato.parse(aux10));
    } catch (ParseException ex) {
        Logger.getLogger(iA.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        fecFin.setDate(formato.parse(aux11));
    } catch (ParseException ex) {
        Logger.getLogger(iA.class.getName()).log(Level.SEVERE, null, ex);
    }
    cump.setText(aux12);
    codCarr.setText(aux13);
    codMat.setText(aux14);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        codDoc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        aD = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        nD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        cUT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        uniTem = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        mat = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        carr = new javax.swing.JTextArea();
        fecFin = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        fecIni = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codCarr = new javax.swing.JTextField();
        cump = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gestion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        codMat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 170, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)), "INSERTAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 72, 225));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INSERTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 72, 225));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Código del Docente:");

        codDoc.setEditable(false);
        codDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codDocKeyTyped(evt);
            }
        });

        jLabel12.setText("Grado de Instrucciondel Docente:");

        grado.setEnabled(false);

        jLabel13.setText("Apellidos (Docente):");

        aD.setEditable(false);
        aD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aDKeyTyped(evt);
            }
        });

        jLabel14.setText("Nombres (Docente):");

        nD.setEditable(false);
        nD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nDKeyTyped(evt);
            }
        });

        jLabel2.setText("Actividad:");

        jLabel1.setText("Código de Unidad Temática:");

        act.setColumns(20);
        act.setLineWrap(true);
        act.setRows(5);
        act.setWrapStyleWord(true);
        act.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                actKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                actKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(act);

        cUT.setEditable(false);
        cUT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cUTKeyTyped(evt);
            }
        });

        jLabel3.setText("Unidad Tematica:");

        uniTem.setEditable(false);
        uniTem.setColumns(20);
        uniTem.setLineWrap(true);
        uniTem.setRows(5);
        uniTem.setWrapStyleWord(true);
        uniTem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uniTemKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uniTemKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(uniTem);

        jLabel4.setText("Materia:");

        jLabel6.setText("Carrera:");

        mat.setEditable(false);
        mat.setColumns(20);
        mat.setLineWrap(true);
        mat.setRows(5);
        mat.setWrapStyleWord(true);
        mat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                matKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                matKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(mat);

        carr.setEditable(false);
        carr.setColumns(20);
        carr.setLineWrap(true);
        carr.setRows(5);
        carr.setWrapStyleWord(true);
        carr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                carrKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                carrKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(carr);

        jLabel8.setText("Fecha Final:");

        jLabel7.setText("Fecha de Inicio:");

        jLabel5.setText("Código Carrera:");

        codCarr.setEditable(false);

        cump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cumpKeyTyped(evt);
            }
        });

        jLabel11.setText("% de Cumplimiento :");

        jLabel9.setText("Gestión:");

        gestion.setEditable(false);

        jLabel15.setText("Código de Materia:");

        codMat.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codDoc, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nD, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(grado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 417, Short.MAX_VALUE)
                                    .addComponent(aD, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(codCarr, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(29, 29, 29)
                        .addComponent(codMat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cump, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fecIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecFin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cUT, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane4)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(aD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fecFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cump, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(codCarr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(codMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sep = System.getProperty("line.separator");
        Date fecha2=fecIni.getDate();
        Date fecha3=fecFin.getDate();
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        boolean band =true;
        if(act.getText().equals("")||cUT.getText().equals("")||codMat.getText().equals("")||codCarr.getText().equals("")||cump.getText().equals("")||gestion.getText().equals("")||codDoc.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No ingreso datos Ingrese por favor, actividad, codigo de materia, código Uni Tem, Código carrera, % de Cumplimiento, gestión, codigo del docente no pueden estar vacios","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
                double aux1= Double.parseDouble(cump.getText());
             if(aux1<0||aux1>100){
                JOptionPane.showMessageDialog(this, "el % de cumplimiento no puede ser negativo, o no puede valer mas de 100","",JOptionPane.WARNING_MESSAGE,icono);
             }
             else{
                try {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO actividad(gestion,actividad,cUT,fechaInicio,fechaFin,cumplido,codCarr,codigoMateria,codDoc) VALUES (?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, gestion.getText());
                    pst.setString(2, act.getText());
                    pst.setString(3, cUT.getText());
                    pst.setString(4, formato.format(fecha2));
                    pst.setString(5, formato.format(fecha3));
                    Double aux3= Double.parseDouble(cump.getText());
                    Redondear r=new Redondear();
                    aux3=r.rD(aux3);
                    BigDecimal aux4= BigDecimal.valueOf(aux3);
                    pst.setBigDecimal(6, aux4);  
                    pst.setString(7, codCarr.getText());
                    pst.setString(8, codMat.getText());
                    pst.setString(9, codDoc.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Operación correcta, presione el boton Actualizar para ver los cambios","",JOptionPane.WARNING_MESSAGE,icono2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operación Incorrecta, Actividad, Codigo Unid Tem, codigo de materia, codigo carrera, gestion, codigo del docente duplicados"+sep+"O la cantidad de letras sobrepasa lo permitido para un campo"+sep+"O los campos no coinciden con una unidad tematica valida NO SE REALIZO CAMBIOS","",JOptionPane.WARNING_MESSAGE,icono);
                    band=false;
                }
                
                if(band==true){
                    try {
                        PreparedStatement pst2 = cn.prepareStatement ("DELETE FROM actividad WHERE gestion='"+gestion.getText()+"' AND actividad='"+""+"' AND cUT='"+cUT.getText()+"'AND codCarr='"+codCarr.getText()+"' AND codigoMateria='"+codMat.getText()+"' AND codDoc='"+codDoc.getText()+"'");
                        pst2.executeUpdate();
                       } catch (Exception e) {
                        System.out.println(e.getMessage());
                       }
                }

            this.setVisible(false);
           }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void codDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codDocKeyTyped
        if(codDoc.getText().length()==21){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_codDocKeyTyped

    private void aDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aDKeyTyped
        if(aD.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_aDKeyTyped

    private void nDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nDKeyTyped
        if(nD.getText().length()==40){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nDKeyTyped

    private void actKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyPressed
         char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
        if(tecla== KeyEvent.VK_TAB){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyPressed

    private void uniTemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uniTemKeyPressed
         char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_uniTemKeyPressed

    private void matKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyPressed
         char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_matKeyPressed

    private void carrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carrKeyPressed
         char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_ENTER){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_carrKeyPressed

    private void actKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actKeyTyped
        if(act.getText().length()==150){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_actKeyTyped

    private void uniTemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uniTemKeyTyped
        if(uniTem.getText().length()==99){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_uniTemKeyTyped

    private void matKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matKeyTyped
        if(mat.getText().length()==99){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_matKeyTyped

    private void carrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carrKeyTyped
        if(carr.getText().length()==99){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_carrKeyTyped

    private void cUTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cUTKeyTyped
        if(cUT.getText().length()==21){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cUTKeyTyped

    private void cumpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cumpKeyPressed
        char tecla= evt.getKeyChar();
        if(tecla== KeyEvent.VK_BACK_SPACE){
            if(cump.getText().equals("")){
                contador1=1;
            }
            else{
                contador1=2;
            }

        }
    }//GEN-LAST:event_cumpKeyPressed

    private void cumpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cumpKeyTyped
        char tecla= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        //Este if no permite el ingreso de letras y otros símbolos
        if(cump.getText().contains(".")){
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
            if (cump.getText().equals("")){
                cump.setText("0");
                contador1=2;
            }
            else{
                if(contador1==2){
                    evt.consume();
                }
                else{
                    cump.setText(cump.getText());
                    contador1=2;
                }
            }
        }
        //Esteif no permite el ingreso de "ñ" ," Ñ" ni "/"
        if(k==241 || k==209|| k==47){
            evt.consume();
            getToolkit().beep();
        }

        if(cump.getText().length()==7){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cumpKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aD;
    private javax.swing.JTextArea act;
    private javax.swing.JTextField cUT;
    private javax.swing.JTextArea carr;
    private javax.swing.JTextField codCarr;
    private javax.swing.JTextField codDoc;
    private javax.swing.JTextField codMat;
    private javax.swing.JTextField cump;
    private com.toedter.calendar.JDateChooser fecFin;
    private com.toedter.calendar.JDateChooser fecIni;
    private javax.swing.JTextField gestion;
    private javax.swing.JComboBox grado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea mat;
    private javax.swing.JTextField nD;
    private javax.swing.JTextArea uniTem;
    // End of variables declaration//GEN-END:variables
Conexion1 cc= new Conexion1();
 Connection cn= cc.conexion();
}
