/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Conexion.ConexionBD;
import Conexion.CuentaCliente;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author JDSan
 */
public class Transaccion extends javax.swing.JFrame {
    private int idCuenta;
    private ConexionBD conexion;
    private ClienteDAO clienteDAO;
    private CuentaCliente cuentaCliente;
    
    
    /**
     * Método constructor del formulario para las transacciones
     * @param idCuenta ID de la cuenta que transferirá
     * @param conexion Conexión con la base de datos
     */
    public Transaccion(int idCuenta, ConexionBD conexion) 
    {
        initComponents();
        this.idCuenta=idCuenta;
        this.conexion=conexion;
        clienteDAO = new ClienteDAO(conexion);
        cuentaCliente = clienteDAO.consultarPorId(idCuenta);        
        
        lblDinero.setText("Su saldo es de: "+cuentaCliente.getSaldo());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDinero = new javax.swing.JLabel();
        txtTransferir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBeneficiario = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDinero.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        txtTransferir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTransferirKeyTyped(evt);
            }
        });

        jLabel1.setText("Cantidad a transferir");

        jLabel2.setText("ID de beneficiario");

        txtBeneficiario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBeneficiarioKeyTyped(evt);
            }
        });

        btnVerificar.setText("Verificar datos");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTransferir)
                    .addComponent(jLabel2)
                    .addComponent(txtBeneficiario))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnVerificar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBeneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnVerificar)
                .addGap(9, 9, 9)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed

        
        int trasnferencia = Integer.parseInt(txtTransferir.getText());
        int idTransferencia = cuentaCliente.getIdCuenta();
        int idTransferido = Integer.parseInt(txtBeneficiario.getText());
        int resultado = clienteDAO.transferencia(trasnferencia, idTransferencia, idTransferido);
        if(resultado>=0)
        {
            JOptionPane.showMessageDialog(null, "Transacción realizada con éxito!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Hubo un error con los datos");
        }
        
        
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void txtTransferirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTransferirKeyTyped
       
        char c = evt.getKeyChar();
        if(c<'0'|| c>'9')evt.consume();
        
        
    }//GEN-LAST:event_txtTransferirKeyTyped

    private void txtBeneficiarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBeneficiarioKeyTyped

               
        char c = evt.getKeyChar();
        if(c<'0'|| c>'9')evt.consume();
        
    }//GEN-LAST:event_txtBeneficiarioKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        this.setVisible(false);
        InterfazCuenta ic = new InterfazCuenta(this.idCuenta,this.conexion);
        ic.setVisible(true);
        
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JTextField txtBeneficiario;
    private javax.swing.JTextField txtTransferir;
    // End of variables declaration//GEN-END:variables
}