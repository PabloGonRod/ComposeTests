package com.pgonrod.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewContainer() {
    Column {
        AppToolbar()
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Content()
    }
}

@Composable
fun Content() {
    LazyColumn {
        item {
            View01()
        }
        item {
            View02()
        }
        item {
            View03()
        }
        item {
            View04()
        }
    }
}

@Composable
fun View04() {
        var counter4 by rememberSaveable {
            mutableStateOf(0)
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.background_card_04)
            ),
            modifier = Modifier.padding(16.dp, 12.dp)
        ) {
            ConstraintLayout {
                val (title, image, description, toolbar4, likes, likesIcon) = createRefs()

                Toolbar04(Modifier.constrainAs(toolbar4) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

                Image(painter = painterResource(id = R.drawable.view01),
                    contentDescription = stringResource(id = R.string.description_image),
                    modifier = Modifier.constrainAs(image) {
                        top.linkTo(toolbar4.bottom)
                        start.linkTo(title.start)
                        end.linkTo(title.end)
                    })

                Text(
                    text = stringResource(id = R.string.description_card),
                    modifier = Modifier
                        .constrainAs(description) {
                            top.linkTo(image.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(likesIcon.start)
                        },
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = stringResource(
                        id = R.string.description_like
                    ),
                    modifier = Modifier
                        .clickable { counter4++ }
                        .constrainAs(likesIcon) {
                            bottom.linkTo(description.bottom)
                            start.linkTo(description.end)
                            end.linkTo(image.end)
                        }
                )
                Text(text = counter4.toString(), modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .constrainAs(likes)
                    {
                        bottom.linkTo(likesIcon.bottom)
                        start.linkTo(likesIcon.end)
                    })
            }
        }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar04(modifier: Modifier) {
        val offset = Offset(5.0f, 10.0f)
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = colorResource(id = R.color.background_toolbar_04)
            ),
            modifier = modifier,
            title = {
                Text(
                    text = stringResource(id = R.string.title_toolbar_04),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 32.sp,
                        shadow = Shadow(
                            color = Color.White,
                            offset = offset,
                            blurRadius = 3f
                        )
                    )
                )
            }
        )
}

@Composable
fun View03() {
    var counter3 by rememberSaveable {
        mutableStateOf(0)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.background_card_03)
        ),
        modifier = Modifier.padding(16.dp, 12.dp)
    ) {
        ConstraintLayout {
            val (title, image, description, toolbar3, likes, likesIcon) = createRefs()

            Toolbar03(Modifier.constrainAs(toolbar3) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

            Image(painter = painterResource(id = R.drawable.view01),
                contentDescription = stringResource(id = R.string.description_image),
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(toolbar3.bottom)
                    start.linkTo(title.start)
                    end.linkTo(title.end)
                })

            Text(
                text = stringResource(id = R.string.description_card),
                modifier = Modifier
                    .constrainAs(description) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(likesIcon.start)
                    },
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = stringResource(
                    id = R.string.description_like
                ),
                modifier = Modifier
                    .clickable { counter3++ }
                    .constrainAs(likesIcon) {
                        bottom.linkTo(description.bottom)
                        start.linkTo(description.end)
                        end.linkTo(image.end)
                    }
            )
            Text(text = counter3.toString(), modifier = Modifier
                .padding(horizontal = 5.dp)
                .constrainAs(likes)
                {
                    bottom.linkTo(likesIcon.bottom)
                    start.linkTo(likesIcon.end)
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar03(modifier: Modifier) {
    val offset = Offset(5.0f, 10.0f)
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.background_toolbar_03)
        ),
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.title_toolbar_03),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 32.sp,
                    shadow = Shadow(
                        color = Color.White,
                        offset = offset,
                        blurRadius = 3f
                    )
                )
            )
        }
    )
}

