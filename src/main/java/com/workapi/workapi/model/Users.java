package com.workapi.workapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 15)
    private String phoneNumber;

    private String description;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, length = 255)
    private String password;

    private String role;

    @CreationTimestamp
    private Instant creationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Offers> offers;

}
