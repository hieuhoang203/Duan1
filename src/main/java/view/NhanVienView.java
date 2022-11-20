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
import modul.BaoHanh;
import modul.ChiTietBaoHanh;
import modul.ChiTietSP;
import modul.HoaDon;
import modul.HoaDonChiTiet;
import modul.NguoiDung;
import service.QuanLyBaoHanhService;
import service.QuanLyChiTietBaoHanhService;
import service.QuanLyChiTietHoaDonService;
import service.QuanLyChiTietSPService;
import service.QuanLyHoaDonService;
import service.serviceImpl.BaoHanhServiceImpl;
import service.serviceImpl.ChiTietBaoHanhServiceImpl;
import service.serviceImpl.ChiTietHoaDonServiceImpl;
import service.serviceImpl.ChiTietSpServiceImpl;
import service.serviceImpl.HoaDonServiceImpl;

/**
 *
 * @author admin
 */
public class NhanVienView extends javax.swing.JFrame {
    private QuanLyChiTietBaoHanhService quanLyChiTietBaoHanhService = new ChiTietBaoHanhServiceImpl();
    private QuanLyChiTietHoaDonService quanLyChiTietHoaDonService = new ChiTietHoaDonServiceImpl();
    private QuanLyBaoHanhService quanLyBaoHanhService = new BaoHanhServiceImpl();
    private QuanLyHoaDonService quanLyHoaDonService = new HoaDonServiceImpl();
    private QuanLyChiTietSPService quanLyChiTietSPService = new ChiTietSpServiceImpl();
    private NguoiDung ng;
    private DefaultTableModel tbModelHoaDon;
    private DefaultTableModel tbModelSanPham;
    private DefaultTableModel tbModelBaoHanh;
    private DefaultTableModel tbModelGioHang;
    private DefaultComboBoxModel comboBoxModel;
    /**
     * Creates new form NhanVienView
     */
    public NhanVienView() {
        initComponents();
    }
    
    public NhanVienView(NguoiDung ng){
        this.ng = ng;
        initComponents();
        setupTrangThai();
        addCbxBaoHanh();
        addRowHoaDon();
        addRowSanPham();
    }
    
    public void setupTrangThai(){
        ButtonGroup group = new ButtonGroup();
        group.add(rd_da);
        group.add(rd_chua);
        group.add(rd_all);
        rd_all.setSelected(true);
    }
    
    public void addCbxBaoHanh(){
        comboBoxModel = (DefaultComboBoxModel) cbx_baohanh.getModel();
        comboBoxModel.addAll(quanLyBaoHanhService.select());
        cbx_baohanh.setSelectedIndex(0);
    }
    
    public void addRowHoaDon(){
        tbModelHoaDon = (DefaultTableModel) tb_hoadon.getModel();
        tbModelHoaDon.setRowCount(0);
        for (HoaDon hoaDon : quanLyHoaDonService.select(ng)) {
            tbModelHoaDon.addRow(new Object[]{
                hoaDon.getMa(),
                hoaDon.getIdNguoiDung(),
                hoaDon.getNgayMua()
            });
        }
    }
    
    public void addRowHoaDon(ArrayList<HoaDon> list){
        tbModelHoaDon = (DefaultTableModel) tb_hoadon.getModel();
        tbModelHoaDon.setRowCount(0);
        for (HoaDon hoaDon : list) {
            tbModelHoaDon.addRow(new Object[]{
                hoaDon.getMa(),
                hoaDon.getIdNguoiDung(),
                hoaDon.getNgayMua()
            });
        }
    }
    
    public void addRowSanPham(){
        tbModelSanPham = (DefaultTableModel) tb_sanpham.getModel();
        tbModelSanPham.setRowCount(0);
        for (ChiTietSP chiTietSP : quanLyChiTietSPService.searchByStore(ng.getIdCuaHang())) {
            tbModelSanPham.addRow(new Object[]{
                chiTietSP.getId(),
                chiTietSP.getImei(),
                chiTietSP.getIdLoaiSp(),
                chiTietSP.getIdLoaiSp().getIdDongSp().getGiaBan()
            });
        }
    }
    
    public HoaDon getHoaDon(){
        int row = tb_hoadon.getSelectedRow();
        if (row>=0) {
            String ma = tb_hoadon.getValueAt(row, 0).toString();
            return quanLyHoaDonService.searchByMa(ma);
        }
        return null;
    }
    
    public ChiTietSP getSanPham(){
        int row = tb_sanpham.getSelectedRow();
        if (row>=0) {
            Integer id = (Integer) tb_sanpham.getValueAt(row, 0);
            return quanLyChiTietSPService.searchById(id);
        }
        return null;
    }
    
