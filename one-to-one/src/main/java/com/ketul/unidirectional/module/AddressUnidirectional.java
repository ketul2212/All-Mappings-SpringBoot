package com.ketul.unidirectional.module;

import com.ketul.annotation.NameChecker;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "address_unidirectional")
public class AddressUnidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @NameChecker()
    private String email;

}

