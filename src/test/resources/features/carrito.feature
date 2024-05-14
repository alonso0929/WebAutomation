Feature: Funcionalidad de carrito de compras

  Scenario: Agregar productos al carrito
    Given el usuario ingresa a la web
    When abre el menu
    And escoge una categoria
    And escoge una subcategoria
    And escoge cinco productos con cantidades aleatoriamente
    Then ingresa a la opcion de carrito
    And se validan los nombres del producto
    And se validan los precios de los productos
    And se validan las cantidades de los productos
    And se validan el numero total de productos
