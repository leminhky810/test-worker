package com.minhky.testworker.data.mapper

import com.minhky.testworker.database.entity.FruittieEntity
import com.minhky.testworker.domain.model.Fruittie
import com.minhky.testworker.network.model.FruittieDto

fun FruittieEntity.toDomain(): Fruittie {
    return Fruittie(
        id = id,
        name = name,
        fullName = fullName,
        calories = calories
    )
}
fun List<FruittieEntity>.toDomain(): List<Fruittie> = map { it.toDomain() }


fun FruittieDto.toEntity(): FruittieEntity {
    return FruittieEntity(
        name = name,
        fullName = fullName,
        calories = calories
    )
}
fun List<FruittieDto>.toEntity(): List<FruittieEntity> = map { it.toEntity() }

fun FruittieDto.toDomain(id: Long): Fruittie {
    return Fruittie(
        id = id,
        name = name,
        fullName = fullName,
        calories = calories
    )
}
fun List<FruittieDto>.toDomain(ids: List<Long>): List<Fruittie> =
    mapIndexed { index, item ->
        item.toDomain(ids[index])
    }

