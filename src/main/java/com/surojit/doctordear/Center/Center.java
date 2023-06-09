package com.surojit.doctordear.Center;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.surojit.doctordear.Hospital.Hospital;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "center")
@ToString
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private String address;

    @Embedded
    private CenterContact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    @JsonBackReference
    @ToString.Exclude
    private Hospital hospital;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CenterStatus status;


}


@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class CenterContact {
    private String primary_phone;
    private String primary_email;
}
