/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundry;

import Controller.Base_Cluster;
import Controller.DokumenManager;
import Controller.Model_Manager;
import Controller.Pre_Processing_Manager;
import Model.Model_Trending;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author rizagamal
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    ArrayList<String> data = new ArrayList<>();

    public MainForm() {
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

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trending_text = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        file_text = new javax.swing.JTextField();
        open_file = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        log_text = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        proses = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trending Topic List", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));
        jPanel1.setFocusable(false);
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.setLayout(new java.awt.CardLayout());

        trending_text.setEditable(false);
        trending_text.setColumns(20);
        trending_text.setLineWrap(true);
        trending_text.setRows(5);
        trending_text.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        trending_text.setFocusable(false);
        jScrollPane1.setViewportView(trending_text);

        jPanel1.add(jScrollPane1, "card2");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Your Folder Path Here");

        file_text.setEditable(false);
        file_text.setEnabled(false);

        open_file.setText("Open");
        open_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_fileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(file_text, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(open_file, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file_text, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open_file, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));
        jPanel2.setLayout(new java.awt.CardLayout());

        log_text.setEditable(false);
        log_text.setColumns(20);
        log_text.setRows(5);
        log_text.setAutoscrolls(false);
        log_text.setEnabled(false);
        log_text.setFocusable(false);
        jScrollPane2.setViewportView(log_text);

        jPanel2.add(jScrollPane2, "card2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Trending Topic");

        proses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        proses.setText("Process");
        proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(proses, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(proses, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesActionPerformed
        // TODO add your handling code here:
        //measuring time execution
        long startTime = System.nanoTime();
        trending_text.selectAll();
        trending_text.replaceSelection("");
        //Preparation Dokumen
        DokumenManager dokumenManager = new DokumenManager();
        ArrayList <String> tempContent = new ArrayList<>();
        ArrayList <String> stemming_manager = new ArrayList<>();
        ArrayList <ArrayList> tempPreprocessing = new ArrayList<>();
        
        System.out.println("data.dokumen = " + data.size());
        for (int i = 0; i < data.size(); i++) {
            try {
//                contens = contens + dokumenManager.get_data(data.get(i));
                  tempContent.add(dokumenManager.get_data(data.get(i)));
                } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
             //Praprocessing Section
                String dokumen = tempContent.get(i);
                Pre_Processing_Manager pre_Processing_Manager = new Pre_Processing_Manager();
                ArrayList<String> tokenization_manager = pre_Processing_Manager.tokenization_manager(dokumen);
                ArrayList<String> casefolding_manager = pre_Processing_Manager.casefolding_manager(tokenization_manager);
                ArrayList<String> stopword_removal_manager = pre_Processing_Manager.stopword_removal_manager(casefolding_manager);

            //Stemming Section
                try {
                    stemming_manager = pre_Processing_Manager.stemming_manager(stopword_removal_manager);
                } catch (IOException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                tempPreprocessing.add(stemming_manager);
        }

        //Identifikasi Base Cluster
        Base_Cluster base_Cluster = new Base_Cluster();
        
        //Create Suffix Tree
        ArrayList<ArrayList> sufix = base_Cluster.sufix(tempPreprocessing);
        System.out.println("phrase = " + sufix.size());
        ArrayList<String> node = base_Cluster.parentWord(sufix);
        System.out.println("node = " + node.size());
        base_Cluster.children(node, sufix);

        //Scoring Cluster
        ArrayList<ArrayList> document = base_Cluster.getdocumentCount();
        ArrayList<Integer> jumlah = base_Cluster.jumlah_suffix(document);

        ArrayList<Integer> score = base_Cluster.score_safikstree(node, jumlah);

        //Modeling Trending Topic
        Model_Manager model_Manager = new Model_Manager();
        ArrayList<Model_Trending> model_trending = model_Manager.make_model(node, score, jumlah);
        System.out.println("Score Sorting:");
        Collections.sort(model_trending, Model_Trending.Score_Safiks);
        for (int i = 0; i < 7; i++) {
            trending_text.append(i + 1 + ". " + model_trending.get(i).getTrending() + "\n");
            log_text.append(model_trending.get(i).toString() + "\n");
        }
        for (Model_Trending str : model_trending) {
            System.out.println(str);
        }

        //endtime
        long stopTime = System.nanoTime();
        System.out.println("Waktu = " + ((stopTime - startTime) / 1000000000) + "detik");
    }//GEN-LAST:event_prosesActionPerformed

    private void open_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_fileActionPerformed
        // TODO add your handling code here:
        data.clear();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Pilih Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file_text.setText(chooser.getSelectedFile().toString());
            File folder = new File(chooser.getSelectedFile().toString());
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt")) {

                    data.add(chooser.getSelectedFile().toString() + "/" + listOfFiles[i].getName());

                }
            }
        } else {
            System.out.println("No Selection ");
        }
        log_text.append("Load Data Selesai" + "\n");
    }//GEN-LAST:event_open_fileActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField file_text;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea log_text;
    private javax.swing.JButton open_file;
    private javax.swing.JButton proses;
    private javax.swing.JTextArea trending_text;
    // End of variables declaration//GEN-END:variables
}