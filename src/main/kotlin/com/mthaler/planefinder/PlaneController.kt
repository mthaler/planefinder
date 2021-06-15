package com.mthaler.planefinder

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Flux
import java.io.IOException

@Controller
class PlaneController(private val pfService: PlaneFinderService) {

    @ResponseBody
    @GetMapping("/aircraft")
    @Throws(IOException::class)
    fun getCurrentAircraft(): Flux<Aircraft> {
        return pfService.getAircraft()
    }
}