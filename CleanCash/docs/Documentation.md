

### ENTITY
1. PRODUCTS
   - Unique Variables:
     1. integer price 
2. CLIENTS
   - Unique Variables:
     1. 

### BACKEND FUNCTIONS
- Donde están los productos del invetario -> main.inventoryDataBase.products
- Añadir un producto al carrito -> main.cartManager.add(Product)
- Get productos en carrito de productos -> main.cartManager.getShoppingCart()
- Get coste productos -> main.cartManager.getTotalCost()
- Get total descuentos -> main.cartManager.getTotalDiscount()
- Get total final -> main.cartManager.getFinalCost()
- Usar codigo descuento -> main.cartManager.applyDiscount(String codigoDescuento)