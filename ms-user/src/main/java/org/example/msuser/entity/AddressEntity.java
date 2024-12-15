package org.example.msuser.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String country;
    @Column(name = "zip_code")
    private String postalCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private UserEntity user;
}
