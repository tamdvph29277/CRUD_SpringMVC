package com.example.asm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chi_tiet_sp", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_sp", "id_nsx", "id_mau_sac", "id_dong_sp"})
})
public class CTSP {
    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sp", referencedColumnName = "id")
    private SanPham idSP;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nsx", referencedColumnName = "id")
    private NSX idNsx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mau_sac", referencedColumnName = "id")
    private MauSac idMauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dong_sp", referencedColumnName = "id")
    private DongSP idDong;

    @Column(name = "nam_bh")
    private Integer namBh;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;
}
