package com.devdroid.architecturalpattern.viewmodel

class FindMaxViewModel {
    fun findMax(firstNumber: Int, secondNumber: Int, thirdNumber: Int): Int {
        return maxOf(firstNumber, secondNumber, thirdNumber)
    }
}