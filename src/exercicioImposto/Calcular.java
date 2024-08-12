package exercicioImposto;

public class Calcular {

	public static double calcularImposto(double valorRenda) {
		double salarioMensal, imposto = 0;

		if (valorRenda > 0) {
			salarioMensal = valorRenda / 12;
			if (salarioMensal > 5000) {
				imposto = salarioMensal * 0.2;
			} else if (salarioMensal > 3000) {
				imposto = salarioMensal * 0.1;
			}
			return imposto * 12;
		}

		return imposto;
	}

}
