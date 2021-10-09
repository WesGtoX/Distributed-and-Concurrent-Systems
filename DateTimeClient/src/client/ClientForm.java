package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.Month;
import service.IDateTime;

/**
 *
 * @author Wesley
 */
public class ClientForm extends javax.swing.JFrame {

    public ClientForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("RMI Client");
        this.setResizable(false);
        txtDate.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDate = new javax.swing.JTextField();
        btnData = new javax.swing.JButton();
        btnTime = new javax.swing.JButton();
        btnAge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDate.setActionCommand("<Not Set>");

        btnData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnData.setText("DATA");
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
            }
        });

        btnTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTime.setText("HORA");
        btnTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeActionPerformed(evt);
            }
        });

        btnAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAge.setText("IDADE");
        btnAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDate)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAge, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAge, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataActionPerformed
        try {
            // Registrar o Servico que sera acessado
            Registry srv = LocateRegistry.getRegistry(
                IDateTime.SERVICE_HOST,
                IDateTime.PORT
            );
            
            // Descobrir quais metodos remotos estao disponiveis
            IDateTime op = (IDateTime)srv.lookup(IDateTime.SERVICE_NAME);
            
            txtDate.setText(op.getDate());
        } catch (NotBoundException | RemoteException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeActionPerformed
        try {
            // Registrar o Servico que sera acessado
            Registry srv = LocateRegistry.getRegistry(
                IDateTime.SERVICE_HOST,
                IDateTime.PORT
            );
            
            // Descobrir quais metodos remotos estao disponiveis
            IDateTime op = (IDateTime)srv.lookup(IDateTime.SERVICE_NAME);
            
            txtDate.setText(op.getTime());
        } catch (NotBoundException | RemoteException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTimeActionPerformed

    private void btnAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgeActionPerformed
        try {
            // Registrar o Servico que sera acessado
            Registry srv = LocateRegistry.getRegistry(
                IDateTime.SERVICE_HOST,
                IDateTime.PORT
            );
            
            // Descobrir quais metodos remotos estao disponiveis
            IDateTime op = (IDateTime)srv.lookup(IDateTime.SERVICE_NAME);
            
            txtDate.setText(op.getAge(LocalDate.of(2000, Month.JANUARY, 1)));
        } catch (NotBoundException | RemoteException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgeActionPerformed

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
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAge;
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnTime;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
