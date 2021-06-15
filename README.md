# planefinder
PlaneFinder Spring Boot RESTful web service from *Spring Boot Up &amp; Running* book converted to Kotlin

## Usage

The application will listen on port 7634. To chance the listen port, edit `application.properties`. It uses the H2 database to store data in memory.
It will query *http://192.168.1.193/ajax/aircraft* for aircraft data. If it cannot get aircraft data from this URL, it will provide some sample data.

The [httpie](https://httpie.io/) is a user-friendly HTTP client that can be used to test the API:

```bash
$ http :7634/aircraft
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Sun, 13 Jun 2021 08:21:48 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

[
    {
        "adsb": false,
        "altitude": 30000,
        "barometer": 0.0,
        "bds40_seen_time": "2021-06-13T08:21:48.559092392Z",
        "callsign": "SAL001",
        "category": "ct",
        "flightno": "SAL001",
        "heading": 280,
        "id": 4,
        "is_on_ground": true,
        "last_seen_time": "2021-06-13T08:21:48.559089456Z",
        "lat": 39.2979849,
        "lon": -94.71921,
        "polar_bearing": 0.0,
        "polar_distance": 0.0,
        "pos_update_time": "2021-06-13T08:21:48.559092039Z",
        "reg": "N12345",
        "route": "route",
        "selected_altitude": 0,
        "speed": 440,
        "squawk": "sqwk",
        "type": "LJ",
        "vert_rate": 0
    },
    {
        "adsb": false,
        "altitude": 40000,
        "barometer": 0.0,
        "bds40_seen_time": "2021-06-13T08:21:48.559095449Z",
        "callsign": "SAL002",
        "category": "ct",
        "flightno": "SAL002",
        "heading": 65,
        "id": 5,
        "is_on_ground": true,
        "last_seen_time": "2021-06-13T08:21:48.559094960Z",
        "lat": 39.8560963,
        "lon": -104.6759263,
        "polar_bearing": 0.0,
        "polar_distance": 0.0,
        "pos_update_time": "2021-06-13T08:21:48.559095231Z",
        "reg": "N54321",
        "route": "route",
        "selected_altitude": 0,
        "speed": 440,
        "squawk": "sqwk",
        "type": "LJ",
        "vert_rate": 0
    },
    {
        "adsb": false,
        "altitude": 40000,
        "barometer": 0.0,
        "bds40_seen_time": "2021-06-13T08:21:48.559097498Z",
        "callsign": "SAL002",
        "category": "ct",
        "flightno": "SAL002",
        "heading": 65,
        "id": 6,
        "is_on_ground": true,
        "last_seen_time": "2021-06-13T08:21:48.559097033Z",
        "lat": 39.8412964,
        "lon": -105.0048267,
        "polar_bearing": 0.0,
        "polar_distance": 0.0,
        "pos_update_time": "2021-06-13T08:21:48.559097278Z",
        "reg": "N54321",
        "route": "route",
        "selected_altitude": 0,
        "speed": 440,
        "squawk": "sqwk",
        "type": "LJ",
        "vert_rate": 0
    }
]
```

## Reactive implementation

The `reactive` branch contains a fully reactive implementation using [Project Reactor](https://projectreactor.io/), [R2DBC](https://r2dbc.io/) and Spring WebFlux.
