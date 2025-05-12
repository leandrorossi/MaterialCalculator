package com.example.materialcalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CalculatorDisplay(
            expression = viewModel.expression,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp
                    )
                )
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(
                    vertical = 64.dp,
                    horizontal = 16.dp
                )
        )
        CalculatorButtonGrid(
            actions = calculatorActions,
            onAction = viewModel::onAction,
            modifier = Modifier.padding(8.dp)
        )
    }
}