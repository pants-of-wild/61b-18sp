
public class NBody{
    public static double readRadius(String file) {	
		In obj = new In(file);
		int num = obj.readInt();
		double radius = obj.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String file) {
		In obj = new In(file);
		int num = obj.readInt();
		double r = obj.readDouble();
		Planet [] allPlanets = new Planet[num];
		for (int i = 0; i < num; i++) {	
				double xp = obj.readDouble();
				double yp = obj.readDouble();
				double vx = obj.readDouble();
				double vy = obj.readDouble();
				double m = obj.readDouble();
				String img = obj.readString();		
				allPlanets[i] = new Planet(xp,yp,vx,vy,m,img);		
		}
		return allPlanets;
	}
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
		double scale = readRadius(filename);
		Planet [] allPlanets = readPlanets(filename);
		StdDraw.setCanvasSize();
		StdDraw.setXscale(-scale, scale);
		StdDraw.setYscale(-scale, scale);
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		StdAudio.play("audio/2001.mid");
		for (int i = 0; i < allPlanets.length; i++) {
			allPlanets[i].draw();
		}
		StdDraw.enableDoubleBuffering();
		double t = 0;
		while (t < T) {
			double [] xForces = new double[allPlanets.length];
			double [] yForces = new double[allPlanets.length];
			for (int i = 0; i < allPlanets.length; i++) {
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}
			for(int i = 0; i < allPlanets.length; i++) {
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for (int i = 0; i < allPlanets.length; i++) {
			    allPlanets[i].draw();
		    }
		    StdDraw.show();
		    StdDraw.pause(10);
		    t += dt;
		}
		System.out.printf("%d\n", allPlanets.length);
        System.out.printf("%.2e\n", scale);
        for (int i = 0; i < allPlanets.length; i++) {
        System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
        }
	}

}
