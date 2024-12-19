package io.github.byttrio.andjo.flashcardset;

import io.github.byttrio.andjo.category.Category;
import io.github.byttrio.andjo.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flashcardsets")
public class FlashcardSet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID setId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private UUID userId;

    private String name;
    private String description;

    @Column(nullable = false)
    private boolean isPublic = false;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToMany(mappedBy = "savedFlashcardSets")
    Set<User> users;
}
