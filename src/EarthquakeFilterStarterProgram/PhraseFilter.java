package EarthquakeFilterStarterProgram;

/**
 * Created by revu on 2/26/17.
 */
public class PhraseFilter implements Filter{
    private String pos;
    private String searchPhrase;
    private String filterName;
    PhraseFilter(String pos, String phrase){
        this.pos = pos;
        this.searchPhrase = phrase;
        filterName = "phraseFilter";
    }
    public String getName(){
        return filterName;
    }

    public boolean satisfies(QuakeEntry qe){
        String quakeTitle = qe.getInfo();

        if(pos.equals("start")){
            return quakeTitle.startsWith(searchPhrase);
        }else if(pos.equals("end")){
            return quakeTitle.endsWith(searchPhrase);
        }else{
            return quakeTitle.contains(searchPhrase);
        }
    }
}
