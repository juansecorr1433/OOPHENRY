class Operacion:
    def __init__(self):
        self.__numero1 = 0.0
        self.__numero2 = 0.0

    #gets-sets numero 1
    @property
    def numero1(self):
        return self.__numero1

    @numero1.setter
    def numero1(self, valor):
        if isinstance(valor, (int, float)):
            self.__numero1 = valor
        else:
            raise ValueError("El primer número debe ser un valor numérico.")

    #gets-sets numero 2
    @property
    def numero2(self):
        return self.__numero2

    @numero2.setter
    def numero2(self, valor):
        if isinstance(valor, (int, float)):
            self.__numero2 = valor
        else:
            raise ValueError("El segundo número debe ser un valor numérico.")

    #operaciones
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