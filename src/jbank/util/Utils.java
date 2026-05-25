package jbank.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
	private Utils() {
		throw new IllegalStateException("Classe utilitária não deve ser instanciada!");
	}

	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");

	public static String doubleToString(Double valor) {
		return formatandoValores.format(valor);
	}

}
