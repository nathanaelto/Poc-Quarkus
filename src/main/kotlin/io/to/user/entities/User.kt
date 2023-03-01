package io.to.user.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var name: String
    lateinit var email: String
    lateinit var password: String
}