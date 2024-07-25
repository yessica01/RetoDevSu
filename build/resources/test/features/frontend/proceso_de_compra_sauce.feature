# language: es

Característica: Compra de un producto en la página wen oficial de Sauce

  "Yo como cliente que compra regularmente en la tienda fisica de sauce
  Quiero usar el sitio web
  Para realizar compras de forma remota"

  Antecedentes:
    Dado que el usuario visita el sitio web de la empresa saucedemo.com

#Escenario critico
  @verCarrito
  Esquema del escenario: 001 - Validar que se visualice el carrito de compras
    Cuando inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Entonces visualiza en el carrito de compras

    Ejemplos:
      | PERFIL | DATOS_CORRECTOS |
      | 1      | S               |
      | 3      | S               |

#Escenario critico
  @agregarProductos
  Esquema del escenario: 002 - Validar que sea posible agregar productos al carrito
    Cuando inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Y agrega el producto número "<ITEM_DE_PRODUCTO>" al carrito
    Entonces se presentan pantalla con la información de los productos agregados "<ITEM_DE_PRODUCTO>"

    Ejemplos:
      | PERFIL | ITEM_DE_PRODUCTO | DATOS_CORRECTOS |
      | 1      | 2                | S               |
      | 5      | 1                | S               |

#Escenario critico
  @diligenciarFormulario
  Esquema del escenario: 003 - Validar diligenciamineto de formulario y cancelación de una compra antes de realizar el pago
    Cuando inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Y agrega productos al carrito y lo verifica "<ITEM_DE_PRODUCTO>"
    Y cancela la compra "<PRIMER_NOMBRE>" "<SEGUNDO_NOMBRE>" "<CODIGO_POSTAL>"
    Entonces se presenta pantalla de productos disponibles

    Ejemplos:
      | PERFIL | ITEM_DE_PRODUCTO | DATOS_CORRECTOS | PRIMER_NOMBRE | SEGUNDO_NOMBRE | CODIGO_POSTAL |
      | 1      | 2                | S               | Sofia         | Maria          | 005           |
      | 4      | 3                | S               | Pedro         | Jose           | 009           |

#Escenario critico
  @ComprarDosProductos
  Esquema del escenario: 004 - Validar opción seguir comprando
    Cuando inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Y agrega productos al carrito y lo consulta "<ITEM_DE_PRODUCTO>"
    Y continua con la compra
    Entonces se presenta pantalla de productos disponibles con la opción de remover cada producto del carrito

    Ejemplos:
      | PERFIL | DATOS_CORRECTOS | ITEM_DE_PRODUCTO |
      | 1      | S               | 2                |
