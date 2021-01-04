
package lk.ijse.PayrollSystem.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lk.ijse.PayrollSystem.Controller.LoginFormController;
import lk.ijse.PayrollSystem.Model.AdministratorModel;

public class LoginForm extends javax.swing.JFrame {

 
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SignInLabel = new javax.swing.JLabel();
        CloseLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pageHeading = new javax.swing.JLabel();
        MinimizeLabel = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kButton2 = new keeptoo.KButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SignInLabel.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        SignInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignInLabel.setText("Sign In to continue");
        SignInLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignInLabelMouseClicked(evt);
            }
        });
        jPanel1.add(SignInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 230, 40));

        CloseLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        CloseLabel.setForeground(new java.awt.Color(255, 255, 255));
        CloseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CloseLabel.setText("x");
        CloseLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        CloseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLabelMouseClicked(evt);
            }
        });
        jPanel1.add(CloseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 30, 40));

        jLabel7.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Genesis Payroll");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 230, 30));

        pageHeading.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        pageHeading.setForeground(new java.awt.Color(255, 255, 255));
        pageHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageHeading.setText("Login Page");
        pageHeading.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageHeadingMouseClicked(evt);
            }
        });
        jPanel1.add(pageHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 104, -1));

        MinimizeLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        MinimizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        MinimizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinimizeLabel.setText("-");
        MinimizeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        MinimizeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseClicked(evt);
            }
        });
        jPanel1.add(MinimizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 30, 40));

        txtUsername.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtUsername.setOpaque(false);
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 180, 20));

        txtPassword.setBackground(new java.awt.Color(0, 0, 0));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtPassword.setOpaque(false);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 180, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, 20));

        kButton2.setText("Login");
        kButton2.setkBackGroundColor(new java.awt.Color(255, 204, 0));
        kButton2.setkBorderRadius(30);
        kButton2.setkEndColor(new java.awt.Color(255, 204, 0));
        kButton2.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        kButton2.setkStartColor(new java.awt.Color(255, 204, 0));
        kButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton2MouseClicked(evt);
            }
        });
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 90, 30));

        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Forgot Password?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\chathu\\Pictures\\y.PNG")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 440, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignInLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInLabelMouseClicked

    }//GEN-LAST:event_SignInLabelMouseClicked

    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
     System.exit(0);
    }//GEN-LAST:event_CloseLabelMouseClicked

    private void pageHeadingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pageHeadingMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pageHeadingMouseClicked

    private void MinimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinimizeLabelMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         ForgotPassword fp = new ForgotPassword();
        fp.setVisible(true);
        fp.setLocationRelativeTo(null);
        fp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void kButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton2MouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
                    String username = txtUsername.getText();
        String password = txtPassword.getText();

        boolean isLogged;
        try {
            isLogged = new LoginFormController().
                    LoginAdmin(new AdministratorModel(username, password));
            
            if (isLogged) {
            JOptionPane.showMessageDialog(null, "Login Success");
            Form h = new Form();
            h.setVisible(true);
            this.dispose();
            h.setLocationRelativeTo(null);
            h.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed");
        }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JLabel MinimizeLabel;
    private javax.swing.JLabel SignInLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KButton kButton2;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
