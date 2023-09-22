import java.lang.Math;
public class Planet {
	public double xxPos, yyPos;
	public double xxVel, yyVel;
	public double mass;
	public String imgFileName;
	static final double G = 6.67e-11;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
		
	}
	public Planet(Planet p) {
		xxPos =  p.xxPos;
		yyPos =  p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet obj) {
		return Math.sqrt((xxPos - obj.xxPos) * (xxPos - obj.xxPos) + (xxPos - obj.yyPos) * (yyPos - obj.yyPos));
	}
	public double calcForceExertedBy(Planet obj) {
		double r = calcDistance(obj);
		double ForceExertedBy = G * mass * obj.mass / (r * r);
		return ForceExertedBy;
	}
	public double calcForceExertedByX(Planet obj) {
		double ForceExertedByX = calcForceExertedBy(obj) * (obj.xxPos - xxPos) / calcDistance(obj);
		return ForceExertedByX;
	}
	public double calcForceExertedByY(Planet obj) {
		double ForceExertedByY = calcForceExertedBy(obj) * (obj.yyPos - yyPos) / calcDistance(obj);
		return ForceExertedByY;
	}
	public double calcNetForceExertedByX(Planet [] allPlanets) {
		double NetForceExertedByX = 0;
		for (int i = 0; i < allPlanets.length; i++) {
		    if(allPlanets[i] != this){
			NetForceExertedByX += calcForceExertedByX(allPlanets[i]);
		    }
	    }
	     return NetForceExertedByX;
    }
    public double calcNetForceExertedByY(Planet [] allPlanets) {
		double NetForceExertedByY = 0;
		for (int i = 0; i < allPlanets.length; i++) {
			if(allPlanets[i] != this) {
			    NetForceExertedByY += calcForceExertedByY(allPlanets[i]);
			}
		}
	     return NetForceExertedByY;
    }
    public void update(double dt, double fX, double fY) {
    	double ax = fX / mass;
    	double ay = fY / mass;
    	xxVel += ax * dt;
    	yyVel += ay * dt;
    	xxPos += dt * xxVel;
    	yyPos += dt * yyVel;
    }
    public void draw() {
    	StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}
}