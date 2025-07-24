package com.example.demo.controller;

import com.example.demo.dto.GiaoDichDto;
import com.example.demo.entity.GiaoDich;
import com.example.demo.repository.GiaoDichRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST Controller cho GiaoDich
 * Câu 3: Web API CRUD
 * Câu 4: Vận dụng DI - inject GiaoDichRepository
 * Câu 5: Vận dụng AOP - sẽ được áp dụng bởi aspect
 */
@RestController
@RequestMapping("/api/giaodich")
public class GiaoDichController {

    // Câu 4: Vận dụng DI - Dependency Injection
    private final GiaoDichRepository giaoDichRepository;

    /**
     * Constructor injection (cách ưu tiên)
     * @param giaoDichRepository repository được inject
     */
    @Autowired
    public GiaoDichController(GiaoDichRepository giaoDichRepository) {
        this.giaoDichRepository = giaoDichRepository;
    }

    /**
     * GET /api/giaodich - Lấy tất cả giao dịch
     * @return ResponseEntity chứa danh sách giao dịch
     */
    @GetMapping
    public ResponseEntity<List<GiaoDichDto>> getAllGiaoDich() {
        List<GiaoDich> giaoDichList = giaoDichRepository.findAll();

        List<GiaoDichDto> responseDtoList = giaoDichList.stream()
                .map(giaoDich -> new GiaoDichDto(
                        giaoDich.getMaGiaoDich(),
                        giaoDich.getMoTa(),
                        giaoDich.getSoTien(),
                        giaoDich.getLoaiGiaoDich()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDtoList);
    }

    /**
     * POST /api/giaodich - Tạo giao dịch mới
     * @param giaoDichDto dữ liệu giao dịch từ request body
     * @return ResponseEntity chứa giao dịch đã tạo
     */
    @PostMapping
    public ResponseEntity<GiaoDichDto> createGiaoDich(@Valid @RequestBody GiaoDichDto giaoDichDto) {
        // Validation: kiểm tra mã giao dịch có đúng 9 ký tự
        if (giaoDichDto.getMaGiaoDich() == null || giaoDichDto.getMaGiaoDich().length() != 9) {
            return ResponseEntity.badRequest().build();
        }

        // Kiểm tra mô tả không rỗng
        if (giaoDichDto.getMoTa() == null || giaoDichDto.getMoTa().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Chuyển đổi DTO sang Entity
        GiaoDich giaoDich = new GiaoDich(
                giaoDichDto.getMaGiaoDich(),
                giaoDichDto.getMoTa(),
                giaoDichDto.getSoTien(),
                giaoDichDto.getLoaiGiaoDich()
        );

        // Lưu vào database
        GiaoDich savedGiaoDich = giaoDichRepository.save(giaoDich);

        // Chuyển đổi Entity sang DTO để trả về
        GiaoDichDto responseDto = new GiaoDichDto(
                savedGiaoDich.getMaGiaoDich(),
                savedGiaoDich.getMoTa(),
                savedGiaoDich.getSoTien(),
                savedGiaoDich.getLoaiGiaoDich()
        );

        return ResponseEntity.ok(responseDto);
    }

    /**
     * GET /api/giaodich/{ma_giao_dich} - Lấy thông tin theo mã giao dịch
     * @param maGiaoDich mã giao dịch cần tìm
     * @return ResponseEntity chứa giao dịch hoặc 404 nếu không tìm thấy
     */
    @GetMapping("/{ma_giao_dich}")
    public ResponseEntity<GiaoDichDto> getGiaoDichById(@PathVariable("ma_giao_dich") String maGiaoDich) {
        Optional<GiaoDich> giaoDichOpt = giaoDichRepository.findById(maGiaoDich);

        if (giaoDichOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        GiaoDich giaoDich = giaoDichOpt.get();
        GiaoDichDto responseDto = new GiaoDichDto(
                giaoDich.getMaGiaoDich(),
                giaoDich.getMoTa(),
                giaoDich.getSoTien(),
                giaoDich.getLoaiGiaoDich()
        );

        return ResponseEntity.ok(responseDto);
    }

    /**
     * PUT /api/giaodich/{ma_giao_dich} - Cập nhật thông tin giao dịch
     * @param maGiaoDich mã giao dịch cần cập nhật
     * @param giaoDichDto dữ liệu cập nhật
     * @return ResponseEntity chứa giao dịch đã cập nhật hoặc 404 nếu không tìm thấy
     */
    @PutMapping("/{ma_giao_dich}")
    public ResponseEntity<GiaoDichDto> updateGiaoDich(
            @PathVariable("ma_giao_dich") String maGiaoDich,
            @Valid @RequestBody GiaoDichDto giaoDichDto) {

        Optional<GiaoDich> giaoDichOpt = giaoDichRepository.findById(maGiaoDich);

        if (giaoDichOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        GiaoDich existingGiaoDich = giaoDichOpt.get();

        // Cập nhật thông tin
        existingGiaoDich.setMoTa(giaoDichDto.getMoTa());
        existingGiaoDich.setSoTien(giaoDichDto.getSoTien());
        existingGiaoDich.setLoaiGiaoDich(giaoDichDto.getLoaiGiaoDich());

        // Lưu vào database
        GiaoDich updatedGiaoDich = giaoDichRepository.save(existingGiaoDich);

        // Chuyển đổi sang DTO để trả về
        GiaoDichDto responseDto = new GiaoDichDto(
                updatedGiaoDich.getMaGiaoDich(),
                updatedGiaoDich.getMoTa(),
                updatedGiaoDich.getSoTien(),
                updatedGiaoDich.getLoaiGiaoDich()
        );

        return ResponseEntity.ok(responseDto);
    }

    /**
     * DELETE /api/giaodich/{ma_giao_dich} - Xóa giao dịch
     * @param maGiaoDich mã giao dịch cần xóa
     * @return ResponseEntity với mã 200 nếu thành công, 404 nếu không tìm thấy
     */
    @DeleteMapping("/{ma_giao_dich}")
    public ResponseEntity<Void> deleteGiaoDich(@PathVariable("ma_giao_dich") String maGiaoDich) {
        if (!giaoDichRepository.existsById(maGiaoDich)) {
            return ResponseEntity.notFound().build();
        }

        giaoDichRepository.deleteById(maGiaoDich);
        return ResponseEntity.ok().build();
    }
}