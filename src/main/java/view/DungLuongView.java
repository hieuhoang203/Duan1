/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modul.DungLuong;
import service.QuanLyDungLuongService;
import service.serviceImpl.DungLuongServiceImpl;

/**
 *
 * @author admin
 */
public class DungLuongView extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private QuanLyDungLuongService quanLyDungLuongService = new DungLuongServiceImpl();

    /**
     * Creates new form DungLuongView
     */
    public DungLuongView() {
        initComponents();
        addRows();
    }

    public void addRows() {
        tableModel = (DefaultTableModel) tb_list.getModel();
        tableModel.setRowCount(0);
        for (DungLuong dungLuong : quanLyDungLuongService.select()) {
            tableModel.addRow(new Object[]{
                dungLuong.getId(),
                dungLuong.getMa(),
                dungLuong.getTen()
            });
        }
    }

    public void fillData(int row) {
        txt_id.setText(tb_list.getValueAt(row, 0).toString());
        txt_ma.setText(tb_list.getValueAt(row, 1).toString());
        txt_ten.setText(tb_list.getValueAt(row, 2).toString());
    }

    public void clear() {
        txt_id.setText("");
        txt_ma.setText("");
        txt_ten.setText("");
    }

    public DungLuong create() {
        return new DungLuong(null, txt_ma.getText().trim(), txt_ten.getText().trim(), 1, null, null, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_list = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dung lượng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Dung Lượng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Id:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Mã:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Tên:");

        txt_id.setEditable(false);

        tb_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_list);

        btn_them.setBackground(new java.awt.Color(204, 255, 204));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 0, 0));
        btn_them.setText("Thêm");
        btn_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themMouseClicked(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(204, 255, 204));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 0, 0));
        btn_sua.setText("Sửa");
        btn_sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_suaMouseClicked(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(204, 255, 204));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 0, 0));
        btn_xoa.setText("Xóa");
        btn_xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoaMouseClicked(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(204, 255, 204));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 0, 0));
        btn_clear.setText("Clear");
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clearMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_clear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themMouseClicked
        // TODO add your handling code here:
        if (quanLyDungLuongService.insert(create())) {
            addRows();
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !");
            clear();
        } else {
            if (!quanLyDungLuongService.checkMa(create())) {
                JOptionPane.showMessageDialog(rootPane, "Mã bị trùng !");
            } else {
                if (create().getMa().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Mã bị trống !");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tên bị trống !");
                }
            }
        }
    }//GEN-LAST:event_btn_themMouseClicked

    private void btn_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suaMouseClicked
        // TODO add your handling code here:
        int row = tb_list.getSelectedRow();
        if (row<0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn bản ghi !");
        } else {
            Integer id = (Integer) tb_list.getValueAt(row, 0);
            if (quanLyDungLuongService.update(id, create())) {
                addRows();
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                clear();
            } else {
                if (create().getMa().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Mã bị trống !");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tên bị trống !");
                }
            }
        }
    }//GEN-LAST:event_btn_suaMouseClicked

    private void btn_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoaMouseClicked
        // TODO add your handling code here:
        int row = tb_list.getSelectedRow();
        if (row<0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn bản ghi !");
        } else {
            Integer id = (Integer) tb_list.getValueAt(row, 0);
            int choose = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa ?");
            if (choose == JOptionPane.YES_OPTION) {
                quanLyDungLuongService.delete(id);
                addRows();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công !");
                clear();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hủy xóa !");
                clear();
            }
        }
    }//GEN-LAST:event_btn_xoaMouseClicked

    private void tb_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listMouseClicked
        // TODO add your handling code here:
        int row = tb_list.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tb_listMouseClicked

    private void btn_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseClicked
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clearMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new AdminView().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(DungLuongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DungLuongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DungLuongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DungLuongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DungLuongView().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_list;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
