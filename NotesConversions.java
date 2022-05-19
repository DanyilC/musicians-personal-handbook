import java.util.*;

public class NotesConversions {
    public static void main(String[] args){
            System.out.println(NotesConversions.findCorrespondingFrequency("5C"));
        
    
    
        } // end main
    public static ArrayList<String> notes = new ArrayList<String>(){
        {
            add("C");
            add("C#/Db");
            add("D");
            add("D#/Db");
            add("E");
            add("F");
            add("F#/Gb");
            add("G");
            add("G#/Ab");
            add("A");
            add("A#/Bb");
            add("B");
        }
    }; // total size is 12!

    public static ArrayList<Double> frequencies = new ArrayList<Double>(){
        {
            this.add(27.500);
            for(int i = 0; i < 96; i++){
                this.add(this.get(i)*Math.pow(2, 0.08333333333));
            }
            for(int j = 0; j < 97; j++){
                this.set(j, Math.round(this.get(j)*1000.000)/1000.000);
            }
        }
    }; // total size will be 97!

    public static String findCorrespondingNote(double frequency){
        int octave = 0;
        int j = 9; // note that is at index 9 of notes arraylist corresponds to the first frequency that is in frequencies arraylist
        for(int i = 0; i < frequencies.size(); i++){
            if(frequency == frequencies.get(i)){
                return octave + notes.get(j);
            }
            else if(frequency != frequencies.get(i)){
                j += 1;
                if(j == 12){
                    j = 0;
                    octave += 1;
                }
            }
        }
        return null;
    } // end findCorrespondingNote

    public static Double findCorrespondingFrequency(String note){
        char[] noteChars = note.toCharArray();

        int octave = Integer.parseInt(String.valueOf(noteChars[0]));
        String noteString = "";
        for(int i = 1; i < noteChars.length; i++){
            noteString += noteChars[i];
        }

        int k = 9;
        int compOctave = 0;
        for(int j = 0; j < frequencies.size(); j++){
            if((compOctave == octave) && (noteString.equals(notes.get(k)))){
                return frequencies.get(j);
            }
            else if((compOctave != octave) || (!noteString.equals(notes.get(k)))){
                k += 1;
                if(k == 12){
                    k = 0;
                    compOctave += 1;
                }
            }
        }
        return null;
    } // end findCorrespondingFrequency
}
