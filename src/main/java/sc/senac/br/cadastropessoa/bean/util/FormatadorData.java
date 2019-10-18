package sc.senac.br.cadastropessoa.bean.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FormatadorData {

	public static DateFormat getFormatadorDataBrasil() {
		return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
	}
}
