package quiz;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Item extends javax.swing.JPanel {

    private int selectedItemId;
    private double selectedItemPrice;

    public Item() {
        initComponents();
    }

    private void updateTotalBelanja() {
        double total = 0;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            total += Double.parseDouble(model.getValueAt(i, 4).toString().replace("Rp. ", "").replace(",", ""));
        }
        hargaTotalBelanja.setText("Rp. " + total);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputItem = new javax.swing.JTextField();
        inputQty = new javax.swing.JTextField();
        cariItem = new javax.swing.JButton();
        btnTambahItem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namaItem = new javax.swing.JLabel();
        ukuran = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        subTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        hargaTotalBelanja = new javax.swing.JLabel();
        btnBayar = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Penjualan"));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 400));

        jLabel1.setText("Item : ");

        inputItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputItemActionPerformed(evt);
            }
        });

        inputQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputQtyActionPerformed(evt);
            }
        });

        cariItem.setText("Cari");
        cariItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariItemActionPerformed(evt);
            }
        });

        btnTambahItem.setText("Tambah Item");
        btnTambahItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahItemActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Item :");

        jLabel3.setText("Ukuran : ");

        jLabel4.setText("Harga :");

        jLabel5.setText("Qty : ");

        jLabel6.setText("Total : ");

        namaItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        namaItem.setText("-");

        ukuran.setText("-");

        harga.setText("Rp. 0");

        subTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        subTotal.setText("Rp. 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(inputItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cariItem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTambahItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputQty)
                            .addComponent(harga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ukuran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cariItem))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaItem))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ukuran))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(harga))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(subTotal))
                .addGap(18, 18, 18)
                .addComponent(btnTambahItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Barang Belanjaan"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Item Id", "Nama Item", "Qty", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total Belanja :");

        hargaTotalBelanja.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hargaTotalBelanja.setText("Rp. 0");

        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(132, 132, 132))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(hargaTotalBelanja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(hargaTotalBelanja))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputItemActionPerformed
    }//GEN-LAST:event_inputItemActionPerformed

    private void inputQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputQtyActionPerformed
    }//GEN-LAST:event_inputQtyActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        double totalHarga = Double.parseDouble(hargaTotalBelanja.getText().replace("Rp. ", "").replace(",", ""));
        try (Connection conn = Database.getConnection()) {
            String queryPenjualan = "INSERT INTO penjualan (tanggal, jumlah_transaksi, total_harga) VALUES (NOW(), ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(queryPenjualan, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, jTable1.getRowCount());
                stmt.setDouble(2, totalHarga);
                stmt.executeUpdate();

                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idPenjualan = generatedKeys.getInt(1);

                    for (int i = 0; i < jTable1.getRowCount(); i++) {
                        int idBarang = (int) jTable1.getValueAt(i, 1);
                        int qty = (int) jTable1.getValueAt(i, 3);
                        double subtotal = Double.parseDouble(jTable1.getValueAt(i, 4).toString().replace("Rp. ", "").replace(",", ""));

                        String queryDetail = "INSERT INTO penjualan_detail (id_penjualan, id_barang, qty, subtotal) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement stmtDetail = conn.prepareStatement(queryDetail)) {
                            stmtDetail.setInt(1, idPenjualan);
                            stmtDetail.setInt(2, idBarang);
                            stmtDetail.setInt(3, qty);
                            stmtDetail.setDouble(4, subtotal);
                            stmtDetail.executeUpdate();
                        }
                    }

                    JOptionPane.showMessageDialog(this, "Transaksi Berhasil!");

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        inputItem.setText("");
        inputQty.setText("");

        namaItem.setText("-");
        ukuran.setText("-");
        harga.setText("Rp. 0");
        subTotal.setText("Rp. 0");

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        hargaTotalBelanja.setText("Rp. 0");

    }//GEN-LAST:event_btnBatalActionPerformed

    private void cariItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariItemActionPerformed
        String keyword = inputItem.getText().trim();
        if (!keyword.isEmpty()) {
            try (Connection conn = Database.getConnection()) {
                String query = "SELECT * FROM barang WHERE id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1,keyword);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        namaItem.setText(rs.getString("nama"));
                        ukuran.setText(rs.getString("ukuran"));
                        harga.setText("Rp. " + rs.getDouble("harga"));
                        selectedItemId = rs.getInt("id");
                        selectedItemPrice = rs.getDouble("harga");
                    } else {
                        JOptionPane.showMessageDialog(this, "Barang tidak ditemukan!");
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_cariItemActionPerformed

    private void btnTambahItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahItemActionPerformed
        int qty = Integer.parseInt(inputQty.getText().trim());
        double subtotal = qty * selectedItemPrice;

        subTotal.setText(String.valueOf(subtotal));

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            model.getRowCount() + 1,
            selectedItemId,
            namaItem.getText(),
            qty,
            "Rp. " + subtotal
        });

        updateTotalBelanja();
    }//GEN-LAST:event_btnTambahItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnTambahItem;
    private javax.swing.JButton cariItem;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel hargaTotalBelanja;
    private javax.swing.JTextField inputItem;
    private javax.swing.JTextField inputQty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel namaItem;
    private javax.swing.JLabel subTotal;
    private javax.swing.JLabel ukuran;
    // End of variables declaration//GEN-END:variables
}
