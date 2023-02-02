package com.shifthackz.scaffold.domain.usecase

import com.shifthackz.scaffold.domain.repository.SampleRepository
import javax.inject.Inject

class SampleUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
): SampleUseCase {

}