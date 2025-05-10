package com.example.materialcalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ExpressionWriterTest {

    private lateinit var write: ExpressionWriter

    @Before
    fun setup() {
        write = ExpressionWriter()
    }

    @Test
    fun `Initial parentheses parsed`() {
        write.processAction(CalculatorAction.Parentheses)
        write.processAction(CalculatorAction.Number(5))
        write.processAction(CalculatorAction.Op(Operation.ADD))
        write.processAction(CalculatorAction.Number(4))
        write.processAction(CalculatorAction.Parentheses)

        assertThat(write.expression).isEqualTo("(5+4)")
    }

    @Test
    fun `Closing parentheses at the start not parsed`() {
        write.processAction(CalculatorAction.Parentheses)
        write.processAction(CalculatorAction.Parentheses)

        assertThat(write.expression).isEqualTo("((")
    }

    @Test
    fun `Parentheses around a number are parsed`() {
        write.processAction(CalculatorAction.Parentheses)
        write.processAction(CalculatorAction.Number(5))
        write.processAction(CalculatorAction.Parentheses)

        assertThat(write.expression).isEqualTo("(5)")
    }
}