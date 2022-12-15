/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conexion.Conexion;
import conexion.Configuracion;
import controller.Ctr_Citas;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model.Mdl_Citas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sharik
 */
public class Vst_AlmacenCitas extends javax.swing.JDialog {

    Ctr_Citas control = new Ctr_Citas();
    Mdl_Citas modelo = new Mdl_Citas();
    ArrayList<Mdl_Citas> listaCitas = new ArrayList();
    int index;

    public Vst_AlmacenCitas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    void llenarTablaUser() {
        lbltitulo.setText("Citas Publicas");
        listaCitas = control.llenarTabla();

        for (int i = 0; i < listaCitas.size(); i++) {
            tblCitas.setValueAt(listaCitas.get(i).getIdCitas(), i, 0);
            tblCitas.setValueAt(listaCitas.get(i).getTituloCita(), i, 1);
            tblCitas.setValueAt(listaCitas.get(i).getDescripcionCita(), i, 2);
            tblCitas.setValueAt(listaCitas.get(i).getFecha_cita(), i, 3);
            tblCitas.setValueAt(listaCitas.get(i).getHora_cita(), i, 4);
            tblCitas.setValueAt(listaCitas.get(i).getTipo_cita(), i, 5);
            tblCitas.setValueAt(listaCitas.get(i).getFecha_registroCita(), i, 6);
            tblCitas.setValueAt(listaCitas.get(i).getUbicacion_cita(), i, 7);
        }
    }

    void Citas_Privadas() {
        ArrayList<Mdl_Citas> citasPrivadas = new ArrayList();
        citasPrivadas = control.CitasPrivadas();
        lbltitulo.setText("Citas Privadas");

        for (int i = 0; i < citasPrivadas.size(); i++) {
            tblCitas.setValueAt(citasPrivadas.get(i).getIdCitas(), i, 0);
            tblCitas.setValueAt(citasPrivadas.get(i).getTituloCita(), i, 1);
            tblCitas.setValueAt(citasPrivadas.get(i).getDescripcionCita(), i, 2);
            tblCitas.setValueAt(citasPrivadas.get(i).getFecha_cita(), i, 3);
            tblCitas.setValueAt(citasPrivadas.get(i).getHora_cita(), i, 4);
            tblCitas.setValueAt(citasPrivadas.get(i).getTipo_cita(), i, 5);
            tblCitas.setValueAt(citasPrivadas.get(i).getFecha_registroCita(), i, 6);
            tblCitas.setValueAt(citasPrivadas.get(i).getUbicacion_cita(), i, 7);
        }
    }

    void visualizar() {
        int fila = tblCitas.getSelectedRow();
        index = fila;
        txtIdcita.setText(tblCitas.getValueAt(fila, 0).toString());
        txtTitulocita.setText(String.valueOf(tblCitas.getValueAt(fila, 1)));
        txtDescripcioncita.setText(String.valueOf(tblCitas.getValueAt(fila, 2)));
        txtfechacita.setText(String.valueOf(tblCitas.getValueAt(fila, 3)));
        txtHoracita.setText(String.valueOf(tblCitas.getValueAt(fila, 4)));
        txtUbicacioncita.setText(String.valueOf(tblCitas.getValueAt(fila, 7)));
    }

    void modificar() {

        modelo.setIdCitas(Integer.parseInt(txtIdcita.getText()));
        modelo.setTituloCita(txtTitulocita.getText().toLowerCase());
        modelo.setDescripcionCita(txtDescripcioncita.getText());
        modelo.setTipo_cita(cbbTipocita.getSelectedItem().toString());
        modelo.setFecha_cita(txtfechacita.getText());
        modelo.setHora_cita(txtHoracita.getText());
        modelo.setUbicacion_cita(txtUbicacioncita.getText());
        control.modificar(modelo);
        if (RbtPrivado.isSelected()) {
            Citas_Privadas();
        } else {
            llenarTablaUser();
        }
    }

    void limpiar() {
        txtIdcita.setText("");
        txtTitulocita.setText("");
        txtDescripcioncita.setText("");
        txtfechacita.setText("");
        txtHoracita.setText("");
        txtUbicacioncita.setText("");
        if (RbtPrivado.isSelected()) {
            borrarTabla();
            Citas_Privadas();
        } else {
            borrarTabla();
            llenarTablaUser();
        }
    }

    void eliminar() {
        int fila = tblCitas.getSelectedRow();
        modelo.setTituloCita(txtTitulocita.getText());
        control.eliminar(modelo);

        tblCitas.setValueAt("", fila, 0);
        tblCitas.setValueAt("", fila, 1);
        tblCitas.setValueAt("", fila, 2);
        tblCitas.setValueAt("", fila, 3);
        tblCitas.setValueAt("", fila, 4);
        tblCitas.setValueAt("", fila, 5);
        tblCitas.setValueAt("", fila, 6);
        tblCitas.setValueAt("", fila, 7);
        if (RbtPrivado.isSelected()) {
            borrarTabla();
            Citas_Privadas();
        } else {
            borrarTabla();
            llenarTablaUser();
        }
        limpiar();
    }

