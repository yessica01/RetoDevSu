# language: es

Característica: Creación y consulta de un usuario en la tienda Petstore

  "Yo como administrador de la tienda petstore
  Quiero registrar a los clientes en la base de datos de la tienda
  Para realizar actualizaciones correspondientes a su información personal como propietarios de mascotas

  #Escenario critico
  @registrarUsuario
  Esquema del escenario: 001 - Validar que se cree correctamente un nuevo usario desde el servicio API
    Cuando se consume el servicio crear nuevo usuario 'endpoint.petstore.usuario'
      | id   | username   | firstName   | lastName   | email   | password   | phone   | userStatus   |
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    Entonces Entonces verá el status 'OK' consumo exitoso
    Ejemplos:
      | id     | username | firstName | lastName | email             | password | phone      | userStatus |
      | 234354 | Dora     | Natalia   | Bermudez | natalia@gmail.com | 12345    | 3234556765 | 5          |

 #Escenario critico
  @consultarUsuario
  Esquema del escenario: 002 - Validar que se pueda consultar correctamente un usario desde el servicio API
    Cuando se consume el servicio crear nuevo usuario 'endpoint.petstore.usuario'
      | id   | username   | firstName   | lastName   | email   | password   | phone   | userStatus   |
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    Y se consume el servicio de consultar 'endpoint.petstore.usuario' con '<username>' usuario creado
    Entonces la estructura de la respuesta es la esperada 'informacion_usuario' '<respuesta>'

    Ejemplos:
      | id      | username | firstName | lastName | email           | password | phone       | userStatus | respuesta |
      | 4534234 | Sofia    | Jimena    | Garcia   | sofia@gmail.com | 6564534  | 34454554465 | 5          | OK        |

 #Escenario critico
  @actualizarUsuario
  Esquema del escenario: 003 - Validar que se pueda actualizar correctamente un usario desde el servicio API
    Cuando se consume el servicio crear nuevo usuario 'endpoint.petstore.usuario'
      | id   | username   | firstName   | lastName   | email   | password   | phone   | userStatus   |
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    Y se consume el servicio actualizar 'endpoint.petstore.usuario' con '<username>' usuario creado
    Entonces Entonces verá el status 'OK' consumo exitoso

    Ejemplos:
      | id     | username | firstName | lastName | email            | password | phone      | userStatus |
      | 566546 | Juanes   | Javier    | Bermudez | juanes@gmail.com | 6565443  | 3545564534 | 8          |

  #Escenario critico
  @actualizarUsuario
  Esquema del escenario: 004 - Validar que se pueda eliminar correctamente un usario desde el servicio API
    Cuando se consume el servicio crear nuevo usuario 'endpoint.petstore.usuario'
      | id   | username   | firstName   | lastName   | email   | password   | phone   | userStatus   |
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    Cuando se consume el servicio eliminar 'endpoint.petstore.usuario' con '<username>' usuario creado
    Entonces Entonces verá el status 'OK' consumo exitoso
    Ejemplos:
      | id     | username | firstName | lastName | email         | password   | phone    | userStatus |
      | 676765 | Ana      | Camila    | Perez    | ana@gmail.com | 6555445434 | 33332232 | 8          |