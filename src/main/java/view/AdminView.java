/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import modul.NguoiDung;

/**
 *
 * @author admin
 */
public class AdminView extends javax.swing.JFrame {
    private NguoiDung ng;
    /**
     * Creates new form AdminView
     */
    public AdminView() {
        initComponents();
    }
    
    public AdminView(NguoiDung ng){
        this.ng = ng;
        initComponents();
        System.out.println(ng);
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
        jPanel2 = new javax.swing.JPanel();
        btn_thongke = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_profile = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mn_coso = new javax.swing.JMenuItem();
        mn_cuahang = new javax.swing.JMenuItem();
        mn_chucvu = new javax.swing.JMenuItem();
        mn_dangki = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mn_hang = new javax.swing.JMenuItem();
        mn_mausac = new javax.swing.JMenuItem();
        mn_dungluong = new javax.swing.JMenuItem();
        mn_baohanh = new javax.swing.JMenuItem();
        mn_dongsp = new javax.swing.JMenuItem();
        mn_loaisp = new javax.swing.JMenuItem();
        mn_chitietsp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jPanel2.setBackground(new java.awt.Color(204, 255, 51));

        btn_thongke.setBackground(new java.awt.Color(255, 204, 204));
        btn_thongke.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_thongke.setForeground(new java.awt.Color(255, 51, 0));
        btn_thongke.setText("Thống kê");

        btn_logout.setBackground(new java.awt.Color(255, 204, 204));
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 0, 0));
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_profile.setBackground(new java.awt.Color(255, 204, 204));
        btn_profile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_profile.setForeground(new java.awt.Color(255, 51, 0));
        btn_profile.setText("Profile");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btn_thongke)
                .addGap(43, 43, 43)
                .addComponent(btn_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thongke)
                    .addComponent(btn_logout)
                    .addComponent(btn_profile))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 102));
        jMenuBar1.setForeground(new java.awt.Color(255, 0, 0));

        jMenu1.setText("Hệ thống phân cấp");

        mn_coso.setText("Cơ sở");
        mn_coso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_cosoActionPerformed(evt);
            }
        });
        jMenu1.add(mn_coso);

        mn_cuahang.setText("Cửa hàng");
        mn_cuahang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_cuahangActionPerformed(evt);
            }
        });
        jMenu1.add(mn_cuahang);

        mn_chucvu.setText("Chức vụ");
        mn_chucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_chucvuActionPerformed(evt);
            }
        });
        jMenu1.add(mn_chucvu);

        mn_dangki.setText("Đăng ký thành viên");
        mn_dangki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_dangkiActionPerformed(evt);
            }
        });
        jMenu1.add(mn_dangki);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Thông tin sản phẩm");

        mn_hang.setText("Hãng");
        mn_hang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_hangActionPerformed(evt);
            }
        });
        jMenu3.add(mn_hang);

        mn_mausac.setText("Màu sắc");
        mn_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_mausacActionPerformed(evt);
            }
        });
        jMenu3.add(mn_mausac);

        mn_dungluong.setText("Dung lượng");
        mn_dungluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_dungluongActionPerformed(evt);
            }
        });
        jMenu3.add(mn_dungluong);

        mn_baohanh.setText("Bảo hành");
        mn_baohanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_baohanhActionPerformed(evt);
            }
        });
        jMenu3.add(mn_baohanh);

        mn_dongsp.setText("Dòng sản phẩm");
        mn_dongsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_dongspActionPerformed(evt);
            }
        });
        jMenu3.add(mn_dongsp);

        mn_loaisp.setText("Loại sản phẩm");
        mn_loaisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_loaispActionPerformed(evt);
            }
        });
        jMenu3.add(mn_loaisp);

        mn_chitietsp.setText("Chi tiết sản phẩm");
        mn_chitietsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_chitietspActionPerformed(evt);
            }
        });
        jMenu3.add(mn_chitietsp);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

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

    private void mn_cosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_cosoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new CoSoView().setVisible(true);
    }//GEN-LAST:event_mn_cosoActionPerformed

    private void mn_dungluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_dungluongActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DungLuongView().setVisible(true);
    }//GEN-LAST:event_mn_dungluongActionPerformed

    private void mn_loaispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_loaispActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LoaiSpView().setVisible(true);
    }//GEN-LAST:event_mn_loaispActionPerformed

    private void mn_chucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_chucvuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ChucVuView().setVisible(true);
    }//GEN-LAST:event_mn_chucvuActionPerformed

    private void mn_baohanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_baohanhActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new BaoHanhView().setVisible(true);
    }//GEN-LAST:event_mn_baohanhActionPerformed

    private void mn_cuahangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_cuahangActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new CuaHangView().setVisible(true);
    }//GEN-LAST:event_mn_cuahangActionPerformed

    private void mn_dangkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_dangkiActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DangKyView().setVisible(true);
    }//GEN-LAST:event_mn_dangkiActionPerformed

    private void mn_hangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_hangActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new HangView().setVisible(true);
    }//GEN-LAST:event_mn_hangActionPerformed

    private void mn_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_mausacActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MauSacView().setVisible(true);
    }//GEN-LAST:event_mn_mausacActionPerformed

    private void mn_dongspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_dongspActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DongSPView().setVisible(true);
    }//GEN-LAST:event_mn_dongspActionPerformed

    private void mn_chitietspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_chitietspActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ChiTietSPView().setVisible(true);
    }//GEN-LAST:event_mn_chitietspActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DangNhapView().setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_profile;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem mn_baohanh;
    private javax.swing.JMenuItem mn_chitietsp;
    private javax.swing.JMenuItem mn_chucvu;
    private javax.swing.JMenuItem mn_coso;
    private javax.swing.JMenuItem mn_cuahang;
    private javax.swing.JMenuItem mn_dangki;
    private javax.swing.JMenuItem mn_dongsp;
    private javax.swing.JMenuItem mn_dungluong;
    private javax.swing.JMenuItem mn_hang;
    private javax.swing.JMenuItem mn_loaisp;
    private javax.swing.JMenuItem mn_mausac;
    // End of variables declaration//GEN-END:variables
}
