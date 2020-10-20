public class Music {

    private String address;
    private String singer;
    private String year;
    private boolean isFavorite;

    public Music (String address, String singer, String year){
        this.address = address;
        this.singer = singer;
        this.year = year;
        isFavorite = false;
    }

    /**
     * @return the address of music
     */
    public String getAddress (){
        return address;
    }

    /**
     * @return true if it's a favorite and false if it's not
     */
    public boolean isFavorite(){
        return isFavorite;
    }

    /**
     * @return the name of the singer
     */
    public String getSinger(){
        return singer;
    }

    /**
     * @return the year of the song
     */
    public String getYear(){
        return year;
    }

    /**
     * will make the music a favorite
     */
    public void addToFavorite (){
        isFavorite = true;
    }

    /**
     * will make the music a non-favorite music
     */
    public void removeFromFavorite (){
        isFavorite = false;
    }





}
