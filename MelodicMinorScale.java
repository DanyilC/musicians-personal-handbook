import java.util.*;

public class MelodicMinorScale extends Scale {
    public MelodicMinorScale(){
        this.intervals = new ArrayList<Integer>();
        this.scale = new ArrayList<Double>();
    }// end Scale default initializer

    public MelodicMinorScale(Double startingFrequency){
        this.intervals = new ArrayList<Integer>(){
            {
                add(2);
                add(1);
                add(2);
                add(2);
                add(2);
                add(2);
                add(1);
            }
        };
        this.scale = findScale(startingFrequency);
        this.name = NotesConversions.findCorrespondingNote(this.scale.get(0));
    }// end Scale initializer
   
    public ArrayList<Double> getScale(){
        return this.scale;
    }
    
    public String rootNote(){
        return NotesConversions.findCorrespondingNote(this.scale.get(0));
    }

    @Override
    public String getName(){
        return this.name;
    }
}
