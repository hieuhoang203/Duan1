/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modul.ChiTietSP;
import modul.CuaHang;
import modul.DongSp;
import modul.DungLuong;
import modul.MauSac;
import service.QuanLyChiTietSPService;
import service.QuanLyCuaHangService;
import service.QuanLyDongSPService;
import service.QuanLyDungLuongService;
import service.QuanLyMauSacService;
import service.serviceImpl.ChiTietSpServiceImpl;
import service.serviceImpl.CuaHangServiceImpl;
import service.serviceImpl.DongSpServiceImpl;
import service.serviceImpl.DungLuongServiceImpl;
import service.serviceImpl.MauSacServiceImpl;

/**
 *
 * @author admin
 */
public class ChiTietSPView extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private DefaultComboBoxModel cbxDongSp;
    private DefaultComboBoxModel cbxMauSac;
    private DefaultComboBoxModel cbxDungLuong;
    private DefaultComboBoxModel cbxCuaHang;
    private QuanLyDongSPService dongSpServiceImpl = new DongSpServiceImpl();
    private QuanLyMauSacService mauSacServiceImpl = new MauSacServiceImpl();
    private QuanLyDungLuongService dungLuongServiceImpl = new DungLuongServiceImpl();
    private QuanLyCuaHangService cuaHangServiceImpl = new CuaHangServiceImpl();
    private QuanLyChiTietSPService chiTietSPService = new ChiTietSpServiceImpl();
    private static long number = 0;

    /**
     * Creates new form ChiTietSPView
     */
    public ChiTietSPView() {
        initComponents();
        addCbxDongSp();
        addCbxMauSac();
        addCbxDungLuong();
        addCbxCuaHang();
        addTrangThai();
        addRows(chiTietSPService.select());
    }

    public void addTrangThai() {
        ButtonGroup group = new ButtonGroup();
        group.add(rd_chuaban);
        group.add(rd_daban);
    }

    public void addCbxDongSp() {
        cbxDongSp = (DefaultComboBoxModel) cbx_dongsp.getModel();
        cbxDongSp.addAll(dongSpServiceImpl.select());
        cbx_dongsp.setSelectedIndex(0);
    }

    public void addCbxMauSac() {
        cbxMauSac = (DefaultComboBoxModel) cbx_mausac.getModel();
        cbxMauSac.addAll(mauSacServiceImpl.select());
        cbx_mausac.setSelectedIndex(0);
    }

    public void addCbxDungLuong() {
        cbxDungLuong = (DefaultComboBoxModel) cbx_dungluong.getModel();
        cbxDungLuong.addAll(dungLuongServiceImpl.select());
        cbx_dungluong.setSelectedIndex(0);
    }

    public void addCbxCuaHang() {
        cbxCuaHang = (DefaultComboBoxModel) cbx_cuahang.getModel();
        cbxCuaHang.addAll(cuaHangServiceImpl.select());
        cbx_cuahang.setSelectedIndex(0);
    }

    public void addRows(ArrayList<ChiTietSP> list) {
        tableModel = (DefaultTableModel) tb_list.getModel();
        tableModel.setRowCount(0);
        for (ChiTietSP chiTietSP : list) {
            tableModel.addRow(new Object[]{
                chiTietSP.getId(),
                chiTietSP.getIdDongSp(),
                chiTietSP.getIdMauSac(),
                chiTietSP.getIdDungLuong(),
                chiTietSP.getIdCuaHang(),
                chiTietSP.getNgayThem(),
                chiTietSP.getNgaySua(),
                chiTietSP.getSoLuong(),
                chiTietSP.getTrangThai()
            });
        }
    }

    public void fillData(int row) {
        cbxDongSp = (DefaultComboBoxModel) cbx_dongsp.getModel();
        cbxMauSac = (DefaultComboBoxModel) cbx_mausac.getModel();
        cbxDungLuong = (DefaultComboBoxModel) cbx_dungluong.getModel();
        cbxCuaHang = (DefaultComboBoxModel) cbx_cuahang.getModel();
        txt_id.setText(tb_list.getValueAt(row, 0).toString());
        cbxDongSp.setSelectedItem(tb_list.getValueAt(row, 1));
        cbxMauSac.setSelectedItem(tb_list.getValueAt(row, 2));
        cbxDungLuong.setSelectedItem(tb_list.getValueAt(row, 3));
        cbxCuaHang.setSelectedItem(tb_list.getValueAt(row, 4));
        txt_ngaythem.setText(tb_list.getValueAt(row, 5).toString());
        try {
            txt_ngaysua.setText(tb_list.getValueAt(row, 6).toString());
        } catch (Exception e) {
            txt_ngaysua.setText("");
        }
        txt_soluong.setText(tb_list.getValueAt(row, 7).toString());
        if (Integer.parseInt(tb_list.getValueAt(row, 8).toString()) == 1) {
            rd_chuaban.setSelected(true);
        } else {
            rd_chuaban.setSelected(true);
        }
    }

    public void clear() {
        ButtonGroup group = new ButtonGroup();
        group.add(rd_chuaban);
        group.add(rd_daban);
        txt_id.setText("");
        cbx_dongsp.setSelectedIndex(0);
        cbx_mausac.setSelectedIndex(0);
        cbx_dungluong.setSelectedIndex(0);
        cbx_cuahang.setSelectedIndex(0);
        txt_ngaythem.setText("");
        txt_ngaysua.setText("");
        txt_soluong.setText("");
        group.clearSelection();
        addRows(chiTietSPService.select());
    }

    public ChiTietSP create() {
        if (rd_chuaban.isSelected() == true) {
            ChiTietSP ctsp = new ChiTietSP(null, (DongSp) cbx_dongsp.getSelectedItem(),
                    (MauSac) cbx_mausac.getSelectedItem(),
                    (DungLuong) cbx_dungluong.getSelectedItem(),
                    (CuaHang) cbx_cuahang.getSelectedItem(), null, null, ++number, 1);
            chiTietSPService.updateAll(ctsp.getSoLuong(), ctsp.getIdDongSp());
            return ctsp;
        } else {
            return new ChiTietSP(null, (DongSp) cbx_dongsp.getSelectedItem(),
                    (MauSac) cbx_mausac.getSelectedItem(),
                    (DungLuong) cbx_dungluong.getSelectedItem(),
                    (CuaHang) cbx_cuahang.getSelectedItem(), null, null, number, 0);
        }
    }

    public ChiTietSP createWhenUpdate(int trangThai) {
        if (trangThai == 1 && rd_daban.isSelected()) {
            ChiTietSP ctsp = new ChiTietSP(null, (DongSp) cbx_dongsp.getSelectedItem(),
                    (MauSac) cbx_mausac.getSelectedItem(),
                    (DungLuong) cbx_dungluong.getSelectedItem(),
                    (CuaHang) cbx_cuahang.getSelectedItem(), null, null, ++number, 1);
            chiTietSPService.updateAll(ctsp.getSoLuong(), ctsp.getIdDongSp());
            return ctsp;
        } else if (trangThai == 0 && rd_chuaban.isSelected()) {
            return new ChiTietSP(null, (DongSp) cbx_dongsp.getSelectedItem(),
                    (MauSac) cbx_mausac.getSelectedItem(),
                    (DungLuong) cbx_dungluong.getSelectedItem(),
                    (CuaHang) cbx_cuahang.getSelectedItem(), null, null, --number, 0);
        } else {
            return new ChiTietSP(null, (DongSp) cbx_dongsp.getSelectedItem(),
                    (MauSac) cbx_mausac.getSelectedItem(),
                    (DungLuong) cbx_dungluong.getSelectedItem(),
                    (CuaHang) cbx_cuahang.getSelectedItem(), null, null, number, 0);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_list = new javax.swing.JTable();
        txt_ngaythem = new javax.swing.JTextField();
        txt_ngaysua = new javax.swing.JTextField();
        txt_soluong = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        rd_chuaban = new javax.swing.JRadioButton();
        rd_daban = new javax.swing.JRadioButton();
        cbx_dongsp = new javax.swing.JComboBox<>();
        cbx_mausac = new javax.swing.JComboBox<>();
        cbx_dungluong = new javax.swing.JComboBox<>();
        cbx_cuahang = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết sản phẩm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Chi Tiết Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Id:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Màu sắc:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Dung lượng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Cửa hàng:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Ngày thêm:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Ngày sửa:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Số lượng:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Trạng thái:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Dòng sản phẩm:");

        tb_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dòng sản phẩm", "Màu sắc", "Dung lượng", "Cửa hàng", "Ngày thêm", "Ngày sửa", "Số lượng", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_list);

        txt_ngaythem.setEditable(false);

        txt_ngaysua.setEditable(false);

        txt_soluong.setEditable(false);

        txt_id.setEditable(false);

        rd_chuaban.setText("Chưa bán");

        rd_daban.setText("Đã bán");
        rd_daban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_dabanActionPerformed(evt);
            }
        });

        btn_add.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\img\\add.png")); // NOI18N
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });

        btn_sua.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\img\\update.png")); // NOI18N
        btn_sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_suaMouseClicked(evt);
            }
        });

        btn_xoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\img\\delete.png")); // NOI18N

        btn_search.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\img\\search.png")); // NOI18N

        btn_clear.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\img\\clear.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(cbx_dongsp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_mausac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_dungluong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_cuahang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_soluong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(txt_ngaysua, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_ngaythem, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rd_chuaban)
                                        .addGap(18, 18, 18)
                                        .addComponent(rd_daban))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(59, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txt_ngaythem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(txt_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_dongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(rd_chuaban)
                    .addComponent(rd_daban)
                    .addComponent(cbx_dungluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbx_cuahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_add, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_sua, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_search, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_clear, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
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

    private void rd_dabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_dabanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_dabanActionPerformed

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        // TODO add your handling code here:
        if (chiTietSPService.insert(create())) {
            addRows(chiTietSPService.select());
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !");
            clear();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa rõ trạng thái !");
        }
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suaMouseClicked
        // TODO add your handling code here:
        int row = tb_list.getSelectedRow();
        Integer id = (Integer) tb_list.getValueAt(row, 0);
        if (id == null) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn bản ghi !");
        } else {
            int trangThai = Integer.parseInt(tb_list.getValueAt(row, 8).toString());
            if (chiTietSPService.update(id, createWhenUpdate(trangThai))) {
                addRows(chiTietSPService.select());
                JOptionPane.showMessageDialog(rootPane, "Load lại để xem cập nhật !");
                clear();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa rõ trạng thái !");
            }
        }
    }//GEN-LAST:event_btn_suaMouseClicked

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
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietSPView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<CuaHang> cbx_cuahang;
    private javax.swing.JComboBox<DongSp> cbx_dongsp;
    private javax.swing.JComboBox<DungLuong> cbx_dungluong;
    private javax.swing.JComboBox<MauSac> cbx_mausac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_chuaban;
    private javax.swing.JRadioButton rd_daban;
    private javax.swing.JTable tb_list;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ngaysua;
    private javax.swing.JTextField txt_ngaythem;
    private javax.swing.JTextField txt_soluong;
    // End of variables declaration//GEN-END:variables
}
