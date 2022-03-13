package org.techtown.domain.utils

enum class ErrorType {
    // 네트워크 문제
    NETWORK,
    // 요청 시간 초과
    TIMEOUT,
    // 세션 만료
    SESSION_EXPIRED,
    // 알 수 없는 오류
    UNKNOWN
}