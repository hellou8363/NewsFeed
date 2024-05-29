package com.noreabang.strawberryrabbit.domain.member.model

import com.noreabang.strawberryrabbit.domain.member.dto.MemberCreateRequest
import com.noreabang.strawberryrabbit.domain.member.dto.MemberResponse
import com.noreabang.strawberryrabbit.domain.member.dto.MemberUpdateRequest
import jakarta.persistence.*
import org.hibernate.annotations.JdbcType
import org.hibernate.dialect.PostgreSQLEnumJdbcType

@Entity
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 32)
    var nickname: String? = null

    @Column(nullable = false, unique = true, length = 100)
    var email: String? = null

    @Column(length = 100)
    var password: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "signup_type", nullable = false)
    @JdbcType(PostgreSQLEnumJdbcType::class)
    var signupType: SignUpType = SignUpType.EMAIL

    @Column(length = 1000)
    var image: String? = null

    companion object {
        fun createMember(memberCreateRequest: MemberCreateRequest, password: String): Member {
            val member: Member = Member()
            member.email = memberCreateRequest.email
            member.nickname = memberCreateRequest.nickname
            member.image = memberCreateRequest.image
            member.password = password
            member.signupType = SignUpType.EMAIL
            return member
        }
    }

    fun update(memberUpdateRequest: MemberUpdateRequest, password: String): Member{
        this.nickname = memberUpdateRequest.nickname
        this.image = memberUpdateRequest.image
        this.password = password
        return this
    }

    fun toResponse(): MemberResponse {
        return MemberResponse(
            this.id!!,
            this.nickname!!,
            this.email!!,
            this.image
        )
    }
}