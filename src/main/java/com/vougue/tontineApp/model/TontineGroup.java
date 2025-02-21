package com.vougue.tontineApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TontineGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private BigDecimal totalAmount;
    private int rotationOrder;
    private LocalDate nextPayout;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Member> members;
}
