package com.example.todolist.model;

import jakarta.persistence.*;
import jakarta.transaction.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Data
@Entity
@Getter
@Setter
@Table(name = "tasks")// Customizes the table name in the database.
public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull(message = "Title cannot be null")
        @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
        private String title;

        @Size(max = 500, message = "Description cannot exceed 500 characters")
        private String description;

        @Enumerated(EnumType.STRING)
        private Status status;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        // Enum to define task status
        public enum Status {PENDING, IN_PROGRESS, COMPLETED}
};
