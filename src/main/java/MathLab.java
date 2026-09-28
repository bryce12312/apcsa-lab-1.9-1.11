/**
 * AP CSA Lab 1.9-1.11 - Method Signatures, Class Methods, and the Math Class
 *
 * Fill in the body of each method marked TODO below. Do not rename anything,
 * do not change the parameter lists, and do not change the return types. The
 * grader compiles against these exact signatures.
 *
 * Every method here is public static, which makes it a CLASS METHOD: it
 * belongs to the class MathLab itself, not to any object. Nothing in this lab
 * is ever constructed with new.
 *
 * Run the program with:  mvn -q compile exec:java
 * Or from your IDE, just run main.
 */
public class MathLab
{
    // ---------------------------------------------------------------
    // PART 1: parameters are variables, and arguments are matched by position
    //
    // Return the total number of minutes in the given hours and minutes.
    //
    // Look at the header below and read it left to right: public, then static,
    // then the return type int, then the name, then the parameter list.
    //
    //     public static int totalMinutes(int hours, int minutes)
    //
    // The SIGNATURE is only the name plus the ordered list of parameter types:
    //
    //     totalMinutes(int, int)
    //
    // The return type, the modifiers and the parameter names are NOT part of
    // the signature. hours and minutes are PARAMETERS: variables declared in
    // the header that you may use anywhere in the body. When someone calls the
    // method, the values they pass in are the ARGUMENTS, and they are matched
    // to the parameters by POSITION, never by name.
    //
    // Example: totalMinutes(2, 30) is 150, because 2 hours is 120 minutes
    // Example: totalMinutes(0, 45) is 45
    // Example: totalMinutes(1, 59) is 119
    //
    // Careful: order matters. totalMinutes(2, 30) and totalMinutes(30, 2) call
    // the same method and give completely different answers, because the first
    // argument always lands in the first parameter.
    // ---------------------------------------------------------------
    public static int totalMinutes(int hours, int minutes)
    {
        // TODO Part 1: return the number of minutes in the given hours
        // and minutes
        
        return hours * 60 + minutes;
    }

    // ---------------------------------------------------------------
    // PART 2: call the method you already wrote
    //
    // Return the total number of seconds in the given hours and minutes.
    //
    // You already have a method that turns hours and minutes into minutes, so
    // do not do that arithmetic again. Call totalMinutes and multiply what it
    // gives back by 60.
    //
    // A class method is normally called as ClassName.methodName(arguments):
    //
    //     MathLab.totalMinutes(hours, minutes)
    //
    // When the call sits inside the class that declares the method -- and this
    // one does -- the class name is optional, so this works too:
    //
    //     totalMinutes(hours, minutes)
    //
    // Either form is fine here. From any OTHER class, the class name is
    // required.
    //
    // totalMinutes is a non-void method, so the call is an expression with a
    // value: store it in a variable or use it inside a bigger expression. The
    // call is a detour, not a jump -- Java runs the whole body of
    // totalMinutes, then comes right back to the point immediately after the
    // call, carrying the returned value with it.
    //
    // Example: totalSeconds(2, 30) is 9000, because 150 minutes is 9000 seconds
    // Example: totalSeconds(0, 1)  is 60
    //
    // Careful: the arguments go in the same order you received them.
    // totalMinutes(minutes, hours) compiles -- both parameters are ints -- and
    // is silently wrong.
    // ---------------------------------------------------------------
    public static int totalSeconds(int hours, int minutes)
    {
        // TODO Part 2: call totalMinutes, then multiply its result by 60

        return totalMinutes(hours,minutes)* 60;
    }

