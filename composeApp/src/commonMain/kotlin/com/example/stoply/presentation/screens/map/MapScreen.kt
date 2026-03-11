package com.example.stoply.presentation.screens.map

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.rememberCameraState
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.style.BaseStyle
import org.maplibre.spatialk.geojson.Position

@Composable
fun MapScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    
    val bishkek = Position(longitude = 74.5698, latitude = 42.8747)
    
    val cameraState = rememberCameraState(
        firstPosition = CameraPosition(
            target = bishkek,
            zoom = 12.0
        )
    )

    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            MaplibreMap(
                modifier = Modifier.fillMaxSize(),
                baseStyle = BaseStyle.Uri("https://tiles.openfreemap.org/styles/bright"),
                cameraState = cameraState
            )

            // Кнопки управления масштабом
            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 80.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SmallFloatingActionButton(
                    onClick = {
                        scope.launch {
                            val currentPos = cameraState.position
                            cameraState.animateTo(currentPos.copy(zoom = currentPos.zoom + 1))
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    Text("+", style = MaterialTheme.typography.headlineSmall)
                }

                SmallFloatingActionButton(
                    onClick = {
                        scope.launch {
                            val currentPos = cameraState.position
                            cameraState.animateTo(currentPos.copy(zoom = currentPos.zoom - 1))
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    Text("-", style = MaterialTheme.typography.headlineSmall)
                }
            }
        }
    }
}
