/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import ziconos.Advertencia;
import ziconos.Bien2;
import ziconos.BotAct2;
import ziconos.Construir;
import ziconos.FatalError;

/**
 *
 * @author WildoJ
 */
public class Report2 extends javax.swing.JDialog {
    private Advertencia icono;
    private FatalError icono5;
    private Construir icono2;
    private Bien2 icono3;
    private BotAct2 icono4;
    private Connection c;
    private String ruta;
    public Report2(java.awt.Frame parent, boolean modal,Connection c,String ruta) {      
        super(parent, modal);
        initComponents();
        this.c=c;
        this.ruta=ruta;
        icono=new Advertencia();
        icono2=new Construir();
        icono3=new Bien2();
        icono4=new BotAct2();
        icono5=new FatalError();
         this.setLocationRelativeTo(null);
        this.setResizable(false);
          try{
        this.setIconImage(new ImageIcon(getClass().getResource("/zimagenes/cg.jpg")).getImage());
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cPG = new javax.swing.JTextField();
        botGen = new javax.swing.JButton();
        botCan = new javax.swing.JButton();
        nomi = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(220, 220, 220));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("INGRESE LA GESTIÓN Y NOMINACIÓN PARA EMITIR EL REPORTE:");

        cPG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botGen.setText("GENERAR");
        botGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGenActionPerformed(evt);
            }
        });

        botCan.setText("CANCELAR");
        botCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCanActionPerformed(evt);
            }
        });

        nomi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diplomado", "Maestría", "Doctorado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(botGen, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(botCan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cPG, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(nomi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botGen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGenActionPerformed
        String sep = System.getProperty("line.separator");
        if(cPG.getText().equals("")||(nomi.getSelectedItem().toString()).equals("")){
            JOptionPane.showMessageDialog(null, "NO INGRESO UNA GESTIÓN AUN, INGRESE PORFAVOR ","",JOptionPane.WARNING_MESSAGE,icono);
        }
        else{
            JOptionPane.showMessageDialog(null, "A CONTINUACIÓN ESCOJA LA DIRECCIÓN DONDE SE GUARDARA EL DOCUMENTO .PDF GENERADO Y EL NOMBRE","",JOptionPane.WARNING_MESSAGE,icono4);
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("todos los Archivos *.PDF","pdf","PDF"));
        int seleccion=fileChooser.showSaveDialog(this);
        try{            
          if(seleccion==JFileChooser.APPROVE_OPTION){
            File jfc=fileChooser.getSelectedFile();
            String path=jfc.getAbsolutePath();
            try(PrintWriter printer=new PrintWriter(jfc)){
                printer.print(ruta);
            }

            //jfc.delete();
            
            if(!(path.endsWith(".pdf"))){
                File temp= new File(path+".pdf");
                jfc.renameTo(temp);
                path=path+".pdf";
                if(!(jfc.exists())){
                     JOptionPane.showMessageDialog(null, "ESTAMOS GENERANDO EL DOCUMENTO... ESTO PUEDE TARDAR UNOS SEGUNDOS...","",JOptionPane.WARNING_MESSAGE,icono2);
                    rutaAPDF(path);
                   JOptionPane.showMessageDialog(null, "EL DOCUMENTO FUE GENERADO CON EXITO!!!","",JOptionPane.WARNING_MESSAGE,icono3);
                }
                 else{
                 JOptionPane.showMessageDialog(null, "ERROR, YA EXISTE UN ARCHIVO CON ESE NOMBRE, NO SE GENERO NINGUN DOCUMENTO VALIDO","",JOptionPane.WARNING_MESSAGE,icono);
                 jfc.delete();
                }
          
            }
             else{
                JOptionPane.showMessageDialog(null, "ERROR, NO ES NECESARIO QUE EL NOMBRE TERMINE EN .pdf, O YA EXISTE UN ARCHIVO CON ESE NOMBRE"+sep+"NO SE GENERO NINGUN DOCUMENTO VALIDO!!!","",JOptionPane.WARNING_MESSAGE,icono5);
                }

         }
          
        
        }catch(FileNotFoundException | HeadlessException e){
        JOptionPane.showMessageDialog(null, "ERROR!!! INTERNO AL EXPORTAR EL DOCUMENTO, INTENTE MAS TARDE","",JOptionPane.WARNING_MESSAGE,icono);
        }
        this.setVisible(false);
      }     
    }//GEN-LAST:event_botGenActionPerformed

    private void botCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCanActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botCanActionPerformed

    public void rutaAPDF(String archivo){
        try {
           JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(ruta));
             Map parametro=new HashMap();
             parametro.put("gesti", cPG.getText());
             parametro.put("nominacion", nomi.getSelectedItem().toString());
            JasperPrint print=JasperFillManager.fillReport(reporte, parametro, c);
            JasperExportManager.exportReportToPdfFile(print, archivo);
            JasperViewer ventana= new JasperViewer(print,false);
            ventana.setVisible(false);
        } catch (JRException ex) {
            Logger.getLogger(Report2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR NO SE INGRESO UNA GESTIÓN CORRECTA!!!","",JOptionPane.WARNING_MESSAGE,icono);
        }
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCan;
    private javax.swing.JButton botGen;
    private javax.swing.JTextField cPG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> nomi;
    // End of variables declaration//GEN-END:variables
}
