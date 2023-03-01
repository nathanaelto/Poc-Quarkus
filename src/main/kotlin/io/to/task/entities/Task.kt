package io.to.task.entities

import io.to.user.entities.User
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tasks")
class Task {
    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var content: String
    lateinit var status: TaskStatus

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @CreationTimestamp
    lateinit var createdAt: LocalDateTime
}