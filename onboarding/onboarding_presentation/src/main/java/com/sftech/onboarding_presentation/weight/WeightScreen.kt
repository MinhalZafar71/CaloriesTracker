package com.sftech.onboarding_presentation.weight

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sftech.core.R
import com.sftech.core.util.UiEvent
import com.sftech.core_ui.LocalSpacing
import com.sftech.onboarding_presentation.age.AgeViewModel
import com.sftech.onboarding_presentation.components.ActionButton
import com.sftech.onboarding_presentation.components.UnitTextField
import com.sftech.onboarding_presentation.height.HeightViewModel

@Composable
fun WeightScreen(
    viewModel: WeightViewModel = hiltViewModel(),
    onNavigate : (UiEvent.Navigate) -> Unit,
    snackBarHostState : SnackbarHostState
) {

    val context = LocalContext.current
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackBar ->  {
                    snackBarHostState.showSnackbar(message = event.message.asString(context))
                }
                else -> Unit

            }
        }

    }


    Box (
        modifier = Modifier.fillMaxSize().padding(spacing.spaceLarge)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(R.string.whats_your_weight),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.weight,
                onValueChange = viewModel::onWeightEnter,
                unit = stringResource(id = R.string.kg)
            )
        }
        ActionButton(
            text = stringResource(R.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )

    }

}