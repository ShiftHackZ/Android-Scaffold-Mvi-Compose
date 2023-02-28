package com.shifthackz.scaffold.domain.usecase

import com.shifthackz.scaffold.domain.repository.SampleRepository

class SampleUseCaseImpl constructor(
    private val repository: SampleRepository,
): SampleUseCase {

}