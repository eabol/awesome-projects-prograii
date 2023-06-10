public class movement {

    //base para el movimiento, modificar acordemente

    //[0] es para coordenadas x, [1] para y

    //incluir funcion para forfait

    //al cambiar a control manual los casos deberan cambiar de 12345678 a 1234 6789

    randomImput = int (math.random(8)+1);
            switch (randomImput) {
                case 1:
                    coordinates[0] = coordinates[0] - 1;
                    coordinates[1] = coordinates[1] - 1;

                    break;
                case 2:
                    coordinates[0] = coordinates[0] - 1;

                    break;
                case 3:
                    coordinates[0] = coordinates[0] - 1;
                    coordinates[1] = coordinates[1] + 1;

                    break;
                case 4:
                    coordinates[1] = coordinates[1] - 1;

                    break; 
                case 5:
                    coordinates[1] = coordinates[1] + 1;

                    break;
                case 6:
                    coordinates[0] = coordinates[0] + 1;
                    coordinates[1] = coordinates[1] - 1;

                    break;
                case 7:
                    coordinates[0] = coordinates[0] + 1;

                    break;
                case 8:
                    coordinates[0] = coordinates[0] + 1;
                    coordinates[1] = coordinates[1] + 1;

                    break;
                case 'f', 'F':
                    forfait = true;
            }

}
