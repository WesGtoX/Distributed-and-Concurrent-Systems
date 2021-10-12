package client;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import service.ICalculator;

/**
 *
 * @author Wesley
 */
public class ClientForm extends javax.swing.JFrame {

    public ClientForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Calculator Client");
        this.setResizable(false);
        txtValue1.requestFocus();
        txtResult.setEditable(false);
        txtOperation.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtResult = new javax.swing.JTextField();
        txtValue1 = new javax.swing.JTextField();
        lblValue1 = new javax.swing.JLabel();
        txtOperation = new javax.swing.JTextField();
        lblOperation = new javax.swing.JLabel();
        txtValue2 = new javax.swing.JTextField();
        lblValue2 = new javax.swing.JLabel();
        btnSum = new javax.swing.JButton();
        lblSum = new javax.swing.JLabel();
        btnSub = new javax.swing.JButton();
        lblSub = new javax.swing.JLabel();
        btnMult = new javax.swing.JButton();
        lblMult = new javax.swing.JLabel();
        btnDiv = new javax.swing.JButton();
        lblDiv = new javax.swing.JLabel();
        btnIqual = new javax.swing.JButton();
        btnSqrt = new javax.swing.JButton();
        lblSqrt = new javax.swing.JLabel();
        btnPoten = new javax.swing.JButton();
        lblPoten = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();
        lblLog = new javax.swing.JLabel();
        btnFtoC = new javax.swing.JButton();
        lblFtoC = new javax.swing.JLabel();
        btnCtoF = new javax.swing.JButton();
        lblCtoF = new javax.swing.JLabel();
        lblValue3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtResult.setBackground(new java.awt.Color(204, 204, 204));
        txtResult.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtResult.setActionCommand("<Not Set>");

        txtValue1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtValue1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValue1.setActionCommand("<Not Set>");

        lblValue1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblValue1.setText("V1");

        txtOperation.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtOperation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOperation.setActionCommand("<Not Set>");

        lblOperation.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblOperation.setText("Operação");

        txtValue2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtValue2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValue2.setActionCommand("<Not Set>");

        lblValue2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblValue2.setText("V2");

