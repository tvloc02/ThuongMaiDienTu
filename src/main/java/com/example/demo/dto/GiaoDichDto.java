package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * DTO cho GiaoDich
 */
public class GiaoDichDto {

    @Size(min = 9, max = 9, message = "Mã giao dịch phải có đúng 9 ký tự")
    private String maGiaoDich;

    @NotBlank(message = "Mô tả không được để trống")
    private String moTa;

    @PositiveOrZero(message = "Số tiền không được âm")
    private Double soTien;

    @NotBlank(message = "Loại giao dịch không được để trống")
    private String loaiGiaoDich;

    // Constructors
    public GiaoDichDto() {}

    public GiaoDichDto(String maGiaoDich, String moTa, Double soTien, String loaiGiaoDich) {
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
        return "GiaoDichDto{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", moTa='" + moTa + '\'' +
                ", soTien=" + soTien +
                ", loaiGiaoDich='" + loaiGiaoDich + '\'' +
                '}';
    }
}