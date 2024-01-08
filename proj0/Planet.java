public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet other) {
        this.xxPos = other.xxPos;
        this.yyPos = other.yyPos;
        this.xxVel = other.xxVel;
        this.yyVel = other.yyVel;
        this.mass = other.mass;
        this.imgFileName = other.imgFileName;
    }

    public double calcDistance(Planet p2) {
        return Math.sqrt((p2.xxPos - this.xxPos) * (p2.xxPos - this.xxPos) +
                (p2.yyPos - this.yyPos) * (p2.yyPos - this.yyPos));
    }


    public double calcForceExertedBy(Planet p2) {
        double r = calcDistance(p2);
        return G * this.mass * p2.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p2) {
        return calcForceExertedBy(p2) * (p2.xxPos - this.xxPos) / calcDistance(p2);
    }

    public double calcForceExertedByY(Planet p2) {
        return calcForceExertedBy(p2) * (p2.yyPos - this.yyPos) / calcDistance(p2);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double f = 0.0;
        for (Planet planet : planets) {
            if (planet != this) {
                f += calcForceExertedByX(planet);
            }
        }
        return f;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double f = 0.0;
        for (Planet planet : planets) {
            if (planet != this) {
                f += calcForceExertedByY(planet);
            }
        }
        return f;
    }

    public void update(double t, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + t * ax;
        this.yyVel = this.yyVel + t * ay;
        this.xxPos = this.xxPos + t * this.xxVel;
        this.yyPos = this.yyPos + t * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
    }
}
