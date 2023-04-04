package br.com.vtvinicius.base_feature.extensions

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import br.com.vtvinicius.base_feature.dialogs.ErrorDialog
import br.com.vtvinicius.domain.exception.DataSourceException
import java.net.ConnectException
import java.net.UnknownHostException

// Componenteização do Scaffold para facilitar a tratativa de Erros vindos do Repositorio

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    drawerGesturesEnabled: Boolean = true,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerDefaults.Elevation,
    drawerBackgroundColor: Color = MaterialTheme.colors.surface,
    drawerContentColor: Color = contentColorFor(drawerBackgroundColor),
    drawerScrimColor: Color = DrawerDefaults.scrimColor,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable (PaddingValues) -> Unit,
    error: Throwable? = null,
) {

    var showError by remember {
        mutableStateOf(true)
    }

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        isFloatingActionButtonDocked = isFloatingActionButtonDocked,
        drawerContent = drawerContent,
        drawerGesturesEnabled = drawerGesturesEnabled,
        drawerShape = drawerShape,
        drawerElevation = drawerElevation,
        drawerBackgroundColor = drawerBackgroundColor,
        drawerContentColor = drawerContentColor,
        drawerScrimColor = drawerScrimColor,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        content = content,
    )
//
//    when (error) {
//        is DataSourceException -> {
//            ErrorDialog(
//                showError = showError,
//                error = "Ocorreu um erro ao processar os Dados",
//                onDismiss = {
//                    showError = false
//                }
//            )
//            println("br.com.vtvinicius.domain.exception.DataSourceException")
//        }
//        is ConnectException -> {
//            ErrorDialog(
//                showError = showError,
//                error = "Ocorreu um erro de conexão",
//                onDismiss = {
//                    showError = false
//
//                }
//            )
//            println("ConnectException")
//        }
//        is UnknownHostException -> {
//            ErrorDialog(
//                showError = showError,
//                error = "Ocorreu um erro de Internet",
//                onDismiss = {
//                    showError = false
//
//                }
//            )
//            println("UnknownHostException")
//        }
//        null -> {
//            println("Error null")
//            showError = true
//        }
//        else -> {
//            ErrorDialog(
//                showError = showError,
//                error = error?.message ?: "Ocorreu um erro",
//                onDismiss = {
//                    showError = false
//                }
//            )
//            println("Erro Generico")
//        }
//    }
}
