import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();

        Scanner scanner = new Scanner(System.in);
        String tmpString;
        while (true) {
            System.out.println("Enter the name of the collection or 0 to exit.");
            tmpString = scanner.nextLine();
            switch (tmpString){
                case "pop":
                    read(pop);
                    break;
                case "jazz":
                    read(jazz);
                    break;
                case "rock":
                    read(rock);
                    break;
                case "country":
                    read(country);
                    break;
                case "0":
                    exit(0);
            }
        }
    }

    /**
     * it does each statement you want from the menu of music collection
     * @param musicCollection the collection we want to work with
     */
        private static void read (MusicCollection musicCollection) {
            Scanner scanner = new Scanner(System.in);
            String tmpString;
            int tmpInt;
            boolean condition = true;

            while (condition){
                System.out.println("choose a statement.");
                MusicCollection.printMenu();
                tmpInt = scanner.nextInt();
                String buf = scanner.nextLine();
                switch (tmpInt){
                    case 1:
                        Music music;
                        System.out.println("Enter the address of the music :");
                        tmpString = scanner.nextLine();
                        System.out.println("Enter the singer of the music :");
                        String singer = scanner.nextLine();
                        System.out.println("Enter the year of the music :");
                        String year = scanner.nextLine();
                        music = new Music(tmpString,singer,year);
                        musicCollection.addFile(music);
                        break;
                    case 2:
                        System.out.println("Enter the address or singer's name :");
                        tmpString = scanner.nextLine();
                        musicCollection.removeFile(musicCollection.searchForMusic(tmpString));
                        break;
                    case 3:
                        System.out.println("Enter the address or singer's name :");
                        tmpString = scanner.nextLine();
                        musicCollection.addToFavorite(musicCollection.searchForMusic(tmpString));
                        break;
                    case 4:
                        System.out.println("Enter the address or singer's name :");
                        tmpString = scanner.nextLine();
                        musicCollection.startPlaying(musicCollection.searchForMusic(tmpString));
                        break;
                    case 5:
                        musicCollection.stopPlaying();
                        break;
                    case 6:
                        System.out.println("Enter the address or singer's name :");
                        tmpString = scanner.nextLine();
                        musicCollection.listFile(musicCollection.searchForMusic(tmpString));
                        break;
                    case 7:
                        musicCollection.listAllFiles();
                        break;
                    case 8:
                        musicCollection.printFavoriteSongs();
                        break;
                    case 9:
                        System.out.println("Enter the address or singer's name :");
                        tmpString = scanner.nextLine();
                        musicCollection.removeFromFavorite(musicCollection.searchForMusic(tmpString));
                        break;
                    case 10:
                        condition = false;
                        break;
                }
        }
    }

}