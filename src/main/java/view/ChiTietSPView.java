package view;

import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modul.ChiTietSP;
import modul.CuaHang;
import modul.DongSp;
import modul.LoaiSp;
import service.*;
import service.serviceImpl.*;

/**
 *
 * @author admin
 */
public class ChiTietSPView extends javax.swing.JFrame {

    private ExcelHelper excelHelper = new ExcelHelper();
    private int firtRecord = 0, soTrang, count, temp = 1;
    private DefaultTableModel tableModel;
    private DefaultComboBoxModel cbxLoaiSp;
    private DefaultComboBoxModel cbxCuaHang;
    private DefaultComboBoxModel cbxSearch;
    private DefaultComboBoxModel cbxDongSp;
    private QuanLyDongSpService quanLyDongSpService = new DongSpServiceImpl();
    private QuanLyLoaiSpService quanLyLoaiSpService = new LoaiSpServiceImpl();
    private QuanLyCuaHangService quanLyCuaHangService = new CuaHangServiceImpl();
    private QuanLyChiTietSPService quanLyChiTietSPService = new ChiTietSpServiceImpl();
    private QuanLyHangService quanLyHangService = new HangServiceImpl();
    private ArrayList<ChiTietSP> list = new ArrayList<>();

    /**
     * Creates new form ChiTietSPView
     */
    public ChiTietSPView() {
        initComponents();
        addCbxLoaiSp();
        addCbxCuaHang();
        addCbxSearch();
        addCbxDongSp();
        list = quanLyChiTietSPService.select();
        setPage(quanLyChiTietSPService.select().size());
        setAnimation(temp, soTrang);
        addRows(firtRecord, list);
    }

    public void setAnimation(int temp, int soTrang) {
        lb_sotrang.setText("/" + soTrang);
        lb_trang.setText("     " + temp);
    }

    public void setPage(int size) {
        count = size;
        if (count % 5 == 0) {
            soTrang = count / 5;
        } else {
            soTrang = count / 5 + 1;
        }
    }

    public void addCbxLoaiSp() {
        cbxLoaiSp = (DefaultComboBoxModel) cbx_loaisp.getModel();
        cbxLoaiSp.addAll(quanLyLoaiSpService.select());
        cbx_loaisp.setSelectedIndex(0);
    }

    public void addCbxCuaHang() {
        cbxCuaHang = (DefaultComboBoxModel) cbx_cuahang.getModel();
        cbxCuaHang.addAll(quanLyCuaHangService.select());
        cbx_cuahang.setSelectedIndex(0);
    }

    public void addCbxSearch() {
        cbxSearch = (DefaultComboBoxModel) cbx_cuaHangSearch.getModel();
        cbxSearch.addAll(quanLyCuaHangService.select());
        cbx_cuaHangSearch.setSelectedIndex(0);
    }

    public void addCbxDongSp() {
        cbxDongSp = (DefaultComboBoxModel) cbx_dongsp.getModel();
        cbxDongSp.addAll(quanLyDongSpService.select());
        cbx_dongsp.setSelectedIndex(0);
    }

    public void addRows(int page, ArrayList<ChiTietSP> list) {
        tableModel = (DefaultTableModel) tb_list.getModel();
        tableModel.setRowCount(0);
        for (int i = page; i < page + 5; i++) {
            try {
                tableModel.addRow(new Object[]{
                    list.get(i).getId(),
                    list.get(i).getImei(),
                    list.get(i).getIdLoaiSp(),
                    list.get(i).getIdCuaHang()
                });
            } catch (Exception e) {
                break;
            }
        }
    }

    public void fillData(int row) {
        cbxLoaiSp = (DefaultComboBoxModel) cbx_loaisp.getModel();
        cbxCuaHang = (DefaultComboBoxModel) cbx_cuahang.getModel();
        txt_id.setText(tb_list.getValueAt(row, 0).toString());
        txt_imei.setText(tb_list.getValueAt(row, 1).toString());
        cbxLoaiSp.setSelectedItem(tb_list.getValueAt(row, 2));
        cbxCuaHang.setSelectedItem(tb_list.getValueAt(row, 3));

    }

