package com.mthaler.planefinder

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.io.IOException
import java.net.URL
import java.util.List

@Service
class PlaneFinderService(private val repo: PlaneRepository) {

    private val acURL = URL("http://192.168.1.193/ajax/aircraft")
    private val om = ObjectMapper()

    fun getAircraft(): Flux<Aircraft> {
        val positions: MutableList<Aircraft> = ArrayList()
        var aircraftNodes: JsonNode? = null
        try {
            aircraftNodes = om.readTree(acURL)["aircraft"]
            aircraftNodes.iterator().forEachRemaining({ node: JsonNode? ->
                try {
                    positions.add(om.treeToValue(node, Aircraft::class.java))
                } catch (e: JsonProcessingException) {
                    e.printStackTrace()
                }
            })
        } catch (e: IOException) {
            //e.printStackTrace();
            println("\n>>> IO Exception: " + e.localizedMessage + ", generating and providing sample data.\n"
            )
            return saveSamplePositions()
        }
        if (positions.size > 0) {
            positions.forEach(System.out::println)
            repo.deleteAll()
            return repo.saveAll(positions)
        } else {
            println("\n>>> No positions to report, generating and providing sample data.\n")
            return saveSamplePositions()
        }
    }

    private fun saveSamplePositions(): Flux<Aircraft> {
        repo.deleteAll()

        // Spring Airlines flight 001 en route, flying STL to SFO, at 30000' currently over Kansas City
        val ac1 = Aircraft("SAL001", "N12345", "SAL001", "LJ", 30000, 280, 440, 39.2979849, -94.71921)

        // Spring Airlines flight 002 en route, flying SFO to STL, at 40000' currently over Denver
        val ac2 = Aircraft("SAL002", "N54321", "SAL002", "LJ", 40000, 65, 440, 39.8560963, -104.6759263)

        // Spring Airlines flight 002 en route, flying SFO to STL, at 40000' currently just past DEN
        val ac3 = Aircraft("SAL002", "N54321", "SAL002", "LJ", 40000, 65, 440, 39.8412964, -105.0048267)

        return repo.saveAll(List.of(ac1, ac2, ac3))
    }
}