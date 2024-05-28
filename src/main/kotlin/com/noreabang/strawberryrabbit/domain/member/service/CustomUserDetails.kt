package com.noreabang.strawberryrabbit.infra.secutiry

import com.noreabang.strawberryrabbit.domain.member.model.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class CustomUserDetails(
    private val member: Member
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> { // 사용자에게 부여된 권한을 반환
        val collector: MutableCollection<GrantedAuthority> = ArrayList() // 빈 권한

        return collector
    }

    override fun getPassword(): String? { // 사용자 비밀번호 반환
        return member.password
    }

    override fun getUsername(): String? { // 사용자 이메일 반환
        return member.email
    }

    override fun isAccountNonExpired(): Boolean { // 계정 만료 여부(만료이면 true, 아니면 false)
        return true
    }

    override fun isAccountNonLocked(): Boolean { // 계정 잠금 여부(잠기면 true, 아니면 false)
        return true
    }

    override fun isCredentialsNonExpired(): Boolean { // 자격 증명(비밀번호) 만료 여부(유효하면 true, 아니면 false)
        return true
    }

    override fun isEnabled(): Boolean { // 사용자 활성화 여부(활성화면 true, 아니면 false)
        return true
    }
}