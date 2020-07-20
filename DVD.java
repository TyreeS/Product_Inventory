/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsmith
 */
public class DVD extends Product{
    
    //Instance variables
    private int movie_length; 
    private int age_rating;
    private String film_studio = " ";
    
    /*Default Constructor 
    super() call used tot he constructor in Product passing the reuired parameters
    */
    public DVD(){
        super();
        this.movie_length = movie_length;
        this.age_rating = age_rating;
        this.film_studio = film_studio;
    }
    
    /*Constructor that accepts values for every instance field required for both DVD and Product class 
    super() call used tot he constructor in Product passing the reuired parameters
    */
    public DVD(String product_name, int unit_amount, double unit_price, String product_status, int movie_length, int age_rating, String film_studio){
        super(product_name, unit_amount, unit_price, product_status);
        this.movie_length = movie_length;
        this.age_rating = age_rating;
        this.film_studio = film_studio;
    }

    //Encapsulated fields getters and setters for DVD instance 
    /**
     * @return the movie_length
     */
    public int getMovie_length() {
        return movie_length;
    }

    /**
     * @param movie_length the movie_length to set
     */
    public void setMovie_length(int movie_length) {
        this.movie_length = movie_length;
    }

    /**
     * @return the age_rating
     */
    public int getAge_rating() {
        return age_rating;
    }

    /**
     * @param age_rating the age_rating to set
     */
    public void setAge_rating(int age_rating) {
        this.age_rating = age_rating;
    }

    /**
     * @return the film_studio
     */
    public String getFilm_studio() {
        return film_studio;
    }

    /**
     * @param film_studio the film_studio to set
     */
    public void setFilm_studio(String film_studio) {
        this.film_studio = film_studio;
    }
    
    /*Override toString() method to include the new DVD fields
     Stock Value needs calculated and displayed when the toString() method is invoked
    */
    @Override
    public String toString(){
        return String.format("Item number:\t %d \nName of DVD:\t %s \nMovie length:\t %s \nAge rating:\t %s \nFilm Studio:\t %s\nUnits in stock:\t %d \nPrice of unit:\t $%.2f \nStock Value:\t $%.2f \nProduct Status:\t %s \n\n", getItem_number(), getProduct_name(), movie_time(), age(), film_studio, getUnit_amount(), getUnit_price(), stockValue(), status());
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
    
    //Calculates time in hours and minutes 
    public String movie_time(){
        String time = " ";
        int hour, minute; 
        if(getMovie_length() >= 60){
            hour = getMovie_length() / 60;
            minute = getMovie_length() % 60;
            time = hour + " " +  "hour(s)" + " " + minute + " " +"minute(s)";
        }
        if(getMovie_length() < 60 && getMovie_length() > 40){
            time = "1 hour";
        }
        if(getMovie_length() <= 40){
            time = "Short film";
        }
        return time;
    }
    
    //Converts age to Rating 
    public String age(){
        String rating = " ";
        if(getAge_rating() < 13){
            rating = "Rated G: General audiences – All ages admitted";
        }
        if(getAge_rating() >= 13 && getAge_rating() < 18){
            rating = "Rated PG13: Parental guidance suggested – Some material may not be suitable for pre-teenagers";
        }
        if(getAge_rating() >= 18){
            rating = "Rated R: Restricted – Under 18 requires accompanying parent or adult guardian.";
        }
        else{
            rating = "NR: Not yet rated";
        }
        
        return rating;
    }
}