    // ---------------------------------------------------------------
    // PART 3: a void method returns nothing, so calling it is a statement
    //
    // PRINT one line in exactly this form, with a colon and one space between
    // the name and the count, followed by a newline:
    //
    //     Pencils: 12
    //
    // This method is declared void, which means it hands nothing back. A void
    // method is never part of an expression and can never sit on the right of
    // an assignment -- there is no value to assign. You call it as a statement
    // on a line by itself:
    //
    //     printLabel("Pencils", 12);        // correct
    //     String s = printLabel("x", 1);    // will not compile: no value
    //
    // Use System.out.println so the line ends with a newline.
    //
    // Example: printLabel("Pencils", 12) prints   Pencils: 12
    // Example: printLabel("Erasers", 0)  prints   Erasers: 0
    //
    // Careful: this is the only part of the lab that is supposed to print, and
    // it must print exactly one line and nothing else. Do not add a label like
    // "count = ", do not use System.out.print (that leaves off the newline),
    // and do not write a return statement with a value in a void method.
    // ---------------------------------------------------------------
    public static void printLabel(String name, int count)
    {
        // TODO Part 3: print the name, a colon, a space, and the count
        System.out.println(name+":"+count);
    }

    // ---------------------------------------------------------------
    // PART 4a: Math.abs, and two methods that share one name
    //
    // Return how far n is from zero, using Math.abs.
    //
    // Math is a class in the package java.lang, which every program gets for
    // free, so there is no import to write. Math contains only class methods,
    // so you always call them on the class name:
    //
    //     Math.abs(-7)       gives the int    7
    //     Math.abs(-7.5)     gives the double 7.5
    //
    // Those are two different methods that happen to share the name abs. That
    // is called OVERLOADING, and it is legal because their signatures differ:
    // abs(int) and abs(double). The ARGUMENT TYPE decides which one runs. The
    // return type never decides -- Java has already picked the method before
    // it looks at what you do with the answer.
    //
    // Part 4a and Part 4b below are your own overloaded pair. Same name,
    // different parameter lists, so both may exist at once.
    //
    // Example: distanceFromZero(-5) is 5
    // Example: distanceFromZero(17) is 17
    //
    // Careful: leave BOTH methods in the file. If either one is missing, the
    // grader will not find the signature it needs.
    // ---------------------------------------------------------------
    public static int distanceFromZero(int n)
    {
        // TODO Part 4a: return the absolute value of n with Math.abs

        return Math.abs(n);
    }

    // ---------------------------------------------------------------
    // PART 4b: the same name, a different parameter list
    //
    // Return how far n is from zero, using Math.abs -- this time for a double.
    //
    // This is a separate method, not a copy of Part 4a. Because the parameter
    // is a double, the call Math.abs(n) reaches the double version of abs,
    // which gives a double back, decimal part and all.
    //
    // Example: distanceFromZero(-5.5)  is 5.5
    // Example: distanceFromZero(0.125) is 0.125
    //
    // Careful: do not cast n to an int on the way in. Math.abs((int) n) would
    // throw away the decimal part and turn -5.5 into 5.
    // ---------------------------------------------------------------
    public static double distanceFromZero(double n)
    {
        // TODO Part 4b: return the absolute value of n with Math.abs
        return Math.abs(n);
    }

    // ---------------------------------------------------------------
    // PART 5: Math.sqrt, with a nested expression as its argument
    //
    // Return the length of the long side of a right triangle whose two short
    // sides are a and b. That length is the square root of a * a + b * b.
    //
    // Math.sqrt takes one double and returns a double: the nonnegative square
    // root. Its return type is double, and this method's return type is also
    // double, so nothing needs a cast.
    //
    // The argument you pass may be any expression, including arithmetic or
    // another method call. Java works from the inside out: it finishes the
    // expression first, then hands the finished value to sqrt.
    //
    //     Math.sqrt(a * a + b * b)
    //
    // Example: hypotenuse(3.0, 4.0)  is 5.0
    // Example: hypotenuse(5.0, 12.0) is 13.0
    //
    // Careful: the square root of a sum is not the sum of the square roots.
    // Math.sqrt(a * a) + Math.sqrt(b * b) is just a + b, which would make
    // hypotenuse(3.0, 4.0) come out as 7.0.
    // ---------------------------------------------------------------
    public static double hypotenuse(double a, double b)
    {
        // TODO Part 5: return the square root of a * a + b * b
    
        return Math.sqrt(a*a+b*b);
    }

