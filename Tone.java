import javax.sound.sampled.*;

public class Tone {
    public static float sampleRate = 48000;
    public static void sound(double hz, int msecs, double vol) throws LineUnavailableException{
        
        if (hz <= 0)
        throw new IllegalArgumentException("Frequency <= 0 hz");

        if (msecs <= 0)
        throw new IllegalArgumentException("Duration <= 0 msecs");

        if (vol > 1.0 || vol < 0.0)
        throw new IllegalArgumentException("Volume out of range 0.0 - 1.0");

        byte[] buffer = new byte[(int)sampleRate * msecs / 1000];

        for (int i=0; i<buffer.length; i++) {
            double angle = i / (sampleRate / hz) * 2.0 * Math.PI;
            buffer[i] = (byte)(Math.sin(angle) * 127.0 * vol);
        }

        // shape the front and back 10ms of the wave form
        for (int i=0; i < sampleRate / 100.0 && i < buffer.length / 2; i++) {
            buffer[i] = (byte)(buffer[i] * i / (sampleRate / 100.0));
            buffer[buffer.length-1-i] = (byte)(buffer[buffer.length-1-i] * i / (sampleRate / 100.0));
        }

        AudioFormat aF = new AudioFormat(sampleRate,8,1,true,false);
        SourceDataLine sDL = AudioSystem.getSourceDataLine(aF);
        sDL.open(aF);
        sDL.start();
        sDL.write(buffer,0,buffer.length);
        sDL.drain();
        sDL.close();
        }
}
