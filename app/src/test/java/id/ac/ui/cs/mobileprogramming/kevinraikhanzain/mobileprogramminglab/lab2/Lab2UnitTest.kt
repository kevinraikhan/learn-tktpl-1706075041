package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.lab2

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Lab2UnitTest {
    private lateinit var activityObject: Lab2Activity
    private lateinit var  testValue:String

    @Before
    fun setUp() {
        activityObject = Lab2Activity()
        testValue = "10.0"
        println("Run this before each test")
    }



    @Test
    fun addition_function_isCorrect() {
        val result = activityObject.add("5", "5")

        Assert.assertEquals(testValue, result)
    }

    @Test
    fun subtraction_function_isCorrect() {
        val result = activityObject.subtract("20", "10")
        Assert.assertEquals(testValue, result)
    }

    @Test
    fun multiplication_function_isCorrect() {
        val result = activityObject.multiply("5", "2")
        Assert.assertEquals(testValue, result)
    }

    @Test
    fun division_function_isCorrect() {
        val result = activityObject.divide("100", "10")
        Assert.assertEquals(testValue, result)
    }
}