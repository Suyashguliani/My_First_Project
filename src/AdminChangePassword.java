
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class AdminChangePassword extends javax.swing.JFrame {


    public AdminChangePassword() {
        initComponents();
        setSize(525, 340);
        
        setLocationRelativeTo(null);
        setTitle("Change password");
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pf1 = new javax.swing.JPasswordField();
        pf2 = new javax.swing.JPasswordField();
        pf3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("CHANGE YOUR PASSWORD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 20, 340, 30);

        jLabel2.setText("OLD PASSWORD : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 100, 114, 17);

        jLabel3.setText("NEW PASSWORD : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 150, 117, 17);

        jLabel4.setText("CONFIRM NEW PASSWORD :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 200, 190, 17);
        getContentPane().add(pf1);
        pf1.setBounds(280, 90, 180, 23);

        pf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf2ActionPerformed(evt);
            }
        });
        getContentPane().add(pf2);
        pf2.setBounds(280, 140, 180, 23);
        getContentPane().add(pf3);
        pf3.setBounds(280, 200, 180, 23);

        jButton1.setText("CHANGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 250, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String oldPassword = pf1.getText();
        String newPassword = pf2.getText();
        String confirmNewPassword = pf3.getText();
        
        String email = Global.adminemail;
        
        if(newPassword.equals(confirmNewPassword)){
            try{
            
                
                ResultSet rs = DBLoader.executeQuery("select * from admin where email = '"+email+"' and password = '"+oldPassword+"' " );
                if(rs.next())
                {
                    rs.updateString("password", newPassword);
                    rs.updateRow();
                    
                    JOptionPane.showMessageDialog(this, "Password Changed Succesfully");
                    
                    dispose();
                    AdminLogin obj = new AdminLogin();
                    
                    
                    
                    
                }else
                {
                    JOptionPane.showMessageDialog(this, "Incorrect Old Password");
                }
            
            
            }catch(Exception ex){
                    
                    
                    ex.printStackTrace();
            }
                    
            
            
        }else
        {
            JOptionPane.showMessageDialog(this, "New password and Confirmed password does not match");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf2ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pf1;
    private javax.swing.JPasswordField pf2;
    private javax.swing.JPasswordField pf3;
    // End of variables declaration//GEN-END:variables
}
