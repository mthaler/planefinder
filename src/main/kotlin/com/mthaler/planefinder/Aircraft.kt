package com.mthaler.planefinder


import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.Instant

data class Aircraft(
    @Id
    val id: String? = null,
    val callsign: String? = null,
    val squawk: String? = null,
    val reg: String? = null,
    val flightno: String? = null,
    val route: String? = null,
    val type: String? = null,
    val category: String? = null,
    val altitude: Int = 0,
    val heading: Int = 0,
    val speed: Int = 0,
    @field:JsonProperty("vert_rate")
    val vertRate: Int = 0,
    @field:JsonProperty("selected_altitude")
    val selectedAltitude: Int = 0,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val barometer: Double = 0.0,
    @field:JsonProperty("polar_distance")
    val polarDistance: Double = 0.0,
    @field:JsonProperty("polar_bearing")
    val polarBearing: Double = 0.0,
    @field:JsonProperty("is_adsb")
    val isADSB: Boolean = false,
    @field:JsonProperty("is_on_ground")
    val isOnGround: Boolean = false,
    @field:JsonProperty("last_seen_time")
    val lastSeenTime: Instant? = null,
    @field:JsonProperty("pos_update_time")
    val posUpdateTime: Instant? = null,
    @field:JsonProperty("bds40_seen_time")
    val bds40SeenTime: Instant? = null
) {
    constructor(
        callsign: String?, reg: String?, flightno: String?, type: String?,
        altitude: Int, heading: Int, speed: Int,
        lat: Double, lon: Double
    ) : this(null, callsign, "sqwk", reg, flightno, "route", type, "ct", altitude,
            heading, speed, 0, 0, lat, lon, 0.0, 0.0, 0.0,
            false, true, Instant.now(), Instant.now(), Instant.now())
}