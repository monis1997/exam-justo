package com.example.justo.model.data


import com.squareup.moshi.Json

data class Person(
    @Json(name = "results")
    val info: Info,
    @Json(name = "results")
    val results: List<Result>
){
    data class Coordinates(
        val latitude: String,
        val longitude: String
    )

    data class Dob(
        val age: String,
        val date: String
    )

    data class Id(
        @Json(name = "name")
        val name: String,
        @Json(name = "value")
        val value: String
    )

    data class Info(
        val page: String,
        val results: String,
        val seed: String,
        val version: String
    )

    data class Location(
        val city: String,
        val coordinates: Coordinates,
        val country: String,
        val postcode: String,
        val state: String,
        val street: Street,
        val timezone: Timezone
    )

    data class Login(
        val md5: String,
        val password: String,
        val salt: String,
        val sha1: String,
        val sha256: String,
        val username: String,
        val uuid: String
    )

    data class Name(
        @Json(name = "first")
        val first: String,
        @Json(name = "last")
        val last: String,
        @Json(name = "title")
        val title: String
    )

    data class Picture(
        @Json(name = "large")
        val large: String,
        @Json(name = "medium")
        val medium: String,
        @Json(name = "thumbnail")
        val thumbnail: String
    )

    data class Registered(
        val age: String,
        val date: String
    )

    data class Result(
        val cell: String,
        val dob: Dob,
        @Json(name = "email")
        val email: String,
        val gender: String,
        val id: Id,
        val location: Location,
        val login: Login,
        val name: Name,
        val nat: String,
        val phone: String,
        @Json(name = "picture")
        val picture: Picture,
        val registered: Registered
    )

    data class Street(
        val name: String,
        val number: String
    )

    data class Timezone(
        val description: String,
        val offset: String
    )
}