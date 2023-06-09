package com.surojit.doctordear.Hospital;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.surojit.doctordear.Center.Center;
import com.surojit.doctordear.Department.Department;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(targetEntity = Center.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hospital")
    private List<Center> centers;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(targetEntity = Department.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hospital")
    private List<Department> departments;


}
