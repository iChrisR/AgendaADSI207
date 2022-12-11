/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Ctr_Notas;
import model.Mdl_Notas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joan
 */
public class Vw_almacenNotas extends javax.swing.JDialog {

    Ctr_Notas Ctr = new Ctr_Notas();
    Mdl_Notas Mdl = new Mdl_Notas();
    ArrayList<Mdl_Notas> listaNotas = new ArrayList();
    int index;

    public Vw_almacenNotas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        inicio();
    }

    void inicio() {
        this.setTitle("Almacen de notas");
        this.setLocationRelativeTo(null);
        llenarTablaUser();

    }

    void llenarTablaUser() {
        lbltittle.setText("Notas Publicas");
        listaNotas = Ctr.llenarTabla();

        for (int i = 0; i < listaNotas.size(); i++) {
            TblNotas.setValueAt(listaNotas.get(i).getId_nota(), i, 0);
            TblNotas.setValueAt(listaNotas.get(i).getTitulo(), i, 1);
            TblNotas.setValueAt(listaNotas.get(i).getNota(), i, 2);
            TblNotas.setValueAt(listaNotas.get(i).getFecha_registro(), i, 3);
            TblNotas.setValueAt(listaNotas.get(i).getTipo_nota(), i, 4);

        }
    }

    void Visualizar() {
        int filaSeleccionada = TblNotas.getSelectedRow();
        index = filaSeleccionada;
        txtId.setText(TblNotas.getValueAt(filaSeleccionada, 0).toString());
        txtNotaTitulo.setText(String.valueOf(TblNotas.getValueAt(filaSeleccionada, 1)));
        txtCuerpo.setText(String.valueOf(TblNotas.getValueAt(filaSeleccionada, 2)));

    }

    void modificar() {

        Mdl.setTitulo(txtNotaTitulo.getText().toLowerCase());
        Mdl.setNota(txtCuerpo.getText());
        Mdl.setId_nota(Integer.parseInt(txtId.getText()));
        Mdl.setFecha_modificacion(Ctr.fechaHoy());
        Mdl.setTipo_nota(cbbtipodenota.getSelectedItem().toString());
        Ctr.modificar(Mdl);
         if (RbtPrivado.isSelected()) {
          
            N_privadas();
        } else {
            llenarTablaUser();
        }
    }



    void Borrartabla() {

        for (int i = 0; i < Ctr.CountNotas(); i++) {
            TblNotas.setValueAt("", i, 0);
            TblNotas.setValueAt("", i, 1);
            TblNotas.setValueAt("", i, 2);
            TblNotas.setValueAt("", i, 3);
            TblNotas.setValueAt("", i, 4);
        }

    }

    void eliminar() {
        int filaSeleccionada = TblNotas.getSelectedRow();
        //Mdl.setId_nota(Integer.parseInt(txtId.getText()));
        Mdl.setTitulo(txtNotaTitulo.getText());
        Ctr.eliminar(Mdl);

        TblNotas.setValueAt("", filaSeleccionada, 0);
        TblNotas.setValueAt("", filaSeleccionada, 1);
        TblNotas.setValueAt("", filaSeleccionada, 2);
        TblNotas.setValueAt("", filaSeleccionada, 3);
        TblNotas.setValueAt("", filaSeleccionada, 4);
        if (RbtPrivado.isSelected()) {
            Borrartabla();
            N_privadas();
        } else {
            Borrartabla();
            llenarTablaUser();
        }

        limpiar();
    }

    void limpiar() {
        txtBuscartitulo.setText("");
        txtCuerpo.setText("");
        txtId.setText("");
        txtNotaTitulo.setText("");
         if (RbtPrivado.isSelected()) {
            Borrartabla();
            N_privadas();
        } else {
            Borrartabla();
            llenarTablaUser();
        }

    }

    void N_privadas() {
        ArrayList<Mdl_Notas> NotasPrivadas = new ArrayList();
        NotasPrivadas = Ctr.NotasPrivadas();
        lbltittle.setText("Notas privadas");

        for (int i = 0; i < NotasPrivadas.size(); i++) {
            TblNotas.setValueAt(NotasPrivadas.get(i).getId_nota(), i, 0);
            TblNotas.setValueAt(NotasPrivadas.get(i).getTitulo(), i, 1);
            TblNotas.setValueAt(NotasPrivadas.get(i).getNota(), i, 2);
            TblNotas.setValueAt(NotasPrivadas.get(i).getFecha_registro(), i, 3);
            TblNotas.setValueAt(NotasPrivadas.get(i).getTipo_nota(), i, 4);
        }

    }

    void buscarNota() {
        ArrayList<Mdl_Notas> Nota = new ArrayList();
        Mdl.setTitulo(txtBuscartitulo.getText().toLowerCase());
        Nota = Ctr.BuscarNotas(Mdl);
        if (Nota.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado esa nota");
        } else {
            Borrartabla();
            for (int i = 0; i < Nota.size(); i++) {
                TblNotas.setValueAt(Nota.get(i).getId_nota(), i, 0);
                TblNotas.setValueAt(Nota.get(i).getTitulo(), i, 1);
                TblNotas.setValueAt(Nota.get(i).getNota(), i, 2);
                TblNotas.setValueAt(Nota.get(i).getFecha_registro(), i, 3);
                TblNotas.setValueAt(Nota.get(i).getTipo_nota(), i, 4);
            }
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
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCuerpo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtBuscartitulo = new javax.swing.JTextField();
        lbltittle = new javax.swing.JLabel();
        txtNotaTitulo = new javax.swing.JTextField();
        ScptableNotas = new javax.swing.JScrollPane();
        TblNotas = new javax.swing.JTable();
        Btneliminar = new javax.swing.JButton();
        Btneditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        RbtPrivado = new javax.swing.JRadioButton();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        RbtPublico = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        cbbtipodenota = new javax.swing.JComboBox<>();
        btnlimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCuerpo.setColumns(20);
        txtCuerpo.setRows(5);
        jScrollPane3.setViewportView(txtCuerpo);

        jLabel2.setText("Buscar Titulo de nota");

        txtBuscartitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscartituloActionPerformed(evt);
            }
        });

        lbltittle.setText("Notas anteriores:");

        txtNotaTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaTituloActionPerformed(evt);
            }
        });

        TblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Contenido", "Fecha de registro", "Tipo de nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblNotasMouseClicked(evt);
            }
        });
        ScptableNotas.setViewportView(TblNotas);

        Btneliminar.setText("Eliminar");
        Btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtneliminarActionPerformed(evt);
            }
        });

        Btneditar.setText("Modificar");
        Btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtneditarActionPerformed(evt);
            }
        });

        jLabel3.setText("TItulo");

        jLabel4.setText("Nota");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbtPrivado);
        RbtPrivado.setText("Notas Privadas");
        RbtPrivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtPrivadoActionPerformed(evt);
            }
        });

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        buttonGroup1.add(RbtPublico);
        RbtPublico.setSelected(true);
        RbtPublico.setText("Notas publicas");
        RbtPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtPublicoActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de dato");

        cbbtipodenota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbtipodenota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de  Nota  ", "Nota casual", "Nota de Eventos", "Nota de Trabajo", "Nota de Salud", "Nota de Belleza", "Nota Escolar", " ", " ", " " }));

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ScptableNotas)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscartitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltittle))
                        .addContainerGap(682, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNotaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbtipodenota, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RbtPrivado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RbtPublico)
                        .addGap(156, 156, 156))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNotaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbtipodenota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscartitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
                .addComponent(lbltittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScptableNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlimpiar))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btneliminar)
                            .addComponent(Btneditar)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RbtPrivado)
                        .addComponent(RbtPublico)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscartituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscartituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscartituloActionPerformed

    private void BtneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtneliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_BtneliminarActionPerformed

    private void BtneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtneditarActionPerformed
        // TODO add your handling code here:
        modificar();
    }//GEN-LAST:event_BtneditarActionPerformed

    private void RbtPrivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtPrivadoActionPerformed
        Borrartabla();
        N_privadas();

    }//GEN-LAST:event_RbtPrivadoActionPerformed

    private void TblNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblNotasMouseClicked
        // TODO add your handling code here:
        Visualizar();
    }//GEN-LAST:event_TblNotasMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void RbtPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtPublicoActionPerformed
        Borrartabla();
        llenarTablaUser();

    }//GEN-LAST:event_RbtPublicoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
     
        buscarNota();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void txtNotaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotaTituloActionPerformed

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
            java.util.logging.Logger.getLogger(Vw_almacenNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vw_almacenNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vw_almacenNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vw_almacenNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vw_almacenNotas dialog = new Vw_almacenNotas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Btneditar;
    private javax.swing.JButton Btneliminar;
    private javax.swing.JRadioButton RbtPrivado;
    private javax.swing.JRadioButton RbtPublico;
    private javax.swing.JScrollPane ScptableNotas;
    private javax.swing.JTable TblNotas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbtipodenota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltittle;
    private javax.swing.JTextField txtBuscartitulo;
    private javax.swing.JTextArea txtCuerpo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNotaTitulo;
    // End of variables declaration//GEN-END:variables
}
