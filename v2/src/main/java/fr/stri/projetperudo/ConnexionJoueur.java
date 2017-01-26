package fr.stri.projetperudo;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor BONSOIR.
 */

/**
 *
 * @author Quizz
 */
public class ConnexionJoueur extends javax.swing.JFrame {

    /**
     * Creates new form ConnexionJoueur
     */
    public ConnexionJoueur() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameRejoindreCreerPartie = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nomPartie = new javax.swing.JTextField();
        nombreJoueurs = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        NomJoueur = new javax.swing.JTextField();
        ValideConnexionJoueur = new javax.swing.JButton();

        jButton1.setText("Rejoindre partie");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Créer partie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nomPartie.setText("Nom partie");
        nomPartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomPartieActionPerformed(evt);
            }
        });

        nombreJoueurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8" }));
        nombreJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJoueursActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setText("jFormattedTextField1");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrameRejoindreCreerPartieLayout = new javax.swing.GroupLayout(jFrameRejoindreCreerPartie.getContentPane());
        jFrameRejoindreCreerPartie.getContentPane().setLayout(jFrameRejoindreCreerPartieLayout);
        jFrameRejoindreCreerPartieLayout.setHorizontalGroup(
            jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                .addGroup(jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                        .addGroup(jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jButton1)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGroup(jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomPartie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(nombreJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jFrameRejoindreCreerPartieLayout.setVerticalGroup(
            jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomPartie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom du joueur");

        ValideConnexionJoueur.setText("Connexion");
        ValideConnexionJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValideConnexionJoueurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(NomJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(ValideConnexionJoueur)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ValideConnexionJoueur)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         String resultnomPartie = nomPartie.getText();
         int resultnombreJoueurs = nombreJoueurs.getItemCount();
        Joueurs cjoueurs = new Joueurs();
        cjoueurs.creerPartie(resultnomPartie, resultnombreJoueurs);
        JOptionPane.showMessageDialog(null, "Partie créée");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nomPartieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomPartieActionPerformed
        // TODO add your handling code here:
               

    }//GEN-LAST:event_nomPartieActionPerformed

    private void nombreJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreJoueursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreJoueursActionPerformed

    private void ValideConnexionJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValideConnexionJoueurActionPerformed
    String resultnomJoueur = NomJoueur.getText();
    
    //Partie connexionjoueur = new Partie();
    Joueurs validejoueur = new Joueurs(resultnomJoueur);
        
    //connexionjoueur.connexion(validejoueur);
    jFrameRejoindreCreerPartie.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_ValideConnexionJoueurActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String resultnomJoueur2 = NomJoueur.getText();
     Partie connexionjoueur = new Partie();
      connexionjoueur.connexion(validejoueur);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    InterfaceServCli recuplistepartie = new InterfaceServCli() {
        @Override
        public String CreerPartie(String nomPartie, Integer NbJoueur) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String SeConnecter(String nomJoueur) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String LanceDes(Integer Des) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ArrayList<Partie> getListePartie() throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
        try {
            ArrayList<Partie> listePartie = recuplistepartie.getListePartie();
            // TODO add your handling code here:
            
                            for(int i=0; i<listePartie.size();i++)
                            {
                                //jComboBox1.addItem(listePartie.get(i));
                            }

        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        InterfaceServCli recuplistepartie = new InterfaceServCli() {
        @Override
        public String CreerPartie(String nomPartie, Integer NbJoueur) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String SeConnecter(String nomJoueur) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String LanceDes(Integer Des) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ArrayList<Partie> getListePartie() throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
        
        ArrayList listeP = new ArrayList();
        try {
            listeP = recuplistepartie.getListePartie();
            for(int i=0; i<listeP.size();i++)
                            {
                                jComboBox1.addItem((String) listeP.get(i));
                            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConnexionJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnexionJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnexionJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnexionJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionJoueur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NomJoueur;
    private javax.swing.JButton ValideConnexionJoueur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFrame jFrameRejoindreCreerPartie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nomPartie;
    private javax.swing.JComboBox<String> nombreJoueurs;
    // End of variables declaration//GEN-END:variables
}
