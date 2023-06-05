import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Chamada {
// Calendário gregoriano e duração
    private GregorianCalendar data;
    private int duracao;

    public Chamada(GregorianCalendar data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
// used for formatting dates
        String dataStr = dateFormat.format(data.getTime());
        return "Data: " + dataStr + ", Duração: " + duracao + " minutos";
    }
}
