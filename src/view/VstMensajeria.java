
package view;

public class VstMensajeria extends javax.swing.JFrame {

  public VstMensajeria() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    lblPara = new javax.swing.JLabel();
    cmbPara = new javax.swing.JComboBox<>();
    lblAsunto = new javax.swing.JLabel();
    txtAsunto = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    txaMensaje = new javax.swing.JTextArea();
    btnEnviar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    lblPara.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    lblPara.setText("Para: ");

    lblAsunto.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    lblAsunto.setText("Asunto: ");

    txaMensaje.setColumns(20);
    txaMensaje.setRows(5);
    jScrollPane1.setViewportView(txaMensaje);

    btnEnviar.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
    btnEnviar.setText("ENVIAR");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(lblPara)
                    .addGap(33, 33, 33))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(lblAsunto)
                    .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(txtAsunto, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                  .addComponent(cmbPara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
          .addGroup(layout.createSequentialGroup()
            .addGap(165, 165, 165)
            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(41, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblPara)
          .addComponent(cmbPara, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblAsunto)
          .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(36, 36, 36)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        .addGap(12, 12, 12))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  public static void main(String args[]) {
    
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(VstMensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(VstMensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(VstMensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(VstMensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new VstMensajeria().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEnviar;
  private javax.swing.JComboBox<String> cmbPara;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblAsunto;
  private javax.swing.JLabel lblPara;
  private javax.swing.JTextArea txaMensaje;
  private javax.swing.JTextField txtAsunto;
  // End of variables declaration//GEN-END:variables
}
