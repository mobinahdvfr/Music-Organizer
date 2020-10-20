import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param music The file to be added.
     */
    public void addFile(Music music)
    {
        files.add(music);
        System.out.println("done.");
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if (validIndex(index)) {
            System.out.println("***************************");
            System.out.println("file's address : " + files.get(index).getAddress());
            System.out.println("song's singer : " + files.get(index).getSinger());
            System.out.println("song's year : " + files.get(index).getYear());
            System.out.println("***************************");
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for (int i = 0 ; i<files.size() ; i++){
            listFile(i);
        }
        if (files.size() == 0)
            System.out.println("collection's empty!");
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if (validIndex(index)) {
            files.remove(index);
            System.out.println("done.");
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if (validIndex(index)) {
            player.startPlaying(files.get(index));
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * it will add the music to favorite musics
     * @param index index of the specific file
     */
    public void addToFavorite (int index){
        if (validIndex(index)){
            files.get(index).addToFavorite();
            System.out.println("done.");
        }
    }

    /**
     * it removes the music from the favorites
     * @param index index of the music
     */
    public void removeFromFavorite (int index){
        if (validIndex(index)){
            files.get(index).removeFromFavorite();
            System.out.println("done.");
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        return index < files.size() && index > -1;
    }

    /**
     * prints the favorite songs
     */
    public void printFavoriteSongs (){
        for (Music music : files){
            if (music.isFavorite()){
                listFile(files.indexOf(music));
            }
        }
    }

    /**
     * it searches for a music
     * @param string the address or singer of the music
     * @return if there is 1 song, it will return the index, else -1
     */
    public int searchForMusic (String string){
        int i =0;
        int index =0;
        for (Music music : files){
//            if (music.getAddress().equals(string) || music.getSinger().equals(string)){
//                return files.indexOf(music);
//            }
            if (music.getAddress().equals(string))
                return files.indexOf(music);
            else if (music.getSinger().equals(string)){
                i++;
                index = files.indexOf(music);
            }
        }
        if (i > 1){
            System.out.println("there are more than 1 song! try the music's address.");
            return -1;
        } else if (i == 1){
            return index;
        }
        System.out.println("No file with this information!");
        return -1;
    }

    /**
     * prints the menu of statements
     */
    public static void printMenu (){
        System.out.println("1. Add a file.");
        System.out.println("2. Remove a file.");
        System.out.println("3. Add to favorite.");
        System.out.println("4. Play a music.");
        System.out.println("5. Stop playing.");
        System.out.println("6. show a song's info.");
        System.out.println("7. print all my musics.");
        System.out.println("8. print my favorite songs.");
        System.out.println("9. remove from favorite.");
        System.out.println("10. done with this collection.");
    }


}