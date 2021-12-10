package com.example.calendarapp.network

import com.example.calendarapp.model.Date
import com.example.calendarapp.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<DateNetworkEntity, Date> {
    override fun mapFromEntity(entity: DateNetworkEntity): Date {
        return Date(
            entity.date,
            entity.localName,
            entity.name,
            entity.countryCode,
            entity.fixed,
            entity.global,
            entity.countries,
            entity.launchYear,
            entity.types
        )
    }

    override fun mapToEntity(domainModel: Date): DateNetworkEntity {
        return DateNetworkEntity(
            domainModel.date,
            domainModel.localName,
            domainModel.name,
            domainModel.countryCode,
            domainModel.fixed,
            domainModel.global,
            domainModel.countries,
            domainModel.launchYear,
            domainModel.types
        )
    }

    fun mapFromEntityList(entities: List<DateNetworkEntity>): List<Date> {
        return entities.map { mapFromEntity(it)}
    }
}