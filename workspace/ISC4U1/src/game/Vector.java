package game;

public class Vector {
	private double mag, angle;
	
	public Vector(double mag, double angle) {
		this.mag = mag;
		this.angle = Math.toRadians(angle);
	}
	
	public double get_mag() {
		return this.mag;
	}
	
	public double get_angle() {
		return Math.toDegrees(this.angle);
	}
	
	
	public static void vector_add(Vector v1, Vector v2) {
		double angle_relative = Math.toRadians(180) -(v2.angle - v1.angle);
		System.out.println(Math.toDegrees(angle_relative));
		double new_mag = Math.sqrt(Math.pow(v1.mag,2) +Math.pow(v2.mag,2) - (2*v1.mag*v2.mag*Math.cos(angle_relative)));
		double new_angle = Math.toDegrees(Math.asin(v2.mag * Math.sin(angle_relative) / v1.mag));
		v1.mag = new_mag;
		v1.angle = new_angle;
	}
	
	public static Vector vector_add_new(Vector v1, Vector v2) {
		double angle_relative = Math.toRadians(180) -(v2.angle - v1.angle);
		System.out.println(Math.toDegrees(angle_relative));
		double new_mag = Math.sqrt(Math.pow(v1.mag,2) +Math.pow(v2.mag,2) - (2*v1.mag*v2.mag*Math.cos(angle_relative)));
		double new_angle = Math.asin(v2.mag * Math.sin(angle_relative) / v1.mag);
		return new Vector(new_mag, Math.toDegrees(new_angle));
	}
}
