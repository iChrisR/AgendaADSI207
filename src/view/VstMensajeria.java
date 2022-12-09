
package view;

public class VstMensajeria extends javax.swing.JFrame {

  public VstMensajeria() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    lblPara = new javax.swing.JLabel();
    txtPara = new javax.swing.JTextField();
    lblAsunto = new javax.swing.JLabel();
    txtAsunto = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    lblPara.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    lblPara.setText("Para: ");

    lblAsunto.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    lblAsunto.setText("Asunto: ");

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    jButton1.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
    jButton1.setText("ENVIAR");

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
                  .addComponent(txtPara)))))
          .addGroup(layout.createSequentialGroup()
            .addGap(165, 165, 165)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(41, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblPara))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblAsunto))
        .addGap(36, 36, 36)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
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
  private javax.swing.JButton jButton1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JLabel lblAsunto;
  private javax.swing.JLabel lblPara;
  private javax.swing.JTextField txtAsunto;
  private javax.swing.JTextField txtPara;
  // End of variables declaration//GEN-END:variables
}
