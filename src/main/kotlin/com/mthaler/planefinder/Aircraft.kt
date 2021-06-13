package com.mthaler.planefinder

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Aircraft(
    @Id
    @GeneratedValue
    val id: Long? = null,
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
    @JsonProperty("vert_rate")
    val vertRate: Int = 0,
    @JsonProperty("selected_altitude")
    val selectedAltitude: Int = 0,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val barometer: Double = 0.0,
    @JsonProperty("polar_distance")
    val polarDistance: Double = 0.0,
    @JsonProperty("polar_bearing")
    val polarBearing: Double = 0.0,
    @JsonProperty("is_adsb")
    val isADSB: Boolean = false,
    @JsonProperty("is_on_ground")
    val isOnGround: Boolean = false,
    @JsonProperty("last_seen_time")
    var lastSeenTime: Instant? = null,
    @JsonProperty("pos_update_time")
    var posUpdateTime: Instant? = null,
    @JsonProperty("bds40_seen_time")
    var bds40SeenTime: Instant? = null
) {

    constructor(callsign: String, reg: String, flightno: String, type: String, altitude: Int, heading: Int, speed: Int, lat: Double, lon: Double) :
            this(null, callsign, "sqwk", reg, flightno, "route", type, "ct", altitude, heading, speed, 0, 0,
            lat, lon, 0.0, 0.0, 0.0, false, true, Instant.now(), Instant.now(), Instant.now())

    fun setLastSeenTime(lastSeenTime: Long) {
        this.lastSeenTime = Instant.ofEpochSecond(lastSeenTime)
    }

    fun setPosUpdateTime(posUpdateTime: Long) {
        this.posUpdateTime = Instant.ofEpochSecond(posUpdateTime)
    }

    fun setBds40SeenTime(bds40SeenTime: Long) {
        this.bds40SeenTime = Instant.ofEpochSecond(bds40SeenTime)
    }
}