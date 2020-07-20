/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsmith
 */
public class CD extends Product{
    
    //Instance variables
    private String artist = " ", record_label = " "; 
    private int songs_on_album;
    
    /*Default Constructor 
    super() call used tot he constructor in Product passing the reuired parameters
    */
    public CD(){
        super();
        this.artist = artist;
        this.songs_on_album = songs_on_album;
        this.record_label = record_label;
    }
    
    /*Constructor that accepts values for every instance field required for both CD and Product class 
    super() call used tot he constructor in Product passing the reuired parameters
    */
    public CD(String product_name, int unit_amount, double unit_price, String product_status, String artist, int songs_on_album, String record_label){
        super(product_name, unit_amount, unit_price, product_status);
        this.artist = artist;
        this.songs_on_album = songs_on_album;
        this.record_label = record_label;
    }

    //Encapsulated fields getters and setters for CD instance 
    /**
     * @return the movie_length
     */
    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return the record_label
     */
    public String getRecord_label() {
        return record_label;
    }

    /**
     * @param record_label the record_label to set
     */
    public void setRecord_label(String record_label) {
        this.record_label = record_label;
    }

    /**
     * @return the songs_on_album
     */
    public int getSongs_on_album() {
        return songs_on_album;
    }

    /**
     * @param songs_on_album the songs_on_album to set
     */
    public void setSongs_on_album(int songs_on_album) {
        this.songs_on_album = songs_on_album;
    }
    
    /*Override toString() method to include the new CD fields
     Stock Value needs calculated and displayed when the toString() method is invoked
    */
    @Override
    public String toString(){
        return String.format("Item number:\t %d \nName of CD:\t %s \nName of Artist:\t %s \nSongs on Album:\t %d \nRecord label:\t %s\nUnits in stock:\t %d \nPrice of unit:\t $%.2f \nStock Value:\t $%.2f \nProduct Status:\t %s \n\n", getItem_number(), getProduct_name(), artist, songs_on_album, record_label, getUnit_amount(), getUnit_price(), stockValue(), status());
    }
    
    /*override the method stockValue
      add a 5% restocking fee to the value of the inventory of that product.
    */
    @Override
    public double stockValue(){
        double restock_fee = 0.05; // 5% restocking fee to the value
        double value = restock_fee * (getUnit_amount() * getUnit_price()) + (getUnit_amount() * getUnit_price());
        return value;
    }
    
}