    void BuscarCitas() {
        ArrayList<Mdl_Citas> citas = new ArrayList();
        modelo.setTituloCita(txtBuscar.getText().toLowerCase());
        citas = control.buscarCitas(modelo);
        if (citas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No fue posible encontrar la cita");
        } else {
            borrarTabla();
            for (int i = 0; i < citas.size(); i++) {
                tblCitas.setValueAt(citas.get(i).getIdCitas(), i, 0);
                tblCitas.setValueAt(citas.get(i).getTituloCita(), i, 1);
                tblCitas.setValueAt(citas.get(i).getDescripcionCita(), i, 2);
                tblCitas.setValueAt(citas.get(i).getFecha_cita(), i, 3);
                tblCitas.setValueAt(citas.get(i).getHora_cita(), i, 4);
                tblCitas.setValueAt(citas.get(i).getTipo_cita(), i, 5);
                tblCitas.setValueAt(citas.get(i).getFecha_registroCita(), i, 6);
                tblCitas.setValueAt(citas.get(i).getUbicacion_cita(), i, 7);
            }
        }
    }

    void borrarTabla() {

        for (int i = 0; i < control.CuentaCitas(); i++) {
            tblCitas.setValueAt("", i, 0);
            tblCitas.setValueAt("", i, 1);
            tblCitas.setValueAt("", i, 2);
            tblCitas.setValueAt("", i, 3);
            tblCitas.setValueAt("", i, 4);
            tblCitas.setValueAt("", i, 5);
            tblCitas.setValueAt("", i, 6);
            tblCitas.setValueAt("", i, 7);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtDescripcioncita = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();
        txtTitulocita = new javax.swing.JTextField();
        cbbTipocita = new javax.swing.JComboBox<>();
        txtIdcita = new javax.swing.JTextField();
        txtHoracita = new javax.swing.JTextField();
        txtfechacita = new javax.swing.JTextField();
        txtUbicacioncita = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnmodificar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        RbtPrivado = new javax.swing.JRadioButton();
        RbtPublica = new javax.swing.JRadioButton();
        lbltitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("DESCRIPCION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtDescripcioncita, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDescripcioncita, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Descripcion", "Fecha Cita", "Hora ", "Tipo de Cita", "Fecha de Registro", "Ubicacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCitas);
        if (tblCitas.getColumnModel().getColumnCount() > 0) {
            tblCitas.getColumnModel().getColumn(0).setResizable(false);
            tblCitas.getColumnModel().getColumn(1).setResizable(false);
            tblCitas.getColumnModel().getColumn(2).setResizable(false);
            tblCitas.getColumnModel().getColumn(3).setResizable(false);
            tblCitas.getColumnModel().getColumn(4).setResizable(false);
            tblCitas.getColumnModel().getColumn(5).setResizable(false);
            tblCitas.getColumnModel().getColumn(6).setResizable(false);
            tblCitas.getColumnModel().getColumn(7).setResizable(false);
        }

        cbbTipocita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de cita", "Reunion", "Escolar", "Medica", "Trabajo" }));

        txtfechacita.setText("dd/mm/aaaa");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("TITULO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("TIPO DE CITA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("UBICACION");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("BUSCAR TITULO DE CITA");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("FECHA CITA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("HORA CITA");

        btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbtPrivado);
        RbtPrivado.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RbtPrivado.setText("Citas Privadas");
        RbtPrivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtPrivadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbtPublica);
        RbtPublica.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RbtPublica.setText("Citas Publicas");
        RbtPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtPublicaActionPerformed(evt);
            }
        });

        lbltitulo.setText("Citas Guardadas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdcita)
                                    .addComponent(cbbTipocita, 0, 167, Short.MAX_VALUE)
                                    .addComponent(txtTitulocita)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(txtfechacita, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                            .addComponent(txtHoracita)
                                            .addComponent(jLabel8))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(txtUbicacioncita, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnmodificar)
                        .addGap(20, 20, 20)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addGap(79, 79, 79)
                        .addComponent(RbtPrivado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RbtPublica)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltitulo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdcita, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulocita, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfechacita, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoracita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTipocita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUbicacioncita, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbltitulo)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodificar)
                    .addComponent(btnbuscar)
                    .addComponent(btnLimpiar)
                    .addComponent(btneliminar)
                    .addComponent(RbtPrivado)
                    .addComponent(RbtPublica))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RbtPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtPublicoActionPerformed
        borrarTabla();
        llenarTablaUser();
    }//GEN-LAST:event_RbtPublicoActionPerformed

    private void RbtPrivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtPrivadoActionPerformed
        borrarTabla();
        Citas_Privadas();
    }//GEN-LAST:event_RbtPrivadoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        BuscarCitas();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void tblCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCitasMouseClicked
        visualizar();
    }//GEN-LAST:event_tblCitasMouseClicked

    private void txtFechacitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechacitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechacitaActionPerformed

    private void RbtPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtPublicaActionPerformed
        borrarTabla();
        llenarTablaUser();
    }//GEN-LAST:event_RbtPublicaActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Vst_AlmacenCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vst_AlmacenCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vst_AlmacenCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vst_AlmacenCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vst_AlmacenCitas dialog = new Vst_AlmacenCitas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbtPrivado;
    private javax.swing.JRadioButton RbtPublica;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbTipocita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTable tblCitas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcioncita;
    private javax.swing.JTextField txtHoracita;
    private javax.swing.JTextField txtIdcita;
    private javax.swing.JTextField txtTitulocita;
    private javax.swing.JTextField txtUbicacioncita;
    private javax.swing.JTextField txtfechacita;
    // End of variables declaration//GEN-END:variables
}
