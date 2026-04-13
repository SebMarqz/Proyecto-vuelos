import java.util.Scanner;

      public class Menu_aerolinea {

        //MENU PRINCIPAL
        public void iniciar(Aerolinea aerolinea){
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("=== MENU AEROLINEA ===");
                System.out.println("1. Pasajeros");
                System.out.println("2. Vuelos");
                System.out.println("3. Reservas");
                System.out.println("4. Salir");
                opcion = scanner.nextInt();

                switch(opcion){
                    case 1:
                        menuPasajeros(aerolinea, scanner);
                        break;
                    case 2:
                        menuVuelos(aerolinea, scanner);
                        break;
                    case 3:
                        menuReservas(aerolinea, scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }

            } while(opcion != 4);
        }

        //SUB MENU PASAJERO
        private void menuPasajeros(Aerolinea aerolinea, Scanner scanner){
            int opcion;

            do {
                System.out.println("=== PASAJEROS ===");
                System.out.println("1. Registrar");
                System.out.println("2. Buscar");
                System.out.println("3. Eliminar");
                System.out.println("4. Volver");
                opcion = scanner.nextInt();

                switch(opcion){
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = scanner.next();
                        System.out.print("Apellido: ");
                        String apellido = scanner.next();
                        System.out.print("Pasaporte: ");
                        int pasaporte = scanner.nextInt();

                        Pasajero p = new Pasajero(nombre, apellido, pasaporte);
                        aerolinea.registrarPasajero(p);
                        break;

                    case 2:
                        System.out.print("Pasaporte: ");
                        int buscar = scanner.nextInt();
                        Pasajero encontrado = aerolinea.buscarPasajero(buscar);

                        if(encontrado != null){
                            System.out.println(encontrado.getNombre() + " " + encontrado.getApellido());
                        } else {
                            System.out.println("No encontrado");
                        }
                        break;

                    case 3:
                        System.out.print("Pasaporte: ");
                        int eliminar = scanner.nextInt();
                        aerolinea.eliminarPasajero(eliminar);
                        break;
                }

            } while(opcion != 4);
        }

        //SUB MENU VUELO

        private void menuVuelos(Aerolinea aerolinea, Scanner scanner){
            int opcion;

            do {
                System.out.println("=== VUELOS ===");
                System.out.println("1. Agregar vuelo");
                System.out.println("2. Buscar vuelo");
                System.out.println("3. Eliminar vuelo");
                System.out.println("4. Consultar ultimo vuelo");
                System.out.println("5. Volver");
                opcion = scanner.nextInt();

                switch(opcion){
                    case 1:
                        System.out.print("Cantidad de asientos: ");
                        int cantidadAsientos = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Origen: ");
                        String origen = scanner.nextLine();

                        System.out.print("Destino: ");
                        String destino = scanner.nextLine();

                        System.out.print("Fecha: ");
                        String fecha = scanner.nextLine();

                        System.out.print("Hora: ");
                        String hora = scanner.nextLine();

                        aerolinea.agregarVuelo(cantidadAsientos, origen, destino, fecha, hora);
                        break;

                    case 2:
                        System.out.print("Id del vuelo: ");
                        int idVueloBuscar = scanner.nextInt();

                        Vuelo vueloBuscado = aerolinea.buscarVuelo(idVueloBuscar);

                        if(vueloBuscado != null){
                            System.out.println("Vuelo encontrado");
                            System.out.println("Id: " + vueloBuscado.getId_vuelo());
                            System.out.println("Origen: " + vueloBuscado.getOrigen());
                            System.out.println("Destino: " + vueloBuscado.getDestino());
                            System.out.println("Fecha: " + vueloBuscado.getFecha());
                            System.out.println("Hora: " + vueloBuscado.getHora());
                            System.out.println("Asientos: " + vueloBuscado.getCantidad_asientos());
                        } else {
                            System.out.println("Vuelo no encontrado");
                        }
                        break;

                    case 3:
                        System.out.print("Id del vuelo: ");
                        int idVueloEliminar = scanner.nextInt();

                        Vuelo vueloEliminar = aerolinea.buscarVuelo(idVueloEliminar);

                        if(vueloEliminar != null){
                            aerolinea.eliminarVuelo(vueloEliminar);
                        } else {
                            System.out.println("Vuelo no encontrado");
                        }
                        break;

                    case 4:
                        Vuelo ultimoVuelo = aerolinea.consultarUltimoVuelo();

                        if(ultimoVuelo != null){
                            System.out.println("Ultimo vuelo cargado:");
                            System.out.println("Origen: " + ultimoVuelo.getOrigen());
                            System.out.println("Destino: " + ultimoVuelo.getDestino());
                            System.out.println("Fecha: " + ultimoVuelo.getFecha());
                            System.out.println("Hora: " + ultimoVuelo.getHora());
                            System.out.println("Asientos: " + ultimoVuelo.getCantidad_asientos());
                        } else {
                            System.out.println("No hay vuelos cargados");
                        }
                        break;

                    case 5:
                        System.out.println("Volviendo al menu principal...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } while(opcion != 5);
        }


        private void menuReservas(Aerolinea aerolinea, Scanner scanner){
            int opcion;

            do {
                System.out.println("=== RESERVAS ===");
                System.out.println("1. Reservar pasaje");
                System.out.println("2. Buscar reserva");
                System.out.println("3. Cancelar reserva");
                System.out.println("4. Ver cola de espera");
                System.out.println("5. Volver");
                opcion = scanner.nextInt();

                switch(opcion){
                    case 1:

                        System.out.print("Pasaporte del pasajero: ");
                        int pasaporteReserva = scanner.nextInt();

                        Pasajero pasajeroReserva = aerolinea.buscarPasajero(pasaporteReserva);

                        if(pasajeroReserva == null){
                            System.out.println("Pasajero no encontrado");
                            break;
                        }

                        System.out.print("Id del vuelo: ");
                        int idVueloReserva = scanner.nextInt();

                        Vuelo vueloReserva = aerolinea.buscarVuelo(idVueloReserva);

                        if(vueloReserva == null){
                            System.out.println("Vuelo no encontrado");
                        } else {
                            aerolinea.reservarPasaje(vueloReserva, pasajeroReserva);
                        }
                        break;

                    case 2:

                        System.out.print("Id del vuelo: ");
                        int idVueloBuscar = scanner.nextInt();

                        Vuelo vueloBuscar = aerolinea.buscarVuelo(idVueloBuscar);

                        if(vueloBuscar == null){
                            System.out.println("Vuelo no encontrado");
                            break;
                        }

                        System.out.print("Numero de reserva: ");
                        int numeroBuscar = scanner.nextInt();

                        Reserva_vuelos reservaBuscada = aerolinea.buscarReserva(vueloBuscar, numeroBuscar);

                        if(reservaBuscada != null){
                            System.out.println("Reserva encontrada");
                            System.out.println("Numero: " + reservaBuscada.getNumero_reserva());
                            System.out.println("Pasajero: " + reservaBuscada.pasajero().getNombre() + " " + reservaBuscada.pasajero().getApellido());
                            System.out.println("Vuelo: " + reservaBuscada.vuelo().getOrigen() + " - " + reservaBuscada.vuelo().getDestino());
                        } else {
                            System.out.println("Reserva no encontrada");
                        }
                        break;

                    case 3:

                        System.out.print("Id del vuelo: ");
                        int idVueloCancelar = scanner.nextInt();

                        Vuelo vueloCancelar = aerolinea.buscarVuelo(idVueloCancelar);

                        if(vueloCancelar == null){
                            System.out.println("Vuelo no encontrado");
                            break;
                        }

                        System.out.print("Numero de reserva a cancelar: ");
                        int numeroCancelar = scanner.nextInt();

                        aerolinea.cancelarReserva(vueloCancelar, numeroCancelar);
                        break;

                    case 4:
                        System.out.print("Id del vuelo: ");
                        int idVueloCola = scanner.nextInt();

                        Vuelo vueloCola = aerolinea.buscarVuelo(idVueloCola);

                        if(vueloCola == null){
                            System.out.println("Vuelo no encontrado");
                            break;
                        }

                        Pasajero enEspera = aerolinea.verColaEsperaDeVuelo(vueloCola);

                        if(enEspera != null){
                            System.out.println("Primer pasajero en espera:");
                            System.out.println("Nombre: " + enEspera.getNombre());
                            System.out.println("Apellido: " + enEspera.getApellido());
                            System.out.println("Pasaporte: " + enEspera.getPasaporte());
                        } else {
                            System.out.println("La cola de espera esta vacia");
                        }
                        break;

                    case 5:
                        System.out.println("Volviendo al menu principal...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } while(opcion != 5);
        }


}
