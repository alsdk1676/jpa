package com.app.basic.domain.entity;

import com.app.basic.domain.type.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode
@Entity @Table(name = "TBL_PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 255) // not null
    private String productName;
    @ColumnDefault("0") // 연산 때문에 숫자타입은 문자열로
    private Integer productPrice;
    @ColumnDefault("민아 메이드")
    private String productBrand;
//    LocalDate, LocalDateTime
//    private LocalDate productReleaseDate; // Date
    private LocalDate productReleaseDate; // TimeStamp
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;


}
