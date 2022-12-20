package view;

import controller.CtrUtilitario;
import javax.swing.JOptionPane;

public class Vw_menu extends javax.swing.JFrame {

    
    public Vw_menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    void AbrirGestionUsuarios() {
        CtrUtilitario util = new CtrUtilitario();

        if (util.retornarUsuario()==1) {
            Vw_GestionUsuarios vu = new Vw_GestionUsuarios(this, true);
            vu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No tienes acesso");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        pnl_body = new javax.swing.JPanel();
        pnl_footer = new javax.swing.JPanel();
        mnb_menu = new javax.swing.JMenuBar();
        mn_usuarios = new javax.swing.JMenu();
        mnt_gestionusuarios = new javax.swing.JMenuItem();
        mn_contactos = new javax.swing.JMenu();
        mnt_gestionContactos = new javax.swing.JMenuItem();
        VstNotas = new javax.swing.JMenu();
        MntNotas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnl_bodyLayout = new javax.swing.GroupLayout(pnl_body);
        pnl_body.setLayout(pnl_bodyLayout);
        pnl_bodyLayout.setHorizontalGroup(
            pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_bodyLayout.setVerticalGroup(
            pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_footerLayout = new javax.swing.GroupLayout(pnl_footer);
        pnl_footer.setLayout(pnl_footerLayout);
        pnl_footerLayout.setHorizontalGroup(
            pnl_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );
        pnl_footerLayout.setVerticalGroup(
            pnl_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        mn_usuarios.setText("Usuarios");

        mnt_gestionusuarios.setText("Gestión  Usuarios");
        mnt_gestionusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnt_gestionusuariosActionPerformed(evt);
            }
        });
        mn_usuarios.add(mnt_gestionusuarios);

        mnb_menu.add(mn_usuarios);

        mn_contactos.setText("Contactos");

        mnt_gestionContactos.setText("Gestion de contactos");
        mnt_gestionContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnt_gestionContactosActionPerformed(evt);
            }
        });
        mn_contactos.add(mnt_gestionContactos);

        mnb_menu.add(mn_contactos);

        VstNotas.setText("Notas");
        VstNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VstNotasActionPerformed(evt);
            }
        });

        MntNotas.setText("Ver notas");
        MntNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MntNotasActionPerformed(evt);
            }
        });
        VstNotas.add(MntNotas);

        mnb_menu.add(VstNotas);

        jMenu2.setText("Edit");
        mnb_menu.add(jMenu2);

        setJMenuBar(mnb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnt_gestionusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnt_gestionusuariosActionPerformed
        AbrirGestionUsuarios();
    }//GEN-LAST:event_mnt_gestionusuariosActionPerformed

    private void mnt_gestionContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnt_gestionContactosActionPerformed
        Vw_contactos vco = new Vw_contactos(this, true);
            vco.setVisible(true);
    }//GEN-LAST:event_mnt_gestionContactosActionPerformed

    private void VstNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VstNotasActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_VstNotasActionPerformed

    private void MntNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MntNotasActionPerformed
        // TODO add your handling code here:
         Vw_Notas vn =  new Vw_Notas();
         vn.setVisible(true);
    }//GEN-LAST:event_MntNotasActionPerformed

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
            java.util.logging.Logger.getLogger(Vw_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vw_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vw_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vw_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vw_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MntNotas;
    private javax.swing.JMenu VstNotas;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu mn_contactos;
    private javax.swing.JMenu mn_usuarios;
    private javax.swing.JMenuBar mnb_menu;
    private javax.swing.JMenuItem mnt_gestionContactos;
    private javax.swing.JMenuItem mnt_gestionusuarios;
    private javax.swing.JPanel pnl_body;
    private javax.swing.JPanel pnl_footer;
    // End of variables declaration//GEN-END:variables
}
