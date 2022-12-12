package view;

import conexion.Conexion;
import controller.Ctr_Citas;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Mdl_Citas;


public class Vst_Citas extends javax.swing.JFrame {

    Mdl_Citas citas = new Mdl_Citas();
    Ctr_Citas ct = new Ctr_Citas();

    public Vst_Citas() {

        initComponents();
    }

    
        public String fechaHoy() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
        
    void enviar() {
        citas.setIdCitas(ct.autoImcremento());        
        citas.setTituloCita(txtTitulo.getText());
        citas.setDescripcionCita(txtDescripcion.getText());
        citas.setFecha_cita(txtFechaC.getText());        
        citas.setHora_cita(txtHora.getText());
        citas.setTipo_cita(cbbTipocita.getSelectedItem().toString());
        citas.setUbicacion_cita(txtUbicacion.getText());
        citas.setZona_horariaCita(txtZonaHoraria.getText());
        citas.setRepeticion_cita(txtRecordatorio.getText());
        citas.setFecha_registroCita(ct.fechaHoy());

        if (RbtPrivado.isSelected()) {
            citas.setVisibilidad_cita("1");
        } else {
            citas.setVisibilidad_cita("0");
        }
        
        
        if (rbtActivo.isSelected()) {
            citas.setEstado_cita("1");
        } else {
            citas.setEstado_cita("0");
        }
        
        ct.Guardar(citas);
    }
    
    void limpiar(){
        
        txtTitulo.setText("");
        txtDescripcion.setText("");
        txtFechaC.setText("");        
        txtHora.setText("");
        cbbTipocita.setSelectedIndex(0);;
        txtUbicacion.setText("");
        txtZonaHoraria.setText("");
        txtRecordatorio.setText("");
    }
    
    void reporte (){
        Conexion con = new Conexion();        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        pnlAgenda = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFechaC = new javax.swing.JTextField();
        lblHora = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        lblTcita = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblVisibilidad = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        lblZonaHoraria = new javax.swing.JLabel();
        txtZonaHoraria = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        RbtPublico = new javax.swing.JRadioButton();
        RbtPrivado = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtRecordatorio = new javax.swing.JTextField();
        rbtActivo = new javax.swing.JRadioButton();
        rbtInactivo = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        cbbTipocita = new javax.swing.JComboBox<>();
        btnVerCitas = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        label1 = new java.awt.Label();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo.setText("TITULO:");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDescripcion.setText("DESCRIPCION:");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFecha.setText("FECHA CITA:");

        txtFechaC.setText("dd/mm/aaa");
        txtFechaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCActionPerformed(evt);
            }
        });

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblHora.setText("HORA  CITA:");

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        lblTcita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTcita.setText("TIPO CITA:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ESTADO:");

        lblVisibilidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVisibilidad.setText("TIPO DE PRIVACIDAD:");

        lblUbicacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUbicacion.setText("UBICACION:");

        lblZonaHoraria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblZonaHoraria.setText("ZONA-HORARIA:");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar Cita");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbtPublico);
        RbtPublico.setText("PUBLICO");
        RbtPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtPublicoActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbtPrivado);
        RbtPrivado.setText("PRIVADO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("REPETICION:");

        txtRecordatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecordatorioActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbtActivo);
        rbtActivo.setText("ACTIVO");

        buttonGroup2.add(rbtInactivo);
        rbtInactivo.setText("INACTIVO");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Recordar Cita");

        cbbTipocita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de cita", "Reunion", "Escolar", "Medica", "Trabajo" }));

        btnVerCitas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnVerCitas.setText("Ver Citas");
        btnVerCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCitasActionPerformed(evt);
            }
        });

        btnlimpiar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAgendaLayout = new javax.swing.GroupLayout(pnlAgenda);
        pnlAgenda.setLayout(pnlAgendaLayout);
        pnlAgendaLayout.setHorizontalGroup(
            pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgendaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblDescripcion)
                    .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblFecha)
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTcita)
                            .addComponent(lblHora)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTipocita, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaC, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtActivo)
                    .addComponent(rbtInactivo))
                .addGap(46, 46, 46)
                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVisibilidad)
                    .addGroup(pnlAgendaLayout.createSequentialGroup()
                        .addComponent(btnVerCitas)
                        .addGap(18, 18, 18)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlAgendaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RbtPrivado)
                            .addComponent(RbtPublico)
                            .addGroup(pnlAgendaLayout.createSequentialGroup()
                                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblZonaHoraria)
                                    .addComponent(lblUbicacion)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtZonaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRecordatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAgendaLayout.setVerticalGroup(
            pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgendaLayout.createSequentialGroup()
                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgendaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitulo)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblDescripcion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUbicacion)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAgendaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblZonaHoraria)
                                    .addComponent(txtZonaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRecordatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlAgendaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)))
                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgendaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha)
                            .addComponent(txtFechaC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHora))
                        .addGap(20, 20, 20)
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTcita)
                            .addComponent(cbbTipocita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlAgendaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblVisibilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RbtPrivado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RbtPublico)))
                .addGap(18, 18, 18)
                .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgendaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVerCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAgendaLayout.createSequentialGroup()
                        .addGroup(pnlAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtActivo)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtInactivo)
                        .addContainerGap())))
        );

        label1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(153, 153, 255));
        label1.setText("AGENDA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(pnlAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        enviar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void RbtPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtPublicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbtPublicoActionPerformed

    private void txtRecordatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecordatorioActionPerformed
 
    }//GEN-LAST:event_txtRecordatorioActionPerformed

    private void btnVerCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCitasActionPerformed
        Vst_AlmacenCitas almacen = new Vst_AlmacenCitas(this, true);
            almacen.setVisible(true);    
    }//GEN-LAST:event_btnVerCitasActionPerformed

    private void txtFechaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaCActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vst_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vst_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vst_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vst_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vst_Citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbtPrivado;
    private javax.swing.JRadioButton RbtPublico;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVerCitas;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbbTipocita;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTcita;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JLabel lblVisibilidad;
    private javax.swing.JLabel lblZonaHoraria;
    private javax.swing.JPanel pnlAgenda;
    private javax.swing.JRadioButton rbtActivo;
    private javax.swing.JRadioButton rbtInactivo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaC;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtRecordatorio;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUbicacion;
    private javax.swing.JTextField txtZonaHoraria;
    // End of variables declaration//GEN-END:variables
}
