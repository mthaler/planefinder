package com.mthaler.planefinder

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PlaneRepository: ReactiveCrudRepository<Aircraft, Long>