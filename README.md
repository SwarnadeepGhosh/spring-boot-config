# Complete Config Server with Client - README



Requirements and supporting Repositories

- [Config Repository](#config-repository)
- [Config Server](#config-server)
- [Config Client(Microservice)](#config-clientmicroservice)



## [Config Repository](https://github.com/SwarnadeepGhosh/config-repo)

Config Repository only having config stored for different microservices : 

https://github.com/SwarnadeepGhosh/config-repo



## [Config Server](https://github.com/SwarnadeepGhosh/spring-cloud-config-server)

Config Server, below is link for fetching config for spring-boot-config application
https://spring-cloud-config-server-01.herokuapp.com/spring-boot-config/default

```json
{
    "name": "spring-boot-config",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "47cfb654acb21430b892e6de949d2f32c551c220",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/SwarnadeepGhosh/config-repo/spring-boot-config.yml",
            "source": {
                "my.greeting": "Newly Updated greeting from Spring boot config  Microservice specific file.",
                "db.connection": "{connectionString: 'Coming from Microservice specific file}"
            }
        },
        {
            "name": "https://github.com/SwarnadeepGhosh/config-repo/application.yml",
            "source": {
                "my.greeting": "Hello from Config server.",
                "my.list.values": "One,Two,Three",
                "db.connection": "{connectionString: 'Coming from Config server', userName: 'mydbConfig', password: 'mypass'}",
                "db.host": "127.0.0.1",
                "db.port": 1200
            }
        }
    ]
}
```



## [Config Client(Microservice)](https://github.com/SwarnadeepGhosh/spring-boot-config)

Config Client(Microservice) - ***This will take value from Config Server and Config server will provide config value from Config Repository***
https://spring-boot-config-01.herokuapp.com/greeting



**Output** : 

```json
Newly Updated greeting from Spring boot config  Microservice specific file.{connectionString: 'Coming from Microservice specific file}127.0.0.1
```

-- This line is coming from **Microservice specific file in Config Repository**

