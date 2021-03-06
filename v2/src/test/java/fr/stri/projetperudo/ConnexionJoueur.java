package fr.stri.projetperudo;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
    //InterfaceServCli proxy = new Serveur();
    public static void ProxyRMI()
    {
        try {           
            Serveur proxy = (Serveur) Naming.lookup("rmi://localhost:1099/MonServeur");
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
Joueurs envoijoueur;

public void envoiJoueur(String j) 
{
        try {
            Joueurs validejoueur = new Joueurs(j);
            envoijoueur = validejoueur;
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
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

        jFrameRejoindreCreerPartie = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        nomPartie = new javax.swing.JTextField();
        nombreJoueurs = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NomJoueur = new javax.swing.JTextField();
        ValideConnexionJoueur = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Rejoindre partie");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nomPartie.setText("chat");
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

        jButton2.setText("Créer partie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom de la partie");

        jLabel3.setText("Nombre de joueurs");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(nomPartie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomPartie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreJoueurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrameRejoindreCreerPartieLayout = new javax.swing.GroupLayout(jFrameRejoindreCreerPartie.getContentPane());
        jFrameRejoindreCreerPartie.getContentPane().setLayout(jFrameRejoindreCreerPartieLayout);
        jFrameRejoindreCreerPartieLayout.setHorizontalGroup(
            jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jFrameRejoindreCreerPartieLayout.setVerticalGroup(
            jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameRejoindreCreerPartieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrameRejoindreCreerPartieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
         
         /* TEMPORAIRE
         int resultnombreJoueurs = nombreJoueurs.getSelectedIndex();
         
         */ int resultnombreJoueurs = 2;
         
         
         
                    Serveur proxy = null;
        try {
            proxy = (Serveur) Naming.lookup("rmi://localhost:1099/MonServeur");
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //String returncreerpartie = creerpartie.proxy.CreerPartie(resultnomPartie, resultnombreJoueurs);
            System.out.println(proxy.creerPartie(resultnomPartie,resultnombreJoueurs));
            //ProxyRMI();
            //JOptionPane.showMessageDialog(null, returncreerpartie);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
    envoiJoueur(resultnomJoueur);
        System.out.println(envoijoueur);    //connexionjoueur.connexion(validejoueur);
    jFrameRejoindreCreerPartie.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_ValideConnexionJoueurActionPerformed

    public JButton getValideConnexionJoueur() {
        return ValideConnexionJoueur;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     //String resultnomJoueur2 = NomJoueur.getText();
    String resultNomPartie = "Chat";//(String) jComboBox1.getSelectedItem();
    String retour;

     
     Serveur proxy = null;
        try {
            proxy = (Serveur) Naming.lookup("rmi://localhost:1099/MonServeur");
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
        
            retour = proxy.connexionAunePartie(envoijoueur, resultNomPartie);
            System.out.println(retour);
            JoueurInterface.main(envoijoueur, resultNomPartie);
            
// TODO add your handling code here:
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
   Serveur proxy = null;
        try {
            proxy = (Serveur) Naming.lookup("rmi://localhost:1099/MonServeur");
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
       
              
        
        ArrayList listeP = new ArrayList();
        try {
            ArrayList<Partie> recuplistePartie = proxy.getListePartie();
            listeP = recuplistePartie;
            String nomPartie;
                     // TODO add your handling code here:
                            for(int i=0; i<listeP.size();i++)
                            {
                                jComboBox1.addItem((String) proxy.getNomPartieRMI(i));
                                System.out.println(proxy.getNomPartieRMI(i));
                            }

        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
                ProxyRMI();               

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NomJoueur;
    private javax.swing.JButton ValideConnexionJoueur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFrame jFrameRejoindreCreerPartie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nomPartie;
    private javax.swing.JComboBox<String> nombreJoueurs;
    // End of variables declaration//GEN-END:variables
}
