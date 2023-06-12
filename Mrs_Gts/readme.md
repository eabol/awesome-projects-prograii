# Máquinas expendedoras

Este proyecto realiza la simulación de un sistema de máquinas expendedoras. Permite realizar compras, seleccionar productos y recibir cambio en función del dinero depositado. De igual manera cuenta con la función de que se irá restando los productos comprados, y se rellena automáticamente cuando la cantidad de productos restantes es mínima

# Instrucción de ejecución

- Asegúrate de tener Java instalado en tu sistema.
- Descarga o clona este repositorio en tu máquina local.
- Navega hasta el directorio del proyecto "awesome-projects-prograii/Mrs_Gts/src".
- Ejecuta el Main.java.

# Estructura del projecto

```
├─ class-diagram/
│ └─ class.plantuml
│
├─ collaboration-diagram
│ └─ collaboration-diagram.plantuml
│
├─ domain-model/
│ └─ domain.plantuml
│
├─ images/
│ ├─ class-diagram.PNG
│ ├─ diagrama-colaboracion.png
│ ├─ domain-model.PNG
│ ├─ menu.png
│ └─ object-diagram.PNG
│
├─ object-diagram/
│ └─ objectos.plantuml
│
├─ src/
│ ├─ controllers/
│ │ ├─ BillController.java
│ │ ├─ CoinController.java
│ │ ├─ MachineController.java
│ │ ├─ ProductController.java
│ │ └─ PurchaseController.java
│ │
│ ├─ models/
│ │ ├─ BillModel.java
│ │ ├─ CoinModel.java
│ │ ├─ MachineModel.java
│ │ ├─ MaintenanceModel.java
│ │ ├─ MoneyAbstract.java
│ │ ├─ ProductModel.java
│ │ └─ PurchaseModel.java
│ │
│ ├─ test/
│ │ ├─ Test_BillController.java
│ │ ├─ Test_CoinController.java
│ │ ├─ Test_MaintenanceController.java
│ │ └─ Test_ProductController.java
│ │
│ ├─ utils/
│ │ └─ Line.java
│ │
│ └─ views/
│   ├─ MachineView.java
│   ├─ ProductView.java
│   └─  PurchaseView.java
│
│
└─ readme.md
```

# Diagramas

![Imagen](images/menu.png)

> Modelo de dominio

<details><summary><b> Mostrar </b></summary>

|         modelo de dominio          |
| :--------------------------------: |
| ![Imagen](images/domain-model.PNG) |

</details>

</br>

> Diagrama de objetos

<details><summary><b> Mostrar </b></summary>

|         diagrama de objetos          |
| :----------------------------------: |
| ![Imagen](images/object-diagram.PNG) |

</details>

</br>

> Diagrama de clases

<details><summary><b> Mostrar </b></summary>

|         diagrama de clases          |
| :---------------------------------: |
| ![Imagen](images/class-diagram.PNG) |

</details>

</br>

> Diagrama de colaboracion

<details><summary><b> Mostrar </b></summary>

|          diagrama de colaboracion           |
| :-----------------------------------------: |
| ![Imagen](images/diagrama-colaboracion.png) |

</details>

</br>
