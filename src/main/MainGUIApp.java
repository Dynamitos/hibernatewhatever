package main;

import baseUtility.ListModelBase;
import db.KontoDb;
import dbUtility.DBConnector;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import pojo.Buchung;
import pojo.Konto;
import resourcen.BuchungEnum;
import resourcen.KontoEnum;

public class MainGUIApp extends javax.swing.JFrame {

    private ListModelBase<Konto> kontoModel;
    private ListModelBase<Buchung> buchungModel;
    private KontoDb kontoDb;

    public MainGUIApp() {
        String status = "GUT Main Konstruktor";

        try {
            DBConnector.getInstance().initDb();
            kontoModel = new ListModelBase<>();
            buchungModel = new ListModelBase<>();
            kontoDb = new KontoDb();
            initComponents();
            liKonten.setModel(kontoModel);
            lKontoSpalten.setText(KontoEnum.getSpalten('|'));
            lBuchungSpalten.setText(BuchungEnum.getSpalten());
        } catch (Exception e) {
            showMessage(status, e, true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liKonten = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        liBuchungen = new javax.swing.JList();
        lKontoSpalten = new javax.swing.JLabel();
        lBuchungSpalten = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        cbBuchungen = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        tfAbfrage1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        tfAbfrage2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Konto & Buchungen");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DB Operationen"));
        jPanel3.setLayout(new java.awt.GridLayout(2, 3));

        jButton1.setText("Add Testdata");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAddTestdaten(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton3.setText("Delete Konto");
        jPanel3.add(jButton3);

        jButton4.setText("Change Konto");
        jPanel3.add(jButton4);

        jButton9.setText("Clear All");
        jPanel3.add(jButton9);

        jButton10.setText("Delete Buchung");
        jPanel3.add(jButton10);

        jButton11.setText("Change Buchung");
        jPanel3.add(jButton11);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(132, 132));

        liKonten.setBorder(javax.swing.BorderFactory.createTitledBorder("Konten"));
        liKonten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onKontoSelected(evt);
            }
        });
        jScrollPane1.setViewportView(liKonten);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(232, 132));

        liBuchungen.setBorder(javax.swing.BorderFactory.createTitledBorder("Buchungen"));
        jScrollPane2.setViewportView(liBuchungen);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        lKontoSpalten.setText("KontoSpalten");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(lKontoSpalten, gridBagConstraints);

        lBuchungSpalten.setText("BuchungSpalten");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(lBuchungSpalten, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter & Abfragen"));
        jPanel2.setLayout(new java.awt.GridLayout(5, 2));

        jButton2.setText("Alle Buchungen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAlleBuchungen(evt);
            }
        });
        jPanel2.add(jButton2);

        jPanel2.add(cbBuchungen);

        jButton8.setText("Alle Konten");
        jPanel2.add(jButton8);

        jButton5.setText("Abfrage 1");
        jPanel2.add(jButton5);

        jButton6.setText("Abfrage 2");
        jPanel2.add(jButton6);

        tfAbfrage1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfAbfrage1.setText("1000");
        jPanel2.add(tfAbfrage1);

        jButton7.setText("Abfrage 3");
        jPanel2.add(jButton7);

        tfAbfrage2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfAbfrage2.setText("1000");
        jPanel2.add(tfAbfrage2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));
        jPanel4.add(lStatus);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMessage(String status, Exception e, boolean trace) {
        if (trace) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, e.getMessage(), status, JOptionPane.ERROR_MESSAGE);
    }
    private void onAddTestdaten(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAddTestdaten
        String status = "Add Testdaten";
        try {
            kontoDb.addTestdaten();
            kontoModel.setListe(kontoDb.read());
        } catch (Exception e) {
            showMessage(status, e, true);
        }
    }//GEN-LAST:event_onAddTestdaten

    private void onKontoSelected(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onKontoSelected
        Konto k = (Konto) liKonten.getSelectedValue();
        List<Buchung> buchungen = new ArrayList<>(k.getBuchungen());
        buchungModel.setListe(buchungen);
        liBuchungen.setModel(buchungModel);
    }//GEN-LAST:event_onKontoSelected

    private void onAlleBuchungen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAlleBuchungen
        cbBuchungen.removeAllItems();
        for (Konto k : kontoModel.getListe()) {
            for (Buchung b : k.getBuchungen()) {
                cbBuchungen.addItem(b.getText());
            }
        }
    }//GEN-LAST:event_onAlleBuchungen

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
            java.util.logging.Logger.getLogger(MainGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUIApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbBuchungen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lBuchungSpalten;
    private javax.swing.JLabel lKontoSpalten;
    private javax.swing.JLabel lStatus;
    private javax.swing.JList liBuchungen;
    private javax.swing.JList liKonten;
    private javax.swing.JTextField tfAbfrage1;
    private javax.swing.JTextField tfAbfrage2;
    // End of variables declaration//GEN-END:variables
}
