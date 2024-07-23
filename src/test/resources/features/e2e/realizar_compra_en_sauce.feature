# language: es

Característica: Compra de un producto en la página wen oficial de Sauce

  "Yo como cliente que compra regularmente en la tienda fisica de sauce
  Quiero usar el sitio web
  Para realizar compras de forma remota"

  Antecedentes:
    Dado que el usuario visita el sitio web de la empresa saucedemo.com

#Escenario E2E
  Esquema del escenario: 001 - Validar realización de una compra exitosa
    Cuando inicia sesion con usuario y contraseña del perfil "<PERFIL>" "<DATOS_CORRECTOS>"
    Y agrega productos al carrito y lo verifica "<ITEM_DE_PRODUCTO>"
    Y completa la compra "<PRIMER_NOMBRE>" "<SEGUNDO_NOMBRE>" "<CODIGO_POSTAL>"
    Entonces se presenta pantalla de compra realizada correctamente

    Ejemplos:
      | PERFIL | ITEM_DE_PRODUCTO | DATOS_CORRECTOS | PRIMER_NOMBRE | SEGUNDO_NOMBRE | CODIGO_POSTAL |
      | 1      | 2                | S               | German        | Rodriguez      | 001           |
      | 4      | 3                | S               | Marta         | Jimena         | 018           |
