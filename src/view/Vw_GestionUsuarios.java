package view;

import controller.Ctr_usuarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mdl_User;

public class Vw_GestionUsuarios extends javax.swing.JDialog {

    Ctr_usuarios cuser = new Ctr_usuarios();
    ArrayList<Mdl_User> listauser = new ArrayList();

    public Vw_GestionUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        llenarTablaUser();
        UserPrivadoExistente();
        contarUsuario();
    }

    void modificarUsuario() {
        Mdl_User user = new Mdl_User();
        String clave;
        if (pxt_clave.getText().equals(pxt_confirmacion.getText()))
        {
            user.setNombreuser(txt_nombreusuario.getText());
            user.setEstado("1");
            user.setUestado("1");
            clave = pxt_clave.getText();
            user.setClave(clave);
            user.setNombres(txt_nombres.getText());
            user.setApellidos(txt_apellidos.getText());
            if (rb_privado.isSelected()==true)
            {
                user.setTipouser("1");
            } else
            {
                user.setTipouser("2");
            }
            cuser.modificarUsuario(user, (tbl_usuarios.getSelectedRow())+1);
            limpiarTabla();
            llenarTablaUser();
            limpiar();
        } else
        {
            JOptionPane.showMessageDialog(null, "Las claves no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    void llenarTablaUser() {
        Ctr_usuarios cu = new Ctr_usuarios();
        listauser = cu.consultar();
        for (int posicion = 0; posicion < listauser.size(); posicion++)
        {
            tbl_usuarios.setValueAt(listauser.get(posicion).getIduser(), posicion, 0);
            tbl_usuarios.setValueAt(listauser.get(posicion).getNombres(), posicion, 1);
            tbl_usuarios.setValueAt(listauser.get(posicion).getApellidos(), posicion, 2);
            if (listauser.get(posicion).getTipouser().equals("1"))
            {
                tbl_usuarios.setValueAt("Privado", posicion, 3);
            } else
            {
                tbl_usuarios.setValueAt("Público", posicion, 3);
            }
            tbl_usuarios.setValueAt(listauser.get(posicion).getNombreuser(), posicion, 4);
        }
    }

    void llenarUsuario() {
        if (listauser.size()==1)
        {
            rb_publico.setSelected(true);
        }
        Mdl_User user = new Mdl_User();
        String clave;
        if (pxt_clave.getText().equals(pxt_confirmacion.getText()))
        {
            user.setNombreuser(txt_nombreusuario.getText());
            user.setEstado("1");
            user.setUestado("1");
            clave = pxt_clave.getText();
            user.setClave(clave);
            user.setNombres(txt_nombres.getText());
            user.setApellidos(txt_apellidos.getText());
            
            if (rb_privado.isSelected()==true)
            {
                user.setTipouser("1");
            } else
            {
                user.setTipouser("2");
            }
            cuser.GuardarUsuario(user);
            limpiarTabla();
            llenarTablaUser();
            limpiar();
            UserPrivadoExistente();
            contarUsuario();
        } else
        {
            JOptionPane.showMessageDialog(null, "Las claves no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    void UserPrivadoExistente() {
            if (0<listauser.size())
            {
                rb_privado.setEnabled(false);
                rb_privado.setSelected(false);
                rb_publico.setSelected(true);
            } else
            {
                rb_publico.setEnabled(false);
                rb_privado.setSelected(true);
            }
    }

    void limpiar() {
        txt_nombres.setText("");
        txt_apellidos.setText("");
        txt_nombreusuario.setText("");
        pxt_clave.setText("");
        pxt_confirmacion.setText("");
        rb_privado.setSelected(false);
        rb_publico.setSelected(false);
    }

    public void limpiarTabla() {
        for (int p = 0; p < 100; p++)
        {
            tbl_usuarios.setValueAt("", p, 0);
            tbl_usuarios.setValueAt("", p, 1);
            tbl_usuarios.setValueAt("", p, 2);
            tbl_usuarios.setValueAt("", p, 3);
            tbl_usuarios.setValueAt("", p, 4);
        }
    }

    void contarUsuario() {
        if (listauser.size() >= 2)
        {
            btn_guardar.setEnabled(false);
            rb_privado.setSelected(false);
            rb_publico.setSelected(false);
        }
        if (listauser.size()>0)
        {
            txt_apellidos.setEnabled(false);
            txt_nombres.setEnabled(false);
        }
    }

    void mostrarTabla() {
        if (tbl_usuarios.getSelectedRow() == 0)
        {
            txt_apellidos.setEnabled(true);
            txt_nombres.setEnabled(true);
        } else
        {
            txt_apellidos.setEnabled(false);
            txt_nombres.setEnabled(false);
        }
        for (int posicion = 0; posicion < listauser.size(); posicion++)
        {
            if (tbl_usuarios.getSelectedRow() == posicion)
            {
                txt_nombres.setText(listauser.get(posicion).getNombres());
                txt_apellidos.setText(listauser.get(posicion).getApellidos());
                if (listauser.get(posicion).getTipouser().equals("2"))
                {
                    rb_publico.setSelected(true);
                }else{
                    rb_privado.setSelected(true);
                }
                pxt_clave.setText(listauser.get(posicion).getClave());
                pxt_confirmacion.setText(listauser.get(posicion).getClave());
                txt_nombreusuario.setText(listauser.get(posicion).getNombreuser());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_tipoUser = new javax.swing.ButtonGroup();
        pnl_botones = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        pnl_titulos = new javax.swing.JPanel();
        lbl_nombres = new javax.swing.JLabel();
        lbl_apellidos = new javax.swing.JLabel();
        lbl_tipousuario = new javax.swing.JLabel();
        lbl_nombreusuario = new javax.swing.JLabel();
        lbl_clave = new javax.swing.JLabel();
        lbl_confirmacionclave = new javax.swing.JLabel();
        pnl_datos = new javax.swing.JPanel();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_nombreusuario = new javax.swing.JTextField();
        pxt_clave = new javax.swing.JPasswordField();
        pxt_confirmacion = new javax.swing.JPasswordField();
        rb_privado = new javax.swing.JRadioButton();
        rb_publico = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuarios = new javax.swing.JTable();

        bg_tipoUser.add(rb_privado);
        bg_tipoUser.add(rb_publico);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        lbl_nombres.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbl_nombres.setText("Nombres :");

        lbl_apellidos.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbl_apellidos.setText("Apellidos :");

        lbl_tipousuario.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbl_tipousuario.setText("Tipo de Usuario :");

        lbl_nombreusuario.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbl_nombreusuario.setText("Nombre Usuario :");

        lbl_clave.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbl_clave.setText("Clave :");

        lbl_confirmacionclave.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbl_confirmacionclave.setText("Confirmación de clave :");

        javax.swing.GroupLayout pnl_titulosLayout = new javax.swing.GroupLayout(pnl_titulos);
        pnl_titulos.setLayout(pnl_titulosLayout);
        pnl_titulosLayout.setHorizontalGroup(
            pnl_titulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_titulosLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(pnl_titulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_confirmacionclave)
                    .addComponent(lbl_tipousuario)
                    .addComponent(lbl_apellidos)
                    .addComponent(lbl_nombreusuario)
                    .addComponent(lbl_clave)
                    .addComponent(lbl_nombres))
                .addGap(21, 21, 21))
        );
        pnl_titulosLayout.setVerticalGroup(
            pnl_titulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_titulosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_nombreusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_confirmacionclave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        rb_privado.setText("Privado");

        rb_publico.setText("Publico");

        javax.swing.GroupLayout pnl_datosLayout = new javax.swing.GroupLayout(pnl_datos);
        pnl_datos.setLayout(pnl_datosLayout);
        pnl_datosLayout.setHorizontalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombres)
                    .addComponent(txt_apellidos)
                    .addComponent(txt_nombreusuario)
                    .addComponent(pxt_clave)
                    .addComponent(pxt_confirmacion)
                    .addGroup(pnl_datosLayout.createSequentialGroup()
                        .addComponent(rb_privado, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rb_publico, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_datosLayout.setVerticalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_privado)
                    .addComponent(rb_publico))
                .addGap(12, 12, 12)
                .addComponent(txt_nombreusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pxt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pxt_confirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
                "#", "Nombres", "Apellidos", "Tipo usuario", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuarios);
        if (tbl_usuarios.getColumnModel().getColumnCount() > 0) {
            tbl_usuarios.getColumnModel().getColumn(0).setResizable(false);
            tbl_usuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_usuarios.getColumnModel().getColumn(1).setResizable(false);
            tbl_usuarios.getColumnModel().getColumn(2).setResizable(false);
            tbl_usuarios.getColumnModel().getColumn(3).setResizable(false);
            tbl_usuarios.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_titulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_titulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        llenarUsuario();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        modificarUsuario();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void tbl_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuariosMouseClicked
        mostrarTabla();
    }//GEN-LAST:event_tbl_usuariosMouseClicked

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Vw_GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Vw_GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Vw_GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Vw_GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vw_GestionUsuarios dialog = new Vw_GestionUsuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bg_tipoUser;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_apellidos;
    private javax.swing.JLabel lbl_clave;
    private javax.swing.JLabel lbl_confirmacionclave;
    private javax.swing.JLabel lbl_nombres;
    private javax.swing.JLabel lbl_nombreusuario;
    private javax.swing.JLabel lbl_tipousuario;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_datos;
    private javax.swing.JPanel pnl_titulos;
    private javax.swing.JPasswordField pxt_clave;
    private javax.swing.JPasswordField pxt_confirmacion;
    private javax.swing.JRadioButton rb_privado;
    private javax.swing.JRadioButton rb_publico;
    private javax.swing.JTable tbl_usuarios;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_nombreusuario;
    // End of variables declaration//GEN-END:variables
}
