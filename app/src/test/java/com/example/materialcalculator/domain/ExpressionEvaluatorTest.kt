package com.example.materialcalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest {

    @Test
    fun `Simple expression is properly evaluated`() {
        val evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
            )
        )

        assertThat(evaluator.evaluate()).isEqualTo(4)
    }

    @Test
    fun `Expression with decimals properly evaluated`() {
        val evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.5),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(5.5),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(3.5),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(5.5),
                ExpressionPart.Op(Operation.DIVIDE),
                ExpressionPart.Number(3.5),
            )
        )

        assertThat(evaluator.evaluate()).isEqualTo(4.5)
    }

    @Test
    fun `Expression with parentheses properly evaluated`() {
        val evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Parentheses(ParenthesesType.Opening),
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(5.0),
                ExpressionPart.Parentheses(ParenthesesType.Closing),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(5.0)
            )
        )

        assertThat(evaluator.evaluate()).isEqualTo(-6.0)
    }

}