    public void fillData(HoaDon hd){
        txt_ma.setText(hd.getMa().toString());
        txt_ngtao.setText(hd.getIdNguoiDung().toString());
        txt_ngaytao.setText(hd.getNgayMua().toString());
        txt_tongtien.setText(hd.getTongTien() + "");
    }
    
    public void addRowGioHang(){
        tbModelGioHang = (DefaultTableModel) tb_giohang.getModel();
        tbModelGioHang.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : quanLyChiTietHoaDonService.select(getHoaDon())) {
            tbModelGioHang.addRow(new Object[]{
                hoaDonChiTiet.getId(),
                hoaDonChiTiet.getIdHoaDon(),
                hoaDonChiTiet.getIdSanPham(),
                hoaDonChiTiet.getSoLuong(),
                hoaDonChiTiet.getDonGia(),
                hoaDonChiTiet.getDonGia() * hoaDonChiTiet.getSoLuong()
            });
        }
    }
    
    public void addRowBaoHanh(){
        tbModelBaoHanh = (DefaultTableModel) tb_baohanh.getModel();
        tbModelBaoHanh.setRowCount(0);
        for (ChiTietBaoHanh chiTietBaoHanh : quanLyChiTietBaoHanhService.select(getHoaDon())) {
            tbModelBaoHanh.addRow(new Object[]{
                chiTietBaoHanh.getIdHoaDon(),
                chiTietBaoHanh.getIdBaoHanh(),
                chiTietBaoHanh.getIdBaoHanh().getGia(),
                chiTietBaoHanh.getNgayBaoHanh(),
                chiTietBaoHanh.getNgayKetThuc()
            });
        }
    }
    
    public HoaDon create(){
        return new HoaDon(null, ng, null, null);
    }
    
    public HoaDonChiTiet createHdct(){
        return new HoaDonChiTiet(null, getHoaDon(), getSanPham(), 1, getSanPham().getIdLoaiSp().getIdDongSp().getGiaBan(), getSanPham().getIdLoaiSp().getIdDongSp().getGiaBan(), 1);
    }
    
    public ChiTietBaoHanh createCtbh(){
        return new ChiTietBaoHanh(null, getHoaDon(), (BaoHanh) cbx_baohanh.getSelectedItem());
    }
    
    public void tinhTien(){
        long tien = quanLyChiTietHoaDonService.getThanhTien(getHoaDon()) + quanLyChiTietBaoHanhService.tienBaoHanh(getHoaDon());
        quanLyHoaDonService.updateTongTien(getHoaDon().getId(), tien);
    }

    public void clear(){
        tbModelBaoHanh = (DefaultTableModel) tb_baohanh.getModel();
        tbModelBaoHanh.setRowCount(0);
        tbModelGioHang = (DefaultTableModel) tb_giohang.getModel();
        tbModelGioHang.setRowCount(0);
        txt_ma.setText("");
        txt_ngaytao.setText("");
        txt_ngtao.setText("");
        txt_tongtien.setText("");
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
        btn_logout = new javax.swing.JButton();
        btn_create = new javax.swing.JButton();
        rd_da = new javax.swing.JRadioButton();
        rd_chua = new javax.swing.JRadioButton();
        rd_all = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btn_thanhtoan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ngtao = new javax.swing.JTextField();
        txt_ngaytao = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_giohang = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_baohanh = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_hoadon = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbx_baohanh = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        btn_xoahoadonchitiet = new javax.swing.JButton();
        btn_xoabaohanhchitiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thu ngân");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_create.setText("Tạo hóa đơn");
        btn_create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_createMouseClicked(evt);
            }
        });

        rd_da.setText("Đã thanh toán");
        rd_da.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_daMouseClicked(evt);
            }
        });

        rd_chua.setText("Chưa thanh toán");
        rd_chua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_chuaMouseClicked(evt);
            }
        });

        rd_all.setText("Tất cả");
        rd_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_allMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        btn_thanhtoan.setText("Thanh toán");
        btn_thanhtoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thanhtoanMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Mã hóa đơn:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Người tạo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Ngày tạo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Tổng tiền:");

        txt_ma.setEditable(false);

        txt_ngtao.setEditable(false);

        txt_ngaytao.setEditable(false);

        txt_tongtien.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_thanhtoan)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngtao, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ngtao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btn_thanhtoan)
                .addContainerGap())
        );

        jButton4.setText("Profile");

        tb_giohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Hóa đơn", "Sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tb_giohang);

        tb_baohanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hóa đơn", "Loại bảo hành", "Giá", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tb_baohanh);

        tb_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Người tạo", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoadonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_hoadon);

        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Imei", "Sản phẩm", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanphamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_sanpham);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Chế độ bảo hành:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Hóa đơn");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Giỏ hàng");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Chi tiết bảo hành");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Sản phẩm");

        btn_them.setText("Thêm");
        btn_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themMouseClicked(evt);
            }
        });

        btn_xoahoadonchitiet.setText("Xóa");
        btn_xoahoadonchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoahoadonchitietMouseClicked(evt);
            }
        });

        btn_xoabaohanhchitiet.setText("Xóa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_xoahoadonchitiet)
                    .addComponent(btn_xoabaohanhchitiet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(0, 817, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_create)
                                .addGap(33, 33, 33)
                                .addComponent(rd_da)
                                .addGap(18, 18, 18)
                                .addComponent(rd_chua)
                                .addGap(18, 18, 18)
                                .addComponent(rd_all))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbx_baohanh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_logout)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_create)
                    .addComponent(rd_da)
                    .addComponent(rd_chua)
                    .addComponent(rd_all))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoahoadonchitiet)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbx_baohanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoabaohanhchitiet))
                .addContainerGap())
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

    private void rd_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_allMouseClicked
        // TODO add your handling code here:
        addRowHoaDon();
    }//GEN-LAST:event_rd_allMouseClicked

    private void rd_daMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_daMouseClicked
        // TODO add your handling code here:
        addRowHoaDon(quanLyHoaDonService.selectByTrangThai(ng, 1));
    }//GEN-LAST:event_rd_daMouseClicked

    private void rd_chuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_chuaMouseClicked
        // TODO add your handling code here:
        addRowHoaDon(quanLyHoaDonService.selectByTrangThai(ng, 0));
    }//GEN-LAST:event_rd_chuaMouseClicked

    private void btn_createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_createMouseClicked
        // TODO add your handling code here:
        quanLyHoaDonService.insert(create());
        addRowHoaDon();
        tbModelBaoHanh = (DefaultTableModel) tb_baohanh.getModel();
        tbModelBaoHanh.setRowCount(0);
        tbModelGioHang = (DefaultTableModel) tb_giohang.getModel();
        tbModelGioHang.setRowCount(0);
    }//GEN-LAST:event_btn_createMouseClicked

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        // TODO add your handling code here:
        if (getHoaDon() == null) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn hóa đơn cụ thể !");
        } else {
            int choose = JOptionPane.showConfirmDialog(rootPane, "Thêm vào hóa đơn ?");
            if (choose == JOptionPane.YES_OPTION) {
                quanLyChiTietHoaDonService.insert(createHdct());
                tinhTien();
                fillData(getHoaDon());
                addRowGioHang();
            }
        }
    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void btn_thanhtoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thanhtoanMouseClicked
        // TODO add your handling code here:
        quanLyHoaDonService.update(txt_ma.getText().trim());
        clear();
    }//GEN-LAST:event_btn_thanhtoanMouseClicked

    private void tb_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoadonMouseClicked
        // TODO add your handling code here:
        int row = tb_hoadon.getSelectedRow();
        fillData(getHoaDon());
        addRowGioHang();
        addRowBaoHanh();
    }//GEN-LAST:event_tb_hoadonMouseClicked

    private void btn_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themMouseClicked
        // TODO add your handling code here:
        if (getHoaDon() == null && quanLyChiTietHoaDonService.select(getHoaDon()) != null) {
            JOptionPane.showMessageDialog(rootPane, "Không đủ điều kiện để thực hiện thao tác !");
        } else {
            int choose = JOptionPane.showConfirmDialog(rootPane, "Thêm bảo hành ?");
            if (choose == JOptionPane.YES_OPTION) {
                quanLyChiTietBaoHanhService.inser(createCtbh());
                tinhTien();
                addRowBaoHanh();
            }
        }
    }//GEN-LAST:event_btn_themMouseClicked

    private void btn_xoahoadonchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoahoadonchitietMouseClicked
        // TODO add your handling code here:
        int row = tb_giohang.getSelectedRow();
        if (row<0) {
            JOptionPane.showMessageDialog(rootPane, "Hệ thống chưa hiểu yêu cầu !");
        } else {
            Integer id = (Integer) tb_giohang.getValueAt(row, 0);
            int choose = JOptionPane.showConfirmDialog(rootPane, "Xóa khỏi hóa đơn ?");
            if (choose == JOptionPane.YES_OPTION) {
                quanLyChiTietHoaDonService.delete(id, getHoaDon());
                addRowGioHang();
            }
        }
    }//GEN-LAST:event_btn_xoahoadonchitietMouseClicked

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
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienView().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_create;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoabaohanhchitiet;
    private javax.swing.JButton btn_xoahoadonchitiet;
    private javax.swing.JComboBox<BaoHanh> cbx_baohanh;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JRadioButton rd_all;
    private javax.swing.JRadioButton rd_chua;
    private javax.swing.JRadioButton rd_da;
    private javax.swing.JTable tb_baohanh;
    private javax.swing.JTable tb_giohang;
    private javax.swing.JTable tb_hoadon;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_ngtao;
    private javax.swing.JTextField txt_tongtien;
    // End of variables declaration//GEN-END:variables
}
