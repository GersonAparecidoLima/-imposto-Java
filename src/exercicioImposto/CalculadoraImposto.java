package exercicioImposto;

import java.util.Locale;
import java.util.Scanner;

public class CalculadoraImposto {
	public static void main(String[] args) {
		double salarioAnual, prestacaoServicosAnual = 0, ganhoCapitalAnual = 0, abatimento = 0, impostoBruto = 0,
				maximoDedutivel = 0, impostoDevido = 0;

		// Cria uma instância da classe Calcular
		Calcular calculadora = new Calcular();

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Renda anual com salário: R$ ");
		salarioAnual = sc.nextDouble();

		// Calcula o imposto anual com o método calcularImposto
		double impostoAnual = calculadora.calcularImposto(salarioAnual);

		System.out.print("Renda anual com prestação de serviço: R$ ");
		prestacaoServicosAnual = sc.nextDouble();

		System.out.print("Digite o valor anual do ganho de capital: R$ ");
		ganhoCapitalAnual = sc.nextDouble();

		System.out.print("Gastos médicos anuais: R$ ");
		double gastosMedicos = sc.nextDouble();

		System.out.print("Gastos educacionais anuais: R$ ");
		double gastosEducacionais = sc.nextDouble();

		if (prestacaoServicosAnual > 0) {
			prestacaoServicosAnual = prestacaoServicosAnual * 0.15;
		}

		if (ganhoCapitalAnual > 0) {
			ganhoCapitalAnual = ganhoCapitalAnual * 0.20;
		}

		abatimento = (gastosMedicos + gastosEducacionais);
		impostoBruto = (impostoAnual + prestacaoServicosAnual + ganhoCapitalAnual);
		maximoDedutivel = ((impostoAnual + prestacaoServicosAnual + ganhoCapitalAnual) * 0.3);

		// Determinar o abatimento permitido (o menor valor)
		impostoDevido = Math.min(maximoDedutivel, abatimento);

		System.out.println("");
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println("");

		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: R$ %.2f\n", impostoAnual);
		System.out.printf("Imposto sobre serviços: R$ %.2f\n", prestacaoServicosAnual);
		System.out.printf("Imposto sobre ganho de capital: R$ %.2f\n", ganhoCapitalAnual);

		System.out.println("");
		System.out.println("DEDUÇÕES:");
		System.out.println("");

		System.out.printf("Máximo dedutível : R$ %.2f\n", maximoDedutivel);
		System.out.printf("A dedução máxima permitida é: R$ %.2f\n", abatimento);

		System.out.println("");
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto é: R$ %.2f\n", impostoBruto);
		System.out.printf("Abatimento: R$ %.2f\n", abatimento);

		System.out.printf("Imposto devido: R$ %.2f\n", impostoBruto - impostoDevido);

		System.out.println("");

		sc.close();
	}
}
