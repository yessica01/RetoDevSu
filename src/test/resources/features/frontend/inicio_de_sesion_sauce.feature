# language: es

Característica: Inicio de sesion de un cliente de la empresa sauce, en el sitio web oficial

  "Yo como cliente que compra regularmente en la tienda fisica de sauce
  Quiero usar el sitio web
  Para realizar compras de forma remota"

  Antecedentes:
    Dado que el usuario visita el sitio web de la empresa saucedemo.com

    #Escenario critico
  @inicioDeSesionExitoso
  Esquema del escenario: 001 - Validar inicio de sesion en el sitio web, con datos correctos
    Cuando inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Entonces se muestra la pantalla principal del sitio web "<PANTALLA_ESPERADA>"

    Ejemplos:
      | PERFIL | PANTALLA_ESPERADA | DATOS_CORRECTOS |
      | 1      | Products          | S               |
      | 3      | Products          | S               |

#Escenario negativo
  @usuarioNoExiste
  Esquema del escenario: 002 - Validar inicio de sesion en el sitio web, con datos incorrectos
    Cuando inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Entonces se muestra mensaje de error porque los datos ingresados no corresponden a los disponibles

    Ejemplos:
      | PERFIL | DATOS_CORRECTOS |
      | 1      | N               |
      | 2      | N               |

#Escenario negativo
  @usuarioBloqueado
  Esquema del escenario: 003 - Validar inicio de sesion en el sitio web, con usuario bloqueado
    Cuando  inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Entonces se muestra un mensaje informativo por usuario bloqueado

    Ejemplos:
      | PERFIL | DATOS_CORRECTOS |
      | 2      | S               |
