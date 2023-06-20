# ShippingProject

Esta API tiene como objetivo consultar el esquema de envios record que permita crear, editar y visualizar las tablas relacionadas.

## Ejecutar proyecto

Puede ejecutar el proyecto por medio de 

```shell
docker-compose up -d
```
## Vehiculos

Gestiona los vehiculos almacenados.

### Registrar un vehiculo

```http
    POST /api/v1/vehicle/newVehicle

BODY

{
    "modelo":"2020",
    "placa":"DDJ809",
    "capacidad":"100KG"
}
```

#### Respuesta Exitosa

```yml
status: 201
{
    "message": "Se guardo el Vehiculo con exito!"
}
```

#### Errores

Caso en el que ya esté registrado

```yml
status: 400
{
    "message": "El vehiculo ya existe"
}
```

### Consultar todos los vehiculos

```http
    GET /api/v1/vehicle/get
```

#### Respuesta Exitosa

```yml
status: 200
[
    {
        "id": 1,
        "modelo": "2020",
        "placa": "DDJ809",
        "capacidad": "100KG"
    },
    {
        "id": 2,
        "modelo": "2020",
        "placa": "DDJ8091",
        "capacidad": "100KG"
    }
]
```

## Conductores

Gestiona los Conductores almacenados.

### Registrar un Conductor

```http
    POST /api/v1/driver/newDriver

BODY

{
    "identificacion":"1007195132",
    "nombre":"Juanito",
    "apellido":"Peréz",
    "telefono":"3132296334",
    "direccion":"Calle 4 # 16 - 09"
}
```

#### Respuesta Exitosa

```yml
status: 201
{
    "message": "Se guardo el conductor con exito!"
}
```

#### Errores

Caso en el que ya esté registrado

```yml
status: 400
{
    "message": "El conductor ya existe"
}
```

### Consultar todos los conductores

```http
    GET /api/v1/driver/get
```

#### Respuesta Exitosa

```yml
status: 200
[
    {
        "id": 1,
        "identificacion": "1007195132",
        "nombre": "Juanito",
        "apellido": "Peréz",
        "telefono": "32296334",
        "direccion": "Calle 4 # 16 - 09"
    }
]
```


### Asociar los vehiculos a un conductor

```http
    PUT /api/v1/driver/associate
    
BODY
{
    "identificacion":"1007195134",
    "placas":[
        "DDJ806"
    ]
}
```

#### Respuesta Exitosa

```yml
status: 200
{
    "message": "Se asociaron los vehiculos de manera exitosa!"
}
```

#### Errores

Caso en el que ya no esté registrado

```yml
status: 404
{
    "message": "No se encontró al conductor"
}
```



### Des Asociar un vehiculo de un conductor

```http
    PUT /api/v1/driver/disassociate
    
BODY
{
    "identificacion":"1007195131",
    "placa": "DDJ806"
}
```

#### Respuesta Exitosa

```yml
status: 200
{
    "message": "Se desasocio el vehiculo de manera exitosa!"
}
```

#### Errores

Caso en el que ya no esté registrado

```yml
status: 404
{
    "message": "No se encontró al conductor"
}
```

## Ordenes

Gestiona los Ordenes almacenados.

### Registrar una Orden

```http
    POST /api/v1/order/make

BODY

{
    "direccion":"Calle 4 # 16 - 09",
    "tipoPedido":"Domicilio"
}
```

#### Respuesta Exitosa

```yml
status: 201
{
    "message": "Se realizó la orden de manera exitosa!"
}
```

#### Errores

Caso en el que no ya haya un conductor disponible

```yml
status: 404
{
    "message": "No se encontró un conductor"
}
```
