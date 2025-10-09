from operacion import Operacion

class VistaCalculadora:
    def __init__(self):
        self.operacion = Operacion()

    def mostrar_menu(self):
        continuar = True

        while continuar:
            print("===== CALCULADORA =====")

            self.operacion.numero1 = self.leer_numero("Ingrese el primer número: ")
            self.operacion.numero2 = self.leer_numero("Ingrese el segundo número: ")

            print("\nSeleccione una operación:")
            print("1. Sumar")
            print("2. Restar")
            print("3. Multiplicar")
            print("4. Dividir")
            print("5. Salir")

            try:
                opcion = int(input("Opción: "))
            except ValueError:
                print("Error: debes ingresar un número entero.")
                continue

            if opcion == 1:
                print("Resultado:", self.operacion.sumar())
            elif opcion == 2:
                print("Resultado:", self.operacion.restar())
            elif opcion == 3:
                print("Resultado:", self.operacion.multiplicar())
            elif opcion == 4:
                resultado = self.operacion.dividir()
                if resultado is not None:
                    print("Resultado:", resultado)
            elif opcion == 5:
                print("Saliendo...")
                continuar = False
            else:
                print("Opción no válida.")

            print()

    def leer_numero(self, mensaje):
        while True:
            try:
                return float(input(mensaje))
            except ValueError:
                print("Error: Ingresa un número válido.")