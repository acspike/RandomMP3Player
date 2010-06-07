
/*
 * Download from http://www.javazoom.net/javalayer/sources.html
 * Unarchive JLayer into source directory
 * 
 * Build with something like:
 *  javac -classpath JLayer1.0.1/classes/ RandomMP3Player.java
 * Run with something like:
 *  java -classpath .:jl1.0.1.jar RandomMP3Player 10 z.mp3 1.mp3
 *
 */
import javazoom.jl.player.*;
import java.io.*;
import java.util.Random;

public class RandomMP3Player {
 public static void main(String[] args) {
  if(args.length < 2){
     System.out.println( "Usage: RandomMP3Player <seconds> <filename1> [<filenameN> ...]" );
     System.exit(0);
  }
  int time = Integer.parseInt(args[0]);
  Random rnd = new Random();
  
  while(true){
    try{
        int sound = rnd.nextInt(args.length-1);
        InputStream is = new FileInputStream(args[sound+1]);
        Player player = new Player(is);
        player.play();
        Thread.sleep(rnd.nextInt(time)*1000);
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }
 }
}
