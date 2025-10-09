class Operacion:
    def __init__(self):
        self.__numero1 = 0.0
        self.__numero2 = 0.0

    #gets-sets
    def get_numero1(self):
        return self.__numero1

    def set_numero1(self, numero1):
        self.__numero1 = numero1

    def get_numero2(self):
        return self.__numero2

    def set_numero2(self, numero2):
        self.__numero2 = numero2

    #Operaciones
    def sumar(self):
        return self.__numero1 + self.__numero2

    def restar(self):
        return self.__numero1 - self.__numero2

    def multiplicar(self):
        return self.__numero1 * self.__numero2

    def dividir(self):
        if self.__numero2 == 0:
            print("Error: no se puede dividir entre cero.")
            return None
        return self.__numero1 / self.__numero2


class VistaCalculadora:
    def __init__(self):
        self.operacion = Operacion()

    def mostrar_menu(self):
        continuar = True

        while continuar:
            print("===== CALCULADORA =====")

            self.operacion.set_numero1(self.leer_numero("Ingrese el primer número: "))
            self.operacion.set_numero2(self.leer_numero("Ingrese el segundo número: "))

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
                print("Saliendo.")
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


if __name__ == "__main__":
    vista = VistaCalculadora()
    vista.mostrar_menu()