    public void clear() {
        list = quanLyChiTietSPService.select();
        firtRecord  = 0;
        temp = 1;
        txt_id.setText("");
        cbx_loaisp.setSelectedIndex(0);
        cbx_cuahang.setSelectedIndex(0);
        txt_imei.setText("");
        addRows(0, list);
        setPage(quanLyChiTietSPService.select().size());
        setAnimation(temp, soTrang);
    }

    public ChiTietSP create() {
        return new ChiTietSP(null, txt_imei.getText().trim(),
                (LoaiSp) cbx_loaisp.getSelectedItem(),
                (CuaHang) cbx_cuahang.getSelectedItem(), 1, null, null, null, null);
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_list = new javax.swing.JTable();
        txt_imei = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        cbx_loaisp = new javax.swing.JComboBox<>();
        cbx_cuahang = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lb_trang = new javax.swing.JLabel();
        lb_sotrang = new javax.swing.JLabel();
        btn_first = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_read = new javax.swing.JButton();
        btn_write = new javax.swing.JButton();
        cbx_cuaHangSearch = new javax.swing.JComboBox<>();
        cbx_dongsp = new javax.swing.JComboBox<>();
        btn_search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết sản phẩm");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Chi Tiết Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Id:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Loại sản phẩm:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Cửa hàng:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Imei:");

        tb_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Imei", "Loại sản phẩm", "Cửa hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        txt_id.setEditable(false);

