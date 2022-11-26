/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JFrame;
import modul.LoaiSp;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import service.QuanLyChiTietHoaDonService;
import service.QuanLyLoaiSpService;
import service.serviceImpl.ChiTietHoaDonServiceImpl;
import service.serviceImpl.LoaiSpServiceImpl;

/**
 *
 * @author admin
 */
public class SanPhamBanDuocView {

    private static QuanLyLoaiSpService quanLyLoaiSpService = new LoaiSpServiceImpl();
    private static QuanLyChiTietHoaDonService quanLyChiTietHoaDonService = new ChiTietHoaDonServiceImpl();

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("CO CAU SAN PHAM BAN DUOC", dataset, true, true, true);
        return chart;
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (LoaiSp loaiSp : quanLyLoaiSpService.select()) {
            if (quanLyChiTietHoaDonService.percent(loaiSp)>0) {
                dataset.setValue(loaiSp.toString(), quanLyChiTietHoaDonService.percent(loaiSp));
            }
        }
        return dataset;
    }

    public static void main(String[] args) {
        JFreeChart pieChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Bieu do san pham ban ra");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
