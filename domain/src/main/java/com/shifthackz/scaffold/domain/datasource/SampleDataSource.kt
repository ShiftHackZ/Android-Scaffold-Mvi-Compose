package com.shifthackz.scaffold.domain.datasource

sealed interface SampleDataSource {
    interface Remote : SampleDataSource {

    }

    interface Local : SampleDataSource {

    }
}
