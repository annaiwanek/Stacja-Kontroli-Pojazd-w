import java.util.ArrayList;
import java.util.List;
public class Pojazdy
{
    private List<Pojazd> lista;

    public Pojazdy()
    {
        lista = new ArrayList<Pojazd>();
    }

    public void drukujWszystkie()
    {

        for (int i = 0; i < lista.size(); i++)
            lista.get(i).drukuj();
    }

    public List<Pojazd> getLista()
    {
        return lista;
    }
}

