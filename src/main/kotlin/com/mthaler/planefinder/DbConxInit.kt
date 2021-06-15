package com.mthaler.planefinder

import org.springframework.beans.factory.annotation.Qualifier
import io.r2dbc.spi.ConnectionFactory
import org.springframework.core.io.ClassPathResource
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
class DbConxInit {

    @Bean
    fun initializer(@Qualifier("connectionFactory") connectionFactory: ConnectionFactory?): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory!!)
        initializer.setDatabasePopulator(
            ResourceDatabasePopulator(ClassPathResource("schema.sql"))
        )
        return initializer
    }

    //    @Bean // Uncomment @Bean annotation to add sample data
    fun init(repo: PlaneRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            repo.save(
                Aircraft(
                    "SAL001", "N12345", "SAL001", "LJ",
                    30000, 30, 300,
                    38.7209228, -90.4107416
                )
            )
                .thenMany(repo.findAll())
                .subscribe { x: Aircraft? -> println(x) }
        }
    }
}