    // ---------------------------------------------------------------
    // PART 6: Math.pow always hands back a double
    //
    // Return base raised to the power exponent, as an int.
    //
    // Math.pow(base, exponent) raises the FIRST argument to the power of the
    // SECOND, and it returns a double every single time -- even when the
    // answer is a whole number. Math.pow(3, 4) is 81.0, not 81.
    //
    // This method must return an int, and Java will not quietly squeeze a
    // double into an int: that is narrowing, and narrowing needs an explicit
    // cast.
    //
    //     int r = Math.pow(3, 4);          // will not compile
    //     int r = (int) Math.pow(3, 4);    // 81
    //
    // Example: powerOf(2, 10) is 1024
    // Example: powerOf(5, 3)  is 125
    // Example: powerOf(2, 0)  is 1
    //
    // Careful: the base comes first. powerOf(2, 10) is 1024, while swapping
    // the two arguments would give 100 instead.
    // ---------------------------------------------------------------
    public static int powerOf(int base, int exponent)
    {
        // TODO Part 6: return Math.pow(base, exponent), cast to an int
        return (int) Math.pow(base, exponent);
    }

    // ---------------------------------------------------------------
    // PART 7: Math.random, scaled, cast, and shifted into a range
    //
    // Return a random int from min to max, with BOTH ends included.
    //
    // Math.random() takes no arguments -- the empty parentheses are required,
    // not optional -- and returns a double that is greater than or equal to
    // 0.0 and strictly less than 1.0. It can return exactly 0.0; it can never
    // return 1.0.
    //
    // To turn that into a whole number in a range you scale, cast, and shift:
    //
    //     (int) (Math.random() * count) + min
    //
    // count is how many different values you want, and you get it by COUNTING
    // them, not by subtracting: from min to max inclusive there are
    // max - min + 1 of them. From 1 to 6 that is 6 values, so
    // (int) (Math.random() * 6) + 1 gives 1 through 6.
    //
    // Check both ends before you believe it. Substitute 0.0 for Math.random()
    // to get the smallest value you can produce, then substitute a value just
    // under 1.0 to get the largest. If either end is wrong, the multiplier or
    // the amount you add is wrong.
    //
    // Example: rollInRange(1, 6) can be any of 1, 2, 3, 4, 5, 6
    // Example: rollInRange(10, 20) can be any of the 11 values 10 through 20
    // Example: rollInRange(7, 7) is always 7
    //
    // Careful: the parentheses around the multiplication are the whole trick.
    // (int) Math.random() * 6 + 1 casts Math.random() by itself, which is
    // always 0, so that line always gives 1. Cast the product, not the call.
    // ---------------------------------------------------------------
    public static int rollInRange(int min, int max)
    {
        // TODO Part 7: return a random int from min to max, both included
        int count = max - min + 1;
        return (int) (Math.random()*count) + min;
    }

    // ---------------------------------------------------------------
    // Run this to see your own work. The grader does not test main, so you
    // may change it freely while you experiment. Part 7 prints a different
    // number nearly every run -- that is the point of it.
    // ---------------------------------------------------------------
    public static void main(String[] args)
    {
        System.out.println("totalMinutes(2, 30)       = " + totalMinutes(2, 30));
        System.out.println("totalSeconds(2, 30)       = " + totalSeconds(2, 30));
        System.out.print("printLabel(Pencils, 12)   -> ");
        printLabel("Pencils", 12);
        System.out.println("distanceFromZero(-5)      = " + distanceFromZero(-5));
        System.out.println("distanceFromZero(-5.5)    = " + distanceFromZero(-5.5));
        System.out.println("hypotenuse(3.0, 4.0)      = " + hypotenuse(3.0, 4.0));
        System.out.println("powerOf(2, 10)            = " + powerOf(2, 10));
        System.out.println("rollInRange(1, 6)         = " + rollInRange(1, 6));
    }
}
