class Box{
    double l ;
    double w ;
    double h ;
    Box(){
        this.l = -1.2;
        this.w = 2.9;
        this.h = -3.4;
    }

    Box(double x, double y, double z){
        this.l = x;
        this.h = y;
        this.w = z;
    }
    Box(double x){
        this.l = x;
    }

    Box(Box obj){
        this.h = obj.h;
        this.l = obj.l;
        this.w = obj.w;
    }
}
