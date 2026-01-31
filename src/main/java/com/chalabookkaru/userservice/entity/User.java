package com.chalabookkaru.userservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.chalabookkaru.userservice.constants.UserConstants.TABLE;

/**
 * JPA entity representing a user in the system.
 * <p>
 * Functionalities:
 * - Persist user records with unique {@code email} and {@code username}.
 * - Automatically generate the primary key {@code id} on persist.
 * - Record the creation timestamp ({@code createdAt}) automatically at persist time.
 * - Lombok generates a no-args constructor, getters and setters.</p>
 * <p>
 * Annotations:
 * - {@code @Entity}: marks this class as a JPA entity.
 * - {@code @Table(name = TABLE)}: maps the entity to the database table defined by
 * {@code UserConstants.TABLE}.
 * - {@code @Id} and {@code @GeneratedValue}: configure the primary key generation.
 * - {@code @Column}: configure column constraints (nullable, unique, updatable).
 * - {@code @NoArgsConstructor}, {@code @Getter}, {@code @Setter} (Lombok): generate boilerplate code.</p>
 * <p>
 * Code flow:
 * 1. Create a new {User} instance in application code (password as of now plain text).
 * 2. Save the instance using a Spring Data repository or JPA EntityManager.
 * 3. JPA calls the method which sets {createdAt} to { LocalDateTime.now()}.
 * 4. JPA assigns a generated {id} value when the entity is persisted to the database.
 */

@Entity
@Table(name = TABLE)
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
