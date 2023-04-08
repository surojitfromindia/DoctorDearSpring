package com.surojit.doctordear.center;

import com.surojit.doctordear.hospital.Hospital;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "center")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private String address;

    @Embedded
    private CenterContact contact;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

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