        btn_add.setBackground(new java.awt.Color(204, 255, 204));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 0, 0));
        btn_add.setText("Thêm");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
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

        btn_first.setText("<<");
        btn_first.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_firstMouseClicked(evt);
            }
        });

        btn_prev.setText("<");
        btn_prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prevMouseClicked(evt);
            }
        });

        btn_next.setText(">");
        btn_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nextMouseClicked(evt);
            }
        });

        btn_last.setText(">>");
        btn_last.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lastMouseClicked(evt);
            }
        });

        btn_read.setBackground(new java.awt.Color(204, 255, 204));
        btn_read.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_read.setForeground(new java.awt.Color(255, 0, 0));
        btn_read.setText("Import");
        btn_read.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_readMouseClicked(evt);
            }
        });

        btn_write.setBackground(new java.awt.Color(204, 255, 204));
        btn_write.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_write.setForeground(new java.awt.Color(255, 0, 0));
        btn_write.setText("Export");
        btn_write.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_writeMouseClicked(evt);
            }
        });

        cbx_cuaHangSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_cuaHangSearchActionPerformed(evt);
            }
        });

        cbx_dongsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_dongspActionPerformed(evt);
            }
        });

        btn_search.setBackground(new java.awt.Color(204, 255, 204));
        btn_search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 0, 0));
        btn_search.setText("Search");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(cbx_cuaHangSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cbx_dongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btn_first)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_prev)
                        .addGap(22, 22, 22)
                        .addComponent(lb_trang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_sotrang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_last))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id)
                            .addComponent(cbx_loaisp, 0, 113, Short.MAX_VALUE)
                            .addComponent(txt_imei, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(cbx_cuahang, 0, 113, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_read, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_write, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add)
                    .addComponent(btn_sua))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_imei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa)
                    .addComponent(btn_clear))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_loaisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_read)
                    .addComponent(btn_write))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_cuahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_dongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_cuaHangSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_trang, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_first)
                        .addComponent(btn_prev))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_next)
                        .addComponent(btn_last))
                    .addComponent(lb_sotrang, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        // TODO add your handling code here:
        if (quanLyChiTietSPService.insert(create())) {
            addRows(0, list);
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !");
            clear();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng imei !");
        }
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suaMouseClicked
        // TODO add your handling code here:
        int row = tb_list.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn bản ghi !");
        } else {
            Integer id = (Integer) tb_list.getValueAt(row, 0);
            if (quanLyChiTietSPService.update(id, create())) {
                addRows(0, list);
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công !");
            } else if (quanLyChiTietSPService.checkData(create())) {
                JOptionPane.showMessageDialog(rootPane, "Sai định dạng imei !");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Imei đã tồn tại !");
            }
        }
    }//GEN-LAST:event_btn_suaMouseClicked

    private void tb_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listMouseClicked
        // TODO add your handling code here:
        int row = tb_list.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tb_listMouseClicked

    private void btn_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoaMouseClicked
        // TODO add your handling code here:
        int row = tb_list.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn bản ghi !");
        } else {
            Integer id = (Integer) tb_list.getValueAt(row, 0);
            int choose = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa ?");
            if (choose == JOptionPane.YES_OPTION) {
                quanLyChiTietSPService.delete(id);
                addRows(0, list);
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công !");
                clear();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hủy xóa !");
            }
        }
    }//GEN-LAST:event_btn_xoaMouseClicked

    private void btn_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseClicked
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clearMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new AdminView().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btn_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseClicked
        // TODO add your handling code here:
        firtRecord += 5;
        temp++;
        if (temp<=soTrang) {
            addRows(firtRecord, list);
            setAnimation(temp, soTrang);
        } else {
            if (count % 5 == 0) {
                firtRecord = count - 5;
            } else {
                firtRecord = count - (count % 5);
            }
            temp = soTrang;
        }
    }//GEN-LAST:event_btn_nextMouseClicked

    private void btn_prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prevMouseClicked
        // TODO add your handling code here:
        firtRecord -= 5;
        temp--;
        if (firtRecord >= 0) {
            addRows(firtRecord, list);
            setAnimation(temp, soTrang);
        } else {
            firtRecord = 0;
            temp = 1;
        }
    }//GEN-LAST:event_btn_prevMouseClicked

    private void btn_readMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_readMouseClicked
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xlsx");
            fileChooser.setFileFilter(filter);
            fileChooser.setMultiSelectionEnabled(false);
            int x = fileChooser.showDialog(jPanel1, "Select file");
            if (x == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String path = file.getAbsolutePath();
                ArrayList<ChiTietSP> list = excelHelper.readFileExcel(path);
                for (ChiTietSP chiTietSP : list) {
                    quanLyChiTietSPService.insert(chiTietSP);
                }
                addRows(0, this.list);
                setAnimation(temp, soTrang);
                JOptionPane.showMessageDialog(rootPane, "Doc file thanh cong !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Chua chon file !");
        }
    }//GEN-LAST:event_btn_readMouseClicked

    private void btn_writeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_writeMouseClicked
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "Ban muon xuat file ?");
        if (choose == JOptionPane.YES_OPTION) {
            excelHelper.writeFileExcel(quanLyChiTietSPService.selectAll());
            JOptionPane.showMessageDialog(rootPane, "Ghi thành công !");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Huy ghi file !");
        }
    }//GEN-LAST:event_btn_writeMouseClicked

    private void btn_firstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_firstMouseClicked
        // TODO add your handling code here:
        firtRecord = 0;
        temp = 1;
        addRows(firtRecord, list);
        setAnimation(temp, soTrang);
    }//GEN-LAST:event_btn_firstMouseClicked

    private void btn_lastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lastMouseClicked
        // TODO add your handling code here:
        if (count % 5 == 0) {
            firtRecord = count - 5;
        } else {
            firtRecord = count - (count % 5);
        }
        temp = soTrang;
        addRows(firtRecord, list);
        setAnimation(temp, soTrang);
    }//GEN-LAST:event_btn_lastMouseClicked

    private void cbx_cuaHangSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_cuaHangSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_cuaHangSearchActionPerformed

    private void cbx_dongspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_dongspActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_cbx_dongspActionPerformed

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        list = quanLyChiTietSPService.search((CuaHang) cbx_cuaHangSearch.getSelectedItem(), (DongSp) cbx_dongsp.getSelectedItem());
        temp = 1;
        firtRecord = 0;
        addRows(firtRecord, list);
        setPage(quanLyChiTietSPService.search((CuaHang) cbx_cuaHangSearch.getSelectedItem(), (DongSp) cbx_dongsp.getSelectedItem()).size());
        setAnimation(temp, soTrang);
    }//GEN-LAST:event_btn_searchMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

    }//GEN-LAST:event_btn_searchActionPerformed

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
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_read;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_write;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<CuaHang> cbx_cuaHangSearch;
    private javax.swing.JComboBox<CuaHang> cbx_cuahang;
    private javax.swing.JComboBox<DongSp> cbx_dongsp;
    private javax.swing.JComboBox<LoaiSp> cbx_loaisp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_sotrang;
    private javax.swing.JLabel lb_trang;
    private javax.swing.JTable tb_list;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_imei;
    // End of variables declaration//GEN-END:variables
}
