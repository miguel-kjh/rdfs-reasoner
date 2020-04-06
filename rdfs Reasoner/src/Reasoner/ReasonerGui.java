package Reasoner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReasonerGui extends javax.swing.JFrame {

    private final JFileChooser fileChooser;
    private File schema;
    private File data;
    private InferenceScraper resonator;
    
    public ReasonerGui() {
        fileChooser = new JFileChooser();
        resonator   = new InferenceScraper();
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Reasoner Rdfs");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeApplicationDialog();
            }
        });
        FileFilter filtro = new FileNameExtensionFilter("Turtel file", "ttl");
        fileChooser.addChoosableFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);
        buttonGroup.add(inferenceRadioButton);
        buttonGroup.add(violationsRadioButton);
    }
    
    private void closeApplicationDialog(){
        int res = JOptionPane.showConfirmDialog(this, "Do you want to exit the application?", 
                "Exit", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        buttonSchema = new javax.swing.JButton();
        schemaField = new javax.swing.JTextField();
        buttonData = new javax.swing.JButton();
        dataField = new javax.swing.JTextField();
        InferenceButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        violationsRadioButton = new javax.swing.JRadioButton();
        inferenceRadioButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Load File"));

        buttonSchema.setText("schema");
        buttonSchema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSchemaActionPerformed(evt);
            }
        });

        schemaField.setEditable(false);

        buttonData.setText("data");
        buttonData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataActionPerformed(evt);
            }
        });

        dataField.setEditable(false);

        InferenceButton.setText("Inference");
        InferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InferenceButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSchema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataField)
                    .addComponent(schemaField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InferenceButton)
                .addGap(18, 18, 18)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSchema)
                    .addComponent(schemaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonData)
                    .addComponent(dataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InferenceButton)
                    .addComponent(clearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose view"));

        violationsRadioButton.setText("See violations");
        violationsRadioButton.setEnabled(false);
        violationsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                violationsRadioButtonActionPerformed(evt);
            }
        });

        inferenceRadioButton.setText("See Inference");
        inferenceRadioButton.setEnabled(false);
        inferenceRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inferenceRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inferenceRadioButton)
                    .addComponent(violationsRadioButton))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inferenceRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(violationsRadioButton)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setAutoscrolls(false);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSchemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSchemaActionPerformed
        int res = fileChooser.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            schema = fileChooser.getSelectedFile();
            schemaField.setText(schema.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonSchemaActionPerformed

    private void buttonDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataActionPerformed
        int res = fileChooser.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            data = fileChooser.getSelectedFile();
            dataField.setText(data.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonDataActionPerformed

    private void InferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InferenceButtonActionPerformed
        if(data == null || schema == null){
            JOptionPane.showMessageDialog(this,
                    "You need load a file data and schema", 
                    "Error - Not Files", JOptionPane.ERROR_MESSAGE);
            return;
        }
        resonator.setFiles(schema, data);
        changeVisabilityOfRadioButtons(true);
    }//GEN-LAST:event_InferenceButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        data   = null;
        schema = null;
        dataField.setText("");
        schemaField.setText("");
        textArea.setText("");
        changeVisabilityOfRadioButtons(false);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void inferenceRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inferenceRadioButtonActionPerformed
        textArea.setText(resonator.getInference());
    }//GEN-LAST:event_inferenceRadioButtonActionPerformed

    private void violationsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_violationsRadioButtonActionPerformed
        textArea.setText(resonator.getViolations());
    }//GEN-LAST:event_violationsRadioButtonActionPerformed

    public void changeVisabilityOfRadioButtons(boolean visability){
        violationsRadioButton.setEnabled(visability);
        inferenceRadioButton.setEnabled(visability);
    }
    
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
            java.util.logging.Logger.getLogger(ReasonerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReasonerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReasonerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReasonerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReasonerGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InferenceButton;
    private javax.swing.JButton buttonData;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton buttonSchema;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField dataField;
    private javax.swing.JRadioButton inferenceRadioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField schemaField;
    private javax.swing.JTextArea textArea;
    private javax.swing.JRadioButton violationsRadioButton;
    // End of variables declaration//GEN-END:variables
}
