package com.mthaler.planefinder

import org.springframework.data.repository.CrudRepository

interface PlaneRepository: CrudRepository<Aircraft, Long>