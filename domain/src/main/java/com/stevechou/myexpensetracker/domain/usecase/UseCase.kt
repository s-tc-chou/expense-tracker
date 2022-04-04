package com.stevechou.myexpensetracker.domain.usecase

import androidx.annotation.NonNull
import java.lang.UnsupportedOperationException

abstract class UseCase<RequestValues, ResponseValue> {
    @NonNull
    open suspend fun execute(@NonNull request: RequestValues): ResponseValue {
        throw UnsupportedOperationException()
    }

    @NonNull
    open suspend fun execute() {
        throw UnsupportedOperationException()
    }
}