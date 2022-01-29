fun main(){
    val userName = "Krystiane"
    var age = 27

    Int

    println("Hello World! My name is $userName. I am $age years old. In 2 years, I'll be ${age + 2}.")

    var a = 5
    val b = 3.0

//    val result:Int = a + b
    println("a = " + a + "b = " + b)

    println("a + b = ${a+b}")
    println("a - b = ${a-b}")
    println("a * b = ${a*b}")
    println("a / b = ${a/b}")
    println("a % b = ${a%b}")
    println("a + b * a = ${a+b*a}")

    a += 2
    println("-a = ${-a}")

    val names: Array<String> = arrayOf("Krystiane", "Hazel", "Axel", "Mike")

    println("First element: ${names[0]}")

    var monthInput = readLine()!!
    print("You entered = $monthInput")
}
