import java.util.*;

public class BazaDanych
{
    private Map<String, List<BadanieTechniczne>> badaniaTechniczne = new HashMap<>();

    public void dodajBadanie(BadanieTechniczne badanieTechniczne)
    {
        String numerRejestracyjny = badanieTechniczne.getPojazd().getNumerRejestracyjny();
        List<BadanieTechniczne> badania = badaniaTechniczne.getOrDefault(numerRejestracyjny, new ArrayList<>());
        badania.add(badanieTechniczne);
        badaniaTechniczne.put(numerRejestracyjny, badania);

    }

    public List<BadanieTechniczne> znajdzBadania(String numerRejestracyjny){
        return badaniaTechniczne.getOrDefault(numerRejestracyjny, new ArrayList<>());
    }

    public BadanieTechniczne znajdzBadania(String numerRejestracyjny, int id){
        List<BadanieTechniczne> badania = badaniaTechniczne.getOrDefault(numerRejestracyjny, new ArrayList<>());
        for (BadanieTechniczne badanieTechniczne: badania){
            if(badanieTechniczne.getIdBadania() == id){
                return badanieTechniczne;
            }
        }
        return null;
    }

    public void aktualizujBadanie(String numerRejestracyjny, int id, BadanieTechniczne noweWartosciBadania){
        usunBadanie(numerRejestracyjny, id);
        dodajBadanie(noweWartosciBadania);

    }

    public void usunBadanie(String numerRejestracyjny, int id){
        List<BadanieTechniczne> badania = badaniaTechniczne.get(numerRejestracyjny);
        badania.removeIf(badanie -> badanie.getIdBadania() == id);

    }




}
