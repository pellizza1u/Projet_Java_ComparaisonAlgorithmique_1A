public class Arc {
    private String dest;
    private double cout;

    public Arc(String destination, double c){
        this.dest=destination;
        if(c>0){
            this.cout=c;
        } else{this.cout=0;
            }
    }

    public double getCout() {
        return cout;
    }

    public String getDest() {
        return dest;
    }

}
