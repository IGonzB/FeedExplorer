package com.example.feedexplorer.presentation.view.detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feedexplorer.R
import com.example.feedexplorer.domain.model.Professional
import com.example.feedexplorer.domain.model.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfessionalDetailScreen(
    professionalId: String,
    viewModel: DetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    // The "Screen" handles the state and logic
    ProfessionalDetailContent(
        state = state,
        professionalId = professionalId,
        onBackClick = onBackClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfessionalDetailContent(
    state: Resource<Professional>,
    professionalId: String,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.details_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            when (val result = state) {
                is Resource.Loading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                is Resource.Error -> Text(result.message, Modifier.align(Alignment.Center))
                is Resource.Success -> DetailContent(result.data, professionalId)
            }
        }
    }
}

@Composable
fun DetailContent(item: Professional, professionalId: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "ID: $professionalId", style = MaterialTheme.typography.labelSmall)

        Text(
            text = item.displayName,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = item.specialty,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        HorizontalDivider()

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.Gray)
            Spacer(Modifier.width(8.dp))
            Text(text = item.fullLocation, style = MaterialTheme.typography.bodyLarge)
        }

        // Status indicator using AssistChip (Material 3)
        AssistChip(
            onClick = {},
            label = {
                Text(
                    if (item.isAvailable) "Accepting New Patients"
                    else "Not Accepting Patients"
                )
            },
            leadingIcon = {
                val color = if (item.isAvailable) Color.Green else Color.Red
                Canvas(modifier = Modifier.size(8.dp)) { drawCircle(color) }
            }
        )
    }
}