@Composable
fun View02() {
    var counter2 by rememberSaveable {
        mutableStateOf(0)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.background_card_02)
        ),
        modifier = Modifier.padding(16.dp, 12.dp)
    ) {
        ConstraintLayout {
            val (title, image, description, toolbar2, likes, likesIcon) = createRefs()

            Toolbar02(Modifier.constrainAs(toolbar2) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

            Image(painter = painterResource(id = R.drawable.view01),
                contentDescription = stringResource(id = R.string.description_image),
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(toolbar2.bottom)
                    start.linkTo(title.start)
                    end.linkTo(title.end)
                })

            Text(
                text = stringResource(id = R.string.description_card),
                modifier = Modifier
                    .constrainAs(description) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(likesIcon.start)
                    },
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = stringResource(
                    id = R.string.description_like
                ),
                modifier = Modifier
                    .clickable { counter2++ }
                    .constrainAs(likesIcon) {
                        bottom.linkTo(description.bottom)
                        start.linkTo(description.end)
                        end.linkTo(image.end)
                    }
            )
            Text(text = counter2.toString(), modifier = Modifier
                .padding(horizontal = 5.dp)
                .constrainAs(likes)
                {
                    bottom.linkTo(likesIcon.bottom)
                    start.linkTo(likesIcon.end)
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar() {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = stringResource(id = R.string.title_maintoolbar),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar01(modifier: Modifier) {
    val offset = Offset(5.0f, 10.0f)
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.background_toolbar_01)
        ),
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.title_toolbar_01),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 32.sp,
                    shadow = Shadow(
                        color = Color.White,
                        offset = offset,
                        blurRadius = 3f
                    )
                )
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar02(modifier: Modifier) {
    val offset = Offset(5.0f, 10.0f)
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.background_toolbar_02)
        ),
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.title_toolbar_02),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 32.sp,
                    shadow = Shadow(
                        color = Color.White,
                        offset = offset,
                        blurRadius = 3f
                    )
                )
            )
        }
    )
}

@Composable
fun View01() {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.background_card_01)
        ),
        modifier = Modifier.padding(16.dp, 12.dp)
    ) {
        ConstraintLayout {
            val (title, image, description, toolbar1, likes, likesIcon) = createRefs()

            Toolbar01(Modifier.constrainAs(toolbar1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

            Image(painter = painterResource(id = R.drawable.view01),
                contentDescription = stringResource(id = R.string.description_image),
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(toolbar1.bottom)
                    start.linkTo(title.start)
                    end.linkTo(title.end)
                })

            Text(
                text = stringResource(id = R.string.description_card),
                modifier = Modifier
                    .constrainAs(description) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(likesIcon.start)
                    },
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = stringResource(
                    id = R.string.description_like
                ),
                modifier = Modifier
                    .clickable { counter++ }
                    .constrainAs(likesIcon) {
                        bottom.linkTo(description.bottom)
                        start.linkTo(description.end)
                        end.linkTo(image.end)
                    }
            )
            Text(text = counter.toString(), modifier = Modifier
                .padding(horizontal = 5.dp)
                .constrainAs(likes)
                {
                    bottom.linkTo(likesIcon.bottom)
                    start.linkTo(likesIcon.end)
                })
        }
    }

@Composable
fun View02Content() {
     var counter2 by rememberSaveable {
            mutableStateOf(0)
     }

     Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.background_card_02)
        ),
         modifier = Modifier.padding(16.dp, 12.dp)
        ) {
            ConstraintLayout {
                val (title, image, description, toolbar1, likes, likesIcon) = createRefs()

                Toolbar02(Modifier.constrainAs(toolbar1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

                Image(painter = painterResource(id = R.drawable.view01),
                    contentDescription = stringResource(id = R.string.description_image),
                    modifier = Modifier.constrainAs(image) {
                        top.linkTo(toolbar1.bottom)
                        start.linkTo(title.start)
                        end.linkTo(title.end)
                    })

                Text(
                    text = stringResource(id = R.string.description_card),
                    modifier = Modifier
                        .constrainAs(description) {
                            top.linkTo(image.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(likesIcon.start)
                        },
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = stringResource(
                        id = R.string.description_like
                    ),
                    modifier = Modifier
                        .clickable { counter2++ }
                        .constrainAs(likesIcon) {
                            bottom.linkTo(description.bottom)
                            start.linkTo(description.end)
                            end.linkTo(image.end)
                        }
                )
                Text(text = counter2.toString(), modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .constrainAs(likes)
                    {
                        bottom.linkTo(likesIcon.bottom)
                        start.linkTo(likesIcon.end)
                    })
            }
        }
    }
}




