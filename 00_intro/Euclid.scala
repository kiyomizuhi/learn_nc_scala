object Euclid extends App {

    def gretestCommonDivisorRec(a: Int, b: Int): Int = {
        if (a == 0) {
            b
        } else if (b == 0) {
            a
        } else {
            gretestCommonDivisorRec(b, a % b)
        }
    }

    println(gretestCommonDivisorRec(24, 36))
}