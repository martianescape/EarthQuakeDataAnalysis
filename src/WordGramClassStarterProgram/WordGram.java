package WordGramClassStarterProgram;

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        return myWords.length;
    }

    public String toString(){
        StringBuilder ret = new StringBuilder();
        // TODO: Complete this method
        for(String str: myWords){
           ret.append(str);
           ret.append(" ");
        }
        return ret.toString().trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram)o;
        int ind= 0;
        for(String str: myWords){
            if (!str.equals(other.myWords[ind])){
                return false;
            }
            ind++;
        }
        return true;
        // TODO: Complete this method

    }

    public WordGram shiftAdd(String word) {	
        WordGram out = new WordGram(myWords, 0, myWords.length);
        for(int i = 0; i< myWords.length-1; i++){
            out.myWords[i] = out.myWords[i+1];
        }
        out.myWords[myWords.length-1] = word;
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        // TODO: Complete this method
        return out;
    }

}