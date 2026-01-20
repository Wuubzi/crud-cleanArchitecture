package com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response


data class TaskReponse (
    var id: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var completed: Boolean? = null,
    var priority: String? = null,
    var due_date: String? = null,
    var user_id: Long? = null,
    var created_at: String? = null,
    var updated_at: String? = null
)