        btnSum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSum.setText("+");
        btnSum.setToolTipText("Precisa do V1 e V2.");
        btnSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumActionPerformed(evt);
            }
        });

        lblSum.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblSum.setText("V1 + V2");

        btnSub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSub.setText("-");
        btnSub.setToolTipText("Precisa do V1 e V2.");
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        lblSub.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblSub.setText("V1 - V2");

        btnMult.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMult.setText("x");
        btnMult.setToolTipText("Precisa do V1 e V2.");
        btnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultActionPerformed(evt);
            }
        });

        lblMult.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblMult.setText("V1 * V2");

        btnDiv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDiv.setText("/");
        btnDiv.setToolTipText("Precisa do V1 e V2.");
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });

        lblDiv.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblDiv.setText("V1 / V2");

        btnIqual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIqual.setText("=");
        btnIqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIqualActionPerformed(evt);
            }
        });

        btnSqrt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSqrt.setText("√");
        btnSqrt.setToolTipText("Precisa apenas do V1.");
        btnSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });

        lblSqrt.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblSqrt.setText("sqrt(V1)");

        btnPoten.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPoten.setText("x²");
        btnPoten.setToolTipText("Precisa do V1 e V2.");
        btnPoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotenActionPerformed(evt);
            }
        });

        lblPoten.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblPoten.setText("V1^V2");

        btnLog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLog.setText("Log");
        btnLog.setToolTipText("Precisa apenas do V1.");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });

        lblLog.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblLog.setText("log(V1)");

        btnFtoC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFtoC.setText("°F -> °C");
        btnFtoC.setToolTipText("Precisa apenas do V1.");
        btnFtoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFtoCActionPerformed(evt);
            }
        });

        lblFtoC.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblFtoC.setText("°F = V1");

        btnCtoF.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCtoF.setText("°C -> °F");
        btnCtoF.setToolTipText("Precisa apenas do V1.");
        btnCtoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCtoFActionPerformed(evt);
            }
        });

        lblCtoF.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblCtoF.setText("°C = V1");

        lblValue3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblValue3.setText("RESULT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResult)
                    .addComponent(lblValue3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFtoC)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFtoC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnIqual, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCtoF)
                            .addComponent(btnCtoF, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSum, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSub))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMult))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSqrt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPoten, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPoten))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLog)
                            .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValue1)
                            .addComponent(txtValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOperation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValue2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtValue2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValue3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue1)
                    .addComponent(lblOperation)
                    .addComponent(lblValue2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSum)
                    .addComponent(lblSub)
                    .addComponent(lblMult)
                    .addComponent(lblDiv)
                    .addComponent(lblSqrt)
                    .addComponent(lblPoten)
                    .addComponent(lblLog))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPoten, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFtoC)
                    .addComponent(lblCtoF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCtoF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIqual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFtoC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumActionPerformed
        txtValue2.setBackground(Color.WHITE);
        txtValue2.setEditable(true);
        txtOperation.setText("+");
    }//GEN-LAST:event_btnSumActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        txtValue2.setBackground(Color.WHITE);
        txtValue2.setEditable(true);
        txtOperation.setText("-");
    }//GEN-LAST:event_btnSubActionPerformed

    private void btnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultActionPerformed
        txtValue2.setBackground(Color.WHITE);
        txtValue2.setEditable(true);
        txtOperation.setText("x");
    }//GEN-LAST:event_btnMultActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        txtValue2.setBackground(Color.WHITE);
        txtValue2.setEditable(true);
        txtOperation.setText("/");
    }//GEN-LAST:event_btnDivActionPerformed

    private void btnSqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSqrtActionPerformed
        txtValue2.setBackground(Color.LIGHT_GRAY);
        txtValue2.setEditable(false);
        txtOperation.setText("√");
    }//GEN-LAST:event_btnSqrtActionPerformed

    private void btnPotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotenActionPerformed
        txtValue2.setBackground(Color.WHITE);
        txtValue2.setEditable(true);
        txtOperation.setText("^");
    }//GEN-LAST:event_btnPotenActionPerformed

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        txtValue2.setBackground(Color.LIGHT_GRAY);
        txtValue2.setEditable(false);
        txtOperation.setText("log");
    }//GEN-LAST:event_btnLogActionPerformed

    private void btnFtoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFtoCActionPerformed
        txtValue2.setBackground(Color.LIGHT_GRAY);
        txtValue2.setEditable(false);
        txtOperation.setText("°F > °C");
    }//GEN-LAST:event_btnFtoCActionPerformed

    private void btnCtoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCtoFActionPerformed
        txtValue2.setBackground(Color.LIGHT_GRAY);
        txtValue2.setEditable(false);
        txtOperation.setText("°C > °F");
    }//GEN-LAST:event_btnCtoFActionPerformed

    private void btnIqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIqualActionPerformed
        double v1 = -1, v2 = -1, result;
        String operation = "", v1_s, v2_s, value_s = "";
        String[] opArray = new String[] {"√", "log", "°F > °C", "C > °F"};
        
        try {
            // Registrar o Servico que sera acessado
            Registry srv = LocateRegistry.getRegistry(
                ICalculator.SERVICE_HOST,
                ICalculator.PORT
            );
            
            // Descobrir quais metodos remotos estao disponiveis
            ICalculator op = (ICalculator)srv.lookup(ICalculator.SERVICE_NAME);
            
            operation = txtOperation.getText();
            
            try {
                v1_s = txtValue1.getText();
                if (!v1_s.isEmpty()) {
                    v1 = Double.parseDouble(v1_s);
                } else {
                    v1 = -1;
                    operation = "v1";
                }

                v2_s = txtValue2.getText();
                if (!v2_s.isEmpty()) {
                    v2 = Double.parseDouble(v2_s);
                } else if (Arrays.asList(opArray).contains(operation)) {
                    v2 = -1;
                } else if (!"v1".equals(operation)) {
                    v2 = -1;
                    operation = "v2";
                }
            } catch (NumberFormatException e) {
                v1 = -1;
                v2 = -1;
                operation = "";
            }
            
            switch (operation) {
                case "+" -> {
                    result = op.getSum(v1, v2);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "-" -> {
                    result = op.getSubtraction(v1, v2);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "x" -> {
                    result = op.getMultiplication(v1, v2);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "/" -> {
                    result = op.getDivision(v1, v2);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "√" -> {
                    result = op.getSquareRoot(v1);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "^" -> {
                    result = op.getPotentiation(v1, v2);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "log" -> {
                    result = op.getLogarithm(v1);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "°F > °C" -> {
                    result = op.getFahrenheitToCelsius(v1);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "°C > °F" -> {
                    result = op.getCelsiusToFahrenheit(v1);
                    value_s = String.format("%.2f", result);
                    System.out.println(result);
                }
                case "v1" -> {
                    value_s = String.valueOf("V1 não pode ser vazio...");
                }
                case "v2" -> {
                    value_s = String.valueOf("V2 não pode ser vazio...");
                }
                default -> {
                    value_s = "OPERATION ERROR!!!";
                }
            }

            txtResult.setText(value_s);
        } catch (NotBoundException | RemoteException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_btnIqualActionPerformed

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
    private javax.swing.JButton btnCtoF;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnFtoC;
    private javax.swing.JButton btnIqual;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnMult;
    private javax.swing.JButton btnPoten;
    private javax.swing.JButton btnSqrt;
    private javax.swing.JButton btnSub;
    private javax.swing.JButton btnSum;
    private javax.swing.JLabel lblCtoF;
    private javax.swing.JLabel lblDiv;
    private javax.swing.JLabel lblFtoC;
    private javax.swing.JLabel lblLog;
    private javax.swing.JLabel lblMult;
    private javax.swing.JLabel lblOperation;
    private javax.swing.JLabel lblPoten;
    private javax.swing.JLabel lblSqrt;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblSum;
    private javax.swing.JLabel lblValue1;
    private javax.swing.JLabel lblValue2;
    private javax.swing.JLabel lblValue3;
    private javax.swing.JTextField txtOperation;
    private javax.swing.JTextField txtResult;
    private javax.swing.JTextField txtValue1;
    private javax.swing.JTextField txtValue2;
    // End of variables declaration//GEN-END:variables
}
