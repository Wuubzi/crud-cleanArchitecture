package com.to_do.backend_kotlin.infrastructure.persistence.Entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tasks")
class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
     @Column
    var title: String = ""
    @Column
    var description: String = ""
    @Column
    var completed: Boolean = false
    @Column
    var priority: String = ""
    @Column
    var due_date: String = ""
    @Column
    var user_id: Long = 0
    @Column
    var created_at: LocalDateTime = LocalDateTime.now()
    @Column
    var updated_at: LocalDateTime = LocalDateTime.now()
}