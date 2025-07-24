package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * Entity cho bảng GiaoDich
 */
@Entity
@Table(name = "GiaoDich")
public class GiaoDich {

    @Id
    @Column(name = "ma_giao_dich", length = 9)
    @Size(min = 9, max = 9, message = "Mã giao dịch phải có đúng 9 ký tự")
    private String maGiaoDich;

    @Column(name = "mo_ta", nullable = false)
    @NotBlank(message = "Mô tả không được để trống")
    private String moTa;

    @Column(name = "so_tien", nullable = false)
    @PositiveOrZero(message = "Số tiền không được âm")
    private Double soTien;

    @Column(name = "loai_giao_dich", nullable = false)
    @NotBlank(message = "Loại giao dịch không được để trống")
    private String loaiGiaoDich;

    // Constructors
    public GiaoDich() {}

    public GiaoDich(String maGiaoDich, String moTa, Double soTien, String loaiGiaoDich) {
        this.maGiaoDich = maGiaoDich;
        this.moTa = moTa;
        this.soTien = soTien;
        this.loaiGiaoDich = loaiGiaoDich;
    }

    // Getters and Setters
    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    @Override
    public String toString() {
        return "GiaoDich{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", moTa='" + moTa + '\'' +
                ", soTien=" + soTien +
                ", loaiGiaoDich='" + loaiGiaoDich + '\'' +
                '}';
    }
}