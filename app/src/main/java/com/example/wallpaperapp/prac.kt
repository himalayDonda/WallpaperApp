package com.example.wallpaperapp

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.withTimeout

// abstract class
//- cannot be instantiated

// diff bw interface and abstract class
// interface cannot hold state
// diff bw interface and abstract class ends
abstract class Calculator {
    abstract fun cal(x: Int, y: Int): Int
}

class add: Calculator() {
    override fun cal(x: Int, y: Int): Int {
        return x+y
    }
}

class sub: Calculator(){
    override fun cal(x: Int, y: Int): Int {
        return x-y
    }
}

// interface
interface CalculatorInterface {
    fun inCalc(x: Int, y: Int): Int
}

class intAdd: CalculatorInterface {
    override fun inCalc(x: Int, y: Int): Int {
        return x+y
    }
}

fun main() {
    var addCal = add()
    addCal.cal(1,2)

    var intAdd = intAdd()
    intAdd.inCalc(1,2)

}

// Open class-----------------
/* Java: final class: A class that cannot be extended
 Kotlin:  Kotlin has a special feature i.e. classes and methods are not open for extension by default,
 which means they are by default final class or final function.
 It means Open classes and methods in Kotlin are equivalent to the opposite of final in Java,
 an open method is overridable and an open class is extendable in Kotlin.*/

open class geeks{
    open fun student():String ="alok" // if we remove open, then we cannot override in batch class
}

class batch: geeks(){
    override fun student(): String {
        return super.student()
    }
}

// Open class ends-----------------

// interface vs abstract class kotlin ---------------------------------------------------
//interfaces cannot store state whereas abstract classes can.

// interface vs abstract class kotlin ends ---------------------------------------------------

// init, constructor kotlin ---------------------------------------------------
//The code inside the init block is the first to be executed when
//    the class is instantiated. The init block is run every time the class
//is instantiated, with any kind of constructor as we shall see next.
//Multiple initializer blocks can be written in a class.

//The most common usage of secondary constructors comes in subclasses when you need to
//initialize the class in different ways. If the class contains a primary constructor,
//the secondary constructor must refer to it in its declaration.
//The declaration is done using this keyword.

class Student(var name: String, val age: Int) {
    var skill: String = ""
    init {
        skill = "NA"
    }
    constructor(name: String, age: Int, skill: String) : this(name, age) {
        this.skill = skill
    }
    fun printDetails() {
        if (skill.equals("NA"))
            println("Name is $name and Age is $age")
        else
            println("Name is $name and Age is $age Skill is $skill")
    }
}

// init, constructor kotlin ends ---------------------------------------------------

// Visibility modifiers-----------------------------------------------------

//Public : Any class, function, property, interface, or object that has this modifier is
//visible and can be accessed from anywhere.
//Private: A class/function defined with this modifier can be only accessed within the same file.
//A member/property in a class/function with this modifier can be only accessed within that block.
//Protected : This modifier is same as private, except that it allows visibility and access
//within subclasses.
//Internal: A class/interface/function with this modifier is accessible only within the same module.

// Visibility modifiers ends-----------------------------------------------------

// Diff bw val and const------------------------------------------------
//By default val properties are set at runtime.
//Adding a const modifier on a val would make a compile-time constant.
//A const cannot be used with a var or on its own. A const is not applicable on a local variable.
// Diff bw val and const ends------------------------------------------------


// lazy and lateinit -------------------------------
//Both are used to delay the property initializations in Kotlin `lateinit` is a modifier used with
//var and is used to set the value to the
//var at a later point. `lazy` is a method or rather say lambda expression.
//It's set on a val only. The val would be created at runtime when it's required.

val x: Int by lazy { 10 }
lateinit var y: String
// lazy and lateinit ends-------------------------------

// Diff between thread and coroutine -------------------------------------

//A thread is a unit of execution that can run independently from other threads.
//A coroutine is a light-weight thread that can be suspended and resumed.

// Diff between thread and coroutine end-------------------------------------

// suspend function-------------------------------------------------
//Suspend functions are functions that can be paused and resumed at a later time. This is useful
//for long-running tasks that might need to be interrupted, such as network requests.
//By default, suspend functions are executed on a background thread.
//When we call a suspend function from another suspend function, the first
//function will suspend execution until the second function completes.
// suspend function ends-------------------------------------------------

//MutableLive data and LiveData-----------------------------------------------------------
//MutableLiveData is just a class that extends the LiveData type class.
//MutableLiveData is commonly used since it provides
//the postValue(), setValue() methods publicly, something that LiveData class doesn’t provide.
//MutableLive data and LiveData ends---------------------------------------------------

// 4 Pillars od OOPS--------------------------------------------------
//Abstraction
//Encapsulation
//Inheritance
//Polymorphism
// 4 Pillars od OOPS ends--------------------------------------------------

fun callMe(greeting: (Int, String)-> Int){
    greeting(1, "1")
    var myLabda = {i:Int -> greeting(i, "1")}
}

//lazy and lateinit
//lateinit can only be used with a var property whereas lazy will always be used with val property.
//A lateinit property can be reinitialised again and again as per the use whereas
// the lazy property can only be initialised once.
//lateinit can't have custom getter or setter whereas lazy has custom getter
//lateinit properties can't be of primitive data types
// whereas lazy properties can be of primitive date types also.
//A lazy property can be of nullable type but a lateinit property can't be of nullable type.
//lazy and lateinit ends
