package com.example.demo.repository;

import com.example.demo.entity.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface cho GiaoDich
 * Extends JpaRepository để có sẵn các phương thức CRUD
 */
@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {
    // JpaRepository đã cung cấp sẵn:
    // - save(entity): tạo mới hoặc cập nhật
    // - findById(id): tìm theo ID
    // - findAll(): lấy tất cả
    // - deleteById(id): xóa theo ID
    // - existsById(id): kiểm tra tồn tại
}